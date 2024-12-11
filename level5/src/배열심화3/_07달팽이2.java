package 배열심화3;

public class _07달팽이2 {

	public static void main(String[] args) {

		int size = 5;
		int[][] arr = new int[size][size];
		int num = 1;
		int min = 0;
		int max = size - 1;
		while (num != size * size + 1) {
			for (int i = min; i < max; i++) {
				arr[min][i] = num++;
			}
			for (int i = min; i < max; i++) {
				arr[i][max] = num++;
			}
			for (int i = max; i > min; i--) {
				arr[max][i] = num++;
			}
			for (int i = max; i > min; i--) {
				arr[i][min] = num++;
			}
			if (size % 2 == 1 && max == size / 2) {
				arr[max][min] = num++;
			}
			min++;
			max--;
		}
		for (int i = 0; i < size; i++) {
			for (int k = 0; k < size; k++) {
				System.out.printf(" %2d ", arr[i][k]);
			}
			System.out.println();
		}        
		
		
	}

}
