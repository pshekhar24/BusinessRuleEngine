package com.bre.orderprocessing.handler;

import com.bre.orderprocessing.model.ProductType;
import com.bre.orderprocessing.service.OrderPaymentService;
import com.bre.orderprocessing.service.PhysicalProductPaymentService;

public class OrderPaymentHandler {
	
	public OrderPaymentService getPaymentHandlerService(ProductType productType) {
		if (productType != null) {
			if ((ProductType.PHYSICAL_PRODCUT).equals(productType)) {
				return new PhysicalProductPaymentService();
			}
		} 
		return null;
	}
}
