package playGround;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PreetyPrint {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		ArrayList<ArrayList<Integer>> resultArray = initPrinter(number);
		System.out.println(resultArray.toString());
	}
	
	private static ArrayList<ArrayList<Integer>> initPrinter(int input){
		int size = input + (input -1);
		int topRow = 0, leftCol = 0;
		int bottomRow = size - 1; 
		int rightCol = size    - 1;
		int direction = 0; // 0 is left to right, 1 is top to down, 2 right to left, 3 is bottom to up;
		ArrayList<ArrayList<Integer>> prettyArray = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0 ; i < size; i++){
			ArrayList<Integer> x = new ArrayList<Integer>();
			for(int j =0 ; j<size; j++)
				x.add(0);
			prettyArray.add(x);
		}
		
		while(topRow <= bottomRow &&  leftCol <= rightCol){
			if(direction == 0){
				for(int i = topRow; i <= rightCol; i++){
					prettyArray.get(topRow).set(i, input);
				}
				topRow++;
				direction=1;
			}else if(direction == 1){
				for (int i = topRow; i <= bottomRow; i++){
					
					prettyArray.get(i).set(rightCol, input);
				}
				
				direction = 2;
				rightCol--;
			}else if(direction == 2){
				for(int i = rightCol; i >=leftCol; i--){
					
					prettyArray.get(bottomRow).set(i, input);
				}
				bottomRow--;
				direction = 3;
			}else if(direction == 3){
				for(int i=bottomRow; i >= topRow; i--){
					
					prettyArray.get(i).set(leftCol, input);
				}
				
				direction = 0;
				leftCol++;
				input--;
			}
		}
		return prettyArray;
		
		
	}

}
