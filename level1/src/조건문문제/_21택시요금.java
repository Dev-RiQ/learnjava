package 조건문문제;

import java.util.Scanner;

public class _21택시요금 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		택시 기본요금은 10000원이다.
		 		기본 요금으로 10km까지 이동할 수 있다.
		 		10km 이상 이동 시 추가요금이 발생한다.
		 		추가요금은 3km를 이동할 때마다 2300원씩 요금이 추가된다.
		 		이동거리를 입력받고 요금을 출력하시오.
		 */
		
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("총 이동거리 >> ");
//		int distance = sc.nextInt();
//		int distanceBasic = 10;
//		int distanceAdd = 0;
//		int feeBasic = 10000;
//		int feeAdd = 2300;
//		int feeTotal = 0;
//		
//		if (distance >= distanceBasic && (distance - distanceBasic)%3 != 0) {
//			distanceAdd = (distance-distanceBasic)/3 + 1;
//			feeTotal = (feeBasic + distanceAdd * feeAdd); 
//			System.out.println("요금은 " + feeTotal + "원 입니다.");
//		}else if ((distance - distanceBasic)%3 == 0) {
//			distanceAdd = (distance-distanceBasic)/3;
//			feeTotal = (feeBasic + distanceAdd * feeAdd); 
//			System.out.println("요금은 " + feeTotal + "원 입니다.");
//		}else {
//			System.out.println("요금은 " + feeBasic + "원 입니다.");
//		}

		System.out.print("총 이동거리 >> ");
		int dis = sc.nextInt();
		int disBasic = 10;
		int disAdd = 0;
		int disExtra = 0;
		int feeBasic = 10000;
		int feeAdd = 2300;
		int feeTotal = 0;
		int feeExtra = 0;
		
		if (dis > 0) {
			if (dis >= disBasic) {
				disAdd = (dis - disBasic);
				disExtra = disAdd/3;
				if (disAdd % 3 != 0) {
					disExtra += 1;
				}
				feeExtra = feeAdd * disExtra;
				feeTotal = feeBasic + feeExtra;
				System.out.println(feeTotal);
			} else {
				System.out.println(feeBasic);
			}
		} else {
			System.out.println("1이상의 값을 입력하세요.");
		}
		sc.close();
		
		
	}

}
