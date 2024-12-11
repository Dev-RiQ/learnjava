package _01;

public class _004 {

	
	public static void main(String[] args) {
		int rentalYear = 2024;
		int rentalMonth = 10;
		int rentalDay = 25;
		int nowYear = 2025;
		int nowMonth = 12;
		int nowDay = 06;
		int rentalPeriod = 10;
		dayBefore(rentalYear, rentalMonth, rentalDay, nowYear,nowMonth, nowDay, rentalPeriod);
	}
	public static void dayBefore(int a, int b, int c , int d, int e, int f ,int g) {
		int[] monthList = { 31, 28, 31, 30, 31, 31, 30, 31, 30, 31, 30, 31 };
		int day = 0;
		while (true) {
			c++;
			day++;
			if (c > monthList[b-1]) {
				c = 1;
				b++;
			}
			if (b > 12) {
				b = 1;
				a++;
			}
			if (a==d && b == e && c == f) {
				break;
			}
			
		}
		int dayDelay = day - g;
		System.out.printf("대여 %d일차, %d일째 연체중",day,dayDelay);
	}

}
