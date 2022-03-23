package model.abilities;

public class DamgingAbility extends Ability {

	private int damageAmount;
	
	public DamgingAbility(String name,int cost,int baseCooldown,int castRange,AreaOfEffect area,int required,int damageAmount) {
		super(name,cost,baseCooldown,castRange,area,required);
		this.damageAmount = damageAmount;
	}

	public int getDamageAmount() {
		return damageAmount;
	}

	public void setDamageAmount(int damageAmount) {
		this.damageAmount = damageAmount;
	}
	
}
