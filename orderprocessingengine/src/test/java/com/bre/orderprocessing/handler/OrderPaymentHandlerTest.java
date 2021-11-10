package com.bre.orderprocessing.handler;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bre.orderprocessing.model.ProductType;
import com.bre.orderprocessing.service.BookPaymentService;
import com.bre.orderprocessing.service.MembershipPaymentService;
import com.bre.orderprocessing.service.MembershipUpgradePaymentService;
import com.bre.orderprocessing.service.PhysicalProductPaymentService;

public class OrderPaymentHandlerTest {

	OrderPaymentHandler orderPaymentHandler;

	@BeforeEach
	void initAll() {
		orderPaymentHandler = new OrderPaymentHandler();
	}

	@Test
	void testWhenProductTypeIsNull() {
		assertNull(orderPaymentHandler.getPaymentHandlerService(null));
	}

	@Test
	void testWhenProductTypeIsForPhysicalProduct() {
		assertEquals(orderPaymentHandler.getPaymentHandlerService(ProductType.PHYSICAL_PRODCUT).getClass(),
				PhysicalProductPaymentService.class);
	}
	
	@Test
	void testWhenProductTypeIsForBook() {
		assertEquals(orderPaymentHandler.getPaymentHandlerService(ProductType.BOOK).getClass(),
				BookPaymentService.class);
	}
	
	@Test
	void testWhenProductTypeIsForMemberShip() {
		assertEquals(orderPaymentHandler.getPaymentHandlerService(ProductType.MEMBERSHIP).getClass(),
				MembershipPaymentService.class);
	}

	@Test
	void testWhenProductTypeIsForMemberShipUpgrade() {
		assertEquals(orderPaymentHandler.getPaymentHandlerService(ProductType.MEMBERSHIP_UPGRADE).getClass(),
				MembershipUpgradePaymentService.class);
	}

}