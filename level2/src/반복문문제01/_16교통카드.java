package 반복문문제01;

public class _16교통카드 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		선호네 반 학생 25명이 체험학습을 하러 가기 위해
		 		버스를 탔는데 총 요금이 19400원이었다.
		 		교통카드 720원
		 		현금 1000원일때
		 		학생수 각각
		 */
		
		int cash = 1000;
		int card = 720;
		int studentCash = 0;
		int studentCard = 25;
		int total = 19400;
		
//		while(true) {
//			if(total == cash * studentCash + card * studentCard) {
//				break;
//			}
//			studentCard-=1;
//			studentCash+=1;
//		}
//		
		while(total != cash * studentCash + card * studentCard) {
			studentCard-=1;
			studentCash+=1;
		}
		System.out.println(studentCard);
		System.out.println(studentCash);
		
//		while (i <= 25) {
//			studentCash = i;
//			studentCard = 25-i;
//			int total = cash * studentCash + card * studentCard;
//			if (total == 19400) {
//				System.out.println("교통카드 : " + studentCard + "명");
//				System.out.println("현금 : " + studentCash + "명");
//			}
//			i += 1;
//		}
//		
//		studentCash = 25;
//		studentCard = 0;
//		i=1;
//		while (i <= 25) {
//			studentCash -= 1;
//			studentCard += 1;
//			int total = cash * studentCash + card * studentCard;
//			if (total == 19400) {
//				System.out.println("교통카드 : " + studentCard + "명");
//				System.out.println("현금 : " + studentCash + "명");
//			}
//			i += 1;
//		}

	}

}
