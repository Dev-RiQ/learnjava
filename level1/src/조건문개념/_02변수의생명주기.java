package 조건문개념;

public class _02변수의생명주기 {

	public static void main(String[] args) {

		/*
		 * 변수의 생명주기(scope : 범위)
		 * 변수 선언 -> 자료형 변수이름 = 초기값;
		 * 변수 삭제 -> 선언한 영역이 끝날 때
		 */
		
		int num = 10;
		System.out.println(num);
		{
			System.out.println(num); // 밖에거는 쓸 수 있는데 안에쓴건 밖에 못씀 (새로 변수 선언)
			int x = 100;
			num = 9;
			System.out.println(x);
		} // 여기 나가면 사라짐(선언한 변수만, 밖에서 선언한 변수의 값 변경은 그대로 적용)
		int x = 1000;
		System.out.println(x);
		
		System.out.println(num);
		
	}

}
