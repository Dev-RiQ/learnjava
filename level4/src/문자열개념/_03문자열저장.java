package 문자열개념;

import java.util.Scanner;

public class _03문자열저장 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String name1 = "박연미";
		String name2 = "박연미";
		String name3 = "홍길동"; // => heap 내의 String Pool에 생성
		
		System.out.println("박연미 입력 >> ");
		String name4 = sc.next(); // => heap 외의 Buffer에서 생성 -> heap 저장
		
		String name5 = new String("박연미"); // => 주소값 달라짐 heap에서 생성
		String name6 = name5; //=> 주소값 복사와 같음
		
		System.out.println("1 name1 = "+name1);
		System.out.println("2 name2 = "+name2);
		System.out.println("3 name3 = "+name3);
		System.out.println("4 name4 = "+name4);
		System.out.println("5 name5 = "+name5);
		
		System.out.println("name1 == name2 => " +(name1==name2));
		System.out.println("name2 == name3 => " +(name2==name3));
		System.out.println("name1 == name4 => " +(name1==name4));
		System.out.println("name1 == name5 => " +(name1==name5));
		System.out.println("name5 == name6 => " +(name5==name6));
		sc.close();
	}

}
