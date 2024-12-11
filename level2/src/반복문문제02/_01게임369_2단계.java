package 반복문문제02;

public class _01게임369_2단계 {

	public static void main(String[] args) {

		/*
		 	1. 1~50까지 반복
		 	2. 3, 6, 9 하나 당 "짝" 출력
		 	3. 없으면 숫자 출력
		 */
		
		int i = 1;
		int max = 50;

		while (i <= max) {
			boolean rs1 = i % 10 % 3 == 0 && i % 10 != 0;
			boolean rs10 = i / 10 % 3 == 0 && i / 10 != 0;
			if (rs10 && rs1) {
				System.out.print("짝짝 ");
			} else if (rs10 || rs1) {
				System.out.print("짝 ");
			} else {
				System.out.print(i + " ");
			}
			if (i % 5 == 0) {
				System.out.println();
			}
			i += 1;
		}
		System.out.println("====================");
		i = 1;
		while( i<= max) {
			
			int pos10 = i / 10;
			int pos1 = i % 10;
			int cnt = 0;
			if(pos10 % 3 == 0 && pos10 != 0) {
				cnt +=1;
			}
			if(pos1%3==0&&pos1!=0) {
				cnt +=1;
			}
			if(cnt ==2) {
				System.out.print("짝짝 ");
			}else if(cnt ==1) {
				System.out.print("짝 ");
			}else {
				System.out.print(i + " ");
			}
			if (i%5==0) {
				System.out.println();
			}
			i+=1;
		}
	}

}
