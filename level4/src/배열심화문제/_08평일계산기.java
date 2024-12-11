package 배열심화문제;

public class _08평일계산기 {

	public static void main(String[] args) {

		//10월 21일 부터 11월 20일 까지 평일 계산
		int[] monthList = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] weeks = { "월", "화", "수", "목", "금", "토", "일" };
		int startMonth = 12;
		int startDay = 1;
		int endMonth = 1;
		int endDay = 20;
		int week = 6;
		int cntDay7 = 0;
//		int cntDay5 = 0;
//		for (int i = startMonth - 1; i <= endMonth - 1; i++) {
//			if (i != startMonth - 1) {
//				startDay = 1;
//				if (i == endMonth - 1) {
//					monthList[i] = endDay;
//				}
//			}
//			for (int k = startDay; k <= monthList[i]; k++) {
//				cntDay7++;
//			}
//		}
//		for(int i = 1;i<cntDay7;i++) {
//			week += week != weeks.length - 1 ? 1 : -6;
//			if (week < 5) {
//				cntDay5++;
//			}
//		}
		
		
		
//		int monthRange = monthList.length;
//		if (startMonth < endMonth) {
//			monthRange = endMonth;
//		}
//		for (int k = startMonth - 1; k < monthRange; k++) {
//			if (monthRange == endMonth && k == monthRange - 1) {
//				monthList[k] = endDay;
//			}
//			for (int j = startDay; j <= monthList[k]; j++) {
//				cntDay7++;
//			}
//			if (k == monthRange - 1 && monthRange != endMonth) {
//				k = -1;
//				monthRange = endMonth;
//			}
//			startDay = 1;
//		}
//		for (int i = 0; i < cntDay7; i++) {
//			if (week < 5) {
//				cntDay5++;
//			}
//			if (i != cntDay7 - 1) {
//				week += week != weeks.length - 1 ? 1 : -6;
//			}
//		}
		
		cntDay7 = 1;
		int weekend = 0;
		
		while(!(startMonth==endMonth&&startDay==endDay)) {
			if(week>4) {
				weekend++;
			}
			cntDay7++;
			week += week != weeks.length - 1 ? 1 : -6;
			startDay++;
			if(startDay > monthList[startMonth-1]) {
				startMonth++;
				if(startMonth==monthList.length+1) {
					startMonth = 1;
				}
				startDay=1;
			}
		}
		
		
		System.out.println("디데이 " + cntDay7 + "일");
		System.out.printf("%d월 %d일 %s요일\n", endMonth, endDay, weeks[week]);
		cntDay7-=weekend;
		System.out.println("평일 " + cntDay7 + "일");
	}

}
