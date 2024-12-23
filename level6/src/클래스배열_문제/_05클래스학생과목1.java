package 클래스배열_문제;

import java.util.Scanner;

class Subject{
	int number;
	String name;
	int score;
}

public class _05클래스학생과목1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numList[] = { 1001, 1002, 1003 };
		String nameList[] = { "이만수", "김철민", "오수정" };

		Student[] student = new Student[numList.length];

		for (int i = 0; i < student.length; i++) {
			Student s = new Student();
			s.number = numList[i];
			s.name = nameList[i];

			student[i] = s;
		}

		int stuNumList[] = { 1001, 1001, 1002, 1002, 1002, 1003 };
		String subList[] = { "국어", "수학", "국어", "수학", "영어", "수학" };
		int scoreList[] = { 100, 32, 23, 35, 46, 60 };

		int subCnt = 0;
		for (int i = 0; i < subList.length; i++) {
			boolean isHave = false;
			for (int k = 0; k < i; k++) {
				if(subList[i]==subList[k]) {
					isHave = true;
					break;
				}
			}
			if(!isHave) {
				subCnt++;
			}
		}
		
		Subject[] subject = new Subject[subCnt];

		for (int i = 0; i < subList.length; i++) {
			Subject s = new Subject();
			s.number = stuNumList[i];
			s.name = subList[i];
			s.score = scoreList[i];

			subject[i] = s;
		}
		
		while(true) {
			System.out.println("=================");
			System.out.println("[0] 종료");
			System.out.println("[1] 학생 정보 출력");
			System.out.println("[2] 과목 정보 출력");
			System.out.println("[3] 과목별 랭킹 저장");
			System.out.println("[4] 과목별 랭킹 + 이름 출력");
			System.out.println("[5] 과목별 랭킹 1등의 이름 과목 점수 출력");
			System.out.print("메뉴 입력 >> ");
			int sel = sc.nextInt();
			if(sel < 0 || sel >5) {
				System.out.println("입력오류");
				continue;
			}
			if(sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			if(sel == 1) {
				System.out.println("=================");
				for(Student s : student) {
					System.out.printf("%d %s \n",s.number,s.name);
				}
			}else if(sel == 2) {
				System.out.println("=================");
				for(Student s : student) {
					System.out.printf("%d %s \n",s.number,s.name);
				}
			}else if(sel == 3) {
			}else if(sel == 4) {
			}else if(sel == 5) {
				
			}
		}
		sc.close();
	}

}
