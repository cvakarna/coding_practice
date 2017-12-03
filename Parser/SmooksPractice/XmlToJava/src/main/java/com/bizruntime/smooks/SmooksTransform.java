package com.bizruntime.smooks;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.milyn.Smooks;
import org.milyn.SmooksException;
import org.milyn.container.ExecutionContext;
import org.milyn.io.StreamUtils;
import org.milyn.payload.JavaResult;
import org.xml.sax.SAXException;

import com.smooks.models.Order;
import com.smooks.models.OrderItem;


public class SmooksTransform {
   private static Logger LOGGER =Logger.getLogger("SmooksTransform");

   private static byte[] messageIn = readInputMessage();

   private static byte[] readInputMessage() {
       try {
           return StreamUtils.readStream(new FileInputStream("src/main/resources/input.xml"));
       } catch (IOException e) {
    	   LOGGER.error(e.getMessage());
    	   return "<no-message/>".getBytes();
       }
   }
   protected static Order runSmooks() throws IOException, SAXException, SmooksException {

       // Instantiate Smooks with the config...
       Smooks smooks = new Smooks("smooks-config.xml");

       try {
            // Create an exec context - no profiles....
           ExecutionContext  executionContext = smooks.createExecutionContext();
           // The result of this transform is a set of Java objects...
           JavaResult result = new JavaResult();
         
           smooks.filterSource(executionContext, new StreamSource(new ByteArrayInputStream(messageIn)), result);

           return (Order) result.getBean("order");
       } finally {
           smooks.close();
       }
   }


   
   public static void main(String[] args) throws SmooksException, IOException, SAXException {
	 
	   Order order = SmooksTransform.runSmooks();
	
	 LOGGER.debug("Header - Customer Name: " + order.getHeader().getCustomerName());
     LOGGER.debug("       - Customer Num:  " + order.getHeader().getCustomerNumber());
     LOGGER.debug("       - Order Date:    " + order.getHeader().getDate());
     LOGGER.debug("\n");
     LOGGER.debug("Order Items:");
	   for(int i = 0; i < order.getOrderItems().size(); i++) {
           OrderItem orderItem = order.getOrderItems().get(i);
         LOGGER.debug("       (" + (i + 1) + ") Product ID:  " + orderItem.getProductId());
         LOGGER.debug("       (" + (i + 1) + ") Quantity:    " + orderItem.getQuantity());
         LOGGER.debug("       (" + (i + 1) + ") Price:       " + orderItem.getPrice());
         LOGGER.debug("       (" + (i + 1) + ") OrderId:       " + orderItem.getOrderId());
       }
}
}
