package com.challenge.daysOfStatistics;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class PlusMinus {

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
		 
		 AtomicInteger positiveOccurence = new AtomicInteger();
		 AtomicInteger negativeOccurence = new AtomicInteger();
		 AtomicInteger zeroOccurence = new AtomicInteger();
		 
		 Arrays.stream(array).forEach((value)->{
			 if(value>0){
				 positiveOccurence.getAndIncrement();
			} else if(value<0){
				negativeOccurence.getAndIncrement();
			}else{
				zeroOccurence.getAndIncrement();
			};
			 
		 });
		 
		 double positiveFraction = (double)positiveOccurence.get()/size;
		 double negativeFraction = (double)negativeOccurence.get()/size;
		 double zeroFraction = (double)zeroOccurence.get()/size;
		 String pattern = "0.000000";
		 DecimalFormat dFormat = new DecimalFormat(pattern);
		 
		 System.out.println(dFormat.format(positiveFraction));
		 System.out.println(dFormat.format(negativeFraction));
		 System.out.println(dFormat.format(zeroFraction));
	}

}
