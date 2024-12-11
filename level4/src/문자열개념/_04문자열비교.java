package 문자열개념;

import java.util.Scanner;

public class _04문자열비교 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
					//	0 1	 2 3					//   0    1    2
		String myName = "이원규이이이이이이잉이"; // => String[] arr = {"이","원","규"};
		System.out.print(myName + " 입력 >> ");
		String inputName = sc.next();
		boolean isEqual = true;
		if (myName.length() != inputName.length()) {
			isEqual = false;
		} else {
			for (int i = 0; i < myName.length(); i++) {
				if (myName.charAt(i) != inputName.charAt(i)) {
					isEqual = false;
				}
			}
		}
		System.out.println(isEqual ? "이름이 같다" : "이름이 다르다");
		//를 줄여서 쓰면 아래 메서드
		System.out.println(myName.equals(inputName)?"이름이 같다" : "이름이 다르다");
		sc.close();
		
		
	}

}
