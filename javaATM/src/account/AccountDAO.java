package account;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import client.ClientDAO;
import controller.Controller;
import utils.Utils;

public class AccountDAO {

	private List<Account> aList;
	private Utils utils;

	private AccountDAO() {
		aList = new ArrayList<>();
		utils = Utils.getInstance();
	}

	private static AccountDAO instance;

	public static AccountDAO getInstance() {
		if (instance == null)
			instance = new AccountDAO();
		return instance;
	}

	/** 전체 계좌 데이터 유무 */
	private boolean hasData() {
		if (aList.size() == 0) {
			utils.showErrorMsg("데이터가 없습니다.");
			return false;
		}
		return true;
	}

	/** 아이디당 계좌 갯수 */
	private int getAccountCnt(int log) {
		int cnt = 0;
		for (Account a : aList)
			if (a.getClientNo() == log)
				cnt++;
		return cnt;
	}

	/** 해당 아이디 계좌 보유 여부 */
	private boolean hasAccount(int log) {
		if (!hasData())
			return false;
		int cnt = getAccountCnt(log);
		if (cnt == 0)
			utils.showErrorMsg("해당 계정에 생성된 계좌가 없습니다.");
		return cnt == 0 ? false : true;
	}

	/** 해당 아이디 계좌 최대 보유 여부 */
	private boolean hasMaxAccount(int log) {
		int cnt = getAccountCnt(log);
		if (cnt == 3)
			utils.showErrorMsg("더 이상 계좌를 생성할 수 없습니다. (현재 3개)");
		return cnt == 3 ? true : false;
	}

	/** 계좌번호 입력 */
	private String getAccount(String msg) {
		while (true) {
			String account = utils.getValue("▶ " + msg + " 계좌번호 입력 >> ");
			if (isValidAccount(account))
				return account;
		}
	}

	/** 계좌번호 형식 일치 판단 */
	private boolean isValidAccount(String account) {
		if (getMatcher(account).matches())
			return true;
		utils.showErrorMsg("잘못된 계좌번호 형식입니다.");
		return false;
	}

	/** 계좌번호 형식 일치 판단 */
	private Matcher getMatcher(String account) {
		String accPattern = "^\\d{4}-\\d{4}-\\d{4}$";
		Pattern pattern = Pattern.compile(accPattern);
		return pattern.matcher(account);
	}

	/** 신규 계좌 개설 중복 확인 */
	private boolean isDuplAccount(String account) {
		for (Account a : aList)
			if (a.getAccNumber().equals(account)) {
				utils.showErrorMsg("이미 존재하는 계좌번호입니다.");
				return true;
			}
		return false;
	}

	/** 아이디 보유 계좌 일치 여부 확인 */
	private boolean isMyAccount(String account, int log) {
		for (Account a : aList)
			if (a.getAccNumber().equals(account) && a.getClientNo() == log)
				return true;
		utils.showErrorMsg("소유하고 있는 계좌번호가 아닙니다.");
		return false;
	}

	/** 이체 계좌와 출금 계좌의 일치 여부 확인 */
	private boolean isNotMyAccount(String myAccount, String account) {
		if (!myAccount.equals(account))
			return true;
		utils.showErrorMsg("동일 계좌로는 이체할 수 없습니다.");
		return false;
	}

	/** 삭제 확인 메세지 */
	private boolean wantDelete() {
		utils.showMsg("정말로 삭제하시겠습니까 ? 예 : 0, 아니오 : 1");
		int sel = utils.getValue("▶ 선택 [0-1] >> ", 0, 1);
		if (sel == 1)
			utils.showMsg("삭제를 취소합니다.");
		return sel == 0 ? true : false;
	}

	/** 해당 계좌번호 인덱스 가져오기 */
	private int getIdx(String account) {
		for (int i = 0; i < aList.size(); i++)
			if (aList.get(i).getAccNumber().equals(account))
				return i;
		return -1;
	}

	/** 현재 잔액 표시 */
	private void showMyMoney(String account) {
		utils.showMsg("현재 잔액은 " + aList.get(getIdx(account)).getMoney() + "원 입니다.");
	}

	/** 이체 및 출금 범위 설정(현재 잔액 기준) */
	private int getMoney(String account) {
		return aList.get(getIdx(account)).getMoney();
	}

	/** 현재 잔액 100원 이상 판단 */
	private boolean validMoney(String account) {
		if (aList.get(getIdx(account)).getMoney() > 99)
			return true;
		utils.showErrorMsg("현재 잔액이 최소 요구 금액보다 적습니다.");
		showMyMoney(account);
		return false;
	}

	/** 계좌 존재 여부 판단 */
	private boolean hasAccount(String account) {
		for (Account a : aList)
			if (a.getAccNumber().equals(account))
				return true;
		utils.showErrorMsg("존재하지 않는 계좌입니다.");
		return false;
	}

	/** 출금 계좌 보유여부 판단 */
	private String getWithdrawInValidAccount(int log) {
		String account = getAccount("출금할");
		if (!isMyAccount(account, log) || !validMoney(account))
			return null;
		showMyMoney(account);
		return account;
	}

