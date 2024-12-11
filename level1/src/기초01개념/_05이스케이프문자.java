package 기초01개념;

	/*
	 * 1. \n : 줄바꿈
	 * 2. \t : tab
	 * 3. \" : "
	 * 4. \' : '
	 */

//출력문의 종류
// System.out.println() : 자동으로 출력하고 띄어쓰기 한다.
// System.out.print() : 띄어쓰기 안한다 , 빈 값 허용 X
// System.out.printf() : 외부에서 값을 넣어서 출력, 자동 띄어쓰기 안함, 빈 값 허용 X

public class _05이스케이프문자 {

	public static void main(String[] args) {
		System.out.println(); // 한칸 띄어쓰기
		System.out.print(10+"\n");
		System.out.print("안녕하세요 \n");
		System.out.print("반갑습니다");
	}

}
