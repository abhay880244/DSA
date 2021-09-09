package ArrayProblems;

import java.util.Arrays;

public class MaxSumSubArray {
	public static void main(String[] args) {
		int a[] = {-3};
		
		int currentSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i< a.length; i++) {
			currentSum += a[i];
			if(currentSum> maxSum) {
				maxSum = currentSum;
			}
			if(currentSum < 0) {
				currentSum = 0;
			}
		}
		System.out.println(maxSum);
	}
}
