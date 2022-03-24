package engine;
import java.util.ArrayList ;
import model.world.Champion ;
import model.abilities.Ability ;
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
	
	
	
}
