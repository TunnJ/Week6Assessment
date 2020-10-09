import java.util.List;

import controller.JerseyHelper;
import model.Jersey;
import model.Player;

public class JerseyTester {

	public static void main(String[] args) {
		Player aRod = new Player("Packers","Aaron Rodgers");
		Jersey j = new Jersey("Green", "Home", aRod);
		JerseyHelper jh = new JerseyHelper();
		jh.insertJersey(j);
		
		List<Jersey> allJerseys = jh.showAllJerseys();
		for(Jersey a : allJerseys) {
			System.out.println(a.toString());
		}
	}

}
