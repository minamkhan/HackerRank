package com.challenge.daysOfStatistics;

//Author: INAM
//Github: github.com/minamkhan
//HackerRank: hackerrank.com/minamkhan

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.Arrays;

/**
Input
6
6 12 8 10 20 16
5 4 3 2 1 5

Input
5
10 40 30 50 20
1 2 3 4 5
30.0
*/
public class InterquartileRange {

	public static void main(String[] args) {
		
		/* Save input */
	    Scanner scan = new Scanner(System.in);
	    int size = scan.nextInt();
	    int [] element = new int[size];
	    int [] frequency = new int[size];
	    
	    for (int i = 0; i < size; i++) {
	        element[i] = scan.nextInt();
	    }
	    int numElements = 0;
	    for (int i = 0; i < size; i++) {
	        frequency[i] = scan.nextInt();
	        numElements += frequency[i];
	    }
	    scan.close();
	    
	    int data[] = new int[numElements];
	    
        
	    AtomicInteger dataIndex = new AtomicInteger();
	    
	    IntStream.range(0,size)
        			.forEach(index -> {        				
        				IntStream.range(0, frequency[index])
        							.forEach(i ->{
        								data[dataIndex.getAndIncrement()] = element[index];        								
        					});
        				
        });
	    
	    Arrays.sort(data);
		 int [] lowerHalfArray;
		 int [] middleHalfArray;
		 int [] upperHalfArray;
		 
		 double q1;
		 double q2;
		 double q3;
		 int arraySize = data.length;
		 
		 if(arraySize%2 ==0){
			 //If even size array
			 int quarterSize = arraySize/2;
			 
			 lowerHalfArray = Arrays.copyOfRange(data, 0, quarterSize);
			 middleHalfArray = Arrays.copyOfRange(data, 0, arraySize);
			 upperHalfArray = Arrays.copyOfRange(data, quarterSize, arraySize);
			 
			 q1 = calculateQuartile(lowerHalfArray, quarterSize);
			 q2 = calculateQuartile(middleHalfArray, arraySize);
			 q3 = calculateQuartile(upperHalfArray, quarterSize);
			 
			 
		 }else{
			 //If odd size array
			 int quarterSize = arraySize/2;
			 lowerHalfArray = Arrays.copyOfRange(data, 0, quarterSize);
			 q2 = (data[arraySize/2]); 
			 upperHalfArray = Arrays.copyOfRange(data, quarterSize + 1, arraySize);	
			 
			 q1 = calculateQuartile(lowerHalfArray, quarterSize);
			 q3 = calculateQuartile(upperHalfArray, quarterSize);
		 }
		 
	    
	    System.out.println(q3 -q1);
	    
	    
	}
	
	
	 private static int calculateQuartile(int[] array, int size){
		 int quartile;
		 if(size % 2 ==0){
			quartile = (array[size/2-1] + array[size/2])/2; 
		 }else{
			quartile = (array[size/2]); 
		 }
		 return quartile;
	 }
	 
//	private static double calculateMedian(int[] array,  int size){
//		
//		 //Calculate the median
//		 double median;
//		 if(size % 2 ==0){
//			 median = (array[size/2 - 1] + array[size/2])/2;
//		 }else{
//			 median = array[size/2];
//		 }
//		 return median;
//	}
	
	
}


