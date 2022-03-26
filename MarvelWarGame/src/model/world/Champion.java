package model.world;
import java.util.ArrayList ;
import java.awt.Point; 
import model.abilities.* ;
import model.effects.* ;
public class Champion {
	private String name ;
	private int maxHP ;
	private int currentHP ;
	private int mana ;
	private int maxActionPointsPerTurn ;
	private int currentActionPoints ;
	private int attackRange ;
	private int attackDamage ;
	private int speed ;
	private ArrayList<Ability> abilities ;
	private ArrayList<Effect> appliedEffects ;
	private Condition condition ;
	private Point location ;
	
	public Champion (String name, int maxHP, int mana, int maxActions, int speed,
			int attackRange,int attackDamage){
		this.name = name ; 
		this.maxHP = maxHP ;
		this.mana = mana ;
		this.maxActionPointsPerTurn = maxActions ;
		this.speed = speed ;
		this.attackRange = attackRange ;
		this.attackDamage = attackDamage ;
		this.condition = Condition.ACTIVE ;
		this.abilities = new ArrayList<Ability>();
		this.appliedEffects = new ArrayList<Effect>() ;
		this.currentActionPoints=maxActions ;
		this.currentHP = maxHP ;
	}
	public Champion (String name, int maxHP, int mana, int maxActions, int speed,
			int attackRange,int attackDamage , Ability a1 , Ability a2 , Ability a3 ){
		this.name = name ; 
		this.maxHP = maxHP ;
		this.mana = mana ;
		this.maxActionPointsPerTurn = maxActions ;
		this.speed = speed ;
		this.attackRange = attackRange ;
		this.attackDamage = attackDamage ;
		this.condition = Condition.ACTIVE ;
		this.abilities = new ArrayList<Ability>();
		this.appliedEffects = new ArrayList<Effect>() ;
		this.currentActionPoints=maxActions ;
		this.currentHP = maxHP ;
		this.abilities.add(a1);
		this.abilities.add(a2);
		this.abilities.add(a3);
	}
	
	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int currentHP) {
			this.currentHP = Math.max(0, Math.min(currentHP, getMaxHP()));
	}
	public int getMaxActionPointsPerTurn() {
		return maxActionPointsPerTurn;
	}
	public void setMaxActionPointsPerTurn(int maxActionPointsPerTurn) {
		this.maxActionPointsPerTurn = maxActionPointsPerTurn;
	}
	public int getAttackDamage() {
		return attackDamage;
	}
	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public int getMana() {
		return mana;
	}
	public void setCurrentActionPoints(int currentActionPoints) {
		this.currentActionPoints = currentActionPoints;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getCurrentActionPoints() {
		return currentActionPoints;
	}
	public int getAttackRange() {
		return attackRange;
	}
	public ArrayList<Ability> getAbilities() {
		return abilities;
	}
	public ArrayList<Effect> getAppliedEffects() {
		return appliedEffects;
	}
	public String printAbilities(ArrayList<Ability>a) {
		String res = "";
		for(int i = 0;i<abilities.size();i++)
			res += abilities.get(i)+" ";
		return res;
	}
	public String printEffects(ArrayList<Effect>a) {
		String res = "";
		for(int i = 0;i<abilities.size();i++)
			res += abilities.get(i)+" ";
		return res;
	}
	/*public String toString() {
		return "NAME: "+name+'\n'+"MAX HP: "+maxHP+'\n'+
				'\n'+ "MANA: "+mana+'\n'+"Max Action Points Per Turn: "+
				maxActionPointsPerTurn+'\n'+"Attack Range: "+attackRange+'\n'+
				"Attack Damage: "+attackDamage+'\n'+"SPEED: "+speed+'\n'+
				"Abilities :"+abilities.toString()+'\n'+
				"________________________________________________"+'\n';
				
	}*/
	
}
