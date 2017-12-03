package com.smooks.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private Header header;
    private List<OrderItem> orderItems;

    public Order() {
        header = new Header();
        orderItems =  new ArrayList<OrderItem>();
        orderItems.add(new OrderItem());        
        orderItems.add(new OrderItem());

        orderItems.get(0).setProductId(111);
        orderItems.get(0).setQuantity(2);
        orderItems.get(0).setPrice(10.99);

        orderItems.get(1).setProductId(222);
        orderItems.get(1).setQuantity(4);
        orderItems.get(1).setPrice(25.50);
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
