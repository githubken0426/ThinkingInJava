package th.part_12_exception.chapter_06._03Chain;

public class DynamicFields {
	
	private Object[][] fields;
	public DynamicFields(int initialsize) {
		fields = new Object[initialsize][2];
		for (int i = 0; i < fields.length; i++) {
			fields[i] = new Object[] { null, null };
		}
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Object[] objects : fields) {
			sb.append(objects[0]);
			sb.append("");
			sb.append(objects[1]);
			sb.append("\n");
		}
		return sb.toString();
	}

	private int hasField(String id) {
		for (int i = 0; i < fields.length; i++) {
			if (id.equals(fields[i][0])) {
				return i;
			}
		}
		return -1;
	}

	private int getFieldNumber(String id) throws NoSuchFieldException {
		int fieldNumber = hasField(id);
		if (fieldNumber == -1) {
			throw new NoSuchFieldException();
		}
		return fieldNumber;
	}

	private int makeField(String id) {
		for (int i = 0; i < fields.length; i++) {
			if (fields[i][0] == null) {
				fields[i][0] = id;
				return i;
			}
		}
		Object[][] temp = new Object[fields.length + 1][2];
		for (int i = 0; i < fields.length; i++) {
			temp[i] = fields[i];
		}

		for (int i = fields.length; i < temp.length; i++) {
			temp[i] = new Object[] { null, null };
		}
		fields = temp;

		return makeField(id);
	}

	public Object getField(String id) throws NoSuchFieldException {
		return fields[getFieldNumber(id)][1];
	}

	public Object setField(String id, Object value) throws DynamicFieldException {
		if (value == null) {
			DynamicFieldException df = new DynamicFieldException();
			df.initCause(new NullPointerException());
			throw df;
		}
		int fieldNumber = hasField(id);
		if (fieldNumber == -1) {
			fieldNumber = makeField(id);
		}
		Object result = null;
		try {
			result = getField(id);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		fields[fieldNumber][1] = value;
		return result;
	}
}
