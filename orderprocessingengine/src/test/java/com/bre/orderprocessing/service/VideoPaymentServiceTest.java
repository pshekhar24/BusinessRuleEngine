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
import com.bre.orderprocessing.model.Order;
import com.bre.orderprocessing.model.ProductType;
import com.bre.orderprocessing.model.UserMembership;
import com.bre.orderprocessing.service.helper.PackingSlipHelperService;
import com.bre.orderprocessing.service.helper.VideoPaymentHelperSerivce;

@ExtendWith(MockitoExtension.class)
class VideoPaymentServiceTest {

	@InjectMocks
	VideoPaymentService videoPaymentService;

	@Mock
	PackingSlipHelperService packingSlipHelperService;
	
	@Mock
	VideoPaymentHelperSerivce videoPaymentHelperSerivce;
	Order order;

	@BeforeEach
	void setUp() {
		order = new Order(1, new UserMembership(1), ProductType.PHYSICAL_PRODCUT);
		order.setProductName("Learning to Ski");
	}

	@Test
	void testOrderNullForPhysicalProduct() {
		try {
			videoPaymentService.processPayment(null);
		} catch (InvalidOrderException e) {
			assertEquals("Order cannot be null", e.getMessage());
		}

	}

	@Test
	void testOrderPaymentForPhysicalProduct() throws InvalidOrderException {
		// when
		when(packingSlipHelperService.generatePackingSlip(order)).thenReturn(order);
		when(videoPaymentHelperSerivce.addFreeFirstAidVideo(order)).thenReturn(order);

		// Given
		videoPaymentService.processPayment(order);

		// then
		verify(packingSlipHelperService).generatePackingSlip(order);
		verify(videoPaymentHelperSerivce).addFreeFirstAidVideo(order);
	}

}
