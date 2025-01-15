package client;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import account.AccountDAO;
import utils.Utils;

public class ClientDAO {

	private List<Client> cList;
	private Utils utils;

	private ClientDAO() {
		cList = new ArrayList<>();
		utils = Utils.getInstance();
	}

	private static ClientDAO instance;

	public static ClientDAO getInstance() {
		if (instance == null)
			instance = new ClientDAO();
		return instance;
	}

	/** Client 데이터 존재 여부 판단 */
	private boolean hasData() {
		if (cList.size() == 0) {
			utils.showErrorMsg("데이터가 없습니다.");
			return false;
		}
		return true;
	}

	/** 삭제 확인 메세지 */
	private boolean wantDelete() {
		utils.showMsg("현재 계좌에 남아있는 모든 금액이 소멸합니다.");
		utils.showMsg("정말로 삭제하시겠습니까 ? 예 : 0, 아니오 : 1");
		int sel = utils.getValue("▶ 선택 [0-1] >> ", 0, 1);
		if (sel == 1)
			utils.showMsg("삭제를 취소합니다.");
		return sel == 0 ? true : false;
	}

	/** id 입력 */
	private String getId() {
		return utils.getValue("▶ id 입력 >> ");
	}

	/** pw 입력 */
	private String getPw() {
		return utils.getValue("▶ pw 입력 >> ");
	}

	/** 이름 입력 */
	private String getName() {
		return utils.getValue("▶ 이름 입력 >> ");
	}
	
	/** 아이디 유효성 검사 */
	private boolean isValidId(String id) {
		if (getMatcher(id, 6, 7).matches())
			return true;
		utils.showErrorMsg("6~7글자의 아이디를 설정해주세요.");
		return false;
	}
	
	/** 비밀번호 유효성 검사 */
	private boolean isValidPw(String pw) {
		if (getMatcher(pw, 3, 4).matches())
			return true;
		utils.showErrorMsg("3~4글자의 비밀번호를 설정해주세요.");
		return false;
	}
	
	/** 유효성 검사 (start~end) 범위 일치 여부 */
	private Matcher getMatcher(String type, int start, int end) {
		String accPattern = String.format("^\\S{%d,%d}$", start, end);
		Pattern pattern = Pattern.compile(accPattern);
		return pattern.matcher(type);
	}

	/** 계정 생성 시 중복 여부 */
	private boolean isDuplId(String id) {
		for (Client c : cList)
			if (c.getId().equals(id)) {
				utils.showErrorMsg("중복된 아이디입니다.");
				return true;
			}
		return false;
	}

	/** 데이터 내 아이디 보유 여부 */
	private boolean hasId(String id) {
		for (Client c : cList)
			if (c.getId().equals(id))
				return true;
		utils.showErrorMsg("존재하지 않는 아이디입니다.");
		return false;
	}

	/** id 일치 인덱스 가져오기 */
	private int getIdx(String id) {
		for (int i = 0; i < cList.size(); i++)
			if (cList.get(i).getId().equals(id))
				return i;
		return -1;
	}

	/** ClientNo 일치 인덱스 가져오기 */
	private int getIdx(int log) {
		for (int i = 0; i < cList.size(); i++)
			if (cList.get(i).getClientNo() == log)
				return i;
		return -1;
	}

	/** 비밀번호 변경 시 기존 비밀번호와 일치하는지 여부 */
	private boolean isNotMatchPw(int idx, String pw) {
		if (!cList.get(idx).getPw().equals(pw))
			return true;
		utils.showErrorMsg("기존 비밀번호와 다르게 입력하세요.");
		return false;
	}

	/** 비밀번호 일치 여부 */
	private boolean isMatchPw(int idx, String pw) {
		if (cList.get(idx).getPw().equals(pw))
			return true;
		utils.showErrorMsg("비밀번호가 일치하지 않습니다.");
		return false;
	}
	
	/** id 기반 회원 번호 가져오기 */
	private int getClientNo(String id) {
		for (Client c : cList)
			if (c.getId().equals(id))
				return c.getClientNo();
		return 0;
	}

	/** Client 목록 전체 출력 */
	public void showAllClientList() {
		if (!hasData())
			return;
		for (Client c : cList)
			System.out.print(c);
	}

