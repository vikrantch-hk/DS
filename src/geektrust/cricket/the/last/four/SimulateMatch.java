package geektrust.cricket.the.last.four;

import geektrust.cricket.the.last.four.pojo.Player;
import geektrust.cricket.the.last.four.pojo.Team;
import geektrust.cricket.the.last.four.util.CommentryGenerator;

// this is main class
public class SimulateMatch {

	public static void main(String[] args) {

		// create match object pass it 2 teams
		Team team1 = new Team("Lengaburu", new Player[] {
				new Player("Kirat Boli", new double[] { 0.05d, 0.3d, 0.25d, 0.1d, 0.15d, 0.01d, 0.09d, 0.05d }),
				new Player("N.S Nodhi", new double[] { 0.1d, 0.4d, 0.2d, 0.05d, 0.1d, 0.01d, 0.04d, 0.1d }),
				new Player("R Rumrah", new double[] { 0.2d, 0.3d, 0.15d, 0.05d, 0.05d, 0.01d, 0.04d, 0.2d }),
				new Player("Shashi Henra", new double[] { 0.3d, 0.25d, 0.05d, 0.0d, 0.05d, 0.01d, 0.04d, 0.3d }) });

		Team team2 = new Team("Enchai", new Player[] {});

		SingleInningMatch match = new SingleInningMatch(new Team[] { team1, team2 });

		// set Enchai toss winner
		match.setTossWinner(match.getTeams()[1]);
		match.setTossLooser(match.getTeams()[0]);

		SecondInnings secondInnings = new SecondInnings(match.getTossLooser(), match.getTossWinner(), 4);
		match.setSecondInnings(secondInnings);

		// simulate match
		match.play();

		// print match summary
		CommentryGenerator.printSingleInningMatchSummary(match);

	}

}
