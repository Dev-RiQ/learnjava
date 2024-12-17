package level5시험;

public class _01 {

	public static void main(String[] args) {

		String data = "123+46";
//		String data = "123+46+1";
//		String data = "1+2+3+4+5";
		String regex = "+";
		char plus = regex.charAt(0);

		// 위 수의 합을 구하시오
		String sumStr = "";
		int sum = 0;
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == plus) {
				sum += Integer.parseInt(sumStr);
				sumStr = "";
				continue;
			}
			sumStr += data.charAt(i);
			System.out.println(sumStr);
		}
		sum += Integer.parseInt(sumStr);
		System.out.println(data + " = " + sum);

		// 소요 시간 : 6분 57초
		
		sumStr = "";
		sum = 0;
		int size = 1;
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == plus) {
				size++;
			}
		}
		String[] split = new String[size];
		int idx = 0;
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == plus) {
				idx++;
				continue;
			}
			if (split[idx] == null) {
				split[idx] = "";
			}
			split[idx] += data.charAt(i);
		}
		for (String add : split) {
			sum += Integer.parseInt(add);
		}
		System.out.println(data + " = " + sum);
	}
}
