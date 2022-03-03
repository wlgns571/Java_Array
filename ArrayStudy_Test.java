package java_day09;

public class ArrayStudy_Test {
	public static void main(String[] args) {
		int[] intArr = {23, 456, 213, 32, 464, 1, 2, 4};
		
		// intArr의 최댓값을 출력하시오.
		// for문 이용
		int max = intArr[0];
		
		for ( int i = 0; i < intArr.length; i++ ) {
			if ( max < intArr[i]) {
				max = intArr[i];
			} 
		}
		
		System.out.println("최댓값 : " + max);
		
		// 배열내 요소 자리 바꾸는 함수
		
		System.out.println("\n==================================\n");
		
		// 선택 정렬
		//	tempArray를 오름차순으로 정렬해주세요.
		//	int[] tempArray = {23, 456, 213, 32, 464, 1, 2, 4};
		
		// 1. 해당 배열에서 최댓값을 찾아 해당 위치의 값과
		// 배열의 마지막 값을 swap 한다.
		
		// 2. 배열의 마지막을 제외한 나머지 값들 중
		// 최댓값을 찾아 해당 위치의 값과 배열의 끝에서 두번재
		// 값을 swap 한다.
		
		// 3. 위 과정을 반복하면 정렬이 된다.
		
		//	@. 오름차순을 훌륭하게 해내셨다면, 최댓값을 이용해서 내림차순도 해보세요.
		// 매번 최댓값을 찾아내어, 맨 앞에서부터 바꿔가면 된다.
		//	@. 조금만 바꾸면 되겠죠? 매번 최댓값을 찾아서 맨 앞에서부터 바꿔가면 됩니다.
		int[] tempArray = { 23, 456, 213, 32, 464, 1, 2, 4 };


		for (int i = 0; i < tempArray.length; i++) {

			max = tempArray[0];
			
			int maxI = 0;
			
			for (int j = 1; j < tempArray.length - i; j++) {
				
				if (max < tempArray[j]) {
					max = tempArray[j];
					maxI = j;
				}
			}		
			swap(tempArray, maxI, tempArray.length - 1 - i);
		}
		printArray(tempArray);
		
		// 강사님이 만들어준 식
		for (int i = 0; i < tempArray.length - 1; i++) {

			int maxVal = tempArray[0];
			
			int maxI = 0;
			
			for (int j = 1; j < tempArray.length - i; j++) {
				if (maxVal < tempArray[j]) {
					maxVal = tempArray[j];
					maxI = j;
				}
			}		
			// swap, 최대값인 maxValue의 인덱스와, 바꿀자리의 인덱스
			swap(tempArray, maxI, tempArray.length - 1 - i );
		}
		// 다른 클래스에서 ArrayStudy 불러오기
		ArrayStudy.printArray(tempArray);
		
		// 내림차순
			for (int i = 0; i < tempArray.length - 1; i++) {

				int maxVar = tempArray[tempArray.length - 1];
				
				int maxI = tempArray.length - 1;
				
				for (int j = i; j < tempArray.length - 1; j++) {
					if (maxVar < tempArray[j]) {
						maxVar = tempArray[j];
						maxI = j;
					}
				}		
				swap(tempArray, maxI, tempArray.length - (tempArray.length - i));
			}
			ArrayStudy.printArray(tempArray);
		
	} // main
	
	/**
	 * 해당 intArray의 인덱스 idxA와 idxB의 값을 교환한다.
	 * @param intArray 값을 교환할 숫자배열
	 * @param idxA 값을 교환할 인덱스 첫번째
	 * @param idxB 값을 교환할 인덱스 두번째
	 */
	public static void swap(int[] intArray, int idxA, int idxB) {
		int temp = intArray[idxA];
		intArray[idxA] = intArray[idxB];
		intArray[idxB] = temp;
	}
	public static void printArray(String[] strArray) {
		
		for (int i = 0; i < strArray.length; i++) {
			if (i == strArray.length - 1) {
				System.out.println(strArray[i]);
			} else {
				System.out.print(strArray[i] + ", ");
			}
		}
	}
	
	public static void printArray(int[] intArray) {
		
		for (int i = 0; i < intArray.length; i++) {
			if (i == intArray.length - 1) {
				System.out.println(intArray[i]);
			} else {
				System.out.print(intArray[i] + ", ");
			}
		}
	}
}
