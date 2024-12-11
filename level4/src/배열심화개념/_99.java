package 배열심화개념;

import java.util.Random;

public class _99 {

	public static void main(String[] args) {

		Random rd = new Random();
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		int cnt4 = 0;
		int cnt5 = 0;
		int cnt6 = 0;
		int cnt7 = 0;
		int cnt8 = 0;
		int cnt9 = 0;
		int cnt10 = 0;
		int total = 10000000;
		for(int i = 0; i < total ; i++) {
			int num = rd.nextInt(1000000)+1;
			if(num<11) { // 0.001
				num=1;
			}else if(num<101){ // 0.009
				num = 2;
			}else if(num<1001) { // 0.09
				num=3;
			}else if(num<10001) { // 0.9
				num=4;
			}else if(num<30001) { // 2
				num = 5;
			}else if(num<80001) { // 5
				num = 6;
			}else if(num<150001) { // 7
				num = 7;
			}else if(num<400001) { //25
				num = 8;
			}else if(num<1000000) { // 60
				num = 9;
			}else { // 0.0001
				num = 10;
			}
			switch(num) {
			case 1: cnt1++; break;
			case 2: cnt2++; break;
			case 3: cnt3++; break;
			case 4: cnt4++; break;
			case 5: cnt5++; break;
			case 6: cnt6++; break;
			case 7: cnt7++; break;
			case 8: cnt8++; break;
			case 9: cnt9++; break;
			case 10: cnt10++; break;
			}
		}
		System.out.printf("cnt1 = %.4f \n",(double)(cnt1*1.0/total*100));
		System.out.printf("cnt2 = %.4f \n",(double)(cnt2*1.0/total*100));
		System.out.printf("cnt3 = %.4f \n",(double)(cnt3*1.0/total*100));
		System.out.printf("cnt4 = %.4f \n",(double)(cnt4*1.0/total*100));
		System.out.printf("cnt5 = %.4f \n",(double)(cnt5*1.0/total*100));
		System.out.printf("cnt6 = %.4f \n",(double)(cnt6*1.0/total*100));
		System.out.printf("cnt7 = %.4f \n",(double)(cnt7*1.0/total*100));
		System.out.printf("cnt8 = %.4f \n",(double)(cnt8*1.0/total*100));
		System.out.printf("cnt9 = %.4f \n",(double)(cnt9*1.0/total*100));
		System.out.printf("cnt10 = %.4f \n",(double)(cnt10*1.0/total*100));
		
		
	}

}
