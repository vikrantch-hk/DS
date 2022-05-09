package geektrust.cricket.tie.breaker;

import geektrust.cricket.tie.breaker.pojo.Player;
import geektrust.cricket.tie.breaker.pojo.Team;
import geektrust.cricket.tie.breaker.util.CommentryGenerator;

public class SimulateMatch {

	public static void main(String[] args) {

		// create match object pass it 2 teams
		Team team1 = new Team("Lengaburu", new Player[] {
				new Player("Kirat Boli", new double[] { 0.05d, 0.1d, 0.25d, 0.1d, 0.25d, 0.01d, 0.14d, 0.1d }),
				new Player("N.S Nodhi", new double[] { 0.05d, 0.15d, 0.15d, 0.1d, 0.20d, 0.01d, 0.19d, 0.15d }) });

		Team team2 = new Team("Enchai",
				new Player[] {
						new Player("DB Vellyers", new double[] { 0.05d, 0.1d, 0.25d, 0.1d, 0.25d, 0.01d, 0.14d, 0.1d }),
						new Player("H Mamla", new double[] { 0.1d, 0.15d, 0.15d, 0.1d, 0.20d, 0.01d, 0.19d, 0.1d }) });

		Match match = new Match(new Team[] { team1, team2 });

		// set Lengaburu toss winner
		match.setTossWinner(match.getTeams()[0]);
		match.setTossLooser(match.getTeams()[1]);

		// create first and second innings, pass batting and bowling teams,
		// total overs
		// set first and second innings objects in match
		Innings firstInnings = new FirstInnings(match.getTossWinner(), match.getTossLooser(), 1);
		match.setFirstInnings(firstInnings);

		SecondInnings secondInnings = new SecondInnings(match.getTossLooser(), match.getTossWinner(), 1);
		match.setSecondInnings(secondInnings);

		// simulate match
		match.play();

		// print match summary
		CommentryGenerator.printMatchSummary(match);

	}

}
