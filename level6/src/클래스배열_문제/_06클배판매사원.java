package 클래스배열_문제;


class Employee {
	int no; // 사원번호
	int point; // 판매실적
	String name; // 사원이름
	boolean isBest; // 우수사원여부
}

public class _06클배판매사원 {

	public static void main(String[] args) {

		String data1 = "1001/3,1002/1,1001/3,1003/5,1004/1,1002/2";
		String data2 = "1001/이만수,1002/김철수,1003/신민아,1004/박상아";

		String[] datas1 = data1.split(",");
		String[][] pointData = new String[datas1.length][];
		for (int i = 0; i < pointData.length; i++)
			pointData[i] = datas1[i].split("/");

		String[] datas2 = data2.split(",");
		Employee[] employee = new Employee[datas2.length];

		for (int i = 0; i < employee.length; i++) {
			Employee e = new Employee();
			String[] info = datas2[i].split("/");
			e.no = Integer.parseInt(info[0]);
			e.name = info[1];

			for (String[] col : pointData) {
				if (info[0].equals(col[0]))
					e.point += Integer.parseInt(col[1]);
			}

			if (e.point > 3)
				e.isBest = true;

			employee[i] = e;
		}
		System.out.println("============ 전체 사원 출력 =============");
		for (Employee e : employee) {
			System.out.printf("%d %s %d %s \n", e.no, e.name, e.point, e.isBest);
		}

		System.out.println("============= 판매 베스트 사원 출력 ==============");
		for (Employee e : employee) {
			if (e.point > 3)
				System.out.printf("%d %s %d %s \n", e.no, e.name, e.point, e.isBest);
		}
	}

}
