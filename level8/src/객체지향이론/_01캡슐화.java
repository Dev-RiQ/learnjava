package 객체지향이론;

//1. 캡슐(encapsulation) : 객체를 독립적으로 다룬다 => private getter setter
//접근 => 통해서 하는 것, 해당 클래스를 사용하는것
//접근제어자 default(package) , public, private , protected

//1. public : 프로젝트 안에 어디서든 접근 가능
//2. default(package) : 같은 패키지 내에서 어디서든 접근가능
//3. protected : 부모 자식 클래스에서만 접근 가능
//4. private : 자기자신 클래스에만 접근 가능



public class _01캡슐화 {

	public static void main(String[] args) {
			
		Test01 e1 = new Test01();
		Test01 e2 = new Test01(10,20);
		Test01 e3 = new Test01("100","200");
		
		// setter를 다 없애버리면 초기에 객체를 생성할때만
		// 값을 설정후 변동 불가능
		
		System.out.println(e1.getA());
		System.out.println(e1.getB());
		e1.printInfo2();
		
		
	}

}
