package client;

public class Client {

	private static int clientNumber = 1001;
	private int clientNo;
	private String id;
	private String pw;
	private String name;

	Client(int clientNo, String id, String pw, String name) {
		this.clientNo = clientNo;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	Client(String clientNo, String id, String pw, String name) {
		this.clientNo = Integer.parseInt(clientNo);
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	static int getClientNumber() {
		return clientNumber;
	}

	static void setClientNumber(int clientNumber) {
		Client.clientNumber = clientNumber;
	}

	int getClientNo() {
		return clientNo;
	}

	String getId() {
		return id;
	}

	String getPw() {
		return pw;
	}

	String getName() {
		return name;
	}

	void setClientNo(int clientNo) {
		this.clientNo = clientNo;
	}

	void setId(String id) {
		this.id = id;
	}

	void setPw(String pw) {
		this.pw = pw;
	}

	void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%d.  %-7s %-4s %s\n", clientNo, id, pw, name);
	}

}
