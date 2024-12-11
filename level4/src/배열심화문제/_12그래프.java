package 배열심화문제;

import java.util.Arrays;

public class _12그래프 {

	public static final String RESET = "\u001B[0m";    
	public static final String BACKGROUND_GREEN = "\u001B[42m";    
	
	public static void main(String[] args) {

		/*
		 	scoreList는 학생 6명의 점수이다
		 	10점당 *인 가로 그래프로 나타내시오
		 */
		int[] scoreList = { 31, 76, 41, 4, 54, 14, 21, 30, 78, 100, 66, 23};
		System.out.println(Arrays.toString(scoreList));
		System.out.println();
		for (int i = 0; i < scoreList.length; i++) {
			System.out.print(scoreList[i] + "	: ");
			for (int k = 0; k < scoreList[i] / 10; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("\n\n\n\n");
		System.out.println("   "+Arrays.toString(scoreList));
		System.out.println();
		for(int i = 10;i>0;i--) { 
			for(int k = 0;k<scoreList.length;k++) {
				if(scoreList[k]/10<i) {
					System.out.print("     ");
				}else {
					System.out.print("  *  " );
				}
			}
			System.out.println();
		}
		for(int i = 0;i<scoreList.length;i++) {
			if(scoreList[i]==100) {
				System.out.print(" "+scoreList[i]+" ");
			}else if(scoreList[i]<10) {
				System.out.print("  "+scoreList[i]+"  ");
			}else {
				System.out.print(" "+scoreList[i]+"  ");
			}
		}
		System.out.println("\n\n\n\n");
		System.out.println("       "+Arrays.toString(scoreList));
		System.out.println();
		for(int i = 10;i>0;i--) {
			System.out.print(i==10? i*10 + "┤":" "+i*10 + "┤");
			for(int k = 0;k<scoreList.length;k++) {
				boolean rs = false;
				if(scoreList[k]/10 <1&&scoreList[k]/10+1 == i) {
					System.out.print("  "+scoreList[k]+"  ");
					rs = true;
				}
				if(scoreList[k]/10>=i) {
					if(scoreList[k]/10 <10 && scoreList[k]/10 == i) {
						System.out.print(" "+BACKGROUND_GREEN+scoreList[k]+" "+RESET+" ");
					}else if(i==10&&scoreList[k]==100){
						System.out.print(" "+BACKGROUND_GREEN+scoreList[k]+RESET+" ");
					}else {
						System.out.print(" "+BACKGROUND_GREEN+"   "+RESET+" ");
					}
				}else {
					if(!rs) {
						System.out.print("     ");
					}
				}
			}
			System.out.println();
		}
		System.out.print("  0└");
		for(int i =0;i<scoreList.length;i++) {
			System.out.print("──┬──");
		}
		System.out.println();
		System.out.print("    ");
		for(int i = 0;i<scoreList.length;i++) {
			if(i<10) {
				System.out.print("  "+i+"  ");
			}else {
				System.out.print("  "+i+" ");
			}
		}
	}

}
