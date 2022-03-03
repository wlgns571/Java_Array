package java_day09;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class ArrayStudy {
	public static void main(String[] args) {
		String student1 = "사오정";
		String student2 = "삼장";
		String student3 = "손오공";
		String student4 = "저팔계";
		
		System.out.println("서유기 등장인물 " + student1 + student2 + student3 + student4);
		
		System.out.println("\n================== 문자 배열 ====================\n");
		
		//배열의 선언1
		String[] students = new String[4];
		// String 타입의 변수를 4개 담을 수 있는 students 배열 선언
		
		// 배열 .length 을 하면 해당 배열의 크기를 리턴한다.
		System.out.println("배열 크기: " + students.length);
		
		// 배열의 값 확인, 인덱스 사용
		System.out.println(students[0]);
		
		// 0부터 array.length 미만까지 순회하면 배열의
		// 모든요소에 접근이 가능하다.
		for ( int i = 0; i < students.length; i++ ) {
			System.out.print(students[i] + ", ");
		}
		
		System.out.println("\n=========== 숫자 배열 =============\n");
		
		// 숫자형 타입의 경우 값을 주지 않으면 0
		// 참조형 타입의 경우 값을 주지 않으면 null
		int[] intArray = new int[6];
		
		for ( int i = 0; i < intArray.length; i++ ) {
			System.out.print(intArray[i] + ", ");
		}
		
		System.out.println("\n=========== 배열에 값 넣기 =============\n");

		students[0] = "사오정";
		students[1] = "삼장";
		students[2] = "손오공";
		students[3] = "저팔계";
		
		// 배열의 단점
		// 크기가 고정됨
		System.out.println(students[2]);
		// students[4] = "크리링";
		// 빨간줄 에러는 컴파일 에러로, 실행을 안해봐도
		// 이클립스가 캐치해냄
		// 실행 했을 경우 발생하는 에러는 런타임 에러
		// System.out.println(students[4]);
		
		for (int i = 0; i < students.length; i++) {
			if (i == students.length - 1) {
				System.out.println(students[i]);
			} else {
				System.out.print(students[i] + ", ");
			}
		} // 배열 요소(element) 조회하는 경우
		printArray(students);
		
		int intVal = 12;
		for ( int i = 0; i < intArray.length; i++ ) {
			intArray[i] = intVal;
			intVal *= 2;
		}
		
		printArray(intArray);
		
		System.out.println("\n=============================\n");

		// 배열의 선언 2
		String[] strArray = {"사오정", "삼장", "손오공", "저팔계"};
		// "사오정", "삼장", "손오공", "저팔계"의 값을 가지는
		// 크기 4의 문자열 배열 선언
		
		// strArray[4] = "크리링"; -> 오류
		printArray(strArray);
		
		System.out.println("\n============== 문자열 나누기 ===============\n");
		
		String myInfo = "김지훈, 010-3055-8832, wlgns571@gmail.com";
		// .split() 괄호안 문자열을 기준으로 해당 문자열을 문자열 배열로 나눈다.
		String[] infoArray = myInfo.split(",");
		System.out.println(infoArray.length);
		System.out.println(infoArray[0]);
		System.out.println(infoArray[1]);
		System.out.println(infoArray[2]);
		printArray(infoArray);
		
		// *, ?. + 를 문자로 써야 에러가 나지 않는다.
		// 문자로 쓰려면 특수기호 앞에 '\\'을 붙인다.
		// regex란 정규표현식(Regular Expression)을 의미한다.
		String calStr = "1+4+2";
		String[] calArray = calStr.split("\\+");
		printArray(calArray);
		
		System.out.println("A : intValA");
		System.out.println("B : intValB");
		
		String[] copyArray = strArray;
		printArray(copyArray);
		System.out.println(strArray);
		System.out.println(copyArray);
		System.out.println(strArray.hashCode());
		System.out.println(copyArray.hashCode());
		
		// 해쉬코드
		// 객체의 메모리 주소값을 이용하여 해쉬를 적용한 코드를 말한다.
		// 해쉬란?
		// 해쉬함수(암호화 알고리즘)을 이용하여, 데이터를 암호화하는 기법
		// (RSA, DES)
		
		copyArray[2] = "손오반";
		printArray(strArray);
		printArray(copyArray);
		
		// 암호화, 복호화
		// 암호화
		Encoder base64Encoder = Base64.getEncoder();
		String password = "1q2w3e4";
		byte[] passByte = password.getBytes();
		String encryption = new String(base64Encoder.encode(passByte));
		
		System.out.println("암호화된 비밀번호: " + encryption);
		
		// 복호화
		Decoder base64Decoder = Base64.getDecoder();
		String decryption = new String(base64Decoder.decode(encryption));
		
		System.out.println("복호화된 비밀번호: " + decryption);
		
		System.out.println("\n=============================\n");

		// 올바른 배열 복사
		String[] copyArray2 = strArray.clone();
		printArray(copyArray2);
		
		System.out.println(strArray.hashCode());
		System.out.println(copyArray2.hashCode());
		
		copyArray2[1] = "크리링";
		printArray(copyArray2);
		printArray(strArray);
		
		// clone을 사용하지 않았을 경우.
		String[] sameStrArray = new String[strArray.length];
		for ( int i = 0; i < strArray.length; i++ ) {
			sameStrArray[i] = strArray[i];
		}
		printArray(sameStrArray);
		
		System.out.println("\n============== 숫자 배열 ===============\n");
		
		int[] intArr = {23, 456, 213, 32, 464, 1, 2, 4};
		
		// 자리 바꾸기
		int temp = intArr[0];
		intArr[0] = intArr[1];
		intArr[1] = temp;
		printArray(intArr);
		
		System.out.println("\n============== 숫자 정렬 ===============\n");
		
		// 정렬 알고리즘
		// 버블 정렬
		for ( int i = 0; i < intArr.length; i++ ) {
			boolean swapped = false;
			
			for ( int j = 0; j < intArr.length -1 - i; j++ ) {
				if ( intArr[j] > intArr[j+1] ) {
					temp = intArr[j];
					intArr[j] = intArr[j+1];
					intArr[j+1] = temp;
					swapped = true;
				}
			}
			
			if(swapped == false) {
				System.out.println("이미 정렬 완료");
				break;
			}
			
			System.out.println(i + " 회 시행");
			printArray(intArr);
		}
//		printArray(intArr);
		
	} // main 
	
	// public을 private로 바꾸게 되면 해당 클래스에서만 사용 가능
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