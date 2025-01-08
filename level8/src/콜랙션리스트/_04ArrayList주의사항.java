package 콜랙션리스트;

import java.util.ArrayList;

public class _04ArrayList주의사항 {
	
	public static void main(String[] args) {
		
		int[] arr = {1,1,2,2,3,4,5,6,21,3,4,1,2};
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		for(int num : arr) 
			list.add(num);
		
		System.out.println(list);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == 3) {
				list.remove(i);
				i--;
			}
		}
		System.out.println(list);
	}
}
