package 클래스배열이론;

// 오버로딩 : overloading : 같은 클래스에서 같은 이름으로 메서드 여러개 생성
// 오버라이딩 : override : 부모클래스에서 부모메서드를 자식클래스에서 재정의 => 메서드 정의 수정 불가, 바디{ }만 수정가능

class Ex02{
	String name;
	int price;
	
	Ex02(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	void print() {
		System.out.println(name+" "+price+"원 ");
	}

	@Override
	public String toString() {
		return "Ex02 [name=" + name + ", price=" + price + "]";
	}
}



public class _04toString개념 {

	public static void main(String[] args) {

		Ex02 e = new Ex02("스폰지밥필통",3000);
		e.print();
		
		System.out.println(e);
		Ex02 e2 = new Ex02("짱구필통",13000);
		
		System.out.println(e2);
	}

}
