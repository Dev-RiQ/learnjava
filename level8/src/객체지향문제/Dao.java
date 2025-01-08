package 객체지향문제;

import java.util.ArrayList;

public class Dao {
	
	private ArrayList<Member> memberList = new ArrayList<Member>();
	private ArrayList<Money> moneyList = new ArrayList<Money>();
	private ArrayList<Total> totalList = new ArrayList<Total>();
	
	
	private void init() {
		
		memberList.add(new Member(100001, "김행복", "010-1111-2222", "SK", "20151202", "A", "01"));
		memberList.add(new Member(100002, "이축복", "010-1111-3333", "SK", "20151206", "B", "01"));
		memberList.add(new Member(100003, "장믿음", "010-1111-4444", "SK", "20151001", "B", "30"));
		memberList.add(new Member(100004, "최사랑", "010-1111-5555", "SK", "20151113", "A", "30"));
		memberList.add(new Member(100005, "진평화", "010-1111-6666", "SK", "20151225", "B", "60"));
		memberList.add(new Member(100006, "차공단", "010-1111-7777", "SK", "20151211", "C", "60"));
		
		
		moneyList.add(new Money(100001, 20160001, 500, 5, 2500, "A001", "20160101"));
		moneyList.add(new Money(100001, 20160002, 1000, 4, 4000, "A002", "20160101"));
		moneyList.add(new Money(100001, 20160003, 500, 3, 1500, "A008", "20160101"));
		moneyList.add(new Money(100002, 20160004, 2000, 1, 2000, "A004", "20160102"));
		moneyList.add(new Money(100002, 20160005, 500, 1, 500, "A001", "20160103"));
		moneyList.add(new Money(100003, 20160006, 1500, 2, 3000, "A003", "20160103"));
		moneyList.add(new Money(100004, 20160007, 500, 2, 1000, "A001", "20160104"));
		moneyList.add(new Money(100004, 20160008, 300, 1, 300, "A005", "20160104"));
		moneyList.add(new Money(100004, 20160009, 600, 1, 600, "A006", "20160104"));
		moneyList.add(new Money(100004, 20160010, 3000, 1, 3000, "A007", "20160106"));
	}
	private void setTotalSum(ArrayList<Member> memberList, ArrayList<Money> moneyList) {
		for(int i = 0; i < memberList.size(); i++) {
			totalList.add(new Total()); 
			int userNum = memberList.get(i).getCustno();
			int sum = 0;
			for(int k = 0; k < moneyList.size(); k++) {
				if(userNum == moneyList.get(k).getCustno()) {
					sum += moneyList.get(k).getPrice();
				}
			}
			totalList.get(i).setSum(sum);
			totalList.get(i).setCustNo(memberList.get(i).getCustno());
			totalList.get(i).setCustname(memberList.get(i).getCustname());
		}
	}
	private void setWinUser() {
		
	    for (int i = 0; i < totalList.size(); i++) {
	        for (int k = i+1; k < totalList.size(); k++) {
	            if (totalList.get(i).getSum() < totalList.get(k).getSum()) {
	                int tempSum = totalList.get(i).getSum();
	                totalList.get(i).setSum(totalList.get(k).getSum());
	                totalList.get(k).setSum(tempSum);

	                int tempCustNo = totalList.get(i).getCustNo();
	                totalList.get(i).setCustNo(totalList.get(k).getCustNo());
	                totalList.get(k).setCustNo(tempCustNo);

	                String tempName = totalList.get(i).getCustname();
	                totalList.get(i).setCustname(totalList.get(k).getCustname());
	                totalList.get(k).setCustname(tempName);
	            }
	        }
	    }
	}
	private void printResult() {
		for(Total t : totalList) {
			if(t.getSum() > 0) {
				System.out.println(t);
				System.out.println("---------------");
			}
		}
	}
	
	public void run() {
		init();
		setTotalSum(memberList,moneyList);
		setWinUser();
		printResult();
	}
	
}
