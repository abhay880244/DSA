package ArrayProblems;

import java.util.Arrays;

public class MoveAllZeroesToRight {
	
	public static void main(String[] args) {
	
		
		int[] arr = {0,3,56,65,0};
		moveAllZeroesToRight(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void moveAllZeroesToRight(int[] arr) {
		
		int count = 0;
		for (int i = 0; i<arr.length; i++) {
			if(arr[i]!= 0) {
				arr[count] = arr[i];
				count ++;
			}
			
		}
		while(count < arr.length) {
			arr[count++] = 0;
		}
	}

}
