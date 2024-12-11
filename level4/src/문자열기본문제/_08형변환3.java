package 문자열기본문제;

public class _08형변환3 {

	public static void main(String[] args) {

		// 이름과 성적을 아래와 같이 하나의 문자열로 연결
		
		String[] name = { "김철수", "이만수", "이영희" };
		int[] score = { 87, 42, 95 };

		String str = "";
		for (int i = 0; i < name.length; i++) {
			str += i == 0 ? name[i] + "/" + score[i] : "," + name[i] + "/" + score[i];
		}
		System.out.println(str);
		
	}

}
