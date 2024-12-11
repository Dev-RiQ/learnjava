package 문자열기본문제;

public class _11문자열식별 {

	public static void main(String[] args) {

		/*
		 	문자열 속 숫자 검사
		 	문자만 있다/숫자만있다/둘다있다
		 */
		/*
		 	심화
		 		오름차순 연속숫자(123,234,159)
		 		내림차순 연속숫자(321,921)
		 		3개 같은 숫자 연속 있는지 (111,222)
		 */
		String text = "1213323213d3wq176wd94f2r69r8461298472109838091221";
		boolean isNum = false;
		boolean isEng = false;
		boolean isUp = false;
		boolean isDown = false;
		boolean isEqual = false;
		
		for (int i = 0; i < text.length()-2; i++) {
			if (text.charAt(i) > 47 && text.charAt(i) < 58) {
				if(text.charAt(i)<text.charAt(i+1) && text.charAt(i+1)<text.charAt(i+2)) {
					isUp = true;
				}else if(text.charAt(i)>text.charAt(i+1) && text.charAt(i+1)>text.charAt(i+2)) {
					isDown = true;
				}else if(text.charAt(i)==text.charAt(i+1) && text.charAt(i+1)==text.charAt(i+2)) {
					isEqual = true;
				}
				isNum = true;
			} else if (text.charAt(i) > 96 && text.charAt(i) < 123) {
				isEng = true;
			}
		}
		System.out.println("오름차순 : "+isUp);
		System.out.println("내림차순 : "+isDown);
		System.out.println("3연속 : "+isEqual);
		System.out.print(isNum ? " 숫자" : "");
		System.out.print(isEng ? " 문자" : "");
		if (isNum && isEng) {
			System.out.println(" 둘 다 있다.");
		} else if (!isNum && !isEng) {
			System.out.println("아무것도 없다");
		} else {
			System.out.println("만 있다");
		}
		
		
	}

}
