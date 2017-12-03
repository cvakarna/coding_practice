/*
	Milyn - Copyright (C) 2006 - 2010

	This library is free software; you can redistribute it and/or
	modify it under the terms of the GNU Lesser General Public
	License (version 2.1) as published by the Free Software
	Foundation.

	This library is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

	See the GNU Lesser General Public License for more details:
	http://www.gnu.org/licenses/lgpl.txt
*/
package com.smooks.model;

import java.util.ArrayList;

import java.util.List;

public class Order {
	 private Header header=new Header();
    private List<OrderItem> orderItems;
    public Order() {
   	orderItems=new ArrayList();
   	orderItems.add(new OrderItem());
   	orderItems.add(new OrderItem());
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

    public String toString() {
        StringBuffer desc = new StringBuffer();

        desc.append("Order Header: \n");
       desc.append(header);
        desc.append("Order Items: \n");
        for(int i = 0; i < orderItems.size(); i++) {
            desc.append("\t" + "(" + i +  "): " + orderItems.get(i)).append("\n");
        }
        return desc.toString();
    }
}
