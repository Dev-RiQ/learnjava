package 클래스배열이론;

//클래스 : 멤버변수(속성 값) + 메서드(행동 , 기능 )

class User{
	String name;
	int score;
	
	void init(String name, int score) {
		this.name = name;
		this.score = score;
	}
	void printUser() {
		System.out.println(name + " : "+ score);
	}
}

public class _01클래스배열기본이론 {

	public static void main(String[] args) {
		
		User[] list = new User[3]; // [null,null,null];
		
		for(int i = 0; i < list.length; i++) {
			list[i] = new User();
		}
		
		int num = 1;
		for(User u : list) {
			// 멤버변수 직접 접근
//			u.name = "길동" + num++;
//			u.score = 45 + num;
			
//			System.out.println(u.name + " : " + u.score);
			// 멤버변수 간접 접근
			u.init("길동"+num++, 45+num);
			u.printUser();
		}
	}
}
