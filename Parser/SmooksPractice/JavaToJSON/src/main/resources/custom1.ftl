{
	"header" : {
		"order id" : ${order.header.orderId},
		"status code" :${order.header.orderStatus},
		"net amount" : ${order.header.netAmount},
		"total amount" : ${order.header.totalAmount},
		"tax" : ${order.header.tax},
		"date&time" : ${order.header.date},
		"customer details" : {
			"username" : ${order.header.customer.userName},
			"firstname" : ${order.header.customer.firstName},
			"lastname" : ${order.header.customer.lastName},
			"state" : ${order.header.customer.state}
		}
	},
	"order item" : [
		{
			"quantity" : ${order.orderItems.quantity},
			"product id" :  ${order.orderItems.productId},
			"title" : ${order.orderItems.price},
			"price" : ${order.orderItems.price.title}
		},

	]
}