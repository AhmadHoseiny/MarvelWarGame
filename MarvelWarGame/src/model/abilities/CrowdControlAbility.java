package model.abilities;
import model.effects.Effect;
public class CrowdControlAbility extends Ability{

	Effect effect;
	
	public CrowdControlAbility(String name,int cost,int baseCooldown,int castRange,AreaOfEffect area,int required,Effect effect) {
		super(name,cost,baseCooldown,castRange,area,required);
		this.effect = effect;
	}

	public Effect getEffect() {
		return effect;
	}
	/*public String toString() {
		return super.toString()+'\n'+effect.toString()+'\n'+
				"________________________"+'\n';
	}*/
	
}
