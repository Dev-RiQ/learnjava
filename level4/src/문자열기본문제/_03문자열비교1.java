package 문자열기본문제;

public class _03문자열비교1 {

	public static void main(String[] args) {

		/*
		 	id배열은 아이디를 저장해 놓은 것
		 	find 변수는 로그인 할 아이디
		 	로그인 성공 실패 여부
		 */
		
		String[] id = { "qwer", "asdf", "zxc" };
		String find = "asdf";
		for (int i = 0; i < id.length; i++) {
			System.out.println(id[i].equals(find) ? "로그인 성공" : "로그인 실패");
		}
		
	}

}
