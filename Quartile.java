package com.challenge.daysOfStatistics;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
//9
//3 7 8 5 12 14 21 13 18


/**
 * 
10
3 7 8 5 12 14 21 15 18 14

7
13
15
 */
public class Quartile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 /* Save input */
		 Scanner scan = new Scanner(System.in);
		 int size = scan.nextInt();
		 int [] array = new int[size];
		 
		 IntStream.range(0, size).forEach( i ->{
			 array[i] = scan.nextInt();
		 });
		
		 scan.close();
		 
		 Arrays.sort(array);
		 int [] lowerHalfArray;
		 int [] middleHalfArray;
		 int [] upperHalfArray;
		 
		 int q1;
		 int q2;
		 int q3;
		 
		 if(size%2 ==0){
			 //If even size array
			 int quarterSize = size/2;
			 
			 lowerHalfArray = Arrays.copyOfRange(array, 0, quarterSize);
			 middleHalfArray = Arrays.copyOfRange(array, 0, size);
			 upperHalfArray = Arrays.copyOfRange(array, quarterSize, size);
			 
			 q1 = calculateQuartile(lowerHalfArray, quarterSize);
			 q2 = calculateQuartile(middleHalfArray, size);
			 q3 = calculateQuartile(upperHalfArray, quarterSize);
			 
			 
		 }else{
			 //If odd size array
			 int quarterSize = size/2;
			 lowerHalfArray = Arrays.copyOfRange(array, 0, quarterSize);
			 q2 = (array[size/2]); 
			 upperHalfArray = Arrays.copyOfRange(array, quarterSize + 1, size);	
			 
			 q1 = calculateQuartile(lowerHalfArray, quarterSize);
			 q3 = calculateQuartile(upperHalfArray, quarterSize);
		 }
		 
		 	System.out.println(q1);
		 	System.out.println(q2);
		 	System.out.println(q3);
		 	 
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
	 

}
