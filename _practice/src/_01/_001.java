package _01;
public class _001 {

	public static int sum (int a, int b) {
		return a + b;
	}
	public static int sumP (int a,int b) {
		int c = 0;
		for(int i = a;i<=b;i++) {
			c += i;
		}
		return c;
	}
	public class calc {
		int a;
		int b;
		public int sum2 () {
			return a + b;
		}
	}
	public static void main(String[] args) {
		//내부 스태틱 변수
		int a = 12;
		int b = 45;
		System.out.println(sum(a,b));
		//외부 클래스 인스턴스 변수
		_002 s = new _002();
		s.a = 1;
		s.b = 5;
		System.out.println(s.sum2());
		//내부 클래스 인스턴스 변수
		_001 d = new _001();
		_001.calc f = d.new calc();
		f.a = 40;
		f.b = 90;
		System.out.println(f.sum2());
		//내부 클래스 스태틱 변수
		System.out.println(sumP(1,7));
		//외부 클래스 스태틱 변수
		System.out.println(_002.sumPO(1,10));
		//외부 클래스 인스턴스 변수
		System.out.println(s.sumPO());
		
		
		
	}
	

}
