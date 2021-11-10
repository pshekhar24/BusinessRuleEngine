package com.bre.orderprocessing.service;

import com.bre.orderprocessing.model.Order;

public interface OrderPaymentService {
	Order processPayment(Order order) throws Exception;
}
