package com.bre.orderprocessing.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private long orderId;

	private UserMembership membership;

	private ProductType productType;

	private List<OrderEventLog> orderEventLogs = new ArrayList<OrderEventLog>();

	public Order(long orderId, UserMembership membership, ProductType productType) {
		this.orderId = orderId;
		this.membership = membership;
		this.productType = productType;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public UserMembership getMembership() {
		return membership;
	}

	public void setMembership(UserMembership membership) {
		this.membership = membership;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public List<OrderEventLog> getOrderEventLogs() {
		return this.orderEventLogs;
	}

	public void addOrderEventLog(OrderEventLog orderEventLog) {
		this.getOrderEventLogs().add(orderEventLog);
	}
	
	public void setOrderEventLogs(List<OrderEventLog> orderEventLogs) {
		this.orderEventLogs = orderEventLogs;
	}

}
