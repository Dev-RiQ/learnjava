package level5시험;

public class _10 {

	public static void main(String[] args) {

		int monthList[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		String today = "2024-12-17";
		String[] todays = today.split("-");
		int[] ts = new int[3];
		for (int i = 0; i < ts.length; i++) {
			ts[i] = Integer.parseInt(todays[i]);
		}

		String rentalData = "";
		rentalData += "책번호/책제목/대여날짜/회원번호\n";
		rentalData += "20122/연필로쓰기/2024-11-17/1001\n";
		rentalData += "40143/외국어 공부의 감각/2024-10-27/1003\n";
		rentalData += "54321/컴퓨터활용능력/2024-12-15/1041\n";
		rentalData += "26543/아무튼,외국어/2023-01-11/1034";
		String[] rentals = rentalData.split("\n");
		String[][] rentalDatas = new String[rentals.length - 1][];
		for (int i = 0; i < rentals.length - 1; i++) {
			rentalDatas[i] = rentals[i + 1].split("/");
		}

		String userData = "";
		userData += "회원번호/책번호/대여일수(day)\n";
		userData += "1001/20122/10\n";
		userData += "1003/40143/8\n";
		userData += "1041/54321/5\n";
		userData += "1034/26543/2";
		String[] users = userData.split("\n");
		String[][] userDatas = new String[users.length - 1][];
		for (int i = 0; i < users.length - 1; i++) {
			userDatas[i] = users[i + 1].split("/");
		}

		System.out.println("[연체자 목록]");
		System.out.printf("[ %-4s | %-10s | %-6s | %-5s | %-6s | %-4s ]\n", "회원번호", "책제목", "연체일", "대여날짜", "경과일",
				"대여기간");
		for (int i = 0; i < rentals.length - 1; i++) {
			int dayCnt = 0;
			String rentalDay = rentalDatas[i][2];
			String[] rentalDays = rentalDay.split("-");
			int[] rtd = new int[3];
			for (int k = 0; k < rtd.length; k++) {
				rtd[k] = Integer.parseInt(rentalDays[k]);
			}
			String ableDay = null;
			for (int k = 0; k < users.length - 1; k++) {
				if (rentalDatas[i][3].equals(userDatas[i][0])) {
					ableDay = userDatas[i][2];
					break;
				}
			}
			int able = Integer.parseInt(ableDay);
			while (!(rtd[2] == ts[2] && rtd[1] == ts[1] && rtd[0] == ts[0])) {
				rtd[2]++;
				dayCnt++;
				if (rtd[2] > monthList[rtd[1] - 1]) {
					rtd[2] = 1;
					rtd[1]++;
					if (rtd[1] > 12) {
						rtd[1] = 1;
						rtd[0]++;
					}
				}
			}
			if (dayCnt > able) {
				System.out.printf("[ %-8s | %-10s | %-6s | %-10s | %-6s | %-8s ]\n", rentalDatas[i][3],
						rentalDatas[i][1], dayCnt - able, rentalDatas[i][2], dayCnt, able);
			}

		}
		// 소요 시간 : 22분 51초
	}

}
