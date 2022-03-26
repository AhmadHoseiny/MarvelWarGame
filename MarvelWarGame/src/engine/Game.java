package engine;
import java.awt.Point ;
import java.util.ArrayList ;
import java.util.HashSet ;
import model.world.* ;
import model.abilities.* ;
import model.effects.* ;
import java.io.* ;
public class Game {
	private Player firstPlayer ;
	private Player secondPlayer ;
	private boolean firstLeaderAbilityUsed ;
	private boolean secondLeaderAbilityUsed ;
	private Object [][] board ;
	private static ArrayList<Champion> availableChampions = new ArrayList<Champion>()  ;
	private static ArrayList<Ability> availableAbilities = new ArrayList<Ability>() ;
	private PriorityQueue turnOrder ;
	private final static int BOARDWIDTH =5 ;
	private final static int BOARDHEIGHT =5;
	
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
	
	public static int getBoardwidth() {
		return BOARDWIDTH;
	}
	public static int getBoardheight() {
		return BOARDHEIGHT;
	}
	public Game(Player first , Player second){
		this.firstPlayer = first ;
		this.secondPlayer = second ;
		//this.turnOrder = new PriorityQueue(6) ;
		board = new Object [BOARDHEIGHT][BOARDWIDTH] ;
		placeCovers() ;
		placeChampions() ;
	}
	
	private void placeChampions(){
		ArrayList<Champion> teamOfP1 = firstPlayer.getTeam() ;
		ArrayList<Champion> teamOfP2 = secondPlayer.getTeam() ;
		for(int i=0 ; i<teamOfP1.size() ; i++){
			board[0][i+1] = teamOfP1.get(i) ;
		}
		for(int i=0 ; i<teamOfP2.size() ; i++){
			board[4][i+1] = teamOfP2.get(i) ;
		}
	}
	private void placeCovers(){
		HashSet<Point> previous = new HashSet<Point> ();
		for(int k=0 ; k<5 ; k++){
			int i=0;
			int j=0;
			boolean flag = true ;
			while(flag) {
				 i = (int)( Math.random() *(4-1) +1  )  ;
				 j = (int)( Math.random() *5  )  ;
				 Point cur = new Point(i,j) ;
				 if(!previous.contains(cur)){
					 flag = false ;
				 }
			}
			Point x = new Point(i,j) ;
			previous.add(x) ;
			Cover newCover = new Cover(i,j) ;
			board[i][j] = newCover ;
		}
	}
	
	public static void loadAbilities(String filePath) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(filePath)) ;
		//String temp = "" ;
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
			AreaOfEffect p5  = null;
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
				DamagingAbility dA = new DamagingAbility(p1,p2,p3,p4,p5,p6,p7 ) ;
				availableAbilities.add(dA)  ;
			}
			else{
				if(isCC){
					String name = arr[7];
					/*EffectType y = null ;
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
					Effect c = new Effect(name , Integer.parseInt(arr[8]) , y) ; */ 
					Effect c = null ; 
					int d = Integer.parseInt(arr[8]) ;
					switch(name){
						case "Disarm" : c = new Disarm(d) ; break ;
						case "PowerUp" : c = new PowerUp(d) ; break ;
						case "Shield" : c = new Shield(d) ; break ;
						case "Silence" : c = new Silence(d) ; break ;
						case "SpeedUp" : c = new SpeedUp(d) ; break ;
						case "Embrace" : c = new Embrace(d) ; break ;
						case "Root" : c = new Root(d) ; break ;
						case "Shock" : c = new Shock(d) ; break ;
						case "Dodge" : c = new Dodge(d) ; break ;
						case "Stun" : c = new Stun(d) ;break ; 
						default : break ;
					}
					CrowdControlAbility cca = new CrowdControlAbility(p1,p2,p3,p4,p5,p6,c) ;
					availableAbilities.add(cca) ;
				}
				else{
					if(isHEL){
						int p7 = Integer.parseInt(arr[7]) ;
						HealingAbility ha = new HealingAbility(p1,p2,p3,p4,p5,p6,p7) ;
						availableAbilities.add(ha) ;
					}
					
				}
			}
		}
		availableAbilities.trimToSize();
		br.close();
	}
	
	public static Ability getAbilityFromName(String name){
		for(int i=0 ; i<availableAbilities.size() ; i++){
			Ability cur = availableAbilities.get(i) ;
			if(name.equals(cur.getName()))
				return cur ;
		}
		return null ;
	}
	public static void loadChampions(String filePath) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(filePath)) ;
		while(br.ready()){
			String tmp = br.readLine();
			String[] arr = tmp.split(",") ;
			boolean isH =false ;
			boolean isA =false ;
			boolean isV =false ;
			switch(arr[0]){
				case "H": isH = true ; break ;
				case "A": isA = true ; break ;
				case "V": isV = true ; break ;
				default: break ;
			}
			String p1 = arr[1] ;
			int p2 = Integer.parseInt(arr[2]) ;
			int p3 = Integer.parseInt(arr[3]) ;
			int p4 = Integer.parseInt(arr[4]) ;
			int p5 = Integer.parseInt(arr[5]) ;
			int p6 = Integer.parseInt(arr[6]) ;
			int p7 = Integer.parseInt(arr[7]) ;
			Ability p8 = getAbilityFromName(arr[8]);
			Ability p9 = getAbilityFromName(arr[9]);
			Ability p10 = getAbilityFromName(arr[10]);
			
			if(isH){
				Hero h = new Hero(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10) ;
				availableChampions.add(h) ;
			}
			else{
				if(isA){
					AntiHero A = new AntiHero(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10) ;
					availableChampions.add(A) ;
				}
				else{
					if(isV){
						Villain v = new Villain(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10) ;
						availableChampions.add(v) ;
					}
					
				}
			}
		}
		availableChampions.trimToSize();
		br.close();
	}
	
	/*public static void main(String[] args) throws Exception {
		loadAbilities("Abilities.csv") ;
		loadChampions("Champions.csv") ;
		//System.out.println(availableAbilities);
		System.out.println(availableChampions);
	}*/
	
	
	
	
}
