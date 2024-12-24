package 클래스배열_문제;

public class _07클배학생과목2 {

	public static void main(String[] args) {

		String studentSample = "1001/이만수\n";
		studentSample += "1002/김철만\n";
		studentSample += "1003/오수정";

		String subjectSample = "";
		subjectSample += "1001/국어/100/0\n";
		subjectSample += "1001/수학/32/0\n";
		subjectSample += "1002/국어/23/0\n";
		subjectSample += "1002/수학/35/0\n";
		subjectSample += "1002/영어/46/0\n";
		subjectSample += "1003/수학/60/0\n";

		String[] studentSamples = studentSample.split("\n");
		String[] subjectSamples = subjectSample.split("\n");

		Student[] student = new Student[studentSamples.length];
		Subject[] subject = new Subject[subjectSamples.length];

		for (int i = 0; i < student.length; i++) {
			String[] studentTemp = studentSamples[i].split("/");
			Student s = new Student();
			s.number = Integer.parseInt(studentTemp[0]);
			s.name = studentTemp[1];

			student[i] = s;
		}

		for (int i = 0; i < subject.length; i++) {
			String[] subjectTemp = subjectSamples[i].split("/");
			Subject s = new Subject();
			s.stuNumber = Integer.parseInt(subjectTemp[0]);
			s.name = subjectTemp[1];
			s.score = Integer.parseInt(subjectTemp[2]);

			subject[i] = s;
		}

		System.out.println("=====================");
		System.out.println("문제 1 : student, subject배열 출력");
		System.out.println("=====================");

		for (Student s : student)
			System.out.printf("%d %s\n", s.number, s.name);

		System.out.println("=====================");

		for (Subject s : subject)
			System.out.printf("%d %s %d점\n", s.stuNumber, s.name, s.score);

		System.out.println("=====================");
		System.out.println("문제 2 : 59점 이하 과목 삭제후 문자열 저장 및 출력");
		System.out.println("=====================");

		subjectSample = "";
		for (Subject s : subject) {
			if (s.score > 59)
				subjectSample += s.stuNumber + "/" + s.name + "/" + s.score + "\n";
		}
		subjectSample = subjectSample.substring(0, subjectSample.length() - 1);
		System.out.println(subjectSample);
	}

}
