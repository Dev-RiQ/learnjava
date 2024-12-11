package 기초03개념;

public class _07연립방정식 {

	public static void main(String[] args) {

		int c = 0;
		int d = 0;
		
		c = -2;
		d = -7;
		
		boolean res1 = 3 * c - d == 1 && -2 * c + d == -3;
		
		// 3c-d = 1
		// -2c+d = -3
		// c = -2 , d = -7
		
		System.out.println(res1);
		
		int e = 0;
		int f = 0;
		
		e = 2;
		f = 4;
		
		boolean res2 = 5 * e -2 * f == 2 && e + 3 * f == 14;
		
		// 5e-2f = 2
		// e+3f = 14
		// 5e+15f = 70
		// 17f = 68
		// f = 4, e = 2
		
		System.out.println(res2);
		
	}

}
