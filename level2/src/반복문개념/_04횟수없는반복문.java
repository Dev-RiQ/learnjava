package 반복문개념;

public class _04횟수없는반복문 {

	public static void main(String[] args) {

		//횟수있는 반복문 => 초기값, 조건식, 증감식
		
		//횟수없는 반복문 => 들어가는 조건식, 나가는 조건식
		
		int i = 1;
		while(i<=10) {
			System.out.print(i + " ");
			i+=1;
		}
		System.out.println("\n================");
		boolean run = true;
		i = 1;
		while(run) {
			System.out.print(i + " ");
			if(i == 10) {
				run = false;
			}
			i += 1;
		}
		
	}

}
