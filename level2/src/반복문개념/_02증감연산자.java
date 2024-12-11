package 반복문개념;

public class _02증감연산자 {

	public static void main(String[] args) {

		
		int num = 10;
		num += 1; 	 //누적변수 => 자기자신에 어떤 수를 변경해준다. (사칙연산 모두 가능 / 모든 언어에 사용 가능)
		System.out.println(num);
		
		num++;	// 1씩 증가 (1만 가능, 증가 감소밖에 안됨)
		
		System.out.println(num);
		
		++num;	// 1씩 증가
		
		System.out.println(num);
		
		num--;	// 1씩 감소
		
		System.out.println(num);
		
		--num;	// 1씩 감소
		
		System.out.println(num);
		
		System.out.println("===");
		
		int a = 10;
		int b = 10;
		
		System.out.println(a);
		System.out.println(++a); // +1하고 a 출력
		System.out.println(a);
		System.out.println(b);
		System.out.println(b++); // b출력 후 다음부터 +1
		System.out.println(b);
	}

}
