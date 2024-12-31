package 클래스배열문제;

import java.util.Random;

/*
 	VO => value object, DTO => data transfer object
 	DAO => data access object, CRUD => create read update delete
 */

class RandNumVO {
	int num;
	boolean check;

	// 간접적으로 넣어주는 메서드
	void init(int num) {
		this.num = num;
	}

	// 간접적으로 값을 가져오는 메서드
	void printRandNum() {
		System.out.print(num + " ");
	}

	void printCheckDupl() {
		System.out.print(check == true ? "t " : "f ");
	}
}

class RandomNumDAO {
	Random rd;
	RandNumVO[] numList;
	int size;

	void init() {
		rd = new Random();
		size = 5;
		numList = new RandNumVO[size];

		for (int i = 0; i < numList.length; i++)
			numList[i] = new RandNumVO();

		setNumList();
	}

	void setNumList() {
		for (int i = 0; i < numList.length; i++)
			if (setNum(i))
				i--;
	}

	boolean setNum(int idx) {
		int num = rd.nextInt(size);
		if (numList[num].check)
			return true;
		numList[idx].num = num + 1;
		numList[num].check = true;
		return false;
	}

	void printNums() {
		for (RandNumVO vo : numList)
			System.out.print(vo.num + " ");
	}

	void run() {
		init();
		printNums();
	}
}

public class _01클배중복숫자제거 {

	public static void main(String[] args) {

		RandomNumDAO e = new RandomNumDAO();
		e.run();
	}

}
