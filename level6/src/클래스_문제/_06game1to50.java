package 클래스_문제;

import java.util.Random;
import java.util.Scanner;

class Game1to50{
	final int SIZE = 25;
	int[] front = new int[SIZE];
	int[] back = new int[SIZE];
	int gameNum;
}

public class _06game1to50 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rd= new Random();
		Game1to50 game = new Game1to50();
		
		for(int i = 0;i<game.SIZE;i++) {
			game.front[i] = i+1;
			game.back[i] = i + 1 + game.SIZE;
		}
		for(int i = 0; i<100;i++) {
			int rdIdx = rd.nextInt(game.SIZE);
			int temp = game.front[0];
			game.front[0] = game.front[rdIdx];
			game.front[rdIdx] = temp;
			
			rdIdx = rd.nextInt(game.SIZE);
			temp = game.back[0];
			game.back[0] = game.back[rdIdx];
			game.back[rdIdx] = temp;
		}
		game.gameNum = 1;
		while(true) {
			int idx = 0;
			for(int i = 0;i<game.SIZE;i++) {
				if(game.front[i] == game.gameNum) {
					idx = i;
				}
				if(game.front[i] == 0) {
					System.out.printf("[%3s]","");
				}else {
					System.out.printf("[%3d]",game.front[i]);
				}
				if(i%5 == 4) {
					System.out.println();
				}
			}
			if(game.gameNum > game.SIZE*2) {
				System.out.println("게임종료");
				break;
			}
			System.out.printf("%d 인덱스(위치) >> \t [%d]",game.gameNum,idx);
			int input = sc.nextInt();
			if(input < 0 || input >= game.SIZE) {
				continue;
			}
			if(game.front[input] == game.gameNum) {
				game.front[input] = game.gameNum <= game.SIZE? game.back[input]:0;
				game.gameNum++;
			}
		}
		sc.close();
	}

}
