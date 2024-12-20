package 클래스배열_기본;

class BB{
	int a;
	int b;
}

public class _04클배메모리구조2 {

	public static void main(String[] args) {

		BB[] bb = new BB[3];
		for(int i = 0;i<bb.length;i++) {
			bb[i] = new BB();
			bb[i].a = 10;
			bb[i].b = 20;
		}
	}

}
