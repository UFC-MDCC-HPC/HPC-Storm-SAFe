package br.ufc.mdcc.pargo.safe.framework.workflow;

public class HShelfArgValueType {

	public static final String INTEGER = "INTEGER";
	public static final String DOUBLE = "DOUBLE";
	public static final String STRING = "STRING";

	private Object value;
	private String type;

	public HShelfArgValueType(Object value, String type) {
		this.type = type;
		if (type.equalsIgnoreCase(INTEGER)) {
			this.value = Integer.parseInt(value.toString());
		} else if (type.equalsIgnoreCase(DOUBLE)) {
			this.value = Double.parseDouble(value.toString());
		}
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
