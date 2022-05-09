package geektrust.cricket;

public class SimulateMatch {

	public static void main(String[] args) {
		Match match = new Match();
		float overBall = 0.1f;
		int lstManIndx = 1;
		System.out.println(match.bowlsRemaining / 6 + " overs left. " + match.target + " runs to win");
		for (int i = 24; i >= 1; i--, match.bowlsRemaining--, overBall += .1f) {
			if (i != 24 && i % 6 == 0) {
				System.out.println(match.bowlsRemaining / 6 + " overs left. " + match.target + " runs to win");
				overBall += .4f;
				Player temp = match.striker;
				match.striker = match.nonStriker;
				match.nonStriker = temp;
			}
			int hitRuns = match.striker.hitRuns();
			if (hitRuns == 7 && i != 24 && i % 6 == 0) {
				System.out.println(String.format("%.1f", overBall) + " " + match.striker.getName() + " out ");
				match.striker.balls++;
				match.wicketsRemaining--;
				match.striker = match.nonStriker;
				if (lstManIndx == 3) {
					match.winner = "Enchai";
					break;
				}
				match.nonStriker = match.players.get(lstManIndx + 1);
				lstManIndx++;
				System.out.println("new player " + match.striker.getName());
			} else if (hitRuns == 7) {
				System.out.println(String.format("%.1f", overBall) + " " + match.striker.getName() + " out ");
				match.striker.balls++;
				match.wicketsRemaining--;
				if (lstManIndx == 3) {
					match.winner = "Enchai";
					break;
				}
				match.striker = match.players.get(lstManIndx + 1);
				lstManIndx++;
				System.out.println("new player " + match.striker.getName());
			} else if (hitRuns == 1 || hitRuns == 3 || hitRuns == 5) {
				System.out.println(
						String.format("%.1f", overBall) + " " + match.striker.getName() + " scores " + hitRuns);

				match.striker.runs += hitRuns;
				match.striker.balls++;

				Player temp = match.striker;
				match.striker = match.nonStriker;
				match.nonStriker = temp;

			} else {
				System.out.println(
						String.format("%.1f", overBall) + " " + match.striker.getName() + " scores " + hitRuns);

				match.striker.runs += hitRuns;
				match.striker.balls++;
			}

			if (hitRuns != 7)
				match.target -= hitRuns;
			if (match.target <= 0) {
				match.winner = "Lengaburu";
				break;
			}

		}
		if (match.bowlsRemaining == 0 && match.target > 0)
			match.winner = "Enchai";

		if (match.winner.equals("Lengaburu"))
			System.out.println("Lengaburu won by " + match.wicketsRemaining + " wicket and " + match.bowlsRemaining--
					+ " balls remaining");
		else
			System.out.println("Lengaburu lost by " + match.target + " runs");
		match.players.forEach(p -> {
			System.out.println(p.getName() + " - " + p.getRuns() + "(" + p.balls + " balls)");
		});
	}

}
