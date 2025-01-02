package 클래스배열문제;

class Node {
	int number;
	int score;

	public int getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = Integer.parseInt(number);
	}

	public int getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = Integer.parseInt(score);
	}
}

class NodeDAO {

	String[][] data;
	Node[] nList;
	int size;

	Node[] quiz1(String[][] data) {
		this.data = data;
		size = setPassListSize();
		setPassList();
		printPassList();
		return nList;
	}

	int setPassListSize() {
		int cnt = 0;
		for (String[] col : data) {
			int score = Integer.parseInt(col[1]);
			if (score >= 60)
				cnt++;
		}
		return cnt;
	}

	void setPassList() {
		nList = new Node[size];
		for (int i = 0; i < size; i++)
			for (int k = 0; k < data.length; k++)
				if (Integer.parseInt(data[k][1]) >= 60) {
					nList[i] = new Node();
					nList[i].setNumber(data[k][0]);
					nList[i].setScore(data[k][1]);
				}
	}

	void printPassList() {
		System.out.println("=== 합격생 리스트 ===");
		for (int i = 0; i < nList.length; i++)
			System.out.printf("[%d, %d] \n", nList[i].getNumber(), nList[i].getScore());
	}

	Node quiz2(String[][] data) {
		Node node = setMinScoreNode(setMinScoreIndex());
		printMinScore(node);
		return node;
	}

	Node setMinScoreNode(int minScoreIdx) {
		Node node = new Node();
		node.setNumber(data[minScoreIdx][0]);
		node.setScore(data[minScoreIdx][1]);
		return node;
	}

	int setMinScoreIndex() {
		int min = 100;
		int idx = -1;
		for (int i = 0; i < data.length; i++) {
			int score = Integer.parseInt(data[i][1]);
			if (score < min) {
				min = score;
				idx = i;
			}
		}
		return idx;
	}

	void printMinScore(Node node) {
		System.out.println("=== 뒤에서 일등 ===");
		System.out.printf("[%d, %d] \n", node.getNumber(), node.getScore());
	}

}

public class _05클배연습문제 {

	public static void main(String[] args) {

		String[][] data = { { "1001", "34" }, { "1002", "46" }, { "1003", "81" }, { "1004", "10" } };

		NodeDAO dao = new NodeDAO();
		// 60점 이상 합격생 정보 저장
		Node[] list = dao.quiz1(data);
		// 꼴등 뽑기
		Node min = dao.quiz2(data);
	}

}
