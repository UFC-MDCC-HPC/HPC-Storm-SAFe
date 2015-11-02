package br.ufc.mdcc.pargo.safe.framework.application.biding;

public class HShelfApplicationBidingEvent {

	public static final Integer UNKNOWN = 0;
	public static final Integer REQUEST = 1;
	public static final Integer INCOMING_MSG = 2;
	
	private Integer eventType;
	private Object value;
	
	public HShelfApplicationBidingEvent() {
	}
	
	public Integer getEventType() {
		return eventType;
	}
	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
}


