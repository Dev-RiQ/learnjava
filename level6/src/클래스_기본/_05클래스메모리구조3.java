package 클래스_기본;

class Sample03{
	int[] hakbun = {1001,1002,1003,1004,1005};
	int[] score = {92,38,87,100,11};
}

public class _05클래스메모리구조3 {

	public static void main(String[] args) {

		int[] arr = new int[3];
		Sample03 s3;
		s3 = new Sample03();
		
		arr = s3.score;
		arr[1] = 100;
		
		Sample03 s4 = new Sample03();
		s4.score[2] = 100;
	}

}
