package org.tw.algos;

/**
 * Write a program to perform division operation 
 * of two numbers without using
 *  % and module operator
 * @author vivek.agrawal
 *
 */
public class Division {

	public static void main(String[] args) {
		Integer divident=30;
		int divisor=4;
		int quoteint=0;
		int remainder=0;
		for(int i=4;i<divident;i=i+divisor){
			 quoteint++;
			 remainder=divident-i;
		}
		System.out.println("Quoteint " + quoteint +" Remainder "+remainder);
	}
}
