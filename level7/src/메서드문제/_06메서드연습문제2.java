package 메서드문제;

import java.util.Arrays;

class Return2 {

	int[][] integerData;
	int countPassStudents;
	int[] passStudentNumbers;

	void setDataFromStringToInteger(String[][] data) {
		integerData = new int[data.length][data[0].length];
		for (int i = 0; i < data.length; i++)
			for (int k = 0; k < data[i].length; k++)
				integerData[i][k] = Integer.parseInt(data[i][k]);
	}

	void setCountPassStudents() {
		for (int i = 0; i < integerData.length; i++)
			if (integerData[i][1] >= 60)
				countPassStudents++;
	}

	void setPassStudentNumbers() {
		passStudentNumbers = new int[countPassStudents];
		int idx = 0;
		for (int i = 0; i < integerData.length; i++)
			if (integerData[i][1] >= 60)
				passStudentNumbers[idx++] = integerData[i][0];
	}

	int[] getPassStudents(String[][] data) {
		setDataFromStringToInteger(data);
		setCountPassStudents();
		setPassStudentNumbers();
		return passStudentNumbers;
	}
}

public class _06메서드연습문제2 {

	public static void main(String[] args) {

		Return2 re = new Return2();

		String[][] data = {
				{"1001","34"},
				{"1002","46"},
				{"1003","81"},
				{"1004","10"}
		};

		int[] result = re.getPassStudents(data);
		System.out.println(Arrays.toString(result));
	}

}
