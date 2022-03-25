package engine;
import java.util.*;
import model.world.Champion;
public class Player {

	private String name;
	private Champion leader;
	private ArrayList<Champion> team;
	public Player(String name) {
		this.name = name;
		this.team = new ArrayList<Champion>() ;
	}
	public Champion getLeader() {
		return leader;
	}
	public void setLeader(Champion leader) {
		leader = leader;
	}
	public String getName() {
		return name;
	}
	public ArrayList<Champion> getTeam() {
		return team;
	}
	
}
