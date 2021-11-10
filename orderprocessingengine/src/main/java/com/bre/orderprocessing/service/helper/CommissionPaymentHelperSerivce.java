package com.bre.orderprocessing.service.helper;

import com.bre.orderprocessing.model.Order;
import com.bre.orderprocessing.model.OrderEventLog;

public class CommissionPaymentHelperSerivce {
	public Order generateCommissionPaymentToAgent(Order order) {
		order.getOrderEventLogs().add(new OrderEventLog("Generated commission payment to agent"));
		return order;
	}
	
}
