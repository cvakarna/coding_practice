package com.smooks.models;

public class Header {

	 private Long customerNumber = 1234L;
     private String customerName = "Buzz Lightyear";
	 
     public Long getCustomerNumber() {
         return customerNumber;
     }

     public void setCustomerNumber(Long customerNumber) {
         this.customerNumber = customerNumber;
     }

     public String getCustomerName() {
         return customerName;
     }

     public void setCustomerName(String customerName) {
         this.customerName = customerName;
     }
     
     public String toString()
     {
     	return "Header [customerName:" + customerName + ", customerNumber:" + customerNumber + "]";
     }    
}
