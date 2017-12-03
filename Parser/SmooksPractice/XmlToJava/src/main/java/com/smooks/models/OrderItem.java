package com.smooks.models;

public class OrderItem {
	 private long productId;
	    private Integer quantity;
	    private double price;
	    private int orderId;
	    public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public long getProductId() {
	        return productId;
	    }

	    public void setProductId(long productId) {
	        this.productId = productId;
	    }

	    public Integer getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(Integer quantity) {
	        this.quantity = quantity;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }
	    
	    public String toString()
	    {
	    	return "OrderItem [productId:" + productId + ", quantity:" + quantity + ", price:" + price + "]";
	    }
}
