package 배열심화3;

public class _07달팽이1 {

	public static void main(String[] args) {

		int size = 5;
		int[][] arr = new int[size][size];
		int num = 1;
		int cnt = 0;
		int temp1 = size - 1;
		int temp2 = size - 1;
		while (true) {
			for (int i = cnt; i <= temp1; i++) {
				arr[cnt][i] = num++;
			}
			for (int i = cnt + 1; i <= temp2; i++) {
				arr[i][temp1] = num++;
			}
			for (int i = --temp1; i >= cnt; i--) {
				arr[temp2][i] = num++;
			}
			for (int i = --temp2; i >= cnt + 1; i--) {
				arr[i][cnt] = num++;
			}
			cnt++;
			if (cnt == (size + 1) / 2) {
				break;

			}
		}
		for (int i = 0; i < size; i++) {
			for (int k = 0; k < size; k++) {
				System.out.printf(" %2d ", arr[i][k]);
			}
			System.out.println();
		}
		
		
	}

}
