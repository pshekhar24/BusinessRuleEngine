package com.bre.orderprocessing.service.helper;

import com.bre.orderprocessing.model.Order;
import com.bre.orderprocessing.model.OrderEventLog;

public class VideoPaymentHelperSerivce {
	
	public Order addFreeFirstAidVideo(Order order) {
		order.getOrderEventLogs().add(new OrderEventLog("Added free video"));
		return order;
	}
	
}
