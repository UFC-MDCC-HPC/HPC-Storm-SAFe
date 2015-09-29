package br.ufc.mdcc.pargo.safe.port.event;

import br.ufc.mdcc.pargo.safe.port.HShelfPort;

public class HShelfConnectionEvent {

	private HShelfEventType eventType;
	private HShelfPort port;

	public HShelfConnectionEvent(HShelfEventType eventType) {
		this.eventType = eventType;
	}

	public HShelfConnectionEvent(HShelfEventType eventType, HShelfPort port) {
		this.eventType = eventType;
		this.port = port;
	}

	public HShelfEventType getEventType() {
		return eventType;
	}

	public void setEventType(HShelfEventType eventType) {
		this.eventType = eventType;
	}

	public HShelfPort getPort() {
		return port;
	}

	public void setPort(HShelfPort port) {
		this.port = port;
	}

}
