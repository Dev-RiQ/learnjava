package 반복문문제02;

public class _11학생수 {

	public static void main(String[] args) {

		/*
		 	a중학교에 1학년으로 입학하는 학생들은
		 	8줄, 12줄, 18줄로 세워도
		 	항상 5명이 남는다.
		 	1학년 전체 학생 수를 구하시오.
		 	단, 학생 수는 200명 이상 250명 미만이다.
		 */
		
		int i = 200;

		while (i <= 250) {
			if (i % 8 == 5 && i % 12 == 5 && i % 18 == 5) {
				System.out.println(i + "명");
			}
			i += 1;
		}
		
		
	}

}
