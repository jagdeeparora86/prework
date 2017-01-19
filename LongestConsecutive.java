package playGround;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LongestConsecutive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> y = new  ArrayList<Integer>(Arrays.asList(100, 4, 200, 1, 3, 2));
		solution s = new solution();
		int ans = s.longestConsecutive(y);
		System.out.println(ans);

	}

}

class solution {
	
	public int longestConsecutive(final List<Integer> a) {
		return findLongest(a, a.size());
		
	}

	private int findLongest(List<Integer> a, int size) {
		HashSet<Integer> hash = new HashSet<Integer>();
		int answer = 0;
		for(int i=0; i<size; i++){
			hash.add(a.get(i));
		}
		
		for(int i=0; i<size; i++){
			if(!hash.contains(a.get(i) - 1)){
				int val = a.get(i);
				while (hash.contains(val)){
					val++;
					
					if(answer < val - a.get(i)){
						answer = val - a.get(i);
					}
				}
			}
		}
		return answer;
	}
	
}
