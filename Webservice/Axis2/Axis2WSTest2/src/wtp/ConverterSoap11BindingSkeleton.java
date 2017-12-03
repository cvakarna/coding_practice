/**
 * ConverterSoap11BindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wtp;

public class ConverterSoap11BindingSkeleton implements wtp.ConverterPortType, org.apache.axis.wsdl.Skeleton {
    private wtp.ConverterPortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wtp", "celsius"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"), java.lang.Float.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("celsiusToFarenheit", _params, new javax.xml.namespace.QName("http://wtp", "return"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wtp", "celsiusToFarenheit"));
        _oper.setSoapAction("urn:celsiusToFarenheit");
        _myOperationsList.add(_oper);
        if (_myOperations.get("celsiusToFarenheit") == null) {
            _myOperations.put("celsiusToFarenheit", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("celsiusToFarenheit")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wtp", "farenheit"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"), java.lang.Float.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("farenheitToCelsius", _params, new javax.xml.namespace.QName("http://wtp", "return"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wtp", "farenheitToCelsius"));
        _oper.setSoapAction("urn:farenheitToCelsius");
        _myOperationsList.add(_oper);
        if (_myOperations.get("farenheitToCelsius") == null) {
            _myOperations.put("farenheitToCelsius", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("farenheitToCelsius")).add(_oper);
    }

    public ConverterSoap11BindingSkeleton() {
        this.impl = new wtp.ConverterSoap11BindingImpl();
    }

    public ConverterSoap11BindingSkeleton(wtp.ConverterPortType impl) {
        this.impl = impl;
    }
    public java.lang.Float celsiusToFarenheit(java.lang.Float celsius) throws java.rmi.RemoteException
    {
        java.lang.Float ret = impl.celsiusToFarenheit(celsius);
        return ret;
    }

    public java.lang.Float farenheitToCelsius(java.lang.Float farenheit) throws java.rmi.RemoteException
    {
        java.lang.Float ret = impl.farenheitToCelsius(farenheit);
        return ret;
    }

}
