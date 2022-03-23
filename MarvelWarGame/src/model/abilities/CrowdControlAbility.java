package model.abilities;
import model.effects;
public class CrowdControlAbility extends Ability{

	Effect effect;
	
	public CrowdControlAbility(String name,int manaCost,int baseCooldown,int currentCooldown,int castRange,int requiredActionPoints,AreaOfEffect castArea,Effect effect) {
		super(name,manaCost,baseCooldown,currentCooldown,castRange,requiredActionPoints,castArea,effect);
		this.effect = effect;
	}

	public Effect getEffect() {
		return effect;
	}
	
}
