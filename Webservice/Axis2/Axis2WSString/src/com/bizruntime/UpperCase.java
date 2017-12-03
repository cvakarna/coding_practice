package com.bizruntime;

public class UpperCase {

	String word;
	
	public void setWord(String word){
		
		this.word=word.toUpperCase();
		getWord();
		
		
	}
	
	public String getWord(){	
		return word;
	}
	
	
}
