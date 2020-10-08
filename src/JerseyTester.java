import java.util.List;

import controller.JerseyHelper;
import model.Jersey;
import model.Player;

public class JerseyTester {

	public static void main(String[] args) {
		//Need a player object to insert into the jersey
		Player sample = new Player("SampleTeam", "SamplePlayer");
		Jersey j = new Jersey("Purple", "Home");
		//set the player for the jersey
		j.setPlayer(sample);
		JerseyHelper jh = new JerseyHelper();
		jh.insertJersey(j);
		
		List<Jersey> allJerseys = jh.showAllJerseys();
		for(Jersey a : allJerseys) {
			System.out.println(a.toString());
		}
	}

}
