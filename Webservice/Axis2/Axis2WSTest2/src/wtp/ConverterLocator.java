/**
 * ConverterLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wtp;

public class ConverterLocator extends org.apache.axis.client.Service implements wtp.Converter {

    public ConverterLocator() {
    }


    public ConverterLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ConverterLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ConverterHttpSoap11Endpoint
    private java.lang.String ConverterHttpSoap11Endpoint_address = "http://localhost:8080/Axis2WSTest/services/Converter.ConverterHttpSoap11Endpoint/";

    public java.lang.String getConverterHttpSoap11EndpointAddress() {
        return ConverterHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ConverterHttpSoap11EndpointWSDDServiceName = "ConverterHttpSoap11Endpoint";

    public java.lang.String getConverterHttpSoap11EndpointWSDDServiceName() {
        return ConverterHttpSoap11EndpointWSDDServiceName;
    }

    public void setConverterHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        ConverterHttpSoap11EndpointWSDDServiceName = name;
    }

    public wtp.ConverterPortType getConverterHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ConverterHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getConverterHttpSoap11Endpoint(endpoint);
    }

    public wtp.ConverterPortType getConverterHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            wtp.ConverterSoap11BindingStub _stub = new wtp.ConverterSoap11BindingStub(portAddress, this);
            _stub.setPortName(getConverterHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setConverterHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        ConverterHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (wtp.ConverterPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                wtp.ConverterSoap11BindingStub _stub = new wtp.ConverterSoap11BindingStub(new java.net.URL(ConverterHttpSoap11Endpoint_address), this);
                _stub.setPortName(getConverterHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ConverterHttpSoap11Endpoint".equals(inputPortName)) {
            return getConverterHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wtp", "Converter");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wtp", "ConverterHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ConverterHttpSoap11Endpoint".equals(portName)) {
            setConverterHttpSoap11EndpointEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
