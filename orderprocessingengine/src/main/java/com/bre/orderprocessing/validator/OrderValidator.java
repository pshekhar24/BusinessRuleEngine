package com.bre.orderprocessing.validator;

import com.bre.orderprocesing.exception.InvalidOrderException;
import com.bre.orderprocessing.model.Order;

public class OrderValidator {
	
	public static void validateOrder(Order order) throws InvalidOrderException {
		if (order == null) {
			throw new InvalidOrderException("Order cannot be null");
		}
	}
}
