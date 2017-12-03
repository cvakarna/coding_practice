/**
 * Converter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wtp;

public interface Converter extends javax.xml.rpc.Service {
    public java.lang.String getConverterHttpSoap11EndpointAddress();

    public wtp.ConverterPortType getConverterHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException;

    public wtp.ConverterPortType getConverterHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
