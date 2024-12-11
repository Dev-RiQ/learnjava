package 문자열심화;

public class _07사원정보 {

	public static void main(String[] args) {
		int deNo1 = 0; // 부서 번호
		int deName = 1; // 부서 명
		int loc = 2; // 지역
		String[][] deData = {
				{"10","ACCOUNTING","NEW YORK"},
				{"20","RESEARCH","DALLAS"},
				{"30","SALES","CHICAGO"},
				{"40","OPERATIONS","BOSTON"}
		};
//		int no = 0;
		int name = 1;
		int title = 2;
//		int supNo = 3;
		int data = 4;
		int sal = 5;
		int com = 6;
		int deNo2 = 7;
		//        [번호, 이름, 직책, 상사번호, 입사일, 급여, 커미션, 부서번호]
		String[][] emData = { 
				{ "7369", "SMITH", "CLERK", "7902", "17-12-1980", "800", "0", "20" },
				{ "7499", "ALLEN", "SALESMAN", "7698", "20-2-1981", "1600", "300", "30" },
				{ "7521", "WARD", "SALESMAN", "7698", "22-2-1981", "1250", "500", "30" },
				{ "7566", "JONES", "MANAGER", "7839", "2-4-1981", "2975", "0", "20" },
				{ "7654", "MARTIN", "SALESMAN", "7698", "28-9-1981", "1250", "1400", "30" },
				{ "7698", "BLAKE", "MANAGER", "7839", "1-5-1981", "2850", "0", "30" },
				{ "7782", "CLARK", "MANAGER", "7839", "9-6-1981", "2450", "0", "10" },
				{ "7788", "SCOTT", "ANALYST", "7566", "13-7-1987", "3000", "0", "20" },
				{ "7839", "KING", "PRESIDENT", "NULL", "17-11-1981", "5000", "0", "10" },
				{ "7844", "TURNER", "SALESMAN", "7698", "8-9-1981", "1500", "0", "30" },
				{ "7876", "ADAMS", "CLERK", "7788", "13-7-1987", "1100", "0", "20" },
				{ "7900", "JAMES", "CLERK", "7698", "3-12-1981", "950", "0", "30" },
				{ "7902", "FORD", "ANALYST", "7566", "3-12-1981", "3000", "0", "20" },
				{ "7934", "MILLER", "CLERK", "7782", "23-1-1982", "1300", "0", "10" } 
				};
		
		System.out.println("1. 부서별 평균 월 급여");
		for (String[] de : deData) {
			int sum = 0;
			int cnt = 0;
			for (String[] em : emData) {
				if (em[deNo2].equals(de[deNo1])) {
					sum += Integer.parseInt(em[sal]);
					cnt++;
				}
			}
			double avg = sum * 1.0 / cnt;
			System.out.printf("%-10s : " + (cnt == 0 ? "No Data" : "%.2f $") + "\n", de[deName], avg);
		}
		System.out.println();

		System.out.println("2 - 1. 부서별 전체 사원 수");
		for (String[] de : deData) {
			int cnt = 0;
			for (String[] em : emData) {
				if (em[deNo2].equals(de[deNo1])) {
					cnt++;
				}
			}
			System.out.printf("%-10s : " + (cnt == 0 ? "No Data" : "%d 명") + "\n", de[deName], cnt);
		}
		System.out.println();

		System.out.println("2 - 2. 커미션 받는 사원 수");
		for (String[] de : deData) {
			int cnt = 0;
			for (String[] em : emData) {
				if (em[deNo2].equals(de[deNo1]) && !em[com].equals("0")) {
					cnt++;
				}
			}
			System.out.printf("%-10s : " + (cnt == 0 ? "No Data" : "%d 명") + "\n", de[deName], cnt);
		}
		System.out.println();

		System.out.println("3-1. 부서별 최대 급여");
		for (String[] de : deData) {
			int max = 0;
			for (String[] em : emData) {
				int pay = Integer.parseInt(em[sal]);
				if (em[deNo2].equals(de[deNo1]) && max < pay) {
					max = pay;
				}
			}
			System.out.printf("%-10s : " + (max == 0 ? "No Data" : "%d $") + "\n", de[deName], max);
		}
		System.out.println();

		System.out.println("3-2. 부서별 최소 급여");
		for (String[] de : deData) {
			int min = 99999;
			for (String[] em : emData) {
				int pay = Integer.parseInt(em[sal]);
				if (em[deNo2].equals(de[deNo1]) && min > pay) {
					min = pay;
				}
			}
			System.out.printf("%-10s : " + (min == 99999 ? "No Data" : "%d $") + "\n", de[deName], min);
		}
		System.out.println();

		System.out.println("4. 부서 번호 30번 사원 이름, 직급, 부서번호, 부서위치 조회");
		System.out.println("   사원 이름  / 직급       / 부서 번호  / 부서명 ");
		for (String[] de : deData) {
			if (de[deNo1].equals("30")) {
				for (String[] em : emData) {
					if (em[deNo2].equals(de[deNo1])) {
						System.out.printf("   %-10s / %-10s / %-10s / %-10s\n", em[name], em[title], em[deNo2],
								de[deName]);
					}
				}
				break;
			}
		}
		System.out.println();

		System.out.println("5. 급여 높은 순 이름, 급여 조회 (같으면 이름순)");
		System.out.println("   이름       / 급여");
		String[][] emTemp = new String[emData.length][emData[0].length];
		for (int i = 0; i < emData.length; i++) {
			for (int k = 0; k < emData[i].length; k++) {
				emTemp[i][k] = emData[i][k];
			}
		}
		for (int i = 0; i < emData.length; i++) {
			for (int k = i + 1; k < emData.length; k++) {
				if (emTemp[i][name].compareTo(emTemp[k][name]) > 0) {
					String[] temp = emTemp[i];
					emTemp[i] = emTemp[k];
					emTemp[k] = temp;
					i = -1;
					break;
				}
			}
		}
		int[] idx = new int[emData.length];
		boolean[] isMax = new boolean[emData.length];
		for (int i = 0; i < emTemp.length; i++) {
			int max = 0;
			for (int k = 0; k < emTemp.length; k++) {
				int pay = Integer.parseInt(emTemp[k][sal]);
				if (max < pay && !isMax[k]) {
					max = pay;
					idx[i] = k;
				}
			}
			isMax[idx[i]] = true;
		}
		for (int i = 0; i < emData.length; i++) {
			System.out.printf("   %-10s / %-10s\n", emTemp[idx[i]][name], emTemp[idx[i]][sal]);
		}

		System.out.println("6. DALLAS 근무");
		System.out.printf("   사원 이름  / 직급       / 부서 번호  / 부서명\n");
		for (String[] de : deData) {
			if (de[loc].equals("DALLAS")) {
				for (String[] em : emData) {
					if (em[deNo2].equals(de[deNo1])) {
						System.out.printf("   %-10s / %-10s / %-10s / %-10s\n", em[name], em[title], em[deNo2],
								de[deName]);
					}
				}
				break;
			}
		}
		System.out.println();

		System.out.println("7. 이름에 A 가 들어있는");
		System.out.println("   사원 이름  / 부서명 ");
		for (String[] em : emData) {
			if (!em[name].split("A")[0].equals(em[name])) {
				for (String[] de : deData) {
					if (de[deNo1].equals(em[deNo2])) {
						System.out.printf("   %-10s / %-10s\n", em[name], de[deName]);
						break;
					}
				}
			}
		}
		System.out.println();

		System.out.println("8. 10번 부서 근무 사원 이름, 부서명 조회");
		System.out.println("   사원 이름  / 부서명 ");
		for (String[] de : deData) {
			if (de[deNo1].equals("10")) {
				for (String[] em : emData) {
					if (em[deNo2].equals(de[deNo1])) {
						System.out.printf("   %-10s / %-10s\n", em[name], de[deName]);
					}
				}
				break;
			}
		}
		System.out.println();
		System.out.println("9. 1985년생 보다 나이 적은 사원 이름, 직책, 부서위치 조회");
		System.out.println("   사원 이름  / 직책        / 부서 위치");
		for (String[] em : emData) {
			if (em[data].split("-")[2].compareTo("1985") > 0) {
				for (String[] de : deData) {
					if (de[deNo1].equals(em[deNo2])) {
						System.out.printf("   %-10s / %-10s / %-10s\n", em[name], em[title], de[loc]);
						break;
					}
				}
			}
		}
	}

}
