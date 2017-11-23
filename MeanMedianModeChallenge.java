package com.challenge.daysOfStatistics;

//Author: INAM
//Github: github.com/minamkhan
//HackerRank: hackerrank.com/minamkhan

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

//Input 10
//64630 11735 14216 99233 14470 4978 73429 38120 51135 67060
//Output  43900.6 
//44627.5 
//4978
public class MeanMedianModeChallenge {
	public static void main(String[] args) {
		 /* Save input */
		 Scanner scan = new Scanner(System.in);
		 int size = scan.nextInt();
		 int [] array = new int[size];
		 for (int i = 0; i < size; i++) {
		     array[i] = scan.nextInt();
		 }
		 scan.close();
		 
		 double mean = calculateMean(array);
		 
		 /* Sort array */
		 Arrays.sort(array);
		 double median = calculateMedian(array, size);

		 double mode = calculateMode(array);
		 /* Print results */
		 System.out.println(mean);
		 System.out.println( median);
		 System.out.println((int)(mode == array[0] ? array[0]:mode));
	}
	
	private static double calculateMean(int[] array){
		 //Calculate the mean
		 return Arrays.stream(array).average().orElse(0.0);
	}
	
	private static double calculateMedian(int[] array,  int size){
		 //Calculate the median
		 double median;
		 if(size % 2 ==0){
			 median = (double)(array[size/2 - 1] + array[size/2])/2;
		 }else{
			 median = array[size/2];
		 }
		 return median;
	}
	
	private static double calculateMode(int[] array){

		 //Calculate the mode
		 double mode = 0.0;
		 int maxOccurences = 0;
		 java.util.Map<Integer,Integer>  occurenceMap = new HashMap<>();
		 for(int num:array){
		
			 occurenceMap.merge(num,1,Integer::sum);
			 int occurences = occurenceMap.get(num);
			 if(occurences>maxOccurences){
				 maxOccurences = occurences;
				 mode = num;
			 }
		 }
		 if(mode==0){
			 return array[0];
		 }
		 return mode;
	}
}
