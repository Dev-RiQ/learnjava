package 메서드개념;

class Test05 {
	void type01() {
		System.out.println("type01실행했다");
	}
	
	void type02(int[] arr) {
		System.out.println("type02실행했다");
	}
	
	int[] type03() {
		System.out.println("type03실행했다");
		
		return null;
	}
	
	int type04(int[] arr) {
		System.out.println("type04실행했다");
		if(arr == null)
			return 0;
		int total = 0;
		for(int i = 0;i<arr.length;i++)
			total += arr[i];
		arr[0] = 0;
		return total;
	}
}

public class _09메서드기본이론5 {

	public static void main(String[] args) {

		Test05 t5 = new Test05();
		
		int[] arr = {10,20,30,40,50};
		System.out.println(t5.type04(arr));
		int total = t5.type04(arr);
		System.out.println(total);
		System.out.println(arr[0]);
		System.out.println(arr[0]);
	}

}