	/** 이체 계좌 존재 여부 판단 */
	private String getSendInValidAccount(String myAccount, int log) {
		String account = getAccount("이체할");
		if (!isNotMyAccount(myAccount, account) || !hasAccount(account))
			return null;
		return account;
	}

	/** 입금 및 출금 잔액 변동 */
	private void moneyFlow(String type, String account) {
		int money = getMoney(type, type.equals("입금") ? 100000000 : getMoney(account));
		changeMoney(type, account, money);
	}

	/** 이체 잔액 변동 */
	private void moneyFlow(String type, String account, String sendAccount) {
		int money = getMoney(type, getMoney(account));
		changeMoney(account, money);
		changeMoney(type, sendAccount, money);
	}
	
	/** 처리할 금액 입력 받기 */
	private int getMoney(String type, int end) {
		return utils.getValue(String.format("▶ %s할 금액 [100 - %d] >> ", type, end), 100, end);
	}

	/** 이체 후 내 계좌 잔액 감소 */
	private void changeMoney(String account, int money) {
		aList.get(getIdx(account)).setMoney(getMoney(account) - money);
	}

	/** 타입별 계좌 잔액 변동 */
	private void changeMoney(String type, String account, int money) {
		aList.get(getIdx(account)).setMoney(getMoney(account) + (type.equals("출금") ? -money : money));
		utils.showMsg(money + "원이 " + type + "되었습니다.");
		showMyMoney(account);
	}

	/** 모든 계좌 삭제 */
	public void deleteAccount(int clientNo) {
		if (!hasAccount(clientNo))
			return;
		deleteAllAccount(clientNo);
		utils.showMsg("모든 계좌의 삭제가 완료되었습니다.");
	}

	/** 모든 계좌 삭제 */
	private void deleteAllAccount(int clientNo) {
		for (int i = 0; i < aList.size(); i++)
			if (aList.get(i).getClientNo() == clientNo)
				aList.remove(i--);
	}

	/** 모든 계좌 정보 txt화 */
	public String getAllListToData() {
		if (!hasData())
			return null;
		String data = "";
		for (Account a : aList)
			data += String.format("%d/%s/%s/%d\n", a.getClientNo(), a.getClientId(), a.getAccNumber(), a.getMoney());
		return data.substring(0, data.length() - 1);
	}

	/** 불러온 계좌 정보 적용 */
	public void setListFromLoadData(String dataToFile) {
		if (dataToFile == null)
			return;
		aList = new ArrayList<>();
		addLoadData(dataToFile.split("\n"));
	}

	/** 불러온 계좌 정보 적용 */
	private void addLoadData(String[] datas) {
		for (int i = 0; i < datas.length; i++) {
			String[] info = datas[i].split("/");
			aList.add(new Account(info[0], info[1], info[2], info[3]));
		}
	}

	/** 신규 계좌 개설 */
	public void setNewAccount(ClientDAO cDAO, int log) {
		if (hasMaxAccount(log))
			return;
		String account = getAccount("생성할");
		if (!isDuplAccount(account))
			addNewAccount(cDAO, log, account);
	}

	/** 신규 계좌 개설 */
	private void addNewAccount(ClientDAO cDAO, int log, String account) {
		aList.add(new Account(log, cDAO.getClientId(log), account, 0));
		System.out.println(aList.get(aList.size() - 1));
		utils.showMsg("계좌가 생성되었습니다.");
	}

	/** 선택 계좌 삭제 */
	public void deleteAnAccount(int log) {
		if (!hasAccount(log))
			return;
		String account = getAccount("삭제할");
		if (!isMyAccount(account, log) || !wantDelete())
			return;
		aList.remove(getIdx(account));
		utils.showMsg("계좌 삭제가 완료되었습니다.");
	}

	/** 입금 */
	public void depositMoney(int log) {
		if (!hasAccount(log))
			return;
		String account = getAccount("입금할");
		if (!isMyAccount(account, log))
			return;
		moneyFlow("입금", account);
	}

	/** 출금 */
	public void withdrawMoney(int log) {
		if (!hasAccount(log))
			return;
		String account = getWithdrawInValidAccount(log);
		if (account == null)
			return;
		moneyFlow("출금", account);
	}

	/** 송금 */
	public void sendMoney(int log) {
		if (!hasAccount(log))
			return;
		String myAccount = getWithdrawInValidAccount(log);
		if (myAccount == null)
			return;
		String sendAccount = getSendInValidAccount(myAccount, log);
		if (sendAccount == null)
			return;
		moneyFlow("이체", myAccount, sendAccount);
	}

	/** 사용자 회원 탈퇴 - 계좌 삭제 */
	public void deleteAccount(ClientDAO cDAO, int log) {
		if (!cDAO.isDeletedClient(log))
			return;
		deleteAccount(log);
		Controller.getInstance().setLog(0);
		utils.showMsg("회원이 삭제되었습니다.");
	}

	/** 해당 아이디 정보 출력 */
	public void showClientInfo(ClientDAO cDAO, int log) {
		cDAO.showClientInfo(log);
		if (!hasAccount(log))
			return;
		for (Account a : aList)
			if (a.getClientNo() == log)
				System.out.printf(" %s %d원\n", a.getAccNumber(), a.getMoney());
	}

}