	/** 회원 정보 수정 */
	public void editClient() {
		if (!hasData())
			return;
		String id = getId();
		if (!hasId(id))
			return;
		utils.showMsg("수정할 정보를 입력하세요.");
		setEditClient(getIdx(id), getPw(), getName());
	}

	/** 회원 정보 수정 */
	private void setEditClient(int idx, String pw, String name) {
		if (!isValidPw(pw) || !isNotMatchPw(idx, pw))
			return;
		cList.get(idx).setPw(pw);
		cList.get(idx).setName(name);
		utils.showMsg("회원 정보가 수정되었습니다.");
	}

	/** 관리자 회원 삭제 */
	public void deleteClient(AccountDAO aDAO) {
		if (!hasData())
			return;
		String id = getId();
		deleteClient(aDAO, getId(), cList.get(getIdx(id)).getClientNo());
	}

	/** 관리자 회원 삭제 */
	private void deleteClient(AccountDAO aDAO, String id, int clientNo) {
		if (!hasId(id) || !wantDelete())
			return;
		deleteClientData(id);
		aDAO.deleteAccount(clientNo);
		utils.showMsg("회원이 삭제되었습니다.");
	}
	
	/** 관리자 회원 정보 삭제(id 일치) */
	private void deleteClientData(String id) {
		for (int i = 0; i < cList.size(); i++)
			if (cList.get(i).getId().equals(id)) {
				cList.remove(i);
				return;
			}
	}
	
	/** 모든 회원 정보 txt화 */
	public String getAllListToData() {
		if (!hasData())
			return null;
		String data = "";
		for (Client c : cList)
			data += String.format("%d/%s/%s/%s\n", c.getClientNo(), c.getId(), c.getPw(), c.getName());
		return data.substring(0, data.length() - 1);
	}
	
	/** 불러온 회원 정보 적용 */
	public void setListFromLoadData(String dataToFile) {
		if (dataToFile == null)
			return;
		cList = new ArrayList<>();
		addLoadData(dataToFile.split("\n"));
		Client.setClientNumber(cList.get(cList.size() - 1).getClientNo() + 1);
	}
	
	/** 불러온 회원 정보 적용 */
	private void addLoadData(String[] datas) {
		for (int i = 0; i < datas.length; i++) {
			String[] info = datas[i].split("/");
			cList.add(new Client(info[0], info[1], info[2], info[3]));
		}
	}

	/** 사용자 회원 탈퇴 - 계정 정보 삭제 및 성공 여부 */
	public boolean isDeletedClient(int log) {
		int idx = getIdx(log);
		if (!isMatchPw(idx, getPw()) || !wantDelete())
			return false;
		deleteClientData(cList.get(idx).getId());
		return true;
	}

	/** 신규 회원 가입 */
	public void setNewClient() {
		String id = getId();
		if (isDuplId(id) || !isValidId(id))
			return;
		String pw = getPw();
		if (!isValidPw(pw))
			return;
		String name = getName();
		addNewClient(id, pw, name);
	}

	/** 신규 회원 등록 */
	private void addNewClient(String id, String pw, String name) {
		cList.add(new Client(Client.getClientNumber(), id, pw, name));
		Client.setClientNumber(Client.getClientNumber() + 1);
		System.out.print(cList.get(cList.size() - 1));
		utils.showMsg("회원가입이 완료되었습니다.");
	}

	/** 로그인하기 */
	public int getLog() {
		String id = getId();
		if (!hasId(id))
			return 0;
		String pw = getPw();
		if (!isMatchPw(getIdx(id), pw))
			return 0;
		return getClientNo(id);
	}

	/** 회원번호 기반 ID 가져오기 */
	public String getClientId(int log) {
		for (Client c : cList)
			if (c.getClientNo() == log)
				return c.getId();
		return null;
	}

	/** 로그인 회원 정보 출력 */
	public void showClientInfo(int log) {
		for (Client c : cList)
			if (c.getClientNo() == log) {
				printInfo(c);
				break;
			}
	}

	/** 로그인 회원 정보 출력 형식 */
	private void printInfo(Client c) {
		System.out.printf("===== %s님 정보 =====\n", c.getName());
		System.out.printf("아이디   : %s\n", c.getId());
		System.out.printf("비밀번호 : %s\n", c.getPw());
		System.out.printf("이름     : %s\n", c.getName());
	}

}
