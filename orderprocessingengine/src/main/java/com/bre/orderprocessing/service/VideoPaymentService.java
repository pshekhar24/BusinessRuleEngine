package com.bre.orderprocessing.service;

import com.bre.orderprocesing.exception.InvalidOrderException;
import com.bre.orderprocessing.model.Order;
import com.bre.orderprocessing.service.helper.PackingSlipHelperService;
import com.bre.orderprocessing.service.helper.VideoPaymentHelperSerivce;
import com.bre.orderprocessing.validator.OrderValidator;

public class VideoPaymentService implements OrderPaymentService {
	
	private PackingSlipHelperService packingSlipHelperService;
	private VideoPaymentHelperSerivce videoPaymentHelperSerivce;
	private final static String LEARNING_TO_SKI = "Learning to Ski";
	
	@Override
	public Order processPayment(Order order) throws InvalidOrderException {
		OrderValidator.validateOrder(order);
		packingSlipHelperService.generatePackingSlip(order);
		if (order.getProductName() != null && LEARNING_TO_SKI.equals(order.getProductName())) {
			videoPaymentHelperSerivce.addFreeFirstAidVideo(order);
		}
		return order;
	}

}
