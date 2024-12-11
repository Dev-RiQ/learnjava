package 기초02개념;

public class _04변수특징 {

	public static void main(String[] args) {
		
		// 변수에서 연산자 우선순위
		/*
		 * [1] () 
		 * [2] * / % 
		 * [3] + - 
		 * [4] =
		 */
		int x = 10+3*(2+1);
		System.out.println("x= " + x);
		
		//변수의 누적
		x = 100; //변수의 값 재정의
		
		int y = 10;
		
		y = y + 10;
		y = y - 3;
		y = y / 2;
		//축약하면 아래
		y+=10; // 누적 시 사용 (띄어쓰기 x)
		y-=3;
		y/=2;
		
	}

}
