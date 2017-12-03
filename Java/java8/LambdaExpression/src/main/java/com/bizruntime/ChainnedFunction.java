package com.bizruntime;

import java.util.function.Function;

import org.apache.log4j.Logger;

public class ChainnedFunction {
	private static Logger log=Logger.getLogger(Example1.class);

	public static void main(String[] args) {
		
		Function<Long, Long> square=x -> x * x ;
		
		Function<Long, Long> chainedFunction= 	square.andThen(x -> x + 1).andThen(x -> x * x)
				.andThen(x -> x * x).andThen(x -> x * x*8);
		log.debug(chainedFunction.apply(10L));
		
		
	}
}
