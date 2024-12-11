package _level2시험;

public class _02문제 {

	public static void main(String[] args) {

		/*
		   [문제]
		  		자전거는 1분에 4칼로리가 소모되고
		  		줄넘기는 1분에 9칼로리가 소모된다.
		  		
		  		철수는 90분 동안 505 칼로리를 소모했다.
		  		철수가 각 운동에서 사용한 시간은 각각 얼마인지 구하시오. (반복문)
		 */
		
		/*
		 	자전거 = x(시간) = i
		 	줄넘기 = y(시간) = 90 - i
		 	x+y = 90 => y = 90 -x
		 	4x + 9y = 505
		 	
		 	
		 	x<= 1~90
		 	x0 y90
		 	x1 y89
		 	x2 y88
		 	...
		 	x90 y0
		 	
		 	x = 61, y = 29
		 */
		
		int bike = 0;
		int line = 0;
		while (true) {
			if (bike* 4 + line * 9 == 505) {
				break;
			}
			bike += 1;
			line = 90 -bike;
		}
		System.out.println("자전거 = " + bike + "분");
		System.out.println("줄넘기 = " + line + "분");
		
		
		//소요 시간 : 3분 12초
	}

}
