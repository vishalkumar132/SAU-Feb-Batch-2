package com.accolite.springMVC.service;

import java.util.Map;

import com.accolite.springMVC.model.Item;

public interface  OrderService {

	public String CreateOrder(Integer orderId);
	public String addItem(Integer orderId,Item item);
	public Map<Integer, Item> getItem(Integer orderId);
	public String deleteItem(Integer orderId, Integer itemId);
	public String updateItem(Integer orderId,Item item);
}
