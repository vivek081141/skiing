package org.algorithm.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input: First line contains one integer, T T, number of test cases. First line
 * of each test case contains two integer, N N and X X, number of bottles and
 * capacity of the container. Second line of each test case contains N N space
 * separated integers, capacities of bottles.
 * 
 * Output: For each test case print the maximum number of bottles you can fill.
 * 
 * Sample 1 5 10 8 5 4 3 2
 * 
 * @author vivek.agrawal
 *
 */
public class GreedyForWater {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		List<String> line1=new ArrayList<String>();
		List<String> line2=new ArrayList<String>();
		int N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			line1.add(br.readLine());
			line2.add(br.readLine());
		}
		
		
		for (int i = 0; i < N; i++) {
			String[] input1 = line1.get(i).split(" ");
			int noOfBottles = Integer.parseInt(input1[0]);
			int capacity = Integer.parseInt(input1[1]);
			int length = line2.get(i).split(" ").length;
			Integer[] bottleArray = new Integer[length];
			for (int j = 0; j < length; j++) {
				bottleArray[j] = Integer.parseInt(line2.get(i).split(" ")[j]);
			}

			/*
			 * int output = greedyAlgorithm(noOfBottles, capacity, bottleArray);
			 */
			/*
			 * System.out.println(output);
			 */

			Arrays.sort(bottleArray);
			int cap = 0;
			int z=0;
			for (z = 0; z < noOfBottles; z++) {
				cap = cap + bottleArray[z];
				if (cap > capacity) {
					break;
				}
			}
			System.out.println(z);
		}
	}

	private static int greedyAlgorithm(int noOfBottles, int totalCapacity, Integer[] bottleArray) {
		Arrays.sort(bottleArray);
		int capacity = 0;
		for (int i = 0; i < noOfBottles; i++) {
			capacity = capacity + bottleArray[i];
			if (capacity > totalCapacity) {
				return i;
			}
		}
		return 0;
	}

}
