package com.accolite.springMVC.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.accolite.springMVC.model.Item;
import com.accolite.springMVC.model.Order;
import com.accolite.springMVC.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	Map<Integer,Order> mp=new HashMap<Integer,Order>();
	
	
	public boolean isOrderPresent(Integer orderId) {
		if(mp.containsKey(orderId))
			return true;
		return false;
	}
	@Override
	public String CreateOrder(Integer orderId) {
		Order order=new Order();
		order.setOrderId(orderId);
		mp.put(orderId, order);
		return "Order with order Id: "+order.getOrderId()+" sucessfully created";
		
	}

	@Override
	public String addItem(Integer orderId, Item item) {

		if(isOrderPresent(orderId))
		{
			
			mp.get(orderId).getitems().put(item.getItemId(), item);
			System.out.println(mp.get(orderId));
			return "Item  successfully added with orderId  "+orderId+" and with itemId: "+item.getItemId();
		}
		return "No Order created, first create and then add items";
	}
	@Override
	public Map<Integer, Item> getItem(Integer orderId) {
		return mp.get(orderId).getitems();

	}
	public boolean isItemPresent(Integer orderId,Integer itemId) {
		if(mp.get(orderId).getitems().containsKey(itemId))
			return true;
		return false;
	}
	@Override
	public String deleteItem(Integer orderId, Integer itemId) {
		if(!isOrderPresent(orderId))	return "order id not present";
		else if(!isItemPresent(orderId,itemId)) return "order present but item not present";
		mp.get(orderId).getitems().remove(itemId);
		return "item deleted successfully";
	}
	@Override
	public String updateItem(Integer orderId,Item item) {
		
		Integer itemId=item.getItemId();
		if(!isOrderPresent(orderId)) {
			return "No Order with order id:"+" "+orderId+" present";			
		}
		else if(!isItemPresent(orderId,itemId))
		{
			return "Order id present but Item id is not present";
		}
		mp.get(orderId).getitems().put(itemId,item);

		return "item updated successfully";
	}

}