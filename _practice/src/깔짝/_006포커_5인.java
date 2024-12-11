package 깔짝;

import java.util.*;

import _01.BACKGROUND;
import _01.FONT;

public class _006포커_5인 {

	public static int[][] cardPack = cardPackSet();
	public static int[][] playerCard = new int[5][7];
	public static int turn = 0;
	public static int[] rank = new int[5];

	public static void reRoll() {
		cardPack = cardPackSet();
		playerCard = new int[5][7];
	}

	public static int[][] cardPackSet() {
		int[][] card = new int[4][13];
		for (int i = 0; i < card.length; i++) {
			for (int k = 0; k < card[i].length; k++) {
				card[i][k] = i * 13 + k + 1;
			}
		}
		return card;
	}

	public static int[] cardPick() {
		Random rd = new Random();
		int[] idx = new int[2];
		while (true) {
			idx[0] = rd.nextInt(4);
			idx[1] = rd.nextInt(13);
			if (cardPack[idx[0]][idx[1]] != 0) {
				break;
			}
		}
		return idx;
	}

	public static void cardShare(int a) {
		int s = 0;
		int f = 3;
		if (a != 0) {
			s = 2 + a;
			f = s + 1;
		}
		for (int k = s; k < f; k++) {
			for (int i = 0; i < playerCard.length; i++) {
				if (die && i == 4) {
					break;
				}
				int[] idx = cardPick();
				if (playerCard[i][k] == 0) {
					playerCard[i][k] = cardPack[idx[0]][idx[1]];
					cardPack[idx[0]][idx[1]] = 0;
				}
			}
		}
		cardListUpMe();
	}

	public static void cardListUpMe() {
		for (int i = 4; i < 5; i++) {
			if (die && i == 4) {
				break;
			}
			for (int k = 0; k < playerCard[i].length; k++) {
				for (int j = k + 1; j < playerCard[i].length; j++) {
					int card1 = playerCard[i][k];
					int card2 = playerCard[i][j];
					int num1 = card1 % 13 == 0 ? 13 : card1 % 13;
					int num2 = card2 % 13 == 0 ? 13 : card2 % 13;
					if (num1 > num2 && card1 != 0 && card2 != 0) {
						playerCard[i][k] = card2;
						playerCard[i][j] = card1;
					}

				}
			}
			for (int k = 0; k < playerCard[i].length; k++) {
				for (int j = k + 1; j < playerCard[i].length; j++) {
					int card1 = playerCard[i][k];
					int card2 = playerCard[i][j];
					int num1 = card1 % 13 == 0 ? 13 : card1 % 13;
					int num2 = card2 % 13 == 0 ? 13 : card2 % 13;
					if (num1 == num2) {
						int shape1 = num1 == 0 ? card1 / 13 - 1 : card1 / 13;
						int shape2 = num2 == 0 ? card2 / 13 - 1 : card2 / 13;
						if (shape1 > shape2 && card1 != 0 && card2 != 0) {
							playerCard[i][k] = card2;
							playerCard[i][j] = card1;
						}
					}

				}
			}

		}
	}

