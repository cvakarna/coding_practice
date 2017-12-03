package com.smooks.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private Header header;
    private List<OrderItem> orderItems;

    public Order() {
       
    }
    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    
    public String toString()
    {
    	return "Order [" + header + ", " + orderItems + "]";
    }
}
