package geektrust.cricket.tie.breaker;

import geektrust.cricket.tie.breaker.pojo.Player;
import geektrust.cricket.tie.breaker.pojo.Team;
import geektrust.cricket.tie.breaker.util.CommentryGenerator;
import geektrust.cricket.tie.breaker.util.InningsHelperUtil;

public abstract class Innings {
	protected Team battingTeam;
	protected Team bowlingTeam;
	protected Player striker;
	protected Player nonStriker;
	protected int totalOvers;
	protected int bowlsRemaining;
	protected int wicketsRemaining;
	protected int overs;
	protected int balls;
	private int lastBatsManIndex;

	public Innings(Team battingTeam, Team bowlingTeam, int totalOvers, int wicketsRemaining) {
		this.totalOvers = totalOvers;
		this.battingTeam = battingTeam;
		this.bowlingTeam = bowlingTeam;
		this.bowlsRemaining = totalOvers * 6;
		this.wicketsRemaining = wicketsRemaining;
		this.overs = 0;
		this.balls = 0;
		this.lastBatsManIndex = 1;
		striker = battingTeam.getPlayers()[0];
		nonStriker = battingTeam.getPlayers()[1];
	}

	public Team getBattingTeam() {
		return battingTeam;
	}

	public void setBattingTeam(Team battingTeam) {
		this.battingTeam = battingTeam;
	}

	public Team getBowlingTeam() {
		return bowlingTeam;
	}

	public void setBowlingTeam(Team bowlingTeam) {
		this.bowlingTeam = bowlingTeam;
	}

	public Player getStriker() {
		return striker;
	}

	public void setStriker(Player striker) {
		this.striker = striker;
	}

	public Player getNonStriker() {
		return nonStriker;
	}

	public void setNonStriker(Player nonStriker) {
		this.nonStriker = nonStriker;
	}

	public int getTotalOvers() {
		return totalOvers;
	}

	public void setTotalOvers(int totalOvers) {
		this.totalOvers = totalOvers;
	}

	public int getBowlsRemaining() {
		return bowlsRemaining;
	}

	public void setBowlsRemaining(int bowlsRemaining) {
		this.bowlsRemaining = bowlsRemaining;
	}

	public int getWicketsRemaining() {
		return wicketsRemaining;
	}

	public void setWicketsRemaining(int wicketsRemaining) {
		this.wicketsRemaining = wicketsRemaining;
	}

	public int getOvers() {
		return overs;
	}

	public void setOvers(int overs) {
		this.overs = overs;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}

	protected abstract void simualteInnings();

	protected void playBall() {

		balls++;
		if (InningsHelperUtil.isOverComplete(bowlsRemaining)) {
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

	protected void takeRuns(int runsOnBall, int overs, int balls) {
		CommentryGenerator.printPerBallRunsCommentry(striker.getName(), overs, balls, runsOnBall);
		striker.runs += runsOnBall;
		striker.balls++;
		battingTeam.setTotalRuns(battingTeam.getTotalRuns() + runsOnBall);
	}

	protected void out() {
		striker.balls++;
		wicketsRemaining--;
		CommentryGenerator.printPerBallOutCommentry(striker.getName(), overs, balls, wicketsRemaining,
				battingTeam.getName());
		if (bowlsRemaining > 0 && wicketsRemaining > 0) {
			striker = getNextBatsman();
			CommentryGenerator.printNewPlayer(striker.getName());

		}
	}

	protected void changeStrike() {
		Player temp = striker;
		striker = nonStriker;
		nonStriker = temp;
	}

	protected Player getNextBatsman() {
		return battingTeam.getPlayers()[++lastBatsManIndex];
	}

}
