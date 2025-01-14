package subject;

import java.util.ArrayList;
import java.util.Random;

import student.StudentDAO;
import utills.Utils;

public class SubjectDAO {

	private ArrayList<Subject> subList;

	public ArrayList<Subject> getSubList() {
		return subList;
	}

	public void setSubList(ArrayList<Subject> subList) {
		this.subList = subList;
	}

	public SubjectDAO() {
		subList = new ArrayList<>();
	}

	public double getSubAvg(int stuNo) {
		double avg = 0;
		int cnt = 0;
		for (Subject s : subList)
			if (s.getStuNo() == stuNo) {
				avg += s.getSubScore();
				cnt++;
			}
		if (cnt == 0)
			return 0;
		return avg / cnt;
	}

	public String getSubData(int stuNo) {
		String subData = "";
		for (Subject sub : subList) {
			if (stuNo == sub.getStuNo())
				subData += sub.toString();
		}
		if (subData.isBlank())
			subData += "[ no subject data ]";
		return subData;
	}

	public void deleteSubjectsByStudentNo(int deleteAStudent) {
		if (!hasSubData())
			return;
		if (deleteAStudent == -1) {
			System.out.println("[ 존재하지 않는 아이디입니다.]");
			return;
		}
		for (int i = 0; i < subList.size(); i++)
			if (subList.get(i).getStuNo() == deleteAStudent)
				subList.remove(i--);
	}

	public void addSubjectToAStudent(StudentDAO stuDAO) {
		if (!stuDAO.hasStuData())
			return;
		int stuNo = getStuNo(stuDAO);
		if (hasStuNo(stuNo))
			return;
		System.out.println("[국어, 수학, 영어]");
		String sub = Utils.getInstance().getValue("추가 과목 이름 입력 >>");
		for (Subject s : subList)
			if (s.getSubName().equals(sub) && s.getStuNo() == stuNo) {
				System.out.println("[ 이미 존재하는 과목 이름 입니다.]");
				return;
			}
		Random rd = new Random();
		subList.add(new Subject(stuNo + "", sub, rd.nextInt(101) + ""));
		System.out.println("[ 과목 추가 완료]");

	}

	private int getStuNo(StudentDAO stuDAO) {
		return stuDAO.getMatchStuNo(Utils.getInstance().getValue("[1001~9999] 학번 입력>>", 1001, 9999));
	}

	private boolean hasStuNo(int stuNo) {
		if (stuNo == -1) {
			System.out.println("[ 존재하지 않는 학번입니다. ]");
			return false;
		}
		return true;
	}

	public void deleteASubject(StudentDAO stuDAO) {
		if (!hasSubData())
			return;
		int stuNo = getStuNo(stuDAO);
		if (hasStuNo(stuNo))
			return;
		System.out.println("[국어, 수학, 영어]");
		String sub = Utils.getInstance().getValue("삭제 과목 이름 입력 >>");
		for (int i = 0; i < subList.size(); i++)
			if (subList.get(i).getSubName().equals(sub) && subList.get(i).getStuNo() == stuNo) {
				subList.remove(i);
				System.out.println("[ 과목 삭제 완료]");
				return;
			}
		System.out.println("[ 존재하지 않는 과목 이름 입니다.]");
	}

	private boolean hasSubData() {
		if (subList.size() == 0) {
			System.out.println("[ 과목 데이터가 존재하지 않습니다. ]");
			return false;
		}
		return true;
	}

	public void printAllSubjectBySubName(StudentDAO stuDAO) {
		if (!hasSubData())
			return;
		String sub = Utils.getInstance().getValue("검색 과목 이름 입력 >>");
		boolean hasName = false;
		for (int i = 0; i < subList.size(); i++)
			for (int k = 0; k < stuDAO.getStuListSize(); k++)
				if (subList.get(i).getSubName().equals(sub) && stuDAO.getStuNo(k) == subList.get(i).getStuNo()) {
					System.out.println(stuDAO.getStuName(k) + " " + subList.get(i).getSubScore() + "점");
					hasName = true;
				}
		if (!hasName)
			System.out.println("[ 해당 과목의 점수가 존재하지 않습니다.]");
	}

	public String getAllListToData() {
		if (!hasSubData())
			return null;
		String data = "";
		for (Subject s : subList)
			data += String.format("%d/%s/%s\n", s.getStuNo(), s.getSubName(), s.getSubScore());
		return data.substring(0, data.length() - 1);
	}

	public void loadSubjectData(String dataToFile) {
		subList = new ArrayList<>();
		String[] datas = dataToFile.split("\n");
		for (int i = 0; i < datas.length; i++) {
			String[] info = datas[i].split("/");
			subList.add(new Subject(info[0], info[1], info[2]));
		}
	}

}
