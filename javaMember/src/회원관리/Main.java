package 회원관리;

// DAO - data access object
// VO - value object
// Controller - 메뉴 홈 => 사용자와 실제 기능 구현 클래스 연결하는 클래스 (징검다리) (기존 DAO run() 하던것)
// Utils - 여러 클래스 공유 사용 자원 : Scanner... Random... File...

public class Main {

	public static void main(String[] args) {

		MemberController controller = new MemberController();
		controller.run();
	}

}
