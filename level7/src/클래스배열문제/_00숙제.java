package 클래스배열문제;

class ClientVO{
	int number;
	String name;
	int price;
	void init(int number ,String name, int price) {
		this.number = number;
		this.name = name;
		this.price = price;
	}
	void printInfo() {
		System.out.println(number +" " + name + " " + price);
	}
}
class CLinetDAO{
	
}

public class _00숙제 {

	public static void main(String[] args) {
		String data ="";
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
		System.out.println("====== 문제 1 =====");

		System.out.println("====== 문제 2 =====");

	}

}