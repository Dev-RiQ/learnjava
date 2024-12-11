package _레벨3시험;

public class _10문제 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		item배열은 상품의 번호이다
		 		price배열은 상품의 가격이다
		 		order배열은 오늘 주문이 들어온 상품의 인덱스 번호이다
		 		count배열은 order에서 주문한 상품들의 개수이다
		 		오늘의 매출을 출력하시오
		 */
//		int[] item = { 1001, 1002, 1003, 1004 };
		int[] price = { 500, 1200, 4300, 2300 };
		int[] order = { 0, 1, 3, 3, 2, 2, 1 };
		int[] count = { 3, 2, 2, 1, 3, 4, 3 };
		int priceTotal = 0;
		for (int i = 0; i < order.length; i++) {
			priceTotal += price[order[i]] * count[i];
		}
		System.out.println(priceTotal + "원");
		// 소요 시간 : 3분 00초
	}

}
