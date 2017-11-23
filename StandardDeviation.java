package com.challenge.daysOfStatistics;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public class StandardDeviation {
	
	public static void main(String args[]){
		 
		/* Save input */
		 Scanner scan = new Scanner(System.in);
		 int size = scan.nextInt();
		 long [] array = new long[size];
		 
		 LongStream.range(0, size).forEach( i ->{
			 array[(int) i] = scan.nextLong();
		 });
		
		 scan.close();
		 
		long mean = (long)Arrays.stream(array).average().orElse(0);
		AtomicLong totalSqDistance = new AtomicLong();
		
		Arrays.stream(array).forEach((element)->{
			long distanceFromMean = (long)(element - mean);
			
			long sqDistance = distanceFromMean * distanceFromMean;
			
			totalSqDistance.addAndGet(sqDistance);
		});
		
		double standardDev = Math.sqrt(totalSqDistance.get()/size);
		
		 String pattern = "0.0";
		 DecimalFormat dFormat = new DecimalFormat(pattern);
		 
		 System.out.println(dFormat.format(standardDev));
		
		
	}
}
