package com.challenge.daysOfStatistics;

//Author: INAM
//Github: github.com/minamkhan
//HackerRank: hackerrank.com/minamkhan

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

//Input 
//5
//10 40 30 50 20
//1 2 3 4 5
//Output  32.0

public class WeightedMeanChallenge {
	public static void main(String[] args) {
		 /* Save input */
		 Scanner scan = new Scanner(System.in);
		 int size = scan.nextInt();
		 int [] array = new int[size];
		 for (int i = 0; i < size; i++) {
		     array[i] = scan.nextInt();
		 }
		 
		 int [] weightArray = new int[size];
		 for(int i=0;i<size;i++){
			 weightArray[i] = scan.nextInt();
		 }
		 
		 scan.close();
		 
		 AtomicInteger totalWeight = new AtomicInteger(); 
		 AtomicInteger calculatedWeight = new AtomicInteger(); 
				 
		 IntStream.range(0, size)
							.forEach((i) ->{
									totalWeight.addAndGet( weightArray[i]);
									calculatedWeight.addAndGet(array[i] * weightArray[i]);
										//return array[i] * weightArray[i]; 
							});
		 
		 
		 	
		 double weightedMean = (double)calculatedWeight.get()/totalWeight.get();
		 
		 /* Print results */
		 System.out.format("%.1f", weightedMean);
		
	}	

	
}
