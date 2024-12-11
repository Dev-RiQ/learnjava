package 문자열개념;

public class _05문자열비교2 {

	public static void main(String[] args) {

		String name1 = "가나다라거가가가가가가ㅏㄱ가ㅏㄱ가가각ㄱㄱㄱ";
		String name2 = "가나다라겨";
		System.out.println(name1);
		// ==>오름차순 정렬
		char str1 = 'a';
		char str2 = 'b';

		char str3 = '가';
		char str4 = '나';
		// char => 문자코드 정수 (한글 정렬 순서대로 오르내림)
		System.out.println(str1+0);
		System.out.println((int) str2);
		System.out.println((int) str3);
		System.out.println((int) str4);
		int a = 5;
		String b  ="10";
		b += a;
		System.out.println(b);
		// 숫자가 크면 뒷순서
		int size = name1.length();
		boolean isSame = true;
		if (size > name2.length()) {
			size = name2.length();
		}
		if (name1.equals(name2)) {
			System.out.println(name1 + ", " + name2 + "는 같다");
		} else {
			for (int i = 0; i < size; i++) {
				if (name1.charAt(i) != name2.charAt(i)) {
					System.out.println(name1.charAt(i) > name2.charAt(i) ? name2 + "가 더 앞" : name1 + "가 더 앞");
					isSame = false;
					break;
				}
			}
			if (isSame) {
				System.out.println(name1.length() > name2.length() ? name2 + "가 더 앞" : name1 + "가 더 앞");
			}
		}
		
		
	}

}
