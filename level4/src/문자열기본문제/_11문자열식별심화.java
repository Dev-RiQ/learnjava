package 문자열기본문제;

public class _11문자열식별심화 {

	public static void main(String[] args) {

		/*
		 	문자열 속 숫자 검사
		 	문자만 있다/숫자만있다/둘다있다
		 */
		/*
		 	심화 3개 연속
		 		오름차순 연속숫자
		 		내림차순 연속숫자
		 		3개 같은 숫자 연속 있는지
		 */
		String text = "1sad112f23e323432221f335511dsae2z2qweqwtfea7889dweqgejhlkj22dd32d33";
		boolean isNum = false;
		boolean isUp = false;
		boolean isDown = false;
		boolean isSame = false;
		boolean isEng = false;
		int test = 2;
		for (int i = 0; i < text.length() - test; i++) {
			if (text.charAt(i) > 47 && text.charAt(i) < 58) {
				if (text.charAt(i) + 1 == text.charAt(i + 1) && text.charAt(i) + 2 == text.charAt(i + 2)) {
					isUp = true;
				} else if (text.charAt(i) - 1 == text.charAt(i + 1) && text.charAt(i) - 2 == text.charAt(i + 2)) {
					isDown = true;
				} else if (text.charAt(i) == text.charAt(i + 1) && text.charAt(i) == text.charAt(i + 2)) {
					isSame = true;
				}
				isNum = true;
			} else if (text.charAt(i) > 96 && text.charAt(i) < 123) {
				isEng = true;
			}
		}
		System.out.println("3개 연속 오름차순  : " + (isUp ? "⚪" : "❌"));
		System.out.println("3개 연속 내림차순  : " + (isDown ? "⚪" : "❌"));
		System.out.println("3개 연속 같은 숫자 : " + (isSame ? "⚪" : "❌"));
		System.out.print(isNum ? " 숫자" : "");
		System.out.print(isEng ? " 문자" : "");
		if (isNum && isEng) {
			System.out.print(" 둘 다 있는");
		} else if (!isNum && !isEng) {
			System.out.print("아무것도 없는");
		} else {
			System.out.print("만 있는");
		}
		System.out.println(" 문자열이다.");
		
		
	}

}
