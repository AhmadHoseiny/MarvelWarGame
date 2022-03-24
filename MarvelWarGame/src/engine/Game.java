package engine;
import java.util.ArrayList ;
import model.world.Champion ;
import model.abilities.* ;
import model.effects.* ;
import java.io.* ;
public class Game {
	private Player firstPlayer ;
	private Player secondPlayer ;
	private boolean firstLeaderAbilityUsed ;
	private boolean secondLeaderAbilityUsed ;
	private Object [][] board ;
	private static ArrayList<Champion> availableChampions ;
	private static ArrayList<Ability> availableAbilities ;
	private PriorityQueue turnOrder ;
	private static int boardWidth ;
	private static int boardHeight ;
	
	public Player getFirstPlayer() {
		return firstPlayer;
	}
	public Player getSecondPlayer() {
		return secondPlayer;
	}
	public boolean isFirstLeaderAbilityUsed() {
		return firstLeaderAbilityUsed;
	}
	public boolean isSecondLeaderAbilityUsed() {
		return secondLeaderAbilityUsed;
	}
	public Object[][] getBoard() {
		return board;
	}
	public static ArrayList<Champion> getAvailableChampions() {
		return availableChampions;
	}
	public static ArrayList<Ability> getAvailableAbilities() {
		return availableAbilities;
	}
	public PriorityQueue getTurnOrder() {
		return turnOrder;
	}
	public static int getBoardWidth() {
		return boardWidth;
	}
	public static int getBoardHeight() {
		return boardHeight;
	}
	public Game(Player first , Player second){
		this.firstPlayer = first ;
		this.secondPlayer = second ;
	}
	public static void loadAbilities(String filePath) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(filePath)) ;
		while(br.ready()){
			String temp = br.readLine() ;
			String [] arr = temp.split(",") ;
			boolean isCC =false ;
			boolean isDMG =false;
			boolean isHEL=false ;
			switch(arr[0]){
				case "DMG" : isDMG = true ;break ;
				case "CC" : isCC = true ; break;
				case "HEL" : isHEL=true ; break ;
				default : break;
			}
			String p1 = arr[1] ;
			int p2 = Integer.parseInt(arr[2]);
			int p3 = Integer.parseInt(arr[4]);
			int p4 = Integer.parseInt(arr[3]);
			String x = arr[5] ;
			AreaOfEffect p5 = null ;
			switch(x){
				case "SELFTARGET" : p5 = AreaOfEffect.SELFTARGET ; break;
				case "SINGLETARGET" : p5 = AreaOfEffect.SINGLETARGET ;break;
				case "TEAMTARGET" : p5 = AreaOfEffect.TEAMTARGET ;break;
				case "DIRECTIONAL" : p5 = AreaOfEffect.DIRECTIONAL ;break;
				case "SURROUND" : p5 = AreaOfEffect.SURROUND ;break;
				default: break;
			}
			
			int p6 = Integer.parseInt(arr[6]);
			if(isDMG){
				int p7 = Integer.parseInt(arr[7]);
				DamagingAbility da = new DamagingAbility(p1,p2,p3,p4,p5,p6,p7 ) ;
				availableAbilities.add(da) ;
			}
			else{
				if(isCC){
					String name = arr[7];
					EffectType y = null ;
					switch(name){
						case "Disarm" : y = EffectType.DEBUFF ;break;
						case "PowerUp" : y = EffectType.BUFF ;break;
						case "Shield" : y = EffectType.BUFF ;break;
						case "Silence" : y = EffectType.DEBUFF ;break;
						case "SpeedUp" : y = EffectType.BUFF ;break;
						case "Embrace" : y = EffectType.BUFF ;break;
						case "Root" : y = EffectType.DEBUFF ;break;
						case "Shock" : y = EffectType.DEBUFF ;break;
						case "Dodge" : y = EffectType.BUFF ;break;
						case "Stun" : y = EffectType.DEBUFF ;break;
						default: break ;
					}
					Effect c = new Effect(name , Integer.parseInt(arr[8]) , y) ; 
					CrowdControlAbility cca = new CrowdControlAbility(p1,p2,p3,p4,p5,p6,c) ;
					availableAbilities.add(cca) ;
				}
				else{
					int p7 = Integer.parseInt(arr[7]) ;
					HealingAbility ha = new HealingAbility(p1,p2,p3,p4,p5,p6,p7) ;
					availableAbilities.add(ha) ;
				}
			}
		}
	}
	
	
	
	
}
