package 문자열심화;

import java.util.Scanner;

public class _01장바구니1단계 {

	public static void main(String[] args) {

		/*
		 	1. 로그인 후, 쇼핑 메뉴를 선택하면
		 		다음과 같은 상품 목록을 출력한다.
		 		(1)사과 (2)바나나 (3)딸기
		 	2. 번호를 선택해 상품을 장바구니에 담는다.
		 	3. 로그인 회원의 아이디는 cartList배열의 0에 저장한다.
		 	4. 해당 회원이 구매한 상품은 cartList배열의 1열에 저장한다.
		 	5. 장바구니 메뉴를 선택하면 로그인 한 회원의 구매 물품만 출력한다.
		 */
		Scanner sc = new Scanner(System.in);
		String[] idList = { "qwer", "javaking", "abcd" };
		String[] pwList = { "1111", "2222", "3333" };
		final int MAX_SIZE = 100;
		String[][] cartList = new String[MAX_SIZE][2];
		String[] items = { "사과", "바나나", "딸기" };
		int[][] cntItems = new int[idList.length][items.length+1];
		int log = -1;
		int cartIdx = 0;
		while (true) {
			if (log == -1) {
				System.out.println("[1]로그인");
			} else {
				System.out.println("[1]로그아웃");
				System.out.println("[2]쇼    핑");
				System.out.println("[3]장바구니");

			}
			System.out.println("[4]전체 회원 장바구니 목록");
			System.out.println("[0]종    료");
			System.out.print("메뉴 선택 >> ");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("종료되었습니다.");
				break;
			}
			if (sel < 1 || sel > 4) {
				System.out.println("입력 오류");
				continue;
			}
			if (log == -1 && (sel == 2 || sel == 3)) {
				System.out.println("로그인 후 이용 가능");
				continue;
			}
			if (sel == 1) {
				if (log == -1) {
					while (true) {
						System.out.print("id : ");
						String id = sc.next();
						System.out.print("pw : ");
						String pw = sc.next();
						for (int i = 0; i < idList.length; i++) {
							if (idList[i].equals(id) && pwList[i].equals(pw)) {
								log = i;
								break;
							}
						}
						if (log == -1) {
							System.out.println("id 혹은 pw 오류");
							continue;
						}
						break;
					}
				} else {
					System.out.println("로그아웃 되었습니다.");
					log = -1;
				}
			} else if (sel == 2) {
				while (true) {
					System.out.print("[1]사과  ");
					System.out.print("[2]바나나  ");
					System.out.print("[3]딸기  ");
					System.out.println("[0]종료");
					System.out.print("메뉴 선택 >> ");
					int order = sc.nextInt();
					if(cartIdx == MAX_SIZE) {
						System.out.println("장바구니가 가득차 자동 종료합니다.");
						break;
					}
					if (order == 0) {
						System.out.println("쇼핑 종료");
						break;
					}
					if (order < 1 || order > 3) {
						System.out.println("입력 오류");
						continue;
					}
					cartList[cartIdx][0] = idList[log];
					cartList[cartIdx][1] = items[order - 1];
					cntItems[log][order-1]++;
					cntItems[log][3]++;
					cartIdx++;
				}
			} else if (sel == 3) {
				System.out.println(idList[log]+"의 장바구니 / 담은 Items : "+cntItems[log][3]+"개");
				for (int i = 0; i < cntItems.length; i++) {
					if(cntItems[log][i]!=0) {
						System.out.println(items[i] + " : "+cntItems[log][i]+"개");
					}
				}
			} else if (sel == 4) {
				for (int i = 0; i < cartIdx; i++) {
					System.out.print(cartList[i][0] + "\t");
					System.out.println(cartList[i][1]);
				}
			}
		}
		sc.close();
	}

}
