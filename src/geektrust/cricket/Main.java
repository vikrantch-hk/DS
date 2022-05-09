package geektrust.cricket;

import java.util.ArrayList;
import java.util.List;

//The input to your solution will be passed in as String[] args
public class Main {
	private Team[] teams;

	public Main() {
		teams = new Team[2];
		Team team1 = new Team();
		team1.setName("Lengaburu");
		Team team2 = new Team();
		team2.setName("Enchai");
		teams[0] = team1;
		teams[1] = team2;
	}

	public Team getTossWinner(WEATHER weather, SESSION session) {
		if (WEATHER.valueOf("Clear").equals(weather) && SESSION.valueOf("Day").equals(session)) {
			teams[0].setTossWinner(true);
			teams[0].setDecision(DECISION.bats);
		} else if (WEATHER.valueOf("Cloudy").equals(weather) && SESSION.valueOf("Night").equals(session)) {
			teams[0].setTossWinner(true);
			teams[0].setDecision(DECISION.bowls);
		} else if (WEATHER.valueOf("Cloudy").equals(weather) && SESSION.valueOf("Day").equals(session)) {
			teams[0].setTossWinner(true);
			teams[0].setDecision(DECISION.bats);
		} else if (WEATHER.valueOf("Clear").equals(weather) && SESSION.valueOf("Night").equals(session)) {
			teams[0].setTossWinner(true);
			teams[0].setDecision(DECISION.bats);
		}
		return teams[0];
	}

	public static void main(String[] args) {
		String weather = args[0];
		String session = args[1];
		Team tossWinner = new Main().getTossWinner(WEATHER.valueOf(weather), SESSION.valueOf(session));
		System.out.println(tossWinner.getName() + " wins toss and " + tossWinner.getDecision());
	}

	enum WEATHER {
		Clear, Cloudy;
	}

	enum SESSION {
		Day, Night;
	}

	enum DECISION {
		bats, bowls;
	}

	
}