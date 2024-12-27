package 메서드문제;

class Return3 {

	final String[] LABLE = { "학생번호", "이름", "지역", "국어", "수학", "영어", "총합", "평균" };

	void printLable() {
		for (String l : LABLE)
			System.out.printf("[ %s ] ", l);
		System.out.println();
	}

	void printDeepArray(String[][] result) {
		for (String[] col : result) {
			for (int i = 0; i < col.length; i++)
				System.out.printf(i==0?"[  %5s   ]":i==1? " [%s]":i==2? " [ %2s ]":i!=col.length-1?" [ %3s  ]":" [%s ]",col[i]);
			System.out.println();
		}
	}

	String[][] getStuList(String[][] student, String[][] score) {
		String[][] studentTotalDatas = new String[student.length][LABLE.length];
		for (int i = 0; i < student.length; i++) {
			studentTotalDatas[i][0] = student[i][2];
			studentTotalDatas[i][1] = student[i][0];
			studentTotalDatas[i][2] = student[i][1];
			int personalTotalScore = 0;
			for (int k = 3; k <= 5; k++)
				for (String[] s : score)
					if (s[1].equals(LABLE[k]) && s[0].equals(student[i][2])) {
						studentTotalDatas[i][k] = s[2];
						personalTotalScore += Integer.parseInt(s[2]);
					}
			double averagePersonalTotalScore = (double) personalTotalScore / 3;
			studentTotalDatas[i][6] = personalTotalScore + "";
			studentTotalDatas[i][7] = String.format("%.2f", averagePersonalTotalScore);
			
		}
		return studentTotalDatas;
	}
}

public class _07메서드연습문제3 {

	public static void main(String[] args) {

		Return3 re = new Return3();
		
		String[][] student = {
				{ "김철만", "신촌", "1001" },
				{ "오상덕", "강남", "1002" },
				{ "민철이", "대치", "1003" },
				{ "유재석", "강동", "1004" }
		};
		String[][] score = {
				{ "1001", "국어", "20" },
				{ "1002", "국어", "50" },
				{ "1003", "국어", "60" },
				{ "1004", "국어", "17" },
				{ "1001", "수학", "65" },
				{ "1002", "수학", "15" },
				{ "1003", "수학", "80" },
				{ "1004", "수학", "70" },
				{ "1001", "영어", "43" },
				{ "1002", "영어", "90" },
				{ "1003", "영어", "30" },
				{ "1004", "영어", "70" }
		};
		String result[][] = re.getStuList(student, score);
		re.printLable();
		re.printDeepArray(result);
	}

}
