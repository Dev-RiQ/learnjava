package 문자열개념;

public class _01문자열개념 {

	public static void main(String[] args) {

		char[] name1 = {'박','연','미'}; //48120
		String name2 = "박연미"; // Scanner, Random class => 기능(메서드)으로 접근해서 사용
		System.out.println(name1[2]);
		for(int i = 0;i<3;i++) {
			System.out.print(name1[i]);
		}
		
		for(int i = 0;i<3;i++) {
			System.out.print(name2.charAt(i)); // .charAt()  =>  method
		}
		
		//배열은 부분 수정 가능
		name1[1] = '영';
		System.out.println(name1);
		//문자열은 통으로 수정
		name2 = "박영미"; //=> 읽기 전용 배열
		System.out.println(name2);
//		
	}

}
