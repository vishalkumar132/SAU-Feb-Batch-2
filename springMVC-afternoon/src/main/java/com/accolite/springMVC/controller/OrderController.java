package com.accolite.springMVC.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.springMVC.model.Item;
import com.accolite.springMVC.service.OrderService;

@RestController
@RequestMapping("/order/")
public class OrderController {
	
	@Autowired
	OrderService service;
	
	@PostMapping("/create/{orderid}")
	public ResponseEntity<String> createOrder(@PathVariable("orderid") Integer orderId)
	{
		String res=service.CreateOrder(orderId);
		return ResponseEntity.ok(res);
	}
	@PostMapping("/item/add/{orderid}")
	public ResponseEntity<String> addItem(@PathVariable("orderid") Integer orderId,@RequestBody Item item)
	{
		String res=service.addItem(orderId, item);
		return ResponseEntity.ok(res);
	}
	@GetMapping("item/get/{orderid}")
	public ResponseEntity<Map<Integer, Item>> getItems(@PathVariable("orderid") Integer orderId)
	{
		Map<Integer, Item> res=service.getItem(orderId);
		return ResponseEntity.ok(res);
	}
	@DeleteMapping("/item/delete/{orderid}/{itemId}")
	public ResponseEntity<String> deleteItem(@PathVariable("orderid") Integer orderId,@PathVariable("itemId") Integer itemId)
	{

		String res = service.deleteItem(orderId, itemId);
        return ResponseEntity.ok(res);
	}
	@PutMapping("/item/update/{orderid}")
	public ResponseEntity<String> updateItem(@PathVariable("orderid") Integer orderId,@RequestBody Item item)
	{

		String res = service.updateItem(orderId,item);
        return ResponseEntity.ok(res);
	}
}
