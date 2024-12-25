package level6시험;

class Employee {
	int no;
	String name;
	String title;
	int supNo;
	String date;
	int salary;
	int com;
	int deNo;
}

class Department {
	int no;
	String name;
	String location;
}

public class _01 {

	public static void main(String[] args) {

		String[][] deData = { { "10", "ACCOUNTING", "NEW YORK" }, { "20", "RESEARCH", "DALLAS" },
				{ "30", "SALES", "CHICAGO" }, { "40", "OPERATIONS", "BOSTON" } };
		String[][] emData = { { "7369", "SMITH", "CLERK", "7902", "17-12-1980", "800", "0", "20" },
				{ "7499", "ALLEN", "SALESMAN", "7698", "20-2-1981", "1600", "300", "30" },
				{ "7521", "WARD", "SALESMAN", "7698", "22-2-1981", "1250", "500", "30" },
				{ "7566", "JONES", "MANAGER", "7839", "2-4-1981", "2975", "0", "20" },
				{ "7654", "MARTIN", "SALESMAN", "7698", "28-9-1981", "1250", "1400", "30" },
				{ "7698", "BLAKE", "MANAGER", "7839", "1-5-1981", "2850", "0", "30" },
				{ "7782", "CLARK", "MANAGER", "7839", "9-6-1981", "2450", "0", "10" },
				{ "7788", "SCOTT", "ANALYST", "7566", "13-7-1987", "3000", "0", "20" },
				{ "7839", "KING", "PRESIDENT", "NULL", "17-11-1981", "5000", "1000", "10" },
				{ "7844", "TURNER", "SALESMAN", "7698", "8-9-1981", "1500", "0", "30" },
				{ "7876", "ADAMS", "CLERK", "7788", "13-7-1987", "1100", "0", "20" },
				{ "7900", "JAMES", "CLERK", "7698", "3-12-1981", "950", "0", "30" },
				{ "7902", "FORD", "ANALYST", "7566", "3-12-1981", "3000", "0", "20" },
				{ "7934", "MILLER", "CLERK", "7782", "23-1-1982", "1300", "0", "10" } };

		Employee[] eList = new Employee[emData.length];
		Department[] dList = new Department[deData.length];

		for (int i = 0; i < eList.length; i++) {
			Employee e = new Employee();
			e.no = Integer.parseInt(emData[i][0]);
			e.name = emData[i][1];
			e.title = emData[i][2];
			if (!emData[i][3].equals("NULL"))
				e.supNo = Integer.parseInt(emData[i][3]);
			e.date = emData[i][4];
			e.salary = Integer.parseInt(emData[i][5]);
			e.com = Integer.parseInt(emData[i][6]);
			e.deNo = Integer.parseInt(emData[i][7]);

			eList[i] = e;
		}

		for (int i = 0; i < dList.length; i++) {
			Department d = new Department();
			d.no = Integer.parseInt(deData[i][0]);
			d.name = deData[i][1];
			d.location = deData[i][2];

			dList[i] = d;
		}

		System.out.println("[문제 1] 부서별 평균 월 급여");
		System.out.println("부서명 \t\t 평균급여");
		for (Department d : dList) {
			int totalSalary = 0;
			int cntMember = 0;
			for (Employee e : eList)
				if (d.no == e.deNo) {
					totalSalary += e.salary;
					cntMember++;
				}
			double averageSalary = 0;
			;
			if (totalSalary != 0)
				averageSalary = totalSalary * 1.0 / cntMember;
			System.out.printf("%-10s \t ", d.name);
			System.out.printf(averageSalary == 0 ? "no data\n" : "%.2f \n", averageSalary);
		}

		System.out.println();
		System.out.println("[문제 2] 부서별 전체 사원수와 커미션을 받는 사원들의수");
		System.out.println("부서명 \t\t 전체 사원 수 \t 커미션 받은 사원 수");
		for (Department d : dList) {
			int cntMember = 0;
			int cntCom = 0;
			for (Employee e : eList)
				if (d.no == e.deNo) {
					cntMember++;
					if (e.com != 0)
						cntCom++;
				}
			System.out.printf("%-10s \t ", d.name);
			System.out.printf(cntMember == 0 ? "no data \t no data \n" : "%-10d \t %d \n", cntMember, cntCom);
		}

		System.out.println();
		System.out.println("[문제 3] 부서별 최대 급여와 최소 급여");
		System.out.println("부서명 \t\t 최대 급여 \t 최소 급여");

		for (Department d : dList) {
			int maxSalary = 0;
			int minSalary = 99999;
			for (Employee e : eList)
				if (d.no == e.deNo) {
					if (maxSalary < e.salary)
						maxSalary = e.salary;
					if (minSalary > e.salary)
						minSalary = e.salary;

				}
			System.out.printf("%-10s \t ", d.name);
			System.out.printf(maxSalary == 0 ? "no data \t no data \n" : "%-10d \t %d \n", maxSalary, minSalary);
		}

		System.out.println();
		System.out.println("[문제 4] 부서번호가 10번인 사원들의 이름, 직급, 부서번호, 부서위치 조회");
		System.out.println("이름 \t\t 직급 \t\t 부서코드 \t 부서위치");

		int deNo = 10;
		for (Employee e : eList)
			if (e.deNo == deNo) {
				System.out.printf("%-10s \t %-10s \t %-10d \t ", e.name, e.title, e.deNo);
				for (Department d : dList)
					if (d.no == deNo)
						System.out.printf("%s \n", d.location);
			}
		System.out.println();
		System.out.println("[문제 5] 커미션을 받는 사원의 이름, 커미션, 부서이름, 부서위치 조회");
		System.out.println("이름 \t\t 커미션 \t 부서이름 \t 부서위치");

		for (Employee e : eList)
			if (e.com != 0)
				for (Department d : dList)
					if (d.no == e.deNo)
						System.out.printf("%-10s \t %-10d \t %-10s \t %s \n", e.name, e.com, d.name, d.location);

		System.out.println();
		System.out.println("[문제 6] 급여가 높은 순으로 조회하되 급여가 같을 경우 이름의 철자가 느린 사원순으로 사번, 이름, 월급여 조회");
		System.out.println("사번 \t\t 이름 \t\t 월급여");

		int max = 0;
		for (Employee e : eList)
			if (max < e.salary)
				max = e.salary;

		int[] rList = new int[eList.length];
		int idx = 0;
		while (idx != eList.length) {
			for (int i = 0; i < eList.length; i++)
				if (eList[i].salary == max)
					rList[idx++] = i;
			max--;
		}

		for (int i = 0; i < rList.length; i++) {
			int cnt = 0;
			int index = i;
			while (true) {
				if (index != eList.length - 1 && eList[rList[index]].salary == eList[rList[index + 1]].salary) {
					cnt++;
					index++;
					continue;
				}
				for (int k = i; k < i + cnt; k++) {
					if (eList[rList[k]].name.compareTo(eList[rList[k + 1]].name) > 0) {
						int temp = rList[k];
						rList[k] = rList[k + 1];
						rList[k + 1] = temp;
						k = i - 1;
					}
				}
				i = index;
				break;
			}
		}

		for (int i = 0; i < rList.length; i++)
			System.out.printf("%-10d \t %-10s\t %d \n", eList[rList[i]].no, eList[rList[i]].name,
					eList[rList[i]].salary);

		System.out.println();
		System.out.println("[문제 7] NEW YORK에서 근무하는 사원의 이름, 직급, 부서번호, 부서명 조회");
		System.out.println("이름 \t\t 직급 \t\t 부서코드 \t 부서명");

		String loc = "NEW YORK";
		for (Department d : dList)
			if (d.location.equals(loc))
				for (Employee e : eList)
					if (d.no == e.deNo)
						System.out.printf("%-10s \t %-10s \t %-10d \t %s \n", e.name, e.title, e.deNo, d.name);

		System.out.println();
		System.out.println("[문제 8] 이름에 B 가 들어가는 사원의 이름, 부서명 조회");
		System.out.println("이름 \t\t 부서명");

		for (Employee e : eList)
			if (e.name.contains("B"))
				for (Department d : dList)
					if (d.no == e.deNo)
						System.out.printf("%-10s \t %s \n", e.name, d.name);

		System.out.println();
		System.out.println("[문제 9] SCOTT과 같은 부서 근무하는 사원의 이름, 부서번호 조회");
		System.out.println("이름 \t\t 부서코드");

		String name = "SCOTT";
		int code = 0;
		for (Employee e : eList)
			if (e.name.equals(name))
				code = e.deNo;

		for (Employee e : eList)
			if (e.deNo == code && !e.name.equals(name))
				System.out.printf("%-10s \t %d \n", e.name, e.deNo);

		System.out.println();
		System.out.println("[문제 10] 20번 부서에서 근무하는 사원의 이름과 20번 부서의 부서명 조회");
		System.out.println("이름 \t\t 부서명");

		int num = 20;
		for (Employee e : eList)
			if (e.deNo == num)
				for (Department d : dList)
					if (d.no == e.deNo)
						System.out.printf("%-10s \t %s \n", e.name, d.name);

		System.out.println();
		System.out.println("[문제 11] 전체 평균 월급여보다 더 많은 월급여를 받은 사원의 사원번호, 이름, 월급여 조회");
		System.out.println("사원번호 \t 이름 \t\t 월급여");

		int totalSalary = 0;
		for (Employee e : eList)
			totalSalary += e.salary;
		int averageTotalSalary = totalSalary / eList.length;
		for (Employee e : eList)
			if (e.salary > averageTotalSalary)
				System.out.printf("%-10d \t %-10s \t %d \n", e.no, e.name, e.salary);

		System.out.println();
		System.out.println("[문제 12] 부서번호가 20인 사원중에서 최대 급여를 받는 사원과 동일한 급여를 받는 사원의 사원번호 ,이름 조회");
		System.out.println("사원번호 \t 이름");

		int deNum = 20;
		int maxSal = 0;
		for (Employee e : eList)
			if (e.deNo == deNum && e.salary > maxSal)
				maxSal = e.salary;
		for (Employee e : eList)
			if (e.deNo == deNum && e.salary == maxSal)
				System.out.printf("%-10d \t %s \n", e.no, e.name);

		System.out.println();
		System.out.println("[문제 13] 사원 테이블에서 사원명과 해당 사원의 관리자명 검색");
		System.out.println("이름 \t\t 관리자명");

		for (Employee e : eList)
			for (Employee el : eList)
				if (e.supNo == el.no)
					System.out.printf("%-10s \t %s \n", e.name, el.name);

		System.out.println();
		System.out.println("[문제 14] 사원 테이블에서 부서별 최대 급여를 받는 사원들의 사번, 이름, 부서코드, 급여 검색");
		System.out.println("사원번호 \t 이름 \t\t 부서코드 \t 급여");

		for (Department d : dList) {
			int maxSalary = 0;
			for (Employee e : eList)
				if (e.deNo == d.no && maxSalary < e.salary)
					maxSalary = e.salary;

			for (Employee e : eList)
				if (e.deNo == d.no && maxSalary == e.salary)
					System.out.printf("%-10s \t %-10s \t %-10d \t %d \n", e.no, e.name, e.deNo, e.salary);
		}

		// 소요 시간 : 1시간 13분 58초
	}

}
