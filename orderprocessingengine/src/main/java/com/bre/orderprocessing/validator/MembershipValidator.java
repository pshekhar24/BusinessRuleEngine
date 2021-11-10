package com.bre.orderprocessing.validator;

import com.bre.orderprocesing.exception.MembershipAlreadyExistsException;
import com.bre.orderprocesing.exception.MembershipNotFoundException;
import com.bre.orderprocessing.model.Order;

public class MembershipValidator {
	
	public static void validateIfMembershipExists(Order order) throws MembershipAlreadyExistsException {
		if (order.getMembership() != null) {
			throw new MembershipAlreadyExistsException("Membership already exists");
		}
	}
	
	public static void validateIfMembershipExistsForUpgrade(Order order) throws MembershipNotFoundException {
		if (order.getMembership() == null) {
			throw new MembershipNotFoundException("No existing membership avaibale for upgrade");
		}
	}
}
