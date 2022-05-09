package geektrust.cricket.tie.breaker.util;

import java.util.Arrays;

import geektrust.cricket.tie.breaker.Match;

public class CommentryGenerator {

	public static void printPerBallRunsCommentry(String strikerName, int overs, int balls, int runsOnBall) {
		System.out.println(overs + "." + balls + " " + strikerName + " scores " + runsOnBall+" runs");
	}

	public static void printPerBallOutCommentry(String strikerName, int overs, int balls, int wicketsRemaining, String team) {
		System.out.println(overs + "." + balls + " " + strikerName + " gets out ");
		if(wicketsRemaining==0)
			System.out.print(team+" all out");
		System.out.println();
	}

	public static void printMatchSummary(Match match) {
		System.out.println("----------------------------------------");
		System.out.println(match.getMatchWinner().getName() + " won with "
				+ (match.getSecondInnings().getBowlsRemaining()) + " balls remaining");
		System.out.println();

		System.out.println(match.getTossWinner().getName());
		Arrays.stream(match.getTossWinner().getPlayers()).forEach(p -> {
			System.out.println(p.getName() + " - " + p.getRuns() + "(" + p.balls + " balls)");
		});

		System.out.println();
		System.out.println(match.getTossLooser().getName());
		Arrays.stream(match.getTossLooser().getPlayers()).forEach(p -> {
			System.out.println(p.getName() + " - " + p.getRuns() + "(" + p.balls + " balls)");
		});
	}

	public static void printNewPlayer(String name) {
		System.out.println("new player " + name);
	}

}
