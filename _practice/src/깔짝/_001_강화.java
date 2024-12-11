package 깔짝;

import java.util.Random;
import java.util.Scanner;


public class _001_강화 {
	
	public static final String RESET = "\u001B[0m";    
	public static final String FONT_GREEN = "\u001B[32m";    
	public static final String FONT_YELLOW = "\u001B[33m";     
	public static final String FONT_PURPLE = "\u001B[35m";     
	public static final String FONT_BLUE = "\u001B[34m";   
	public static final String FONT_CYAN = "\u001B[36m";     
	public static final String BACKGROUND_CYAN = "\u001B[46m";     
	public static final String BACKGROUND_GREEN = "\u001B[42m";    
	public static final String BACKGROUND_YELLOW = "\u001B[43m";     
	public static final String BACKGROUND_BLUE = "\u001B[44m";    
	public static final String BACKGROUND_PURPLE = "\u001B[45m";     
	
	public static void main(String[] args) {

		/*
		 	200제 무기 (두손검) 기준 제작
		 	힘100
		 	덱100
		 	공295
		 	보공30
		 	방무20
		 	
		 	1. 주문서 강화 
		 		(100(725),70(940),30(1125),15(1350)% (공/마1+2n,스텟n,hp 50n)
		 		순백5%(2000) / 100% 20000주흔
		 		강화횟수 (기본 최대 8 황망시9)
		 		황금망치 30%(10000) / 100% 24000주흔
		 		주흔갯수
		 	2. 스타포스 강화
		 		주문서 강화 끝나야 사용 가능 (강화 가능 횟수 0일때)
		 		1-25성
		 		성공 (성공 시 1성 상승)
		 		실패 (실패 시 1성 하락)
		 		파괴 (15성 이상부터 파괴, 파괴 시 12성으로)
		 		파괴 방지 (15,16성에서만 사용가능)
		 	3. 잠재능력 강화
		 		레어
		 		1;레100
		 		2;레20노80
		 		3;레5노95
		 		에픽 (15% / 10회)
		 		1;에100
		 		2;에20레80
		 		3;에5레95
		 		유니크 (3.5% / 42회)
		 		1;유100
		 		2;유20에80
		 		3;유5에95
		 		레전드리 (1.4% / 107회)
		 		1;레100
		 		2;레20 유80
		 		3;레5 유95
		 		쓸만한~, 피격후 무적 뜨면 그 뒤에는 제외 표기확률/(100-제외옵션 표기확률 합)
		 		피격 시 뜨면 최대 2개
		 	4. 에디셔널 잠재능력 강화
		 		레어
		 		1;레100
		 		2;레1.96078노98.03922
		 		3;레1.96078노98.03922
		 		에픽 (2.381% / 62회)
		 		1;에100
		 		2;에4.7619레95.2381
		 		3;에4.7619레95.2381
		 		유니크 (0.9804% / 152회)
		 		1;유100
		 		2;유1.96078에98.03922
		 		3;유1.96078에98.03922
		 		레전드리 (0.7% / 214회)
		 		1;레100
		 		2;레0.4975 유99.5025
		 		3;레0.4975 유99.5025
		 		쓸만한~, 피격후 무적 뜨면 그 뒤에는 제외 표기확률/(100-제외옵션 표기확률 합)
		 		피격 시 뜨면 최대 2개
		 	5. 추가옵션 강화
		 		19가지 옵션 중 무작위 1~4개 선택 (40/40/16/4)
		 		각 스탯 77 ~ 11씩 하락
		 		각 스탯 2개합 각 42 ~ 6씩 하락
		 		hp 4200~ 600씩 하락
		 		mp 4200~ 600씩 하락
		 		착감 -35 ~ -5씩 하락
		 		공 두손검 기준  182 142 108 78 54
		 		마 두손검 기준  182 142 108 78 54
		 		방어력160 ~ -20씩 하락
		 		보공 14~ 2%씩 하락
		 		뎀 7% ~ 1%씩 하락
		 		올텟 7% ~ 1%씩 하락
		 		기본 시작 옵션 25/30/30/14/1
		 		강력한 환생의 불꽃(2~5추) 20/30/36/14
		 		영원한 환생의 불꽃(1~4추) 29/45/25/1
		 		검은 환생의 불꽃 (1~4추)(변화 누르면 적용)29/45/25/1 
		 		심연의 환생의 불꽃 (1~3추)(변화 누르면 적용)63/34/3
		 	6. 소울 강화
		 		위대한 소울 (동일 확률) 공 +24 마 +24
		 		공3%
		 		마3%
		 		올텟5%
		 		최대HP2000
		 		크확12%
		 		방무7%
		 		보공7%
		 */
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		// 스타포스 성공 횟수
		int cntStar = 0;
		boolean soul = false;
		boolean jamjae = false;
		boolean jamjaeAdd = false;
		boolean hammer = false;
		boolean end = false;
		int jamjaeNum = 0;
		int jamjaeAddNum = 0;
		int pos = 0;
		int posText = 0;
		String str1 = "";
		String str2 = "";
		long calc = 0l;
		int posTotal = 0;
		// 주문서 작 횟수
		int cntPlus = 0;
		int cntMinus = 0;
		int cntAble = 8;
		int cntWhite = 0;
		int cnt100 = 0;
		int cnt70 = 0;
		int cnt30 = 0;
		int cnt15 = 0;
		long mesoJuhen = 0l;
		// 스타포스 확률
		double starUp = 00.00;
		double starDown = 0.00;
		double starBreak = 0.00;
		int cntFail = 0;
		int cntStarTry = 0;
		int cntStarDis = 0;
		long mesoStar = 0l;
		int jamjaeLev = 0;
		int jamjaeAddLev = 0; // 0:normal ~ 4:legend
		String[] jamjaesMark = { "", BACKGROUND_CYAN + "R" + RESET, BACKGROUND_PURPLE + "E" + RESET,
				BACKGROUND_YELLOW + "U" + RESET, BACKGROUND_GREEN + "L" + RESET };
		String[] jamjaesWrite = { "", FONT_CYAN + "잠재옵션" + RESET, FONT_PURPLE + "잠재옵션" + RESET,
				FONT_YELLOW + "잠재옵션" + RESET, FONT_GREEN + "잠재옵션" + RESET };
		String[] jamjaesAddWrite = { "", FONT_CYAN + "에디셔널" + RESET, FONT_PURPLE + "에디셔널" + RESET,
				FONT_YELLOW + "에디셔널" + RESET, FONT_GREEN + "에디셔널" + RESET };
		String[] jamjaes = { "", "레어 아이템", "에픽 아이템", "유니크 아이템", "레전드리 아이템" };
		// 윗잠
		int cntOpUp = 0;
		int cntToEpic = 0;
		int cntToUnique = 0;
		int cntToLegend = 0;
		int cntToEpicSet = 10;
		int cntToUniqueSet = 42;
		int cntToLegendSet = 107;
		long mesoJamjae = 0l;
		String[] jamjaeSet = { "", "", "" };
		String[] jamjaeRare = { "STR : +12", "DEX : +12", "INT : +12", "LUK : +12", "최대HP : +120", "최대MP : +120",
				"공격력 : +12", "마력 : +12", "STR : +3%", "DEX : +3%", "INT : +3%", "LUK : +3%", "공격력 : +3%", "마력 : +3%",
				"크리티컬 확률 : +4%", "데미지 : +3%", "올스텟 : +5", "20% 확률로 240의 HP 회복", "20% 확률로 120의 MP 회복",
				"10% 확률로 6레벨 중독효과 적용", "10% 확률로 2레벨 기절효과 적용", "10% 확률로 2레벨 슬로우효과 적용", "10% 확률로 3레벨 암흑효과 적용",
				"10% 확률로 2레벨 빙결효과 적용", "10% 확률로 2레벨 봉인효과 적용", "몬스터 방어율 무시 : +15%" };
		String[] jamjaeEpic = { "STR : +6%", "DEX : +6%", "INT : +6%", "LUK : +6%", "최대HP : +6%", "최대MP : +6%",
				"공격력 : +6%", "마력 : +6%", "크리티컬 확률 : +8%", "데미지 : +6%", "올스텟 : +3%", " 0% 확률로 360의 HP 회복",
				"20% 확률로 180의 MP 회복", "몬스터 방어율 무시 : +15%" };
		String[] jamjaeUnique = { "STR : +9%", "DEX : +9%", "INT : +9%", "LUK : +9%", "공격력 : +9%", "마력 : +9%",
				"크리티컬 확률 : +9%", "데미지 : +9%", "올스텟 : +6%", "몬스터 방어율 무시 : +30%", "보스 공격 시 데미지 : +30%" };
		String[] jamjaeLegend = { "STR : +12%", "DEX : +12%", "INT : +12%", "LUK : +12%", "공격력 : +12%", "마력 : +12%",
				"크리티컬 확률 : +12%", "데미지 : +12%", "올스텟 : +9%", "공격력 : +32", "마력 : +32", "몬스터 방어율 무시 : +35%",
				"몬스터 방어율 무시 : +40%", "보스 공격 시 데미지 : +35%", "보스 공격 시 데미지 : +40%" };
		// 아랫잠
		int cntOpDown = 0;
		int cntToEpicAdd = 0;
		int cntToUniqueAdd = 0;
		int cntToLegendAdd = 0;
		int cntToEpicAddSet = 62;
		int cntToUniqueAddSet = 152;
		int cntToLegendAddSet = 214;
		long mesoJamjaeAdd = 0l;
		String[] jamjaeAddSet = { "", "", "" };
		String[] jamjaeAddRare = { "최대HP : +100", "최대MP : +100", "이동속도 : +6", "점프력 : +6", "방어력 : +100", "STR : +12",
				"DEX : +12", "INT : +12", "LUK : +12", "공격력 : +12", "마력 : +12", "최대HP : +2%", "최대MP : +2%", "STR : +3%",
				"DEX : +3%", "INT : +3%", "LUK : +3%", "공격력 : +3%", "마력 : +3%", "크리티컬 확률 : +4%", "데미지 : +3%",
				"올스텟 : +5" };
		String[] jamjaeAddEpic = { "최대HP : +5%", "최대MP : +5%", "공격력 : +6%", "마력 : +6%", "크리티컬 확률 : +6%", "STR : +6%",
				"DEX : +6%", "INT : +6%", "LUK : +6%", "데미지 : +6%", "올스텟 : +3%", "3% 확률로 53의 HP 회복", "3% 확률로 53의 MP 회복",
				"몬스터 방어력 무시 : +3%" };
		String[] jamjaeAddUnique = { "최대HP : +8%", "최대MP : +8%", "공격력 : +9%", "마력 : +9%", "크리티컬 확률 : +9%", "STR : +9%",
				"DEX : +9%", "INT : +9%", "LUK : +9%", "데미지 : +9%", "올스텟 : +6%", "캐릭터 기준 9레벨 당 STR : +1",
				"캐릭터 기준 9레벨 당 DEX : +1", "캐릭터 기준 9레벨 당 INT : +1", "캐릭터 기준 9레벨 당 LUK : +1", "3% 확률로 95의 HP 회복",
				"3% 확률로 95의 MP 회복", "몬스터 방어력 무시 : +4%", "보스 공격 시 데미지 : +12%" };
		String[] jamjaeAddLegend = { "최대HP : +11%", "최대MP : +11%", "공격력 : +12%", "마력 : +12%", "크리티컬 확률 : +12%",
				"STR : +12%", "DEX : +12%", "INT : +12%", "LUK : +12%", "데미지 : +12%", "올스텟 : +9%",
				"캐릭터 기준 9레벨 당 STR : +2", "캐릭터 기준 9레벨 당 DEX : +2", "캐릭터 기준 9레벨 당 INT : +2", "캐릭터 기준 9레벨 당 LUK : +2",
				"공격력 : +32", "마력 : +32", "몬스터 방어력 무시 : +5%", "보스 공격 시 데미지 : +18%" };
		// 추옵
		int cntAdd = 0;
		long mesoAdd = 0l;
		boolean isChange = false;
		int[] levAdd = { 35, 30, 25, 20, 15 };
		int[] strAdd = { 77, 66, 55, 44, 33 };
		int[] dexAdd = { 77, 66, 55, 44, 33 };
		int[] IntAdd = { 77, 66, 55, 44, 33 };
		int[] lukAdd = { 77, 66, 55, 44, 33 };
		int[] strDexAdd = { 42, 36, 30, 24, 18 };
		int[] dexIntAdd = { 42, 36, 30, 24, 18 };
		int[] IntLukAdd = { 42, 36, 30, 24, 18 };
		int[] lukStrAdd = { 42, 36, 30, 24, 18 };
		int[] strIntAdd = { 42, 36, 30, 24, 18 };
		int[] dexLukAdd = { 42, 36, 30, 24, 18 };
		int[] hpAdd = { 4200, 3600, 3000, 2400, 1800 };
		int[] mpAdd = { 4200, 3600, 3000, 2400, 1800 };
		int[] defAdd = { 160, 140, 120, 100, 80 };
		int[] powerAdd = { 182, 142, 108, 78, 54 };
		int[] magicPowerAdd = { 182, 142, 108, 78, 54 };
		int[] bossDmgAdd = { 14, 12, 10, 8, 6 };
		int[] dmgAdd = { 7, 6, 5, 4, 3 };
		int[] allStaAdd = { 7, 6, 5, 4, 3 };
		// 소울
		String soulName = "";
		int soulNameCnt = 0;
		String soulOption = "";
		int soulOpCnt = 0;
		int cntSoul = 0;
		long mesoSoul = 0l;
		long mesoTotal = 0l;
		// 장비 옵션 (총합 / 기본 / 추옵 / 주문서 / 스타포스)
		int[] lev = new int[3];
		int[] str = new int[5];
		int[] dex = new int[5];
		int[] Int = new int[5];
		int[] luk = new int[5];
		int[] hp = new int[5];
		int[] mp = new int[5];
		int[] def = new int[5];
		int[] power = new int[5];
		int[] magicPower = new int[5];
		int[] bossDmg = new int[3];
		int defBreak = 20;
		int[] dmg = new int[3];
		int[] allSta = new int[3];
		int cntCol = 0;
		// 기본 값 셋팅
		lev[1] = 200;
		str[1] = dex[1] = 100;
		power[1] = 295;
		bossDmg[1] = 30;
		for (int i = 1; i < lev.length; i++) {
			lev[0] += i == 1 ? lev[i] : -lev[i];
		}
		for (int i = 1; i < str.length; i++) {
			str[0] += str[i];
		}
		for (int i = 1; i < dex.length; i++) {
			dex[0] += dex[i];
		}
		for (int i = 1; i < Int.length; i++) {
			Int[0] += Int[i];
		}
		for (int i = 1; i < luk.length; i++) {
			luk[0] += luk[i];
		}
		for (int i = 1; i < hp.length; i++) {
			hp[0] += hp[i];
		}
		for (int i = 1; i < mp.length; i++) {
			mp[0] += mp[i];
		}
		for (int i = 1; i < def.length; i++) {
			def[0] += def[i];
		}
		for (int i = 1; i < power.length; i++) {
			power[0] += power[i];
		}
		for (int i = 1; i < magicPower.length; i++) {
			magicPower[0] += magicPower[i];
		}
		for (int i = 1; i < bossDmg.length; i++) {
			bossDmg[0] += bossDmg[i];
		}
		for (int i = 1; i < dmg.length; i++) {
			dmg[0] += dmg[i];
		}
		for (int i = 1; i < allSta.length; i++) {
			allSta[0] += allSta[i];
		}
		while (true) {
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.print("┃          ");
			for (int i = 0; i < 25; i++) {
				System.out.print(i < cntStar ? FONT_YELLOW + "★" : RESET + "☆");
				if (i % 5 == 4 && i != 14) {
					System.out.print(" ");
				}
				if (i == 14) {
					System.out.println(RESET + "           ┃");
					System.out.print("┃             ");
				}
			}
			System.out.println("             ┃");
			if (soul) {
				System.out.print("┃ ");
				for (int i = 1; i < 18 - (soulNameCnt + 2) / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(soulName);
				System.out.print("의");
				for (int i = 18 + (soulNameCnt + 2) / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
			}
			if (cntPlus == 0) {
				System.out.print("┃        ");
				System.out.print("    짱짱 쎈 삼지창");
				System.out.println("            ┃");
			} else {
				System.out.print("┃        ");
				System.out.print("  짱짱 쎈 삼지창");
				System.out.print("(+" + cntPlus + ")");
				System.out.println("          ┃");
			}
			if (jamjae) {
				if (jamjaeNum == 1) {
					System.out.print("┃             ");
					System.out.print(jamjaes[jamjaeNum]);
					System.out.println("            ┃");
				} else if (jamjaeNum == 2) {
					System.out.print("┃             ");
					System.out.print(jamjaes[jamjaeNum]);
					System.out.println("            ┃");
				} else if (jamjaeNum == 3) {
					System.out.print("┃            ");
					System.out.print(jamjaes[jamjaeNum]);
					System.out.println("           ┃");
				} else if (jamjaeNum == 4) {
					System.out.print("┃           ");
					System.out.print(jamjaes[jamjaeNum]);
					System.out.println("          ┃");
				}
			}
			System.out.print("┃ ");
			System.out.print("┌──────────┐");
			System.out.println("                         ┃");
			System.out.print("┃ ");
			System.out.print("│ ");
			System.out.print("      ／");
			System.out.print(" │");
			System.out.println("                         ┃");
			System.out.print("┃ ");
			System.out.print("│ ");
			System.out.print("    ／  ");
			System.out.print(" │");
			System.out.println("                         ┃");
			System.out.print("┃ ");
			System.out.print("│ ");
			System.out.print("／＼    ");
			System.out.print(" │");
			System.out.println("                         ┃");
			System.out.print("┃ ");
			System.out.print("│ ");
			System.out.print("／／    ");
			System.out.print(" │");
			System.out.printf(" REQ LEV: %d", lev[0]);
			cntCol = 0;
			for (int i = 2; i < lev.length; i++) {
				if (lev[i] != 0) {
					System.out.print(" (" + lev[1] + "-" + lev[i]);
					cntCol++;
				}
			}
			if (cntCol != 0) {
				System.out.print(")");
			}
			System.out.println(cntCol != 0 ? "   ┃" : "            ┃");
			System.out.print("┃ ");
			System.out.print("└──────────┘");
			System.out.println("                         ┃");
			System.out.println("┃ ------------------------------------ ┃");
			System.out.print("┃ ");
			System.out.print("무기분류 : 창 (두손무기)");
			System.out.println("             ┃");
			System.out.print("┃ ");
			System.out.print("공격속도 : 보통 (4단계)");
			System.out.println("              ┃");
			// STR
			System.out.print("┃ ");
			String temp = "";
			int tempCnt = 0;
			temp += str[2] != 0 || str[3] != 0 || str[4] != 0 ? FONT_CYAN + "STR : +" + str[0] + RESET
					: "STR : +" + str[0];
			tempCnt += 9;
			tempCnt += str[0] / 1000 != 0 ? 4 : str[0] / 100 != 0 ? 3 : str[0] / 10 != 0 ? 2 : 1;
			cntCol = 0;
			for (int i = 2; i < str.length; i++) {
				if (str[i] != 0) {
					temp += cntCol == 0 ? " (" + str[1] + "+" : "+";
					tempCnt += cntCol == 0 ? 3 : 1;
					temp += i == 2 ? FONT_GREEN + str[i] + RESET
							: i == 3 ? FONT_YELLOW + str[i] + RESET : FONT_CYAN + str[i] + RESET;
					tempCnt += str[i] / 1000 != 0 ? 4 : str[i] / 100 != 0 ? 3 : str[i] / 10 != 0 ? 2 : 1;
					cntCol++;
				}
			}
			if (cntCol != 0) {
				temp += ")";
				tempCnt += 4;
			}
			System.out.print(temp);
			for (int i = 0; i < 39 - tempCnt; i++) {
				System.out.print(" ");
			}
			System.out.println("┃");
			// DEX
			System.out.print("┃ ");
			temp = "";
			tempCnt = 0;
			temp += dex[2] != 0 || dex[3] != 0 || dex[4] != 0 ? FONT_CYAN + "DEX : +" + dex[0] + RESET
					: "DEX : +" + dex[0];
			tempCnt += 9;
			tempCnt += dex[0] / 1000 != 0 ? 4 : dex[0] / 100 != 0 ? 3 : dex[0] / 10 != 0 ? 2 : 1;
			cntCol = 0;
			for (int i = 2; i < dex.length; i++) {
				if (dex[i] != 0) {
					temp += cntCol == 0 ? " (" + dex[1] + "+" : "+";
					tempCnt += cntCol == 0 ? 3 : 1;
					temp += i == 2 ? FONT_GREEN + dex[i] + RESET
							: i == 3 ? FONT_YELLOW + dex[i] + RESET : FONT_CYAN + dex[i] + RESET;
					tempCnt += dex[i] / 1000 != 0 ? 4 : dex[i] / 100 != 0 ? 3 : dex[i] / 10 != 0 ? 2 : 1;
					cntCol++;
				}
			}
			if (cntCol != 0) {
				temp += ")";
				tempCnt += 4;
			}
			System.out.print(temp);
			for (int i = 0; i < 39 - tempCnt; i++) {
				System.out.print(" ");
			}
			System.out.println("┃");
			// INT
			if (Int[0] != 0) {
				System.out.print("┃ ");
				temp = "";
				tempCnt = 0;
				temp += Int[2] != 0 || Int[3] != 0 || Int[4] != 0 ? FONT_CYAN + "INT : +" + Int[0] + RESET
						: "INT : +" + Int[0];
				tempCnt += 9;
				tempCnt += Int[0] / 1000 != 0 ? 4 : Int[0] / 100 != 0 ? 3 : Int[0] / 10 != 0 ? 2 : 1;
				cntCol = 0;
				for (int i = 2; i < Int.length; i++) {
					if (Int[i] != 0) {
						temp += cntCol == 0 ? " (" + Int[1] + "+" : "+";
						tempCnt += cntCol == 0 ? 3 : 1;
						temp += i == 2 ? FONT_GREEN + Int[i] + RESET
								: i == 3 ? FONT_YELLOW + Int[i] + RESET : FONT_CYAN + Int[i] + RESET;
						tempCnt += Int[i] / 1000 != 0 ? 4 : Int[i] / 100 != 0 ? 3 : Int[i] / 10 != 0 ? 2 : 1;
						cntCol++;
					}
				}
				if (cntCol != 0) {
					temp += ")";
					tempCnt += 2;
				}
				System.out.print(temp);
				for (int i = 0; i < 39 - tempCnt; i++) {
					System.out.print(" ");
				}
				System.out.println("┃");
			}
			// luk
			if (luk[0] != 0) {
				System.out.print("┃ ");
				temp = "";
				tempCnt = 0;
				temp += luk[2] != 0 || luk[3] != 0 || luk[4] != 0 ? FONT_CYAN + "LUK : +" + luk[0] + RESET
						: "LUK : +" + luk[0];
				tempCnt += 9;
				tempCnt += luk[0] / 1000 != 0 ? 4 : luk[0] / 100 != 0 ? 3 : luk[0] / 10 != 0 ? 2 : 1;
				cntCol = 0;
				for (int i = 2; i < luk.length; i++) {
					if (luk[i] != 0) {
						temp += cntCol == 0 ? " (" + luk[1] + "+" : "+";
						tempCnt += cntCol == 0 ? 3 : 1;
						temp += i == 2 ? FONT_GREEN + luk[i] + RESET
								: i == 3 ? FONT_YELLOW + luk[i] + RESET : FONT_CYAN + luk[i] + RESET;
						tempCnt += luk[i] / 1000 != 0 ? 4 : luk[i] / 100 != 0 ? 3 : luk[i] / 10 != 0 ? 2 : 1;
						cntCol++;
					}
				}
				if (cntCol != 0) {
					temp += ")";
					tempCnt += 2;
				}
				System.out.print(temp);
				for (int i = 0; i < 39 - tempCnt; i++) {
					System.out.print(" ");
				}
				System.out.println("┃");
			}
			// hp
			if (hp[0] != 0) {
				System.out.print("┃ ");
				temp = "";
				tempCnt = 0;
				temp += hp[2] != 0 || hp[3] != 0 || hp[4] != 0 ? FONT_CYAN + "HP : +" + hp[0] + RESET
						: "HP : +" + hp[0];
				tempCnt += 8;
				tempCnt += hp[0] / 1000 != 0 ? 4 : hp[0] / 100 != 0 ? 3 : hp[0] / 10 != 0 ? 2 : 1;
				cntCol = 0;
				for (int i = 2; i < hp.length; i++) {
					if (hp[i] != 0) {
						temp += cntCol == 0 ? " (" + hp[1] + "+" : "+";
						tempCnt += cntCol == 0 ? 3 : 1;
						temp += i == 2 ? FONT_GREEN + hp[i] + RESET
								: i == 3 ? FONT_YELLOW + hp[i] + RESET : FONT_CYAN + hp[i] + RESET;
						tempCnt += hp[i] / 1000 != 0 ? 4 : hp[i] / 100 != 0 ? 3 : hp[i] / 10 != 0 ? 2 : 1;
						cntCol++;
					}
				}
				if (cntCol != 0) {
					temp += ")";
					tempCnt += 2;
				}
				System.out.print(temp);
				for (int i = 0; i < 39 - tempCnt; i++) {
					System.out.print(" ");
				}
				System.out.println("┃");
			}
			// np
			if (mp[0] != 0) {
				System.out.print("┃ ");
				temp = "";
				tempCnt = 0;
				temp += mp[2] != 0 || mp[3] != 0 || mp[4] != 0 ? FONT_CYAN + "MP : +" + mp[0] + RESET
						: "MP : +" + mp[0];
				tempCnt += 8;
				tempCnt += mp[0] / 1000 != 0 ? 4 : mp[0] / 100 != 0 ? 3 : mp[0] / 10 != 0 ? 2 : 1;
				cntCol = 0;
				for (int i = 2; i < mp.length; i++) {
					if (mp[i] != 0) {
						temp += cntCol == 0 ? " (" + mp[1] + "+" : "+";
						tempCnt += cntCol == 0 ? 3 : 1;
						temp += i == 2 ? FONT_GREEN + mp[i] + RESET
								: i == 3 ? FONT_YELLOW + mp[i] + RESET : FONT_CYAN + mp[i] + RESET;
						tempCnt += mp[i] / 1000 != 0 ? 4 : mp[i] / 100 != 0 ? 3 : mp[i] / 10 != 0 ? 2 : 1;
						cntCol++;
					}
				}
				if (cntCol != 0) {
					temp += ")";
					tempCnt += 2;
				}
				System.out.print(temp);
				for (int i = 0; i < 39 - tempCnt; i++) {
					System.out.print(" ");
				}
				System.out.println("┃");
			}
			// def
			if (def[0] != 0) {
				System.out.print("┃ ");
				temp = "";
				tempCnt = 0;
				temp += def[2] != 0 || def[3] != 0 || def[4] != 0 ? FONT_CYAN + "방어력 : +" + def[0] + RESET
						: "방어력 : +" + def[0];
				tempCnt += 12;
				tempCnt += def[0] / 1000 != 0 ? 4 : def[0] / 100 != 0 ? 3 : def[0] / 10 != 0 ? 2 : 1;
				cntCol = 0;
				for (int i = 2; i < def.length; i++) {
					if (def[i] != 0) {
						temp += cntCol == 0 ? " (" + def[1] + "+" : "+";
						tempCnt += cntCol == 0 ? 3 : 1;
						temp += i == 2 ? FONT_GREEN + def[i] + RESET
								: i == 3 ? FONT_YELLOW + def[i] + RESET : FONT_CYAN + def[i] + RESET;
						tempCnt += def[i] / 1000 != 0 ? 4 : def[i] / 100 != 0 ? 3 : def[i] / 10 != 0 ? 2 : 1;
						cntCol++;
					}
				}
				if (cntCol != 0) {
					temp += ")";
					tempCnt += 2;
				}
				System.out.print(temp);
				for (int i = 0; i < 39 - tempCnt; i++) {
					System.out.print(" ");
				}
				System.out.println("┃");
			}
			// 공격력
			System.out.print("┃ ");
			temp = "";
			tempCnt = 0;
			temp += power[2] != 0 || power[3] != 0 || power[4] != 0 ? FONT_CYAN + "공격력 : +" + power[0] + RESET
					: "공격력 : +" + power[0];
			tempCnt += 12;
			tempCnt += power[0] / 1000 != 0 ? 4 : power[0] / 100 != 0 ? 3 : power[0] / 10 != 0 ? 2 : 1;
			cntCol = 0;
			for (int i = 2; i < power.length; i++) {
				if (power[i] != 0) {
					temp += cntCol == 0 ? " (" + power[1] + "+" : "+";
					tempCnt += cntCol == 0 ? 3 : 1;
					temp += i == 2 ? FONT_GREEN + power[i] + RESET
							: i == 3 ? FONT_YELLOW + power[i] + RESET : FONT_CYAN + power[i] + RESET;
					tempCnt += power[i] / 1000 != 0 ? 4 : power[i] / 100 != 0 ? 3 : power[i] / 10 != 0 ? 2 : 1;
					cntCol++;
				}
			}
			if (cntCol != 0) {
				temp += ")";
				tempCnt += 4;
			}
			System.out.print(temp);
			for (int i = 0; i < 39 - tempCnt; i++) {
				System.out.print(" ");
			}
			System.out.println("┃");
			// 마력
			if (magicPower[0] != 0) {
				System.out.print("┃ ");
				temp = "";
				tempCnt = 0;
				temp += magicPower[2] != 0 || magicPower[3] != 0 || magicPower[4] != 0
						? FONT_CYAN + "마력 : +" + magicPower[0] + RESET
						: "마력 : +" + magicPower[0];
				tempCnt += 10;
				tempCnt += magicPower[0] / 1000 != 0 ? 4
						: magicPower[0] / 100 != 0 ? 3 : magicPower[0] / 10 != 0 ? 2 : 1;
				cntCol = 0;
				for (int i = 2; i < magicPower.length; i++) {
					if (magicPower[i] != 0) {
						temp += cntCol == 0 ? " (" + magicPower[1] + "+" : "+";
						tempCnt += cntCol == 0 ? 3 : 1;
						temp += i == 2 ? FONT_GREEN + magicPower[i] + RESET
								: i == 3 ? FONT_YELLOW + magicPower[i] + RESET : FONT_CYAN + magicPower[i] + RESET;
						tempCnt += magicPower[i] / 1000 != 0 ? 4
								: magicPower[i] / 100 != 0 ? 3 : magicPower[i] / 10 != 0 ? 2 : 1;
						cntCol++;
					}
				}
				if (cntCol != 0) {
					temp += ")";
					tempCnt += 2;
				}
				System.out.print(temp);
				for (int i = 0; i < 39 - tempCnt; i++) {
					System.out.print(" ");
				}
				System.out.println("┃");
			}
			// 보공
			System.out.print("┃ ");
			temp = "";
			tempCnt = 0;
			temp += bossDmg[2] != 0 ? FONT_CYAN + "보스 공격 시 데미지 : +" + bossDmg[0] + "%" + RESET
					: "보스 공격 시 데미지 : +" + bossDmg[0] + "%";
			tempCnt += 28;
			cntCol = 0;
			for (int i = 2; i < bossDmg.length; i++) {
				if (bossDmg[i] != 0) {
					temp += cntCol == 0 ? " (" + bossDmg[1] + "%" + "+" : "+";
					tempCnt += cntCol == 0 ? 5 : 1;
					temp += FONT_GREEN + bossDmg[i] + "%" + RESET;
					tempCnt += bossDmg[i] / 10 != 0 ? 2 : 1;
					cntCol++;
				}
			}
			if (cntCol != 0) {
				temp += ")";
				tempCnt += 3;
			}
			System.out.print(temp);
			for (int i = 0; i < 39 - tempCnt; i++) {
				System.out.print(" ");
			}
			System.out.println("┃");
			// 방무
			System.out.print("┃ ");
			System.out.print("몬스터 방어율 무시 : " + defBreak + "%");
			System.out.println("             ┃");
			// 데미지
			if (dmg[0] != 0) {
				System.out.print("┃ ");
				temp = "";
				tempCnt = 0;
				temp += FONT_CYAN + "데미지 : +" + dmg[0] + "%" + RESET;
				tempCnt += 14;
				tempCnt += 1;
				cntCol = 0;
				if (dmg[2] != 0) {
					temp += cntCol == 0 ? " (" + dmg[1] + "%" + "+" : "+";
					tempCnt += cntCol == 0 ? 5 : 1;
					temp += FONT_GREEN + dmg[2] + "%" + RESET;
					tempCnt += 3;
					cntCol++;
				}
				if (cntCol != 0) {
					temp += ")";
					tempCnt += 2;
				}
				System.out.print(temp);
				for (int i = 0; i < 39 - tempCnt; i++) {
					System.out.print(" ");
				}
				System.out.println("   ┃");
			}
			// allSta
			if (allSta[0] != 0) {
				System.out.print("┃ ");
				temp = "";
				tempCnt = 0;
				temp += FONT_CYAN + "올스텟 : +" + allSta[0] + "%" + RESET;
				tempCnt += 14;
				tempCnt += 1;
				cntCol = 0;
				for (int i = 2; i < allSta.length; i++) {
					if (allSta[i] != 0) {
						temp += cntCol == 0 ? " (" + allSta[1] + "%" + "+" : "+";
						tempCnt += cntCol == 0 ? 5 : 1;
						temp += FONT_GREEN + allSta[i] + "%" + RESET;
						tempCnt += 3;
						cntCol++;
					}
				}
				if (cntCol != 0) {
					temp += ")";
					tempCnt += 2;
				}
				System.out.print(temp);
				for (int i = 0; i < 39 - tempCnt; i++) {
					System.out.print(" ");
				}
				System.out.println("   ┃");
			}
			// 업글횟수
			System.out.print("┃ ");
			System.out.print("업그레이드 가능 횟수 : " + cntAble + FONT_YELLOW + " (복구 : " + cntMinus + ")" + RESET);
			System.out.println("  ┃");
			// 황망제련
			if (hammer) {
				System.out.print("┃ ");
				System.out.print("황금망치 제련 적용");
				System.out.println("                   ┃");
			}
			// 윗잠
			if (jamjae) {
				System.out.println("┃ ------------------------------------ ┃");
				System.out.print("┃ ");
				System.out.print(jamjaesMark[jamjaeLev] + jamjaesWrite[jamjaeLev]);
				System.out.println("                            ┃");
				System.out.print("┃ ");
				System.out.print(jamjaeSet[0]);
				posTotal = (jamjaeSet[0].length() + jamjaeSet[0].getBytes().length) / 2;
				for (int i = posTotal; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
				System.out.print("┃ ");
				System.out.print(jamjaeSet[1]);
				posTotal = (jamjaeSet[1].length() + jamjaeSet[1].getBytes().length) / 2;
				for (int i = posTotal; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
				System.out.print("┃ ");
				System.out.print(jamjaeSet[2]);
				posTotal = (jamjaeSet[2].length() + jamjaeSet[2].getBytes().length) / 2;
				for (int i = posTotal; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
			}
			// 아랫잠
			if (jamjaeAdd) {
				System.out.println("┃ ------------------------------------ ┃");
				System.out.print("┃ ");
				System.out.print(
						jamjaesMark[jamjaeAddLev] + jamjaesAddWrite[jamjaeAddLev] + " " + jamjaesWrite[jamjaeAddLev]);
				System.out.println("                   ┃");
				System.out.print("┃ ");
				System.out.print(jamjaeAddSet[0]);
				posTotal = (jamjaeAddSet[0].length() + jamjaeAddSet[0].getBytes().length) / 2;
				for (int i = posTotal; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
				System.out.print("┃ ");
				System.out.print(jamjaeAddSet[1]);
				posTotal = (jamjaeAddSet[1].length() + jamjaeAddSet[1].getBytes().length) / 2;
				for (int i = posTotal; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
				System.out.print("┃ ");
				System.out.print(jamjaeAddSet[2]);
				posTotal = (jamjaeAddSet[2].length() + jamjaeAddSet[2].getBytes().length) / 2;
				for (int i = posTotal; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
			}
			// 소울
			if (soul) {
				System.out.println("┃ ------------------------------------ ┃");
				System.out.print("┃ ");
				System.out.print(FONT_YELLOW + soulName);
				System.out.print("의 소울 적용" + RESET);
				for (int i = soulNameCnt + 12; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
				System.out.print("┃ ");
				System.out.print("공 : +24, 마 : +24");
				for (int i = 18; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
				System.out.print("┃ ");
				System.out.print(soulOption);
				for (int i = soulOpCnt; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
			}
			System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┨");
			if (end) {
				System.out.println("강화 종료");
				break;
			}
		
			System.out.print("┃ ");
			System.out.print("┌─────┬────────────────────────────┐");
			System.out.println(" ┃");
			System.out.print("┃ ");
			System.out.print("│  1  │     주문의 흔적 강화       │");
			System.out.println(" ┃");
			System.out.print("┃ ");
			System.out.print("├─────┼────────────────────────────┤");
			System.out.println(" ┃");
			System.out.print("┃ ");
			System.out.print("│  2  │      스타포스 강화         │");
			System.out.println(" ┃");
			System.out.print("┃ ");
			System.out.print("├─────┼────────────────────────────┤");
			System.out.println(" ┃");
			System.out.print("┃ ");
			System.out.print("│  3  │      잠재능력 강화         │");
			System.out.println(" ┃");
			System.out.print("┃ ");
			System.out.print("├─────┼────────────────────────────┤");
			System.out.println(" ┃");
			System.out.print("┃ ");
			System.out.print("│  4  │   에디셔널 잠재능력 강화   │");
			System.out.println(" ┃");
			System.out.print("┃ ");
			System.out.print("├─────┼────────────────────────────┤");
			System.out.println(" ┃");
			System.out.print("┃ ");
			System.out.print("│  5  │      추가옵션 강화         │");
			System.out.println(" ┃");
			System.out.print("┃ ");
			System.out.print("├─────┼────────────────────────────┤");
			System.out.println(" ┃");
			System.out.print("┃ ");
			System.out.print("│  6  │        소울 강화           │");
			System.out.println(" ┃");
			System.out.print("┃ ");
			System.out.print("├─────┼────────────────────────────┤");
			System.out.println(" ┃");
			System.out.print("┃ ");
			System.out.print("│  7  │     현재 사용 재화 조회    │");
			System.out.println(" ┃");
			System.out.print("┃ ");
			System.out.print("└─────┴────────────────────────────┘");
			System.out.println(" ┃");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.print("메뉴 선택 (0. 종료) >> ");
			int sel = sc.nextInt();
			System.out.println();
			System.out.println();
			if (sel < 0 || sel > 7) {
				System.out.println("선택 오류");
				continue;
			}
			if (sel == 0) {
				end = true;
				continue;
			}
			if (sel == 1) {
				if (cntAble == 0 && cntMinus == 0 && hammer) {
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
					System.out.print("┃ ");
					System.out.print("  업그레이드 가능 횟수가 없습니다.  ");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("                                    ");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("              1. 확인               ");
					System.out.println(" ┃");
					System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
					System.out.print("1. 확인 >> ");
					int check = sc.nextInt();
					System.out.println();
					continue;
				}
				while (true) {
					if (cntAble == 0 && cntMinus == 0 && hammer) {
						System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
						System.out.print("┃ ");
						System.out.print("  업그레이드 가능 횟수가 없습니다.  ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("                                    ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("              1. 확인               ");
						System.out.println(" ┃");
						System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
						System.out.print("1. 확인 >> ");
						int check = sc.nextInt();
						System.out.println();
						break;
					}
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
					System.out.print("┃ ");
					System.out.print("┌──────────────────────────────────┐");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│         주문의 흔적 강화         │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("└──────────────────────────────────┘");
					System.out.println(" ┃");
					System.out.print("┃             ");
					System.out.print("┌──────────┐");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("      ／");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("    ／  ");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("／＼    ");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("／／    ");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("└──────────┘");
					System.out.println("             ┃");
					System.out.print("┃ ");
					System.out.print("┌─────┬────────────────────────────┐");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│  1  │      무기 공격력 100%      │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├─────┼────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│  2  │      무기 공격력 70%       │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├─────┼────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│  3  │      무기 공격력 30%       │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├─────┼────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│  4  │      무기 공격력 15%       │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├─────┼────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│  5  │      순백의 주문서 10%     │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├─────┼────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│  6  │      황금 망치 30%         │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("└─────┴────────────────────────────┘");
					System.out.println(" ┃");
					System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
					System.out.print("주문서 선택 (0. 종료) >> ");
					int scroll = sc.nextInt();
					System.out.println();
					if (scroll == 0) {
						System.out.println("주문의 흔적 강화 종료");
						break;
					}
					if (scroll < 0 || scroll > 6) {
						System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
						System.out.print("┃ ");
						System.out.print("             입력 오류              ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("                                    ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("              1. 확인               ");
						System.out.println(" ┃");
						System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
						System.out.print("확인 >> ");
						int check = sc.nextInt();
						System.out.println();
						continue;
					}
					if (cntMinus == 0 && scroll == 5) {
						System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
						System.out.print("┃ ");
						System.out.print("  업그레이드 실패 횟수가 없습니다   ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("                                    ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("              1. 확인               ");
						System.out.println(" ┃");
						System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
						System.out.print("1. 확인 >> ");
						int check = sc.nextInt();
						System.out.println();
						continue;
					}
					if (hammer && scroll == 6) {
						System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
						System.out.print("┃ ");
						System.out.print(" 이미 황금 망치가 적용되어 있습니다 ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("                                    ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("              1. 확인               ");
						System.out.println(" ┃");
						System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
						System.out.print("1. 확인 >> ");
						int check = sc.nextInt();
						System.out.println();
						continue;
					}
					if (cntAble == 0 && (scroll != 6 && scroll != 5)) {
						System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
						System.out.print("┃ ");
						System.out.print("  업그레이드 가능 횟수가 없습니다   ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("                                    ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("              1. 확인               ");
						System.out.println(" ┃");
						System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
						System.out.print("1. 확인 >> ");
						int check = sc.nextInt();
						System.out.println();
						continue;
					}

					if (scroll == 1) {
						System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
						System.out.print("┃ ");
						System.out.print("             강화 성공 !            ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("------------------------------------");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("                                    ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("              STR  +1               ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("             공격력  +3             ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("                                    ");
						System.out.println(" ┃");
						System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
						str[0] -= str[3];
						power[0] -= power[3];
						str[3] += 1;
						power[3] += 3;
						str[0] += str[3];
						power[0] += power[3];
						mesoJuhen += 200000;
						cntPlus++;
						cntAble--;
						cnt100++;
						System.out.print("확인 >> ");
						int check = sc.nextInt();
						System.out.println();
						continue;
					} else if (scroll == 2) {
						int rdNum = rd.nextInt(1000000);
						int per = 0;
						if (rdNum % 10 < 7) {
							per = 1;
						} else {
							per = 2;
						}
						if (per == 1) {
							System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
							System.out.print("┃ ");
							System.out.print("             강화 성공 !            ");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("------------------------------------");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("                                    ");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("              STR  +2               ");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("             공격력  +5             ");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("                                    ");
							System.out.println(" ┃");
							System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
							str[0] -= str[3];
							power[0] -= power[3];
							str[3] += 2;
							power[3] += 5;
							str[0] += str[3];
							power[0] += power[3];
							cntPlus++;
						} else {
							System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
							System.out.print("┃ ");
							System.out.print("             강화 실패 !            ");
							System.out.println(" ┃");
							System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
							cntMinus++;
						}
						mesoJuhen += 500000;
						cntAble--;
						cnt70++;
						System.out.print("확인 >> ");
						int check = sc.nextInt();
						System.out.println();
						continue;
					} else if (scroll == 3) {
						int rdNum = rd.nextInt(1000000);
						int per = 0;
						if (rdNum % 10 < 3) {
							per = 1;
						} else {
							per = 2;
						}
						if (per == 1) {
							System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
							System.out.print("┃ ");
							System.out.print("             강화 성공 !            ");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("------------------------------------");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("                                    ");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("              STR  +3               ");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("             공격력  +7             ");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("                                    ");
							System.out.println(" ┃");
							System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
							str[0] -= str[3];
							power[0] -= power[3];
							str[3] += 3;
							power[3] += 7;
							str[0] += str[3];
							power[0] += power[3];
							cntPlus++;

						} else {
							System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
							System.out.print("┃ ");
							System.out.print("             강화 실패 !            ");
							System.out.println(" ┃");
							System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
							cntMinus++;
						}
						mesoJuhen += 700000;
						cntAble--;
						cnt30++;
						System.out.print("확인 >> ");
						int check = sc.nextInt();
						System.out.println();
						continue;
					} else if (scroll == 4) {
						int rdNum = rd.nextInt(1000000);
						int per = 0;
						if (rdNum % 100 < 15) {
							per = 1;
						} else {
							per = 2;
						}
						if (per == 1) {
							System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
							System.out.print("┃ ");
							System.out.print("             강화 성공 !            ");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("------------------------------------");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("                                    ");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("              STR  +4               ");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("             공격력  +9             ");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("                                    ");
							System.out.println(" ┃");
							System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
							str[0] -= str[3];
							power[0] -= power[3];
							str[3] += 4;
							power[3] += 9;
							str[0] += str[3];
							power[0] += power[3];
							cntPlus++;
						} else {
							System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
							System.out.print("┃ ");
							System.out.print("             강화 실패 !            ");
							System.out.println(" ┃");
							System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
							System.out.println();
							cntMinus++;
						}
						mesoJuhen += 1000000;
						cntAble--;
						cnt15++;
						System.out.print("확인 >> ");
						int check = sc.nextInt();
						System.out.println();
						continue;
					} else if (scroll == 5) {
						int rdNum = rd.nextInt(1000000);
						int per = 0;
						if (rdNum % 10 < 1) {
							per = 1;
						} else {
							per = 2;
						}
						if (per == 1) {
							System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
							System.out.print("┃ ");
							System.out.print("             강화 성공 !            ");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("------------------------------------");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("                                    ");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("       업그레이드 가능 횟수 +1       ");
							System.out.print("┃ ");
							System.out.print("                                    ");
							System.out.println(" ┃");
							System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
							cntMinus--;
							cntAble++;
						} else {
							System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
							System.out.print("┃ ");
							System.out.print("             강화 실패 !            ");
							System.out.println(" ┃");
							System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
							System.out.println("\n\n");
						}
						cntWhite++;
						mesoJuhen += 5000000;
						System.out.print("확인 >> ");
						int check = sc.nextInt();
						System.out.println();
						continue;
					} else if (scroll == 6) {
						int rdNum = rd.nextInt(1000000);
						int per = 0;
						if (rdNum % 10 < 3) {
							per = 1;
						} else {
							per = 2;
						}
						if (per == 1) {
							System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
							System.out.print("┃ ");
							System.out.print("             강화 성공 !            ");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("------------------------------------");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("                                    ");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("       업그레이드 가능 횟수 +1       ");
							System.out.print("┃ ");
							System.out.print("                                    ");
							System.out.println(" ┃");
							System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
							cntAble++;

						} else {
							System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
							System.out.print("┃ ");
							System.out.print("             강화 실패 !            ");
							System.out.println(" ┃");
							System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
							System.out.println("\n\n");
							cntMinus++;
						}
						mesoJuhen += 20000000;
						hammer = true;
						System.out.print("확인 >> ");
						int check = sc.nextInt();
						System.out.println();
						continue;
					}

				}
			} else if (sel == 2) {
				if (cntAble != 0) {
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
					System.out.print("┃ ");
					System.out.print("주문의 흔적 강화 완료 후 가능합니다 ");
					System.out.println(" ┃");
					System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
					System.out.println("\n\n");
					System.out.print("확인 >> ");
					int check = sc.nextInt();
					System.out.println();
					continue;
				}
				while (true) {
					int per = 0;
					if (cntStar < 15) {
						int rdNum = rd.nextInt(1000000);
						if (rdNum % 20 < (cntStar + 1)) {
							per = 2;
						} else {
							per = 1;
						}
						starUp = 5.00 * (20 - cntStar);
						starDown = 5.00 * (cntStar);
						starBreak = 0.00;
					} else if (cntStar < 22) {
						if (cntFail == 2) {
							per = 1;
							cntFail = 0;
							starUp = 100.00;
							starBreak = 0.00;
							starDown = 0.00;
						} else {
							int rdNum = rd.nextInt(1000000);
							if (rdNum % 1000 < 700) {
								if (cntStar == 15 || cntStar == 20) {
									per = 2;
									starBreak = 0.00;
								} else if (rdNum % 1000 < 21 && cntStar < 18 || rdNum % 1000 < 28 && cntStar < 20
										|| rdNum % 1000 < 70 && cntStar < 22) {
									per = 4;
								} else {
									per = 3;
									cntFail++;
								}
							} else {
								per = 1;
							}
							starUp = 30.00;
							starBreak = cntStar < 18 ? 2.10 : cntStar < 20 ? 2.80 : 7.00;
							starDown = 70.00 - starBreak;
						}
					} else if (cntStar == 22) {
						if (cntFail == 2) {
							per = 1;
							cntFail = 0;
							starUp = 100.00;
							starBreak = 0.00;
							starDown = 0.00;
						} else {
							int rdNum = rd.nextInt(1000000);
							if (rdNum % 1000 < 970) {
								if (rdNum % 1000 < 194) {
									per = 4;
								} else {
									per = 3;
									cntFail++;
								}
							} else {
								per = 1;
							}
						}
						starUp = 3.00;
						starBreak = 19.40;
						starDown = 97.00 - starBreak;
					} else if (cntStar == 23) {
						if (cntFail == 2) {
							per = 1;
							cntFail = 0;
							starUp = 100.00;
							starBreak = 0.00;
							starDown = 0.00;
						} else {
							int rdNum = rd.nextInt(1000000);
							if (rdNum % 1000 < 980) {
								if (rdNum % 1000 < 294) {
									per = 4;
								} else {
									per = 3;
									cntFail++;
								}
							} else {
								per = 1;
							}
						}
						starUp = 2.00;
						starBreak = 29.40;
						starDown = 98.00 - starBreak;
					} else if (cntStar == 24) {
						if (cntFail == 2) {
							per = 1;
							cntFail = 0;
							starUp = 100.00;
							starBreak = 0.00;
							starDown = 0.00;
						} else {
							int rdNum = rd.nextInt(1000000);
							if (rdNum % 1000 < 990) {
								if (rdNum % 1000 < 394) {
									per = 4;
								} else {
									per = 3;
									cntFail++;
								}
							} else {
								per = 1;
							}
						}
						starUp = 1.00;
						starBreak = 39.40;
						starDown = 99.00 - starBreak;
					}
					int costStar = 0;
					if (cntStar < 10) {
						costStar = (int) (1000 + (8000000 * (cntStar + 1) / 36));
					} else if (cntStar == 10) {
						costStar = (int) (1000 + (8000000 * (Math.pow((cntStar + 1), 2.7)) / 571));
					} else if (cntStar == 11) {
						costStar = (int) (1000 + (8000000 * (Math.pow((cntStar + 1), 2.7)) / 314));
					} else if (cntStar == 12) {
						costStar = (int) (1000 + (8000000 * (Math.pow((cntStar + 1), 2.7)) / 214));
					} else if (cntStar == 13) {
						costStar = (int) (1000 + (8000000 * (Math.pow((cntStar + 1), 2.7)) / 157));
					} else if (cntStar == 14) {
						costStar = (int) (1000 + (8000000 * (Math.pow((cntStar + 1), 2.7)) / 107));
					} else {
						costStar = (int) (1000 + (8000000 * (Math.pow((cntStar + 1), 2.7)) / 200));
					}
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
					System.out.print("┃ ");
					System.out.print("┌──────────────────────────────────┐");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│          스타 포스 강화          │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("└──────────────────────────────────┘");
					System.out.println(" ┃");
					System.out.print("┃             ");
					System.out.print("┌──────────┐");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("      ／");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃     ");
					System.out.print("현재    ");
					System.out.print("│ ");
					System.out.print("    ／  ");
					System.out.print(" │");
					System.out.print("   성공 시");
					System.out.println("   ┃");
					System.out.print("┃     ");
					System.out.print(cntStar < 10 ? " " + cntStar + "성    " : "" + cntStar + "성    ");
					System.out.print("│ ");
					System.out.print("／＼    ");
					System.out.print(" │     ");
					System.out.print(cntStar + 1 < 10 ? " " + (cntStar + 1) + "성" : "" + (cntStar + 1) + "성");
					System.out.println("    ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("／／    ");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("└──────────┘");
					System.out.println("             ┃");
					System.out.print("┃ ");
					System.out.print("┌──────────────────────────────────┐");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│         성공 확률 : ");
					System.out.print(starUp == 100.00 ? starUp + "        │"
							: starUp >= 10.00 ? starUp + "         │" : starUp + "          │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├──────────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│         실패 확률 : ");
					System.out.print(starDown < 10 ? starDown + "          │" : starDown + "         │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├──────────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│         파괴 확률 : ");
					System.out.print(starBreak < 10 ? starBreak + "          │" : starBreak + "         │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├──────────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print(costStar < 1000000 ? "│        강화 비용 : "
							: costStar < 10000000 ? "│        강화 비용 : "
									: costStar < 100000000 ? "│       강화 비용 : " : "│       강화 비용 : ");
					System.out.print(costStar < 1000000 ? costStar + "        │"
							: costStar < 10000000 ? costStar + "       │"
									: costStar < 100000000 ? costStar + "       │" : costStar + "      │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├─────────────────┬────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│     1. 강화     │     0. 취소    │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("└─────────────────┴────────────────┘");
					System.out.println(" ┃");
					System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
					System.out.print("강화 선택 >> ");
					int star = sc.nextInt();
					System.out.println();
					if (star == 0) {
						System.out.println("스타 포스 강화 종료");
						break;
					}
					power[0] -= power[4];
					str[0] -= str[4];
					dex[0] -= dex[4];
					hp[0] -= hp[4];
					mp[0] -= mp[4];
					if (per == 1) {
						System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
						System.out.print("┃ ");
						System.out.print(cntStar + 1 < 10 ? "           " + (cntStar + 1) + "성 "
								: "          " + (cntStar + 1) + "성 ");
						System.out.print("강화 성공 !          ");
						System.out.println(" ┃");
						System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
						cntStar++;
						if (cntStar < 16) {
							power[4] += (power[1] + power[3] + power[4]) / 50 + 1;
						} else if (cntStar < 18) {
							power[4] += 13;
						} else if (cntStar < 20) {
							power[4] += 14;
						} else if (cntStar < 23) {
							power[4] += cntStar - 5;
						} else if (cntStar < 26) {
							power[4] += cntStar + 11;
						}
						if (cntStar < 6) {
							str[4] += 2;
							dex[4] += 2;
						} else if (cntStar < 16) {
							str[4] += 3;
							dex[4] += 3;
						} else if (cntStar < 23) {
							str[4] += 15;
							dex[4] += 15;
						}
						if (cntStar < 4) {
							hp[4] += 5;
							mp[4] += 5;
						} else if (cntStar < 7) {
							hp[4] += 10;
							mp[4] += 10;
						} else if (cntStar < 10) {
							hp[4] += 20;
							mp[4] += 20;
						} else if (cntStar < 16) {
							hp[4] += 25;
							mp[4] += 25;
						}
					} else if (per == 2) {
						System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
						System.out.print("┃ ");
						System.out.print("             강화 실패 !            ");
						System.out.println(" ┃");
						System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
					} else if (per == 3) {
						System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
						System.out.print("┃ ");
						System.out.print("             강화 하락 !            ");
						System.out.println(" ┃");
						System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
						if (cntStar < 18) {
							power[4] -= 13;
						} else if (cntStar < 20) {
							power[4] -= 14;
						} else if (cntStar < 23) {
							power[4] -= cntStar - 5;
						} else if (cntStar < 26) {
							power[4] -= cntStar + 11;
						}
						if (cntStar < 23) {
							str[4] -= 15;
							dex[4] -= 15;
						}
						cntStar--;
					} else {
						System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
						System.out.print("┃ ");
						System.out.print("             장비 파괴 !            ");
						System.out.println(" ┃");
						System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
						for (int i = cntStar; i > 12; i--) {
							if (cntStar < 16) {
								power[4] -= (power[1] + power[3] + power[4]) / 50 + 1;
							} else if (cntStar < 18) {
								power[4] -= 13;
							} else if (cntStar < 20) {
								power[4] -= 14;
							} else if (cntStar < 23) {
								power[4] -= cntStar - 5;
							} else if (cntStar < 26) {
								power[4] -= cntStar + 11;
							}
							if (cntStar < 6) {
								str[4] -= 2;
								dex[4] -= 2;
							} else if (cntStar < 16) {
								str[4] -= 3;
								dex[4] -= 3;
							} else if (cntStar < 23) {
								str[4] -= 15;
								dex[4] -= 15;
							}
							if (cntStar < 4) {
								hp[4] -= 5;
								mp[4] -= 5;
							} else if (cntStar < 7) {
								hp[4] -= 10;
								mp[4] -= 10;
							} else if (cntStar < 10) {
								hp[4] -= 20;
								mp[4] -= 20;
							} else if (cntStar < 16) {
								hp[4] -= 25;
								mp[4] -= 25;
							}
							cntStar--;
						}
						cntStarDis++;
					}
					hp[0] += hp[4];
					mp[0] += mp[4];
					power[0] += power[4];
					str[0] += str[4];
					dex[0] += dex[4];
					cntStarTry++;
					mesoStar += costStar;
					System.out.print("확인 >> ");
					int check = sc.nextInt();
					System.out.println();
					continue;
				}
			} else if (sel == 3) {
				jamjae = true;
				while (true) {
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
					System.out.print("┃ ");
					System.out.print("┌──────────────────────────────────┐");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│          잠재 능력 강화          │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("└──────────────────────────────────┘");
					System.out.println(" ┃");
					System.out.print("┃             ");
					System.out.print("┌──────────┐");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("      ／");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("    ／  ");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("／＼    ");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("／／    ");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("└──────────┘");
					System.out.println("             ┃");
					System.out.print("┃ ");
					System.out.print("┌──────────────────────────────────┐");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│             현재 옵션            │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├──────────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│ ");
					if (jamjae) {
						posTotal = jamjaes[jamjaeLev].equals("") ? 1
								: (jamjaes[jamjaeLev].length() + jamjaes[jamjaeLev].getBytes().length) / 2;
						for (int i = 0; i < 16 - posTotal / 2; i++) {
							System.out.print(" ");
						}
						System.out.print(jamjaes[jamjaeLev]);
						for (int i = 16 + posTotal / 2; i < 32; i++) {
							System.out.print(" ");
						}
						System.out.print(posTotal % 2 == 1 && posTotal != 1 ? "│" : " │");
					} else {
						System.out.print("                                 │");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├──────────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│ ");
					if (jamjae) {
						System.out.print(jamjaeSet[0]);
						posTotal = jamjaeSet[0].equals("") ? 0
								: (jamjaeSet[0].length() + jamjaeSet[0].getBytes().length) / 2;
						for (int i = posTotal; i < 32; i++) {
							System.out.print(" ");
						}
						System.out.print(" │");
					} else {
						System.out.print("                                 │");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│ ");
					if (jamjae) {
						System.out.print(jamjaeSet[1]);
						posTotal = jamjaeSet[1].equals("") ? 0
								: (jamjaeSet[1].length() + jamjaeSet[1].getBytes().length) / 2;
						for (int i = posTotal; i < 32; i++) {
							System.out.print(" ");
						}
						System.out.print(" │");
					} else {
						System.out.print("                                 │");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│ ");
					if (jamjae) {
						System.out.print(jamjaeSet[2]);
						posTotal = jamjaeSet[2].equals("") ? 0
								: (jamjaeSet[2].length() + jamjaeSet[2].getBytes().length) / 2;
						for (int i = posTotal; i < 32; i++) {
							System.out.print(" ");
						}
						System.out.print(" │");
					} else {
						System.out.print("                                 │");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("└──────────────────────────────────┘");
					System.out.println(" ┃");
					// 등급 업 판정
					boolean jamjaeLevUp = false;
					if (jamjaeLev == 0) {
						jamjaeLev++;
						jamjaeLevUp = true;
					}
					if (jamjaeLev == 3) {
						int rdNum = rd.nextInt(1000000);
						if (rdNum % 1000 < 14 || cntToLegend == cntToLegendSet) {
							jamjaeLev++;
							jamjaeLevUp = true;
							cntToLegend++;
						} else {
							cntToLegend++;
						}
					}
					if (jamjaeLev == 2) {
						int rdNum = rd.nextInt(1000000);
						if (rdNum % 200 < 7 || cntToUnique == cntToUniqueSet) {
							jamjaeLev++;
							cntToUnique++;
							jamjaeLevUp = true;
						} else {
							cntToUnique++;
						}
					}
					if (jamjaeLev == 1) {
						int rdNum = rd.nextInt(1000000);
						if (rdNum % 20 < 3 || cntToEpic == cntToEpicSet) {
							jamjaeLev++;
							cntToEpic++;
							jamjaeLevUp = true;
						} else {
							cntToEpic++;
						}
					}
					String jamjae1Temp = "";
					String jamjae2Temp = "";
					String jamjae3Temp = "";
					// 1번 잠재추출
					if (jamjaeLev == 1) {
						// 레어
						// 6.1224 => 10개0~5,8~11
						// 4.08178 => 3개6,7,16
						// 2.04082 => 13개 12~15, 17~25
						int rdNum = rd.nextInt(10000000);
						if (rdNum < 6122400) {
							switch (rdNum % 10) {
							case 0:
								jamjae1Temp = jamjaeRare[0];
								break;
							case 1:
								jamjae1Temp = jamjaeRare[1];
								break;
							case 2:
								jamjae1Temp = jamjaeRare[2];
								break;
							case 3:
								jamjae1Temp = jamjaeRare[3];
								break;
							case 4:
								jamjae1Temp = jamjaeRare[4];
								break;
							case 5:
								jamjae1Temp = jamjaeRare[5];
								break;
							case 6:
								jamjae1Temp = jamjaeRare[8];
								break;
							case 7:
								jamjae1Temp = jamjaeRare[9];
								break;
							case 8:
								jamjae1Temp = jamjaeRare[10];
								break;
							case 9:
								jamjae1Temp = jamjaeRare[11];
								break;
							}
						} else if (rdNum < 8775466) {
							switch (rdNum % 3) {
							case 0:
								jamjae1Temp = jamjaeRare[6];
								break;
							case 1:
								jamjae1Temp = jamjaeRare[7];
								break;
							case 2:
								jamjae1Temp = jamjaeRare[16];
								break;
							}
						} else {
							switch (rdNum % 13) {
							case 0:
								jamjae1Temp = jamjaeRare[12];
								break;
							case 1:
								jamjae1Temp = jamjaeRare[13];
								break;
							case 2:
								jamjae1Temp = jamjaeRare[14];
								break;
							case 3:
								jamjae1Temp = jamjaeRare[15];
								break;
							case 4:
								jamjae1Temp = jamjaeRare[17];
								break;
							case 5:
								jamjae1Temp = jamjaeRare[18];
								break;
							case 6:
								jamjae1Temp = jamjaeRare[19];
								break;
							case 7:
								jamjae1Temp = jamjaeRare[20];
								break;
							case 8:
								jamjae1Temp = jamjaeRare[21];
								break;
							case 9:
								jamjae1Temp = jamjaeRare[22];
								break;
							case 10:
								jamjae1Temp = jamjaeRare[23];
								break;
							case 11:
								jamjae1Temp = jamjaeRare[24];
								break;
							case 12:
								jamjae1Temp = jamjaeRare[25];
								break;
							}
						}
					} else if (jamjaeLev == 2) {
						// 에픽
						// 10.8696 => 6개 0~5
						// 4.3478 => 8개6~13
						int rdNum = rd.nextInt(10000000);
						if (rdNum < 6121760) {
							switch (rdNum % 6) {
							case 0:
								jamjae1Temp = jamjaeEpic[0];
								break;
							case 1:
								jamjae1Temp = jamjaeEpic[1];
								break;
							case 2:
								jamjae1Temp = jamjaeEpic[2];
								break;
							case 3:
								jamjae1Temp = jamjaeEpic[3];
								break;
							case 4:
								jamjae1Temp = jamjaeEpic[4];
								break;
							case 5:
								jamjae1Temp = jamjaeEpic[5];
								break;
							}
						} else {
							switch (rdNum % 8) {
							case 0:
								jamjae1Temp = jamjaeEpic[6];
								break;
							case 1:
								jamjae1Temp = jamjaeEpic[7];
								break;
							case 2:
								jamjae1Temp = jamjaeEpic[8];
								break;
							case 3:
								jamjae1Temp = jamjaeEpic[9];
								break;
							case 4:
								jamjae1Temp = jamjaeEpic[10];
								break;
							case 5:
								jamjae1Temp = jamjaeEpic[11];
								break;
							case 6:
								jamjae1Temp = jamjaeEpic[12];
								break;
							case 7:
								jamjae1Temp = jamjaeEpic[13];
								break;
							}
						}
					} else if (jamjaeLev == 3) {
						// 유니크
						// 11.6279 => 4개 0~3
						// 6.9767 => 5개 4,5,7,9,10
						// 9.30245 => 2개 6,8
						int rdNum = rd.nextInt(10000000);
						if (rdNum < 4651160) {
							switch (rdNum % 4) {
							case 0:
								jamjae1Temp = jamjaeUnique[0];
								break;
							case 1:
								jamjae1Temp = jamjaeUnique[1];
								break;
							case 2:
								jamjae1Temp = jamjaeUnique[2];
								break;
							case 3:
								jamjae1Temp = jamjaeUnique[3];
								break;
							}
						} else if (rdNum < 6511650) {
							switch (rdNum % 2) {
							case 0:
								jamjae1Temp = jamjaeUnique[6];
								break;
							case 1:
								jamjae1Temp = jamjaeUnique[8];
								break;
							}
						} else {
							switch (rdNum % 5) {
							case 0:
								jamjae1Temp = jamjaeUnique[4];
								break;
							case 1:
								jamjae1Temp = jamjaeUnique[5];
								break;
							case 2:
								jamjae1Temp = jamjaeUnique[7];
								break;
							case 3:
								jamjae1Temp = jamjaeUnique[9];
								break;
							case 4:
								jamjae1Temp = jamjaeUnique[10];
								break;
							}
						}
					} else if (jamjaeLev == 4) {
						// 레전
						// 9.75609 => 5개0~3,13
						// 7.3171 => 1개 8
						// 4.87805 => 9개 4~7,9,10,11,12,14
						int rdNum = rd.nextInt(10000000);
						if (rdNum < 4878045) {
							switch (rdNum % 5) {
							case 0:
								jamjae1Temp = jamjaeLegend[0];
								break;
							case 1:
								jamjae1Temp = jamjaeLegend[1];
								break;
							case 2:
								jamjae1Temp = jamjaeLegend[2];
								break;
							case 3:
								jamjae1Temp = jamjaeLegend[3];
								break;
							case 4:
								jamjae1Temp = jamjaeLegend[13];
								break;
							}
						} else if (rdNum < 5609755) {
							jamjae1Temp = jamjaeLegend[8];
						} else {
							switch (rdNum % 9) {
							case 0:
								jamjae1Temp = jamjaeLegend[4];
								break;
							case 1:
								jamjae1Temp = jamjaeLegend[5];
								break;
							case 2:
								jamjae1Temp = jamjaeLegend[6];
								break;
							case 3:
								jamjae1Temp = jamjaeLegend[7];
								break;
							case 4:
								jamjae1Temp = jamjaeLegend[9];
								break;
							case 5:
								jamjae1Temp = jamjaeLegend[10];
								break;
							case 6:
								jamjae1Temp = jamjaeLegend[11];
								break;
							case 7:
								jamjae1Temp = jamjaeLegend[12];
								break;
							case 8:
								jamjae1Temp = jamjaeLegend[14];
								break;
							}
						}

					}

					// 2번 잠재추출
					if (jamjaeLev == 1) {
						// 레어
						// 6.1224 => 10개0~5,8~11
						// 4.08178 => 3개6,7,16
						// 2.04082 => 13개 12~15, 17~25
						int rdNum = rd.nextInt(10000000);
						if (rdNum < 6122400) {
							switch (rdNum % 10) {
							case 0:
								jamjae2Temp = jamjaeRare[0];
								break;
							case 1:
								jamjae2Temp = jamjaeRare[1];
								break;
							case 2:
								jamjae2Temp = jamjaeRare[2];
								break;
							case 3:
								jamjae2Temp = jamjaeRare[3];
								break;
							case 4:
								jamjae2Temp = jamjaeRare[4];
								break;
							case 5:
								jamjae2Temp = jamjaeRare[5];
								break;
							case 6:
								jamjae2Temp = jamjaeRare[8];
								break;
							case 7:
								jamjae2Temp = jamjaeRare[9];
								break;
							case 8:
								jamjae2Temp = jamjaeRare[10];
								break;
							case 9:
								jamjae2Temp = jamjaeRare[11];
								break;
							}
						} else if (rdNum < 8775466) {
							switch (rdNum % 3) {
							case 0:
								jamjae2Temp = jamjaeRare[6];
								break;
							case 1:
								jamjae2Temp = jamjaeRare[7];
								break;
							case 2:
								jamjae2Temp = jamjaeRare[16];
								break;
							}
						} else {
							switch (rdNum % 13) {
							case 0:
								jamjae2Temp = jamjaeRare[12];
								break;
							case 1:
								jamjae2Temp = jamjaeRare[13];
								break;
							case 2:
								jamjae2Temp = jamjaeRare[14];
								break;
							case 3:
								jamjae2Temp = jamjaeRare[15];
								break;
							case 4:
								jamjae2Temp = jamjaeRare[17];
								break;
							case 5:
								jamjae2Temp = jamjaeRare[18];
								break;
							case 6:
								jamjae2Temp = jamjaeRare[19];
								break;
							case 7:
								jamjae2Temp = jamjaeRare[20];
								break;
							case 8:
								jamjae2Temp = jamjaeRare[21];
								break;
							case 9:
								jamjae2Temp = jamjaeRare[22];
								break;
							case 10:
								jamjae2Temp = jamjaeRare[23];
								break;
							case 11:
								jamjae2Temp = jamjaeRare[24];
								break;
							case 12:
								jamjae2Temp = jamjaeRare[25];
								break;
							}
						}
					} else if (jamjaeLev == 2) {
						int rdNum = rd.nextInt(10000000);
						if (rdNum % 5 < 1) {
							// 에픽
							// 10.8696 => 6개 0~5
							// 4.3478 => 8개6~13
							rdNum = rd.nextInt(10000000);
							if (rdNum < 6121760) {
								switch (rdNum % 6) {
								case 0:
									jamjae2Temp = jamjaeEpic[0];
									break;
								case 1:
									jamjae2Temp = jamjaeEpic[1];
									break;
								case 2:
									jamjae2Temp = jamjaeEpic[2];
									break;
								case 3:
									jamjae2Temp = jamjaeEpic[3];
									break;
								case 4:
									jamjae2Temp = jamjaeEpic[4];
									break;
								case 5:
									jamjae2Temp = jamjaeEpic[5];
									break;
								}
							} else {
								switch (rdNum % 8) {
								case 0:
									jamjae2Temp = jamjaeEpic[6];
									break;
								case 1:
									jamjae2Temp = jamjaeEpic[7];
									break;
								case 2:
									jamjae2Temp = jamjaeEpic[8];
									break;
								case 3:
									jamjae2Temp = jamjaeEpic[9];
									break;
								case 4:
									jamjae2Temp = jamjaeEpic[10];
									break;
								case 5:
									jamjae2Temp = jamjaeEpic[11];
									break;
								case 6:
									jamjae2Temp = jamjaeEpic[12];
									break;
								case 7:
									jamjae2Temp = jamjaeEpic[13];
									break;
								}
							}
						} else {
							// 레어
							// 6.1224 => 10개0~5,8~11
							// 4.08178 => 3개6,7,16
							// 2.04082 => 13개 12~15, 17~25
							rdNum = rd.nextInt(10000000);
							if (rdNum < 6122400) {
								switch (rdNum % 10) {
								case 0:
									jamjae2Temp = jamjaeRare[0];
									break;
								case 1:
									jamjae2Temp = jamjaeRare[1];
									break;
								case 2:
									jamjae2Temp = jamjaeRare[2];
									break;
								case 3:
									jamjae2Temp = jamjaeRare[3];
									break;
								case 4:
									jamjae2Temp = jamjaeRare[4];
									break;
								case 5:
									jamjae2Temp = jamjaeRare[5];
									break;
								case 6:
									jamjae2Temp = jamjaeRare[8];
									break;
								case 7:
									jamjae2Temp = jamjaeRare[9];
									break;
								case 8:
									jamjae2Temp = jamjaeRare[10];
									break;
								case 9:
									jamjae2Temp = jamjaeRare[11];
									break;
								}
							} else if (rdNum < 8775466) {
								switch (rdNum % 3) {
								case 0:
									jamjae2Temp = jamjaeRare[6];
									break;
								case 1:
									jamjae2Temp = jamjaeRare[7];
									break;
								case 2:
									jamjae2Temp = jamjaeRare[16];
									break;
								}
							} else {
								switch (rdNum % 13) {
								case 0:
									jamjae2Temp = jamjaeRare[12];
									break;
								case 1:
									jamjae2Temp = jamjaeRare[13];
									break;
								case 2:
									jamjae2Temp = jamjaeRare[14];
									break;
								case 3:
									jamjae2Temp = jamjaeRare[15];
									break;
								case 4:
									jamjae2Temp = jamjaeRare[17];
									break;
								case 5:
									jamjae2Temp = jamjaeRare[18];
									break;
								case 6:
									jamjae2Temp = jamjaeRare[19];
									break;
								case 7:
									jamjae2Temp = jamjaeRare[20];
									break;
								case 8:
									jamjae2Temp = jamjaeRare[21];
									break;
								case 9:
									jamjae2Temp = jamjaeRare[22];
									break;
								case 10:
									jamjae2Temp = jamjaeRare[23];
									break;
								case 11:
									jamjae2Temp = jamjaeRare[24];
									break;
								case 12:
									jamjae2Temp = jamjaeRare[25];
									break;
								}
							}
						}

					} else if (jamjaeLev == 3) {
						int rdNum = rd.nextInt(10000000);
						if (rdNum % 5 < 1) {
							// 유니크
							// 11.6279 => 4개 0~3
							// 6.9767 => 5개 4,5,7,9,10
							// 9.30245 => 2개 6,8
							rdNum = rd.nextInt(10000000);
							if (rdNum < 4651160) {
								switch (rdNum % 4) {
								case 0:
									jamjae2Temp = jamjaeUnique[0];
									break;
								case 1:
									jamjae2Temp = jamjaeUnique[1];
									break;
								case 2:
									jamjae2Temp = jamjaeUnique[2];
									break;
								case 3:
									jamjae2Temp = jamjaeUnique[3];
									break;
								}
							} else if (rdNum < 6511650) {
								switch (rdNum % 2) {
								case 0:
									jamjae2Temp = jamjaeUnique[6];
									break;
								case 1:
									jamjae2Temp = jamjaeUnique[8];
									break;
								}
							} else {
								switch (rdNum % 5) {
								case 0:
									jamjae2Temp = jamjaeUnique[4];
									break;
								case 1:
									jamjae2Temp = jamjaeUnique[5];
									break;
								case 2:
									jamjae2Temp = jamjaeUnique[7];
									break;
								case 3:
									jamjae2Temp = jamjaeUnique[9];
									break;
								case 4:
									jamjae2Temp = jamjaeUnique[10];
									break;
								}
							}
						} else {
							// 에픽
							// 10.8696 => 6개 0~5
							// 4.3478 => 8개6~13
							rdNum = rd.nextInt(10000000);
							if (rdNum < 6121760) {
								switch (rdNum % 6) {
								case 0:
									jamjae2Temp = jamjaeEpic[0];
									break;
								case 1:
									jamjae2Temp = jamjaeEpic[1];
									break;
								case 2:
									jamjae2Temp = jamjaeEpic[2];
									break;
								case 3:
									jamjae2Temp = jamjaeEpic[3];
									break;
								case 4:
									jamjae2Temp = jamjaeEpic[4];
									break;
								case 5:
									jamjae2Temp = jamjaeEpic[5];
									break;
								}
							} else {
								switch (rdNum % 8) {
								case 0:
									jamjae2Temp = jamjaeEpic[6];
									break;
								case 1:
									jamjae2Temp = jamjaeEpic[7];
									break;
								case 2:
									jamjae2Temp = jamjaeEpic[8];
									break;
								case 3:
									jamjae2Temp = jamjaeEpic[9];
									break;
								case 4:
									jamjae2Temp = jamjaeEpic[10];
									break;
								case 5:
									jamjae2Temp = jamjaeEpic[11];
									break;
								case 6:
									jamjae2Temp = jamjaeEpic[12];
									break;
								case 7:
									jamjae2Temp = jamjaeEpic[13];
									break;
								}
							}
						}
					} else if (jamjaeLev == 4) {
						int rdNum = rd.nextInt(10000000);
						if (rdNum % 5 < 1) {
							// 레전
							// 9.75609 => 5개0~3,13
							// 7.3171 => 1개 8
							// 4.87805 => 9개 4~7,9,10,11,12,14
							rdNum = rd.nextInt(10000000);
							if (rdNum < 4878045) {
								switch (rdNum % 5) {
								case 0:
									jamjae2Temp = jamjaeLegend[0];
									break;
								case 1:
									jamjae2Temp = jamjaeLegend[1];
									break;
								case 2:
									jamjae2Temp = jamjaeLegend[2];
									break;
								case 3:
									jamjae2Temp = jamjaeLegend[3];
									break;
								case 4:
									jamjae2Temp = jamjaeLegend[13];
									break;
								}
							} else if (rdNum < 5609755) {
								jamjae2Temp = jamjaeLegend[8];
							} else {
								switch (rdNum % 9) {
								case 0:
									jamjae2Temp = jamjaeLegend[4];
									break;
								case 1:
									jamjae2Temp = jamjaeLegend[5];
									break;
								case 2:
									jamjae2Temp = jamjaeLegend[6];
									break;
								case 3:
									jamjae2Temp = jamjaeLegend[7];
									break;
								case 4:
									jamjae2Temp = jamjaeLegend[9];
									break;
								case 5:
									jamjae2Temp = jamjaeLegend[10];
									break;
								case 6:
									jamjae2Temp = jamjaeLegend[11];
									break;
								case 7:
									jamjae2Temp = jamjaeLegend[12];
									break;
								case 8:
									jamjae2Temp = jamjaeLegend[14];
									break;
								}
							}
						} else {
							// 유니크
							// 11.6279 => 4개 0~3
							// 6.9767 => 5개 4,5,7,9,10
							// 9.30245 => 2개 6,8
							rdNum = rd.nextInt(10000000);
							if (rdNum < 4651160) {
								switch (rdNum % 4) {
								case 0:
									jamjae2Temp = jamjaeUnique[0];
									break;
								case 1:
									jamjae2Temp = jamjaeUnique[1];
									break;
								case 2:
									jamjae2Temp = jamjaeUnique[2];
									break;
								case 3:
									jamjae2Temp = jamjaeUnique[3];
									break;
								}
							} else if (rdNum < 6511650) {
								switch (rdNum % 2) {
								case 0:
									jamjae2Temp = jamjaeUnique[6];
									break;
								case 1:
									jamjae2Temp = jamjaeUnique[8];
									break;
								}
							} else {
								switch (rdNum % 5) {
								case 0:
									jamjae2Temp = jamjaeUnique[4];
									break;
								case 1:
									jamjae2Temp = jamjaeUnique[5];
									break;
								case 2:
									jamjae2Temp = jamjaeUnique[7];
									break;
								case 3:
									jamjae2Temp = jamjaeUnique[9];
									break;
								case 4:
									jamjae2Temp = jamjaeUnique[10];
									break;
								}
							}
						}

					}

					// 3번 잠재추출
					if (jamjaeLev == 1) {
						// 레어
						// 6.1224 => 10개0~5,8~11
						// 4.08178 => 3개6,7,16
						// 2.04082 => 13개 12~15, 17~25
						int rdNum = rd.nextInt(10000000);
						if (rdNum < 6122400) {
							switch (rdNum % 10) {
							case 0:
								jamjae3Temp = jamjaeRare[0];
								break;
							case 1:
								jamjae3Temp = jamjaeRare[1];
								break;
							case 2:
								jamjae3Temp = jamjaeRare[2];
								break;
							case 3:
								jamjae3Temp = jamjaeRare[3];
								break;
							case 4:
								jamjae3Temp = jamjaeRare[4];
								break;
							case 5:
								jamjae3Temp = jamjaeRare[5];
								break;
							case 6:
								jamjae3Temp = jamjaeRare[8];
								break;
							case 7:
								jamjae3Temp = jamjaeRare[9];
								break;
							case 8:
								jamjae3Temp = jamjaeRare[10];
								break;
							case 9:
								jamjae3Temp = jamjaeRare[11];
								break;
							}
						} else if (rdNum < 8775466) {
							switch (rdNum % 3) {
							case 0:
								jamjae3Temp = jamjaeRare[6];
								break;
							case 1:
								jamjae3Temp = jamjaeRare[7];
								break;
							case 2:
								jamjae3Temp = jamjaeRare[16];
								break;
							}
						} else {
							switch (rdNum % 13) {
							case 0:
								jamjae3Temp = jamjaeRare[12];
								break;
							case 1:
								jamjae3Temp = jamjaeRare[13];
								break;
							case 2:
								jamjae3Temp = jamjaeRare[14];
								break;
							case 3:
								jamjae3Temp = jamjaeRare[15];
								break;
							case 4:
								jamjae3Temp = jamjaeRare[17];
								break;
							case 5:
								jamjae3Temp = jamjaeRare[18];
								break;
							case 6:
								jamjae3Temp = jamjaeRare[19];
								break;
							case 7:
								jamjae3Temp = jamjaeRare[20];
								break;
							case 8:
								jamjae3Temp = jamjaeRare[21];
								break;
							case 9:
								jamjae3Temp = jamjaeRare[22];
								break;
							case 10:
								jamjae3Temp = jamjaeRare[23];
								break;
							case 11:
								jamjae3Temp = jamjaeRare[24];
								break;
							case 12:
								jamjae3Temp = jamjaeRare[25];
								break;
							}
						}
					} else if (jamjaeLev == 2) {
						int rdNum = rd.nextInt(10000000);
						if (rdNum % 20 < 1) {
							// 에픽
							// 10.8696 => 6개 0~5
							// 4.3478 => 8개6~13
							rdNum = rd.nextInt(10000000);
							if (rdNum < 6121760) {
								switch (rdNum % 6) {
								case 0:
									jamjae3Temp = jamjaeEpic[0];
									break;
								case 1:
									jamjae3Temp = jamjaeEpic[1];
									break;
								case 2:
									jamjae3Temp = jamjaeEpic[2];
									break;
								case 3:
									jamjae3Temp = jamjaeEpic[3];
									break;
								case 4:
									jamjae3Temp = jamjaeEpic[4];
									break;
								case 5:
									jamjae3Temp = jamjaeEpic[5];
									break;
								}
							} else {
								switch (rdNum % 8) {
								case 0:
									jamjae3Temp = jamjaeEpic[6];
									break;
								case 1:
									jamjae3Temp = jamjaeEpic[7];
									break;
								case 2:
									jamjae3Temp = jamjaeEpic[8];
									break;
								case 3:
									jamjae3Temp = jamjaeEpic[9];
									break;
								case 4:
									jamjae3Temp = jamjaeEpic[10];
									break;
								case 5:
									jamjae3Temp = jamjaeEpic[11];
									break;
								case 6:
									jamjae3Temp = jamjaeEpic[12];
									break;
								case 7:
									jamjae3Temp = jamjaeEpic[13];
									break;
								}
							}
						} else {
							// 레어
							// 6.1224 => 10개0~5,8~11
							// 4.08178 => 3개6,7,16
							// 2.04082 => 13개 12~15, 17~25
							rdNum = rd.nextInt(10000000);
							if (rdNum < 6122400) {
								switch (rdNum % 10) {
								case 0:
									jamjae3Temp = jamjaeRare[0];
									break;
								case 1:
									jamjae3Temp = jamjaeRare[1];
									break;
								case 2:
									jamjae3Temp = jamjaeRare[2];
									break;
								case 3:
									jamjae3Temp = jamjaeRare[3];
									break;
								case 4:
									jamjae3Temp = jamjaeRare[4];
									break;
								case 5:
									jamjae3Temp = jamjaeRare[5];
									break;
								case 6:
									jamjae3Temp = jamjaeRare[8];
									break;
								case 7:
									jamjae3Temp = jamjaeRare[9];
									break;
								case 8:
									jamjae3Temp = jamjaeRare[10];
									break;
								case 9:
									jamjae3Temp = jamjaeRare[11];
									break;
								}
							} else if (rdNum < 8775466) {
								switch (rdNum % 3) {
								case 0:
									jamjae3Temp = jamjaeRare[6];
									break;
								case 1:
									jamjae3Temp = jamjaeRare[7];
									break;
								case 2:
									jamjae3Temp = jamjaeRare[16];
									break;
								}
							} else {
								switch (rdNum % 13) {
								case 0:
									jamjae3Temp = jamjaeRare[12];
									break;
								case 1:
									jamjae3Temp = jamjaeRare[13];
									break;
								case 2:
									jamjae3Temp = jamjaeRare[14];
									break;
								case 3:
									jamjae3Temp = jamjaeRare[15];
									break;
								case 4:
									jamjae3Temp = jamjaeRare[17];
									break;
								case 5:
									jamjae3Temp = jamjaeRare[18];
									break;
								case 6:
									jamjae3Temp = jamjaeRare[19];
									break;
								case 7:
									jamjae3Temp = jamjaeRare[20];
									break;
								case 8:
									jamjae3Temp = jamjaeRare[21];
									break;
								case 9:
									jamjae3Temp = jamjaeRare[22];
									break;
								case 10:
									jamjae3Temp = jamjaeRare[23];
									break;
								case 11:
									jamjae3Temp = jamjaeRare[24];
									break;
								case 12:
									jamjae3Temp = jamjaeRare[25];
									break;
								}
							}
						}

					} else if (jamjaeLev == 3) {
						int rdNum = rd.nextInt(10000000);
						if (rdNum % 20 < 1) {
							// 유니크
							// 11.6279 => 4개 0~3
							// 6.9767 => 5개 4,5,7,9,10
							// 9.30245 => 2개 6,8
							rdNum = rd.nextInt(10000000);
							if (rdNum < 4651160) {
								switch (rdNum % 4) {
								case 0:
									jamjae3Temp = jamjaeUnique[0];
									break;
								case 1:
									jamjae3Temp = jamjaeUnique[1];
									break;
								case 2:
									jamjae3Temp = jamjaeUnique[2];
									break;
								case 3:
									jamjae3Temp = jamjaeUnique[3];
									break;
								}
							} else if (rdNum < 6511650) {
								switch (rdNum % 2) {
								case 0:
									jamjae3Temp = jamjaeUnique[6];
									break;
								case 1:
									jamjae3Temp = jamjaeUnique[8];
									break;
								}
							} else {
								switch (rdNum % 5) {
								case 0:
									jamjae3Temp = jamjaeUnique[4];
									break;
								case 1:
									jamjae3Temp = jamjaeUnique[5];
									break;
								case 2:
									jamjae3Temp = jamjaeUnique[7];
									break;
								case 3:
									jamjae3Temp = jamjaeUnique[9];
									break;
								case 4:
									jamjae3Temp = jamjaeUnique[10];
									break;
								}
							}
						} else {
							// 에픽
							// 10.8696 => 6개 0~5
							// 4.3478 => 8개6~13
							rdNum = rd.nextInt(10000000);
							if (rdNum < 6121760) {
								switch (rdNum % 6) {
								case 0:
									jamjae3Temp = jamjaeEpic[0];
									break;
								case 1:
									jamjae3Temp = jamjaeEpic[1];
									break;
								case 2:
									jamjae3Temp = jamjaeEpic[2];
									break;
								case 3:
									jamjae3Temp = jamjaeEpic[3];
									break;
								case 4:
									jamjae3Temp = jamjaeEpic[4];
									break;
								case 5:
									jamjae3Temp = jamjaeEpic[5];
									break;
								}
							} else {
								switch (rdNum % 8) {
								case 0:
									jamjae3Temp = jamjaeEpic[6];
									break;
								case 1:
									jamjae3Temp = jamjaeEpic[7];
									break;
								case 2:
									jamjae3Temp = jamjaeEpic[8];
									break;
								case 3:
									jamjae3Temp = jamjaeEpic[9];
									break;
								case 4:
									jamjae3Temp = jamjaeEpic[10];
									break;
								case 5:
									jamjae3Temp = jamjaeEpic[11];
									break;
								case 6:
									jamjae3Temp = jamjaeEpic[12];
									break;
								case 7:
									jamjae3Temp = jamjaeEpic[13];
									break;
								}
							}
						}
					} else if (jamjaeLev == 4) {
						int rdNum = rd.nextInt(10000000);
						if (rdNum % 20 < 1) {
							// 레전
							// 9.75609 => 5개0~3,13
							// 7.3171 => 1개 8
							// 4.87805 => 9개 4~7,9,10,11,12,14
							rdNum = rd.nextInt(10000000);
							if (rdNum < 4878045) {
								switch (rdNum % 5) {
								case 0:
									jamjae3Temp = jamjaeLegend[0];
									break;
								case 1:
									jamjae3Temp = jamjaeLegend[1];
									break;
								case 2:
									jamjae3Temp = jamjaeLegend[2];
									break;
								case 3:
									jamjae3Temp = jamjaeLegend[3];
									break;
								case 4:
									jamjae3Temp = jamjaeLegend[13];
									break;
								}
							} else if (rdNum < 5609755) {
								jamjae3Temp = jamjaeLegend[8];
							} else {
								switch (rdNum % 9) {
								case 0:
									jamjae3Temp = jamjaeLegend[4];
									break;
								case 1:
									jamjae3Temp = jamjaeLegend[5];
									break;
								case 2:
									jamjae3Temp = jamjaeLegend[6];
									break;
								case 3:
									jamjae3Temp = jamjaeLegend[7];
									break;
								case 4:
									jamjae3Temp = jamjaeLegend[9];
									break;
								case 5:
									jamjae3Temp = jamjaeLegend[10];
									break;
								case 6:
									jamjae3Temp = jamjaeLegend[11];
									break;
								case 7:
									jamjae3Temp = jamjaeLegend[12];
									break;
								case 8:
									jamjae3Temp = jamjaeLegend[14];
									break;
								}
							}
						} else {
							// 유니크
							// 11.6279 => 4개 0~3
							// 6.9767 => 5개 4,5,7,9,10
							// 9.30245 => 2개 6,8
							rdNum = rd.nextInt(10000000);
							if (rdNum < 4651160) {
								switch (rdNum % 4) {
								case 0:
									jamjae3Temp = jamjaeUnique[0];
									break;
								case 1:
									jamjae3Temp = jamjaeUnique[1];
									break;
								case 2:
									jamjae3Temp = jamjaeUnique[2];
									break;
								case 3:
									jamjae3Temp = jamjaeUnique[3];
									break;
								}
							} else if (rdNum < 6511650) {
								switch (rdNum % 2) {
								case 0:
									jamjae3Temp = jamjaeUnique[6];
									break;
								case 1:
									jamjae3Temp = jamjaeUnique[8];
									break;
								}
							} else {
								switch (rdNum % 5) {
								case 0:
									jamjae3Temp = jamjaeUnique[4];
									break;
								case 1:
									jamjae3Temp = jamjaeUnique[5];
									break;
								case 2:
									jamjae3Temp = jamjaeUnique[7];
									break;
								case 3:
									jamjae3Temp = jamjaeUnique[9];
									break;
								case 4:
									jamjae3Temp = jamjaeUnique[10];
									break;
								}
							}
						}

					}
					System.out.print("┃ ");
					System.out.print("┌──────────────────────────────────┐");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│             변경 옵션            │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├──────────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│ ");
					if (jamjae) {
						posTotal = (jamjaes[jamjaeLev].length() + jamjaes[jamjaeLev].getBytes().length) / 2;
						for (int i = 0; i < 16 - posTotal / 2; i++) {
							System.out.print(" ");
						}
						System.out.print(jamjaes[jamjaeLev]);
						for (int i = 16 + posTotal / 2; i < 32; i++) {
							System.out.print(" ");
						}
						System.out.print(posTotal % 2 == 1 ? "│" : " │");
					} else {
						System.out.print("                                 │");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├──────────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│ ");
					if (jamjae) {
						System.out.print(jamjae1Temp);
						posTotal = (jamjae1Temp.length() + jamjae1Temp.getBytes().length) / 2;
						for (int i = posTotal; i < 32; i++) {
							System.out.print(" ");
						}
						System.out.print(" │");
					} else {
						System.out.print("                                 │");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│ ");
					if (jamjae) {
						System.out.print(jamjae2Temp);
						posTotal = (jamjae2Temp.length() + jamjae2Temp.getBytes().length) / 2;
						for (int i = posTotal; i < 32; i++) {
							System.out.print(" ");
						}
						System.out.print(" │");
					} else {
						System.out.print("                                 │");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│ ");
					if (jamjae) {
						System.out.print(jamjae3Temp);
						posTotal = (jamjae3Temp.length() + jamjae3Temp.getBytes().length) / 2;
						for (int i = posTotal; i < 32; i++) {
							System.out.print(" ");
						}
						System.out.print(" │");
					} else {
						System.out.print("                                 │");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("└──────────────────────────────────┘");
					System.out.println(" ┃");
					System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
					if (jamjaeLevUp) {
						System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
						System.out.print("┃ ");
						System.out.print("             등급 상승              ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("                                    ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("              1. 확인               ");
						System.out.println(" ┃");
						System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
						System.out.print("확인 >> ");
						jamjaeSet[0] = jamjae1Temp;
						jamjaeSet[1] = jamjae2Temp;
						jamjaeSet[2] = jamjae3Temp;
						int check = sc.nextInt();
						System.out.println();
						continue;
					}
					System.out.println("1. 옵션 적용 >> ");
					System.out.print("옵션 돌리기 (0. 큐브 강화 종료) >> ");
					System.out.println();
					mesoJamjae += jamjaeLev == 0 ? 5400000
							: jamjaeLev == 1 ? 21600000 : jamjaeLev == 2 ? 45900000 : 54000000;
					cntOpUp++;
					int jamjaeSel = sc.nextInt();
					if (jamjaeSel == 0) {
						System.out.println("큐브 강화 종료");
						break;
					}
					if (jamjaeSel == 1) {
						jamjaeSet[0] = jamjae1Temp;
						jamjaeSet[1] = jamjae2Temp;
						jamjaeSet[2] = jamjae3Temp;
					}

				}
			} else if (sel == 4) {
				jamjaeAdd = true;
				while (true) {
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
					System.out.print("┃ ");
					System.out.print("┌──────────────────────────────────┐");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│     에디셔널 잠재 능력 강화      │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("└──────────────────────────────────┘");
					System.out.println(" ┃");
					System.out.print("┃             ");
					System.out.print("┌──────────┐");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("      ／");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("    ／  ");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("／＼    ");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("／／    ");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("└──────────┘");
					System.out.println("             ┃");
					System.out.print("┃ ");
					System.out.print("┌──────────────────────────────────┐");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│             현재 옵션            │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├──────────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│ ");
					if (jamjaeAdd) {
						posTotal = jamjaes[jamjaeAddLev].equals("") ? 1
								: (jamjaes[jamjaeAddLev].length() + jamjaes[jamjaeAddLev].getBytes().length) / 2;
						for (int i = 0; i < 16 - posTotal / 2; i++) {
							System.out.print(" ");
						}
						System.out.print(jamjaes[jamjaeAddLev]);
						for (int i = 16 + posTotal / 2; i < 32; i++) {
							System.out.print(" ");
						}
						System.out.print(posTotal % 2 == 1 && posTotal != 1 ? "│" : " │");
					} else {
						System.out.print("                                 │");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├──────────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│ ");
					if (jamjaeAdd) {
						System.out.print(jamjaeAddSet[0]);
						posTotal = jamjaeAddSet[0].equals("") ? 0
								: (jamjaeAddSet[0].length() + jamjaeAddSet[0].getBytes().length) / 2;
						for (int i = posTotal; i < 32; i++) {
							System.out.print(" ");
						}
						System.out.print(" │");
					} else {
						System.out.print("                                 │");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│ ");
					if (jamjaeAdd) {
						System.out.print(jamjaeAddSet[1]);
						posTotal = jamjaeAddSet[1].equals("") ? 0
								: (jamjaeAddSet[1].length() + jamjaeAddSet[1].getBytes().length) / 2;
						for (int i = posTotal; i < 32; i++) {
							System.out.print(" ");
						}
						System.out.print(" │");
					} else {
						System.out.print("                                 │");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│ ");
					if (jamjaeAdd) {
						System.out.print(jamjaeAddSet[2]);
						posTotal = jamjaeAddSet[2].equals("") ? 0
								: (jamjaeAddSet[2].length() + jamjaeAddSet[2].getBytes().length) / 2;
						for (int i = posTotal; i < 32; i++) {
							System.out.print(" ");
						}
						System.out.print(" │");
					} else {
						System.out.print("                                 │");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("└──────────────────────────────────┘");
					System.out.println(" ┃");
					// 등급 업 판정
					boolean jamjaeAddLevUp = false;
					if (jamjaeAddLev == 0) {
						jamjaeAddLev++;
						jamjaeAddLevUp = true;
					}
					if (jamjaeAddLev == 3) {
						int rdNum = rd.nextInt(100000000);
						if (rdNum % 1000 < 7 || cntToLegendAdd == cntToLegendAddSet) {
							jamjaeAddLev++;
							jamjaeAddLevUp = true;
							cntToLegendAdd++;
						} else {
							cntToLegendAdd++;
						}
					}
					if (jamjaeAddLev == 2) {
						int rdNum = rd.nextInt(100000000);
						if (rdNum % 1000000 < 9804 || cntToUniqueAdd == cntToUniqueAddSet) {
							jamjaeAddLev++;
							cntToUniqueAdd++;
							jamjaeAddLevUp = true;
						} else {
							cntToUniqueAdd++;
						}
					}
					if (jamjaeAddLev == 1) {
						int rdNum = rd.nextInt(100000000);
						if (rdNum % 100000 < 2381 || cntToEpicAdd == cntToEpicAddSet) {
							jamjaeAddLev++;
							cntToEpicAdd++;
							jamjaeAddLevUp = true;
						} else {
							cntToEpicAdd++;
						}
					}
					String jamjaeAdd1Temp = "";
					String jamjaeAdd2Temp = "";
					String jamjaeAdd3Temp = "";
					// 1번 잠재추출
					if (jamjaeAddLev == 1) {
						// 레어
						// 5.8824 => 10개0~8,21
						// 3.9216 => 9개9~16,19
						// 1.9608 => 3개 17,18,20
						int rdNum = rd.nextInt(1000000);
						if (rdNum < 588240) {
							switch (rdNum % 10) {
							case 0:
								jamjaeAdd1Temp = jamjaeAddRare[0];
								break;
							case 1:
								jamjaeAdd1Temp = jamjaeAddRare[1];
								break;
							case 2:
								jamjaeAdd1Temp = jamjaeAddRare[2];
								break;
							case 3:
								jamjaeAdd1Temp = jamjaeAddRare[3];
								break;
							case 4:
								jamjaeAdd1Temp = jamjaeAddRare[4];
								break;
							case 5:
								jamjaeAdd1Temp = jamjaeAddRare[5];
								break;
							case 6:
								jamjaeAdd1Temp = jamjaeAddRare[6];
								break;
							case 7:
								jamjaeAdd1Temp = jamjaeAddRare[7];
								break;
							case 8:
								jamjaeAdd1Temp = jamjaeAddRare[8];
								break;
							case 9:
								jamjaeAdd1Temp = jamjaeAddRare[21];
								break;
							}
						} else if (rdNum < 647064) {
							switch (rdNum % 3) {
							case 0:
								jamjaeAdd1Temp = jamjaeAddRare[17];
								break;
							case 1:
								jamjaeAdd1Temp = jamjaeAddRare[18];
								break;
							case 2:
								jamjaeAdd1Temp = jamjaeAddRare[20];
								break;
							}
						} else {
							switch (rdNum % 9) {
							case 0:
								jamjaeAdd1Temp = jamjaeAddRare[9];
								break;
							case 1:
								jamjaeAdd1Temp = jamjaeAddRare[10];
								break;
							case 2:
								jamjaeAdd1Temp = jamjaeAddRare[11];
								break;
							case 3:
								jamjaeAdd1Temp = jamjaeAddRare[12];
								break;
							case 4:
								jamjaeAdd1Temp = jamjaeAddRare[13];
								break;
							case 5:
								jamjaeAdd1Temp = jamjaeAddRare[14];
								break;
							case 6:
								jamjaeAdd1Temp = jamjaeAddRare[15];
								break;
							case 7:
								jamjaeAdd1Temp = jamjaeAddRare[16];
								break;
							case 8:
								jamjaeAdd1Temp = jamjaeAddRare[19];
								break;
							}
						}
					} else if (jamjaeAddLev == 2) {
						// 에픽
						// 8.8235 =>0,1,5,6,7,8,11,12
						// 5.8824 =>2,3,10,13
						// 2.9412 =>4,9
						int rdNum = rd.nextInt(1000000);
						if (rdNum < 705880) {
							switch (rdNum % 8) {
							case 0:
								jamjaeAdd1Temp = jamjaeAddEpic[0];
								break;
							case 1:
								jamjaeAdd1Temp = jamjaeAddEpic[1];
								break;
							case 2:
								jamjaeAdd1Temp = jamjaeAddEpic[5];
								break;
							case 3:
								jamjaeAdd1Temp = jamjaeAddEpic[6];
								break;
							case 4:
								jamjaeAdd1Temp = jamjaeAddEpic[7];
								break;
							case 5:
								jamjaeAdd1Temp = jamjaeAddEpic[8];
								break;
							case 6:
								jamjaeAdd1Temp = jamjaeAddEpic[11];
								break;
							case 7:
								jamjaeAdd1Temp = jamjaeAddEpic[12];
								break;
							}
						} else if (rdNum < 941176) {
							switch (rdNum % 4) {
							case 0:
								jamjaeAdd1Temp = jamjaeAddEpic[2];
								break;
							case 1:
								jamjaeAdd1Temp = jamjaeAddEpic[3];
								break;
							case 2:
								jamjaeAdd1Temp = jamjaeAddEpic[10];
								break;
							case 3:
								jamjaeAdd1Temp = jamjaeAddEpic[13];
								break;
							}
						} else {
							switch (rdNum % 2) {
							case 0:
								jamjaeAdd1Temp = jamjaeAddEpic[4];
								break;
							case 1:
								jamjaeAdd1Temp = jamjaeAddEpic[9];
								break;
							}
						}
					} else if (jamjaeAddLev == 3) {
						// 유니크!
						// 6.9767% => 0,1,5,6,7,8,15,16
						// 4.6512 => 2,3,4,10,11,12,13,14
						// 2.3256% => 9,17,18
						int rdNum = rd.nextInt(1000000);
						if (rdNum < 558136) {
							switch (rdNum % 8) {
							case 0:
								jamjaeAdd1Temp = jamjaeAddUnique[0];
								break;
							case 1:
								jamjaeAdd1Temp = jamjaeAddUnique[1];
								break;
							case 2:
								jamjaeAdd1Temp = jamjaeAddUnique[5];
								break;
							case 3:
								jamjaeAdd1Temp = jamjaeAddUnique[6];
								break;
							case 4:
								jamjaeAdd1Temp = jamjaeAddUnique[7];
								break;
							case 5:
								jamjaeAdd1Temp = jamjaeAddUnique[8];
								break;
							case 6:
								jamjaeAdd1Temp = jamjaeAddUnique[15];
								break;
							case 7:
								jamjaeAdd1Temp = jamjaeAddUnique[16];
								break;
							}
						} else if (rdNum < 930232) {
							switch (rdNum % 8) {
							case 0:
								jamjaeAdd1Temp = jamjaeAddUnique[2];
								break;
							case 1:
								jamjaeAdd1Temp = jamjaeAddUnique[3];
								break;
							case 2:
								jamjaeAdd1Temp = jamjaeAddUnique[4];
								break;
							case 3:
								jamjaeAdd1Temp = jamjaeAddUnique[10];
								break;
							case 4:
								jamjaeAdd1Temp = jamjaeAddUnique[11];
								break;
							case 5:
								jamjaeAdd1Temp = jamjaeAddUnique[12];
								break;
							case 6:
								jamjaeAdd1Temp = jamjaeAddUnique[13];
								break;
							case 7:
								jamjaeAdd1Temp = jamjaeAddUnique[14];
								break;
							}
						} else {
							switch (rdNum % 3) {
							case 0:
								jamjaeAdd1Temp = jamjaeAddUnique[9];
								break;
							case 1:
								jamjaeAdd1Temp = jamjaeAddUnique[17];
								break;
							case 2:
								jamjaeAdd1Temp = jamjaeAddUnique[18];
								break;
							}
						}
					} else if (jamjaeAddLev == 4) {
						// 레전!
						// 7.6923 => 0,1,5,6,7,8,
						// 5.1282 => 2,3,4,10,11,12,13,14
						// 2.5641 => 9,15,16,17,18
						int rdNum = rd.nextInt(1000000);
						if (rdNum < 461538) {
							switch (rdNum % 6) {
							case 0:
								jamjaeAdd1Temp = jamjaeAddLegend[0];
								break;
							case 1:
								jamjaeAdd1Temp = jamjaeAddLegend[1];
								break;
							case 2:
								jamjaeAdd1Temp = jamjaeAddLegend[5];
								break;
							case 3:
								jamjaeAdd1Temp = jamjaeAddLegend[6];
								break;
							case 4:
								jamjaeAdd1Temp = jamjaeAddLegend[7];
								break;
							case 5:
								jamjaeAdd1Temp = jamjaeAddLegend[8];
								break;
							}
						} else if (rdNum < 871794) {
							switch (rdNum % 8) {
							case 0:
								jamjaeAdd1Temp = jamjaeAddLegend[2];
								break;
							case 1:
								jamjaeAdd1Temp = jamjaeAddLegend[3];
								break;
							case 2:
								jamjaeAdd1Temp = jamjaeAddLegend[4];
								break;
							case 3:
								jamjaeAdd1Temp = jamjaeAddLegend[10];
								break;
							case 4:
								jamjaeAdd1Temp = jamjaeAddLegend[11];
								break;
							case 5:
								jamjaeAdd1Temp = jamjaeAddLegend[12];
								break;
							case 6:
								jamjaeAdd1Temp = jamjaeAddLegend[13];
								break;
							case 7:
								jamjaeAdd1Temp = jamjaeAddLegend[14];
								break;
							}
						} else {
							switch (rdNum % 5) {
							case 0:
								jamjaeAdd1Temp = jamjaeAddLegend[9];
								break;
							case 1:
								jamjaeAdd1Temp = jamjaeAddLegend[15];
								break;
							case 2:
								jamjaeAdd1Temp = jamjaeAddLegend[16];
								break;
							case 3:
								jamjaeAdd1Temp = jamjaeAddLegend[17];
								break;
							case 4:
								jamjaeAdd1Temp = jamjaeAddLegend[18];
								break;
							}
						}

					}

					// 2번 잠재추출
					if (jamjaeAddLev == 1) {
						/// 레어
						// 5.8824 => 10개0~8,21
						// 3.9216 => 9개9~16,19
						// 1.9608 => 3개 17,18,20
						int rdNum = rd.nextInt(1000000);
						if (rdNum < 588240) {
							switch (rdNum % 10) {
							case 0:
								jamjaeAdd2Temp = jamjaeAddRare[0];
								break;
							case 1:
								jamjaeAdd2Temp = jamjaeAddRare[1];
								break;
							case 2:
								jamjaeAdd2Temp = jamjaeAddRare[2];
								break;
							case 3:
								jamjaeAdd2Temp = jamjaeAddRare[3];
								break;
							case 4:
								jamjaeAdd2Temp = jamjaeAddRare[4];
								break;
							case 5:
								jamjaeAdd2Temp = jamjaeAddRare[5];
								break;
							case 6:
								jamjaeAdd2Temp = jamjaeAddRare[6];
								break;
							case 7:
								jamjaeAdd2Temp = jamjaeAddRare[7];
								break;
							case 8:
								jamjaeAdd2Temp = jamjaeAddRare[8];
								break;
							case 9:
								jamjaeAdd2Temp = jamjaeAddRare[21];
								break;
							}
						} else if (rdNum < 647064) {
							switch (rdNum % 3) {
							case 0:
								jamjaeAdd2Temp = jamjaeAddRare[17];
								break;
							case 1:
								jamjaeAdd2Temp = jamjaeAddRare[18];
								break;
							case 2:
								jamjaeAdd2Temp = jamjaeAddRare[20];
								break;
							}
						} else {
							switch (rdNum % 9) {
							case 0:
								jamjaeAdd2Temp = jamjaeAddRare[9];
								break;
							case 1:
								jamjaeAdd2Temp = jamjaeAddRare[10];
								break;
							case 2:
								jamjaeAdd2Temp = jamjaeAddRare[11];
								break;
							case 3:
								jamjaeAdd2Temp = jamjaeAddRare[12];
								break;
							case 4:
								jamjaeAdd2Temp = jamjaeAddRare[13];
								break;
							case 5:
								jamjaeAdd2Temp = jamjaeAddRare[14];
								break;
							case 6:
								jamjaeAdd2Temp = jamjaeAddRare[15];
								break;
							case 7:
								jamjaeAdd2Temp = jamjaeAddRare[16];
								break;
							case 8:
								jamjaeAdd2Temp = jamjaeAddRare[19];
								break;
							}
						}
					} else if (jamjaeAddLev == 2) {
						int rdNum = rd.nextInt(10000000);
						if (rdNum % 1000000 < 47619) {
							// 에픽
							// 8.8235 =>0,1,5,6,7,8,11,12
							// 5.8824 =>2,3,10,13
							// 2.9412 =>4,9
							rdNum = rd.nextInt(1000000);
							if (rdNum < 705880) {
								switch (rdNum % 8) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddEpic[0];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddEpic[1];
									break;
								case 2:
									jamjaeAdd2Temp = jamjaeAddEpic[5];
									break;
								case 3:
									jamjaeAdd2Temp = jamjaeAddEpic[6];
									break;
								case 4:
									jamjaeAdd2Temp = jamjaeAddEpic[7];
									break;
								case 5:
									jamjaeAdd2Temp = jamjaeAddEpic[8];
									break;
								case 6:
									jamjaeAdd2Temp = jamjaeAddEpic[11];
									break;
								case 7:
									jamjaeAdd2Temp = jamjaeAddEpic[12];
									break;
								}
							} else if (rdNum < 941176) {
								switch (rdNum % 4) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddEpic[2];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddEpic[3];
									break;
								case 2:
									jamjaeAdd2Temp = jamjaeAddEpic[10];
									break;
								case 3:
									jamjaeAdd2Temp = jamjaeAddEpic[13];
									break;
								}
							} else {
								switch (rdNum % 2) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddEpic[4];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddEpic[9];
									break;
								}
							}
						} else {
							// 레어
							// 5.8824 => 10개0~8,21
							// 3.9216 => 9개9~16,19
							// 1.9608 => 3개 17,18,20
							rdNum = rd.nextInt(1000000);
							if (rdNum < 588240) {
								switch (rdNum % 10) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddRare[0];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddRare[1];
									break;
								case 2:
									jamjaeAdd2Temp = jamjaeAddRare[2];
									break;
								case 3:
									jamjaeAdd2Temp = jamjaeAddRare[3];
									break;
								case 4:
									jamjaeAdd2Temp = jamjaeAddRare[4];
									break;
								case 5:
									jamjaeAdd2Temp = jamjaeAddRare[5];
									break;
								case 6:
									jamjaeAdd2Temp = jamjaeAddRare[6];
									break;
								case 7:
									jamjaeAdd2Temp = jamjaeAddRare[7];
									break;
								case 8:
									jamjaeAdd2Temp = jamjaeAddRare[8];
									break;
								case 9:
									jamjaeAdd2Temp = jamjaeAddRare[21];
									break;
								}
							} else if (rdNum < 647064) {
								switch (rdNum % 3) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddRare[17];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddRare[18];
									break;
								case 2:
									jamjaeAdd2Temp = jamjaeAddRare[20];
									break;
								}
							} else {
								switch (rdNum % 9) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddRare[9];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddRare[10];
									break;
								case 2:
									jamjaeAdd2Temp = jamjaeAddRare[11];
									break;
								case 3:
									jamjaeAdd2Temp = jamjaeAddRare[12];
									break;
								case 4:
									jamjaeAdd2Temp = jamjaeAddRare[13];
									break;
								case 5:
									jamjaeAdd2Temp = jamjaeAddRare[14];
									break;
								case 6:
									jamjaeAdd2Temp = jamjaeAddRare[15];
									break;
								case 7:
									jamjaeAdd2Temp = jamjaeAddRare[16];
									break;
								case 8:
									jamjaeAdd2Temp = jamjaeAddRare[19];
									break;
								}
							}
						}

					} else if (jamjaeAddLev == 3) {
						int rdNum = rd.nextInt(10000000);
						if (rdNum % 1000000 < 19608) {
							// 유니크
							// 6.9767% => 0,1,5,6,7,8,15,16
							// 4.6512 => 2,3,4,10,11,12,13,14
							// 2.3256% => 9,17,18
							rdNum = rd.nextInt(1000000);
							if (rdNum < 558136) {
								switch (rdNum % 8) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddUnique[0];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddUnique[1];
									break;
								case 2:
									jamjaeAdd2Temp = jamjaeAddUnique[5];
									break;
								case 3:
									jamjaeAdd2Temp = jamjaeAddUnique[6];
									break;
								case 4:
									jamjaeAdd2Temp = jamjaeAddUnique[7];
									break;
								case 5:
									jamjaeAdd2Temp = jamjaeAddUnique[8];
									break;
								case 6:
									jamjaeAdd2Temp = jamjaeAddUnique[15];
									break;
								case 7:
									jamjaeAdd2Temp = jamjaeAddUnique[16];
									break;
								}
							} else if (rdNum < 930232) {
								switch (rdNum % 8) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddUnique[2];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddUnique[3];
									break;
								case 2:
									jamjaeAdd2Temp = jamjaeAddUnique[4];
									break;
								case 3:
									jamjaeAdd2Temp = jamjaeAddUnique[10];
									break;
								case 4:
									jamjaeAdd2Temp = jamjaeAddUnique[11];
									break;
								case 5:
									jamjaeAdd2Temp = jamjaeAddUnique[12];
									break;
								case 6:
									jamjaeAdd2Temp = jamjaeAddUnique[13];
									break;
								case 7:
									jamjaeAdd2Temp = jamjaeAddUnique[14];
									break;
								}
							} else {
								switch (rdNum % 3) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddUnique[9];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddUnique[17];
									break;
								case 2:
									jamjaeAdd2Temp = jamjaeAddUnique[18];
									break;
								}
							}
						} else {
							// 에픽
							// 8.8235 =>0,1,5,6,7,8,11,12
							// 5.8824 =>2,3,10,13
							// 2.9412 =>4,9
							rdNum = rd.nextInt(1000000);
							if (rdNum < 705880) {
								switch (rdNum % 8) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddEpic[0];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddEpic[1];
									break;
								case 2:
									jamjaeAdd2Temp = jamjaeAddEpic[5];
									break;
								case 3:
									jamjaeAdd2Temp = jamjaeAddEpic[6];
									break;
								case 4:
									jamjaeAdd2Temp = jamjaeAddEpic[7];
									break;
								case 5:
									jamjaeAdd2Temp = jamjaeAddEpic[8];
									break;
								case 6:
									jamjaeAdd2Temp = jamjaeAddEpic[11];
									break;
								case 7:
									jamjaeAdd2Temp = jamjaeAddEpic[12];
									break;
								}
							} else if (rdNum < 941176) {
								switch (rdNum % 4) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddEpic[2];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddEpic[3];
									break;
								case 2:
									jamjaeAdd2Temp = jamjaeAddEpic[10];
									break;
								case 3:
									jamjaeAdd2Temp = jamjaeAddEpic[13];
									break;
								}
							} else {
								switch (rdNum % 2) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddEpic[4];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddEpic[9];
									break;
								}
							}
						}
					} else if (jamjaeAddLev == 4) {
						int rdNum = rd.nextInt(10000000);
						if (rdNum % 1000000 < 4975) {
							// 레전
							// 7.6923 => 0,1,5,6,7,8,
							// 5.1282 => 2,3,4,10,11,12,13,14
							// 2.5641 => 9,15,16,17,18
							rdNum = rd.nextInt(1000000);
							if (rdNum < 461538) {
								switch (rdNum % 6) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddLegend[0];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddLegend[1];
									break;
								case 2:
									jamjaeAdd2Temp = jamjaeAddLegend[5];
									break;
								case 3:
									jamjaeAdd2Temp = jamjaeAddLegend[6];
									break;
								case 4:
									jamjaeAdd2Temp = jamjaeAddLegend[7];
									break;
								case 5:
									jamjaeAdd2Temp = jamjaeAddLegend[8];
									break;
								}
							} else if (rdNum < 871794) {
								switch (rdNum % 8) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddLegend[2];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddLegend[3];
									break;
								case 2:
									jamjaeAdd2Temp = jamjaeAddLegend[4];
									break;
								case 3:
									jamjaeAdd2Temp = jamjaeAddLegend[10];
									break;
								case 4:
									jamjaeAdd2Temp = jamjaeAddLegend[11];
									break;
								case 5:
									jamjaeAdd2Temp = jamjaeAddLegend[12];
									break;
								case 6:
									jamjaeAdd2Temp = jamjaeAddLegend[13];
									break;
								case 7:
									jamjaeAdd2Temp = jamjaeAddLegend[14];
									break;
								}
							} else {
								switch (rdNum % 5) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddLegend[9];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddLegend[15];
									break;
								case 2:
									jamjaeAdd2Temp = jamjaeAddLegend[16];
									break;
								case 3:
									jamjaeAdd2Temp = jamjaeAddLegend[17];
									break;
								case 4:
									jamjaeAdd2Temp = jamjaeAddLegend[18];
									break;
								}
							}
						} else {
							// 유니크
							// 6.9767% => 0,1,5,6,7,8,15,16
							// 4.6512 => 2,3,4,10,11,12,13,14
							// 2.3256% => 9,17,18
							rdNum = rd.nextInt(1000000);
							if (rdNum < 558136) {
								switch (rdNum % 8) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddUnique[0];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddUnique[1];
									break;
								case 2:
									jamjaeAdd2Temp = jamjaeAddUnique[5];
									break;
								case 3:
									jamjaeAdd2Temp = jamjaeAddUnique[6];
									break;
								case 4:
									jamjaeAdd2Temp = jamjaeAddUnique[7];
									break;
								case 5:
									jamjaeAdd2Temp = jamjaeAddUnique[8];
									break;
								case 6:
									jamjaeAdd2Temp = jamjaeAddUnique[15];
									break;
								case 7:
									jamjaeAdd2Temp = jamjaeAddUnique[16];
									break;
								}
							} else if (rdNum < 930232) {
								switch (rdNum % 8) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddUnique[2];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddUnique[3];
									break;
								case 2:
									jamjaeAdd2Temp = jamjaeAddUnique[4];
									break;
								case 3:
									jamjaeAdd2Temp = jamjaeAddUnique[10];
									break;
								case 4:
									jamjaeAdd2Temp = jamjaeAddUnique[11];
									break;
								case 5:
									jamjaeAdd2Temp = jamjaeAddUnique[12];
									break;
								case 6:
									jamjaeAdd2Temp = jamjaeAddUnique[13];
									break;
								case 7:
									jamjaeAdd2Temp = jamjaeAddUnique[14];
									break;
								}
							} else {
								switch (rdNum % 3) {
								case 0:
									jamjaeAdd2Temp = jamjaeAddUnique[9];
									break;
								case 1:
									jamjaeAdd2Temp = jamjaeAddUnique[17];
									break;
								case 2:
									jamjaeAdd2Temp = jamjaeAddUnique[18];
									break;
								}
							}
						}

					}
					// 3번 잠재추출
					if (jamjaeAddLev == 1) {
						/// 레어
						// 5.8824 => 10개0~8,21
						// 3.9216 => 9개9~16,19
						// 1.9608 => 3개 17,18,20
						int rdNum = rd.nextInt(1000000);
						if (rdNum < 588240) {
							switch (rdNum % 10) {
							case 0:
								jamjaeAdd3Temp = jamjaeAddRare[0];
								break;
							case 1:
								jamjaeAdd3Temp = jamjaeAddRare[1];
								break;
							case 2:
								jamjaeAdd3Temp = jamjaeAddRare[2];
								break;
							case 3:
								jamjaeAdd3Temp = jamjaeAddRare[3];
								break;
							case 4:
								jamjaeAdd3Temp = jamjaeAddRare[4];
								break;
							case 5:
								jamjaeAdd3Temp = jamjaeAddRare[5];
								break;
							case 6:
								jamjaeAdd3Temp = jamjaeAddRare[6];
								break;
							case 7:
								jamjaeAdd3Temp = jamjaeAddRare[7];
								break;
							case 8:
								jamjaeAdd3Temp = jamjaeAddRare[8];
								break;
							case 9:
								jamjaeAdd3Temp = jamjaeAddRare[21];
								break;
							}
						} else if (rdNum < 647064) {
							switch (rdNum % 3) {
							case 0:
								jamjaeAdd3Temp = jamjaeAddRare[17];
								break;
							case 1:
								jamjaeAdd3Temp = jamjaeAddRare[18];
								break;
							case 2:
								jamjaeAdd3Temp = jamjaeAddRare[20];
								break;
							}
						} else {
							switch (rdNum % 9) {
							case 0:
								jamjaeAdd3Temp = jamjaeAddRare[9];
								break;
							case 1:
								jamjaeAdd3Temp = jamjaeAddRare[10];
								break;
							case 2:
								jamjaeAdd3Temp = jamjaeAddRare[11];
								break;
							case 3:
								jamjaeAdd3Temp = jamjaeAddRare[12];
								break;
							case 4:
								jamjaeAdd3Temp = jamjaeAddRare[13];
								break;
							case 5:
								jamjaeAdd3Temp = jamjaeAddRare[14];
								break;
							case 6:
								jamjaeAdd3Temp = jamjaeAddRare[15];
								break;
							case 7:
								jamjaeAdd3Temp = jamjaeAddRare[16];
								break;
							case 8:
								jamjaeAdd3Temp = jamjaeAddRare[19];
								break;
							}
						}
					} else if (jamjaeAddLev == 2) {
						int rdNum = rd.nextInt(10000000);
						if (rdNum % 1000000 < 47619) {
							// 에픽
							// 8.8235 =>0,1,5,6,7,8,11,12
							// 5.8824 =>2,3,10,13
							// 2.9412 =>4,9
							rdNum = rd.nextInt(1000000);
							if (rdNum < 705880) {
								switch (rdNum % 8) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddEpic[0];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddEpic[1];
									break;
								case 2:
									jamjaeAdd3Temp = jamjaeAddEpic[5];
									break;
								case 3:
									jamjaeAdd3Temp = jamjaeAddEpic[6];
									break;
								case 4:
									jamjaeAdd3Temp = jamjaeAddEpic[7];
									break;
								case 5:
									jamjaeAdd3Temp = jamjaeAddEpic[8];
									break;
								case 6:
									jamjaeAdd3Temp = jamjaeAddEpic[11];
									break;
								case 7:
									jamjaeAdd3Temp = jamjaeAddEpic[12];
									break;
								}
							} else if (rdNum < 941176) {
								switch (rdNum % 4) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddEpic[2];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddEpic[3];
									break;
								case 2:
									jamjaeAdd3Temp = jamjaeAddEpic[10];
									break;
								case 3:
									jamjaeAdd3Temp = jamjaeAddEpic[13];
									break;
								}
							} else {
								switch (rdNum % 2) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddEpic[4];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddEpic[9];
									break;
								}
							}
						} else {
							// 레어
							// 5.8824 => 10개0~8,21
							// 3.9216 => 9개9~16,19
							// 1.9608 => 3개 17,18,20
							rdNum = rd.nextInt(1000000);
							if (rdNum < 588240) {
								switch (rdNum % 10) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddRare[0];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddRare[1];
									break;
								case 2:
									jamjaeAdd3Temp = jamjaeAddRare[2];
									break;
								case 3:
									jamjaeAdd3Temp = jamjaeAddRare[3];
									break;
								case 4:
									jamjaeAdd3Temp = jamjaeAddRare[4];
									break;
								case 5:
									jamjaeAdd3Temp = jamjaeAddRare[5];
									break;
								case 6:
									jamjaeAdd3Temp = jamjaeAddRare[6];
									break;
								case 7:
									jamjaeAdd3Temp = jamjaeAddRare[7];
									break;
								case 8:
									jamjaeAdd3Temp = jamjaeAddRare[8];
									break;
								case 9:
									jamjaeAdd3Temp = jamjaeAddRare[21];
									break;
								}
							} else if (rdNum < 647064) {
								switch (rdNum % 3) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddRare[17];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddRare[18];
									break;
								case 2:
									jamjaeAdd3Temp = jamjaeAddRare[20];
									break;
								}
							} else {
								switch (rdNum % 9) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddRare[9];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddRare[10];
									break;
								case 2:
									jamjaeAdd3Temp = jamjaeAddRare[11];
									break;
								case 3:
									jamjaeAdd3Temp = jamjaeAddRare[12];
									break;
								case 4:
									jamjaeAdd3Temp = jamjaeAddRare[13];
									break;
								case 5:
									jamjaeAdd3Temp = jamjaeAddRare[14];
									break;
								case 6:
									jamjaeAdd3Temp = jamjaeAddRare[15];
									break;
								case 7:
									jamjaeAdd3Temp = jamjaeAddRare[16];
									break;
								case 8:
									jamjaeAdd3Temp = jamjaeAddRare[19];
									break;
								}
							}
						}

					} else if (jamjaeAddLev == 3) {
						int rdNum = rd.nextInt(10000000);
						if (rdNum % 1000000 < 19608) {
							// 유니크
							// 6.9767% => 0,1,5,6,7,8,15,16
							// 4.6512 => 2,3,4,10,11,12,13,14
							// 2.3256% => 9,17,18
							rdNum = rd.nextInt(1000000);
							if (rdNum < 558136) {
								switch (rdNum % 8) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddUnique[0];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddUnique[1];
									break;
								case 2:
									jamjaeAdd3Temp = jamjaeAddUnique[5];
									break;
								case 3:
									jamjaeAdd3Temp = jamjaeAddUnique[6];
									break;
								case 4:
									jamjaeAdd3Temp = jamjaeAddUnique[7];
									break;
								case 5:
									jamjaeAdd3Temp = jamjaeAddUnique[8];
									break;
								case 6:
									jamjaeAdd3Temp = jamjaeAddUnique[15];
									break;
								case 7:
									jamjaeAdd3Temp = jamjaeAddUnique[16];
									break;
								}
							} else if (rdNum < 930232) {
								switch (rdNum % 8) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddUnique[2];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddUnique[3];
									break;
								case 2:
									jamjaeAdd3Temp = jamjaeAddUnique[4];
									break;
								case 3:
									jamjaeAdd3Temp = jamjaeAddUnique[10];
									break;
								case 4:
									jamjaeAdd3Temp = jamjaeAddUnique[11];
									break;
								case 5:
									jamjaeAdd3Temp = jamjaeAddUnique[12];
									break;
								case 6:
									jamjaeAdd3Temp = jamjaeAddUnique[13];
									break;
								case 7:
									jamjaeAdd3Temp = jamjaeAddUnique[14];
									break;
								}
							} else {
								switch (rdNum % 3) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddUnique[9];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddUnique[17];
									break;
								case 2:
									jamjaeAdd3Temp = jamjaeAddUnique[18];
									break;
								}
							}
						} else {
							// 에픽
							// 8.8235 =>0,1,5,6,7,8,11,12
							// 5.8824 =>2,3,10,13
							// 2.9412 =>4,9
							rdNum = rd.nextInt(1000000);
							if (rdNum < 705880) {
								switch (rdNum % 8) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddEpic[0];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddEpic[1];
									break;
								case 2:
									jamjaeAdd3Temp = jamjaeAddEpic[5];
									break;
								case 3:
									jamjaeAdd3Temp = jamjaeAddEpic[6];
									break;
								case 4:
									jamjaeAdd3Temp = jamjaeAddEpic[7];
									break;
								case 5:
									jamjaeAdd3Temp = jamjaeAddEpic[8];
									break;
								case 6:
									jamjaeAdd3Temp = jamjaeAddEpic[11];
									break;
								case 7:
									jamjaeAdd3Temp = jamjaeAddEpic[12];
									break;
								}
							} else if (rdNum < 941176) {
								switch (rdNum % 4) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddEpic[2];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddEpic[3];
									break;
								case 2:
									jamjaeAdd3Temp = jamjaeAddEpic[10];
									break;
								case 3:
									jamjaeAdd3Temp = jamjaeAddEpic[13];
									break;
								}
							} else {
								switch (rdNum % 2) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddEpic[4];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddEpic[9];
									break;
								}
							}
						}
					} else if (jamjaeAddLev == 4) {
						int rdNum = rd.nextInt(10000000);
						if (rdNum % 1000000 < 4975) {
							// 레전
							// 7.6923 => 0,1,5,6,7,8,
							// 5.1282 => 2,3,4,10,11,12,13,14
							// 2.5641 => 9,15,16,17,18
							rdNum = rd.nextInt(1000000);
							if (rdNum < 461538) {
								switch (rdNum % 6) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddLegend[0];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddLegend[1];
									break;
								case 2:
									jamjaeAdd3Temp = jamjaeAddLegend[5];
									break;
								case 3:
									jamjaeAdd3Temp = jamjaeAddLegend[6];
									break;
								case 4:
									jamjaeAdd3Temp = jamjaeAddLegend[7];
									break;
								case 5:
									jamjaeAdd3Temp = jamjaeAddLegend[8];
									break;
								}
							} else if (rdNum < 871794) {
								switch (rdNum % 8) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddLegend[2];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddLegend[3];
									break;
								case 2:
									jamjaeAdd3Temp = jamjaeAddLegend[4];
									break;
								case 3:
									jamjaeAdd3Temp = jamjaeAddLegend[10];
									break;
								case 4:
									jamjaeAdd3Temp = jamjaeAddLegend[11];
									break;
								case 5:
									jamjaeAdd3Temp = jamjaeAddLegend[12];
									break;
								case 6:
									jamjaeAdd3Temp = jamjaeAddLegend[13];
									break;
								case 7:
									jamjaeAdd3Temp = jamjaeAddLegend[14];
									break;
								}
							} else {
								switch (rdNum % 5) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddLegend[9];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddLegend[15];
									break;
								case 2:
									jamjaeAdd3Temp = jamjaeAddLegend[16];
									break;
								case 3:
									jamjaeAdd3Temp = jamjaeAddLegend[17];
									break;
								case 4:
									jamjaeAdd3Temp = jamjaeAddLegend[18];
									break;
								}
							}
						} else {
							// 유니크
							// 6.9767% => 0,1,5,6,7,8,15,16
							// 4.6512 => 2,3,4,10,11,12,13,14
							// 2.3256% => 9,17,18
							rdNum = rd.nextInt(1000000);
							if (rdNum < 558136) {
								switch (rdNum % 8) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddUnique[0];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddUnique[1];
									break;
								case 2:
									jamjaeAdd3Temp = jamjaeAddUnique[5];
									break;
								case 3:
									jamjaeAdd3Temp = jamjaeAddUnique[6];
									break;
								case 4:
									jamjaeAdd3Temp = jamjaeAddUnique[7];
									break;
								case 5:
									jamjaeAdd3Temp = jamjaeAddUnique[8];
									break;
								case 6:
									jamjaeAdd3Temp = jamjaeAddUnique[15];
									break;
								case 7:
									jamjaeAdd3Temp = jamjaeAddUnique[16];
									break;
								}
							} else if (rdNum < 930232) {
								switch (rdNum % 8) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddUnique[2];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddUnique[3];
									break;
								case 2:
									jamjaeAdd3Temp = jamjaeAddUnique[4];
									break;
								case 3:
									jamjaeAdd3Temp = jamjaeAddUnique[10];
									break;
								case 4:
									jamjaeAdd3Temp = jamjaeAddUnique[11];
									break;
								case 5:
									jamjaeAdd3Temp = jamjaeAddUnique[12];
									break;
								case 6:
									jamjaeAdd3Temp = jamjaeAddUnique[13];
									break;
								case 7:
									jamjaeAdd3Temp = jamjaeAddUnique[14];
									break;
								}
							} else {
								switch (rdNum % 3) {
								case 0:
									jamjaeAdd3Temp = jamjaeAddUnique[9];
									break;
								case 1:
									jamjaeAdd3Temp = jamjaeAddUnique[17];
									break;
								case 2:
									jamjaeAdd3Temp = jamjaeAddUnique[18];
									break;
								}
							}
						}

					}
					System.out.print("┃ ");
					System.out.print("┌──────────────────────────────────┐");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│             변경 옵션            │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├──────────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│ ");
					if (jamjaeAdd) {
						posTotal = (jamjaes[jamjaeAddLev].length() + jamjaes[jamjaeAddLev].getBytes().length) / 2;
						for (int i = 0; i < 16 - posTotal / 2; i++) {
							System.out.print(" ");
						}
						System.out.print(jamjaes[jamjaeAddLev]);
						for (int i = 16 + posTotal / 2; i < 32; i++) {
							System.out.print(" ");
						}
						System.out.print(posTotal % 2 == 1 ? "│" : " │");
					} else {
						System.out.print("                                 │");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├──────────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│ ");
					if (jamjaeAdd) {
						System.out.print(jamjaeAdd1Temp);
						posTotal = (jamjaeAdd1Temp.length() + jamjaeAdd1Temp.getBytes().length) / 2;
						for (int i = posTotal; i < 32; i++) {
							System.out.print(" ");
						}
						System.out.print(" │");
					} else {
						System.out.print("                                 │");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│ ");
					if (jamjaeAdd) {
						System.out.print(jamjaeAdd2Temp);
						posTotal = (jamjaeAdd2Temp.length() + jamjaeAdd2Temp.getBytes().length) / 2;
						for (int i = posTotal; i < 32; i++) {
							System.out.print(" ");
						}
						System.out.print(" │");
					} else {
						System.out.print("                                 │");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│ ");
					if (jamjaeAdd) {
						System.out.print(jamjaeAdd3Temp);
						posTotal = (jamjaeAdd3Temp.length() + jamjaeAdd3Temp.getBytes().length) / 2;
						for (int i = posTotal; i < 32; i++) {
							System.out.print(" ");
						}
						System.out.print(" │");
					} else {
						System.out.print("                                 │");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("└──────────────────────────────────┘");
					System.out.println(" ┃");
					System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
					if (jamjaeAddLevUp) {
						System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
						System.out.print("┃ ");
						System.out.print("             등급 상승              ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("                                    ");
						System.out.println(" ┃");
						System.out.print("┃ ");
						System.out.print("              1. 확인               ");
						System.out.println(" ┃");
						System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
						System.out.print("확인 >> ");
						jamjaeAddSet[0] = jamjaeAdd1Temp;
						jamjaeAddSet[1] = jamjaeAdd2Temp;
						jamjaeAddSet[2] = jamjaeAdd3Temp;
						int check = sc.nextInt();
						System.out.println();
						continue;
					}
					System.out.println("1. 옵션 적용 >> ");
					System.out.print("옵션 돌리기 (0. 큐브 강화 종료) >> ");
					System.out.println();
					mesoJamjaeAdd += jamjaeAddLev == 0 ? 18000000
							: jamjaeAddLev == 1 ? 50400000 : jamjaeAddLev == 2 ? 61200000 : 72000000;
					cntOpDown++;
					int jamjaeAddSel = sc.nextInt();
					if (jamjaeAddSel == 0) {
						System.out.println("큐브 강화 종료");
						break;
					}
					if (jamjaeAddSel == 1) {
						jamjaeAddSet[0] = jamjaeAdd1Temp;
						jamjaeAddSet[1] = jamjaeAdd2Temp;
						jamjaeAddSet[2] = jamjaeAdd3Temp;
					}

				}

			} else if (sel == 5) {
				while (true) {
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
					System.out.println("공격 시 10% 확률로 6레벨 중독효과 적용");
					System.out.print("┃ ");
					System.out.print("┌──────────────────────────────────┐");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│          추가 옵션 강화          │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("└──────────────────────────────────┘");
					System.out.println(" ┃");
					System.out.print("┃             ");
					System.out.print("┌──────────┐");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("      ／");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("    ／  ");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("／＼    ");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("／／    ");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("└──────────┘");
					System.out.println("             ┃");
					System.out.print("┃ ");
					System.out.print("┌─────┬────────────────────────────┐");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│  1  │     강력한 환생의 불꽃     │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├─────┼────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│  2  │     영원한 환생의 불꽃     │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├─────┼────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│  3  │      검은 환생의 불꽃      │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├─────┼────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│  4  │     심연의 환생의 불꽃     │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("└─────┴────────────────────────────┘");
					System.out.println(" ┃");
					System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
					System.out.print("환생의 불꽃 선택 (0. 종료) >> ");
					System.out.println();
					int fire = sc.nextInt();
					if (fire == 0) {
						System.out.println("추가 옵션 강화 종료");
						break;
					}

					if (fire == 1 || fire == 2) {
						lev[0] += lev[2];
						str[0] -= str[2];
						dex[0] -= dex[2];
						Int[0] -= Int[2];
						luk[0] -= luk[2];
						hp[0] -= hp[2];
						mp[0] -= mp[2];
						def[0] -= def[2];
						power[0] -= power[2];
						magicPower[0] -= magicPower[2];
						bossDmg[0] -= bossDmg[2];
						dmg[0] -= dmg[2];
						allSta[0] -= allSta[2];
						while (true) {
							lev[2] = 0;
							str[2] = 0;
							dex[2] = 0;
							Int[2] = 0;
							luk[2] = 0;
							hp[2] = 0;
							mp[2] = 0;
							def[2] = 0;
							power[2] = 0;
							magicPower[2] = 0;
							bossDmg[2] = 0;
							dmg[2] = 0;
							allSta[2] = 0;
							int set = -1;
							int rdNum = rd.nextInt(1000000);
							if (rdNum % 100 < 40) {
								set = 1;
							} else if (rdNum % 100 < 80) {
								set = 2;
							} else if (rdNum % 100 < 96) {
								set = 3;
							} else {
								set = 4;
							}
							int[] stat = new int[set];
							for (int i = 0; i < stat.length; i++) {
								rdNum = rd.nextInt(1900000);
								stat[i] = rdNum % 19;
								for (int k = 0; k < i; k++) {
									if (stat[i] == stat[k]) {
										i--;
										break;
									}
								}
							}
							int[] option = new int[stat.length];
							for (int i = 0; i < stat.length; i++) {
								int chu = -1;
								rdNum = rd.nextInt(1000000);
								if (fire == 1) {
									if (rdNum % 100 < 14) {
										chu = 1;
									} else if (rdNum % 100 < 50) {
										chu = 2;
									} else if (rdNum % 100 < 80) {
										chu = 3;
									} else {
										chu = 4;
									}
									option[i] = chu;
								} else if (fire == 2) {
									if (rdNum % 100 < 1) {
										chu = 0;
									} else if (rdNum % 100 < 26) {
										chu = 1;
									} else if (rdNum % 100 < 71) {
										chu = 2;
									} else {
										chu = 3;
									}
									option[i] = chu;
								}
							}
							for (int i = 0; i < stat.length; i++) {
								switch (stat[i]) {
								case 0:
									lev[2] += levAdd[option[i]];
									break;
								case 1:
									str[2] += strAdd[option[i]];
									break;
								case 2:
									dex[2] += dexAdd[option[i]];
									break;
								case 3:
									Int[2] += IntAdd[option[i]];
									break;
								case 4:
									luk[2] += lukAdd[option[i]];
									break;
								case 5:
									str[2] += strDexAdd[option[i]];
									dex[2] += strDexAdd[option[i]];
									break;
								case 6:
									dex[2] += dexIntAdd[option[i]];
									Int[2] += dexIntAdd[option[i]];
									break;
								case 7:
									Int[2] += IntLukAdd[option[i]];
									luk[2] += IntLukAdd[option[i]];
									break;
								case 8:
									str[2] += lukStrAdd[option[i]];
									luk[2] += lukStrAdd[option[i]];
									break;
								case 9:
									str[2] += strIntAdd[option[i]];
									Int[2] += strIntAdd[option[i]];
									break;
								case 10:
									dex[2] += dexLukAdd[option[i]];
									luk[2] += dexLukAdd[option[i]];
									break;
								case 11:
									hp[2] += hpAdd[option[i]];
									break;
								case 12:
									mp[2] += mpAdd[option[i]];
									break;
								case 13:
									def[2] += defAdd[option[i]];
									break;
								case 14:
									power[2] += powerAdd[option[i]];
									break;
								case 15:
									magicPower[2] += magicPowerAdd[option[i]];
									break;
								case 16:
									bossDmg[2] += bossDmgAdd[option[i]];
									break;
								case 17:
									dmg[2] += dmgAdd[option[i]];
									break;
								case 18:
									allSta[2] += allStaAdd[option[i]];
									break;
								}
							}

							System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
							System.out.print("┃ ");
							System.out.print("┌──────────────────────────────────┐");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("│          추가 옵션 강화          │");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("└──────────────────────────────────┘");
							System.out.println(" ┃");
							System.out.print("┃             ");
							System.out.print("┌──────────┐");
							System.out.println("             ┃");
							System.out.print("┃             ");
							System.out.print("│ ");
							System.out.print("      ／");
							System.out.print(" │");
							System.out.println("             ┃");
							System.out.print("┃             ");
							System.out.print("│ ");
							System.out.print("    ／  ");
							System.out.print(" │");
							System.out.println("             ┃");
							System.out.print("┃             ");
							System.out.print("│ ");
							System.out.print("／＼    ");
							System.out.print(" │");
							System.out.println("             ┃");
							System.out.print("┃             ");
							System.out.print("│ ");
							System.out.print("／／    ");
							System.out.print(" │");
							System.out.println("             ┃");
							System.out.print("┃             ");
							System.out.print("└──────────┘");
							System.out.println("             ┃");
							System.out.print("┃ ");
							System.out.print("┌──────────────────────────────────┐");
							System.out.println(" ┃");
							int chuCnt = 0;
							if (str[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "STR : ";
								str2 = "+" + str[2];
								str1 += str2;
								posText = 0;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (dex[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "DEX : ";
								str2 = "+" + dex[2];
								str1 += str2;
								posText = 0;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (Int[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "INT : ";
								str2 = "+" + Int[2];
								str1 += str2;
								posText = 0;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (luk[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "LUK : ";
								str2 = "+" + luk[2];
								str1 += str2;
								posText = 0;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (hp[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "최대 HP : ";
								str2 = "+" + hp[2];
								str1 += str2;
								posText = 2;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (mp[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "최대 MP : ";
								str2 = "+" + mp[2];
								str1 += str2;
								posText = 2;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (def[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "방어력 : ";
								str2 = "+" + def[2];
								str1 += str2;
								posText = 3;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (power[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "공격력 : ";
								str2 = "+" + power[2];
								str1 += str2;
								posText = 3;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (magicPower[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "마력 : ";
								str2 = "+" + magicPower[2];
								str1 += str2;
								posText = 2;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (bossDmg[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "보스 공격 시 데미지 : ";
								str2 = "+" + bossDmg[2] + "%";
								str1 += str2;
								posText = 8;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (dmg[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "데미지 : ";
								str2 = "+" + dmg[2] + "%";
								str1 += str2;
								posText = 3;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (allSta[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "올스텟 : ";
								str2 = "+" + allSta[2] + "%";
								str1 += str2;
								posText = 3;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (lev[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "착용 레벨 감소 : ";
								str2 = "-" + lev[2];
								str1 += str2;
								posText = 6;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							for (int i = chuCnt; i < 8; i++) {
								System.out.print("┃ ");
								System.out.print("│                                  │");
								System.out.println(" ┃");
							}
							System.out.print("┃ ");
							System.out.print("└──────────────────────────────────┘");
							System.out.println(" ┃");
							System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
							System.out.print("옵션 돌리기 (0. 불꽃 변경) >> ");
							System.out.println();
							mesoAdd += fire == 1 ? 4999999 : 78888888;
							cntAdd++;
							isChange = true;
							int add = sc.nextInt();
							if (add == 0) {
								System.out.println("불꽃 선택");
								break;
							}
						}

					} else if (fire == 3 || fire == 4) {
						while (true) {
							System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
							System.out.print("┃ ");
							System.out.print("┌──────────────────────────────────┐");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("│          추가 옵션 강화          │");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("└──────────────────────────────────┘");
							System.out.println(" ┃");
							System.out.print("┃             ");
							System.out.print("┌──────────┐");
							System.out.println("             ┃");
							System.out.print("┃             ");
							System.out.print("│ ");
							System.out.print("      ／");
							System.out.print(" │");
							System.out.println("             ┃");
							System.out.print("┃             ");
							System.out.print("│ ");
							System.out.print("    ／  ");
							System.out.print(" │");
							System.out.println("             ┃");
							System.out.print("┃             ");
							System.out.print("│ ");
							System.out.print("／＼    ");
							System.out.print(" │");
							System.out.println("             ┃");
							System.out.print("┃             ");
							System.out.print("│ ");
							System.out.print("／／    ");
							System.out.print(" │");
							System.out.println("             ┃");
							System.out.print("┃             ");
							System.out.print("└──────────┘");
							System.out.println("             ┃");
							System.out.print("┃ ");
							System.out.print("┌──────────────────────────────────┐");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("│             현재 옵션            │");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("├──────────────────────────────────┤");
							System.out.println(" ┃");
							int chuCnt = 0;
							if (str[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "STR : ";
								str2 = "+" + str[2];
								str1 += str2;
								posText = 0;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (dex[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "DEX : ";
								str2 = "+" + dex[2];
								str1 += str2;
								posText = 0;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (Int[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "INT : ";
								str2 = "+" + Int[2];
								str1 += str2;
								posText = 0;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (luk[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "LUK : ";
								str2 = "+" + luk[2];
								str1 += str2;
								posText = 0;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (hp[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "최대 HP : ";
								str2 = "+" + hp[2];
								str1 += str2;
								posText = 2;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (mp[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "최대 MP : ";
								str2 = "+" + mp[2];
								str1 += str2;
								posText = 2;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (def[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "방어력 : ";
								str2 = "+" + def[2];
								str1 += str2;
								posText = 3;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (power[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "공격력 : ";
								str2 = "+" + power[2];
								str1 += str2;
								posText = 3;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (magicPower[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "마력 : ";
								str2 = "+" + magicPower[2];
								str1 += str2;
								posText = 2;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (bossDmg[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "보스 공격 시 데미지 : ";
								str2 = "+" + bossDmg[2] + "%";
								str1 += str2;
								posText = 8;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (dmg[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "데미지 : ";
								str2 = "+" + dmg[2] + "%";
								str1 += str2;
								posText = 3;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (allSta[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "올스텟 : ";
								str2 = "+" + allSta[2] + "%";
								str1 += str2;
								posText = 3;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (lev[2] != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "착용 레벨 감소 : ";
								str2 = "-" + lev[2];
								str1 += str2;
								posText = 6;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							for (int i = chuCnt; i < 8; i++) {
								System.out.print("┃ ");
								System.out.print("│                                  │");
								System.out.println(" ┃");
							}
							System.out.print("┃ ");
							System.out.print("└──────────────────────────────────┘");
							System.out.println(" ┃");

							int set = -1;
							int rdNum = rd.nextInt(1000000);
							if (rdNum % 100 < 40) {
								set = 1;
							} else if (rdNum % 100 < 80) {
								set = 2;
							} else if (rdNum % 100 < 96) {
								set = 3;
							} else {
								set = 4;
							}
							int[] stat = new int[set];
							for (int i = 0; i < stat.length; i++) {
								rdNum = rd.nextInt(1900000);
								stat[i] = rdNum % 19;
								for (int k = 0; k < i; k++) {
									if (stat[i] == stat[k]) {
										i--;
										break;
									}
								}
							}
							int[] option = new int[stat.length];
							for (int i = 0; i < stat.length; i++) {
								int chu = -1;
								rdNum = rd.nextInt(1000000);
								if (fire == 3) {
									if (rdNum % 100 < 1) {
										chu = 0;
									} else if (rdNum % 100 < 26) {
										chu = 1;
									} else if (rdNum % 100 < 71) {
										chu = 2;
									} else {
										chu = 3;
									}
									option[i] = chu;
								} else if (fire == 4) {
									if (rdNum % 100 < 3) {
										chu = 0;
									} else if (rdNum % 100 < 37) {
										chu = 1;
									} else {
										chu = 2;
									}
									option[i] = chu;
								}
							}
							int levTemp = 0;
							int strTemp = 0;
							int dexTemp = 0;
							int IntTemp = 0;
							int lukTemp = 0;
							int hpTemp = 0;
							int mpTemp = 0;
							int defTemp = 0;
							int powerTemp = 0;
							int magicPowerTemp = 0;
							int bossDmgTemp = 0;
							int dmgTemp = 0;
							int allStaTemp = 0;
							for (int i = 0; i < stat.length; i++) {
								switch (stat[i]) {
								case 0:
									levTemp += levAdd[option[i]];
									break;
								case 1:
									strTemp += strAdd[option[i]];
									break;
								case 2:
									dexTemp += dexAdd[option[i]];
									break;
								case 3:
									IntTemp += IntAdd[option[i]];
									break;
								case 4:
									lukTemp += lukAdd[option[i]];
									break;
								case 5:
									strTemp += strDexAdd[option[i]];
									dexTemp += strDexAdd[option[i]];
									break;
								case 6:
									dexTemp += dexIntAdd[option[i]];
									IntTemp += dexIntAdd[option[i]];
									break;
								case 7:
									IntTemp += IntLukAdd[option[i]];
									lukTemp += IntLukAdd[option[i]];
									break;
								case 8:
									lukTemp += lukStrAdd[option[i]];
									strTemp += lukStrAdd[option[i]];
									break;
								case 9:
									strTemp += strIntAdd[option[i]];
									IntTemp += strIntAdd[option[i]];
									break;
								case 10:
									dexTemp += dexLukAdd[option[i]];
									lukTemp += dexLukAdd[option[i]];
									break;
								case 11:
									hpTemp += hpAdd[option[i]];
									break;
								case 12:
									mpTemp += mpAdd[option[i]];
									break;
								case 13:
									defTemp += defAdd[option[i]];
									break;
								case 14:
									powerTemp += powerAdd[option[i]];
									break;
								case 15:
									magicPowerTemp += magicPowerAdd[option[i]];
									break;
								case 16:
									bossDmgTemp += bossDmgAdd[option[i]];
									break;
								case 17:
									dmgTemp += dmgAdd[option[i]];
									break;
								case 18:
									allStaTemp += allStaAdd[option[i]];
									break;
								}
							}

							System.out.print("┃ ");
							System.out.print("┌──────────────────────────────────┐");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("│             변경 옵션            │");
							System.out.println(" ┃");
							System.out.print("┃ ");
							System.out.print("├──────────────────────────────────┤");
							System.out.println(" ┃");
							chuCnt = 0;
							if (strTemp != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "STR : ";
								str2 = "+" + strTemp;
								str1 += str2;
								posText = 0;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (dexTemp != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "DEX : ";
								str2 = "+" + dexTemp;
								str1 += str2;
								posText = 0;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (IntTemp != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "INT : ";
								str2 = "+" + IntTemp;
								str1 += str2;
								posText = 0;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (lukTemp != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "LUK : ";
								str2 = "+" + lukTemp;
								str1 += str2;
								posText = 0;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (hpTemp != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "최대 HP : ";
								str2 = "+" + hpTemp;
								str1 += str2;
								posText = 2;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (mpTemp != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "최대 MP : ";
								str2 = "+" + mpTemp;
								str1 += str2;
								posText = 2;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (defTemp != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "방어력 : ";
								str2 = "+" + defTemp;
								str1 += str2;
								posText = 3;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (powerTemp != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "공격력 : ";
								str2 = "+" + powerTemp;
								str1 += str2;
								posText = 3;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (magicPowerTemp != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "마력 : ";
								str2 = "+" + magicPowerTemp;
								str1 += str2;
								posText = 2;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (bossDmgTemp != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "보스 공격 시 데미지 : ";
								str2 = "+" + bossDmgTemp + "%";
								str1 += str2;
								posText = 8;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (dmgTemp != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "데미지 : ";
								str2 = "+" + dmgTemp + "%";
								str1 += str2;
								posText = 3;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (allStaTemp != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "올스텟 : ";
								str2 = "+" + allStaTemp + "%";
								str1 += str2;
								posText = 3;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							if (levTemp != 0) {
								System.out.print("┃ ");
								System.out.print("│ ");
								str1 = "착용 레벨 감소 : ";
								str2 = "-" + levTemp;
								str1 += str2;
								posText = 6;
								posTotal = posText + str1.length();
								System.out.print(str1);
								for (int i = posTotal; i < 32; i++) {
									System.out.print(" ");
								}
								System.out.print(" │");
								System.out.println(" ┃");
								chuCnt++;
							}
							for (int i = chuCnt; i < 8; i++) {
								System.out.print("┃ ");
								System.out.print("│                                  │");
								System.out.println(" ┃");
							}
							System.out.print("┃ ");
							System.out.print("└──────────────────────────────────┘");
							System.out.println(" ┃");
							System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
							System.out.println("1. 옵션 적용 >> ");
							System.out.print("옵션 돌리기 (0. 불꽃 변경) >> ");
							System.out.println();
							mesoAdd += fire == 3 ? 129999999 : 299999999;
							cntAdd++;
							int add = sc.nextInt();
							if (add == 0) {
								System.out.println("불꽃 선택");
								break;
							}
							if (add == 1) {
								isChange = true;
								lev[0] += lev[2];
								str[0] -= str[2];
								dex[0] -= dex[2];
								Int[0] -= Int[2];
								luk[0] -= luk[2];
								hp[0] -= hp[2];
								mp[0] -= mp[2];
								def[0] -= def[2];
								power[0] -= power[2];
								magicPower[0] -= magicPower[2];
								bossDmg[0] -= bossDmg[2];
								dmg[0] -= dmg[2];
								allSta[0] -= allSta[2];
								lev[2] = levTemp;
								str[2] = strTemp;
								dex[2] = dexTemp;
								Int[2] = IntTemp;
								luk[2] = lukTemp;
								hp[2] = hpTemp;
								mp[2] = mpTemp;
								def[2] = defTemp;
								power[2] = powerTemp;
								magicPower[2] = magicPowerTemp;
								bossDmg[2] = bossDmgTemp;
								dmg[2] = dmgTemp;
								allSta[2] = allStaTemp;
								break;
							}
						}

					}
					if (isChange) {
						lev[0] -= lev[2];
						str[0] += str[2];
						dex[0] += dex[2];
						Int[0] += Int[2];
						luk[0] += luk[2];
						hp[0] += hp[2];
						mp[0] += mp[2];
						def[0] += def[2];
						power[0] += power[2];
						magicPower[0] += magicPower[2];
						bossDmg[0] += bossDmg[2];
						dmg[0] += dmg[2];
						allSta[0] += allSta[2];
						isChange = false;
					}
				}
			} else if (sel == 6) {
				while (true) {
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
					System.out.print("┃ ");
					System.out.print("┌──────────────────────────────────┐");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│            소울 장착             │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("└──────────────────────────────────┘");
					System.out.println(" ┃");
					System.out.print("┃             ");
					System.out.print("┌──────────┐");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("      ／");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("    ／  ");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("／＼    ");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("│ ");
					System.out.print("／／    ");
					System.out.print(" │");
					System.out.println("             ┃");
					System.out.print("┃             ");
					System.out.print("└──────────┘");
					System.out.println("             ┃");
					System.out.print("┃ ");
					System.out.print("┌─────┬────────────────────────────┐");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│  1  │   위대한 뭐시깽이의 소울   │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├─────┼────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│  2  │   위대한 진힐라의 소울     │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├─────┼────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│  3  │   위대한 세렌의 소울       │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├─────┼────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│  4  │   위대한 칼로스의 소울     │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├─────┼────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│  5  │   위대한 카링의 소울       │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("├─────┼────────────────────────────┤");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("│  6  │   위대한 림보의 소울       │");
					System.out.println(" ┃");
					System.out.print("┃ ");
					System.out.print("└─────┴────────────────────────────┘");
					System.out.println(" ┃");
					System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
					System.out.print("소울 선택 (0. 종료) >> ");
					int soulSel = sc.nextInt();
					System.out.println();
					if (soulSel == 0) {
						System.out.println("소울 장착 종료");
						break;
					}
					int rdNum = rd.nextInt(700000);
					switch (rdNum % 7) {
					case 0:
						soulOption = "공격력 : +3%";
						soulOpCnt = 12;
						break;
					case 1:
						soulOption = "마력 : +3%";
						soulOpCnt = 10;
						break;
					case 2:
						soulOption = "올스텟 : +5%";
						soulOpCnt = 12;
						break;
					case 3:
						soulOption = "최대 HP : +2000";
						soulOpCnt = 15;
						break;
					case 4:
						soulOption = "크리티컬 확률 : +12%";
						soulOpCnt = 20;
						break;
					case 5:
						soulOption = "몬스터 방어율 무시 : +7%";
						soulOpCnt = 24;
						break;
					case 6:
						soulOption = "보스 공격 시 데미지 : +7%";
						soulOpCnt = 25;
						break;
					}
					if (soulSel == 1) {
						soulName = "위대한 뭐시깽이";
						soulNameCnt = 15;
						mesoSoul += 270000000;
					} else if (soulSel == 2) {
						soulName = "위대한 진힐라";
						soulNameCnt = 13;
						mesoSoul += 549990000l;
					} else if (soulSel == 3) {
						soulName = "위대한 세렌";
						soulNameCnt = 11;
						mesoSoul += 879900000l;
					} else if (soulSel == 4) {
						soulName = "위대한 칼로스";
						soulNameCnt = 13;
						mesoSoul += 1399000000l;
					} else if (soulSel == 5) {
						soulName = "위대한 카링";
						soulNameCnt = 11;
						mesoSoul += 2399000000l;
					} else if (soulSel == 6) {
						soulName = "위대한 림보";
						soulNameCnt = 11;
						mesoSoul += 2999000000l;
					}
					int sizeF = soulOpCnt / 2;
					int sizeB = soulOpCnt / 2;
					if (soulOpCnt % 2 == 1) {
						sizeB++;
					}
					int sizeF2 = (soulNameCnt + 18) / 2;
					int sizeB2 = (soulNameCnt + 18) / 2;
					if (soulNameCnt % 2 == 1) {
						sizeB2++;
					}
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
					System.out.print("┃ ");
					for (int i = 0; i < 18 - sizeF2; i++) {
						System.out.print(" ");
					}
					System.out.print(soulName);
					System.out.print("의 소울 장착 완료!");
					for (int i = 18 + sizeB2; i < 36; i++) {
						System.out.print(" ");
					}
					System.out.println(" ┃");
					System.out.print("┃ ");
					for (int i = 0; i < 18 - sizeF; i++) {
						System.out.print(" ");
					}
					System.out.print(soulOption);
					for (int i = 18 + sizeB; i < 36; i++) {
						System.out.print(" ");
					}
					System.out.println(" ┃");
					System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
					System.out.print("확인 >> ");
					System.out.println();
					int check = sc.nextInt();
					soul = true;
					cntSoul++;
					continue;
				}
			} else if (sel == 7) {
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.print("┃ ");
				for (int i = 0; i < 11; i++) {
					System.out.print(" ");
				}
				System.out.print("주문서 작 횟수");
				for (int i = 25; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
				System.out.print("┃ ");
				System.out.print("------------------------------------");
				System.out.println(" ┃");
				System.out.print("┃ ");
				pos = cnt100 > 100000 ? 6
						: cnt100 > 10000 ? 5 : cnt100 > 1000 ? 4 : cnt100 > 100 ? 3 : cnt100 > 10 ? 2 : 1;
				posText = 10;
				for (int i = 0; i < 18 - (posText + pos) / 2; i++) {
					System.out.print(" ");
				}
				System.out.print("100% 작 : " + cnt100);
				for (int i = 18 + (posText + pos) / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println((posText + pos) % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				pos = cnt70 > 100000 ? 6 : cnt70 > 10000 ? 5 : cnt70 > 1000 ? 4 : cnt70 > 100 ? 3 : cnt70 > 10 ? 2 : 1;
				posText = 9;
				for (int i = 0; i < 18 - (posText + pos) / 2; i++) {
					System.out.print(" ");
				}
				System.out.print("70% 작 : " + cnt70);
				for (int i = 18 + (posText + pos) / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println((posText + pos) % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				pos = cnt30 > 100000 ? 6 : cnt30 > 10000 ? 5 : cnt30 > 1000 ? 4 : cnt30 > 100 ? 3 : cnt30 > 10 ? 2 : 1;
				posText = 9;
				for (int i = 0; i < 18 - (posText + pos) / 2; i++) {
					System.out.print(" ");
				}
				System.out.print("30% 작 : " + cnt30);
				for (int i = 18 + (posText + pos) / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println((posText + pos) % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				pos = cnt15 > 100000 ? 6 : cnt15 > 10000 ? 5 : cnt15 > 1000 ? 4 : cnt15 > 100 ? 3 : cnt15 > 10 ? 2 : 1;
				posText = 9;
				for (int i = 0; i < 18 - (posText + pos) / 2; i++) {
					System.out.print(" ");
				}
				System.out.print("15% 작 : " + cnt15);
				for (int i = 18 + (posText + pos) / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println((posText + pos) % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				pos = cntWhite > 100000 ? 6
						: cntWhite > 10000 ? 5 : cntWhite > 1000 ? 4 : cntWhite > 100 ? 3 : cntWhite > 10 ? 2 : 1;
				posText = 19;
				for (int i = 0; i < 18 - (posText + pos) / 2; i++) {
					System.out.print(" ");
				}
				System.out.print("순백의 주문서 작 : " + cntWhite);
				for (int i = 18 + (posText + pos) / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println((posText + pos) % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				str1 = "소요 메소 : ";
				str2 = "";
				calc = mesoJuhen;
				str2 = calc > 999999999999l
						? (calc / 1000000000000l) + "조" + (calc % 1000000000000l / 100000000) + "억"
								+ (calc % 100000000 / 10000) + "만" + calc % 10000 + "메소"
						: calc > 99999999
								? (calc % 1000000000000l / 100000000) + "억" + (calc % 100000000 / 10000) + "만"
										+ calc % 10000 + "메소"
								: calc > 9999 ? (calc % 100000000 / 10000) + "만" + calc % 10000 + "메소"
										: calc % 10000 + "메소";
				str1 += str2;
				pos = calc > 999999999999l ? 5 : calc > 99999999 ? 4 : calc > 9999 ? 3 : 2;
				posText = 4;
				posTotal = str1.length() + posText + pos;
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.print("┃ ");
				for (int i = 0; i < 11; i++) {
					System.out.print(" ");
				}
				System.out.print("스타 포스 횟수");
				for (int i = 25; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
				System.out.print("┃ ");
				System.out.print("------------------------------------");
				System.out.println(" ┃");
				System.out.print("┃ ");
				str1 = "시도 횟수 : ";
				str2 = cntStarTry > 999999
						? cntStarTry / 1000000 + "," + cntStarTry % 1000000 / 1000 + "," + cntStarTry % 1000 + ""
						: cntStarTry > 999 ? cntStarTry % 1000000 / 1000 + "," + cntStarTry % 1000 + ""
								: cntStarTry % 1000 + "";
				str1 += str2;
				posText = 4;
				posTotal = posText + str1.length();
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				str1 = "파괴 횟수 : ";
				str2 = cntStarDis > 999999
						? cntStarDis / 1000000 + "," + cntStarDis % 1000000 / 1000 + "," + cntStarDis % 1000 + ""
						: cntStarDis > 999 ? cntStarDis % 1000000 / 1000 + "," + cntStarDis % 1000 + ""
								: cntStarDis % 1000 + "";
				str1 += str2;
				posText = 4;
				posTotal = posText + str1.length();
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				str1 = "소요 메소 : ";
				str2 = "";
				calc = mesoStar;
				str2 = calc > 999999999999l
						? (calc / 1000000000000l) + "조" + (calc % 1000000000000l / 100000000) + "억"
								+ (calc % 100000000 / 10000) + "만" + calc % 10000 + "메소"
						: calc > 99999999
								? (calc % 1000000000000l / 100000000) + "억" + (calc % 100000000 / 10000) + "만"
										+ calc % 10000 + "메소"
								: calc > 9999 ? (calc % 100000000 / 10000) + "만" + calc % 10000 + "메소"
										: calc % 10000 + "메소";
				str1 += str2;
				pos = calc > 999999999999l ? 5 : calc > 99999999 ? 4 : calc > 9999 ? 3 : 2;
				posText = 4;
				posTotal = str1.length() + posText + pos;
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.print("┃ ");
				for (int i = 0; i < 11; i++) {
					System.out.print(" ");
				}
				System.out.print("잠재 설정 횟수");
				for (int i = 25; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
				System.out.print("┃ ");
				System.out.print("------------------------------------");
				System.out.println(" ┃");
				System.out.print("┃ ");
				str1 = "시도 횟수 : ";
				str2 = cntOpUp > 999999 ? cntOpUp / 1000000 + "," + cntOpUp % 1000000 / 1000 + "," + cntOpUp % 1000 + ""
						: cntOpUp > 999 ? cntOpUp % 1000000 / 1000 + "," + cntOpUp % 1000 + "" : cntOpUp % 1000 + "";
				str1 += str2;
				posText = 4;
				posTotal = posText + str1.length();
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				str1 = "레어 => 에픽 : ";
				str2 = cntToEpic > 999999
						? cntToEpic / 1000000 + "," + cntToEpic % 1000000 / 1000 + "," + cntToEpic % 1000 + ""
						: cntToEpic > 999 ? cntToEpic % 1000000 / 1000 + "," + cntToEpic % 1000 + ""
								: cntToEpic % 1000 + "";
				str1 += str2;
				posText = 4;
				posTotal = posText + str1.length();
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				str1 = "에픽 => 유니크 : ";
				str2 = cntToUnique > 999999
						? cntToUnique / 1000000 + "," + cntToUnique % 1000000 / 1000 + "," + cntToUnique % 1000 + ""
						: cntToUnique > 999 ? cntToUnique % 1000000 / 1000 + "," + cntToUnique % 1000 + ""
								: cntToUnique % 1000 + "";
				str1 += str2;
				posText = 5;
				posTotal = posText + str1.length();
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				str1 = "유니크 => 레전드리 : ";
				str2 = cntToLegend > 999999
						? cntToLegend / 1000000 + "," + cntToLegend % 1000000 / 1000 + "," + cntToLegend % 1000 + ""
						: cntToLegend > 999 ? cntToLegend % 1000000 / 1000 + "," + cntToLegend % 1000 + ""
								: cntToLegend % 1000 + "";
				str1 += str2;
				posText = 7;
				posTotal = posText + str1.length();
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				str1 = "소요 메소 : ";
				str2 = "";
				calc = mesoJamjae;
				str2 = calc > 999999999999l
						? (calc / 1000000000000l) + "조" + (calc % 1000000000000l / 100000000) + "억"
								+ (calc % 100000000 / 10000) + "만" + calc % 10000 + "메소"
						: calc > 99999999
								? (calc % 1000000000000l / 100000000) + "억" + (calc % 100000000 / 10000) + "만"
										+ calc % 10000 + "메소"
								: calc > 9999 ? (calc % 100000000 / 10000) + "만" + calc % 10000 + "메소"
										: calc % 10000 + "메소";
				str1 += str2;
				pos = calc > 999999999999l ? 5 : calc > 99999999 ? 4 : calc > 9999 ? 3 : 2;
				posText = 4;
				posTotal = str1.length() + posText + pos;
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.print("┃ ");
				for (int i = 0; i < 7; i++) {
					System.out.print(" ");
				}
				System.out.print("에디셔널 잠재 설정 횟수");
				for (int i = 30; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
				System.out.print("┃ ");
				System.out.print("------------------------------------");
				System.out.println(" ┃");
				System.out.print("┃ ");
				str1 = "시도 횟수 : ";
				str2 = cntOpDown > 999999
						? cntOpDown / 1000000 + "," + cntOpDown % 1000000 / 1000 + "," + cntOpDown % 1000 + ""
						: cntOpDown > 999 ? cntOpDown % 1000000 / 1000 + "," + cntOpDown % 1000 + ""
								: cntOpDown % 1000 + "";
				str1 += str2;
				posText = 4;
				posTotal = posText + str1.length();
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				str1 = "레어 => 에픽 : ";
				str2 = cntToEpicAdd > 999999
						? cntToEpicAdd / 1000000 + "," + cntToEpicAdd % 1000000 / 1000 + "," + cntToEpicAdd % 1000 + ""
						: cntToEpicAdd > 999 ? cntToEpicAdd % 1000000 / 1000 + "," + cntToEpicAdd % 1000 + ""
								: cntToEpicAdd % 1000 + "";
				str1 += str2;
				posText = 4;
				posTotal = posText + str1.length();
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				str1 = "에픽 => 유니크 : ";
				str2 = cntToUniqueAdd > 999999
						? cntToUniqueAdd / 1000000 + "," + cntToUniqueAdd % 1000000 / 1000 + "," + cntToUniqueAdd % 1000
								+ ""
						: cntToUniqueAdd > 999 ? cntToUniqueAdd % 1000000 / 1000 + "," + cntToUniqueAdd % 1000 + ""
								: cntToUniqueAdd % 1000 + "";
				str1 += str2;
				posText = 5;
				posTotal = posText + str1.length();
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				str1 = "유니크 => 레전드리 : ";
				str2 = cntToLegendAdd > 999999
						? cntToLegendAdd / 1000000 + "," + cntToLegendAdd % 1000000 / 1000 + "," + cntToLegendAdd % 1000
								+ ""
						: cntToLegendAdd > 999 ? cntToLegendAdd % 1000000 / 1000 + "," + cntToLegendAdd % 1000 + ""
								: cntToLegendAdd % 1000 + "";
				str1 += str2;
				posText = 7;
				posTotal = posText + str1.length();
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				str1 = "소요 메소 : ";
				str2 = "";
				calc = mesoJamjaeAdd;
				str2 = calc > 999999999999l
						? (calc / 1000000000000l) + "조" + (calc % 1000000000000l / 100000000) + "억"
								+ (calc % 100000000 / 10000) + "만" + calc % 10000 + "메소"
						: calc > 99999999
								? (calc % 1000000000000l / 100000000) + "억" + (calc % 100000000 / 10000) + "만"
										+ calc % 10000 + "메소"
								: calc > 9999 ? (calc % 100000000 / 10000) + "만" + calc % 10000 + "메소"
										: calc % 10000 + "메소";
				str1 += str2;
				pos = calc > 999999999999l ? 5 : calc > 99999999 ? 4 : calc > 9999 ? 3 : 2;
				posText = 4;
				posTotal = str1.length() + posText + pos;
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.print("┃ ");
				for (int i = 0; i < 9; i++) {
					System.out.print(" ");
				}
				System.out.print("추가옵션 설정 횟수");
				for (int i = 27; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
				System.out.print("┃ ");
				System.out.print("------------------------------------");
				System.out.println(" ┃");
				System.out.print("┃ ");
				str1 = "시도 횟수 : ";
				str2 = cntAdd > 999999 ? cntAdd / 1000000 + "," + cntAdd % 1000000 / 1000 + "," + cntAdd % 1000 + ""
						: cntAdd > 999 ? cntAdd % 1000000 / 1000 + "," + cntAdd % 1000 + "" : cntAdd % 1000 + "";
				str1 += str2;
				posText = 4;
				posTotal = posText + str1.length();
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				str1 = "소요 메소 : ";
				str2 = "";
				calc = mesoAdd;
				str2 = calc > 999999999999l
						? (calc / 1000000000000l) + "조" + (calc % 1000000000000l / 100000000) + "억"
								+ (calc % 100000000 / 10000) + "만" + calc % 10000 + "메소"
						: calc > 99999999
								? (calc % 1000000000000l / 100000000) + "억" + (calc % 100000000 / 10000) + "만"
										+ calc % 10000 + "메소"
								: calc > 9999 ? (calc % 100000000 / 10000) + "만" + calc % 10000 + "메소"
										: calc % 10000 + "메소";
				str1 += str2;
				pos = calc > 999999999999l ? 5 : calc > 99999999 ? 4 : calc > 9999 ? 3 : 2;
				posText = 4;
				posTotal = str1.length() + posText + pos;
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.print("┃ ");
				for (int i = 0; i < 11; i++) {
					System.out.print(" ");
				}
				System.out.print("소울 강화 횟수");
				for (int i = 25; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
				System.out.print("┃ ");
				System.out.print("------------------------------------");
				System.out.println(" ┃");
				System.out.print("┃ ");
				str1 = "시도 횟수 : ";
				str2 = cntSoul > 999999 ? cntSoul / 1000000 + "," + cntSoul % 1000000 / 1000 + "," + cntSoul % 1000 + ""
						: cntSoul > 999 ? cntSoul % 1000000 / 1000 + "," + cntSoul % 1000 + "" : cntSoul % 1000 + "";
				str1 += str2;
				posText = 4;
				posTotal = posText + str1.length();
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.print("┃ ");
				str1 = "소요 메소 : ";
				str2 = "";
				calc = mesoSoul;
				str2 = calc > 999999999999l
						? (calc / 1000000000000l) + "조" + (calc % 1000000000000l / 100000000) + "억"
								+ (calc % 100000000 / 10000) + "만" + calc % 10000 + "메소"
						: calc > 99999999
								? (calc % 1000000000000l / 100000000) + "억" + (calc % 100000000 / 10000) + "만"
										+ calc % 10000 + "메소"
								: calc > 9999 ? (calc % 100000000 / 10000) + "만" + calc % 10000 + "메소"
										: calc % 10000 + "메소";
				str1 += str2;
				pos = calc > 999999999999l ? 5 : calc > 99999999 ? 4 : calc > 9999 ? 3 : 2;
				posText = 4;
				posTotal = str1.length() + posText + pos;
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.print("┃ ");
				for (int i = 0; i < 12; i++) {
					System.out.print(" ");
				}
				System.out.print("총 사용 재화");
				for (int i = 24; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(" ┃");
				System.out.print("┃ ");
				System.out.print("------------------------------------");
				System.out.println(" ┃");
				System.out.print("┃ ");
				str1 = "";
				str2 = "";
				mesoTotal = mesoJuhen + mesoStar + mesoJamjae + mesoJamjaeAdd + mesoAdd + mesoSoul;
				calc = mesoTotal;
				str2 = calc > 999999999999l
						? (calc / 1000000000000l) + "조" + (calc % 1000000000000l / 100000000) + "억"
								+ (calc % 100000000 / 10000) + "만" + calc % 10000 + "메소"
						: calc > 99999999
								? (calc % 1000000000000l / 100000000) + "억" + (calc % 100000000 / 10000) + "만"
										+ calc % 10000 + "메소"
								: calc > 9999 ? (calc % 100000000 / 10000) + "만" + calc % 10000 + "메소"
										: calc % 10000 + "메소";
				str1 += str2;
				pos = calc > 999999999999l ? 5 : calc > 99999999 ? 4 : calc > 9999 ? 3 : 2;
				posText = 0;
				posTotal = str1.length() + posText + pos;
				for (int i = 0; i < 18 - posTotal / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(str1);
				for (int i = 18 + posTotal / 2; i < 36; i++) {
					System.out.print(" ");
				}
				System.out.println(posTotal % 2 == 1 ? "┃" : " ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				System.out.print("확인 >> ");
				System.out.println("\n");
				int check = sc.nextInt();
				continue;
			}
		}
		sc.close();
	}

}
