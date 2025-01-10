package 회원관리;

import java.util.ArrayList;

public class MemberDAO {

	private ArrayList<Member> memberList;

	MemberDAO() {
		memberList = new ArrayList<>();
	}

	public void join() {
		String id = getId();
		memberList.add(new Member(id, Utils.getValue("pw >> "), Utils.getValue("이름 >> ")));
		System.out.println(id + "님 가입을 환영합니다 !");
	}

	private String getId() {
		String id = "";
		while (true) {
			id = Utils.getValue("id >> ");
			if (isHaveId(id))
				System.err.println("중복된 아이디입니다.");
			else
				break;
		}
		return id;
	}

	private boolean isHaveId(String id) {
		for (Member member : memberList)
			if (member.getId().equals(id))
				return true;
		return false;
	}

	private boolean isVaild(String msg) {
		if (memberList.size() == 0) {
			System.err.println(msg + "할 데이터가 없습니다.");
			return false;
		}
		return true;

	}

	public void delete() {
		if (!isVaild("삭제"))
			return;

		String id = Utils.getValue("삭제할 id >> ");
		if (!isHaveId(id))
			System.err.println("존재하지 않는 ID입니다.");
		else
			System.out.println("id : " + id + "의 삭제가 완료되었습니다.");
	}

	public void update() {
		if (!isVaild("수정"))
			return;

		String id = Utils.getValue("pw를 변경할 id >> ");
		if (!isHaveId(id))
			System.err.println("존재하지 않는 ID입니다.");
		else {
			memberList.get(getMatchIndex(id)).setPw(Utils.getValue("변경할 pw >> "));
			System.out.println("id : " + id + "의 pw변경이 완료되었습니다.");
		}

	}

	private int getMatchIndex(String id) {
		for (int i = 0; i < memberList.size(); i++)
			if (memberList.get(i).getId().equals(id))
				return i;
		return -1;
	}

	public void printAll() {
		if (!isVaild("출력"))
			return;

		System.out.println("전체 데이터를 출력합니다.");
		for (Member member : memberList)
			System.out.println(member);
	}

	public void addLoadedMemberData(String dataFromFile) {
		String[] temp = dataFromFile.split("\n");
		for (int i = 0; i < temp.length; i++) {
			String[] info = temp[i].split(" : ");
			memberList.add(new Member(info[0], info[1], info[2]));
		}
	}

	public String getMemberList() {
		String data = "";
		for (Member member : memberList)
			data += member.toString() + "\n";
		return data;
	}

}
