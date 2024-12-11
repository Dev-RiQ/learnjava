package 조건문개념;

public class _05if문구조 {

	public static void main(String[] args) {

		/*
		 	[개념]
		 		if(조건식) { if 영역 } : 조건식 == true 일때 if 영역 실행
		 		else { else 영역 } : 조건식 == false 일때 else 영역 실행 (조건식은 if거 사용) (if 다음에 사용 (조건이 반대일 경우))
		 		
		 */
		
		int num = 10;

//		if (num%2 == 0) {
//			System.out.println("짝수");
//		}
//		if (num%2 != 0) {
//			System.out.println("홀수");
//		}
//		위 2개를 아래 1개로 합침

		if (num % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}

		num = 1;
		if (num == 1) {
			System.out.println("1");
		}
		if (num == 2) {
			System.out.println("2");
		} else {
			System.out.println("3"); // 바로 위 if에서 연산, 사이에 뭐 있으면 안됨
		}
		
		
	}

}
