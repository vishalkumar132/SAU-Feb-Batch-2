package com.accolite.springMVC.model;

import java.util.HashMap;
import java.util.Map;

public class Order {

	private Integer orderId;
	private Map<Integer,Item> items=new HashMap<Integer,Item>();
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Map<Integer, Item> getitems() {
		return items;
	}
	public void setitems(Map<Integer, Item> hm) {
		this.items = hm;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", items=" + items + "]";
	}
}
