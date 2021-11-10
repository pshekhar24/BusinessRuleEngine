package com.bre.orderprocessing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bre.orderprocesing.exception.InvalidOrderException;
import com.bre.orderprocesing.exception.MembershipAlreadyExistsException;
import com.bre.orderprocessing.model.Order;
import com.bre.orderprocessing.model.ProductType;
import com.bre.orderprocessing.model.UserMembership;
import com.bre.orderprocessing.service.helper.MembershipHelperService;
import com.bre.orderprocessing.service.helper.NotificationHelperSerivce;

@ExtendWith(MockitoExtension.class)
class MembershipPaymentServiceTest {

	@InjectMocks
	MembershipPaymentService membershipPaymentService;

	@Mock
	MembershipHelperService membershipHelperService;

	@Mock
	NotificationHelperSerivce notificationHelperSerivce;

	Order order;

	@BeforeEach
	void setUp() {
		order = new Order(1, new UserMembership(1), ProductType.BOOK);
	}

	@Test
	void testOrderNullForMembership() throws MembershipAlreadyExistsException {
		try {
			membershipPaymentService.processPayment(null);
		} catch (InvalidOrderException e) {
			assertEquals("Order cannot be null", e.getMessage());
		}

	}
	
	@Test
	void testMembershipIdExistsForMembership() throws InvalidOrderException {
		try {
			membershipPaymentService.processPayment(order);
		} catch (MembershipAlreadyExistsException e) {
			assertEquals("Membership already exists", e.getMessage());
		}

	}

	@Test
	void testOrderPaymentForMembership() throws InvalidOrderException, MembershipAlreadyExistsException {
		// when
		order.setMembership(null);
		when(membershipHelperService.activateMembership(order)).thenReturn(order);
		when(notificationHelperSerivce.sendEmailNotification(order)).thenReturn(order);

		// Given
		membershipPaymentService.processPayment(order);

		// then
		verify(membershipHelperService).activateMembership(order);
		verify(notificationHelperSerivce).sendEmailNotification(order);
	}
	

}
