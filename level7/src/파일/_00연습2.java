package 파일;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

class Student {
	int stuNo; // 학번
	String stuName; // 학생 이름
	int[] subjectScores; // 입학 시험 과목별 점수
	String stuBirthday; // 생년월일
	boolean isMale; // 성별
	int rank; // 등수

	int getStuNo() {
		return stuNo;
	}

	String getStuName() {
		return stuName;
	}

	int[] getSubjectScores() {
		return subjectScores;
	}

	String getStuBirthday() {
		return stuBirthday;
	}

	boolean getIsMale() {
		return isMale;
	}

	void setStuNo(String stuNo) {
		this.stuNo = Integer.parseInt(stuNo);
	}

	void setRank(int rank) {
		this.rank = rank;
	}

	Student(String stuName, String subjectScores1, String subjectScores2, String subjectScores3, String stuBirthday,
			String isMale) {
		this.stuName = stuName;
		int score1 = Integer.parseInt(subjectScores1);
		int score2 = Integer.parseInt(subjectScores2);
		int score3 = Integer.parseInt(subjectScores3);
		int[] scores = { score1, score2, score3 };
		this.subjectScores = scores;
		this.stuBirthday = stuBirthday;
		if (isMale.equals("남"))
			this.isMale = true;
	}

	String setPrint() {
		String data = "";
		int score = 0;
		for (int i = 0; i < subjectScores.length; i++)
			score += subjectScores[i];
		data += String.format("    [ %d  |  %s  |   %s   |    %s    |  %8d  | ", stuNo, stuName, stuBirthday,
				isMale ? "남" : "여", score);
		if (rank == 1)
			data += " 수석 ]\n";
		else if (rank == 2)
			data += " 차석 ]\n";
		else
			data += String.format(" %4d ]\n", rank);
		return data;
	}

	@Override
	public String toString() {
		return setPrint();
	}
}

class GradeClass {
	final int SIZE = 30; // 반 최대 학생 수
	int[] stuNo; // 해당 반의 stuNo

	int[] getStuNo() {
		return stuNo;
	}

	void setStuNo(int[] stuNo) {
		this.stuNo = stuNo;
	}

	@Override
	public String toString() {
		return "    [ Class";
	}
}

class StudentDAO {
	Random rd;
	Student[] sList;

	StudentDAO(String data) {
		rd = new Random();
		String[] datas = data.split("\r\n");
		int size = datas.length;
		sList = new Student[size];
		for (int i = 0; i < size; i++) {
			String[] temp = datas[i].split(",");
			sList[i] = new Student(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
		}
	}

	Student[] getsList() {
		return sList;
	}

	void setStuNo(int size) {
		boolean[] isUse = new boolean[sList.length];
		int[] stuCnt = setCnt(sList.length, size);
		for (int i = 0; i < size; i++) {
			String[][] classStu = setClassStu(isUse, stuCnt[i]);
			defineStuNo(classStu, stuCnt, i);
		}
	}

	void defineStuNo(String[][] classStu, int[] stuCnt, int idx) {
		int maleNum = 1;
		int femaleNum = 31;
		for (int i = 0; i < stuCnt[idx]; i++) {
			String stuNo = "25";
			stuNo += "0" + (idx + 1);
			int changeNum = setNumAndClassStuNo(classStu, stuNo, maleNum, femaleNum, i);
			if (changeNum == maleNum)
				maleNum++;
			else
				femaleNum++;
		}
	}

	int setNumAndClassStuNo(String[][] classStu, String stuNo, int maleNum, int femaleNum, int idx) {
		int num = 0;
		for (int i = 0; i < sList.length; i++) {
			boolean isMale = sList[i].getIsMale();
			boolean isSameName = classStu[idx][0].equals(sList[i].getStuName());
			boolean isSameBirthday = classStu[idx][1].equals(sList[i].getStuBirthday());
			if (isSameName && isSameBirthday) {
				stuNo += setClassStuNo(isMale, maleNum, femaleNum);
				sList[i].setStuNo(stuNo);
				num = isMale ? maleNum : femaleNum;
				break;
			}
		}
		return num;
	}

	String setClassStuNo(boolean isMale, int maleNum, int femaleNum) {
		int num = isMale ? maleNum : femaleNum;
		String stuNo = num < 10 ? "0" + num : num + "";
		return stuNo;
	}

	int[] setCnt(int sizeTotal, int size) {
		int[] cnt = new int[size];
		for (int i = 0; i < size; i++)
			cnt[i] = sizeTotal / size;
		int remainCnt = sizeTotal % size;
		if (remainCnt != 0)
			for (int i = 0; i < size; i++) {
				cnt[i]++;
				remainCnt--;
				if (remainCnt == 0)
					break;
			}
		return cnt;
	}

	String[][] setClassStu(boolean[] isUse, int stuCnt) {
		String[][] temp = new String[stuCnt][2];
		for (int i = 0; i < stuCnt; i++) {
			int idx = rd.nextInt(isUse.length);
			if (isUse[idx])
				i--;
			else {
				temp[i][0] = sList[idx].getStuName();
				temp[i][1] = sList[idx].getStuBirthday();
				isUse[idx] = true;
			}
		}
		ascArray(temp);
		return temp;
	}

	void ascArray(String[][] temp) {
		for (int i = 0; i < temp.length; i++)
			for (int k = 0; k < temp.length; k++)
				if (temp[i][0].compareTo(temp[k][0]) < 0
						|| (temp[i][0].compareTo(temp[k][0]) == 0 && temp[i][1].compareTo(temp[k][1]) < 0)) {
					String set1 = temp[i][0];
					String set2 = temp[i][1];
					temp[i][0] = temp[k][0];
					temp[i][1] = temp[k][1];
					temp[k][0] = set1;
					temp[k][1] = set2;
				}
	}

	void setRank() {
		for (int i = 0; i < sList.length; i++) {
			int cnt = 1;
			for (int k = 0; k < sList.length; k++)
				if (getScore(i) < getScore(k))
					cnt++;
			sList[i].setRank(cnt);
		}
	}

	int getScore(int idx) {
		int score = 0;
		int[] scores = sList[idx].getSubjectScores();
		for (int i = 0; i < scores.length; i++)
			score += scores[i];
		return score;
	}
}

class GradeClassDAO {
	GradeClass[] cList;

