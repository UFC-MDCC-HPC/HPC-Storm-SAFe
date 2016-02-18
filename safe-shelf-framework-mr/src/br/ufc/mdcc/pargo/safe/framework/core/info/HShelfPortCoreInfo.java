package br.ufc.mdcc.pargo.safe.framework.core.info;

public class HShelfPortCoreInfo {

	private String ID;
	private String name;
	private String URL;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	
	@Override
	public String toString() {
		return "name="+this.name+",id="+this.ID+",url="+this.URL;
	}
}
