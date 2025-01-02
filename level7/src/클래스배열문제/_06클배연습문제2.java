package 클래스배열문제;

class Node2 {
	int number;
	String name;
	String address;
	int[] scoreList = new int[3];
	int total;
	double avg;
	int rank;

	public int getTotal() {
		return total;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	void setNode2(int number, String name, String address, int[] scoreList, int total, double avg) {
		this.number = number;
		this.name = name;
		this.address = address;
		this.scoreList = scoreList;
		this.total = total;
		this.avg = avg;
	}

	void printNode2() {
		System.out.printf("[%8d] [%s] [%s] [%4d] [%4d] [%4d] [%4d] [%6.2f] [%4d] \n", number, name, address,
				scoreList[0], scoreList[1], scoreList[2], total, avg, rank);
	}
}

class Node2DAO {

	Node2[] getList(String[][] student, String[][] score) {
		int size = student.length;
		Node2[] list = setList(student, score, size);
		setRank(list);
		printAll(list);
		return list;
	}

	Node2[] setList(String[][] student, String[][] score, int size) {
		Node2[] list = new Node2[size];
		for (int i = 0; i < size; i++) {
			list[i] = new Node2();
			int number = Integer.parseInt(score[i][0]);
			int idx = setIndex(student, score, i);
			String name = idx != -1 ? student[idx][0] : "      ";
			String address = idx != -1 ? student[idx][1] : "    ";
			int[] scoreList = setScore(score, i);
			int total = setTotal(scoreList);
			double avg = (double) total / 3;
			list[i].setNode2(number, name, address, scoreList, total, avg);
		}
		return list;
	}

	int setIndex(String[][] student, String[][] score, int idx) {
		for (int i = 0; i < student.length; i++)
			if (student[i][2].equals(score[idx][0]))
				return i;
		return -1;
	}

	int[] setScore(String[][] score, int idx) {
		int[] scoreList = new int[3];
		for (int i = 0; i < scoreList.length; i++) {
			scoreList[i] = getScore(score, idx, i);
		}
		return scoreList;
	}

	int getScore(String[][] score, int idx1, int idx2) {
		int scores = Integer.parseInt(score[idx1][idx2 + 1]);
		if (scores < 0 || scores > 100)
			scores = 0;
		return scores;
	}

	int setTotal(int[] scoreList) {
		int total = 0;
		for (int s : scoreList)
			total += s;
		return total;
	}

	void setRank(Node2[] list) {
		for (Node2 node1 : list) {
			int rank = 1;
			for (Node2 node2 : list)
				if (node1.getTotal() < node2.getTotal())
					rank++;
			node1.setRank(rank);
		}
	}

	void printAll(Node2[] list) {
		System.out.println("[학생번호] [이  름] [지역] [국어] [수학] [영어] [총합] [평  균] [등수]");
		for (Node2 node2 : list)
			node2.printNode2();
	}

}

public class _06클배연습문제2 {

	public static void main(String[] args) {

		String[][] student = {
				{"이만수","신촌","1001"},
				{"김철민","강남","1002"},
				{"심창효","대치","1003"},
				{"유재석","강릉","1004"}
		};
		String[][] score = {
				{"1001","10","60","60"},
				{"1002","100","20","30"},
				{"1003","23","63","31"},
				{"1004","45","30","35"}
		};
		
		Node2DAO dao = new Node2DAO();
		Node2[] list = dao.getList(student, score);
	}

}
