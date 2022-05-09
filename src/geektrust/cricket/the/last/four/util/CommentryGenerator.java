package geektrust.cricket.the.last.four.util;

import java.util.Arrays;

import geektrust.cricket.the.last.four.SingleInningMatch;

public class CommentryGenerator {
	public static void printOverCommentry(int bowlsRemaining, int remainingTarget) {
		System.out.println();
		System.out.println(bowlsRemaining / 6 + " overs left. " + remainingTarget + " runs to win");
		System.out.println();
	}

	public static void printPerBallRunsCommentry(String strikerName, int overs, int balls, int runsOnBall) {
		System.out.println(overs + "." + balls + " " + strikerName + " scores " + runsOnBall+" runs");
	}

	public static void printPerBallOutCommentry(String strikerName, int overs, int balls, int wicketsRemaining, String team) {
		System.out.println(overs + "." + balls + " " + strikerName + " gets out ");
		if(wicketsRemaining==0)
			System.out.print(team+" all out");
		System.out.println();
	}

	public static void printNewPlayer(String name) {
		System.out.println("new player " + name);
	}

	public static void printSingleInningMatchSummary(SingleInningMatch match) {
		System.out.println("----------------------------------------");
		if (match.getTossLooser().equals(match.getMatchWinner())) {
			System.out.println(
					match.getMatchWinner().getName() + " won by " + match.getSecondInnings().getWicketsRemaining()
							+ " wicket and " + (match.getSecondInnings().getBowlsRemaining()) + " balls remaining");
		} else {
			System.out.println(match.getMatchWinner().getName() + " won by "
					+ (match.getSecondInnings().getTarget() - match.getSecondInnings().getBattingTeam().getTotalRuns())
					+ " runs ");
		}
		System.out.println();

		Arrays.stream(match.getTossLooser().getPlayers()).forEach(p -> {
			System.out.println(p.getName() + " - " + p.getRuns() + "(" + p.balls + " balls)");
		});
	}

}
