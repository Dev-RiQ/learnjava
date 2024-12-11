package _01;

import java.util.Random;

public class _008확률 {
	public static int pIndex (String[] a, String b) {
		int index = -1;
		for(int i = 0;i<a.length;i++) {
			if(a[i].equals(b)) {
				index = i;
				break;
			}
		}
		return index;
	}
	public static double parseDouble(String a) {
		int idx = -1;
		int idxFirst = 0; 
		int temp = 0;
		int cnt = 0;
		for(int i = 0;i<a.length();i++) {
			if(a.charAt(i)>47&&a.charAt(i)<58) {
				temp += Integer.parseInt(a.substring(i,i+1))*Math.pow(10,a.length()-cnt);
				if(cnt == 0) {
					idxFirst = i;
				}
				cnt++;
			}
			if(a.charAt(i)==46) {
				idx = i;
			}
		}
		return temp*Math.pow(10,(idx-idxFirst))/10/Math.pow(10, a.length());
	}
	public static String p (double[] a, String[] b) {
		Random rd = new Random();
		int rdNum = rd.nextInt(1000000);
		int idx = 0;
		for(int i =0;i<a.length;i++) {
			double sum = 0;
			for(int k = 0;k<=i;k++) {
				sum += a[k]*10000;
			}
			if(rdNum<sum) {
				idx = i;
				break;
			}
		}
		return b[idx];
	}
	public static void test (double[] a, String[] b, int d) {
		double[] e = new double[a.length];
		String[] f = new String[a.length];
		for(int i = 0 ; i<d;i++) {
			for(int k = 0;k<e.length;k++) {
				String str = p(a,b);
				if(a[k] == parseDouble(str.substring(0,str.length()-1))) {
					e[k] ++;
				}
			}
		}
		System.out.print("설정 확률\t");
		System.out.print("실제 확률\t");
		System.out.println("오차율\t");
		for(int i =0;i<e.length;i++) {
			e[i] /= d*0.01;
			f[i] = e[i] + "%";
			System.out.printf("%9s \t",b[i]);
			System.out.printf("%9s \t",f[i]);
			System.out.printf("%8.4f",(e[i]-parseDouble(b[i]))/parseDouble(b[i]));
			System.out.println(" %");
		}
	}
	public static String[] changeDoubleAddPercent (double[] a) {
		String[] b = new String[a.length];
		for(int i = 0;i<a.length;i++) {
			b[i] = a[i]+"%";
		}
		return b;
	}
	public static double sumArr(double[] a) {
		int sum = 0;
		for(int i = 0 ; i<a.length;i++) {
			sum += a[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		double[] arr = {0.01,0.7,0.001,76.389,0.5,24.4};
		System.out.println(sumArr(arr));
		String[] arrStr = changeDoubleAddPercent(arr);
		String[] list = {"햄버거","피자","치킨","국밥","떡볶이","삼겹살"};
		int round = 1000000;
		String str = p(arr,list);
		System.out.println("이번에 뽑은것");
		System.out.println(str);
		System.out.println("이번에 뽑은것 확률");
		System.out.println(arrStr[pIndex(list, str)]);
		System.out.printf("    [%,d회 반복 확률 정확도 테스트]\n",round);
		test(arr,arrStr,round);
	}

}
