package om.mathutility.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://test.mathutility.om/", portName = "MathUtilityPort", serviceName = "MathUtilityService")
public class MathUtility {

    @WebMethod(operationName = "addIntegers", action = "urn:AddIntegers")
	@RequestWrapper(className = "om.mathutility.test.jaxws.AddIntegers", localName = "addIntegers", targetNamespace = "http://test.mathutility.om/")
	@ResponseWrapper(className = "om.mathutility.test.jaxws.AddIntegersResponse", localName = "addIntegersResponse", targetNamespace = "http://test.mathutility.om/")
	public int addIntegers(@WebParam(name = "arg0") int firstNum, @WebParam(name = "arg1") int secondNum) {
        return firstNum + secondNum;
    }    

    @WebMethod(operationName = "factorial", action = "urn:Factorial")
	@RequestWrapper(className = "om.mathutility.test.jaxws.Factorial", localName = "factorial", targetNamespace = "http://test.mathutility.om/")
	@ResponseWrapper(className = "om.mathutility.test.jaxws.FactorialResponse", localName = "factorialResponse", targetNamespace = "http://test.mathutility.om/")
	public int factorial(@WebParam(name = "arg0") int n) {
        int result = 1;        
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }        
        return result;
    }
}
