package com.bizruntime;

import java.io.IOException;
import java.text.NumberFormat;

import javax.management.AttributeList;
import javax.servlet.jsp.JspWriter;

import org.w3c.dom.Node;
import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;

public class Productparser extends HandlerBase {
		private Product product;
		private StringBuffer buffer;
		private JspWriter out;
		private NumberFormat fmt;
		public class Product {
			private String code;
			private String productType;
			private double price;
			private int onHand;
			private String manufacturer;
			private String description;

			/**
			 * Load the product data from a DOM element
			 */
			public void load(org.w3c.dom.Element element) {
				code = element.getAttribute("code");

				for (Node node = element.getFirstChild(); node != null; node = node
						.getNextSibling()) {
					// Select only element nodes
					if (node.getNodeType() != Node.ELEMENT_NODE)
						continue;
					String tagName = node.getNodeName();
					// product-type
					if (tagName.equals("product-type")) {
						String text = node.getFirstChild().getNodeValue();
						productType = text.trim();
					}
					// price
					else if (tagName.equals("price")) {
						String text = node.getFirstChild().getNodeValue();
						price = Double.parseDouble(text.trim());
					}

					// on-hand
					else if (tagName.equals("on-hand")) {
						String text = node.getFirstChild().getNodeValue();
						onHand = Integer.parseInt(text.trim());
					}
					// manufacturer
					else if (tagName.equals("manufacturer")) {
						String text = node.getFirstChild().getNodeValue();
						manufacturer = text.trim();
					}

					else if (tagName.equals("description")) {
						String text = node.getFirstChild().getNodeValue();
						description = text.trim();

					}
				}
			}

			public String getCode() {
				return code;
			}

			public void setCode(String code) {
				this.code = code;
			}

			public String getProductType() {
				return productType;
			}

			public void setProductType(String productType) {
				this.productType = productType;
			}

			public double getPrice() {
				return price;
			}

			public void setPrice(double price) {
				this.price = price;
			}

			public int getOnHand() {
				return onHand;
			}

			public void setOnHand(int onHand) {
				this.onHand = onHand;
			}

			public String getManufacturer() {
				return manufacturer;
			}

			public void setManufacturer(String manufacturer) {
				this.manufacturer = manufacturer;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}
		}

		public void ProductParser(JspWriter out) {
			this.out = out;
			buffer = new StringBuffer();
			fmt = NumberFormat.getCurrencyInstance();
		}

		/**
		 * Called when a start tag is encountered
		 */
		public void startElement(String name, AttributeList attrs)
				throws SAXException {
			if (name.equals("product")) {
				product = new Product();
				product.setCode(attrs.getValue("code"));
			}
			buffer = new StringBuffer();
		}

		/**
		 * Accumulates characters from text nodes
		 */
		public void characters(char[] ch, int start, int len)
				throws SAXException {
			buffer.append(ch, start, len);
		}

		/**
		 * Called when an end tag is encountered
		 */
		public void endElement(String name) throws SAXException {
			String text = buffer.toString().trim();
			if (name.equals("price"))
				product.setPrice(Double.parseDouble(text));
			else if (name.equals("manufacturer"))
				product.setManufacturer(text);
			else if (name.equals("description"))
				product.setDescription(text);
			else if (name.equals("product")) {
				if (product.getManufacturer().equals("Clemens-Altman")) {
					try {
						String[] lines = { "<TR>", "<TD>",
								product.getCode(), "</TD>", "<TD>",
								product.getDescription(), "</TD>",
								"<TD ALIGN='RIGHT'>",
								fmt.format(product.getPrice()),
								"</TD>", "</TR>", };
						for (int i = 0; i < lines.length; i++)
							out.println(lines[i]);
					} catch (IOException e) {
						throw new SAXException(e.getMessage());
					}
				}
			}
		}
	

}
