package java_day10;

import java_day09.ArrayStudy;

public class MultiArray {
	public static void main(String[] args) {
		
		int[][] doubleArr = {{1,2,3},{4,5,6},{7,8,9}};
		
		int[] tempArr = doubleArr[0];
		ArrayStudy.printArray(tempArr);
		
		tempArr = doubleArr[1];
		ArrayStudy.printArray(tempArr);
		
		System.out.println(tempArr[0]);
		System.out.println(doubleArr[1][0]);
		
		System.out.println(doubleArr[2][1]);
		
		int[][][] tripleArr = {{{1,2,3},{4,5,6},{7,8,9}},
							  {{10,11,12},{13,14,15},{16,17,18}},
							  {{19,20,21},{22,23,24},{25,26,27}}};
		System.out.println(tripleArr[1][2][0]);
		
	}
}
