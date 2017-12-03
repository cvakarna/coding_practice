package com.forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.RecursiveTask;

import org.apache.log4j.Logger;


public class RandomIntSum extends RecursiveTask<Long>{ 
	private Logger log = Logger.getLogger(RandomIntSum.class);

	private Random randGenerator = new Random();

	private int count;
	
	public RandomIntSum(int count) {
		
		
		this.count = count;
	}



	@Override
	protected Long compute() {
		long result=0;
		
		if (this.count <= 0) {
			return 0L;
		}
		if (this.count == 1) {
			return (long)this.getRandomInteger();
		}
		
		
		List<RecursiveTask<Long>>forks = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			
			RandomIntSum subTask = new RandomIntSum(1);
			subTask.fork();
			forks.add(subTask);
			log.debug("subtask "+subTask+" fork --> "+forks);

		}
		for(RecursiveTask<Long> subTask : forks) {
			result = result + subTask.join();
		}
		
		return result;
	}
	
	public int getRandomInteger() {
		
		int n=randGenerator.nextInt(100)+1;
		log.debug("Generated a random integer: "+n);
		return n;
	}
}
