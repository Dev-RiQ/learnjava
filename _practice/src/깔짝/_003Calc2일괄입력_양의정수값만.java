package 깔짝;

import java.util.Arrays;
import java.util.Scanner;

public class _003Calc2일괄입력_양의정수값만 {
	public static String[] res(int i, int i2, String[] a, int[] w, int b) {
		int c = 0;
		int d = 0;
		char e = '0';
		int rs = 0;
		String[] temp = new String[a.length];
		temp = a;
		int[] tempW = new int[w.length];
		tempW = w;
		int cnt = 0;
		int idx = -1;
		if (i2 == -1) {
			i2 = i;
		}
		if (b > 10) {
			for (int k = i + 1; k < i2; k++) {
				if (tempW[k] == b - 10) {
					i = k;
					break;
				}
			}
			for (int k = i + 1; k < i2; k++) {
				if (k != i && tempW[k] == b - 10) {
					i2 = k;
					break;
				}
			}
		}
		boolean isNon = true;
		for (int k = i; k <= i2; k++) {
			if (tempW[k] == 1) {
				isNon = false;
				idx = k;
				break;
			}
		}
		for (int k = i; k <= i2; k++) {
			if (!isNon) {
				k = idx;
			}
			if (temp[k] == null) {
				continue;
			}
			if (temp[k].charAt(0) == '/' || temp[k].charAt(0) == '*' || temp[k].charAt(0) == '+'
					|| temp[k].charAt(0) == '-') {
				e = temp[k].charAt(0);
				for (int j = k - 1;; j--) {
					if (temp[j] != null && temp[j].charAt(0) > 47 && temp[j].charAt(0) < 58) {
						c = Integer.parseInt(temp[j]);
						temp[j] = null;
						tempW[j] = 100;
						break;
					}
				}
				for (int j = k + 1;; j++) {
					if (temp[j] != null && temp[j].charAt(0) > 47 && temp[j].charAt(0) < 58) {
						d = Integer.parseInt(temp[j]);
						temp[j] = null;
						tempW[j] = 100;
						break;
					}
				}
				// (11*(1+2))*2+12/3-2*(1*2+1)
				rs = calc(c, d, e);
				temp[k] = rs + "";
				if (!isNon) {
					tempW[k] = 0;
					break;
				} else {
					tempW[k] = 100;
				}
			}
			if (k == i2) {
				for (int j = i; j <= i2; j++) {
					if (tempW[j] == 100) {
						cnt++;
					}
				}
				if (cnt == i2 - i - 2) {
					temp[i] = null;
					temp[i2] = null;
				}
			}
		}
		return temp;
	}

	public static int[] resRank(String[] a, int[] b, int c) {
		int[] temp = b;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == null) {
				temp[i] = 100;
			}
			if (temp[i] == 100 && a[i] != null) {
				temp[i] = 0;
			}
		}
		return temp;
	}

	public static int calc(int a, int b, char c) {
		int d = 0;
		if (c == '/') {
			d = div(a, b);
		} else if (c == '+') {
			d = sum(a, b);
		} else if (c == '-') {
			d = min(a, b);
		} else if (c == '*') {
			d = mul(a, b);
		}
		return d;
	}

	public static int sum(int a, int b) {
		return a + b;
	}

	public static int min(int a, int b) {
		return a - b;
	}

	public static int mul(int a, int b) {
		return a * b;
	}

	public static int div(int a, int b) {
		return a / b;
	}

	public static String[] get(String[] a, int b) {
		String[] temp = new String[b];
		int idx = 0;
		for (int i = 0; i < a.length - 1; i++) {
			temp[idx] = a[i];
			while (true) {
				if (a[i].charAt(0) > 47 && a[i].charAt(0) < 58 && a[i + 1].charAt(0) > 47 && a[i + 1].charAt(0) < 58) {
					temp[idx] += a[++i];
					continue;
				}
				break;
			}
			idx++;
		}
		if (temp[b - 1] == null) {
			temp[b - 1] = a[a.length - 1];
		}
		return temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("입력 >> ");
			String input = sc.nextLine();
			String delBlank = input.replace(" ", "");
			String[] temp = delBlank.split("");
			int cnt = 1;
			for (int i = 0; i < temp.length - 1; i++) {
				if (temp[i].charAt(0) > 47 && temp[i].charAt(0) < 58 && temp[i + 1].charAt(0) > 47
						&& temp[i + 1].charAt(0) < 58) {
					continue;
				}
				cnt++;
			}
			// 항목 별 정리
			String[] set = new String[cnt];
			set = get(temp, cnt);
			System.out.println(Arrays.toString(set));
			// 계산 우선순위 지정
			int[] rank = new int[set.length];
			cnt = 0;
			for (int i = 0; i < set.length; i++) {
				if (set[i].charAt(0) == '*' || set[i].charAt(0) == '/') {
					rank[i] = 1;
				} else if (set[i].charAt(0) == '(' || set[i].charAt(0) == ')') {
					if (set[i].charAt(0) == '(') {
						cnt++;
					}
					rank[i] += 10 * cnt;
					if (set[i].charAt(0) == ')') {
						cnt--;
					}
				}
			}
			System.out.println(Arrays.toString(rank));
			// 우선순위따라 계산
			int idx = 0;
			for (int i = 0; i < rank.length; i++) {
				int max = -1;
				for (int k = 0; k < rank.length; k++) {
					if (max < rank[k] && rank[k] != 100) {
						max = rank[k];
					}
				}
				if (rank[i] == max) {
					idx = -1;
					int idx2 = -1;
					for (int k = 0; k < rank.length; k++) {
						if (rank[k] == max) {
							max = rank[k];
							idx = k;
							break;
						}
					}
					for (int k = 0; k < rank.length; k++) {
						if (k != idx && rank[k] == max) {
							idx2 = k;
							break;
						}
					}
					set = res(idx, idx2, set, rank, max);
					rank = resRank(set, rank, max);
					String[] tempS = set;
					int[] tempR = rank;
					cnt = 0;
					for (int k = 0; k < set.length; k++) {
						if (set[k] == null) {
							cnt++;
						}
					}
					set = new String[set.length - cnt];
					idx = 0;
					for (int k = 0; k < tempS.length; k++) {
						if (tempS[k] != null) {
							set[idx++] = tempS[k];
						}
					}

					cnt = 0;
					for (int k = 0; k < rank.length; k++) {
						if (rank[k] == 100) {
							cnt++;
						}
					}
					rank = new int[rank.length - cnt];
					idx = 0;
					for (int k = 0; k < tempR.length; k++) {
						if (tempR[k] != 100) {
							rank[idx++] = tempR[k];
						}
					}
					i = -1;
				}
				System.out.println(Arrays.toString(set));
				System.out.println(Arrays.toString(rank));
				if (set.length == 1) {
					break;
				}
			}
			System.out.println("정답 = " + set[0]);
			break;
		}
		sc.close();
	}
}
