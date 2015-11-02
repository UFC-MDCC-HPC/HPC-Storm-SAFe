package br.ufc.mdcc.pargo.safe.framework.application.biding;

public class IHShelfApplicationBidingEvent {

	public static final Integer UNKNOWN = 0;
	public static final Integer REQUEST = 1;
	public static final Integer INCOMING_MSG = 2;
	
	private Integer eventType;
	private Object value;
	
	public IHShelfApplicationBidingEvent(Integer eventType, Object value) {
		this.eventType = eventType;
		this.value = value;
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


