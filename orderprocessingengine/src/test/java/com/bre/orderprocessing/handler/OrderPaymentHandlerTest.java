package com.bre.orderprocessing.handler;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bre.orderprocessing.model.ProductType;
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

}