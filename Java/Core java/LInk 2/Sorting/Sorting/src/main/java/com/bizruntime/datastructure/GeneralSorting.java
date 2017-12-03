package com.bizruntime.datastructure;

import org.apache.log4j.Logger;

public class GeneralSorting {

	static Integer[] a = new Integer[10];
	static final Logger log = Logger.getLogger(GeneralSorting.class);
	
	public static void main(String[] args) {
		sort();
	}
	public static void sort(){
		log.debug("Before sorting : ");
		for (int i = 0; i < a.length; i++) {
			a[i]=new Integer((int) (Math.random()*100));
			log.info(a[i]+"\t");
		}
//		BubbleSort(a);
//		InsertionSort(a);
		SeletctionSort(a);
		log.debug("\nAfter sorting : ");
		for (int i = 0; i < a.length; i++) {
			log.info(a[i]+"\t");
		}
	}
	public static void BubbleSort(Comparable[] a) {
		 boolean switched = true;
	        for(int i=0;i<a.length-1 && switched;i++){
	            switched = false;
	            for(int j=0;j<a.length-i-1;j++)
	                if(a[j].compareTo(a[j+1]) > 0){
	                    switched = true;
	                    Comparable hold = a[j];
	                    a[j] = a[j+1];
	                    a[j+1] = hold;
	                }
	        }

	}

	public static void SeletctionSort(Comparable[] a) {
		for(int i = a.length-1;i>0;i--){
            Comparable large = a[0];
            int indx = 0;
            for(int j = 1;j <= i;j++)
                if(a[j].compareTo(large) > 0){
                    large = a[j];
                    indx = j;
                }
            a[indx] = a[i];
            a[i] = large;
        }
	}

	public static void InsertionSort(Comparable[] a) {
		int i,j;
        Comparable e;
        for(i=1;i<a.length;i++){
            e = a[i];
            for(j=i-1;j>=0 && a[j].compareTo(e) > 0;j--)
                a[j+1] = a[j];
            a[j+1] = e;
        }
	}


}
