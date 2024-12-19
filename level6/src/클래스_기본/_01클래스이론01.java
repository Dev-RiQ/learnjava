package 클래스_기본;

/*
		 	변수의 종류
		 	
		 		[데이터 타입별 분류]
		 		- 기본형 변수 : int, char, double, boolean, float, long, short, byte => 순수 값 저장
		 		- 참조형 변수 : 기본형 변수를 제외한 모든 타입 ( 배열, 클래스, String 등등) => 주소값 저장
		 		
		 		[위치별 분류]
		 		- 지역 변수 : 메서드 영역 안에서 생성한 변수 => 반드시 초기값이 필요하다
		 		- 전역 변수(멤버변수) : 클래스 영역 안, 메서드 영역 밖에서 생성한 변수 => heap에 생성 (자동 초기값 : 0, false, null)
		 		
		 		변수 => 단 한개의 데이터만 저장 (변경 시 기존 값 삭제)
		 		배열 => 단 한개의 자료형이 여러개 저장
		 		클래스 => 여러개의 자료형을 여러개 저장 (사용자 정의 자료형 타입)
 */

public class _01클래스이론01 {

	public static void main(String[] args) {
		// 여기서 생성하면 지역 변수 (초기값 지정 필수)
		
		String[][] data = {{"1","qwer","1234","김철수","true"}};
		// 가독성 하락(인덱스 저게 뭘 뜻하는데?) , 형태 변형 필요
		System.out.println(Integer.parseInt(data[0][0]));
		System.out.println(data[0][1]);
		System.out.println(data[0][2]);
		System.out.println(data[0][3]);
		System.out.println(Boolean.parseBoolean(data[0][4])==true? "남자":"여자");
		System.out.println("===");
		Member m = new Member(); // Member 클래스로 만든 객체(인스턴스) => heap에 Member 클래스 생성
		// 자동 초기값이 출력
		System.out.println(m.no);
		System.out.println(m.id);
		System.out.println(m.pw);
		System.out.println(m.name);
		System.out.println(m.isMan);
		System.out.println("===");
		// 값 입력해주면 변경
		int selIdx = 0;
		m.no = Integer.parseInt(data[selIdx][0]);
		m.id = data[selIdx][1];
		m.pw = data[selIdx][2];
		m.name = data[selIdx][3];
		m.isMan = Boolean.parseBoolean(data[selIdx][4]);
		System.out.println(m.no);
		System.out.println(m.id);
		System.out.println(m.pw);
		System.out.println(m.name);
		System.out.println(m.isMan);
		System.out.println("===");
	}
	
	
}

class Member {
	int no; // 전역 변수 ( 0 값 heap에 생성)
	String id; // 전역 변수 ( null 값 heap에 생성)
	String pw;
	String name;
	boolean isMan; // 전역 변수 ( false 값 heap에 생성)
}
