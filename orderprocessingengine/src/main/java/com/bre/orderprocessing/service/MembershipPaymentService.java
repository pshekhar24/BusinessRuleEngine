package com.bre.orderprocessing.service;

import com.bre.orderprocesing.exception.InvalidOrderException;
import com.bre.orderprocesing.exception.MembershipAlreadyExistsException;
import com.bre.orderprocessing.model.Order;
import com.bre.orderprocessing.service.helper.MembershipHelperService;
import com.bre.orderprocessing.service.helper.NotificationHelperSerivce;
import com.bre.orderprocessing.validator.MembershipValidator;
import com.bre.orderprocessing.validator.OrderValidator;

public class MembershipPaymentService implements OrderPaymentService {
	
	private MembershipHelperService membershipHelperService;
	private NotificationHelperSerivce notificationHelperSerivce;

	@Override
	public Order processPayment(Order order) throws InvalidOrderException, MembershipAlreadyExistsException {
		OrderValidator.validateOrder(order);
		MembershipValidator.validateIfMembershipExists(order);
		membershipHelperService.activateMembership(order);
		notificationHelperSerivce.sendEmailNotification(order);
		return order;
	}
	
}
