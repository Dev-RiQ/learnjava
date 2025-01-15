package account;

public class Account {
	// 계정 당 최대 3계좌
	private int clientNo;
	private String clientId;
	private String accNumber;
	private int money;

	Account(int clientNo, String clientId, String accNumber, int money) {
		this.clientNo = clientNo;
		this.clientId = clientId;
		this.accNumber = accNumber;
		this.money = money;
	}

	Account(String clientNo, String clientId, String accNumber, String money) {
		this.clientNo = Integer.parseInt(clientNo);
		this.clientId = clientId;
		this.accNumber = accNumber;
		this.money = Integer.parseInt(money);
	}

	int getClientNo() {
		return clientNo;
	}

	String getClientId() {
		return clientId;
	}

	String getAccNumber() {
		return accNumber;
	}

	int getMoney() {
		return money;
	}

	void setClientNo(int clientNo) {
		this.clientNo = clientNo;
	}

	void setClientId(String clientId) {
		this.clientId = clientId;
	}

	void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return String.format("%d %-7s %s %d", clientNo, clientId, accNumber, money);
	}

}
