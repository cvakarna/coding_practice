package wtp;

public class Tester {

	public static void main(String[] args) {
		
		CelsiusToFarenheit c2f=new CelsiusToFarenheit();
		FarenheitToCelsius f2c=new FarenheitToCelsius();
		
		c2f.setCelsius(10);
		
		f2c.setFarenheit((c2f.getCelsius() * 9 / 5) + 32);
		System.out.println(f2c.getFarenheit());
		
		c2f.setCelsius((f2c.getFarenheit()-32)*5/9);
		System.out.println(c2f.getCelsius());
		
	}
}
