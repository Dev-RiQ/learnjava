package _레벨1시험;

public class _03문제 {

	public static void main(String[] args) {
	/*
	 	[문제]
			연필 7타를 여학생 3명과 남학생 4명에게 남김없이 똑같이 나누어 주었다.
			여학생들이 받은 연필 개수가 5의 배수이고,
			남학생들이 받은 연필 개수가 3의 배수인지 여부를
			treu 또는 false로 표현하시오
			(연필 1타는 12자루)
	 	[정답]
	 		false
	 */
	
		int penSet = 7;
		int male = 4;
		int female = 3;
		int penTotal = penSet * 12;
		int totalStudent = male + female;
		int penShare = penTotal / totalStudent;
		int penShareMale = penShare * male;
		int penShareFemale = penShare * female;
	
		boolean rs = penShareMale % 3 == 0 && penShareFemale % 5 == 0;
	
		System.out.println(rs);
		
		//시간 : 2분 53초
	}

}
