package 클래스배열_기본;

public class _02클배이론02 {

	public static void main(String[] args) {
		
		String[][] dataList = {
				{ "1001", "qwer", "1234", "김철수", "10" },
				{ "1002", "asdf", "2345", "이영희", "30" }
		};
		Student[] stList = new Student[dataList.length];
		for (int i = 0; i < stList.length; i++) {
			stList[i] = new Student();
			stList[i].number = Integer.parseInt(dataList[i][0]);
			stList[i].id = dataList[i][1];
			stList[i].pw = dataList[i][2];
			stList[i].name = dataList[i][3];
			stList[i].score = Integer.parseInt(dataList[i][4]);

		}
		for (Student s : stList) {
			System.out.printf("%s : %d \n","학번",s.number);
			System.out.printf("%s : %s \n","id",s.id);
			System.out.printf("%s : %s \n","pw",s.pw);
			System.out.printf("%s : %s \n","이름",s.name);
			System.out.printf("%s : %d \n","학번",s.score);
			System.out.println("----------------");
		}
	}
}
