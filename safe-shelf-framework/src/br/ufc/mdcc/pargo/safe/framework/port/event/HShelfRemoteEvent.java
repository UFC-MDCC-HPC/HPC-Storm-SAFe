package br.ufc.mdcc.pargo.safe.framework.port.event;

public class HShelfRemoteEvent {

	private HShelfEventType eventType;
	private Object value;

	public HShelfRemoteEvent(HShelfEventType eventType, Object value) {
		this.eventType = eventType;
		this.value = value;
	}
	
	public HShelfEventType getEventType() {
		return eventType;
	}
	public void setEventType(HShelfEventType eventType) {
		this.eventType = eventType;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}

