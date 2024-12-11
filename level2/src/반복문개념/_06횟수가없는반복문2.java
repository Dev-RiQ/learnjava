package 반복문개념;

public class _06횟수가없는반복문2 {

	public static void main(String[] args) {

		int i = 1;
		boolean run = true;
		while(run) {
			System.out.print(i + " ");
			if(i==7) {
				run = false;
			}
			i+=1;
		}
		System.out.println("i = " + i);

		System.out.println("=================");
		
		i = 1;
		while(true) {
			System.out.print(i + " ");
			if(i==7) {
				break;
			}
			i+=1;
		}
		System.out.println("i = " + i);
		
	}

}
