package com.bre.orderprocessing.handler;

import com.bre.orderprocessing.model.ProductType;
import com.bre.orderprocessing.service.BookPaymentService;
import com.bre.orderprocessing.service.MembershipPaymentService;
import com.bre.orderprocessing.service.MembershipUpgradePaymentService;
import com.bre.orderprocessing.service.OrderPaymentService;
import com.bre.orderprocessing.service.PhysicalProductPaymentService;

public class OrderPaymentHandler {
	
	public OrderPaymentService getPaymentHandlerService(ProductType productType) {
		if (productType != null) {
			if ((ProductType.PHYSICAL_PRODCUT).equals(productType)) {
				return new PhysicalProductPaymentService();
			} else if ((ProductType.BOOK).equals(productType)) {
				return new BookPaymentService();
			} else if ((ProductType.MEMBERSHIP).equals(productType)) {
				return new MembershipPaymentService();
			} else if ((ProductType.MEMBERSHIP_UPGRADE).equals(productType)) {
				return new MembershipUpgradePaymentService();
			}  
		} 
		return null;
	}
}
