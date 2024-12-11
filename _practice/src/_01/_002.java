package _01;

public class _002 {

	int a;
	int b;
	public int sum2 () {
		return a + b;
	}
	
	public static int sumPO (int a,int b) {
		int c = 0;
		for(int i = a;i<=b;i++) {
			c += i;
		}
		return c;
	}
	public int sumPO () { // 제일 상위 a, b에 귀속
		int c = 0;
		for(int i = a;i<=b;i++) {
			c += i;
		}
		return c;
	}

}
