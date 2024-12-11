package 이차원반복문;

public class _03삼각형그리기 {

	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			for (int k = 0; k <= i; k++) {
				System.out.print("#");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int k = i; k < 3; k++) {
				System.out.print("#");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				if (k <= i) {
					System.out.print("@");
				} else {
					System.out.print("#");
				}
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 5; k++) {
				if (k > i + 2 || k < 2 - i) {
					System.out.print(" ");
				} else {
					System.out.print("#");
				}
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				if (k > i) {
					System.out.print(" ");
				} 
			}
			for(int k = 0; k<i*2+1;k++){
					System.out.print("#");
			}
			System.out.println();
		}
		
	}

}
