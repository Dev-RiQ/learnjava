package 클래스배열이론;

//메서드 오버로딩 : 한개의 클래스내에서 같은 이름으로 메서드를 여러개 만드는 것
//주의사항 : 반드시 외부값이 달라야한다 => 외부값의 자료형형태 , 갯수, 순서
class Person{
	String name;
	int age;
	boolean gender;
	
	void init() {
		name = "김찰스";
		age = 18;
		gender = true;
		
	}
//	int init() {
//		return 0;
//	}
	void init(String name) {
		this.name = name;
		age = 18;
		gender = true;
	}
	
	void init(String name, int age) {
		this.name = name;
		this.age = age;
		gender = true;
	}
	void init(String name, int age, boolean gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;	
	}
	void personInfo() {
		System.out.println(name + " : " + age + " : " + gender);
	}
}

public class _02메소드오버로딩 {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.init();
		p1.personInfo();
		p1.init("개똥이");
		p1.personInfo();
		p1.init("둘리",5,false);
		p1.personInfo();
		p1.init("짱구",6);
		p1.personInfo();

		
	}
}
