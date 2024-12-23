package 클래스배열_문제;

public class _03클배기본문제3 {

	public static void main(String[] args) {
		// 초기 데이터
		String data = "";
		data += "김영희/30\n";
		data += "이민수/40\n";
		data += "이철민/60";
		
		// 데이터 유저 단위 배열화
		String[] datas = data.split("\n");
		Student[] studentList = new Student[datas.length];
		
		// 데이터 유저 개인 정보 단위 배열화
		for (int i = 0; i < datas.length; i++) {
			Student student = new Student();
			String[] studentData = datas[i].split("/");
			student.name = studentData[0];
			student.score = Integer.parseInt(studentData[1]);
			studentList[i] = student;
		}
		
		// 전체 유저 데이터 출력
		int studentCount = 1;
		for (Student s : studentList)
			System.out.printf("[ %d ] 이름 : %-5s \t 점수 : %-3d \n", studentCount++, s.name, s.score);
		
		// 가장 낮은 점수 찾기
		int scoreMin = studentList[0].score;
		for (Student s : studentList) {
			if (s.score < scoreMin)
				scoreMin = s.score;
		}

		// 가장 점수 낮은 유저 데이터 삭제
		data = "";
		for (Student s : studentList) {
			if (s.score != scoreMin) {
				data += s.name + "/" + s.score + "\n";
			}
		}
		data = data.substring(0,data.length() - 1);
		System.out.println(data);
	}

}
