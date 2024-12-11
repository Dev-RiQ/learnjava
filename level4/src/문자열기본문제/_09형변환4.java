package 문자열기본문제;

public class _09형변환4 {

	public static void main(String[] args) {

		/*
		 	꼴등 삭제 후 다시 문자열로 변경
		 */
		String str = "김철수/87,이만수/42,이영희/95";

		String[] temp = str.split(",");
		int[] arr = new int[temp.length];
		int min = 100;
		int idx = -1;
		for (int i = 0; i < temp.length; i++) {
			arr[i] = Integer.parseInt(temp[i].substring(4, 6));
			temp[i] = temp[i].substring(0, 3);
			if (min > arr[i]) {
				min = arr[i];
				idx = i;
			}
		}
		int cnt = 0;
		str = "";
		for (int i = 0; i < temp.length; i++) {
			if (i != idx) {
				str += cnt == 0 ? temp[i] + "/" + (arr[i] + "") : "," + temp[i] + "/" + (arr[i] + "");
				cnt++;
			}
		}
		System.out.println(str);
		
		
	}

}
