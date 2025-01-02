package 클래스배열문제;

// Student, Subject == > VO, DTO : 순수 데이터 저장 클래스 : 저장/출력
// DAO = dataAcessObject : 데이터를 접근하는 클래스
// 

class Student {

	int stuNo;
	String name;
	Subject[] subjects;

	int getStuNo() {
		return stuNo;
	}

	String getName() {
		return name;
	}

	Subject[] getSubjects() {
		return subjects;
	}

	void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}


	void setName(String name) {
		this.name = name;
	}

	void setSubjects(Subject[] subjects) {
		this.subjects = subjects;
	}
	@Override
	public String toString() {
		String print = getName() + "\n";
		for(Subject s : subjects)
			print+=s.getName() + " " + s.getScore() + "점\n";
		print+="\n---------------------";
		return print;
	}
}

class Subject {

	int stuNo;
	String name;
	int score;

	int getStuNo() {
		return stuNo;
	}

	String getName() {
		return name;
	}

	int getScore() {
		return score;
	}

	void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	void setName(String name) {
		this.name = name;
	}

	void setScore(int score) {
		this.score = score;
	}
}

// 여러 학생 관련 CRUD
class StudentDAO {

	int cnt;
	Student[] stuList;
	SubjectDAO subDAO;

	StudentDAO(String stuData, SubjectDAO subDAO) {
		this.subDAO = subDAO;
		String[] temp = stuData.split("\n");
		cnt = temp.length;
		stuList = new Student[cnt];
		setStuList(temp);
	}

	void setStuList(String[] temp) {
		for (int i = 0; i < cnt; i++) {
			String[] data = temp[i].split("/");
			stuList[i] = new Student();
			stuList[i].setStuNo(Integer.parseInt(data[0]));
			stuList[i].setName(data[1]);
			stuList[i].setSubjects(subDAO.getPersonalSubList(stuList[i].getStuNo()));
		}
	}

	Student[] getStuList() {
		return stuList;
	}
}

// 여러 과목 관련 CRUD
class SubjectDAO {

	int cnt;
	Subject[] subList;

	SubjectDAO(String subData) {
		String[] temp = subData.split("\n");
		cnt = temp.length;
		subList = new Subject[cnt];
		setSubList(temp);
	}

	void setSubList(String[] temp) {
		for (int i = 0; i < cnt; i++) {
			String[] data = temp[i].split("/");
			subList[i] = new Subject();
			subList[i].setStuNo(Integer.parseInt(data[0]));
			subList[i].setName(data[1]);
			subList[i].setScore(Integer.parseInt(data[2]));
		}
	}

	Subject[] getPersonalSubList(int stuNo) {
		int size = setSize(stuNo);
		Subject[] temp = new Subject[size];
		int idx = 0;
		for (int i = 0; i < cnt; i++)
			if (subList[i].getStuNo() == stuNo)
				temp[idx++] = subList[i];

		return temp;
	}

	int setSize(int stuNo) {
		int cnt = 0;
		for (Subject sub : subList)
			if (sub.getStuNo() == stuNo)
				cnt++;

		return cnt;
	}

}

// 전체 데이터를 다루는 곳 : 여러 DAO 모이는 곳 => Service 
class SchoolService {

	StudentDAO stuDAO;
	SubjectDAO subDAO;

	SchoolService(String stuData, String subData) {
		subDAO = new SubjectDAO(subData);
		stuDAO = new StudentDAO(stuData, subDAO);
	}

	void run() {
		printAllData();
	}

	void printAllData() {
		for(Student s : stuDAO.getStuList())
			System.out.println(s);
//		for (int i = 0; i < stuDAO.getStuList().length; i++) {
//			Student student = stuDAO.getStuList()[i];
//			System.out.println(student.getName());
//
//			for (int k = 0; k < student.getSubjects().length; k++) {
//				Subject subject = student.getSubjects()[k];
//				System.out.printf("%s %d점 \n", subject.getName(), subject.getScore());
//			}
//
//			System.out.println();
//			System.out.println("----------------------");
//		}
	}
}

public class _07학생성적관리 {

	public static void main(String[] args) {

		String stuData = "1001/이만수\n";
		stuData += "1002/김철만\n";
		stuData += "1003/오수정\n";
		String subData = "";
		subData += "1001/국어/10\n";
		subData += "1001/수학/32\n";
		subData += "1002/국어/23\n";
		subData += "1002/수학/35\n";
		subData += "1002/영어/46\n";
		subData += "1003/수학/60\n";
		subData += "1003/영어/100\n";

		SchoolService school = new SchoolService(stuData, subData);
		school.run();
	}

}
