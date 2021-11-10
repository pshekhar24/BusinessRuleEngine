package com.bre.orderprocessing.model;

import java.util.Objects;

public class OrderEventLog {
	
	private String eventLog;

	public OrderEventLog(String eventLog) {
		this.eventLog = eventLog;
	}

	public String getEventLog() {
		return eventLog;
	}

	public void setEventLog(String eventLog) {
		this.eventLog = eventLog;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eventLog);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderEventLog other = (OrderEventLog) obj;
		return Objects.equals(eventLog, other.eventLog);
	}

}
