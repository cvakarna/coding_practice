
/**
 * ConverterMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package wtp;

        /**
        *  ConverterMessageReceiverInOut message receiver
        */

        public class ConverterMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        ConverterSkeleton skel = (ConverterSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("farenheitToCelsius".equals(methodName)){
                
                wtp.FarenheitToCelsiusResponse farenheitToCelsiusResponse1 = null;
	                        wtp.FarenheitToCelsius wrappedParam =
                                                             (wtp.FarenheitToCelsius)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    wtp.FarenheitToCelsius.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               farenheitToCelsiusResponse1 =
                                                   
                                                   
                                                         skel.farenheitToCelsius(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), farenheitToCelsiusResponse1, false, new javax.xml.namespace.QName("http://wtp",
                                                    "farenheitToCelsius"));
                                    } else 

            if("celsiusToFarenheit".equals(methodName)){
                
                wtp.CelsiusToFarenheitResponse celsiusToFarenheitResponse3 = null;
	                        wtp.CelsiusToFarenheit wrappedParam =
                                                             (wtp.CelsiusToFarenheit)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    wtp.CelsiusToFarenheit.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               celsiusToFarenheitResponse3 =
                                                   
                                                   
                                                         skel.celsiusToFarenheit(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), celsiusToFarenheitResponse3, false, new javax.xml.namespace.QName("http://wtp",
                                                    "celsiusToFarenheit"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(wtp.FarenheitToCelsius param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(wtp.FarenheitToCelsius.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(wtp.FarenheitToCelsiusResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(wtp.FarenheitToCelsiusResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(wtp.CelsiusToFarenheit param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(wtp.CelsiusToFarenheit.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(wtp.CelsiusToFarenheitResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(wtp.CelsiusToFarenheitResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, wtp.FarenheitToCelsiusResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(wtp.FarenheitToCelsiusResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private wtp.FarenheitToCelsiusResponse wrapfarenheitToCelsius(){
                                wtp.FarenheitToCelsiusResponse wrappedElement = new wtp.FarenheitToCelsiusResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, wtp.CelsiusToFarenheitResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(wtp.CelsiusToFarenheitResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private wtp.CelsiusToFarenheitResponse wrapcelsiusToFarenheit(){
                                wtp.CelsiusToFarenheitResponse wrappedElement = new wtp.CelsiusToFarenheitResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (wtp.FarenheitToCelsius.class.equals(type)){
                
                           return wtp.FarenheitToCelsius.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (wtp.FarenheitToCelsiusResponse.class.equals(type)){
                
                           return wtp.FarenheitToCelsiusResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (wtp.CelsiusToFarenheit.class.equals(type)){
                
                           return wtp.CelsiusToFarenheit.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (wtp.CelsiusToFarenheitResponse.class.equals(type)){
                
                           return wtp.CelsiusToFarenheitResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    