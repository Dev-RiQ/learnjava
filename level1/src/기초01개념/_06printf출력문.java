package 기초01개념;
/*
 * %d : 십진수 = 정수
 * %f : 실수
 * %c : 문자 한개
 * %s : 문자여러개
 */
public class _06printf출력문 {

	public static void main(String[] args) {
		
		System.out.println("사과 5개 중에 3개를 먹고 2개가 남았습니다");
		System.out.println("사과 "+5+"개 중에 "+3+"개를 먹고 "+(5-3)+"개가 남았습니다");
		
		String fruit = "사과";
		int cntApple = 5;
		int cntEat = 2;
		
		System.out.printf("%s %d개 중에 %d개를 먹고 %d개가 남았습니다\n",fruit,cntApple,cntEat,(cntApple-cntEat));
		System.out.println(10/3.0);
		System.out.printf("%.2f \n" ,  10/3.0);
		System.out.println(String.format("%.2f", 10/3.0));
		System.out.println(Math.round(10/3.0 * 100)/100.0);
		
	}
}
