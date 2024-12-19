package 클래스_문제;

import java.util.Scanner;

class School {
	String name = "빙하타고등학교";
	int cnt = 5;
	int[] arHakbun = { 1001, 1002, 1003, 1004, 1005 };
	int[] arScore = { 92, 38, 87, 100, 11 };
	String[] arNames = { "둘리", "호길동", "가치", "가이클", "조던" };
}

public class _03학생성적 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		School school = new School();

		while (true) {
			System.out.println();
			System.out.println("=== " + school.name + " ===");
			System.out.println("1.전교생 성적확인(저장순)");
			System.out.println("2.1등학생 성적확인");
			System.out.println("3.꼴등학생 성적확인");
			System.out.println("4.성적확인하기(이름순)");
			System.out.println("5.종료하기");

			System.out.print("메뉴 선택 >> ");
			int sel = sc.nextInt();
			if (sel == 5) {
				System.out.println("종료");
				break;
			}
			if (sel < 1 || sel > 4) {
				System.out.println("입력오류");
				continue;
			}
			System.out.println();
			if (sel == 1) {
				System.out.println("[ 전교생 성적 확인 (저장순) ]");
				for (int i = 0; i < school.cnt; i++) {
					System.out.printf("(%2d) %d \t %5s \t %3d점\n", i + 1, school.arHakbun[i], school.arNames[i],
							school.arScore[i]);
				}
			} else if (sel == 2) {
				System.out.println("[ 1등 학생 성적 확인]");
				int idxMax = -1;
				int max = 0;
				for (int i = 0; i < school.cnt; i++) {
					if (max < school.arScore[i]) {
						max = school.arScore[i];
						idxMax = i;
					}
				}
				System.out.printf("%d \t %5s \t %3d점\n", school.arHakbun[idxMax], school.arNames[idxMax],
						school.arScore[idxMax]);
			} else if (sel == 3) {
				System.out.println("[ 꼴등 학생 성적 확인]");
				int idxMin = -1;
				int min = 100;
				for (int i = 0; i < school.cnt; i++) {
					if (min > school.arScore[i]) {
						min = school.arScore[i];
						idxMin = i;
					}
				}
				System.out.printf("%d \t %5s \t %3d점\n", school.arHakbun[idxMin], school.arNames[idxMin],
						school.arScore[idxMin]);
			} else if (sel == 4) {
				int[] idxName = new int[school.cnt];
				for (int i = 0; i < school.cnt; i++) {
					idxName[i] = i;
				}
				for (int i = 0; i < school.cnt; i++) {
					for (int k = i + 1; k < school.cnt; k++) {
						if (school.arNames[idxName[i]].compareTo(school.arNames[idxName[k]]) > 0) {
							int temp = idxName[i];
							idxName[i] = idxName[k];
							idxName[k] = temp;
						}
					}
				}
				System.out.println("[ 성적 확인 (이름순) ]");
				for (int i = 0; i < school.cnt; i++) {
					System.out.printf("(%2d) %d \t %5s \t %3d점\n", i + 1, school.arHakbun[idxName[i]],
							school.arNames[idxName[i]], school.arScore[idxName[i]]);
				}
			}
		}
		sc.close();
	}

}
