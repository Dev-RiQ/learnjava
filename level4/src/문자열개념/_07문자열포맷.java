package 문자열개념;

public class _07문자열포맷 {

	public static void main(String[] args) {

		/*
		"%d", // 1. 기본
		"%13d", // 2. n 자리수 확보, 오른쪽 정렬
		"%013d", // 3. 빈 자리수 0으로 채움
		"%+13d", // 4. 양수는 앞에 + 붙임
		"%,13d", // 5. 쉼표 사용
		"%-13d", // 6. 자리수 확보, 왼쪽 정렬
		"%+,013d" // 양양수는 앞에 + 붙임


		"%f", // 1. 기본 (소수점 6자리, 0으로 메움)
		"%.2f", // 2. 소수점 n자리까지
		"%13.2f", // 3. 정수자리 확보, 소수자리 제한

		"%s", // 1. 기본
		"%9s", // 2. 자리 확보
		"%.2s", // 3. ~글자만
		"%9.2s", // 4.
		"%-9s", // 5. 왼쪽 정렬


		*/
		// 문자열은 +(연결연산자) 로 연결할 수 있다. 
		
				System.out.println("안녕" + "하세요");
				
				// concat()
				String menu="";
				menu+="==== 롯데리아 ====";
				menu+="\n";
				menu+="1.햄버거 2000원"; 
				menu+="\n";
				menu+="2.콜라 200원"; 
				
				System.out.println(menu);
				
				
				String name ="박연미";
				System.out.println(name.concat("입니다"));
				
				
				String names[] = {"aaa" , "bbbbbbbbb" , "c"};
				int total[] = {270 , 100 , 25};
				double avg[] = new double[3];
				
				for(int i =0; i < 3;i+=1) {
					avg[i] = total[i]*1.0 /3;
				}
				
				for(int i =0; i < 3; i+=1) {
					System.out.printf("[%10s] [%+5d] [%6.2f] \n" , names[i] , total[i], avg[i]);
				}
				System.out.println("=======");
				for(int i =0; i < 3; i+=1) {
					System.out.printf("[%-10s] [%-5d] [%-6.2f] \n" , names[i] , total[i], avg[i]);
				}
				
				//String format() : 단순 출력이 아니라 문자열로 저장하고 싶을때 쓴다 
				String data="";
				for(int i =0; i < 3; i+=1) {
					data+= String.format("[%-10s] [%-5d] [%-6.2f] %n", names[i] , total[i], avg[i]);
				}
				
				System.out.println("=====");
				System.out.println(data);
		
	}

}
