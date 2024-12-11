package 배열심화개념;


public class _06배열컨트롤러2단계_추가 {

	public static void main(String[] args) {

		int[] score = {10, 20};  // => {0,0,0}
		int count = 2;
		int value = 30;
		int[] temp = score; //=> {10,20}
		score = new int[count+1];// => {0,0,0}
		for(int i = 0;i<count;i++) {
			score[i]=temp[i];
		}
		score[count] = value;
		count++;
		temp = null;
		
	}

}
