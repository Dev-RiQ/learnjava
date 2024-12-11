package 조건문개념;

import java.util.Random;
//import java.util.Scanner;

public class _04랜덤 {

	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);
//		int input = sc.nextInt();
		
		Random rd = new Random();
		int randNum = rd.nextInt();
		double randDouble = rd.nextDouble();
		
		System.out.println(randNum);
		System.out.println(randDouble);
		
		randNum = rd.nextInt(3); // 0, 1, 2 (총 3개)
		System.out.println(randNum);
		
		randNum = rd.nextInt(3) + 1; // 1, 2, 3 (총 3개)
		System.out.println(randNum);
		
		randNum = rd.nextInt(7) - 3; 
		System.out.println(randNum);
		
		// rd.nextInt(끝값 - 시작값 + 1) + 시작값;
		
	}

}
