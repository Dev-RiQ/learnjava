package 배열1개념;

public class _02배열기본2 {

	public static void main(String[] args) {

		//1. 배열 사용법
		int[] arr = new int[3];
		
		for(int i=0;i<3;i+=1) {
			arr[i] = (i+1)*10;
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		//2 축약형
		int[] arr2 = {10,20,30}; // 선언 시에만 가능
		for(int i=0;i<3;i+=1) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		
//		int[] arr3 = null; // 비어있는 주소 값=> 처음 길이를 모를때
		//arr3 = {10,20,30,40} 되겠냐고 ㅋㅋ
		
//		int cnt = 3;
//		arr3 = new int[cnt];
		
	}

}
