package 조건문문제;

public class _14도화지 {

	public static void main(String[] args) {
		
		/*
        [문제]
            민수네 반 학생은 26명이다.
            민수네반 학생들에게 도화지를 두 장씩 나누어 주려고 한다.
            도화지는 열장씩 묶음으로만 판매하고 열장에 1200원이다.
            총 얼마가 필요한지 구하시오.
        [정답]
            7200원
    */
		
		int student = 26;
		int paperShareCnt = 2;
		int paperBuy = student * paperShareCnt;
		int paperPricePer10 = 1200;
		int paperSet = 10;
		int paperSetBuy = paperBuy / paperSet;
		
		if (paperBuy % 10 != 0) {
			paperSetBuy += 1;
		}
		
		int money = paperSetBuy * paperPricePer10;
		System.out.println(money + "원");
		
	}

}
