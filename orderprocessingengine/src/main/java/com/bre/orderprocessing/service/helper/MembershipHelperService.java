package com.bre.orderprocessing.service.helper;

import com.bre.orderprocessing.model.Order;
import com.bre.orderprocessing.model.OrderEventLog;

public class MembershipHelperService {
	
	public Order activateMembership(Order order) {
		order.getOrderEventLogs().add(new OrderEventLog("Membership activated"));
		return order;
	}

	public Order upgradeMembership(Order order) {
		order.getOrderEventLogs().add(new OrderEventLog("Upgraded Membership"));
		return order;
	}
	
}
