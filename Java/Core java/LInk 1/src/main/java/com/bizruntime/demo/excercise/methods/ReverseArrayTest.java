package com.bizruntime.demo.excercise.methods;


public class ReverseArrayTest {
public static void main(String[] args) {
int []arr={1,2,3,4};
	reverseArray(arr);
}

static void reverseArray(int arr[]){
		int temp=0;
		
		for (int i = 0,j=arr.length-1; i < arr.length && j>i;  i++,j--) {
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
for (int i = 0; i < arr.length; i++) {
	System.out.print(arr[i]);
}
}

}
