{
	"header" : {
		"order id" : ${order.header.orderId},
		"status code" : ${order.header.orderStatus},
     "customer details" : {
			"username" : ${order.header.customer.userName},
			"firstname" : ${order.header.customer.firstName},
			"lastname" : ${order.header.customer.lastName},
			"state" : ${order.header.customer.state}
		}
	},
	
	"order item" : [
	<#assign a=order.orderItems?size>
	
	<#list order.orderItems as c>
	
		<#if  c_has_next >
		{ 
		
			"quantity" : ${c.quantity},
			"product id" : "${c.productId}",
			"title" : "${c.price}",
			"price" : "${c.title}"
		},
		<#else>
			{ 
				"quantity" : ${c.quantity},
				"product id" : "${c.productId}",
				"title" : "${c.price}",
				"price" : "${c.title}"
			}
		</#if>
	</#list>
	]
}