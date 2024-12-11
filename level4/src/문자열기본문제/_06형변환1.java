package 문자열기본문제;

public class _06형변환1 {

	public static void main(String[] args) {

		String str = "11/100/89";
		// 1. arr 배열에 각 점수 저장하고, 총점 출력
		String[] strs = str.split("/");
		int[] arr = new int[strs.length];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
			sum += arr[i];
		}
		System.out.println(sum);

		// 2.scroes 배열의 각 점수를 슬러시 구분자로 하나의 문자열로 연결
		int[] scores = { 11, 100, 89 };
		String text = "";
		String[] scoreList = new String[scores.length];
		for (int i = 0; i < scoreList.length; i++) {
			scoreList[i] = scores[i] + "";
			text += i == 0 ? scoreList[i] : "/" + scoreList[i];
		}
		System.out.println(text);
		
		
	}

}
