/**
 * ConverterSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package wtp;

import java.rmi.RemoteException;

/**
 * ConverterSkeleton java skeleton for the axisService
 */
public class ConverterSkeleton {

	/**
	 * Auto generated method signature
	 * 
	 * @param farenheitToCelsius
	 * @return farenheitToCelsiusResponse
	 * @throws RemoteException 
	 */

	public wtp.FarenheitToCelsiusResponse farenheitToCelsius(
			wtp.FarenheitToCelsius farenheitToCelsius) throws RemoteException {
				
		wtp.FarenheitToCelsiusResponse response=new wtp.FarenheitToCelsiusResponse();
		ConverterSoap11BindingStub stub=new ConverterSoap11BindingStub();
		float cel=stub.farenheitToCelsius(farenheitToCelsius.getFarenheit());
		System.out.println(cel);
		
		response.set_return(cel);
		
		return response;
	}

	/**
	 * Auto generated method signature
	 * 
	 * `@param celsiusToFarenheit
	 * 
	 * @return celsiusToFarenheitResponse
	 * @throws RemoteException 
	 */

	public wtp.CelsiusToFarenheitResponse celsiusToFarenheit(
			wtp.CelsiusToFarenheit celsiusToFarenheit) throws RemoteException {
		
		wtp.CelsiusToFarenheitResponse response=new wtp.CelsiusToFarenheitResponse();
		ConverterSoap11BindingStub stub=new ConverterSoap11BindingStub();
		
		float fa=stub.celsiusToFarenheit(celsiusToFarenheit.getCelsius());
		System.out.println(fa);
		response.set_return(fa);
		return response;
		
	}

}
