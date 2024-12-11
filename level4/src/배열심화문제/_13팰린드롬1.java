package 배열심화문제;

public class _13팰린드롬1 {

	public static void main(String[] args) {

		/*
		 	arr배열이 팰린드롬인지 아닌지 출력
		 	팰린드롬? 
		 	앞 뒤로 읽어도 똑같은 배열
		 */
		int[] arr = { 1, 5, 4, 5, 3, 2, 2, 3, 5, 4, 5, 1 };
		boolean isPal = true; // ==> boolean명명 이런식 (is???)
		int size = arr.length;
		for (int i = 0; i < size/2; i++) {
			if (arr[i] != arr[size - 1 - i]) {
				isPal = false;
				break;
			}
		}
		System.out.println(isPal?"팰린드롬이다":"팰린드롬이아니다");
	}

}
