package 배열심화문제;

public class _07기념일 {

	public static void main(String[] args) {

		/*
		 	철수와 영희는 3월 3일에 만났다. 철수는 영희와 100일 기념일에 축하파티를 하려고 한다
		 	만난지 100일 뒤는 몇월 몇일인지 구하시오.  (윤년 고려, 년단위 출력 포함)
		 */
		int[] monthList = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] weeks = { "월", "화", "수", "목", "금", "토", "일" };
		int year = 2024;
		int month = 3;
		int day = 3;
		int dDay = 4442;
		int dayCalc = day + dDay;
		int monthCalc = monthList.length;
		int yearCalc = year;
		int week = 6;
		for (int i = month - 1; i < monthCalc; i++) {
			monthList[1] = yearCalc % 4 == 0 ? 29 : 28;
			if (dayCalc > monthList[i]) {
				dayCalc -= monthList[i];
				if (i == monthList.length - 1) {
					i = -1;
					yearCalc++;
				}
			} else {
				monthCalc = i + 1;
			}
		}
		for(int i = 0;i<dDay;i++) {
			week += week != weeks.length - 1 ? 1 : -6;
		}
		System.out.printf("%d일 뒤는 %d년 %d월 %d일 (%s요일)\n", dDay, yearCalc, monthCalc, dayCalc,weeks[week]);
		//지정 날짜까지 몇일 남았는지
		int yearToday = 2024;
		int monthToday = 11;
		int dayToday = 20;
		week = 2;
		int yearTarget = 2025;
		int monthTarget = 1;
		int dayTarget = 1;
		int monthRange = monthList.length;
		dDay = 0;
		for (int i = yearToday - 1; i < yearTarget; i++) {
			monthList[1] = (i-1) % 4 == 0 ? 29 : 28;
			if(i!=yearToday-1) {
				monthToday = 1;
			}
			if(i==yearTarget-1) {
				monthRange = monthTarget;
			}
			for(int k =monthToday-1;k<monthRange;k++) {
				if(k!=monthToday-1) {
					dayToday = 0;
				}
				if(k == monthRange-1 && i==yearTarget-1) {
					monthList[k] = dayTarget;
				}
				for(int j=dayToday+1;j<=monthList[k];j++) {
					dDay++;
					week += week != weeks.length - 1 ? 1 : -6;
				}
			}
		}
		System.out.printf("%d년 %d월 %d일 (%s요일)까지 D-%d", yearTarget, monthTarget, dayTarget,weeks[week],dDay);
	}

}
