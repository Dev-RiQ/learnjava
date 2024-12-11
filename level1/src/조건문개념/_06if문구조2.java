package 조건문개념;

public class _06if문구조2 {

	public static void main(String[] args) {

		/*
	 		[개념]
	 		 	1. if ( 조건식1 ) { 영역 }
	 		 	2. if ( 조건식1 ) { 영역 } else { 영역 }
	 		 	3. if ( 조건식1 ) { 영역 } elseif( 조건식2 ) { 영역 } ... elseif( 조건식n ) { 영역 } (여러개 가능)
	 		 	4. if ( 조건식1 ) { 영역 } elseif( 조건식2 ) { 영역 } ... elseif( 조건식n ) { 영역 } else { 영역 } .. (else가 마지막)
	 		else가 있으면 무조건 한가지 실행, 없으면 실행하거나 안하거나
		 */
		
		int sel = 2;
		if(sel ==1) {
			System.out.println("과자");
		}
		if(sel ==2) {
			System.out.println("음료수");
		}
		if(sel ==3) {
			System.out.println("라면");
		}else {
			System.out.println("오류");
		}
		//음료수 , 오류 두개 출력
		System.out.println("-----------------------");
		
		sel = 2;
		if(sel ==1) {
			System.out.println("과자");
		} else if(sel ==2) {
			System.out.println("음료수");
		} else if(sel ==3) {
			System.out.println("라면");
		} else {
			System.out.println("오류");
		}
		System.out.println(sel);
	}
		
}