	public static void cardListUp() {
		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < playerCard[i].length; k++) {
				for (int j = k + 1; j < playerCard[i].length; j++) {
					int card1 = playerCard[i][k];
					int card2 = playerCard[i][j];
					int num1 = card1 % 13 == 0 ? 13 : card1 % 13;
					int num2 = card2 % 13 == 0 ? 13 : card2 % 13;
					if (num1 > num2 && card1 != 0 && card2 != 0) {
						playerCard[i][k] = card2;
						playerCard[i][j] = card1;
					}

				}
			}
			for (int k = 0; k < playerCard[i].length; k++) {
				for (int j = k + 1; j < playerCard[i].length; j++) {
					int card1 = playerCard[i][k];
					int card2 = playerCard[i][j];
					int num1 = card1 % 13 == 0 ? 13 : card1 % 13;
					int num2 = card2 % 13 == 0 ? 13 : card2 % 13;
					if (num1 == num2) {
						int shape1 = num1 == 0 ? card1 / 13 - 1 : card1 / 13;
						int shape2 = num2 == 0 ? card2 / 13 - 1 : card2 / 13;
						if (shape1 > shape2 && card1 != 0 && card2 != 0) {
							playerCard[i][k] = card2;
							playerCard[i][j] = card1;
						}
					}

				}
			}

		}
	}

	public static void showCard() {
		for (int i = 0; i < playerCard.length; i++) {
			if (die && i == 4) {
				break;
			}
			System.out.print(i == 4 ? "  Me     : " : ("Player " + (i + 1) + " : "));
			System.out.printf("%,16d 원\n", money[i]);
			for (int k = 0; k < playerCard[i].length; k++) {
				if (i != 4 && (k > 5 || k<2)) {
					if (playerCard[i][k] != 0) {
						System.out.print(BACKGROUND.BLACK_BRIHT(""));
						System.out.print("┃");
						System.out.print("   ");
					}
				} else {
					int temp = playerCard[i][k] % 13 == 0 ? 13 : playerCard[i][k] % 13;
					int temp2 = playerCard[i][k] % 13 == 0 ? playerCard[i][k] / 13 - 1 : playerCard[i][k] / 13;
					if (playerCard[i][k] != 0) {
						System.out.print(BACKGROUND.WHITE_BRIHT(""));
						System.out.print("┃");
						System.out.print(temp2 == 1 || temp2 == 2 ? FONT.RED_BOLD_BRIGHT("") : FONT.BLACK_BOLD(""));
						System.out
								.print(temp == 1 ? "A" : temp == 11 ? "J" : temp == 12 ? "Q" : temp == 13 ? "K" : temp);
					} else {
						System.out.print(FONT.RESET());
					}
					System.out.print(temp == 10 ? " " : "  ");
				}
			}
			System.out.println();
			for (int k = 0; k < playerCard[i].length; k++) {
				if (i != 4 && (k > 5||k<2)) {
					if (playerCard[i][k] != 0) {
						System.out.print(BACKGROUND.BLACK_BRIHT(""));
						System.out.print("┃");
						System.out.print("   ");
					}
				} else {
					int temp2 = playerCard[i][k] % 13 == 0 ? playerCard[i][k] / 13 - 1 : playerCard[i][k] / 13;
					if (playerCard[i][k] != 0) {
						System.out.print(BACKGROUND.WHITE_BRIHT(""));
						System.out.print("┃");
						System.out.print(temp2 == 1 || temp2 == 2 ? FONT.RED_BOLD_BRIGHT("") : FONT.BLACK_BOLD(""));
						System.out.print(temp2 == 0 ? "♠" : temp2 == 1 ? "◆" : temp2 == 2 ? "♥" : "♣");
					} else {
						System.out.print(FONT.RESET());
					}
					System.out.print("  ");
				}
			}
			System.out.println(FONT.RESET());
			System.out.println();
		}
	}

	public static void showRs() {
		cardListUp();
		for (int i = 0; i < playerCard.length; i++) {
			if (die && i == 4) {
				break;
			}
			System.out.print(i == 4 ? "  Me     : " : ("Player " + (i + 1) + " : "));
			System.out.printf("%,16d 원\n", money[i]);
			for (int k = 0; k < playerCard[i].length; k++) {
				int temp = playerCard[i][k] % 13 == 0 ? 13 : playerCard[i][k] % 13;
				int temp2 = playerCard[i][k] % 13 == 0 ? playerCard[i][k] / 13 - 1 : playerCard[i][k] / 13;
				if (playerCard[i][k] != 0) {
					System.out.print(BACKGROUND.WHITE_BRIHT(""));
					System.out.print("┃");
					System.out.print(temp2 == 1 || temp2 == 2 ? FONT.RED_BOLD_BRIGHT("") : FONT.BLACK_BOLD(""));
					System.out.print(temp == 1 ? "A" : temp == 11 ? "J" : temp == 12 ? "Q" : temp == 13 ? "K" : temp);
				} else {
					System.out.print(FONT.RESET());
				}
				System.out.print(temp == 10 ? " " : "  ");
			}
			System.out.println();
			for (int k = 0; k < playerCard[i].length; k++) {
				int temp2 = playerCard[i][k] % 13 == 0 ? playerCard[i][k] / 13 - 1 : playerCard[i][k] / 13;
				if (playerCard[i][k] != 0) {
					System.out.print(BACKGROUND.WHITE_BRIHT(""));
					System.out.print("┃");
					System.out.print(temp2 == 1 || temp2 == 2 ? FONT.RED_BOLD_BRIGHT("") : FONT.BLACK_BOLD(""));
					System.out.print(temp2 == 0 ? "♠" : temp2 == 1 ? "◆" : temp2 == 2 ? "♥" : "♣");
				} else {
					System.out.print(FONT.RESET());
				}
				System.out.print("  ");
			}
			System.out.println(FONT.RESET());
			System.out.print(BACKGROUND.WHITE_BRIHT("") + FONT.BLACK_BOLD(""));
			System.out.print(i == 4 ? "Me : " : ("Player " + (i + 1) + " : "));
			System.out.print(result()[i]);
			System.out.println(" (" + rank[i] + "등)");
			System.out.print(FONT.RESET());
			System.out.println();
		}
		for (int k = 0; k < rank.length; k++) {
			if (rank[k] == 1) {
				System.out.println("승자 : " + (k == 4 ? "Me" : "Player " + (k + 1)));
				System.out.println(" + " + totalMoney);
				money[k] += totalMoney;
			}
		}
		for (int i = 0; i < rank.length; i++) {
			System.out.print((i == 4 ? "      Me" : "Player " + (i + 1)));
			System.out.printf(" 현재 보유 금액 : %,16d\n", money[i]);
		}
	}

	public static String[] result() {
		String[] rankWhat = new String[5];
		int[] rankTop = new int[5];
		int[] rankWin = new int[5];
		int[] rankTopNum = new int[5];
		int[] rankTopShape = { 4, 4, 4, 4, 4 };
		for (int i = 0; i < playerCard.length; i++) {
			if (die && i == 4) {
				break;
			}
			int[] shape = new int[4];
			boolean flush = false;
			boolean straight = false;
			boolean straightBack = false;
			boolean[] numHave = new boolean[13];
			int[] nums = new int[13];
			boolean pare = false;
			boolean pare2 = false;
			boolean pare3 = false;
			boolean threeple = false;
			boolean fourCard = false;
			boolean mountain = false;
			int[] st = new int[7];
			int[] stS = new int[7];
			int pareNum1 = 0;
			int pareNum2 = 0;
			int pareNum3 = 0;
			int stCnt = 0;
			for (int k = 0; k < playerCard[i].length; k++) {
				int temp = playerCard[i][k] % 13 == 0 ? 13 : playerCard[i][k] % 13;
				int temp2 = playerCard[i][k] % 13 == 0 ? playerCard[i][k] / 13 - 1 : playerCard[i][k] / 13;
				numHave[temp - 1] = true;
				st[k] = temp;
				stS[k] = temp2;
				if (numHave[0] && numHave[9] && numHave[10] && numHave[11] && numHave[12]) {
					mountain = true;
					rankTopNum[i] = st[0];
					rankTopShape[i] = stS[0];
					break;
				}
				if (numHave[0] && numHave[1] && numHave[2] && numHave[3] && numHave[4]) {
					straightBack = true;
					rankTopNum[i] = st[0];
					rankTopShape[i] = stS[0];
					break;
				}
				int idx = -1;
				for (int j = 0; j < numHave.length; j++) {
					if (numHave[j]) {
						stCnt++;
						idx++;
						if (idx < 6 && st[idx] == st[idx + 1]) {
							if (idx < 5 && st[idx] == st[idx + 2]) {
								idx++;
							}
							idx++;
						}
					} else {
						stCnt = 0;
					}
					if (stCnt == 5) {
						straight = true;
						rankTopNum[i] = j + 1;
						rankTopShape[i] = stS[idx];
						if (idx < 6 && st[idx] + 1 == st[idx + 1]) {
							rankTopNum[i]++;
							rankTopShape[i] = stS[idx + 1];
							if (idx < 5 && st[idx] + 2 == st[idx + 2]) {
								rankTopNum[i]++;
								rankTopShape[i] = stS[idx + 2];
							}
						}
						break;
					}
				}
				if (stCnt == 5) {
					break;
				}
				shape[temp2]++;
				if (shape[temp2] == 5) {
					flush = true;
					if (rankTopNum[i] < temp) {
						rankTopNum[i] = temp;
						rankTopShape[i] = temp2;
					}
					for (int j = 0; j < 3; j++) {
						if (st[j] == 1 && stS[j] == temp2) {
							rankTopNum[i] = 1;
						}
					}
					break;
				}
				nums[temp - 1]++;
				if (nums[temp - 1] == 4) {
					fourCard = true;
					threeple = false;
					if (rankTopNum[i] < temp || temp == 1) {
						rankTopNum[i] = temp;
						rankTopShape[i] = stS[k - 3];
					}
					break;
				} else if (nums[temp - 1] == 3) {
					threeple = true;
					if (temp == pareNum1) {
						pare = false;
					} else if (temp == pareNum2) {
						pare2 = false;
					} else if (temp == pareNum3) {
						pare3 = false;
					}
					if (rankTopNum[i] < temp || temp == 1) {
						rankTopNum[i] = st[k];
						rankTopShape[i] = stS[k - 2];
					}
				} else if ((nums[temp - 1] == 2 && pare && pare2)) {
					pare3 = true;
					pareNum3 = temp;
					if ((rankTopNum[i] < temp || temp == 1) && rankTopNum[i] != 1 && !threeple) {
						rankTopNum[i] = temp;
						rankTopShape[i] = stS[k - 1];
					}
				} else if (nums[temp - 1] == 2 && pare) {
					pare2 = true;
					pareNum2 = temp;
					if ((rankTopNum[i] < temp || temp == 1) && rankTopNum[i] != 1 && !threeple) {
						rankTopNum[i] = temp;
						rankTopShape[i] = stS[k - 1];
					}
				} else if (nums[temp - 1] == 2) {
					pare = true;
					pareNum1 = temp;
					if ((rankTopNum[i] < temp || temp == 1) && rankTopNum[i] != 1 && !threeple) {
						rankTopNum[i] = temp;
						rankTopShape[i] = stS[k - 1];
					}
				}
			}
			rankWhat[i] = "";
			if (mountain && flush) {
				rankTop[i] = 1;
				rankWhat[i] += " 로얄 스트레이트 플러쉬";
			} else if (straightBack && flush) {
				rankTop[i] = 2;
				rankWhat[i] += " 백 스트레이트 플러쉬";
			} else if (straight && flush) {
				rankTop[i] = 3;
				rankWhat[i] += " 스트레이트 플러쉬";
			} else if (fourCard) {
				rankTop[i] = 4;
				rankWhat[i] += " 포카드";
			} else if (threeple && (pare || pare2 || pare3)) {
				rankTop[i] = 5;
				rankWhat[i] += " 풀하우스";
			} else if (flush) {
				rankTop[i] = 6;
				rankWhat[i] += " 플러쉬";
			} else if (mountain) {
				rankTop[i] = 7;
				rankWhat[i] += " 마운틴";
			} else if (straightBack) {
				rankTop[i] = 8;
				rankWhat[i] += " 백 스트레이트";
			} else if (straight) {
				rankTop[i] = 9;
				rankWhat[i] += " 스트레이트";
			} else if (threeple) {
				rankTop[i] = 10;
				rankWhat[i] += " 트리플";
			} else if (pare3) {
				rankTop[i] = 11;
				rankWhat[i] += " 투페어";
			} else if (pare && pare2) {
				rankTop[i] = 11;
				rankWhat[i] += " 투페어";
			} else if (pare) {
				rankTop[i] = 12;
				rankWhat[i] += " 원페어";
			} else {
				rankTopNum[i] = st[0] == 1 ? st[0] : st[6];
				rankTopShape[i] = st[0] == 1 ? stS[0] : stS[6];
				rankTop[i] = 13;
				rankWhat[i] += " 탑";
			}
		}
		for (int i = 0; i < rankTop.length; i++) {
			if (die && i == 4) {
				break;
			}
			rankWin[i] = die ? 0 : 1;
			for (int k = 0; k < rankTop.length; k++) {
				if (i != k && rankTop[i] > rankTop[k]) {
					rankWin[i]++;
				}
			}
		}
		int rankSameCnt = 0;
		for (int i = 0; i < rankWin.length; i++) {
			if (die && i == 4) {
				break;
			}
			for (int k = i + 1; k < rankWin.length; k++) {
				if (rankWin[i] == rankWin[k]) {
					rankSameCnt++;
					break;
				}
			}
		}
		for (int i = 0; i < rankWin.length; i++) {
			if (die && i == 4) {
				break;
			}
			boolean isMore = false;
			for (int k = 0; k < rankWin.length; k++) {
				if (i != k && rankWin[i] == rankWin[k]) {
					if (rankTopNum[k] == rankTopNum[i]) {
						if (rankTopShape[k] > rankTopShape[i]) {
							rankWin[k]++;
						} else if (rankTopShape[k] < rankTopShape[i]) {
							rankWin[i]++;
							i = k;
						}
					} else if ((rankTopNum[i] == 1 || (rankTopNum[k] != 1 && rankTopNum[i] > rankTopNum[k]))) {
						rankWin[k]++;
					} else if ((rankTopNum[k] == 1 || (rankTopNum[i] != 1 && rankTopNum[i] < rankTopNum[k]))) {
						rankWin[i]++;
						i = k;
					}
					isMore = true;
				}
				if (k == rankWin.length - 1) {
					rankSameCnt--;
				}
			}
			if (!isMore && i == rankWin.length - 1 && rankSameCnt == 0) {
				break;
			}
			if (isMore) {
				i = -1;
			}
		}

		for (int i = 0; i < rankWhat.length; i++) {
			if (die && i == 4) {
				break;
			}
			String temp = rankWhat[i];
			rankWhat[i] = "";
			rankWhat[i] += (rankTopShape[i] == 1 || rankTopShape[i] == 2 ? FONT.RED_BOLD_BRIGHT("")
					: FONT.BLACK_BOLD(""));
			rankWhat[i] += (rankTopShape[i] == 0 ? "♠" : rankTopShape[i] == 1 ? "◆" : rankTopShape[i] == 2 ? "♥" : "♣");
			rankWhat[i] += (rankTopNum[i] == 1 ? "A"
					: rankTopNum[i] == 11 ? "J"
							: rankTopNum[i] == 12 ? "Q" : rankTopNum[i] == 13 ? "K" : rankTopNum[i]);
			rankWhat[i] += FONT.BLACK_BOLD("");
			rankWhat[i] += temp;
		}
		rank = rankWin;
		return rankWhat;
	}

	public static boolean die = false;
	public static int[] money = { 10000000, 10000000, 10000000, 10000000, 10000000 };
	public static int baseMoney = 10000;
	public static int betMoney = 10000;
	public static int totalMoney = 0;
	public static int startPlayer = 1;

	public static void moneyRound() {
		for (int i = 0; i < money.length; i++) {
			if (die && i == 4) {
				break;
			}
			if (money[i] <= 0) {
				if (i == 0) {
					betMoney = 0;
				}
				continue;
			}
			if (money[i] < betMoney) {
				if (i == 0) {
					betMoney = money[i];
				}
				totalMoney += money[i];
				money[i] = 0;
				continue;
			}
			if (turn == 0) {
				money[i] -= baseMoney;
				totalMoney += baseMoney;
			} else {
				money[i] -= betMoney;
				totalMoney += betMoney;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			while (true) {
				System.out.println("현재 콜당 금액 : " + betMoney);
				moneyRound();
				if (betMoney == 0) {
					betMoney = baseMoney;
				}
				cardShare(turn);
				showCard();
				turn++;
				System.out.println("누적 판돈 : " + totalMoney);
				while (!die) {
					int input = 0;
					System.out.print("1.체크   ");
					System.out.print("2.콜     ");
					System.out.println(turn != 1 ? "3.레이즈 (X2) " : "");
					System.out.print(turn != 1 ? "4.올인   5.다이 " : "         5.다이 ");
					input = sc.nextInt();
					if (input < 1 || input > 5) {
						continue;
					}
					if (turn == 1 && input > 2 && input < 5) {
						continue;
					}
					if (input == 1) {
						System.out.println("체크");
						betMoney = 0;
					} else if (input == 2) {
						System.out.println("콜");
					} else if (input == 3) {
						System.out.println("레이즈 (X2)");
						if (turn == 5) {
							turn--;
						}
						betMoney *= 2;
					} else if (input == 4) {
						System.out.println("올인");
						betMoney = money[4];
					} else if (input == 5) {
						System.out.println("다이");
						die = true;
					}
					break;
				}
				if (turn == 5) {
					moneyRound();
					showRs();
					reRoll();
					betMoney = baseMoney;
					die = false;
					totalMoney = 0;
					turn = 0;
					break;
				}
			}
			for (int i = 0; i < 4; i++) {
				if (money[i] == 0) {
					money[i] = 10000000;
				}
			}
			if (money[4] == 0) {
				System.out.println("다 꼴았으니 충전 해드립니다..");
				money[4] = 10000000;
			}
			System.out.println("1.새 게임   2.판돈 설정 후 새 게임   0.종료");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("게임 종료");
				break;
			}
			if (sel == 2) {
				int moneyUp = 10000;
				while (true) {
					System.out.print("판돈 (10000~1000000) >> ");
					moneyUp = sc.nextInt();
					if (moneyUp < 10000 || moneyUp > 1000000) {
						continue;
					}
					break;
				}
				baseMoney = moneyUp;
				betMoney = baseMoney;
			}
		}
		sc.close();
	}

}
