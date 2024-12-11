package 배열심화문제;

import java.util.Arrays;

public class _06갯수찾기 {

	public static void main(String[] args) {

		/*
		 * [문제] 가장 많이 들어있는 숫자 갯수와 가장 적게 들어있는 숫자 갯수 합?
		 */
		int[] arr = { 1, 2, 3, 3, 100, 1, 3, 3, 2, 3, 2 };
		int[] copy = null;
		int[] cnt = null;
		int numCnt = 0;
		int minCnt = arr.length;
		int maxCnt = 0;
		int minNum = 0;
		int maxNum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < i; k++) {
				if (arr[i] == arr[k]) {
					numCnt--;
					break;
				}
			}
			numCnt++;
		}
		copy = new int[numCnt];
		cnt = new int[numCnt];
		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			copy[idx] = arr[i];
			for (int k = 0; k < idx; k++) {
				if (copy[idx] == copy[k]) {
					idx--;
					break;
				}
			}
			idx++;
			if (idx == numCnt) {
				break;
			}
		}
		System.out.println(Arrays.toString(copy));
		for (int k = 0; k < cnt.length; k++) {
			for (int i = 0; i < arr.length; i++) {
				if (copy[k] == arr[i]) {
					cnt[k]++;
				}
			}
		}
		System.out.println(Arrays.toString(cnt));
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] < minCnt) {
				minCnt = cnt[i];
				minNum = copy[i];
			}
			if (cnt[i] > maxCnt) {
				maxCnt = cnt[i];
				maxNum = copy[i];
			}
		}
		System.out.print(minNum + " : ");
		System.out.println(minCnt + "개");
		System.out.print(maxNum + "   : ");
		System.out.println(maxCnt + "개");
		System.out.println("정답 : " + (minCnt + maxCnt));
		System.out.println();
	}

}
