package resourceCode.util;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public abstract class AbstractListMe<E> extends AbstractCollectionMe<E>
		implements ListMe<E> {
	protected AbstractListMe() {}

	public boolean add(E e) {
		add(size(), e);
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IndexOutOfBoundsException
	 *             {@inheritDoc}
	 */
	abstract public E get(int index);

	/**
	 * {@inheritDoc}
	 * This implementation always throws an {@code
	 * UnsupportedOperationException}.
	 * 
	 * @throws UnsupportedOperationException
	 *             {@inheritDoc}
	 * @throws ClassCastException
	 *             {@inheritDoc}
	 * @throws NullPointerException
	 *             {@inheritDoc}
	 * @throws IllegalArgumentException
	 *             {@inheritDoc}
	 * @throws IndexOutOfBoundsException
	 *             {@inheritDoc}
	 */
	public E set(int index, E element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 * This implementation always throws an {@code
	 * UnsupportedOperationException}.
	 * 
	 * @throws UnsupportedOperationException
	 *             {@inheritDoc}
	 * @throws ClassCastException
	 *             {@inheritDoc}
	 * @throws NullPointerException
	 *             {@inheritDoc}
	 * @throws IllegalArgumentException
	 *             {@inheritDoc}
	 * @throws IndexOutOfBoundsException
	 *             {@inheritDoc}
	 */
	public void add(int index, E element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 * This implementation always throws an {@code
	 * UnsupportedOperationException}.
	 * 
	 * @throws UnsupportedOperationException
	 *             {@inheritDoc}
	 * @throws IndexOutOfBoundsException
	 *             {@inheritDoc}
	 */
	public E remove(int index) {
		throw new UnsupportedOperationException();
	}

	// Search Operations

	/**
	 * {@inheritDoc}
	 * This implementation first gets a list iterator (with {@code
	 * listIterator()}). Then, it iterates over the list until the specified
	 * element is found or the end of the list is reached.
	 * 
	 * @throws ClassCastException
	 *             {@inheritDoc}
	 * @throws NullPointerException
	 *             {@inheritDoc}
	 */
	public int indexOf(Object o) {
		ListIteratorMe<E> e = listIterator();
		if (o == null) {
			while (e.hasNext())
				if (e.next() == null)
					return e.previousIndex();
		} else {
			while (e.hasNext())
				if (o.equals(e.next()))
					return e.previousIndex();
		}
		return -1;
	}

	/**
	 * {@inheritDoc}
	 * This implementation first gets a list iterator that points to the end of
	 * the list (with {@code listIterator(size())}). Then, it iterates backwards
	 * over the list until the specified element is found, or the beginning of
	 * the list is reached.
	 * 
	 * @throws ClassCastException
	 *             {@inheritDoc}
	 * @throws NullPointerException
	 *             {@inheritDoc}
	 */
	public int lastIndexOf(Object o) {
		ListIteratorMe<E> e = listIterator(size());
		if (o == null) {
			while (e.hasPrevious())
				if (e.previous() == null)
					return e.nextIndex();
		} else {
			while (e.hasPrevious())
				if (o.equals(e.previous()))
					return e.nextIndex();
		}
		return -1;
	}

	// Bulk Operations

	/**
	 * Removes all of the elements from this list (optional operation). The list
	 * will be empty after this call returns.
	 * This implementation calls {@code removeRange(0, size())}.
	 * 
	 * Note that this implementation throws an {@code
	 * UnsupportedOperationException} unless {@code remove(int index)} or
	 * {@code removeRange(int fromIndex, int toIndex)} is overridden.
	 * 
	 * @throws UnsupportedOperationException
	 *             if the {@code clear} operation is not supported by this list
	 */
	public void clear() {
		removeRange(0, size());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * This implementation gets an iterator over the specified collection and
	 * iterates over it, inserting the elements obtained from the iterator into
	 * this list at the appropriate position, one at a time, using {@code
	 * add(int, E)}. Many implementations will override this method for
	 * efficiency.
	 * 
	 * Note that this implementation throws an {@code
	 * UnsupportedOperationException} unless {@link #add(int, Object) add(int,
	 * E)} is overridden.
	 * 
	 * @throws UnsupportedOperationException
	 *             {@inheritDoc}
	 * @throws ClassCastException
	 *             {@inheritDoc}
	 * @throws NullPointerException
	 *             {@inheritDoc}
	 * @throws IllegalArgumentException
	 *             {@inheritDoc}
	 * @throws IndexOutOfBoundsException
	 *             {@inheritDoc}
	 */
	public boolean addAll(int index, CollectionMe<? extends E> c) {
		boolean modified = false;
		IteratorMe<? extends E> e = c.iterator();
		while (e.hasNext()) {
			add(index++, e.next());
			modified = true;
		}
		return modified;
	}

	// Iterators

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * 
	 * This implementation returns a straightforward implementation of the
	 * iterator interface, relying on the backing list's {@code size()}, {@code
	 * get(int)}, and {@code remove(int)} methods.
	 * 
	 * Note that the iterator returned by this method will throw an {@code
	 * UnsupportedOperationException} in response to its {@code remove} method
	 * unless the list's {@code remove(int)} method is overridden.
	 * 
	 * This implementation can be made to throw runtime exceptions in the face
	 * of concurrent modification, as described in the specification for the
	 * (protected) {@code modCount} field.
	 * 
	 * @return an iterator over the elements in this list in proper sequence
	 * 
	 * @see #modCount
	 */
	public IteratorMe<E> iterator() {
		return new Itr();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * This implementation returns {@code listIterator(0)}.
	 * 
	 * @see #listIterator(int)
	 */
	public ListIteratorMe<E> listIterator() {
		return listIterator(0);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * This implementation returns a straightforward implementation of the
	 * {@code ListIterator} interface that extends the implementation of the
	 * {@code Iterator} interface returned by the {@code iterator()} method. The
	 * {@code ListIterator} implementation relies on the backing list's {@code
	 * get(int)}, {@code set(int, E)}, {@code add(int, E)} and {@code
	 * remove(int)} methods.
	 * 
	 * Note that the list iterator returned by this implementation will throw an
	 * {@code UnsupportedOperationException} in response to its {@code remove},
	 * {@code set} and {@code add} methods unless the list's {@code remove(int)}, {@code set(int, E)}, and {@code add(int, E)} methods are overridden.
	 * 
	 * This implementation can be made to throw runtime exceptions in the face
	 * of concurrent modification, as described in the specification for the
	 * (protected) {@code modCount} field.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             {@inheritDoc}
	 * 
	 * @see #modCount
	 */
	public ListIteratorMe<E> listIterator(final int index) {
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException("Index: " + index);

		return new ListItr(index);
	}

	private class Itr implements IteratorMe<E> {
		/**
		 * Index of element to be returned by subsequent call to next.
		 */
		int cursor = 0;

		/**
		 * Index of element returned by most recent call to next or previous.
		 * Reset to -1 if this element is deleted by a call to remove.
		 */
		int lastRet = -1;

		/**
		 * The modCount value that the iterator believes that the backing List
		 * should have. If this expectation is violated, the iterator has
		 * detected concurrent modification.
		 */
		int expectedModCount = modCount;

		public boolean hasNext() {
			return cursor != size();
		}

		public E next() {
			checkForComodification();
			try {
				E next = get(cursor);
				lastRet = cursor++;
				return next;
			} catch (IndexOutOfBoundsException e) {
				checkForComodification();
				throw new NoSuchElementException();
			}
		}

		public void remove() {
			if (lastRet == -1)
				throw new IllegalStateException();
			checkForComodification();

			try {
				AbstractListMe.this.remove(lastRet);
				if (lastRet < cursor)
					cursor--;
				lastRet = -1;
				expectedModCount = modCount;
			} catch (IndexOutOfBoundsException e) {
				throw new ConcurrentModificationException();
			}
		}

		final void checkForComodification() {
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();
		}
	}

	private class ListItr extends Itr implements ListIteratorMe<E> {
		ListItr(int index) {
			cursor = index;
		}

		public boolean hasPrevious() {
			return cursor != 0;
		}

		public E previous() {
			checkForComodification();
			try {
				int i = cursor - 1;
				E previous = get(i);
				lastRet = cursor = i;
				return previous;
			} catch (IndexOutOfBoundsException e) {
				checkForComodification();
				throw new NoSuchElementException();
			}
		}

		public int nextIndex() {
			return cursor;
		}

		public int previousIndex() {
			return cursor - 1;
		}

		public void set(E e) {
			if (lastRet == -1)
				throw new IllegalStateException();
			checkForComodification();

			try {
				AbstractListMe.this.set(lastRet, e);
				expectedModCount = modCount;
			} catch (IndexOutOfBoundsException ex) {
				throw new ConcurrentModificationException();
			}
		}

		public void add(E e) {
			checkForComodification();

			try {
				AbstractListMe.this.add(cursor++, e);
				lastRet = -1;
				expectedModCount = modCount;
			} catch (IndexOutOfBoundsException ex) {
				throw new ConcurrentModificationException();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * This implementation returns a list that subclasses {@code AbstractList}.
	 * The subclass stores, in private fields, the offset of the subList within
	 * the backing list, the size of the subList (which can change over its
	 * lifetime), and the expected {@code modCount} value of the backing list.
	 * There are two variants of the subclass, one of which implements {@code
	 * RandomAccess}. If this list implements {@code RandomAccess} the returned
	 * list will be an instance of the subclass that implements {@code
	 * RandomAccess}.
	 * 
	 * The subclass's {@code set(int, E)}, {@code get(int)}, {@code add(int, E)}, {@code remove(int)}, {@code addAll(int, Collection)} and {@code
	 * removeRange(int, int)} methods all delegate to the corresponding methods
	 * on the backing abstract list, after bounds-checking the index and
	 * adjusting for the offset. The {@code addAll(Collection c)} method merely
	 * returns {@code addAll(size, c)}.
	 * 
	 * The {@code listIterator(int)} method returns a "wrapper object" over a
	 * list iterator on the backing list, which is created with the
	 * corresponding method on the backing list. The {@code iterator} method
	 * merely returns {@code listIterator()}, and the {@code size} method merely
	 * returns the subclass's {@code size} field.
	 * 
	 * All methods first check to see if the actual {@code modCount} of the
	 * backing list is equal to its expected value, and throw a {@code
	 * ConcurrentModificationException} if it is not.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             endpoint index value out of range {@code (fromIndex < 0 ||
	 *             toIndex > size)}
	 * @throws IllegalArgumentException
	 *             if the endpoint indices are out of order {@code (fromIndex >
	 *             toIndex)}
	 */
	public ListMe<E> subList(int fromIndex, int toIndex) {
		return (this instanceof RandomAccess ? new RandomAccessSubList<E>(this,
				fromIndex, toIndex) : new SubList<E>(this, fromIndex, toIndex));
	}

	// Comparison and hashing
	/**
	 * Compares the specified object with this list for equality. Returns
	 * {@code true} if and only if the specified object is also a list, both
	 * lists have the same size, and all corresponding pairs of elements in the
	 * two lists are <i>equal</i>. (Two elements {@code e1} and {@code e2} are
	 * <i>equal</i> if {@code (e1==null ? e2==null : e1.equals(e2))}.) In other
	 * words, two lists are defined to be equal if they contain the same
	 * elements in the same order.
	 * 
	 * This implementation first checks if the specified object is this list. If
	 * so, it returns {@code true}; if not, it checks if the specified object is
	 * a list. If not, it returns {@code false}; if so, it iterates over both
	 * lists, comparing corresponding pairs of elements. If any comparison
	 * returns {@code false}, this method returns {@code false}. If either
	 * iterator runs out of elements before the other it returns {@code false}
	 * (as the lists are of unequal length); otherwise it returns {@code true}
	 * when the iterations complete.
	 * 
	 * @param o
	 *            the object to be compared for equality with this list
	 * @return {@code true} if the specified object is equal to this list
	 */
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof ListMe))
			return false;
		ListIteratorMe<E> e1 = listIterator();
		ListIteratorMe e2 = ((ListMe) o).listIterator();
		while (e1.hasNext() && e2.hasNext()) {
			E o1 = e1.next();
			Object o2 = e2.next();
			if (!(o1 == null ? o2 == null : o1.equals(o2)))
				return false;
		}
		return !(e1.hasNext() || e2.hasNext());
	}

	/**
	 * Returns the hash code value for this list.
	 * 
	 * This implementation uses exactly the code that is used to define the list
	 * hash function in the documentation for the {@link List#hashCode} method.
	 * 
	 * @return the hash code value for this list
	 */
	public int hashCode() {
		int hashCode = 1;
		IteratorMe<E> i = iterator();
		while (i.hasNext()) {
			E obj = i.next();
			hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
		}
		return hashCode;
	}

	/**
	 * Removes from this list all of the elements whose index is between {@code
	 * fromIndex}, inclusive, and {@code toIndex}, exclusive. Shifts any
	 * succeeding elements to the left (reduces their index). This call shortens
	 * the ArrayList by {@code (toIndex - fromIndex)} elements. (If {@code
	 * toIndex==fromIndex}, this operation has no effect.)
	 * 
	 * This method is called by the {@code clear} operation on this list and its
	 * subLists. Overriding this method to take advantage of the internals of
	 * the list implementation can <i>substantially</i> improve the performance
	 * of the {@code clear} operation on this list and its subLists.
	 * 
	 * This implementation gets a list iterator positioned before {@code
	 * fromIndex}, and repeatedly calls {@code ListIterator.next} followed by
	 * {@code ListIterator.remove} until the entire range has been removed.
	 * <b>Note: if {@code ListIterator.remove} requires linear time, this
	 * implementation requires quadratic time.</b>
	 * 
	 * @param fromIndex
	 *            index of first element to be removed
	 * @param toIndex
	 *            index after last element to be removed
	 */
	protected void removeRange(int fromIndex, int toIndex) {
		ListIteratorMe<E> it = listIterator(fromIndex);
		for (int i = 0, n = toIndex - fromIndex; i < n; i++) {
			it.next();
			it.remove();
		}
	}

	/**
	 * The number of times this list has been <i>structurally modified</i>.
	 * Structural modifications are those that change the size of the list, or
	 * otherwise perturb it in such a fashion that iterations in progress may
	 * yield incorrect results.
	 * 
	 * This field is used by the iterator and list iterator implementation
	 * returned by the {@code iterator} and {@code listIterator} methods. If the
	 * value of this field changes unexpectedly, the iterator (or list iterator)
	 * will throw a {@code ConcurrentModificationException} in response to the
	 * {@code next}, {@code remove}, {@code previous}, {@code set} or {@code
	 * add} operations. This provides <i>fail-fast</i> behavior, rather than
	 * non-deterministic behavior in the face of concurrent modification during
	 * iteration.
	 * 
	 * <b>Use of this field by subclasses is optional.</b> If a subclass wishes
	 * to provide fail-fast iterators (and list iterators), then it merely has
	 * to increment this field in its {@code add(int, E)} and {@code
	 * remove(int)} methods (and any other methods that it overrides that result
	 * in structural modifications to the list). A single call to {@code
	 * add(int, E)} or {@code remove(int)} must add no more than one to this
	 * field, or the iterators (and list iterators) will throw bogus {@code
	 * ConcurrentModificationExceptions}. If an implementation does not wish to
	 * provide fail-fast iterators, this field may be ignored.
	 */
	protected transient int modCount = 0;
}

class SubList<E> extends AbstractListMe<E> {
	private AbstractListMe<E> l;
	private int offset;
	private int size;
	private int expectedModCount;

	SubList(AbstractListMe<E> list, int fromIndex, int toIndex) {
		if (fromIndex < 0)
			throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
		if (toIndex > list.size())
			throw new IndexOutOfBoundsException("toIndex = " + toIndex);
		if (fromIndex > toIndex)
			throw new IllegalArgumentException("fromIndex(" + fromIndex
					+ ") > toIndex(" + toIndex + ")");
		l = list;
		offset = fromIndex;
		size = toIndex - fromIndex;
		expectedModCount = l.modCount;
	}

	public E set(int index, E element) {
		rangeCheck(index);
		checkForComodification();
		return l.set(index + offset, element);
	}

	public E get(int index) {
		rangeCheck(index);
		checkForComodification();
		return l.get(index + offset);
	}

	public int size() {
		checkForComodification();
		return size;
	}

	public void add(int index, E element) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		checkForComodification();
		l.add(index + offset, element);
		expectedModCount = l.modCount;
		size++;
		modCount++;
	}

	public E remove(int index) {
		rangeCheck(index);
		checkForComodification();
		E result = l.remove(index + offset);
		expectedModCount = l.modCount;
		size--;
		modCount++;
		return result;
	}

	protected void removeRange(int fromIndex, int toIndex) {
		checkForComodification();
		l.removeRange(fromIndex + offset, toIndex + offset);
		expectedModCount = l.modCount;
		size -= (toIndex - fromIndex);
		modCount++;
	}

	public boolean addAll(CollectionMe<? extends E> c) {
		return addAll(size, c);
	}

	public boolean addAll(int index, CollectionMe<? extends E> c) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
					+ size);
		int cSize = c.size();
		if (cSize == 0)
			return false;

		checkForComodification();
		l.addAll(offset + index, c);
		expectedModCount = l.modCount;
		size += cSize;
		modCount++;
		return true;
	}

	public IteratorMe<E> iterator() {
		return listIterator();
	}

	public ListIteratorMe<E> listIterator(final int index) {
		checkForComodification();
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
					+ size);

		return new ListIteratorMe<E>() {
			private ListIteratorMe<E> i = l.listIterator(index + offset);

			public boolean hasNext() {
				return nextIndex() < size;
			}

			public E next() {
				if (hasNext())
					return i.next();
				else
					throw new NoSuchElementException();
			}

			public boolean hasPrevious() {
				return previousIndex() >= 0;
			}

			public E previous() {
				if (hasPrevious())
					return i.previous();
				else
					throw new NoSuchElementException();
			}

			public int nextIndex() {
				return i.nextIndex() - offset;
			}

			public int previousIndex() {
				return i.previousIndex() - offset;
			}

			public void remove() {
				i.remove();
				expectedModCount = l.modCount;
				size--;
				modCount++;
			}

			public void set(E e) {
				i.set(e);
			}

			public void add(E e) {
				i.add(e);
				expectedModCount = l.modCount;
				size++;
				modCount++;
			}
		};
	}

	public ListMe<E> subList(int fromIndex, int toIndex) {
		return new SubList<E>(this, fromIndex, toIndex);
	}

	private void rangeCheck(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ",Size: "
					+ size);
	}

	private void checkForComodification() {
		if (l.modCount != expectedModCount)
			throw new ConcurrentModificationException();
	}
}

class RandomAccessSubList<E> extends SubList<E> implements RandomAccess {
	RandomAccessSubList(AbstractListMe<E> list, int fromIndex, int toIndex) {
		super(list, fromIndex, toIndex);
	}

	public ListMe<E> subList(int fromIndex, int toIndex) {
		return new RandomAccessSubList<E>(this, fromIndex, toIndex);
	}
}