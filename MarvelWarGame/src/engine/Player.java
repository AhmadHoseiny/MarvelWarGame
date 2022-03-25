package engine;
import java.util.*;
import model.world.Champion;
public class Player {

	String name;
	Champion Leader;
	ArrayList<Champion> team;
	public Player(String name) {
		this.name = name;
	}
	public Champion getLeader() {
		return Leader;
	}
	public void setLeader(Champion leader) {
		Leader = leader;
	}
	public String getName() {
		return name;
	}
	public ArrayList<Champion> getTeam() {
		return team;
	}
	
}
