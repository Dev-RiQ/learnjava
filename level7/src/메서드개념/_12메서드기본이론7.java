package 메서드개념;

class Test10{
	String name;
	int age;
	
	void setName(String name) {
		this.name = name;
	}
	
	void setAge(int age) {
		if(age < 0) {
			this.age = 0;
			System.out.println("age는 0세 이상이어야합니다.");
			return;
		}
		this.age = age;
	}
	
	String getName() {
		return name;
	}
	
	int getAge() {
		return age;
	}
}

public class _12메서드기본이론7 {

	public static void main(String[] args) {

		// 객체주소.값 => 직접 접근 (조건 없으면 그냥써도 무방할듯?)
		Test10 t10 = new Test10();
		t10.name = "스폰지밥";
		t10.age = 3;
		System.out.println(t10.name);
		System.out.println(t10.age);
		
		// 객체주소.메서드 => 간접 접근 (값 입력에 조건을 주기 위해)
		Test10 t = new Test10();
		t.setName("둘리");
		t.setAge(1000);
		System.out.println(t.getName());
		System.out.println(t.getAge());
	}

}
