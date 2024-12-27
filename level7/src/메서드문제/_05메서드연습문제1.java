package 메서드문제;

import java.util.Arrays;

class Return1 {

	int[] integerData;
	int[] passList;
	int countPassStudent;
	boolean isError;

	void setArrayFromStringToInteger(String[] data) {
		integerData = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			integerData[i] = Integer.parseInt(data[i]);
			if (integerData[i] < 0 || integerData[i] > 100) {
				isError = true;
				integerData[i] = -1;
			}
		}
	}

	void setCountPassStudent() {
		for (int p : integerData)
			if (p >= 60)
				countPassStudent++;
	}

	void setPassList() {
		passList = new int[countPassStudent];
		int idx = 0;
		for (int p : integerData)
			if (p >= 60)
				passList[idx++] = p;
	}

	int[] getResult(String[] data) {
		setArrayFromStringToInteger(data);
		if (isError) {
			System.out.println("0~100 범위를 벗어나는 입력이 있습니다.");
			System.out.println("데이터를 확인해 주십시오.");
		}
		setCountPassStudent();
		setPassList();

		return passList;
	}
}

public class _05메서드연습문제1 {

	public static void main(String[] args) {

		Return1 re = new Return1();

		String[] data = { "34", "43", "76", "12", "64" };
		int[] result = re.getResult(data);
		System.out.println(Arrays.toString(result));
	}

}
