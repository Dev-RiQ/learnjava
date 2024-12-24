package 클래스배열_문제;

import java.util.Scanner;

class Subject{
	int stuNumber;
	String name;
	int score;
	int rank;
	String stuName;
}

public class _05클배학생과목1 {

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

		Subject[] subject = new Subject[subList.length];

		for (int i = 0; i < subList.length; i++) {
			Subject s = new Subject();
			s.stuNumber = stuNumList[i];
			s.name = subList[i];
			s.score = scoreList[i];
			for (Student st : student) {
				if (s.stuNumber == st.number) {
					s.stuName = st.name;
					break;
				}
			}

			subject[i] = s;
		}

		while (true) {
			System.out.println("=================");
			System.out.println("[0] 종료");
			System.out.println("[1] 학생 정보 출력");
			System.out.println("[2] 과목 정보 출력");
			System.out.println("[3] 과목별 랭킹 저장");
			System.out.println("[4] 과목별 랭킹 + 이름 출력");
			System.out.println("[5] 과목별 랭킹 1등의 이름 과목 점수 출력");
			System.out.print("메뉴 입력 >> ");
			int sel = sc.nextInt();
			if (sel < 0 || sel > 5) {
				System.out.println("입력오류");
				continue;
			}
			if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			if (sel < 3 && student.length == 0) {
				System.out.println("처리할 데이터가 없습니다.");
				continue;
			}
			if (sel > 3 && subject[0].rank == 0) {
				System.out.println("아직 랭킹이 저장되지 않았습니다");
				continue;
			}
			if (sel == 1) {

				System.out.println("=================");
				for (Student st : student)
					System.out.printf("%d %s \n", st.number, st.name);

			} else if (sel == 2) {

				System.out.println("=================");
				for (Subject sb : subject)
					System.out.printf("%d %s %3d점 \n", sb.stuNumber, sb.name, sb.score);

			} else if (sel == 3) {

				for (Subject sb : subject) {
					sb.rank = 1;
					for (Subject psb : subject) {
						if (sb.name.equals(psb.name) && sb.score < psb.score)
							sb.rank++;
					}
				}

			} else if (sel == 4) {

				System.out.println("=================");
				for (Subject sb : subject)
					System.out.printf("%d %s %3d점 %2d등 %s \n", sb.stuNumber, sb.name, sb.score, sb.rank, sb.stuName);

			} else if (sel == 5) {

				System.out.println("=================");
				for (Subject sb : subject) {
					if (sb.rank == 1)
						System.out.printf("%s %2s %3d점 \n", sb.stuName, sb.name, sb.score);
				}
				
			}
		}
		sc.close();
	}

}
