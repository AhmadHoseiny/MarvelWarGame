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
}
