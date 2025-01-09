package 객체지향이론;

import java.util.ArrayList;
import java.util.Random;

// 객체 : 속성 => 변수, 행동(기능) => 메서드
class Monster{
	private String name;
	private final int MAX_HP = 10;
	private int hp;
	private boolean dead;
	private static int cnt;
	
	Monster(String name) {
		this.name = name;
		this.hp = MAX_HP;
		cnt++;
	}

	String getName() {
		return name;
	}

	int getHp() {
		return hp;
	}

	boolean isDead() {
		return dead;
	}

	void setHp(int hp) {
		this.hp = hp;
	}

	void setDead(boolean dead) {
		this.dead = dead;
	}
	
	void getDamaged(int damage) {
		if(dead) return;
		if(damage == 0) {
			System.out.println("MISS");
			return;
		}
		System.out.printf("%s [%d/%d] 데미지 %d \n",name,hp,MAX_HP,damage);
		hp -= damage;
		if(hp <= 0) {
			System.out.println(this + "사망");
			dead = true;
			cnt--;
		}
	}

	static int getAliveMonsterCnt() {
		return cnt;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}

public class _04스태틱2 {

	public static void main(String[] args) {

		ArrayList<Monster> mList = new ArrayList<>();
		mList.add(new Monster("오크1"));
		mList.add(new Monster("오크2"));
		mList.add(new Monster("오크3"));
		mList.add(new Monster("오크4"));
		Random rd = new Random();
		while(Monster.getAliveMonsterCnt() != 0) {
			for(Monster m : mList) {
				m.getDamaged(rd.nextInt(4));
			}
		}
	}

}
