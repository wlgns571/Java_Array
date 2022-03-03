package java_day10;

import java_day09.ArrayStudy;

public class Lotto {
	public static void main(String[] args) {
		// 로또
		// Math.random() : 0부터 1사이의 랜덤 실수를 생성
		// 0 ~ 0.999999999999999
		// 로또는 1부터 45까지 6자리의 숫자 배열
		
		// Math.random() * 10 을 하면 0 ~ 9.9999999 ( int 0 ~ 9 )
		// Math.random() * 100 을 하면 0 ~ 99.9999999 ( int 0 ~ 99 )
		// Math.random() * 45 를 하면 0 ~ 44.999999 ( int 0 ~ 44 )
		
		int lottoNum = (int) ((Math.random() * 45) + 1);
//		System.out.println(lottoNum);
		
		int[] myLotto = new int[6];
		
		// myLotto 에 Math.random()을 이용해서
		// 로또 번호 ( 1 ~ 45 )를 중복되지 않게 담으시오.
		// i-- 는 잘 사용하지 않는것이 좋다.
//		for (int i = 0; i < myLotto.length; i++) {
//			
//			myLotto[i] = (int) ((Math.random() * 45) + 1);
//			
//			for ( int j = 0; j < i; j++ ) {
//				
//					if (myLotto[i] == myLotto[j]) {
//						i--;
//				}
//			}
//		}
//		ArrayStudy.printArray(myLotto);
		
		int[] winLotto = {1, 4, 29, 39, 43, 45};
		int[] lottoArr = makeLotto();
		
		ArrayStudy.printArray(winLotto);
		ArrayStudy.printArray(lottoArr);
		
		// winLotto 와 lottoArr를 비교해서
		// 당첨 갯수를 리턴하는 함수를 만드시오.
		// 함수명 한번에 변경하는 단축키
		// Alt + Shift + R
		System.out.println( "당첨갯수: " + compareLotto(winLotto, lottoArr));
		
		long runTime = 0;
		
		while (true) {
			System.out.println(++runTime + "회 실행");
			
			if(compareLotto(winLotto, makeLotto())) {
				
				System.out.println("1등 당첨");
				System.out.println("구매 횟수: " + runTime);
				System.out.println("구매 금액: " + (runTime * 1000));
				break;
			} 
		}
		
	} // main
	
	// 두 숫자 배열을 비교하여 6개가 같다면 true를 리턴
	public static boolean compareLotto(int[] winArr, int[] myArr) {
		
		int cnt = 0;
		
		for ( int i = 0; i < winArr.length; i++ ) {
			
			for ( int j = 0; j < myArr.length; j++ ) {
				
				if ( winArr[i] == myArr[j] ) {
					cnt++;
				}
			}
		}
//		if(cnt == 6) {
//			return true;
//		}
//		return false;
		return ( cnt == 6 );
	}
	
	public static int[] makeLotto() {
		
		int[] myLotto = new int[6];
		int idx = 0;
		
		while(true) {
			int lotto = (int) (Math.random() * 45 + 1);
			boolean isEqual = false;
			
			// 중복체크
			for ( int i = 0; i < idx; i++ ) {
				if (lotto == myLotto[i]) {
					isEqual = true;
				}
			}
			
			if(isEqual == false) {
				myLotto[idx] = lotto;
				idx++;
			
				if(idx > 5) {
					break;
				}
			}
		}
//		ArrayStudy.printArray(myLotto);
		
		// 로또는 정렬도 해야함 ( 오름차순 )
		
		// 정렬 알고리즘
		// 버블 정렬
		
		for ( int i = 0; i < myLotto.length; i++ ) {
			boolean swapped = false;
			
			for ( int j = 0; j < myLotto.length -1 - i; j++ ) {
				if ( myLotto[j] > myLotto[j+1] ) {
					
					// myLotto의 j와 j+1의 자리바꾸기
					myLotto[j] = myLotto[j] + myLotto[j+1];
					myLotto[j+1] = myLotto[j] - myLotto[j+1];
					myLotto[j] = myLotto[j] - myLotto[j+1];
					
					swapped = true;
				}
			}
			
			if(swapped == false) {
				break;
			}
			
		}
		
//		ArrayStudy.printArray(myLotto);
		return myLotto;
	}
}