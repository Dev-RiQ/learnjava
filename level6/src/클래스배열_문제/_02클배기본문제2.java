package 클래스배열_문제;

import java.util.Random;
import java.util.Scanner;

public class _02클배기본문제2 {

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		int max = 10;
		Student[] stList = new Student[max];
		int cnt = 0; // 현재 생성 학생 숫자
		int num = 1001;
		while (true) {
			System.out.println("[1]학생추가 [2]학생삭제 [3]수정 [4]검색 [5]전체츌력 [0]종료");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("종료");
				break;
			}
			if (sel < 1 || sel > 5) {
				System.out.println("입력 오류");
				continue;
			}
			if (sel == 1) {
				if (cnt == max) {
					System.out.println("더 이상 추가할 수 없습니다.");
					continue;
				}
				System.out.println("[ 학생 추가 ]");
				stList[cnt] = new Student();

				stList[cnt].number = num++;

				while (true) {
					boolean isHave = false;
					System.out.print("id : ");
					String id = sc.next();
					for (int i = 0; i < cnt; i++) {
						if (id.equals(stList[i].id)) {
							System.out.println("이미 사용중인 아이디");
							isHave = true;
							break;
						}
					}
					if (!isHave) {
						stList[cnt].id = id;
						break;
					}
				}

				System.out.print("pw : ");
				String pw = sc.next();
				stList[cnt].pw = pw;

				System.out.print("이름 : ");
				String name = sc.next();
				stList[cnt].name = name;

				stList[cnt].score = rd.nextInt(71) + 30;

				System.out.println("새로운 학생 추가 완료");
				cnt++;

			} else if (sel == 2) {
				if (cnt == 0) {
					System.out.println("삭제할 학생이 없습니다.");
					continue;
				}
				System.out.println("[학생 삭제]");
				int idx = -1;
				while (true) {
					System.out.print("삭제할 할생 ID 입력 >> ");
					String id = sc.next();
					for (int i = 0; i < cnt; i++) {
						if (id.equals(stList[i].id)) {
							idx = i;
							break;
						}
					}
					if (idx == -1) {
						System.out.println("존재하지 않는 아이디");
						continue;
					}
					System.out.println("id : " + stList[idx].id + " 학생 삭제 완료");
					for (int i = idx; i < cnt - 1; i++) {
						stList[i] = stList[i + 1];
					}
					cnt--;
					stList[cnt] = null;
					break;
				}

			} else if (sel == 3) {
				if (cnt == 0) {
					System.out.println("수정할 학생이 없습니다.");
					continue;
				}
				System.out.println("[학생 점수 수정]");
				int idx = -1;
				while (true) {
					System.out.print("수정할 할생 학번 입력 >> ");
					int number = sc.nextInt();
					if(number < 1001 || number > 9999) {
						System.out.println("네 자리 정수를 입력하세요");
						continue;
					}
					for (int i = 0; i < cnt; i++) {
						if (number == stList[i].number) {
							idx = i;
							break;
						}
					}
					if (idx == -1) {
						System.out.println("존재하지 않는 학번");
						continue;
					}
					while (true) {
						System.out.print("점수 입력 >> ");
						int score = sc.nextInt();
						if (score == stList[idx].score) {
							System.out.println("현재 점수와 같음");
							continue;
						}
						if (score < 30 || score > 100) {
							System.out.println("30~100사이 값 입력");
							continue;
						}
						stList[idx].score = score;
						break;
					}
					System.out.println(stList[idx].number + "번 학생 점수 변경 완료");
					break;
				}
			} else if (sel == 4) {
				if (cnt == 0) {
					System.out.println("검색할 학생이 없습니다.");
					continue;
				}
				System.out.println("[학생 학번 검색]");
				int idx = -1;
				while (true) {
					System.out.print("검색할 할생 이름 입력 >> ");
					String name = sc.next();
					for (int i = 0; i < cnt; i++) {
						if (name.equals(stList[i].name)) {
							idx = i;
							System.out.println(stList[idx].name + " 학생 학번 : " + stList[idx].number);
						}
					}
					if (idx == -1) {
						System.out.println("존재하지 않는 이름");
						continue;
					}
					break;
				}

			} else if (sel == 5) {
				if (cnt == 0) {
					System.out.println("학생이 없습니다.");
					continue;
				}
				int listNum = 1;
				for (Student s : stList) {
					if (s == null) {
						break;
					}
					System.out.println("===== [ " + (listNum++) + " ] =====");
					System.out.println("학번 : " + s.number);
					System.out.println("id : " + s.id);
					System.out.println("pw : " + s.pw);
					System.out.println("이름 : " + s.name);
					System.out.println("점수 : " + s.score+"점");
				}
			}
		}
		sc.close();

	}

}
