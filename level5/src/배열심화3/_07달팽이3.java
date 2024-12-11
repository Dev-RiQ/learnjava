package 배열심화3;

public class _07달팽이3 {

	public static void main(String[] args) {

		int size = 5;
		int[][] arr = new int[size][size];
		int num = 1;
		int min = 0;
		int max = size - 1;
		int numPlus = size - 1;
		int set = size - 1;
		while (num != size * size + 1) {
			for (int i = min; i < max; i++) {
				arr[min][i] = num;
				arr[i][max] = num+numPlus;
				arr[max][set-i] = num+numPlus*2;
				arr[set-i][min] = num+numPlus*3;
				num++;
			}
			if (size % 2 == 1 && max == size / 2) {
				arr[max][min] = num++;
			}
			min++;
			max--;
			num += numPlus*3;
			numPlus -= 2;
		}
		for (int i = 0; i < size; i++) {
			for (int k = 0; k < size; k++) {
				System.out.printf(" %2d ", arr[i][k]);
			}
			System.out.println();
		}
		
		
	}

}
