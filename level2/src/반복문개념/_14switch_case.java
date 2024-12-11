package 반복문개념;

public class _14switch_case {

	public static void main(String[] args) {

		/*
		 	조건문 문법
		 	switch case : 비교 대상이 전부 == 특정 값 일때
		 */
		
		int age = 21;
		//10세 이상 19세 미만 => 청소년
		//19세 이상 65 이하 => 어른
		//65 초과 120이하 => 노인
		if(age<=120 &&age>65) {
			System.out.println("노인");
		}else if(age>=19) {
			System.out.println("어른");
		}else if(age>=10) {
			System.out.println("청소년");
		}

		switch (age) {
		case 10:
			System.out.println("청소년");
			break;
		case 11:
			System.out.println("청소년");
			break;
		case 12:
			System.out.println("청소년");
			break;
		case 13:
			System.out.println("청소년");
			break;
		case 14:
			System.out.println("청소년");
			break;
		case 15:
			System.out.println("청소년");
			break;
		case 16:
			System.out.println("청소년");
			break;
		case 17:
			System.out.println("청소년");
			break;
		case 18:
			System.out.println("청소년");
			break;
		case 21:
			System.out.println("어른");
			break;
		case 70:
			System.out.println("노인");
			break;
		default: // else 같음
			System.out.println("비교대상 아님");
		}
	}

}
