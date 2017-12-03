package wtp;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import wtp.ConverterStub.CelsiusToFarenheit;

public class Test {
public static void main(String[] args) throws RemoteException {
	
	ConverterStub stub=new ConverterStub();
	ConverterStub.CelsiusToFarenheit ce=new ConverterStub.CelsiusToFarenheit();
	ce.setCelsius(10);
	
	ConverterStub.CelsiusToFarenheitResponse res=stub.celsiusToFarenheit(ce);
	System.out.println(res.get_return());
}
}
