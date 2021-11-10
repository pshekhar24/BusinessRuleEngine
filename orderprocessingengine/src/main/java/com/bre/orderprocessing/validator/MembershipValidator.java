package com.bre.orderprocessing.validator;

import com.bre.orderprocesing.exception.MembershipAlreadyExistsException;
import com.bre.orderprocessing.model.Order;

public class MembershipValidator {
	
	public static void validateIfMembershipExists(Order order) throws MembershipAlreadyExistsException {
		if (order.getMembership() != null) {
			throw new MembershipAlreadyExistsException("Membership already exists");
		}
	}
}
