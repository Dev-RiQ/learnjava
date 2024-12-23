package 클래스배열_기본;

class DD{
	int a;
	int b;
}

public class _06클배메모리구조04 {

	public static void main(String[] args) {
		
		DD[] ddList = new DD[3];
		
		DD d1 = new DD();
		d1.a = 100;
		ddList[0] = d1;
		
		d1 = new DD();
		d1.a = 200;
		ddList[1] = d1;
		
		d1 = new DD();
		d1.a = 300;
		ddList[2] = d1;
	}
}
