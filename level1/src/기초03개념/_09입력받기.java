package 기초03개념;

import java.util.Scanner; // package, class 사이

public class _09입력받기 {

	public static void main(String[] args) {

		System.out.println("출력문");
		// 1. 입력객체를 만든것
		// 스캐너 : 콘솔창에서 사용자 입력값을 받음
		
//		int num = 10;
		
		Scanner scan = new Scanner(System.in); //생성 
		
		System.out.println("나이값 입력 : ");
		int age = scan.nextInt(); // 정수값 한개 입력 받음
		System.out.println("아무 숫자 입력 : ");
		int random = scan.nextInt(); // 하나 생성해서 여러개 가능
		System.out.println("아무 글자 입력 : ");
		String qwerty = scan.next();
		
		
		scan.close(); //제거 (제일 마지막)
		
		System.out.println("입력한 나이 값은 " + age + " " +qwerty + " " + random); // 위 scan 모두 입력해야 나옴
		
		
		
	}

}
