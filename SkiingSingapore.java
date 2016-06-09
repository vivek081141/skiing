package com.hakerearth.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * The algorith to find the maximum skiing distance
 * Sample Input
 *  4 4 
	4 8 7 3 
	2 5 9 3 
	6 3 2 5 
	4 4 1 6
 * @author vivek.agrawal
 *
 */
public class SkiingSingapore {
	private static Integer[][] input=null;
	private static Integer length=null;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line=br.readLine().split(" ");
		int a=Integer.parseInt(line[0]);
		int b=Integer.parseInt(line[1]);
		input=new Integer[a][b];
		for(int i=0;i<a;i++){
			line=br.readLine().split(" ");
			for(int j=0;j<line.length;j++){
				input[i][j]=Integer.parseInt(line[j]);
			}
		}
		length=input.length;
		List<Integer> list=new ArrayList<Integer>();
		List<List<Integer>> superList=new ArrayList<List<Integer>>();
		for(int i=0;i<a;i++){
			for(int j=0;j<b;j++){
				list=recursion(input[i][j],i,j);
				superList.add(list);
			}
		}
		
		Collections.sort(superList, new Comparator<List<Integer>>() {
		  public int compare(List<Integer> o1, List<Integer> o2)  {
		    return o2.size()-o1.size();
		  }
		});
		
		int maxSize=superList.get(0).size(); //5 in this case
		int maxDiff=0;
		List<Integer>  output = null;
		for(int z=0;z<superList.size();z++){
			List<Integer>  tempList=superList.get(z);
			if(superList.get(z).size()==maxSize){
				int diff=tempList.get(maxSize-1)-tempList.get(0);
				if(diff>maxDiff){
					maxDiff=diff;
					output=tempList;
				}
			} 
			
		}
		
		if(output!=null){
			for(int i=output.size()-1;i>=0;i--)
					System.out.print(output.get(i)+" ");
		}
		
	}
	
	
	
	private static List<Integer> recursion(int x,int i,int j) {
			List<Integer> listA=new ArrayList<Integer>();
			List<Integer> listB=new ArrayList<Integer>();
			List<Integer> listC=new ArrayList<Integer>();
			List<Integer> listD=new ArrayList<Integer>();
		
			if((i-1>=0) && x>input[i-1][j]){
				listA=recursion(input[i-1][j],i-1,j);
			}
			
			if((j-1>=0) && x>input[i][j-1]){
				listB=recursion(input[i][j-1],i,j-1);
			}
			if((i+1<length) && x>input[i+1][j]){
				listC=recursion(input[i+1][j],i+1,j);
			}
			if((j+1<length) && x>input[i][j+1]){
				listD=recursion(input[i][j+1],i,j+1);
			}
			
			return greatestList(listA,listB,listC,listD,x);
	}

	private static List<Integer> greatestList(List<Integer> listA, List<Integer> listB, List<Integer> listC,
			List<Integer> listD,int x) {
			if(listA.size()==0 && listB.size()==0 && listC.size()==0 && listD.size()==0){
				List<Integer> listX=new ArrayList<Integer>();
				listX.add(x);
				return listX;
			}
			Integer[] list={listA.size(),listB.size(),listC.size(),listD.size()};
		    Arrays.sort(list);
		    
		    if(list[3]==listA.size()){
		    	listA.add(x);
		    	return listA;
		    }
		    if(list[3]==listB.size()){
		    	listB.add(x);
		    	return listB;
		    }
		    if(list[3]==listC.size()){
		    	listC.add(x);
		    	return listC;
		    }
		    listD.add(x);    
		return listD;
	}
}
