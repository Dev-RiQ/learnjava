package 클래스배열_문제;

class Student {
	int number;
	String id;
	String pw;
	String name;
	int score;
}

public class _01클배기본문제1 {

	public static void main(String[] args) {

		String data = "";
		data += "1001,qwer,1234,김철민,100\n";
		data += "1002,asdf,2345,우중현,3\n";
		data += "1003,zxcv,3456,이만수,30";

		String[] studentList = data.split("\n");

		Student[] student = new Student[studentList.length];

		for (int i = 0; i < studentList.length; i++) {
			String[] info = studentList[i].split(",");
			student[i] = new Student();
			student[i].number = Integer.parseInt(info[0]);
			student[i].id = info[1];
			student[i].pw = info[2];
			student[i].name = info[3];
			student[i].score = Integer.parseInt(info[4]);
		}
		
		int count = 1;
		
		System.out.println("==========학생목록==========");
		for (Student s : student) {
			System.out.printf("[ %d ] 이름 : %s \t 학점 : %d점\n",count++ ,s.name, s.score);
		}
		System.out.println("============================");
		
		String firstRankName = "";
		int scoreMax = 0;
		
		for (Student s : student) {
			if (scoreMax < s.score) {
				scoreMax = s.score;
				firstRankName = s.name;
			}
		}
		System.out.println("1등 이름 : " + firstRankName);
	}

}
