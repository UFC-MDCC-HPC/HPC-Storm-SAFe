package br.ufc.mdcc.pargo.safe.application.component;

public class MontageParam {

	private String name;
	private String type;
	private String value;
	
	public static final String DIR_TYPE = "DIR_TYPE";
	public static final String FILE_TYPE = "FILE_TYPE";
	public static final String PARAM_TYPE = "PARAM_TYPE";
	
	public MontageParam(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof MontageParam))
			return false;
		MontageParam ref = (MontageParam)obj;
		if(!ref.getName().equals(this.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		String res = "[name: "+this.name+ ", type: "+this.type + ", value: "+this.value+"]";
		return res;
	}
}
