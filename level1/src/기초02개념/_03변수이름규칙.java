package 기초02개념;

public class _03변수이름규칙 {

	public static void main(String[] args) {
		/* 1. 변수이름은 숫자로 시작할 수 없다.
		 * 2. 특수문자 _ $ 사용 가능하다.
		 * 3. 변수 이름 띄어쓰기 불가능
		 * 4. 키워드 사용 불가
		 * 5. 대소문자 구분
		 * 6. 이미 있는 이름 사용 불가
		 * 7. 일반적으로 소문자 영단어 명사 사용
		 *  */

			int age = 10;
//			age = 10.5; type 안맞음 - type mismatch
			
			age = 'a'; //묵시적 형변환 (type-casting) : 자동 형변환
		
			System.out.println(age);
			System.out.println((int)'가'); // 강제 형변환 (유니코드)
			System.out.println((int)'A');
			System.out.println((int)'a');
			System.out.println((int)10.3);
			System.out.println((double)10);
			
			System.out.println((char)65);// 2바이트 정수, 숫자코드를 문자 한개로 변경
	}

}