	GradeClass[] getcList() {
		return cList;
	}

	int setMaxSize() {
		GradeClass gc = new GradeClass();
		return gc.SIZE;
	}

	void setcListSize(Student[] sList) {
		int size = sList.length / setMaxSize();
		if (sList.length % setMaxSize() != 0)
			size++;
		cList = new GradeClass[size];
	}

	void setcList(Student[] sList, int[] cnt) {
		for (int i = 0; i < cList.length; i++) {
			cList[i] = new GradeClass();
			int[] stuNo = new int[cnt[i]];
			int idx = 0;
			for (int j = 0; j < sList.length; j++) {
				int classNum = (sList[j].getStuNo() / 100) % 100;
				if (classNum == i + 1)
					stuNo[idx++] = sList[j].getStuNo();
			}
			ascArray(stuNo);
			cList[i].setStuNo(stuNo);
		}
	}

	void ascArray(int[] stuNo) {
		for (int i = 0; i < stuNo.length; i++)
			for (int k = 0; k < stuNo.length; k++)
				if (stuNo[i] < stuNo[k]) {
					int temp = stuNo[i];
					stuNo[i] = stuNo[k];
					stuNo[k] = temp;
				}
	}
}

class SchoolService {
	StudentDAO sdao;
	GradeClassDAO cdao;

	SchoolService(String data) {
		sdao = new StudentDAO(data);
		cdao = new GradeClassDAO();
	}

	void joinData() {
		cdao.setcListSize(sdao.getsList());
		sdao.setStuNo(cdao.getcList().length);
		cdao.setcList(sdao.getsList(), sdao.setCnt(sdao.getsList().length, cdao.getcList().length));
		sdao.setRank();
	}

	String setData() {
		Student[] sList = sdao.getsList();
		GradeClass[] cList = cdao.getcList();
		String data = "";
		for (int i = 0; i < cList.length; i++) {
			int[] stuNo = cList[i].getStuNo();
			data += cList[i].toString() + (i + 1) + " | 학생 - " + stuNo.length + "명 ]\n";
			data += "    [=================================================================]\n";
			data += String.format("    [ %s  |  %s  |  %s  |  %s  |  %s  |  %s ]\n", "학  번", "이  름", "생년월일", "성  별",
					"입학성적", "등수");
			data += "    [=================================================================]\n";
			for (int j = 0; j < stuNo.length; j++)
				for (int k = 0; k < sList.length; k++)
					if (stuNo[j] == sList[k].getStuNo())
						data += sList[k].toString();
			data += "    [=================================================================]\n\n";
		}
		return data;
	}

