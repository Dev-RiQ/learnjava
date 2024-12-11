package 반복문문제01;

public class _13배수빼기 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		다음 조건이 전부 맞는 수를 출력하시오.
		 		[조건1] 13 이상 100 미만의 숫자 중 13의 배수를 전부 검사
		 		[조건2] 그 중 6번째 배수에서 4번째 배수를 뺀 수를 구한다.
		 */

		int i = 1;
		int cnt = 0;
		int max = 100;
		int min = 13;
		int multi = 13;
		int num6 = 0;
		int num4 = 0;

		while (i < max) {
			if (i % multi == 0 && i >= min) {
				cnt += 1;
				if (cnt == 4) {
					num4 = i;
				} else if (cnt == 6) {
					num6 = i;
				}
			}
			i += 1;
		}
		System.out.println(num6 - num4);
		
		i = 1;
		cnt = 0;
		int cnt6 = 0;
		int cnt4 = 0;
		while(i<max) {
			if(i%13 ==0) {
				cnt+=1;
			}
			if(cnt ==4) {
				cnt4=i;
			}else if(cnt ==6) {
				cnt6=i;
			}
			
			
			i+=1;
		}
		System.out.println(cnt6);
		System.out.println(cnt4);
		System.out.println(cnt6-cnt4);
	}

}
