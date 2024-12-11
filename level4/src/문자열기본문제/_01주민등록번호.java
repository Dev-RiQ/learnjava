package 문자열기본문제;

public class _01주민등록번호 {

	public static void main(String[] args) {

		//주번1과 주번2의 각각 만 나이와 성별을 출력하시오
		
		// 주번 1 (.substring()사용함)
		String jumin1 = "890101-2012932";
		int jumin1back1 = Integer.parseInt(jumin1.substring(7, 8));
		int jumin1front2 = Integer.parseInt(jumin1.substring(0, 2));
		int yearNow = 2024;
		int yearStart = jumin1back1 < 3 ? 1900 : 2000;
		int yearBirth = yearStart + jumin1front2;
		int age = yearNow - yearBirth;
		char sex = jumin1back1 % 2 == 0 ? '여' : '남';
		System.out.printf("%s성 %d세\n", sex, age);

		// 주번 2 (split으로 앞 뒤 분류 후 int 로 변경)
		String jumin2 = "020101-3012932";
		String[] jumin2FB = jumin2.split("-");
		int[] jumin2num = new int[2];
		for (int i = 0; i < jumin2FB.length; i++) {
			jumin2num[i] = Integer.parseInt(jumin2FB[i]);
		}
		int jumin2back1 = jumin2num[1] / 1000000;
		int jumin2front2 = jumin2num[0] / 10000;
		yearNow = 2024;
		yearStart = jumin2back1 < 3 ? 1900 : 2000;
		yearBirth = yearStart + jumin2front2;
		age = yearNow - yearBirth;
		sex = jumin2back1 == 0 ? '여' : '남';
		System.out.printf("%s성 %d세\n", sex, age);
		
		//주번 3 (char+"" 로 강제 문자출력 후 int 처리)
		String jumin3 = "990101-1001234";
		String strF = jumin3.charAt(0)+""+jumin3.charAt(1);
		String strB = jumin3.charAt(7)+"";
		int numF = Integer.parseInt(strF);
		int numB = Integer.parseInt(strB);
		yearNow = 2024;
		yearStart = numB < 3 ? 1900 : 2000;
		yearBirth = yearStart + numF;
		age = yearNow - yearBirth;
		sex = numB % 2 == 0 ? '여' : '남';
		System.out.printf("%s성 %d세\n", sex, age);
	}

}
