package 반복문문제01;

public class _12배수의가까운값 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1에서 200사이의 숫자 중 다음 조건에 맞는 숫자를 출력하시오.
		 		조건) 6의 배수 중에서 100에 가장 가까운 수를 출력하시오.
		 */
		
		int i =1;
		int multi = 6;
		int max = 200;
		int setNum = 100;
		int num1 = 0;
		int num2 = 0;

		while (i <= max) {
			if (i % multi == 0 && i < setNum) {
				num1 = i;
			}
			i += 1;
		}
		num2 = num1 + multi;

		int diff1 = setNum - num1;
		int diff2 = num2 - setNum;

		if (diff1 > diff2) {
			System.out.println(num2);
		} else if (diff2 > diff1) {
			System.out.println(num1);
		} else {
			System.out.println(num1 + " = " + num2 + " 차이가 같다");
		}

//		int i = 1;
//		int multi = 8;
//		int max = 200;
//		int setNum = 100;
//		int beforeNum = 0;
//		int afterNum = 0;
//		
//		while(i<=max) {
//			if(i % multi == 0 && i < setNum) {
//				beforeNum = i;
//			}
//			i += 1;
//		}
//		afterNum = beforeNum + multi;
//				
//		int res1 = setNum - beforeNum;
//		int res2 = afterNum  - setNum;
//		
//		if (res1<res2) {
//			System.out.println(beforeNum);
//		}else if (res1>res2) {
//			System.out.println(afterNum);
//		}else {
//			System.out.println(beforeNum + " = " + afterNum);
//		}

	}

}
