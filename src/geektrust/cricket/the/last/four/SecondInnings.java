package geektrust.cricket.the.last.four;

import geektrust.cricket.the.last.four.pojo.Team;
import geektrust.cricket.the.last.four.util.CommentryGenerator;
import geektrust.cricket.the.last.four.util.InningsHelperUtil;

public class SecondInnings extends Innings {

	private int target;

	public SecondInnings(Team battingTeam, Team bowlingTeam, int overs) {
		super(battingTeam, bowlingTeam, overs, battingTeam.getPlayers().length - 1);
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	// simulate innings return total runs scored by batting team
	@Override
	public void simualteInnings() {
		System.out.println(battingTeam.getName() + " innings:");
		for (int i = bowlsRemaining; i >= 1; i--) {
			if (isTargetAchieved() || wicketsRemaining == 0) {
				break;
			} else {
				playBall();
			}
		}
	}

	protected void playBall() {

		balls++;
		if (InningsHelperUtil.isOverComplete(bowlsRemaining)) {
			CommentryGenerator.printOverCommentry(bowlsRemaining, target - getBattingTeam().getTotalRuns());

			// change strike and numbers of balls if over has been
			// completed
			// and it's not first over
			if (totalOvers * 6 != bowlsRemaining) {
				// over completed change ball number if 6 balls have
				// been
				// thrown
				// next ball will be 1.1
				// ball += (totalOvers-bowlsRemaining/6)+
				changeStrike();
				overs++;
				balls = 1;
			}

		}

		bowlsRemaining--;
		int runsOnBall = striker.hitRuns();
		// considering 7 runs as out
		if (runsOnBall == 7) {
			out();
		} else if (runsOnBall == 1 || runsOnBall == 3 || runsOnBall == 5) {
			takeRuns(runsOnBall, overs, balls);
			changeStrike();
		} else {
			takeRuns(runsOnBall, overs, balls);
		}

	}

	private boolean isTargetAchieved() {
		return target - battingTeam.getTotalRuns() <= 0;
	}
}