	void saveData() {
		String data = setData();
		String path = System.getProperty("user.dir");
		String packagePath = path + "\\src\\파일\\";
		String fileName = "studentInfo.txt";
		String filePath = packagePath + fileName;

		File file = new File(filePath);
		if (file.exists()) {
			System.out.println("이미 생성된 파일입니다.");
		} else {
			try (FileWriter fw = new FileWriter(file)) {
				fw.write(data);
				System.out.println(fileName + " 저장 완료");
				System.out.println("저장 경로 : " + filePath);
			} catch (Exception e) {
				System.out.println("저장 실패");
				e.printStackTrace();
			}
		}
	}

	void run() {
		joinData();
		saveData();
	}
}

public class _00연습2 {

	public static void main(String[] args) {
		// [ 학생 정보 관리 시스템 ]
		// newStudentData는 올해 신입생들의 이름과 입학 시험의 국어,영어,수학의 점수, 생년월일, 성별을 나타낸다.

		// [문제 1] 해당 데이터를 통해 신입생의 학번을 student 클래스에 생성 및 저장한다.
		// **** (학번 : 올해년도+반번호+반에서이름순서 => ex.250101 (년도 2자리, 반번호 2자리, 반에서이름순서 2자리=>(앞
		// 4자리가 같은 학생 들의 이름순서))
		// **** 반에서 이름순서를 정할 때, 남학생은 1번부터, 여학생은 31번부터 지정한다.(ex. 1~15, 31~45)

		// [문제 2] 학번 생성 시 반 배정은 각 반당 최대 30명이며, 랜덤으로 배정한다.
		// **** (만약 총 학생 수가 181명이라면, "6개반 30명 / 1개반 1명" 이 아닌 "6개반 26명 / 1개반 25명" 으로 고르게
		// 분배한다.(사람이 많은 반이 앞쪽 번호 (25명반 => 7반)

		// [문제 3] 각 학생들의 시험 점수 총 합을 구하고 등수를 student 클래스에 저장한다 (ex. 3)

		// [문제 4] 저장 시 studentInfo.txt로 동일 패키지에 저장한다
		// **** 저장 포맷은 출력예시 참고 (반 >> 학번 순)
		// **** (단, 저장 시 가장 높은 점수의 학생은 "수석", 그 다음 높은 점수의 학생은 "차석"으로 표시한다. 같은 점수가 여러명이라면
		// 모두 동일하게 표시한다)
		// **** 이미 studentInfo.txt가 있다면 "이미 생성된 파일입니다" 출력되며 새로 저장되지 않도록 설정

		// **** 클래스 간의 데이터 변경 및 불러오기는 간접접근을 이용
		// **** 각 클래스 모두 생성자 이용하여 인스턴스 생성
		// **** 기존에 주어진 멤버변수 외의 변수는 생성하지 않는다.

		String newStudentData = "채석후,54,76,90,090118,여\r\n" + "윤정련,97,1,10,091116,남\r\n" + "맹유기,32,32,44,090304,여\r\n"
				+ "채이으,48,14,68,090418,남\r\n" + "유탁충,18,98,97,091016,남\r\n" + "국실을,23,90,47,091021,남\r\n"
				+ "강재운,46,7,57,090203,남\r\n" + "연배래,72,89,21,091205,남\r\n" + "전솜배,13,32,45,091016,여\r\n"
				+ "문예전,89,31,67,090616,남\r\n" + "노호송,93,1,2,090810,남\r\n" + "진기하,39,22,34,091129,남\r\n"
				+ "차흥실,95,75,66,090825,남\r\n" + "인련배,21,72,39,090728,남\r\n" + "손량순,9,47,80,090325,남\r\n"
				+ "공현림,86,23,99,091011,여\r\n" + "지련흥,91,61,42,091006,여\r\n" + "안람덕,62,69,14,090714,여\r\n"
				+ "전남탐,63,67,73,091126,남\r\n" + "방탐명,100,87,72,090116,여\r\n" + "곽영악,4,19,18,090103,남\r\n"
				+ "조휴향,7,65,82,090701,남\r\n" + "공무디,46,32,69,091104,여\r\n" + "표린들,100,89,77,090707,여\r\n"
				+ "공율디,80,15,80,090409,여\r\n" + "허으훔,74,43,70,090103,여\r\n" + "유한화,20,64,37,090104,여\r\n"
				+ "주웅래,47,14,86,090203,여\r\n" + "한려삼,69,75,12,090303,남\r\n" + "원휘려,18,40,39,090430,남\r\n"
				+ "국율얀,53,16,48,090623,남\r\n" + "김연충,21,4,78,090402,여\r\n" + "은롱정,16,42,10,091209,여\r\n"
				+ "기서길,95,62,48,090112,여\r\n" + "전별주,47,86,19,090720,남\r\n" + "반홍순,41,40,22,090731,남\r\n"
				+ "모문광,45,14,40,090308,남\r\n" + "전우경,73,99,84,090825,남\r\n" + "문솔추,11,39,64,091220,여\r\n"
				+ "용전탁,55,94,52,090728,여\r\n" + "국옥흥,100,32,1,091231,여\r\n" + "모견탐,39,10,41,090210,남\r\n"
				+ "은권하,1,42,36,090212,여\r\n" + "오식온,66,38,59,090205,여\r\n" + "서규뜸,29,15,23,090719,남\r\n"
				+ "우운진,22,53,82,090606,남\r\n" + "옥걸길,41,54,67,091113,여\r\n" + "탁고충,42,18,33,091016,남\r\n"
				+ "남성흠,84,48,76,090317,남\r\n" + "국얀완,19,41,20,090705,남\r\n" + "엄직숭,86,69,35,091029,여\r\n"
				+ "전헌헌,9,38,90,090721,여\r\n" + "권지균,94,87,49,090626,남\r\n" + "엄울기,62,77,53,091014,남\r\n"
				+ "기선묵,50,95,24,091222,남\r\n" + "전중련,68,23,18,091123,남\r\n" + "여  온,61,4,10,090922,남\r\n"
				+ "조타창,70,38,12,090509,여\r\n" + "한공지,26,40,73,091214,여\r\n" + "연춘흥,46,69,40,090728,남\r\n"
				+ "반린창,86,16,47,090213,여\r\n" + "금전홍,6,62,94,090409,여\r\n" + "남인하,9,36,26,090817,여\r\n"
				+ "맹련반,60,56,32,090907,여\r\n" + "서학형,85,31,68,090613,남\r\n" + "최식철,27,96,74,090401,남\r\n"
				+ "노반변,14,65,31,090306,남\r\n" + "방웅수,38,51,49,090919,여\r\n" + "편부봉,24,52,70,090912,남\r\n"
				+ "남제별,34,48,92,090805,여\r\n" + "손누성,73,8,85,090425,남\r\n" + "우련천,0,96,23,090616,남\r\n"
				+ "연용랑,83,64,91,091123,여\r\n" + "전얀종,60,51,47,090225,남\r\n" + "기설담,70,22,50,090528,남\r\n"
				+ "진백태,34,17,93,091224,여\r\n" + "명치개,40,67,52,090729,남\r\n" + "전나이,40,19,54,091221,남\r\n"
				+ "남훔호,81,91,50,091116,남\r\n" + "남언도,15,25,39,090911,여\r\n" + "박모루,91,94,73,090509,여\r\n"
				+ "국송훈,14,47,73,090217,여\r\n" + "진마훈,29,12,77,091024,여\r\n" + "위섭겸,74,66,31,090102,여\r\n"
				+ "정산화,36,98,84,090903,여\r\n" + "맹나향,44,5,25,091111,남\r\n" + "지은담,11,95,74,091004,여\r\n"
				+ "어율흔,96,88,91,091223,여\r\n" + "방근로,50,82,0,090718,남\r\n" + "원두천,18,58,97,090930,여\r\n"
				+ "장초담,88,64,13,090714,여\r\n" + "표로관,85,0,35,090525,여\r\n" + "진란상,82,17,46,090227,남\r\n"
				+ "정회장,71,9,100,090716,여\r\n" + "신늘연,92,31,1,090227,여\r\n" + "조리원,98,30,42,091021,여\r\n"
				+ "고견전,83,89,54,090419,여\r\n" + "공  잔,37,8,59,090527,여\r\n" + "정흠종,14,100,65,090411,여\r\n"
				+ "전하준,3,70,44,090810,남\r\n" + "진여월,86,4,42,091202,남\r\n" + "구을실,39,18,52,090710,여\r\n"
				+ "여봉천,86,69,8,090304,남\r\n" + "명령잎,88,13,10,090406,남\r\n" + "하설안,51,25,23,090715,남\r\n"
				+ "진도실,35,98,47,090116,남\r\n" + "편구휘,38,11,71,091116,여\r\n" + "육초리,49,44,77,091021,여\r\n"
				+ "권휘강,75,46,31,090209,남\r\n" + "국회심,31,40,59,091010,여\r\n" + "박충숭,60,26,51,090923,남\r\n"
				+ "어아황,31,46,76,090508,여\r\n" + "손산택,78,69,77,090810,남\r\n" + "위치잎,71,41,2,091015,남\r\n"
				+ "권송혁,58,88,77,090520,여\r\n" + "엄무권,82,88,84,091021,남\r\n" + "우림형,95,64,22,090821,여\r\n"
				+ "우섭심,2,40,44,090107,남\r\n" + "채술경,27,52,15,090221,여\r\n" + "국혁개,47,45,2,090616,남\r\n"
				+ "류타모,78,24,85,090928,남\r\n" + "은묵천,52,84,28,091017,여\r\n" + "진비시,35,13,50,090218,여\r\n"
				+ "홍희황,28,27,20,090128,여\r\n" + "구길개,9,92,4,090619,남\r\n" + "송달구,85,24,89,090916,남\r\n"
				+ "오정분,32,20,46,091112,여\r\n" + "진롱충,69,92,97,090421,남\r\n" + "반월휘,63,85,97,090319,여\r\n"
				+ "위온래,7,52,70,090122,여\r\n" + "진달서,69,35,2,091002,남\r\n" + "기추흠,54,42,6,091121,남\r\n"
				+ "옥윤평,19,54,94,091023,남\r\n" + "채슬대,39,41,26,090724,여\r\n" + "명실춘,2,52,13,090408,남\r\n"
				+ "탁봉근,67,99,57,091102,남\r\n" + "박무라,49,12,10,091029,남\r\n" + "장휘나,36,68,59,090804,남\r\n"
				+ "탁승란,31,89,78,091121,여\r\n" + "이늬만,93,68,64,090908,남\r\n" + "정건의,23,37,38,090328,남\r\n"
				+ "안잔하,30,22,81,090226,여\r\n" + "반다강,13,33,46,090108,남\r\n" + "나얀늬,10,63,59,090412,남\r\n"
				+ "윤으식,88,12,96,090721,남\r\n" + "은  새,52,91,45,090730,남\r\n" + "어안삼,97,20,12,090123,여\r\n"
				+ "옥유한,87,25,48,091102,남\r\n" + "차무번,89,32,20,090918,남\r\n" + "금문범,57,42,77,090705,여\r\n"
				+ "전경천,36,33,80,090713,여\r\n" + "하제남,14,56,61,090325,여\r\n" + "채민송,28,35,60,090128,남\r\n"
				+ "엄양두,72,13,15,091003,남\r\n" + "용을철,2,31,6,091207,여\r\n" + "배람시,77,67,38,090918,남\r\n"
				+ "명남성,54,54,78,091106,남\r\n" + "탁량면,85,59,75,091126,남\r\n" + "천효안,17,58,36,090717,여\r\n"
				+ "송혜병,39,80,88,090607,여\r\n" + "원평들,61,52,53,090302,여\r\n" + "연려흠,74,78,58,090626,남\r\n"
				+ "임련언,79,71,4,090929,남\r\n" + "강숭직,24,41,90,090110,여\r\n" + "어얀황,47,48,10,090316,남\r\n"
				+ "남훈제,69,60,6,090207,여\r\n" + "나로휘,5,96,84,090131,여\r\n" + "방려양,33,7,6,090308,남\r\n"
				+ "연대흔,73,16,92,091025,남\r\n" + "성바면,40,76,31,091212,여\r\n" + "유준욱,79,5,75,090831,남\r\n"
				+ "왕두옥,8,56,66,091123,남\r\n" + "엄천창,97,17,2,091005,여\r\n" + "한견범,3,70,85,090702,남\r\n"
				+ "방완이,29,18,10,090225,여\r\n" + "공윤상,16,59,68,091106,남\r\n" + "민울항,98,22,23,090728,여\r\n"
				+ "연민호,6,65,73,090719,여\r\n" + "제로도,55,80,76,090406,여\r\n" + "조바한,95,31,92,091111,여\r\n"
				+ "정연실,93,77,43,090616,남\r\n" + "주악홍,47,63,7,090829,남\r\n" + "지출흠,66,62,7,090416,여\r\n"
				+ "조강개,17,18,39,091225,여\r\n" + "장미희,38,50,0,090925,남\r\n" + "제정림,56,25,40,091119,여\r\n"
				+ "조얀슬,32,91,70,091007,남\r\n" + "국창슬,50,41,76,090109,여\r\n" + "조초관,7,46,80,090625,남\r\n"
				+ "표롱령,50,64,91,090719,여\r\n" + "인이실,97,13,31,090831,남\r\n" + "심비은,83,83,10,090628,남";

		SchoolService ss = new SchoolService(newStudentData);
		ss.run();

	}

}
