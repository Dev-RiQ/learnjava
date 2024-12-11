package 배열심화3;

import java.util.Arrays;
import java.util.Scanner;

public class _04한칸씩밀기 {

	public static void main(String[] args) {

		// 동, 서, 남, 북 1칸씩 이동
		
		Scanner sc = new Scanner(System.in);
		String arr[][] = {
				{"○","☏","○","☏","○"},
				{"▦","■","▦","■","▦"},
				{"♬","★","♬","★","♬"}
		};
		while (true) {
			for (String[] show : arr) {
				System.out.println(Arrays.toString(show));
			}
			System.out.print("입력 (동/서/남/북, exit:종료) >> ");
			String input = sc.next();
			sc.nextLine();
			String tempEastWest;
			String[] tempSouthNorth;
			if (input.equals("exit")) {
				System.out.println("종료");
				break;
			}
			if (input.equals("동")) {
				for (int i = 0; i < arr.length; i++) {
					tempEastWest = arr[i][arr[i].length - 1];
					for (int k = arr[i].length - 1; k > 0; k--) {
						arr[i][k] = arr[i][k - 1];
					}
					arr[i][0] = tempEastWest;
				}
				System.out.println("동쪽으로 이동 완료");
			} else if (input.equals("서")) {
				for (int i = 0; i < arr.length; i++) {
					tempEastWest = arr[i][0];
					for (int k = 0; k < arr[i].length - 1; k++) {
						arr[i][k] = arr[i][k + 1];
					}
					arr[i][arr[i].length - 1] = tempEastWest;
				}
				System.out.println("서쪽으로 이동 완료");
			} else if (input.equals("남")) {
				tempSouthNorth = arr[arr.length - 1];
				for (int i = arr.length - 1; i > 0; i--) {
					arr[i] = arr[i - 1];
				}
				arr[0] = tempSouthNorth;
				System.out.println("남쪽으로 이동 완료");
			} else if (input.equals("북")) {
				tempSouthNorth = arr[0];
				for (int i = 0; i < arr.length - 1; i++) {
					arr[i] = arr[i + 1];
				}
				arr[arr.length - 1] = tempSouthNorth;
				System.out.println("북쪽으로 이동 완료");
			} else {
				System.out.println("입력오류");
			}
			System.out.println();
		}
		sc.close();
	}

}
