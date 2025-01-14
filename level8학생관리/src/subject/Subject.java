package subject;

public class Subject {

	private int stuNo;
	private String subName;
	private int subScore;

	Subject(String stuNo, String subName, String subScore) {
		this.stuNo = Integer.parseInt(stuNo);
		this.subName = subName;
		this.subScore = Integer.parseInt(subScore);
	}

	public int getStuNo() {
		return stuNo;
	}

	String getSubName() {
		return subName;
	}

	int getSubScore() {
		return subScore;
	}

	void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	void setSubName(String subName) {
		this.subName = subName;
	}

	void setSubScore(int subScore) {
		this.subScore = subScore;
	}

	@Override
	public String toString() {
		return String.format("%s %d점 \t", subName, subScore);
	}

}
