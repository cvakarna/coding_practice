<%@ page session="false"%>
<%@ page import="java.io.*"%>
<%@ page import="java.net.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.xml.parsers.*"%>
<%@ page import="org.xml.sax.*"%>
<%@ page import="com.bizruntime.*" %>
<%
	long stime = System.currentTimeMillis();
%>
<html>
<head>

</head>
<body>

	<H3>Clemens-Altman Musical Instruments</H3>

	<table BORDER="1" CELLPADDING="3" CELLSPACING="0">
		<tr>
			<TH>Product Code</TH>
			<TH>Description</TH>
			<TH>Price</TH>
		</tr>
		<%
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();

			StringBuffer requestURL = HttpUtils.getRequestURL(request);
			URL jspURL = new URL(requestURL.toString());
			URL url = new URL(jspURL, "instruments.xml");
			InputSource is = new InputSource(url.openStream());

			parser.parse(is, new ProductParser(out));
		%>
	</table>
	<p>
		<%
			long etime = System.currentTimeMillis();
			double elapsed = (etime - stime) / 1000.0;
		%>
		<EM>Elapsed time: <%=elapsed%> seconds
		</EM>
	</p>
</body>
</html>
