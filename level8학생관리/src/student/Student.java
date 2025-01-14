package student;

import subject.Subject;

public class Student {

	private static int stuNumber = 1001;
	private int stuNo;
	private String stuName;
	private String stuId;
	private Subject[] subjects;
	private double avg;

	Student(String stuNo, String stuName, String stuId) {
		this.stuNo = Integer.parseInt(stuNo);
		this.stuName = stuName;
		this.stuId = stuId;
	}

	public int getStuNo() {
		return stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	String getStuId() {
		return stuId;
	}

	Subject[] getSubjects() {
		return subjects;
	}

	double getAvg() {
		return avg;
	}

	static int getStuNumber() {
		return stuNumber;
	}

	static void setStuNumber(int stuNumber) {
		Student.stuNumber = stuNumber;
	}

	void setAvg(double avg) {
		this.avg = avg;
	}

	void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	void setStuName(String stuName) {
		this.stuName = stuName;
	}

	void setStuId(String stuId) {
		this.stuId = stuId;
	}

	void setSubjects(Subject[] subjects) {
		this.subjects = subjects;
	}

	private String getToString() {
		String print = String.format("%d \t %s \t %s \t 평균 %.2f점 \n", stuNo, stuId, stuName, avg);
		return print;
	}

	@Override
	public String toString() {
		return getToString();
	}

}
