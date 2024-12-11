package 반복문개념;

public class _05break {

	public static void main(String[] args) {

		int i = 1;
		while(i<=10) {
			System.out.println(i);
			if(i==5) {
				break; // i += 1 안하고 여기서 바로 나감.
			}
			i+=1;
		}
		System.out.println(i);
	}

}
