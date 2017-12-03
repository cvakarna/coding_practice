package com.bizruntime.demo.excercise.command.line.argument;

public class Arithmetic {
public static void main(String[] args) {
	int operand1;
	int operand2;
	char operator;
	
	
	if(args.length!=3){
	      System.err.println("Usage: java Arithmetic int1 int2 op");
	      return;
	}
    operand1 = Integer.parseInt(args[1]);
    operand2 = Integer.parseInt(args[2]);
    operator = args[0].charAt(0);
    System.out.print(args[0] + args[2] + args[1] + "=");

    switch(operator) {
    case ('-'):
    	System.out.println(operand1 - operand2); 
    	break;
    case ('+'): 
    	System.out.println(operand1 - operand2); 
		break;
    case ('*'):
    	System.out.println(operand1 - operand2); 
		break;
    case ('/'): 
    	System.out.println(operand1 - operand2); 
    	break;
    default:
      System.err.println("Error: invalid operator!"); 
  }
}
	
}
