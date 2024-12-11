package _레벨3시험;

import java.util.Arrays;
import java.util.Scanner;

public class _04문제 {

	public static void main(String[] args) {

		/*
		 	[문제] 회원가입
		 		1. 가입
		 			-아이디와 비밀번호 입력받아 기입
		 			-아이디 중복검사 (존재하면 사용중이라고 출력)
		 		2. 탈퇴
		 			-아이디 입력받아 탈퇴 (비번까지 일치하면 탈퇴)
		 */
		Scanner sc = new Scanner(System.in);
		int[] ids = { 1001, 1002, 0, 0, 0 };
		int[] pws = { 1111, 2222, 0, 0, 0 };
		int cnt = 2;
		boolean run = true;
		while (run) {
			System.out.println();
			System.out.println(Arrays.toString(ids));
			System.out.println(Arrays.toString(pws));
			System.out.println("1.가입");
			System.out.println("2.탈퇴");
			System.out.print("메뉴 선택 (종료 : -100): ");
			int sel = sc.nextInt();
			if (sel == -100) {
				break;
			}
			if (sel != 1 && sel != 2) {
				System.out.println("메뉴 선택 오류");
				continue;
			}
			if (sel == 1 && cnt == 5) {
				System.out.println("더 이상 가입할 수 없습니다");
				continue;
			}
			System.out.print("ID : ");
			int id = sc.nextInt();
			System.out.print("PW : ");
			int pw = sc.nextInt();
			if (id >= 10000 || pw >= 10000 || id < 1000 || pw < 1000) {
				System.out.println("4자리 숫자를 입력해주세요");
				continue;
			}
			boolean matchId = false;
			int idx = cnt;
			for (int i = 0; i < ids.length; i++) {
				if (ids[i] == id) {
					matchId = true;
					idx = i;
					break;
				}
			}
			if (sel == 1) {
				if (matchId) {
					System.out.println("이미 존재하는 아이디입니다");
					continue;
				}
				ids[cnt] = id;
				pws[cnt] = pw;
				cnt++;
				System.out.println(id + "님 가입 완료 되었습니다");
			} else {
				if (!matchId) {
					System.out.println("존재하지 않는 회원입니다");
					continue;
				}
				if (pws[idx] != pw) {
					System.out.println("PW를 확인해주세요");
					continue;
				}
				for (int i = idx; i < cnt - 1; i++) {
					ids[i] = ids[i + 1];
					pws[i] = pws[i + 1];
				}
				cnt--;
				ids[cnt] = 0;
				pws[cnt] = 0;
				System.out.println(id + "님 탈퇴 완료 되었습니다");
			}
		}
		System.out.println("프로그램 종료");
		sc.close();
		// 소요 시간 : 31분 55초
	}

}
