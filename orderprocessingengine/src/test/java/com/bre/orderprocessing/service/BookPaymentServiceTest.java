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
import com.bre.orderprocessing.service.helper.CommissionPaymentHelperSerivce;
import com.bre.orderprocessing.service.helper.PackingSlipHelperService;

@ExtendWith(MockitoExtension.class)
class BookPaymentServiceTest {

	@InjectMocks
	BookPaymentService bookPaymentService;

	@Mock
	PackingSlipHelperService packingSlipHelperService;
	
	@Mock
	CommissionPaymentHelperSerivce commissionPaymentHelperSerivce;
	
	Order order;

	@BeforeEach
	void setUp() {
		order = new Order(1, new UserMembership(1), ProductType.BOOK);
	}

	@Test
	void testOrderNullForBook() {
		try {
			bookPaymentService.processPayment(null);
		} catch (InvalidOrderException e) {
			assertEquals("Order cannot be null", e.getMessage());
		}

	}

	@Test
	void testOrderPaymentForPhysicalProduct() throws InvalidOrderException {
		// when
		when(packingSlipHelperService.createDuplicatePackingSlip(order)).thenReturn(order);
		when(commissionPaymentHelperSerivce.generateCommissionPaymentToAgent(order)).thenReturn(order);

		// Given
		bookPaymentService.processPayment(order);

		// then
		verify(packingSlipHelperService).createDuplicatePackingSlip(order);
		verify(commissionPaymentHelperSerivce).generateCommissionPaymentToAgent(order);
	}

}
