package 클래스배열_기본;

import java.util.Arrays;

class Student{
	int number;
	String id;
	String pw;
	String name;
	int score;
}

public class _01클배이론01 {

	public static void main(String[] args) {

		Student s1 = new Student();
		
		String data = "1001/qwer/1234/김철수/45";
		String[] info = data.split("/");
		System.out.println(Arrays.toString(info));
		
		s1.number = Integer.parseInt(info[0]);
		s1.id = info[1];
		s1.pw = info[2];
		s1.name = info[3];
		s1.score = Integer.parseInt(info[4]);
		
		data = "1002/abcd/4321/김영희/87";
		info = data.split("/");
		
		Student s2 = new Student();
		
		s2.number = Integer.parseInt(info[0]);
		s2.id = info[1];
		s2.pw = info[2];
		s2.name = info[3];
		s2.score = Integer.parseInt(info[4]);
		
		System.out.println(s1.name);
		System.out.println(s2.name);
		
		int[] arr = {10,20,30,40}; // int 값만 들어감
		
		Student[] stList = new Student[2]; // {null,null};
		// 아직 객체 만들지 않음 (방만 생성)
		stList[0] = new Student();
		stList[1] = s1;
		int darr[][] = new int[2][]; // {null,null};
		// 클래스 배열은 이차원 배열과 비슷하다
		darr[0] = arr;
	}

}
