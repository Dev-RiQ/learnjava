package level5시험;


public class _03 {

	public static void main(String[] args) {
// 최종 (길이 줄이기)
		int[][] data = {
				{12300678},
				{12305678},
				{12345678},
				{4005},
				{230055},
				{1},
				{200}
		};
		String[] unit = { "십", "백", "천", "만" };
		for (int i = 0; i < data.length; i++) {
			String show = "";
			String temp = data[i][0] + "";
			int size = temp.length();
			int idx = size - 2;
			for (int k = 0; k < size; k++) {
				if (temp.charAt(k) != '0' || size - k > 4) {
					show += temp.charAt(k);
					if (idx < unit.length && k != size - 1) {
						show += unit[idx];
					}
				}
				idx--;
			}
			System.out.println(show);
		}
		
//	3차 수정 (중복 코드 병합)
//		int[][] data = {
//				{12300678},
//				{12305678},
//				{12345678},
//				{4005},
//				{230055},
//				{1},
//				{200}
//		};
//		String[][] dataPrint = new String[data.length][];
//		String[] unit = { "십", "백", "천", "만" };
//		int size, idx;
//		String temp;
//		String show = "";
//		for (int i = 0; i < data.length; i++) {
//			temp = data[i][0] + "";
//			size = temp.length();
//			dataPrint[i] = new String[size];
//			idx = size - 2;
//			for (int k = 0; k < size; k++) {
//				if (temp.charAt(k) != '0' || size - k > 4) {
//					show += temp.charAt(k);
//					if (idx < unit.length && k != size - 1) {
//						show += unit[idx];
//					}
//				}
//				idx--;
//			}
//			System.out.println(show);
//			show = "";
//		}
//		
		
//	2차 수정 (만단위 이상에서 0 출력)
//		int[][] data = {
//				{12300678},
//				{12305678},
//				{12345678},
//				{4005},
//				{230055},
//				{1},
//				{200}
//		};
//		String[][] dataPrint = new String[data.length][];
//		String[] unit = { "십", "백", "천", "만" };
//		int size, idx;
//		String temp;
//		String show = "";
//		for (int i = 0; i < data.length; i++) {
//			temp = data[i][0] + "";
//			size = temp.length();
//			dataPrint[i] = new String[size];
//			idx = size - 2;
//			for (int k = 0; k < size; k++) {
//				if (temp.charAt(k) != '0') {
//					show += temp.charAt(k);
//					if (idx < unit.length && k != size - 1) {
//						show += unit[idx];
//					}
//				} else {
//					if (size - k > 4) {
//						show += temp.charAt(k);
//						if (idx < unit.length && k != size - 1) {
//							show += unit[idx];
//						}
//					}
//				}
//
//				idx--;
//			}
//			System.out.println(show);
//			show = "";
//		}
//		
		
// 1차 수정 (만단위까지만)
//		int[][] data = {
//				{12345678},
//				{4005},
//				{230055},
//				{1},
//				{200}
//		};
//		String[][] dataPrint = new String[data.length][];
//		String[] unit = { "십", "백", "천", "만" };
//		int size, idx;
//		String temp;
//		String show = "";
//		for (int i = 0; i < data.length; i++) {
//			temp = data[i][0] + "";
//			size = temp.length();
//			dataPrint[i] = new String[size];
//			idx = size - 2;
//			for (int k = 0; k < size; k++) {
//				if (temp.charAt(k) != '0') {
//					show += temp.charAt(k);
//					if (idx < unit.length && k != size - 1) {
//						show += unit[idx];
//					}
//				}
//				idx--;
//			}
//			System.out.println(show);
//			show = "";
//		}
//		
		
		
// 초안
//		int[][] data = {
//				{12345678},
//				{4005},
//				{230055},
//				{1},
//				{200}
//		};
//		String[][] dataPrint = new String[data.length][];
//		String[] unit1 = { "십", "백", "천" };
//		String[] unit2 = { "만", "억", "조", "경" };
//		int size, idx1, idx2;
//		String temp;
//		String show = "";
//		for (int i = 0; i < data.length; i++) {
//			temp = data[i][0] + "";
//			size = temp.length();
//			dataPrint[i] = new String[size];
//			for (int k = 0; k < dataPrint[i].length; k++) {
//				idx1 = -1;
//				idx2 = -1;
//				dataPrint[i][k] = temp.charAt(k) + "";
//				switch ((size - 1 - k) % 4) {
//				case 1:
//					idx1 = 0;
//					break;
//				case 2:
//					idx1 = 1;
//					break;
//				case 3:
//					idx1 = 2;
//					break;
//				}
//				switch ((size - 1 - k) / 4) {
//				case 1:
//					idx2 = 0;
//					break;
//				case 2:
//					idx2 = 1;
//					break;
//				case 3:
//					idx2 = 2;
//					break;
//				case 4:
//					idx2 = 3;
//					break;
//				}
//				if (temp.charAt(k) != '0') {
//					if (idx1 != -1 &&  (size - 1 - k) < 5) {
//						dataPrint[i][k] += unit1[idx1];
//					}
//					if (idx2 != -1 && (size - 1 - k) % 4 == 0) {
//						dataPrint[i][k] += unit2[idx2];
//					}
//					show += dataPrint[i][k];
//				}
//
//			}
//			System.out.println(show);
//			show = "";
//		}
		
		// 소요 시간 : 24분 06초
	}

}
