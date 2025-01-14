package student;

import java.util.ArrayList;

import subject.SubjectDAO;
import utills.Utils;

public class StudentDAO {

	private ArrayList<Student> stuList;

	public StudentDAO() {
		stuList = new ArrayList<>();
	}

	public ArrayList<Student> getStuList() {
		return stuList;
	}

	public void setStuList(ArrayList<Student> stuList) {
		this.stuList = stuList;
	}

	public int getMatchStuNo(int stuNo) {
		for (int i = 0; i < stuList.size(); i++)
			if (stuList.get(i).getStuNo() == stuNo) {
				return stuNo;
			}
		return -1;
	}

	public int getStuListSize() {
		return stuList.size();
	}

	public int getStuNo(int idx) {
		return stuList.get(idx).getStuNo();
	}

	public String getStuName(int idx) {
		return stuList.get(idx).getStuName();
	}

	public void addStudent() {
		String id = Utils.getInstance().getValue("[추가] 아이디 입력>>");
		if (isMatchId(id)) {
			System.out.println("[ 중복된 아이디입니다.]");
			return;
		}
		String name = Utils.getInstance().getValue("이름 입력>>");
		stuList.add(new Student(Student.getStuNumber() + "", name, id));
		Student.setStuNumber(Student.getStuNumber() + 1);
		System.out.println("[ 학생 한 명 추가 완료]");
	}

	public int deleteAStudent() {
		if (!hasStuData())
			return -1;
		String id = Utils.getInstance().getValue("삭제할 학생 아이디 입력>>");
		int stuNo = -1;
		if (!isMatchId(id))
			return stuNo;
		for (int i = 0; i < stuList.size(); i++)
			if (stuList.get(i).getStuId().equals(id)) {
				System.out.println("[ " + stuList.get(i) + " 삭제 완료 ]");
				stuNo = stuList.get(i).getStuNo();
				stuList.remove(i);
				break;
			}
		return stuNo;
	}

	public boolean hasStuData() {
		if (stuList.size() == 0) {
			System.out.println("[ 학생 데이터가 존재하지 않습니다. ]");
			return false;
		}
		return true;
	}

	private boolean isMatchId(String id) {
		for (Student s : stuList)
			if (s.getStuId().equals(id))
				return true;
		return false;
	}

	private void setSubAvg(SubjectDAO subDAO) {
		for (int i = 0; i < stuList.size(); i++)
			stuList.get(i).setAvg(subDAO.getSubAvg(stuList.get(i).getStuNo()));
	}

	private void setAsc() {
		for (int i = 0; i < stuList.size(); i++)
			for (int k = i + 1; k < stuList.size(); k++)
				if (stuList.get(i).getAvg() < stuList.get(k).getAvg()) {
					Student temp = stuList.get(i);
					stuList.set(i, stuList.get(k));
					stuList.set(k, temp);
				}
	}

	public void printAllStudentByScore(SubjectDAO subDAO) {
		if (!hasStuData())
			return;
		setSubAvg(subDAO);
		setAsc();

		System.out.println("[ 학생 목록( 점수 내림차순 ) ]");
		for (Student stu : stuList) {
			System.out.println(stu);
			String subData = subDAO.getSubData(stu.getStuNo());
			System.out.println(subData + "\n----------------------------------------------");
		}
	}

	public String getAllListToData() {
		if (!hasStuData())
			return null;
		String data = "";
		for (Student s : stuList)
			data += String.format("%d/%s/%s\n", s.getStuNo(), s.getStuName(), s.getStuId());
		return data.substring(0, data.length() - 1);
	}

	public void loadStudentData(String dataToFile) {
		stuList = new ArrayList<>();
		String[] datas = dataToFile.split("\n");
		for (int i = 0; i < datas.length; i++) {
			String[] info = datas[i].split("/");
			stuList.add(new Student(info[0], info[1], info[2]));
			if (Student.getStuNumber() < stuList.get(i).getStuNo())
				Student.setStuNumber(stuList.get(i).getStuNo());
		}
		Student.setStuNumber(Student.getStuNumber() + 1);

	}

}
