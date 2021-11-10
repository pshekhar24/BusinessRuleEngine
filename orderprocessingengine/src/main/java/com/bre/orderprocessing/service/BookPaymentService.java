package com.bre.orderprocessing.service;

import com.bre.orderprocesing.exception.InvalidOrderException;
import com.bre.orderprocessing.model.Order;
import com.bre.orderprocessing.service.helper.CommissionPaymentHelperSerivce;
import com.bre.orderprocessing.service.helper.PackingSlipHelperService;
import com.bre.orderprocessing.validator.OrderValidator;

public class BookPaymentService implements OrderPaymentService{
	
	private PackingSlipHelperService packingSlipHelperService;
	private CommissionPaymentHelperSerivce commissionPaymentHelperSerivce;

	@Override
	public Order processPayment(Order order) throws InvalidOrderException {
		OrderValidator.validateOrder(order);
		packingSlipHelperService.createDuplicatePackingSlip(order);
		commissionPaymentHelperSerivce.generateCommissionPaymentToAgent(order);
		return order;
	}

}
