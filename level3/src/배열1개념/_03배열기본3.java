package 배열1개념;

public class _03배열기본3 {

	public static void main(String[] args) {

		int[] arr1 = new int[5]; // 0 0 0 0 0
		double[] arr2 = new double[3]; // 0.0 0.0 0.0
		boolean[] arr3 = new boolean[2]; // false false
		char[] arr4 = new char[4]; // \u0000 => null문자라서 공백으로 보여짐
		String[] arr5 = new String[5]; // \u0000 => null문자
		
		//rd.nextInt()
		
		//arr1.length => 배열의 길이(방의 갯수)
		
		for(int i =0;i<arr1.length;i+=1) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for(int i =0;i<arr2.length;i+=1) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		for(int i =0;i<arr3.length;i+=1) {
			System.out.print(arr3[i] + " ");
		}
		System.out.println();
		for(int i =0;i<arr4.length;i+=1) {
			System.out.print(arr4[i] + " ");
		}
		System.out.println();
		for(int i =0;i<arr5.length;i+=1) {
			System.out.print(arr5[i] + " ");
		}
		System.out.println();
	}

}
