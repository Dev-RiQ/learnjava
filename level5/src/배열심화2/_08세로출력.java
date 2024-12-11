package 배열심화2;

public class _08세로출력 {

	public static void main(String[] args) {

		/*
		 	y 입력 된 값에 해당하는 col 출력
		 */
		int[][] data = {
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 3 },
				{ 0, 2, 0, 0, 3 },
				{ 3, 1, 3, 0, 1 },
				{ 1, 4, 2, 0, 2 },
				{ 4, 1, 4, 0, 4 },
				{ 2, 1, 4, 3, 3 }
		};
		int[] yList = { 1, 3, 2, 2, 0, 1 };
		for (int i = 0; i < yList.length; i++) {
			System.out.printf("yList[%d] = %d : ", i, yList[i]);
			for (int k = 0; k < data.length; k++) {
				System.out.print(data[k][yList[i]] + " ");
			}
			System.out.println();
		}
	}

}
//(1+1)*2+3*(4+2-(2+1))
// (2*((3+1)+(1+1))*(2+(6*2+(1+1))-10))