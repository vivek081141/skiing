package org.algorithm.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		int maxHeight=0;
		for(int i=0;i<pileList.size();i++){ 
			int tempMaxHeight=0;
			int tempMaxGold=0;
			for (int j = i; j < pileList.size(); j++) {
				
				if(i==j){
					tempMaxHeight=pileList.get(i).getHeight();
					tempMaxGold=pileList.get(i).getWeight();
				}else{
					if(pileList.get(j).getIndex()>pileList.get(j-1).getIndex()){
						tempMaxHeight=tempMaxHeight+pileList.get(i).getHeight();
						tempMaxGold=tempMaxGold+pileList.get(i).getWeight();
					}
				}
				
			}
			
			
		}
		
		System.out.println(maxHeight);
		
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
			return o.getHeight()-this.height;
		}
		
	}
	
	class WeightSorter  implements Comparator<Pile>{

		@Override
		public int compare(Pile o1, Pile o2) {
			return o2.getWeight()-o1.getWeight();
		}
		
	}
	
	
	public static Pile greatestPile(List<Pile> resultList){
		LargestPile x=new LargestPile();
		Collections.sort(resultList,x.new WeightSorter());
		return resultList.get(0);
		
	}
	
	public static Pile recursion(int index,List<Pile> pileList){
		List<Pile> resultList=new ArrayList<Pile>();
		
		
		
		return greatestPile(resultList);
	}

}
