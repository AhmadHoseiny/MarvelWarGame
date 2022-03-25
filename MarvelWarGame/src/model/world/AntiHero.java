package model.world;
import model.abilities.* ;
public class AntiHero extends Hero {
	public AntiHero(String name, int maxHP, int mana, int maxActions, int speed,
			int attackRange,int attackDamage ){
		super(name,maxHP , mana , maxActions , speed , attackRange , attackDamage) ;
		//setCurrentHP(maxHP) ;
	}
	public AntiHero(String name, int maxHP, int mana, int maxActions, int speed,
			int attackRange,int attackDamage ,Ability a1 , Ability a2 , Ability a3){
		super(name,maxHP , mana , maxActions , speed , attackRange , attackDamage ,a1,
				a2,a3) ; 
	}
}
