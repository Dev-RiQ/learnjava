package 깔짝;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import _01.BACKGROUND;
import _01.FONT;

public class _004캘린더 {

	public static int nowYear() {
		LocalDate now = LocalDate.now();
		int year = now.getYear();
		return year;
	}
	public static int nowMonth() {
		LocalDate now = LocalDate.now();
		int month = now.getMonthValue();
		return month;
	}
	public static int nowDay() {
		LocalDate now = LocalDate.now();
		int day = now.getDayOfMonth();
		return day;
	}
	public static int nowWeek() {
		LocalDate now = LocalDate.now();
		int week = now.getDayOfWeek().getValue();
		return week;
	}
	public static int[] monthData(int a) {
		// a = year, b = month
		int[] monthData = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		monthData[1] = (a % 4 == 0 && a % 100 != 0) || a % 400 == 0 ? 29 : 28;
		return monthData;
	}
	public static String week(int a, int b, int c) {
		// a = year, b = month, c = day
		int yearCnt = BASIC_YEAR;
		int monthCnt = BASIC_MONTH;
		int dayCnt = BASIC_DAY;
		int weekCnt = BASIC_WEEK;
		boolean isMatch = false;
		while (true) {
			for (int i = dayCnt; i <= monthData(yearCnt)[monthCnt - 1]; i++) {
				if (yearCnt == a && monthCnt == b && dayCnt == c) {
					isMatch = true;
					break;
				}
				dayCnt++;
				weekCnt += weekCnt < 6 ? 1 : -6;
			}
			monthCnt++;
			if (monthCnt > 12) {
				monthCnt = 1;
				yearCnt++;
			}
			dayCnt = 1;
			if (isMatch) {
				break;
			}
		}
		return BASIC_WEEKS[weekCnt];
	}
	public static void calendarYear(int a, int b) {
		menu1();
		System.out.println(" ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ");
		System.out.println(" ┃                                   ┃ ");
		System.out.printf(" ┃               %d년              ┃ \n", a);
		System.out.println(" ┃                                   ┃ ");
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < 4; i++) {
				if (k == 0) {
					System.out.print(i == 0 ? " ┣━━━━━━━━" : i == 3 ? "┳━━━━━━━━┫ " : "┳━━━━━━━━");
				} else {
					System.out.print(i == 0 ? " ┣━━━━━━━━" : i == 3 ? "╋━━━━━━━━┫ " : "╋━━━━━━━━");
				}
			}
			System.out.println();
			for (int i = 0; i < 4; i++) {
				System.out.print(i == 0 ? " ┃        ┃" : "        ┃");
			}
			System.out.println(" ");
			for (int i = 0; i < 4; i++) {
				System.out.printf(i == 0 ? " ┃  " : "  ", k * 4 + i + 1);
				if (k * 4 + i + 1 == monthSet) {
					System.out.printf(
							i == 0 ? BACKGROUND.RED_BRIHT("") + FONT.WHITE_BOLD_BRIGHT("") + "%02d월" + FONT.RESET()
									: BACKGROUND.RED_BRIHT("") + FONT.WHITE_BOLD_BRIGHT("") + "%02d월" + FONT.RESET(),
							k * 4 + i + 1);
					setBackGround();
					setFont();
				} else {
					System.out.printf(i == 0 ? "%02d월" : "%02d월", k * 4 + i + 1);
				}
				System.out.printf(i == 0 ? "  ┃" : "  ┃", k * 4 + i + 1);
			}
			System.out.println(" ");
			for (int i = 0; i < 4; i++) {
				System.out.print(i == 0 ? " ┃        ┃" : "        ┃");
			}
			System.out.println(" ");
		}
		for (int i = 0; i < 4; i++) {
			System.out.print(i == 0 ? " ┗━━━━━━━━" : i == 3 ? "┻━━━━━━━━┛ " : "┻━━━━━━━━");
		}
		System.out.println();
		menu2();
	}
	public static void calendarMonth(int a, int b) {
		menu1();
		System.out.println(" ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ");
		System.out.printf(" ┃             %d년 %02d월          ┃ \n", a, b);
		int idx = -1;
		String str = week(a, b, 1);
		for (int i = 0; i < BASIC_WEEKS.length; i++) {
			if (BASIC_WEEKS[i].equals(str)) {
				idx = i;
				break;
			}
		}
		int num = 1;
		boolean isEnd = false;
		for (int k = 0; k < 7; k++) {
			for (int i = 0; i < 7; i++) {
				if (k == 0) {
					System.out.print(i == 0 ? " ┣━━━━" : i == 6 ? "┳━━━━┫ " : "┳━━━━");
				} else {
					System.out.print(i == 0 ? " ┣━━━━" : i == 6 ? "╋━━━━┫ " : "╋━━━━");
				}
			}
			System.out.println();
			for (int i = 0; i < 7; i++) {
				if (k == 0) {
					System.out.printf(i == 0 ? " ┃ " : " ", BASIC_WEEKS[i]);
					System.out.printf(i == 0 ? FONT.RED_BOLD_BRIGHT("") + "%s" + FONT.RESET()
							: i == 6 ? FONT.BLUE_BOLD_BRIGHT("") + "%s" + FONT.RESET() : "%s", BASIC_WEEKS[i]);
					setBackGround();
					setFont();
					System.out.print(" ┃");
				} else {
					if (i == 0) {
					}
					if (k == 1 && i >= idx) {
						System.out.print(i == 0 ? " ┃ " : " ");
						if (num == daySet) {
							System.out.print(BACKGROUND.RED_BRIHT("") + FONT.WHITE_BOLD_BRIGHT(""));
						}
						System.out.printf(i == 0
								? (num == daySet ? "" : FONT.RED_BOLD_BRIGHT("")) + "%02d" + FONT.RESET()
								: i == 6 ? (num == daySet ? "" : FONT.BLUE_BOLD_BRIGHT("")) + "%02d" + FONT.RESET()
										: "%02d",
								num++);
						if (num == daySet) {
							System.out.print(FONT.RESET());
						}
						setBackGround();
						setFont();
						System.out.print(" ┃");
					} else if (k > 1 && num <= monthData(a)[b - 1]) {
						System.out.print(i == 0 ? " ┃ " : " ");
						if (num == daySet) {
							System.out.print(BACKGROUND.RED_BRIHT("") + FONT.WHITE_BOLD_BRIGHT(""));
						}
						System.out.printf(i == 0
								? (num == daySet ? "" : FONT.RED_BOLD_BRIGHT("")) + "%02d" + FONT.RESET()
								: i == 6 ? (num == daySet ? "" : FONT.BLUE_BOLD_BRIGHT("")) + "%02d" + FONT.RESET()
										: "%02d",
								num++);
						if (num == daySet) {
							System.out.print(FONT.RESET());
						}
						setBackGround();
						setFont();
						System.out.print(" ┃");
						if (k != 6 && num > monthData(a)[b - 1]) {
							isEnd = true;
						}
					} else {
						System.out.print(i == 0 ? " ┃    ┃" : "    ┃");
					}
				}
			}
			System.out.print(" ");
			System.out.println();
			if (isEnd) {
				break;
			}
		}
		for (int i = 0; i < 7; i++) {
			System.out.print(i == 0 ? " ┗━━━━" : i == 6 ? "┻━━━━┛ " : "┻━━━━");
		}
		System.out.println();
		menu2();
	}
	public static void calendarDay(int a, int b, int c) {
		menu1();
		System.out.println(" ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ");
		String week = week(a, b, c);
		System.out.printf(" ┃      %d년 %02d월 %02d일 ", a, b, c);
		System.out.printf(
				(week.equals("일") ? FONT.RED_BOLD_BRIGHT("") : week.equals("토") ? FONT.BLUE_BOLD_BRIGHT("") : "")
						+ "%s요일",
				week);
		System.out.print(FONT.RESET());
		setBackGround();
		setFont();
		System.out.print("     ┃ \n");
		System.out.println(" ┠━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┨ ");
		boolean isHave = false;
		int index = -1;
		for (int i = 1; i < toDo.length; i++) {
			if (toDo[i][0].equals(yearSet + "" + (monthSet < 10 ? "0" + monthSet : monthSet) + ""
					+ (daySet < 10 ? "0" + daySet : daySet))) {
				isHave = true;
				index = i;
				break;
			}
		}
		if (!isHave) {
			System.out.println(" ┃                                  ┃ ");
			System.out.print(" ┃            " + FONT.BLACK_BOLD_BRIGHT("") + "일정 없음" + FONT.RESET());
			setBackGround();
			setFont();
			System.out.println("             ┃ ");
		} else {
			for (int i = 1; i < toDo[index].length; i++) {
				System.out.println(" ┃                                  ┃ ");
				int set1 = cntLength(toDo[index][i]);
				int set3 = cntLength(toDoPlace[index][i]);
				if (set1 < 29) {
					System.out.print(" ┃ [" + i + "] ");
					System.out.print(toDo[index][i]);
					for (int k = 0; k < 28 - set1; k++) {
						System.out.print(" ");
					}
					System.out.println(" ┃ ");
				} else {
					int round = set1 / 28;
					for (int k = 0; k <= round; k++) {
						System.out.print(k == 0 ? " ┃ [" + i + "] " : " ┃     ");
						if (k == 0) {
							System.out.print(toDo[index][i].substring(0, cntLengthIdx(toDo[index][i])[k + 1]));
						} else if (k < round) {
							System.out.print(toDo[index][i].substring(cntLengthIdx(toDo[index][i])[k],
									cntLengthIdx(toDo[index][i])[k + 1]));
						} else {
							System.out.print(toDo[index][i].substring(cntLengthIdx(toDo[index][i])[k]));
						}
						for (int j = 0; j < (k == round ? 28 - (set1 % 28) : 0); j++) {
							System.out.print(" ");
						}
						System.out.println(" ┃ ");
					}
				}
				System.out.print(" ┃      [시간] ");
				if (toDoTime[index][i].equals("하루종일")) {
					System.out.println("하루종일             ┃ ");
				} else {
					System.out.printf("(%s) %02d:%02d", toDoTime[index][i].substring(0, 2),
							Integer.parseInt(toDoTime[index][i].substring(2, 4)),
							Integer.parseInt(toDoTime[index][i].substring(4)));
					System.out.println("         ┃ ");
				}
				if (set3 < 20) {
					System.out.print(" ┃      [장소] ");
					System.out.print(toDoPlace[index][i]);
					for (int k = 0; k < 20 - set3; k++) {
						System.out.print(" ");
					}
					System.out.println(" ┃ ");
				} else {
					int round = set3 / 20;
					for (int k = 0; k <= round; k++) {
						System.out.print(k == 0 ? " ┃      [장소] " : " ┃             ");
						if (k == 0) {
							System.out
									.print(toDoPlace[index][i].substring(0, cntLengthIdx2(toDoPlace[index][i])[k + 1]));
						} else if (k < round) {
							System.out.print(toDoPlace[index][i].substring(cntLengthIdx2(toDoPlace[index][i])[k],
									cntLengthIdx2(toDoPlace[index][i])[k + 1]));
						} else {
							System.out.print(toDoPlace[index][i].substring(cntLengthIdx2(toDoPlace[index][i])[k]));
						}
						for (int j = 0; j < (k == round ? 20 - (set3 % 20) : 0); j++) {
							System.out.print(" ");
						}
						System.out.println(" ┃ ");
					}
				}
			}
		}
		System.out.println(" ┃                                  ┃ ");

		System.out.println(" ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ");
		menu2();
	}
	public static void calendarToDo(int a, int b, int c, int h) {

		int cnt = 0;
		int index = -1;
		for (int i = 1; i < toDo.length; i++) {
			if (Integer.parseInt(toDo[i][0].substring(0, 4)) > nowYear()
					|| (Integer.parseInt(toDo[i][0].substring(0, 4)) == nowYear()
							&& Integer.parseInt(toDo[i][0].substring(4, 6)) > nowMonth())
					|| (Integer.parseInt(toDo[i][0].substring(0, 4)) == nowYear()
							&& Integer.parseInt(toDo[i][0].substring(4, 6)) == nowMonth()
							&& Integer.parseInt(toDo[i][0].substring(6, 8)) > nowDay())) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			System.out.println("오늘 이후 일정이 없습니다.");
		} else {
			if (h == 9) {
				System.out.println("오늘 이후 가장 가까운 일정을 표시합니다.");
			} else {
				System.out.println("오늘 이후으로 가까운 10개 목록을 표시합니다.");
			}
			setBackGround();
			setFont();
			menu1();
			while (cnt != 10) {
				if (h == 9) {
					cnt = 9;
				}
				if (index == toDo.length) {
					break;
				}
				int d = Integer.parseInt(toDo[index][0].substring(0, 4));
				int e = Integer.parseInt(toDo[index][0].substring(4, 6));
				int f = Integer.parseInt(toDo[index][0].substring(6));
				for (int i = 1; i < toDo[index].length; i++) {
					System.out.println(" ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ");
					String week = week(d, e, f);
					System.out.printf(" ┃      %d년 %02d월 %02d일 ", d, e, f);
					System.out.printf((week.equals("일") ? FONT.RED_BOLD_BRIGHT("")
							: week.equals("토") ? FONT.BLUE_BOLD_BRIGHT("") : "") + "%s요일", week);
					System.out.print(FONT.RESET());
					setBackGround();
					setFont();
					System.out.print("     ┃ \n");
					System.out.println(" ┠━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┨ ");
					int set1 = cntLength(toDo[index][i]);
					int set3 = cntLength(toDoPlace[index][i]);
					if (set1 < 29) {
						System.out.print(" ┃ [" + i + "] ");
						System.out.print(toDo[index][i]);
						for (int k = 0; k < 28 - set1; k++) {
							System.out.print(" ");
						}
						System.out.println(" ┃ ");
					} else {
						int round = set1 / 28;
						for (int k = 0; k <= round; k++) {
							System.out.print(k == 0 ? " ┃ [" + i + "] " : " ┃     ");
							if (k == 0) {
								System.out.print(toDo[index][i].substring(0, cntLengthIdx(toDo[index][i])[k + 1]));
							} else if (k < round) {
								System.out.print(toDo[index][i].substring(cntLengthIdx(toDo[index][i])[k],
										cntLengthIdx(toDo[index][i])[k + 1]));
							} else {
								System.out.print(toDo[index][i].substring(cntLengthIdx(toDo[index][i])[k]));
							}
							for (int j = 0; j < (k == round ? 28 - (set1 % 28) : 0); j++) {
								System.out.print(" ");
							}
							System.out.println(" ┃ ");
						}
					}
					System.out.print(" ┃      [시간] ");
					if (toDoTime[index][i].equals("하루종일")) {
						System.out.println("하루종일             ┃ ");
					} else {
						System.out.printf("(%s) %02d:%02d", toDoTime[index][i].substring(0, 2),
								Integer.parseInt(toDoTime[index][i].substring(2, 4)),
								Integer.parseInt(toDoTime[index][i].substring(4)));
						System.out.println("         ┃ ");
					}
					if (set3 < 20) {
						System.out.print(" ┃      [장소] ");
						System.out.print(toDoPlace[index][i]);
						for (int k = 0; k < 20 - set3; k++) {
							System.out.print(" ");
						}
						System.out.println(" ┃ ");
					} else {
						int round = set3 / 20;
						for (int k = 0; k <= round; k++) {
							System.out.print(k == 0 ? " ┃      [장소] " : " ┃             ");
							if (k == 0) {
								System.out.print(
										toDoPlace[index][i].substring(0, cntLengthIdx2(toDoPlace[index][i])[k + 1]));
							} else if (k < round) {
								System.out.print(toDoPlace[index][i].substring(cntLengthIdx2(toDoPlace[index][i])[k],
										cntLengthIdx2(toDoPlace[index][i])[k + 1]));
							} else {
								System.out.print(toDoPlace[index][i].substring(cntLengthIdx2(toDoPlace[index][i])[k]));
							}
							for (int j = 0; j < (k == round ? 20 - (set3 % 20) : 0); j++) {
								System.out.print(" ");
							}
							System.out.println(" ┃ ");
						}
					}
					System.out.println(" ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ");
					cnt++;
				}
				index++;
			}
			menu2();
		}
	}
	public static int cntLength(String a) {
		int cnt = 0;
		for (int i = 0; i < a.length(); i++) {
			char b = a.charAt(i);
			if ((b < '0' || b > '9') && (b < 'A' || b > 'Z') && (int) b > 255) {
				cnt += 2;
			} else {
				cnt += 1;
			}
		}
		return cnt;
	}
	public static int[] cntLengthIdx(String a) {
		int cnt = 0;
		int[] idx = new int[a.length() * 2];
		int idxIdx = 1;
		for (int i = 0; i < a.length(); i++) {
			char b = a.charAt(i);
			if ((b < '0' || b > '9') && (b < 'A' || b > 'Z') && (int) b > 255) {
				cnt += 2;
			} else {
				cnt += 1;
			}
			if (cnt % 28 == 0) {
				idx[idxIdx++] = i + 1;
			}
		}
		return idx;
	}
	public static int[] cntLengthIdx2(String a) {
		int cnt = 0;
		int[] idx = new int[a.length() * 2];
		int idxIdx = 1;
		for (int i = 0; i < a.length(); i++) {
			char b = a.charAt(i);
			if ((b < '0' || b > '9') && (b < 'A' || b > 'Z') && (int) b > 255) {
				cnt += 2;
			} else {
				cnt += 1;
			}
			if (cnt % 20 == 0) {
				idx[idxIdx++] = i + 1;
			}
		}
		return idx;
	}
	public static String[][] toDoAdd(String[][] a, int[] b, String c) {
		int size = a.length;
		boolean isHave = false;
		int index = -1;
		String[][] returnA = new String[size][];
		returnA = a;
		for (int i = 0; i < size; i++) {
			if (a[i][0].equals(yearSet + "" + (monthSet < 10 ? "0" + monthSet : monthSet) + ""
					+ (daySet < 10 ? "0" + daySet : daySet))) {
				isHave = true;
				index = i;
				break;
			}
		}
		returnA = addHave(a, b, index, c, isHave);
		System.out.println("일정이 추가되었습니다.");
		return returnA;
	}
	public static String[][] addHave(String[][] a, int[] b, int c, String d, boolean e) {
		String[][] str = new String[a.length][];
		if (e) {
			String[] temp = new String[a[c].length + 1];
			for (int i = 0; i < temp.length - 1; i++) {
				temp[i] = a[c][i];
			}
			temp[temp.length - 1] = d;
			for (int i = 0; i < str.length - 1; i++) {
				str[i] = a[i];
			}
			str[c] = temp;
		} else {
			int size = a.length + 1;
			int[] tempB = new int[size];
			for (int i = 0; i < tempB.length - 1; i++) {
				tempB[i] = b[i];
			}
			tempB[tempB.length - 1] = 1;
			str = new String[size][];
			for (int i = 0; i < str.length - 1; i++) {
				str[i] = a[i];
			}
			String[] add = { yearSet + "" + (monthSet < 10 ? "0" + monthSet : monthSet) + ""
					+ (daySet < 10 ? "0" + daySet : daySet), d };
			str[str.length - 1] = add;
			if (str.length > 2) {
				str = listUp(str);
			}
		}
		return str;
	}
	public static int[] toDoCntAdd(String[][] a) {
		int[] temp = new int[a.length];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = a[i].length - 1;
		}
		return temp;
	}
	public static String[][] toDoDel(String[][] a, int b, int c) {
		int size = a.length;
		if (a[b].length == 2) {
			String[][] temp = new String[size - 1][];
			int idx = 0;
			for (int i = 0; i < size; i++) {
				if (i != b) {
					temp[idx++] = a[i];
				}
			}
			return temp;
		} else {
			String[][] temp = new String[size][];
			String[] tempS = new String[a[b].length - 1];
			int idx = 0;
			for (int i = 0; i < a[b].length; i++) {
				if (i != c) {
					tempS[idx++] = a[b][i];
				}
			}
			idx = 0;
			for (int i = 0; i < size; i++) {
				temp[idx++] = i != b ? a[i] : tempS;
			}
			return temp;
		}
	}
	public static String[][] listUp(String[][] a) {
		String[][] temp = new String[a.length][];
		temp = a;
		for (int i = 1; i < temp.length - 1; i++) {
			for (int k = i + 1; k < temp.length; k++) {
				if (Integer.parseInt(temp[i][0]) > Integer.parseInt(temp[k][0])) {
					String[] temp2 = temp[i];
					temp[i] = temp[k];
					temp[k] = temp2;
				}
			}
		}
		return temp;
	}
	public static void setBackGround() {
		System.out.print(BACKGROUND.WHITE_BRIHT(""));
	}
	public static void setFont() {
		System.out.print(FONT.BLACK_BOLD(""));
	}
	public static void menu1() {
		System.out.print(" ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(screen == 0 ? "━┓ " : "┓ ");
		System.out.print(screen == 1 ? " ┃  ⓞ종료  ①연력  ②검색  ③오늘  " : " ┃  ⓞ종료  ①달력  ②검색  ③오늘  ");
		System.out.println(screen == 0 ? " ┃ " : "┃ ");
		System.out.print(" ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(screen == 0 ? "━┛ " : "┛ ");
	}
	public static void menu2() {
		System.out.print(" ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(screen == 0 ? "━┓ " : "┓ ");
		System.out.print(" ┃ ④일정확인 ⑤일정등록 ⑥일정삭제 ");
		System.out.println(screen == 0 ? " ┃ " : "┃ ");
		System.out.print(" ┃ ⑦일정목록 ⑧일정편집 ⑨빠른일정 ");
		System.out.println(screen == 0 ? " ┃ " : "┃ ");
		System.out.print(" ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(screen == 0 ? "━┛ " : "┛ ");
		System.out.print(" ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(screen == 0 ? "━┓ " : "┓ ");
		System.out.print(" ┃ << ⑩ 이전            다음 ⑪ >> ");
		System.out.println(screen == 0 ? " ┃ " : "┃ ");
		System.out.print(" ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(screen == 0 ? "━┛ " : "┛ ");
	}
	public static boolean timeSetInput(String a) {
		boolean rs = true;
		if (!a.equals("오전") && !a.equals("오후")) {
			System.out.println("오전, 오후만 입력 가능합니다");
			rs = false;
		}
		return rs;
	}
	public static boolean timeInput(String a) {
		boolean rs = true;
		if (a.length() != 4) {
			System.out.println("4자리 숫자만 입력하세요 (ex. 1200)");
			rs = false;
		} else {
			boolean isSame = false;
			for (int i = 0; i < 4; i++) {
				if (a.charAt(i) < 48 || a.charAt(i) > 57) {
					isSame = true;
					rs = false;
				}
			}
			if (isSame) {
				System.out.println("숫자만 입력하세요 (ex. 1200)");
				rs = false;
			}
			if (Integer.parseInt(a) / 100 < 0 || Integer.parseInt(a) / 100 > 12) {
				System.out.println("시간(앞 두자리)을 0~12 사이로 입력하세요");
				rs = false;
			}
			if (Integer.parseInt(a) % 100 < 0 || Integer.parseInt(a) % 100 > 59) {
				System.out.println("분(뒤 두자리)을 0~60 사이로 입력하세요");
				rs = false;
			}
		}
		return rs;
	}
	public static void load(int a, int b, int c, int d) {
		setBackGround();
		setFont();
		if (a == 0) {
			calendarYear(b, c);
		} else if (a == 1) {
			calendarMonth(b, c);
		} else {
			calendarDay(b, c, d);
		}
		System.out.print(FONT.RESET());
	}
	
	public static final int BASIC_YEAR = 1900;
	public static final int BASIC_MONTH = 1;
	public static final int BASIC_DAY = 1;
	public static final int BASIC_WEEK = 1;
	public static final String[] BASIC_WEEKS = { "일", "월", "화", "수", "목", "금", "토", "일" };
	public static int yearSet = nowYear();
	public static int monthSet = nowMonth();
	public static int daySet = nowDay();
	public static int screen = 1;
	public static String[][] toDo = { { "년/월/일", "일정 데이터" } };
	public static String[][] toDoTime = { { "년/월/일", "일정 데이터" } };
	public static String[][] toDoPlace = { { "년/월/일", "일정 데이터" } };
	public static int[] toDoCnt = { 1 };
	public static boolean skip = false;
	public static int skipInt = -1;
	public static int skipIdx1 = -1;
	public static int skipIdx2 = -1;
	public static int skipY = -1;
	public static int skipM = -1;
	public static int skipD = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		load(screen, yearSet, monthSet, daySet);
		while (true) {
			int sel = -1;
			if (!skip) {
				System.out.print("메뉴 입력 >> ");
				sel = sc.nextInt();
				if (sel < 0 || sel > 11) {
					System.out.println("메뉴 입력 오류");
					continue;
				}
				if (sel == 0) {
					System.out.println("캘린더 종료");
					break;
				}
				if (sel < 10 && sel > 5 && toDo.length == 1) {
					System.out.println("등록된 일정이 하나도 없습니다.");
					continue;
				}
			} else {
				sel = skipInt;
			}
			if (sel == 1) {
				screen = screen == 1 ? 0 : 1;
			} else if (sel == 2) {
				while (true) {
					int yearTemp = 1900;
					int monthTemp = 1;
					int dayTemp = 1;
					int cnt = 0;
					if (!skip) {
						System.out.println("ex. 2024(년) 또는 202412(년월) 또는 20241231(년월일)");
					} else {
						System.out.println("ex.1231(월일) 또는 13(일) 또는 2024(년) \n 또는 202412(년월) 또는 20241231(년월일)");
					}
					System.out.print("(0. 취소) 검색: ");
					int date = sc.nextInt();
					if (date == 0) {
						System.out.println(!skip ? "검색 취소" : "수정 취소");
						if (skip) {
							skipInt = 8;
						}
						break;
					}
					if (date < 32) {
						dayTemp = date;
						cnt = -1;
					} else if (date / 1000 < 1) {
						monthTemp = date / 100;
						dayTemp = date % 100;
						cnt = 0;
					} else if (date / 1000 < 10) {
						yearTemp = date;
						cnt = 1;
					} else if (date / 100000 < 10) {
						yearTemp = date / 100;
						monthTemp = date % 100;
						cnt = 2;
					} else {
						yearTemp = date / 10000;
						monthTemp = date % 10000 / 100;
						dayTemp = date % 100;
						cnt = 3;
					}
					boolean check1 = yearTemp > 1899 && yearTemp < 10000;
					boolean check2 = monthTemp > 0 && monthTemp < 13;
					boolean check3 = dayTemp > 0 && dayTemp <= monthData(yearTemp)[monthTemp - 1];
					if (!check1) {
						System.out.println("1900년 ~ 9999년 까지만 확인 가능합니다");
						continue;
					}
					if (!check2) {
						System.out.println("정확한 달을 입력해주세요");
						continue;
					}
					if (!check3) {
						System.out.println("정확한 날짜를 입력해주세요");
						continue;
					}
					if (skip) {
						if (cnt == -1) {
							monthTemp = Integer.parseInt(toDo[skipIdx1][0].substring(4, 6));
							yearTemp = Integer.parseInt(toDo[skipIdx1][0].substring(0, 4));
						} else if (cnt == 0) {
							yearTemp = Integer.parseInt(toDo[skipIdx1][0].substring(0, 4));
						} else if (cnt == 1) {
							monthTemp = Integer.parseInt(toDo[skipIdx1][0].substring(4, 6));
							dayTemp = Integer.parseInt(toDo[skipIdx1][0].substring(6));
						} else if (cnt == 2) {
							dayTemp = Integer.parseInt(toDo[skipIdx1][0].substring(6));
						}
						if (yearTemp < nowYear() || (yearTemp == nowYear() && monthTemp < nowMonth())
								|| (yearTemp == nowYear() && monthTemp == nowMonth() && dayTemp <= nowDay())) {
							System.out.println("오늘 날짜 이후로만 변경 가능합니다");
							continue;
						}
						skipInt = 5;
					}
					if (cnt == 1) {
						screen = 0;
					} else if (cnt == 2) {
						screen = 1;
					} else if (cnt == 3) {
						screen = screen == 2 ? 2 : 1;
					}
					yearSet = yearTemp;
					monthSet = monthTemp;
					daySet = dayTemp;
					break;
				}
				if (skip) {
					continue;
				}
			} else if (sel == 3) {
				yearSet = nowYear();
				monthSet = nowMonth();
				daySet = nowDay();
			} else if (sel == 4) {
				screen = 2;
			} else if (sel == 5) {
				sc.nextLine();
				String input = "";
				String time = "";
				String place = "";
				if (!skip) {
					boolean isEnd = false;
					System.out.println("일정 등록 (빈칸 : 등록취소)>> ");
					input = sc.nextLine();
					if (input.isBlank()) {
						isEnd = true;
						continue;
					}
					if (isEnd) {
						System.out.println("일정 등록 취소");
						continue;
					}
					while (true) {
						System.out.println("시간 등록 (오전 또는 오후 ) >> ");
						time = sc.nextLine();
						if (!timeSetInput(time)) {
							continue;
						}
						break;
					}
					while (true) {
						System.out.println("시간 등록 (빈칸 : 하루종일) >> ");
						String timeP = sc.nextLine();
						if (timeP.isBlank()) {
							time = "하루종일";
							break;
						}
						if (!timeInput(timeP)) {
							continue;
						}
						if (time.equals("오전") && Integer.parseInt(timeP) / 100 == 12) {
							time = "오후";
						} else if (time.equals("오후") && Integer.parseInt(timeP) / 100 == 12) {
							time = "오전";
							timeP = "00" + timeP.substring(2, 4);
						} else if (time.equals("오후") && Integer.parseInt(timeP) / 100 == 0) {
							timeP = "12" + timeP.substring(2, 4);
						}
						time += timeP;
						break;
					}
					System.out.println("장소 등록 (빈칸 : 표시안함) >> ");
					place = sc.nextLine();

				} else {
					input = toDo[skipIdx1][skipIdx2];
					time = toDoTime[skipIdx1][skipIdx2];
					place = toDoPlace[skipIdx1][skipIdx2];
				}
				toDo = toDoAdd(toDo, toDoCnt, input);
				toDoTime = toDoAdd(toDoTime, toDoCnt, time);
				toDoPlace = toDoAdd(toDoPlace, toDoCnt, place);
				toDoCnt = toDoCntAdd(toDo);
				screen = 2;
				if (skip) {
					int temp = yearSet;
					yearSet = skipY;
					skipY = temp;
					temp = monthSet;
					monthSet = skipM;
					skipM = temp;
					temp = daySet;
					daySet = skipD;
					skipD = temp;
					skipInt = 6;
					continue;
				}
			} else if (sel == 6) {
				int idx = -1;
				int del = -1;
				boolean isHave = false;
				for (int i = 0; i < toDo.length; i++) {
					if (toDo[i][0].equals(yearSet + "" + (monthSet < 10 ? "0" + monthSet : monthSet) + ""
							+ (daySet < 10 ? "0" + daySet : daySet))) {
						isHave = true;
						idx = i;
						break;
					}
				}
				if (!skip) {
					if (!isHave) {
						System.out.println("해당 일자에 삭제할 일정이 없습니다");
						continue;
					}
					while (true) {
						System.out.print("삭제할 일정 번호 >> ");
						del = sc.nextInt();
						if (del < 1 || del > toDo[idx].length - 1) {
							System.out.println("없는 번호입니다");
							continue;
						}
						break;
					}
				} else {
					del = skipIdx2;
				}
				toDo = toDoDel(toDo, idx, del);
				toDoTime = toDoDel(toDoTime, idx, del);
				toDoPlace = toDoDel(toDoPlace, idx, del);
				toDoCnt = toDoCntAdd(toDo);
				System.out.println(Arrays.toString(toDoCnt));
				screen = 2;
				if (skip) {
					yearSet = skipY;
					monthSet = skipM;
					daySet = skipD;
					skip = false;
					System.out.println("수정 완료");
				}
			} else if (sel == 7) {
				screen = 3;
				calendarToDo(nowYear(), nowMonth(), nowDay(), sel);
				System.out.print(FONT.RESET());
				continue;
			} else if (sel == 8) {
				skip = false;
				while (true) {
					boolean isHave = false;
					int idx = -1;
					for (int i = 0; i < toDo.length; i++) {
						if (toDo[i][0].equals(yearSet + "" + (monthSet < 10 ? "0" + monthSet : monthSet) + ""
								+ (daySet < 10 ? "0" + daySet : daySet))) {
							isHave = true;
							idx = i;
							break;
						}
					}
					if (!isHave) {
						System.out.println("해당 일자에 변경할 일정이 없습니다");
						break;
					}
					int reInput = -1;
					while (true) {
						System.out.print("변경할 일정 번호 >> ");
						reInput = sc.nextInt();
						if (reInput < 1 || reInput > toDo[idx].length - 1) {
							System.out.println("없는 번호입니다");
							continue;
						}
						break;
					}
					int re = 0;
					boolean isFin = false;
					boolean isEnd = false;
					while (true) {
						System.out.println("수정할 내용 \n(0.취소 1.내용 2.시간 3.장소 4.날짜) >>");
						re = sc.nextInt();
						if (re == 0) {
							isEnd = true;
							break;
						}
						if (re == 4) {
							skip = true;
							skipInt = 2;
							skipIdx1 = idx;
							skipIdx2 = reInput;
							skipY = yearSet;
							skipM = monthSet;
							skipD = daySet;
							break;
						}
						if (re < 1 || re > 3) {
							System.out.println("입력 오류");
							continue;
						}
						break;
					}
					if (skip) {
						break;
					}
					if (isEnd) {
						System.out.println("수정 취소");
						break;
					}
					while (true) {
						String time = toDoTime[idx][reInput].substring(0, 2);
						if (re == 2) {
							if (toDoTime[idx][reInput].equals("하루종일")) {
								toDoTime[idx][reInput] = "오전0000";
								System.out.println("하루종일로 설정되어 있어 (오전) 00:00으로 임시 변경합니다.");
								break;
							}
							while (true) {
								System.out.println("1. 오전/오후 수정  \n2. 시간 수정 >> ");
								int change = sc.nextInt();
								if (change < 1 || change > 2) {
									System.out.println("입력 오류");
									continue;
								}
								if (change == 1) {
									String input = toDoTime[idx][reInput].substring(2);
									time = time.equals("오전") ? "오후" : "오전";
									if (time.equals("오전") && Integer.parseInt(input) / 100 == 12) {
										time = "오후";
									} else if (time.equals("오후") && Integer.parseInt(input) / 100 == 12) {
										time = "오전";
										input = "00" + toDoTime[idx][reInput].substring(2, 4);
									} else if (time.equals("오후") && Integer.parseInt(input) / 100 == 0) {
										input = "12" + toDoTime[idx][reInput].substring(2, 4);
									}
									time += input;
									toDoTime[idx][reInput] = time;
									isFin = true;
								}
								break;
							}
						}
						if (isFin) {
							break;
						}
						sc.nextLine();
						System.out.print(re == 1 ? "내용 " : re == 2 ? "시간 " : "장소 ");
						System.out.println("수정 (다시 선택 : exit) >> ");
						String input = sc.nextLine();
						if (input.equals("exit")) {
							isEnd = true;
							break;
						}
						if (re == 1) {
							if (input.isBlank()) {
								System.out.println("빈칸 입력 불가");
								continue;
							}
							toDo[idx][reInput] = input;
						} else if (re == 2) {
							if (input.isBlank()) {
								toDoPlace[idx][reInput] = "하루종일";
								break;
							}
							if (!timeInput(input)) {
								continue;
							}
							if (time.equals("오전") && Integer.parseInt(input) / 100 == 12) {
								time = "오후";
							} else if (time.equals("오후") && Integer.parseInt(input) / 100 == 12) {
								time = "오전";
								input = "00" + input.substring(2, 4);
							} else if (time.equals("오후") && Integer.parseInt(input) / 100 == 0) {
								input = "12" + input.substring(2, 4);
							}
							time += input;
							toDoTime[idx][reInput] = time;
						} else {
							toDoPlace[idx][reInput] = input;
						}
						isFin = true;
						break;
					}
					if (isFin) {
						System.out.println("수정 완료");
						screen = 2;
						break;
					}
					if (isEnd) {
						System.out.println("수정 항목 재선택");
						continue;
					}

				}
				if (skip) {
					continue;
				}

			} else if (sel == 9) {
				screen = 3;
				calendarToDo(nowYear(), nowMonth(), nowDay(), sel);
				System.out.print(FONT.RESET());
				continue;
			} else if (sel == 10) {
				if ((yearSet == 1900 && screen == 0) && (yearSet == 1900 && monthSet == 1 && screen == 1)
						|| (yearSet == 1900 && monthSet == 1 && daySet == 1 && (screen == 2))) {
					System.out.println("제일 첫 달력입니다." + FONT.RESET());
					continue;
				}
				if (screen == 0) {
					yearSet--;
				} else if (screen == 1) {
					monthSet--;
					if (monthSet == 0) {
						yearSet--;
						monthSet = 12;
					}
				} else {
					daySet--;
					if (daySet == 0) {
						monthSet--;
						if (monthSet == 0) {
							yearSet--;
							monthSet = 12;
						}
						daySet = monthData(yearSet)[monthSet - 1];
					}
				}
			} else if (sel == 11) {
				if ((yearSet == 9999 && screen == 0) || (yearSet == 9999 && monthSet == 12 && screen == 1)
						|| (yearSet == 9999 && monthSet == 12 && daySet == 31 && (screen == 2))) {
					System.out.println("제일 마지막 달력입니다." + FONT.RESET());
					continue;
				}
				if (screen == 0) {
					yearSet++;
				} else if (screen == 1) {
					monthSet++;
					if (monthSet > 12) {
						yearSet++;
						monthSet = 1;
					}
				} else {
					daySet++;
					if (daySet > monthData(yearSet)[monthSet - 1]) {
						monthSet++;
						if (monthSet > 12) {
							yearSet++;
							monthSet = 1;
						}
						daySet = 1;
					}
				}

			}
			load(screen, yearSet, monthSet, daySet);
		}
		sc.close();
	}

}
