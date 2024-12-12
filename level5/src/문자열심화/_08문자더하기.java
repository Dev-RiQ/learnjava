package 문자열심화;

public class _08문자더하기 {

	public static void main(String[] args) {
		// int, long 안쓰고 합 구하기
//		String data1 = "1";
//		String data2 = "123456788";
//		String data1 = "100";
//		String data2 = "123456689";
//		String data1 = "1111";
//		String data2 = "1234";
//		String data1 = "876543212345678";
//		String data2 = "123456787654321";
//		String data1 = "9999999999999999";
//		String data2 = "9999999999999999";
		String data1 = "123456789123456";
		String data2 = "88888888888888";
		String[] datas1 = data1.split("");
		String[] datas2 = data2.split("");
		int max = datas1.length > datas2.length ? datas1.length : datas2.length;
		String[] sumDatas = new String[max + 1];
		String sumData = "";
		int i = datas1.length - 1;
		int k = datas2.length - 1;
		int idx = max;
		while (idx != -1) {
			int num1 = i < 0 ? 0 : Integer.parseInt(datas1[i--]);
			int num2 = k < 0 ? 0 : Integer.parseInt(datas2[k--]);
			int num3 = sumDatas[idx] == null ? 0 : Integer.parseInt(sumDatas[idx]);
			int sum = num1 + num2 + num3;
			if (sum > 9) {
				sum -= 10;
				sumDatas[idx - 1] = "1";
			}
			sumDatas[idx--] = sum + "";
		}
		idx = 0;
		for (; idx < max + 1; idx++) {
			if (idx == 0 && sumDatas[idx].equals("0")) {
				idx++;
			}
			sumData += sumDatas[idx];
		}
		System.out.println(sumData);
//		int[] datas1 = new int[data1.length()];
//		int[] datas2 = new int[data2.length()];
//		for(int i = 0;i<datas1.length;i++) {
//			datas1[i] = Integer.parseInt(data1.split("")[i]);
//		}
//		for(int i = 0;i<datas2.length;i++) {
//			datas2[i] = Integer.parseInt(data2.split("")[i]);
//		}
//		int max = datas1.length > datas2.length ? datas1.length : datas2.length;
//		int[] sumDatas = new int[max + 1];
//		String sumData = "";
//		int i = datas1.length - 1;
//		int k = datas2.length - 1;
//		int idx = max;
//		while (idx != -1) {
//			int num1 = i < 0 ? 0 : datas1[i--];
//			int num2 = k < 0 ? 0 : datas2[k--];
//			int sum = num1 + num2 + sumDatas[idx];
//			if (sum > 9) {
//				sum -= 10;
//				sumDatas[idx - 1] = 1;
//			}
//			sumDatas[idx--] = sum;
//		}
//		idx = 0;
//		for (; idx < max + 1; idx++) {
//			if (idx == 0 && sumDatas[idx] == 0) {
//				idx++;
//			}
//			sumData += sumDatas[idx] + "";
//		}
//		System.out.println(sumData);
	}

}
