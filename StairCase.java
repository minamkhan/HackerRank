package com.challenge.daysOfStatistics;

import java.util.Scanner;
import java.util.stream.IntStream;

public class StairCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 /* Save input */
		 Scanner scan = new Scanner(System.in);
		 int size = scan.nextInt();	
		
		 scan.close();
		 
		 IntStream.rangeClosed(1, size).forEach(
				  (index) ->{
					  IntStream.range(index, size)
					  			.forEach((i)->{
					  				System.out.print(" ");
					  			});
					  IntStream.rangeClosed(1, index)
					  			.forEach((j)->{
					  				System.out.print("#");
					  			});
					  System.out.println();
					  
				  });
	}

}
