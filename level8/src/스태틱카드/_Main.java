package 스태틱카드;

public class _Main {

	public static void main(String[] args) {
		// 플레이어 수, 인당 카드 수 설정
		int playerCnt = 5;
		int cardCnt = 2;
		// 각 수 적용
		GameManager.init(playerCnt, cardCnt);
		// 적용된 인원과 카드 수에 따른 게임 생성
		GameManager gm = new GameManager();
		// 적용된 인원과 카드 수에 따른 게임 실행
		gm.run();
	}

}
