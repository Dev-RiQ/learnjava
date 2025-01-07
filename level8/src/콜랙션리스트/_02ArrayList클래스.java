package 콜랙션리스트;

import java.util.ArrayList;

/*
 	배열의 특징
 	1. 같은 자료형만 들어온다
 	2. 배열 변수는 heap에 만든 배열의 주소값을 저장한다
 	3. 한번 선언하면 크기 변경 불가 => 가변배열 사용했음.
 */

/*
 	콜랙션 => 데이터를 저장하는 여러가지 알고리즘을 미리 구현한 여러 클래스들의 모음집
 	ArrayList<클래스>
 	
 	주요 기능
 	1. 추가 : add(value)
 	2. 삭제 : remove(idx),remove(value)
 	3. 삽입 : add(idx, value)
 	4. 수정 : set(idx, value)
 	5. 갯수 : size
 	6. 값읽기 : get(idx)
 	7. 전체삭제 : clear()
 */

public class _02ArrayList클래스 {

	public static void main(String[] args) {

		int[] arr = {10,20,30,40,50};
		// < > 제네릭 : class만 들어올 수 있음 => 기본 자료형 레퍼
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println(list);
		System.out.println(list.size());
		System.out.println();
		for(int value : arr)
			list.add(value);
		System.out.println(list.size());
		for(int i = 0 ; i < list.size() ; i++)
			System.out.print(list.get(i)+" ");
		System.out.println();
		System.out.println("=====");
		System.out.println(list.remove(0));
		System.out.println(list.remove(Integer.valueOf(20)));
		System.out.println("=====");
		list.add(0,100);
//		list.add(10,100);
		System.out.println(list);
		list.set(1,1000);
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list);
		for(int i = 0 ; i< 10; i++)
			list.add(i+1);
		System.out.println(list);
	}

}
