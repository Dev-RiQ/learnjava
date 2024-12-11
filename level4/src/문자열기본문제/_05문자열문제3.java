package 문자열기본문제;

public class _05문자열문제3 {

	public static void main(String[] args) {

		String userData = "1001,1002,1003,1004";
		String scoreData = "10,21,43,12";
		String[] userDatas = userData.split(",");
		String[] scoreDatas = scoreData.split(",");
		int idx = -1;
		int max = 0;
		int sum = 0;
		for (int i = 0; i < scoreDatas.length; i++) {
			if (max < Integer.parseInt(scoreDatas[i])) {
				max = Integer.parseInt(scoreDatas[i]);
				idx = i;
			}
			sum += Integer.parseInt(scoreDatas[i]);
		}
		double avg = sum * 1.0 / scoreDatas.length;
		System.out.println("1등 >> " + userDatas[idx] + "번 : " + scoreDatas[idx] + "점");
		System.out.printf("평균 >> %.1f점 \n", avg);
		
	}

}
