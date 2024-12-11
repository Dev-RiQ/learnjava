package 깔짝;

import java.util.Scanner;

public class _002Calc개별입력 {

	public static int sum(int a, int b) {
		return a + b;
	}

	public static int min(int a, int b) {
		return a - b;
	}

	public static int mul(int a, int b) {
		return a * b;
	}

	public static double div(int a, int b) {
		return a / b;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int calc = 0;
		String input = "";
		int cnt = 0;
		double rs = 0;
		String save = "";
		while (true) {
			System.out.print("입력 >> ");
			input = sc.next();
			save += input + " ";
			if (input.equals("=")) {
				System.out.println(save);
				System.out.println("답 : " + rs);
				break;
			}
			if (input.charAt(0) < 58 && input.charAt(0) > 47) {
				if (cnt % 2 == 0) {
					a = Integer.parseInt(input);
				} else {
					b = Integer.parseInt(input);
				}
				if (cnt != 0) {
					if (cnt % 2 == 0) {
						c = b;
						d = a;
					} else {
						c = a;
						d = b;
					}
					if (calc == 42) {
						rs = mul(c, d);
					} else if (calc == 43) {
						rs = sum(c, d);
					} else if (calc == 45) {
						rs = min(c, d);
					} else if (calc == 47) {
						rs = div(c, d);
					}
					if (cnt % 2 == 0) {
						a = (int) rs;
					} else {
						b = (int) rs;
					}
				}
				cnt++;
				continue;
			} else if (input.charAt(0) == 42) { // *
				calc = 42;
				continue;
			} else if (input.charAt(0) == 43) { // +
				calc = 43;
				continue;
			} else if (input.charAt(0) == 45) { // -
				calc = 45;
				continue;
			} else if (input.charAt(0) == 47) { // /
				calc = 47;
				continue;
			}
		}
		sc.close();

	}
}
