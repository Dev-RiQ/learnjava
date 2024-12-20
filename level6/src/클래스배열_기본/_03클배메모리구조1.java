package 클래스배열_기본;

class AA{
	int a;
	int b;
}

public class _03클배메모리구조1 {

	public static void main(String[] args) {
		AA aa = new AA();
		aa.a = 10;
		aa = new AA();
		aa.b = 20;
	}

}
