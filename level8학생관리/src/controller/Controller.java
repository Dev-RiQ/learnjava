package controller;

import student.StudentDAO;
import subject.SubjectDAO;
import utills.Utils;

public class Controller {

	private StudentDAO stuDAO;
	private SubjectDAO subDAO;

	public Controller() {
		stuDAO = new StudentDAO();
		subDAO = new SubjectDAO();
	}

	private void mainMenu() {
		System.out.println("[1]학생추가");
		System.out.println("[2]학생삭제");
		System.out.println("[3]학생과목추가");
		System.out.println("[4]학생과목삭제");
		System.out.println("[5]전체학생목록");
		System.out.println("[6]한 과목 학생목록");
		System.out.println("[7]파일 저장");
		System.out.println("[8]파일 로드");
		System.out.println("[0]종료");
	}

	public void run() {
		Utils utils = Utils.getInstance();
		
		while (true) {
			mainMenu();
			int sel = utils.getValue("메뉴 선택", 0, 8);
			if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			} else if (sel == 1) {
				stuDAO.addStudent();
			} else if (sel == 2) {
				subDAO.deleteSubjectsByStudentNo(stuDAO.deleteAStudent());
			} else if (sel == 3) {
				subDAO.addSubjectToAStudent(stuDAO);
			} else if (sel == 4) {
				subDAO.deleteASubject(stuDAO);
			} else if (sel == 5) {
				stuDAO.printAllStudentByScore(subDAO);
			} else if (sel == 6) {
				subDAO.printAllSubjectBySubName(stuDAO);
			} else if (sel == 7) {
				utils.savaDataToFile("student.txt", stuDAO.getAllListToData());
				utils.savaDataToFile("subject.txt", subDAO.getAllListToData());
			} else if (sel == 8) {
				stuDAO.loadStudentData(utils.loadDataToFile("student.txt"));
				subDAO.loadSubjectData(utils.loadDataToFile("subject.txt"));
			}
		}
	}
}
