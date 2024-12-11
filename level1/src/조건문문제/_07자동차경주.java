package 조건문문제;

import java.util.Scanner;

public class _07자동차경주 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		자동차는 154km의 거리를 1시간 18분에 달린다.
		 		트럭은 215km의 거리를 2시간 17분에 달린다.
		 		자동차가 트럭보다 빠른지 여부를 출력해라
		 		
		 		 자동차가 더 빠르다
		 		 트럭이 더 빠르다
		 		 자동차랑 트럭이 같은 속도다
		 		 
		 */
		
		Scanner sc = new Scanner(System.in);

		System.out.print("자동차 이동 거리 (km) >> ");
		int moveCar = sc.nextInt();
		System.out.print("자동차 이동 시간 (시간) >> ");
		int hourCar = sc.nextInt();
		System.out.print("자동차 이동 시간 (분) >> ");
		int minCar = sc.nextInt();
		
		System.out.print("\n트럭 이동 거리 (km) >> ");
		int moveTruck = sc.nextInt();
		System.out.print("트럭 이동 시간 (시간) >> ");
		int hourTruck = sc.nextInt();
		System.out.print("트럭 이동 시간 (분) >> ");
		int minTruck = sc.nextInt();

		int timeCar = hourCar * 60 + minCar;
		int timeTruck = hourTruck * 60 + minTruck;

		double kmPer1minCar = moveCar * 1.0 / timeCar;
		double kmPer1minTruck = moveTruck * 1.0 / timeTruck;

		System.out.printf("\n자동차의 속도 (km/min) = %.5f",(kmPer1minCar));
		System.out.printf("트럭의 속도 (km/min) = %.5f",(kmPer1minCar));

		if (kmPer1minCar > kmPer1minTruck) {
			System.out.println("\n자동차가 더 빠르다");
		}
		if (kmPer1minCar == kmPer1minTruck) {
			System.out.println("\n자동차랑 트럭은 같은 속도다");
		}
		if (kmPer1minCar < kmPer1minTruck) {
			System.out.println("\n트럭이 더 빠르다");
		}

		sc.close();
	}

}
