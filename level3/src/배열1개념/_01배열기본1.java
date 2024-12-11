package 배열1개념;

public class _01배열기본1 {

	public static void main(String[] args) {

		/*
		 	변수 - 특정 값 한개 재사용 하기 위해 메모리 공간에 저장하는 방법 => 값 변경 => 이전값 사라진다
		 	
		 	배열 - 같은 종류의 데이터를 여러개 저장하는 방법
		 	
		 	원시타입(primitive) - int, double, char, boolean, byte, short, long, float
		 	=> 변수에 실제로 해당 값이 저장
		 	참조타입(reference) - 배역, 클래스(String, Scanner, Random ...),
		 	=> 변수에 주소값이 저장된다
		 	=> 자동 초기값 가짐 (0, false, null(숫자x boolean도 아닌 참조타입 값; 비어있음))
		 */
		
		int num = 10;
		System.out.println(num);
		num = 100;
		System.out.println(num);
		
		int[] arr; // 배열 선언
		arr = new int [5]; // 배열 초기값 => int만 들어가는 메모리방 5개 만들기 (0부터 5개)
		double[] darr = new double[5];//[index]
		System.out.println(" =========== ");
		
		System.out.println(arr);
		System.out.println(darr);
		System.out.println(" =========== ");
		
		System.out.println(arr[0]);// arr주소의 0번째 값 가져와
		System.out.println(darr[0]);// darr주소의 0번째 값 가져와
		System.out.println(" =========== ");
		
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		//System.out.println(arr[5]); //ArrayIndexOutOfBoundsException => 없는 방 번호
		System.out.println(" =========== ");
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		for(int i = 0;i<5;i+=1) {
			System.out.println(arr[i]);
		}
		System.out.println(" =========== ");
		
		
	}

}
