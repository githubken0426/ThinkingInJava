package resourceCode.lang;

import resourceCode.util.IteratorMe;

/**
 * jdk 1.6.0_13
 * 
 * @author ken
 * @param <E>
 * 2017-4-1 ионГ09:07:56
 */
public interface IterableMe<T> {
	/**
     * Returns an iterator over a set of elements of type T.
     * 
     * @return an Iterator.
     */
	public IteratorMe<T> iterator();
}
