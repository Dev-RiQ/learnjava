
package 문자열심화;

import java.util.Scanner;

public class _06장바구니 {

	public static void main(String[] args) {
		/*
		 	로그인, 로그아웃, 쇼핑, 장바구니, 전체 회원 장바구니 목록, 종료
		 	쇼핑- 사과, 바나나, 딸기, 종료
		 	장바구니 - 아이템 삭제, 전체 삭제, 종료 (없으면 비었다)
		 	아이템 삭제 - 삭제 아이템 이름 입력
		 */
		Scanner sc = new Scanner(System.in);
		String[] id = { "qwer", "java", "abcd" };
		String[] pw = { "1111", "2222", "3333" };
		String[] item = { "사과", "바나나", "딸기" };
		String[][] cartTotal = new String[1000][3];
		int[] sellTotal = new int[3];
		int[][] cartPersonal = new int[id.length][item.length + 1];
		int log = -1;
		int cartCnt = 0;
		boolean isIn[][] = new boolean[id.length][item.length];
		while (true) {
			System.out.println("[ MEGA MART ]");
			if (log != -1) {
				System.out.println("[1]로그아웃");
				System.out.println("[2]쇼핑");
				System.out.println("[3]장바구니");
			} else {
				System.out.println("[1]로그인");
			}
			System.out.println("[4]전체 회원 장바구니 이력");
			System.out.println("[0]종료");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("쇼핑을 종료합니다.");
				break;
			}
			if (sel < 1 || sel > 4) {
				System.out.println("입력 오류입니다.");
				continue;
			}
			if ((sel == 2 || sel == 3) && log == -1) {
				System.out.println("로그인 후 선택 가능한 메뉴입니다.");
				continue;
			}
			if (sel == 1) {
				if (log != -1) {
					System.out.println(id[log] + "님 로그아웃 하셨습니다.");
					log = -1;
				} else {
					while (true) {
						boolean isLogIn = false;
						System.out.print("ID : ");
						String inputId = sc.next();
						System.out.print("PW : ");
						String inputPw = sc.next();
						for (int i = 0; i < id.length; i++) {
							if (inputId.equals(id[i]) && inputPw.equals(pw[i])) {
								isLogIn = true;
								log = i;
								break;
							}
						}
						if (isLogIn) {
							System.out.println(inputId + "님 로그인 하셧습니다.");
							break;
						}
						System.out.println("ID 혹은 PW를 확인해주세요.");
					}
				}
			} else if (sel == 2) {
				while (true) {
					System.out.println("[ 쇼     핑 ]");
					System.out.println("[ 1 ]사과  [ 2 ]바나나  [ 3 ]딸기  [ 0 ]종료");
					System.out.println("아이템 선택  >> ");
					int selItem = sc.nextInt();
					if (selItem == 0) {
						break;
					}
					if (selItem < 1 || selItem > 3) {
						System.out.println("입력 오류입니다.");
						continue;
					}
					while (true) {
						System.out.println("담을 갯수 입력 (1~999개) (0. 종료) >>");
						int itemCnt = sc.nextInt();
						if (itemCnt == 0) {
							System.out.println("장바구니 담기가 취소되었습니다.");
							break;
						}
						if (itemCnt < 1 || itemCnt > 999) {
							System.out.println("갯수 입력 오류입니다.");
							continue;
						}
						cartPersonal[log][selItem - 1] += itemCnt;
						cartPersonal[log][3] += itemCnt;
						sellTotal[selItem - 1] += itemCnt;
						isIn[log][selItem - 1] = true;
						cartTotal[cartCnt][0] = id[log];
						cartTotal[cartCnt][1] = item[selItem - 1];
						cartTotal[cartCnt++][2] = itemCnt + "";
						break;
					}
					System.out.println(item[selItem - 1] + " " + cartPersonal[log][selItem - 1] + "개 장바구니 추가 완료");
				}
			} else if (sel == 3) {
				System.out.println("[ " + id[log] + "님의 장바구니 목록 ] [ 총 아이템 갯수 : " + cartPersonal[log][3] + "]");
				boolean isHave = false;
				for (int i = 0; i < item.length; i++) {
					if (cartPersonal[log][i] != 0) {
						System.out.printf("           [%4s] [%5d개]\n", item[i], cartPersonal[log][i]);
						isHave = true;
					}
				}
				if (!isHave) {
					System.out.println("   [ 장바구니에 추가된 아이템이 없습니다. ]");
					continue;
				}
				while (true) {
					System.out.println("[1]아이템 삭제  [2]전체 삭제  [0]종료");
					System.out.print("메뉴 선택 >> ");
					int selCart = sc.nextInt();
					if (selCart == 0) {
						System.out.println("장바구니가 종료되었습니다.");
						break;
					}
					if (selCart < 1 || selCart > 2) {
						System.out.println("입력 오류입니다.");
						continue;
					}
					if (selCart == 1) {
						while (true) {
							System.out.println("[ 아이템 삭제 ]");
							for (int i = 0; i < isIn[log].length; i++) {
								if (isIn[log][i]) {
									System.out.print("[" + (i + 1) + "]" + item[i] + " ");
								}
							}
							System.out.println();
							System.out.print("삭제할 아이템 선택 (0. 종료) >> ");
							int selDel = sc.nextInt();
							if (selDel == 0) {
								System.out.println("아이템 삭제가 취소되었습니다.");
								break;
							}
							if (selDel < 1 || selDel > 3) {
								System.out.println("입력 오류입니다.");
								continue;
							}
							if (!isIn[log][selDel - 1]) {
								System.out.println("해당 번호의 아이템은 담겨있지 않습니다.");
								continue;
							}
							while (true) {
								System.out.println("[ 삭제 수량 입력 ]");
								System.out.print(item[selDel - 1] + " 삭제 수량 (0. 취소) >>");
								int cntDel = sc.nextInt();
								if (cntDel == 0) {
									System.out.println("해당 아이템 삭제를 취소합니다.");
									break;
								}
								if (cntDel < 1 || cntDel > cartPersonal[log][selDel - 1]) {
									System.out.println("유효한 수량을 입력하세요.(1~" + cartPersonal[log][selDel - 1] + ")");
									continue;
								}
								System.out.println(item[selDel - 1] + " " + cntDel + "개 삭제 완료되었습니다.");
								cartPersonal[log][selDel - 1] -= cntDel;
								cartPersonal[log][3] -= cntDel;
								sellTotal[selDel - 1] -= cntDel;
								cartTotal[cartCnt][0] = id[log];
								cartTotal[cartCnt][1] = item[selDel - 1];
								cartTotal[cartCnt++][2] = "-" + cntDel + "";
								if (cartPersonal[log][selDel - 1] == 0) {
									isIn[log][selDel - 1] = false;
								}
								System.out.println(
										"현재 " + item[selDel - 1] + " 잔여 수량 : " + cartPersonal[log][selDel - 1] + "개");
								break;
							}
							break;
						}

					} else {
						System.out.println(id[log] + "님의 장바구니가 모두 삭제 되었습니다.");
						for (int i = 0; i < item.length; i++) {
							if (cartPersonal[log][i] != 0) {
								sellTotal[i] -= cartPersonal[log][i];
								cartTotal[cartCnt][0] = id[log];
								cartTotal[cartCnt][1] = item[i];
								cartTotal[cartCnt++][2] = "-" + cartPersonal[log][i] + "";
							}
						}
						cartPersonal[log] = new int[item.length + 1];
						isIn[log] = new boolean[item.length];
					}
					break;
				}
			} else {
				System.out.println("[ 회원별 장바구니 종합 ]");
				System.out.println();
				for (int i = 0; i < cartPersonal.length; i++) {
					System.out.printf("[ %s ][  총 : %5d개  ]\n", id[i], cartPersonal[i][3]);
					System.out.print("        ");
					for (int k = 0; k < item.length; k++) {
						System.out.printf("[%3s : %4d개]", item[k], cartPersonal[i][k]);
					}
					System.out.println();
					System.out.println();
				}
				System.out.println("[ 전체 회원 장바구니 이력 ]");
				System.out.println(" [아이디] [아이템] [수량]");
				for (int i = 0; i < cartTotal.length; i++) {
					if (cartTotal[i][0] == null) {
						if (i == 0) {
							System.out.println("장바구니 이력이 존재하지 않습니다.");
						}
						break;
					}
					for (int k = 0; k < cartTotal[i].length; k++) {
						System.out.printf("[ %5s" + (k == 2 ? "개 ]" : " ]"), cartTotal[i][k]);
					}
					System.out.println();
				}
			}
			System.out.println();
		}
		sc.close();
	}

}
