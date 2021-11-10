package com.bre.orderprocessing.service;

import com.bre.orderprocesing.exception.InvalidOrderException;
import com.bre.orderprocessing.model.Order;

public interface OrderPaymentService {
	Order processPayment(Order order) throws InvalidOrderException;
}
