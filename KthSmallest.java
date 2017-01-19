package playGround;

import java.awt.geom.GeneralPath;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallest {
	
	public static void main(String[] args){
		Scanner in  = new Scanner(System.in);
		int input = in.nextInt();
		List<Integer> y = new  ArrayList<Integer>(Arrays.asList(1));
		kthsmallest(y, input);
	}
	
	public static int kthsmallest(final List<Integer> a, int k) {
		int result = -1;
		//result = findKth(a, 0, a.size() -1, k);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<=a.size()-1; i++){
			pq.offer(a.get(i));
		}
		while(k>0){
			result = pq.poll();
			k--;
		}
		
		System.out.println(result);
		return result;
	}
	
	public static int findKth(List<Integer> a, int start, int end, int k){
		
		int pivot = a.get(end);
		int left = start;
		int right = end;
		 while (true){
			 while(left < right && a.get(left) < pivot){
				 left++;
			 }
			 while( left < right && a.get(right) >= pivot){
				 right --; 
			 }
			 if (left == right){
				 break;
			 }
			 swap(a, left, right);
		 }
		 
		 swap(a, left, end);
		 if( k == left + 1){
			 return pivot;
		 }
		 else if(k < left + 1){
			 return findKth(a, start, left - 1, k);
			 
		 }
		 else {
			 return findKth(a, left + 1, end, k);
		 }
	}
	

	private static void swap(List<Integer> a, Integer i, Integer pIndexed) {
		int temp = a.get(i);
		a.set(i,a.get(pIndexed));
		a.set(pIndexed, temp);
	}
	
}
