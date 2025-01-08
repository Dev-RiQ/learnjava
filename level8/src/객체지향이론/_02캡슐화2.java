package 객체지향이론;

import java.util.ArrayList;

class Product{
	private String name;
	private  int price;
	
	public Product(String name, int price) {
		setName(name);
		setPrice(price);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		if(name == null || name.isBlank()) {
			System.out.println("이름이 비어있어서 무명이로 셋팅");
			this.name = "무명이";
			return;
		}
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	private void setPrice(int price) {
		
		if(price < 100) {
			System.out.println("최소 가격 셋팅은 100원 이상입니다");
			this.price = 100;
			return;
		}
		this.price = price;
	}
	@Override
	public String toString() {
		return name + " : " + price + "원";
	}
}
public class _02캡슐화2 {

	public static void main(String[] args) {
		
		
		// set를 막아놨기 때문에 처음에 객체 생성할때만 값을 넣어줄 수 있음
		Product p1 = new Product("필통", 1000);
		Product p2 = new Product("", 1000);
		Product p3 = new Product(null, -1000);
		
		ArrayList<Product> pList = new ArrayList<Product>();
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		
		for(Product p : pList)
			System.out.println(p);
	}

}
