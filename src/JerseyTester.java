import java.util.List;

import controller.JerseyHelper;
import model.Jersey;

public class JerseyTester {

	public static void main(String[] args) {
		Jersey j = new Jersey("Purple", "Home");
		JerseyHelper jh = new JerseyHelper();
		jh.insertJersey(j);
		
		List<Jersey> allJerseys = jh.showAllJerseys();
		for(Jersey a : allJerseys) {
			System.out.println(a.toString());
		}
	}

}
