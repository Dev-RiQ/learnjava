package 객체지향이론;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _05정규표현식 {

	public static void main(String[] args) {

		String acc = "1111-1111-1111";
		String accPattern = "^\\d{4}-\\d{4}-\\d{4}";
		
		Pattern pattern = Pattern.compile(accPattern); // 검증할 패턴 형태
		Matcher matcher = pattern.matcher(acc); // 검증 받을 문자열
		System.out.println(matcher.matches()? "올바른 계좌번호":"잘못된 계좌번호");
		
		// 1001~1099 까지 존재하는 학번 유효성 검사
		
		String stuNo = "1000";
		String stuNoPattern = "^10(0[1-9]|[1-9][0-9])$";
		
		pattern = Pattern.compile(stuNoPattern);
		matcher = pattern.matcher(stuNo);
		System.out.println(matcher.matches()? "올바른 학번" : "잘못된 학번");
	}

}
