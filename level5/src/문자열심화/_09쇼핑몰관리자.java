package 문자열심화;

import java.util.Scanner;

public class _09쇼핑몰관리자 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 기본 데이터
		String data = "과일,사과/포도\n";
		data += "과자,홈런볼/조리퐁\n";
		data += "음료,콜라/사이다/나랑드\n";
		data += "육류,소고기/돼지고기/오리고기/닭고기\n";
		
		String dataExport = ""; // 데이터 저장용
		String datas[] = data.split("\n");
		int categoryLen = 100;
		String[][] items = new String[categoryLen][2]; // [카테고리 명, 아이템명/아이템명/...]
		for (int i = 0; i < datas.length; i++) {
			items[i] = datas[i].split(",");
		}
		
		boolean isNon = false; // 카테고리 존재 여부 판단 (없을 시 항목 출력 없음 메세지)
		int categoryCnt = 0; // 카테고리 저장된 갯수
		
		// 기초 카테고리 갯수 측정
		for (int i = 0; i < categoryLen; i++) {
			if (items[i][0] == null) {
				break;
			}
			categoryCnt++;
		}
		
		//메인 메뉴
		while (true) {
			System.out.println("--------------------------");
			System.out.println("[관리자모드]");
			System.out.println("[1]카테고리 관리");
			System.out.println("[2]아이템 관리");
			System.out.println("[3]전체품목 출력");
			System.out.println("[4]데이터 저장");
			System.out.println("[0]종료");
			System.out.println("--------------------------");
			System.out.print("메뉴 >> ");
			int menu = sc.nextInt();
			if (menu == 0) {
				System.out.println("관리자모드를 종료합니다.");
				break;
			}
			if (menu < 1 || menu > 4) {
				System.err.println("존재하지 않는 메뉴입니다.");
				continue;
			}
			switch (menu) {
			
			// 카테고리 관리 메뉴
			case 1:
				while (true) {
					isNon = categoryCnt == 0 ? true : false;
					System.out.println("--------------------------");
					System.out.println("[카테고리 관리]");
					for (int i = 0; i < categoryLen; i++) {
						if (items[i][0] == null) {
							break;
						}
						System.out.printf("[%d] %s\n", i + 1, items[i][0]);
					}
					if (isNon) {
						System.err.println("현재 등록된 데이터가 없습니다.");
					}
					System.out.println("--------------------------");
					System.out.println("(1)추가 (2)삭제 (3)뒤로 >> ");
					int menu1 = sc.nextInt();
					if (menu1 < 1 || menu1 > 3) {
						System.err.println("존재하지 않는 메뉴입니다.");
						continue;
					}
					if (menu1 == 3) {
						System.out.println("관리자 메뉴로 돌아갑니다.");
						break;
					}
					switch (menu1) {
					
					// 카테고리 관리 메뉴 -> 추가
					case 1:
						if (categoryCnt == categoryLen) {
							System.err.println("더 이상 추가할 공간이 없습니다.");
							System.err.println("공간을 확장하거나 기존 데이터를 삭제해주세요.");
							continue;
						}
						System.out.print("[추가] 카테고리 입력 >> ");
						sc.nextLine();
						String categoryAdd = sc.nextLine();
						if (categoryAdd.isBlank()) {
							System.err.println("공백은 입력할 수 없습니다.");
							continue;
						}
						
						// 중복 체크 후 카테고리 추가
						boolean isHave = false;
						int idx = -1;
						for (int i = 0; i < categoryLen; i++) {
							if (items[i][0] == null) {
								idx = i;
								break;
							}
							if (categoryAdd.equals(items[i][0])) {
								isHave = true;
								break;
							}
						}
						if (isHave) {
							System.err.println("[메세지] 카테고리 이름 중복");
						} else {
							items[idx][0] = categoryAdd;
							categoryCnt++;
							System.out.printf("[%d]번에 카테고리 [%s]가 추가되었습니다.\n", idx + 1, categoryAdd);
						}
						break;
						
					//카테고리 관리 메뉴 ->  삭제
					case 2:
						if (isNon) {
							System.err.println("삭제할 데이터가 없습니다.");
							continue;
						}
						System.out.print("[삭제] 카테고리 번호 입력 >> ");
						int categoryDel = sc.nextInt() - 1;
						if (items[categoryDel][0] == null) {
							System.err.println("존재하지 않는 카테고리 번호입니다.");
							continue;
						}
						if (items[categoryDel][1] != null) {
							System.err.println("선택하신 카테고리에 아이템이 남아있습니다.");
							System.out.print("(1)모두 삭제 (2)삭제 취소 >> ");
							int selDel = sc.nextInt();
							if (selDel < 1 || selDel > 2) {
								System.err.println("존재하지 않는 메뉴입니다.");
								continue;
							}
							if (selDel == 2) {
								System.out.println("카테고리 삭제를 취소합니다.");
								continue;
							}
							System.out.printf("카테고리 [ %s ]가 삭제되었습니다.\n", items[categoryDel][0]);
							categoryCnt--;
							
							// 삭제 인덱스 기준 앞으로 당겨오기
							for (int i = categoryDel; i < categoryLen; i++) {
								if (items[i][0] == null) {
									items[i] = new String[2];
									break;
								}
								items[i][0] = items[i + 1][0];
								items[i][1] = items[i + 1][1];
							}
						}
						break;
					}

				}
				break;
				
			// 아이템 관리 메뉴
			case 2:
				if (isNon) {
					System.err.println("생성된 카테고리가 없습니다.");
					System.err.println("카테고리를 먼저 등록해주세요.");
					continue;
				}
				System.out.println("--------------------------");
				System.out.println("[아이템 관리]");
				for (int i = 0; i < categoryLen; i++) {
					if (items[i][0] == null) {
						break;
					}
					System.out.printf("[%d] %s\n", i + 1, items[i][0]);
				}
				System.out.println("--------------------------");
				System.out.print("[관리] 카테고리 번호 입력 >> ");
				int categoryIdx = sc.nextInt() - 1;
				if (categoryIdx < 0 || categoryIdx > categoryCnt - 1) {
					System.err.println("없는 카테고리 번호입니다.");
					continue;
				}
				
				// 카테고리 선택 후 카테고리별 아이템 관리
				while (true) {
					System.out.printf("[ %s ]\n", items[categoryIdx][0]);
					String[] temp = items[categoryIdx][1] == null ? null : items[categoryIdx][1].split("/");
					if (items[categoryIdx][1] == null) {
						System.err.println("아이템 없음");
					} else {
						for (int i = 0; i < temp.length; i++) {
							System.out.printf("(%d) %s\n", i + 1, temp[i]);
						}
					}
					System.out.println("(1)추가 (2)삭제 (3)뒤로 >> ");
					int sel = sc.nextInt();
					if (sel == 3) {
						System.out.println("아이템 추가를 종료합니다.");
						break;
					}
					switch (sel) {
					
					// 아이템 관리 메뉴 -> 추가
					case 1:
						System.out.print("추가할 아이템 입력 >> ");
						sc.nextLine();
						String inputItem = sc.nextLine();
						if (inputItem.isBlank()) {
							System.err.println("공백은 입력할 수 없습니다.");
							continue;
						}
						if (items[categoryIdx][1] == null) {
							items[categoryIdx][1] = inputItem;
							break;
						}
						
						//null이 아닐 때, 중복 체크 후 추가
						boolean isHave = false;
						for (int i = 0; i < temp.length; i++) {
							if (temp[i].equals(inputItem)) {
								isHave = true;
								break;
							}
						}
						if (isHave) {
							System.err.println("이미 존재하는 아이템입니다.");
							continue;
						}
						items[categoryIdx][1] += "/" + inputItem;
						System.out.printf("[ %s ] 아이템 추가가 완료되었습니다.\n", inputItem);
						break;
						
					// 아이템 관리 메뉴 -> 삭제
					case 2:
						if (items[categoryIdx][1] == null) {
							System.err.println("삭제할 아이템이 존재하지 않습니다.");
							continue;
						}
						System.out.print("삭제할 아이템 번호 입력 >> ");
						int delItem = sc.nextInt() - 1;
						if (delItem < 0 || delItem > temp.length - 1) {
							System.err.println("존재하지 않는 아이템 번호입니다.");
							continue;
						}
						items[categoryIdx][1] = "";
						
						// 삭제한 아이템 인덱스 기준 앞으로 당겨오기 및 마지막에 / 안붙이기
						for (int i = 0; i < temp.length; i++) {
							if (i != delItem) {
								if (delItem == temp.length - 1) {
									items[categoryIdx][1] += i == temp.length - 2 ? temp[i] : temp[i] + "/";
								} else {
									items[categoryIdx][1] += i == temp.length - 1 ? temp[i] : temp[i] + "/";
								}
							}
						}
						
						// 빈칸이라면 null로 반환
						if (items[categoryIdx][1].equals("")) {
							items[categoryIdx][1] = null;
						}
						System.out.printf("[ %s ] 아이템 삭제가 완료되었습니다.\n", temp[delItem]);
						break;
					}

				}
				break;
			
			// 전체 품목 출력 메뉴
			case 3:
				System.out.println("--------------------------");
				System.out.println("[전체 품목 출력]");
				for (int i = 0; i < categoryLen; i++) {
					if (items[i][0] == null) {
						break;
					}
					System.out.printf("[ %d] %s\t( %s )\n", i + 1, items[i][0],
							items[i][1] == null ? "아이템 없음" : items[i][1]);

				}
				if (isNon) {
					System.err.println("출력할 데이터가 없습니다.");
					continue;
				}
				System.out.println("--------------------------");
				System.out.println("전체 품목 출력이 완료되었습니다.");
				break;
				
			// 전체 데이터 저장 메뉴
			case 4:
				System.out.println("--------------------------");
				System.out.println("[데이터 저장]");
				dataExport = "";
				for (int i = 0; i < categoryLen; i++) {
					if (items[i][0] == null) {
						break;
					}
					dataExport += items[i][0] + "," + (items[i][1] == null ? "아이템 없음" : items[i][1]) + "\n";
				}
				if (isNon) {
					System.err.println("저장할 데이터가 없습니다.");
					continue;
				}
				System.out.println(dataExport);
				System.out.println("--------------------------");
				System.out.println("데이터가 성공적으로 저장되었습니다.");
				break;
			}
		}
		sc.close();
	}
}
