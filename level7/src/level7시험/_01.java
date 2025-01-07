package level7시험;

class Node {
	int number;
	String name;
	String address;
	int[] scoreList = new int[3];
	int total;
	double avg;
	int rank;

	Node(String number, String name, String address) {
		this.number = Integer.parseInt(number);
		this.name = name;
		this.address = address;
	}

	int getNumber() {
		return number;
	}

	int[] getScoreList() {
		return scoreList;
	}

	int getTotal() {
		return total;
	}

	void setScoreList(int[] scoreList) {
		this.scoreList = scoreList;
	}

	void setTotal(int total) {
		this.total = total;
	}

	void setAvg(double avg) {
		this.avg = avg;
	}

	void setRank(int rank) {
		this.rank = rank;
	}

	String setString() {
		String str = "";
		str += String.format("%d %s %s ", number, name, address);
		for (int i = 0; i < scoreList.length; i++)
			str += String.format("%-3d ", scoreList[i]);
		str += String.format("%-3d %6.2f점 %d등", total, avg, rank);
		return str;
	}

	@Override
	public String toString() {
		return setString();
	}

}

class Return {

	void setnList(String[][] student, String[][] score, Node[] nList) {
		for (int i = 0; i < nList.length; i++) {
			nList[i] = new Node(student[i][2], student[i][0], student[i][1]);
			setPersonalScoreList(score, nList, i);
			setPersonalScoreTotal(nList, i);
			setPersonalScoreAvg(nList, i);
		}
		setPersonalScoreRank(nList);
	}

	void setPersonalScoreList(String[][] score, Node[] nList, int idx) {
		for (int i = 0; i < score.length; i++)
			if (nList[idx].getNumber() == Integer.parseInt(score[i][0])) {
				int[] scores = new int[nList[idx].getScoreList().length];
				for (int k = 1; k < score[idx].length; k++)
					scores[k - 1] = Integer.parseInt(score[i][k]);
				nList[idx].setScoreList(scores);
			}
	}

	void setPersonalScoreTotal(Node[] nList, int idx) {
		int total = 0;
		for (int score : nList[idx].getScoreList())
			total += score;
		nList[idx].setTotal(total);
	}

	void setPersonalScoreAvg(Node[] nList, int idx) {
		double avg = (double) nList[idx].getTotal() / nList[idx].getScoreList().length;
		nList[idx].setAvg(avg);
	}

	void setPersonalScoreRank(Node[] nList) {
		for (int i = 0; i < nList.length; i++) {
			int cnt = 1;
			for (Node n : nList)
				if (nList[i].getTotal() < n.getTotal())
					cnt++;
			nList[i].setRank(cnt);
		}
	}

	void printnList(Node[] nList) {
		for (Node node : nList)
			System.out.println(node);
	}

	Node[] getnList(String[][] student, String[][] score) {
		Node[] nList = new Node[student.length];
		setnList(student, score, nList);
		printnList(nList);
		return nList;
	}
}

public class _01 {

	public static void main(String[] args) {

		String[][] student= {
				{"이만수","신촌","1001"},	
				{"김철민","강남","1002"},	
				{"심창효","대치","1003"},	
				{"유재석","강동","1004"}	
		};
		String[][] score = {
				{"1003","23","63","31"},
				{"1001","10","60","60"},
				{"1002","100","20","30"},
				{"1004","45","30","35"},
		};

		Return re = new Return();
		Node[] nodeList = re.getnList(student, score);
	}
	// 소요 시간 : 19분 29초
}
