package 반복문문제02;

public class _04학생구슬 {

	public static void main(String[] args) {

		/*
		 	파란구슬 50개와 빨간구슬 70개를 최대한 많은 학생들에게 똑같이 나누어 주려고 한다.
		 	파란구슬은 5개가 남고, 빨간구슬은 2개가 부족할 때 다음 물음에 답하시오.
		 	1. 학생수?
		 	2. 한명당 빨간구슬 개수
		 	3. 한명당 파란구슬 개수
		 */
		
		int i = 1;
		int stuCnt = 0;
		int redCnt = 70;
		int blueCnt = 50;
		int redLeftCnt = -2;
		int blueLeftCnt = 5;

		while (i <= blueCnt) {
			if ((redCnt - redLeftCnt) % i == 0 && (blueCnt - blueLeftCnt) % i == 0) {
				stuCnt = i;
			}
			i += 1;
		}
		int redCntPer1 = redCnt / stuCnt;
		int blueCntPer1 = blueCnt / stuCnt;
		System.out.println("학생수 : " + stuCnt);
		System.out.println("한 명당 빨간 구슬 : " + redCntPer1 + "개");
		System.out.println("한 명당 파란 구슬 : " + blueCntPer1 + "개");
	}

}
