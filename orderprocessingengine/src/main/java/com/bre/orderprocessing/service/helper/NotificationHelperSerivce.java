package com.bre.orderprocessing.service.helper;

import com.bre.orderprocessing.model.Order;
import com.bre.orderprocessing.model.OrderEventLog;

public class NotificationHelperSerivce {
	
	public Order sendEmailNotification(Order order) {
		order.getOrderEventLogs().add(new OrderEventLog("Sent Email notification to Owner"));
		return order;
	}
	
}
