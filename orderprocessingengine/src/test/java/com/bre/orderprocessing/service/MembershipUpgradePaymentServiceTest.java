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
import com.bre.orderprocesing.exception.MembershipNotFoundException;
import com.bre.orderprocessing.model.Order;
import com.bre.orderprocessing.model.ProductType;
import com.bre.orderprocessing.model.UserMembership;
import com.bre.orderprocessing.service.helper.MembershipHelperService;
import com.bre.orderprocessing.service.helper.NotificationHelperSerivce;

@ExtendWith(MockitoExtension.class)
class MembershipUpgradePaymentServiceTest {

	@InjectMocks
	MembershipUpgradePaymentService membershipUpgradePaymentService;

	@Mock
	MembershipHelperService membershipHelperService;

	@Mock
	NotificationHelperSerivce notificationHelperSerivce;

	Order order;

	@BeforeEach
	void setUp() {
		order = new Order(1, new UserMembership(1), ProductType.MEMBERSHIP_UPGRADE);
	}

	@Test
	void testOrderNullForMembership() throws MembershipNotFoundException {
		try {
			membershipUpgradePaymentService.processPayment(null);
		} catch (InvalidOrderException e) {
			assertEquals("Order cannot be null", e.getMessage());
		}

	}
	
	
	@Test
	void testOrderPaymentForMembership() throws InvalidOrderException, MembershipNotFoundException {
		// when
		when(membershipHelperService.upgradeMembership(order)).thenReturn(order);
		when(notificationHelperSerivce.sendEmailNotification(order)).thenReturn(order);

		// Given
		membershipUpgradePaymentService.processPayment(order);

		// then
		verify(membershipHelperService).upgradeMembership(order);
		verify(notificationHelperSerivce).sendEmailNotification(order);
	}
	
	@Test
	void testMembershipIdExistsForMembership() throws InvalidOrderException {
		try {
			order.setMembership(null);
			membershipUpgradePaymentService.processPayment(order);
		} catch (MembershipNotFoundException e) {
			assertEquals("No existing membership avaibale for upgrade", e.getMessage());
		}

	}


}
