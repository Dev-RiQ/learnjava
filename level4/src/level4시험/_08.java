package level4시험;

public class _08 {

	public static void main(String[] args) {

		String[][] student = {
				{"1001","이만수","남","100","40"},
				{"1002","이영희","여","70","30"},
				{"1003","김민정","여","64","15"},
				{"1004","이철민","남","53","87"},
				{"1005","오만석","남","49","80"},
				{"1006","최이슬","여","14","90"},
		};
		double[] avg = new double[student.length];
		int sumM = 0;
		int sumF = 0;
		double max = 0;
		for (int i = 0; i < student.length; i++) {
			for (int k = 0; k < student[i].length; k++) {
				if (k > 2) {
					avg[i] += Integer.parseInt(student[i][k]) * 1.0 / 2;
				}
			}

			if (student[i][2].equals("남")) {
				sumM += avg[i] * 2;
			} else {
				sumF += avg[i] * 2;
			}
			if (avg[i] > max) {
				max = avg[i];
			}
		}
		// 여학생들 점수 총합과 남학생들 점수 총합 비교해 큰 값
		System.out.println("남/여 점수 총합 큰쪽?");
		System.out.println(sumM > sumF ? "남 = " + sumM + "점" : "여 = " + sumF + "점");
		System.out.println();
		// 평균 60 이상 합격생 번호,이름,점수
		System.out.println("평균 60 이상?");
		for (int i = 0; i < avg.length; i++) {
			if (avg[i] >= 60) {
				System.out.printf("%s번 = %s, %.1f점 \n", student[i][0], student[i][1], avg[i]);
			}
		}
		System.out.println();
		// 국어점수가 수학점수보다 큰 학생 번호,이름
		System.out.println("국어점수 > 수학점수 ?");
		for (int i = 0; i < avg.length; i++) {
			if (Integer.parseInt(student[i][3]) > Integer.parseInt(student[i][4])) {
				System.out.printf("%s번 = %s \n", student[i][0], student[i][1]);
			}
		}
		System.out.println();
		// 1등 번호,이름(여러명이면 전부출력)
		System.out.println("1등?");
		for (int i = 0; i < avg.length; i++) {
			if (avg[i] == max) {
				System.out.printf("%s번 = %s \n", student[i][0], student[i][1]);
			}
		}
		// 소요 시간 : 19분 51초
		
	}

}
