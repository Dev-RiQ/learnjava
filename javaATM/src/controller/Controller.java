package controller;

import account.AccountDAO;
import client.ClientDAO;
import utils.Utils;

// atm 프로젝트 요구사항 

// [1]관리자 [2]사용자 [0]종료
//관리자
// [1] 회원목록 [2] 회원수정 [3]회원 삭제 [4]데이터 저장 [5]데이터 불러오기
// 회원수정 : 회원 아이디로 검색 . 비밀번호 , 이름 수정가능
// 회원삭제 : 회원 아이디 일치 시 삭제여부
// 데이터 저장 : account.txt , client.txt

// 사용자메뉴
// [1] 회원가입 [2] 로그인 [0] 뒤로가기
// 회원가입 : 회원 아이디 중복 확인

// 로그인메뉴
// [1] 계좌추가 [2] 계좌삭제 [3] 입금 [4] 출금 [5] 이체 [6]탈퇴 [7]마이페이지 [0]로그아웃

// 계좌추가 : 숫자4개-숫자4개-숫자4개 (정규표현식 사용) 일치할때 추가가능 , 중복 계좌번호 불가능 , 계좌 총 3개까지만 생성가능 
// 계좌삭제 : 본인 회원 계좌만 삭제 가능 , 
// 입금 : account에 계좌가 존재할때만 입금가능 :100이상 입금/이체/출금 : 계좌잔고만큼만 가능
// 이체 : 잔고 내에서만 이체가능 본인 계좌사이에서 이체 가능.동일계좌 이체불가능
// 탈퇴 : 비밀번호 다시 입력받아서 탈퇴가능. 
// 마이페이지 : 아아디/비밀번호/이름/ 내 계좌목록/잔고 확인

public class Controller {

	private int log = 0;

	private ClientDAO cDAO;
	private AccountDAO aDAO;

	private Controller() {
		cDAO = ClientDAO.getInstance();
		aDAO = AccountDAO.getInstance();
	}

	private static Controller instance;

	public static Controller getInstance() {
		if (instance == null)
			instance = new Controller();
		return instance;
	}

	public int getLog() {
		return log;
	}

	public void setLog(int log) {
		this.log = log;
	}

	private void showLogo() {
		System.out.println("========[ 더조은 뱅크 ]========");
	}

	private void showMainMenu() {
		showLogo();
		System.out.println("[1] 관리자 메뉴");
		System.out.println("[2] 사용자 메뉴");
		System.out.println("[0] 종료");
	}

	private void showManagerMenu() {
		showLogo();
		System.out.println("[1] 회원 목록");
		System.out.println("[2] 회원 수정");
		System.out.println("[3] 회원 삭제");
		System.out.println("[4] 데이터 저장");
		System.out.println("[5] 데이터 불러오기");
		System.out.println("[0] 뒤로 가기");
	}

	private void showUserMenu() {
		showLogo();
		System.out.println("[1] 회원 가입");
		System.out.println("[2] 로그인");
		System.out.println("[0] 뒤로 가기");
	}

	private void showLogInMenu() {
		showLogo();
		System.out.println("[1] 계좌 추가");
		System.out.println("[2] 계좌 삭제");
		System.out.println("[3] 입금");
		System.out.println("[4] 출금");
		System.out.println("[5] 이체");
		System.out.println("[6] 회원 탈퇴");
		System.out.println("[7] 마이페이지");
		System.out.println("[0] 로그아웃");
	}

	private void backToMainMenu(Utils utils) {
		utils.showErrorMsg("메인 메뉴로 돌아갑니다.");
	}

	private void runManagerMenu(Utils utils) {
		while (true) {
			showManagerMenu();
			int sel = utils.getValue("▶ 관리자 메뉴 선택 [0-5] >> ", 0, 5);
			if (sel == 1)
				// 회원 목록
				cDAO.showAllClientList();
			else if (sel == 2)
				// 회원 수정
				cDAO.editClient();
			else if (sel == 3)
				// 회원 삭제
				cDAO.deleteClient(aDAO);
			else if (sel == 4) {
				// 데이터 저장
				utils.savaDataToFile("account.txt", aDAO.getAllListToData());
				utils.savaDataToFile("client.txt", cDAO.getAllListToData());
			} else if (sel == 5) {
				// 데이터 불러오기
				aDAO.setListFromLoadData(utils.loadDataToFile("account.txt"));
				cDAO.setListFromLoadData(utils.loadDataToFile("client.txt"));
			} else {
				// 뒤로가기
				backToMainMenu(utils);
				return;
			}
		}
	}

	private void runUserMenu(Utils utils) {
		while (true) {
			showUserMenu();
			int sel = utils.getValue("▶ 사용자 메뉴 선택 [0-2] >> ", 0, 2);
			if (sel == 1)
				// 회원가입
				cDAO.setNewClient();
			else if (sel == 2)
				// 로그인 메뉴
				runLogInMenu(utils);
			else {
				// 뒤로가기
				backToMainMenu(utils);
				return;
			}
		}
	}

	private void runLogInMenu(Utils utils) {
		log = cDAO.getLog();
		while (log != 0) {
			showLogInMenu();
			int sel = utils.getValue("▶ 메뉴 선택 [0-7] >> ", 0, 7);
			if (sel == 1)
				// 계좌 개설
				aDAO.setNewAccount(cDAO, log);
			else if (sel == 2)
				// 지정 계좌 삭제
				aDAO.deleteAnAccount(log);
			else if (sel == 3)
				// 입금
				aDAO.depositMoney(log);
			else if (sel == 4)
				// 출금
				aDAO.withdrawMoney(log);
			else if (sel == 5)
				// 이체
				aDAO.sendMoney(log);
			else if (sel == 6)
				// 회원 탈퇴
				aDAO.deleteAccount(cDAO, log);
			else if (sel == 7)
				// 회원 정보 조회
				aDAO.showClientInfo(cDAO, log);
			else
				// 로그아웃
				log = 0;
		}
	}

	public void run() {
		Utils utils = Utils.getInstance();
		while (true) {
			showMainMenu();
			int sel = utils.getValue("▶ 메인 메뉴 선택 [0-2] >> ", 0, 2);
			if (sel == 1)
				// 관리자 메뉴
				runManagerMenu(utils);
			else if (sel == 2)
				// 사용자 메뉴
				runUserMenu(utils);
			else
				// 종료
				break;
		}
		utils.showMsg("프로그램이 종료되었습니다.");
	}
}
