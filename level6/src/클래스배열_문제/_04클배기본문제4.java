package 클래스배열_문제;

import java.util.Arrays;

class Test {
	int num;
	int size;
	char[] data;
}

public class _04클배기본문제4 {

	public static void main(String[] args) {

		// 초기 데이터
		String data = "";
		data += "0/2/a/b\n";
		data += "1/3/a/b/c\n";
		data += "2/5/a/b/c/d/e\n";
		data += "3/4/a/b/c/d\n";
		data += "4/3/a/b/c\n";
		data += "5/1/a";
		System.out.println(data);

		// 데이터 행 길이만큼 테스트 배열 생성
		String[] datas = data.split("\n");
		Test[] test = new Test[datas.length];

		// data 정보 클래스 배열 test에 저장
		for (int i = 0; i < datas.length; i++) {
			Test t = new Test();
			String[] rowData = datas[i].split("/");
			t.num = Integer.parseInt(rowData[0]);
			t.size = Integer.parseInt(rowData[1]);
			t.data = new char[t.size];
			
			for (int k = 0; k < t.size; k++)
				t.data[k] = rowData[k + 2].charAt(0);
			
			test[i] = t;
		}

		// test 배열 출력
		for (Test t : test) 
			System.out.printf("%d %d %s \n", t.num, t.size, Arrays.toString(t.data));
	}

}
