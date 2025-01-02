package 클래스배열문제;

class ConsumerVO {
	int number;
	String name;
	int price;

	int getPrice() {
		return price;
	}

	void init(int number, String name, int price) {
		this.number = number;
		this.name = name;
		this.price = price;
	}

	void printInfo() {
		System.out.println(number + " " + name + " " + price);
	}
}

class ConsumerDAO {

	ConsumerVO[] voList;
	String[] datas;
	String[][] data;
	int size;
	String[] numbers;
	String[] names;
	int[] prices;

	void init(String data) {
		datas = data.split("\n");
		this.data = new String[datas.length][];
		for (int i = 0; i < datas.length; i++)
			this.data[i] = datas[i].split("/");
	}

	void setVOSize() {
		int cntNonDupl = 0;
		for (int i = 0; i < datas.length; i++) {
			for (int k = 0; k < i; k++)
				if (isSameNumber(i, k)) {
					cntNonDupl--;
					break;
				}
			cntNonDupl++;
		}
		size = cntNonDupl;
	}

	boolean isSameNumber(int idx1, int idx2) {
		String num1 = getConsumerValue("number", idx1);
		String num2 = getConsumerValue("number", idx2);
		if (num1.equals(num2))
			return true;
		return false;
	}

	String getConsumerValue(String value, int idx) {
		if (value.equals("number"))
			return data[idx][0];
		else
			return data[idx][1];
	}

	int getConsumerPrice(int idx) {
		return Integer.parseInt(data[idx][2]);
	}

	boolean isDupl(String value, int end, int idx) {
		String[] values = setValue(value);
		for (int i = 0; i < end; i++)
			if (values[i].equals(getConsumerValue(value, idx)))
				return true;
		return false;
	}

	String[] setValue(String value) {
		if (value.equals("name"))
			return names;
		else
			return numbers;
	}

	void setNumbers() {
		numbers = new String[size];
		for (int i = 0; i < size; i++)
			for (int k = 0; k < datas.length; k++)
				if (!isDupl("number", i, k)) {
					numbers[i] = getConsumerValue("number", k);
					break;
				}
	}

	void setNames() {
		names = new String[size];
		for (int i = 0; i < size; i++)
			for (int k = 0; k < datas.length; k++)
				if (!isDupl("name", i, k)) {
					names[i] = getConsumerValue("name", k);
					break;
				}
	}

	void setPrices() {
		prices = new int[size];
		for (int i = 0; i < size; i++)
			for (int k = 0; k < datas.length; k++)
				if (numbers[i].equals(getConsumerValue("number", k)))
					prices[i] += getConsumerPrice(k);
	}

	void setVOList() {
		voList = new ConsumerVO[size];
		for (int i = 0; i < size; i++) {
			voList[i] = new ConsumerVO();
			voList[i].init(Integer.parseInt(numbers[i]), names[i], prices[i]);
		}
	}

	void run(String data) {
		init(data);
		setVOSize();
		setNumbers();
		setNames();
		setPrices();
		setVOList();
	}

	void printTotal() {
		for (ConsumerVO vo : voList)
			vo.printInfo();
	}

	void printTop() {
		int max = 0;
		int idx = 0;
		for (int i = 0; i < voList.length; i++)
			if (max < voList[i].getPrice()) {
				max = voList[i].getPrice();
				idx = i;
			}
		voList[idx].printInfo();
	}
}

public class _00숙제 {

	public static void main(String[] args) {

		String data = "";
		data += "10001/김철수/600\n";
		data += "10002/이영희/800\n";
		data += "10001/김철수/1400\n";
		data += "10003/유재석/780\n";
		data += "10002/이영희/950\n";
		data += "10004/박명수/330\n";
		data += "10001/김철수/670\n";
		data += "10003/유재석/3300\n";
		data += "10002/이영희/200\n";
		data += "10004/박명수/6800";

		ConsumerDAO dao = new ConsumerDAO();
		dao.run(data);

		System.out.println("====== 문제 1 =====");

		dao.printTotal();
		System.out.println("====== 문제 2 =====");

		dao.printTop();

	}

}