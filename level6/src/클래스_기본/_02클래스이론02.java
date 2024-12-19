package 클래스_기본;

//class Member {  같은 패키지에서 동일명 클래스 생성 불가 
//
//}

public class _02클래스이론02 {

	public static void main(String[] args) {
		
		Member m = new Member(); //같은 패키지 불러오기 가능 (다른 패키지라면 import 해줘야함)
		System.out.println(m.name);
		m.name = "김영희";
		System.out.println(m.name);
		
	}
}
