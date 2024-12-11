package 문자열개념;

import java.util.Arrays;

public class _06문자열함수 {

	public static void main(String[] args) {
//		String test = null; => 빈 주소 값(
//		String test2 = ""; => 빈 문자열 값
//		System.out.println(test.length());// 주소 없으니 안뜸
//		System.out.println(test2.length());// 빈 값이라 0
		String str = "가나다라마바사";
		
		//1.문자 길이 추출
		System.out.println(str.length());
				
		//2. 문자 한개 추출
		char str1 = str.charAt(1);
		System.out.println(str1);
		
		//3. 문자 -> 숫자
		String num1 = "100";
		int num2 = 30;
		
		System.out.println(num1+num2);
		int num3 = Integer.parseInt(num1); // "100" => 100
		System.out.println(num3+num2);
		
		//4.숫자->문자
		int num4 = 100;
		//1)
		String num5 = String.valueOf(num4); // 100 => "100"
		System.out.println(num4+num5);
		//2) 추천
		String num6 = 100+""; // 100 => "100"
		System.out.println(num4+num6);
		
		//5. 문자데이터 확인
		String[] strArr = new String[3]; // [null,null,null]
		System.out.println(strArr.length);
//		System.out.println(strArr[0].length());//=> 초기값 null이니까 에러뜸
		String[] strArr2 = {""," ","      "};
		for(int i = 0;i<strArr2.length;i++) {
			System.out.print(strArr2[i]);  
			System.out.println(strArr2[i].length());   // 안보이지만 공백도 칸 차지함 
		}
		//빈 문자열이다 (.isBlank())
		System.out.println(strArr2[0].length()==0);
		System.out.println(strArr2[1].length()==0);//false 나옴; (공백도 데이터로 취급)
		System.out.println(strArr2[0].isBlank()); //공백은 데이터로 취급 안함
		System.out.println(strArr2[1].isBlank());
		System.out.println(strArr2[2].isBlank()); 
		System.out.println(strArr2[0].isEmpty()); //.length()==0이랑 같음
		System.out.println(strArr2[1].isEmpty()); 
		System.out.println(strArr2[2].isEmpty());
		
		//6. 구분자
		str = "떡볶이/짜장면/치킨/우동/족발"; // 1개로 취급
		String[] dinner = str.split("/"); // 구분 기준으로 나누어 저장
		String[] dinner2 = str.split("볶"); // 구분자는 사라짐
		System.out.println(str);
		System.out.println(Arrays.toString(dinner));
		System.out.println(Arrays.toString(dinner2));
		System.out.println(dinner[1]);
		System.out.println(dinner2[1]);
		
		//7. trim() 여러줄 공백 제거
		str = "           hello            world                ";
		System.out.println(str);
		System.out.println(str.trim()); // 사이 공백은 못없엠 (앞뒤만 가능)
		
		//8. 문자열 변경 replace
		str = "HelloHelloHelloWorld";
		System.out.println(str);
		System.out.println(str.replace("Hello", "A")); // .replace("바꿀거","넣을거");
		
		str = "           hello            world                ";
		System.out.println(str);
		System.out.println(str.trim());
		System.out.println(str.replace(" ", "")); // 공백 그냥 다제거하고싶으면 trim 대신 사용
		
		//9. 하위 문자열 subString
		str = "안녕하세요 반갑습니다";
		String temp = str.substring(5); // 시작인덱스~끝
		String temp2 = str.substring(6,7); // 시작인덱스~끝인덱스 전까지
		System.out.println(temp);
		System.out.println(temp2);
	}

}
