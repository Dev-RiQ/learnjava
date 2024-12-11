package 반복문개념;

public class _08continue {

	public static void main(String[] args) {

		int rs = 0;
		int i = 0;
		
		while(i<10) {
			i+=1;
			if(i%2==0) {
				continue;
			}
			rs+=i;
			System.out.println(i);
		}
		System.out.println(rs);
		
		
		
		
		
	}

}
