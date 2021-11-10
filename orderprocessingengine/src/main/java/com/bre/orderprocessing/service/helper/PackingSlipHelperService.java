package com.bre.orderprocessing.service.helper;

import com.bre.orderprocessing.model.Order;
import com.bre.orderprocessing.model.OrderEventLog;

public class PackingSlipHelperService {
	
	public Order generatePackingSlip(Order order) {
		order.addOrderEventLog(new OrderEventLog("Generated packing slip"));
		return order;
	}
	
	public Order createDuplicatePackingSlip(Order order) {
		order.addOrderEventLog(new OrderEventLog("Created duplicate packing slip for the royalty department"));
		return order;
	}

}
