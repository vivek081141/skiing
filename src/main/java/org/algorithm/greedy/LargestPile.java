package org.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.hackerearth.com/problem/algorithm/the-largest-pile/
 *  First line contains N total boxes. Next line contains N space 
 * 	separated integers H[i] denoting height of box at index i
	Next line contains N space seprated integers G[i] denoting gold 
	in box at index i
	INPUT:
	4
	1 2 3 4
	1 2 3 4
	OUTPUT: 4 4
 * @author vivek.agrawal
 *
 */
public class LargestPile {
	
	public static void main(String[] args) throws Exception {
		LargestPile instance=new LargestPile();
		List<Pile> pileList=new ArrayList<Pile>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] line1=br.readLine().split(" ");
		String[] line2=br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			Pile pile=instance.new Pile();
			pile.setIndex(i);
			pile.setHeight(Integer.parseInt(line1[i]));
			pile.setWeight(Integer.parseInt(line2[i]));
			pileList.add(pile);
		}
		/** sorting the list according to index **/
		Collections.sort(pileList);
		
		
		
	}
	
	
	class Pile implements Comparable<Pile>{
		int index;
		int height;
		int weight;
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		@Override
		public int compareTo(Pile o) {
			return this.index-o.getIndex();
		}
		
	}

}
