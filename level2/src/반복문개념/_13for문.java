package 반복문개념;

public class _13for문 {

	public static void main(String[] args) {

		// whlie => 횟수가 정해지지 않는 반복문에서 많이 씀
		
		// for => 횟수가 정해져 있는 반복문에서 많이 씀
		
		// 횟수 => 초기값, 조건식, 증감식
		
		int i = 1; // 초기값
		while(i<=10) { // 조건식
			System.out.print(i + " ");
			i+=1; // 증감식
		}
		System.out.println();
		System.out.println("====");
		
		for(int k = 1; k<=10; k++) { // 밖에서 k 출력 불가
			System.out.print(k + " ");
		}
		System.out.println();
		System.out.println("====");
		
		int k = 1;	//가능은한데 왠만하면 안씀
		for(;k<=10;k++) {
			System.out.print(k + " ");
		}
		System.out.println(k);
		System.out.println("====");
		//무한반복은 while이 더 직관적
		while(true) {
			break;
		}
		for(;;) { // ;; 필수 (초기값; 조건식; 증감식)
			break;
		}
		
		for(int j = 1;j<=10;j++) {
			if(j%2==0) {
				continue;
			}
			System.out.print(j+" ");
		}
	}

}
