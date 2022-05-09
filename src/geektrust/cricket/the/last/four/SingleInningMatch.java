package geektrust.cricket.the.last.four;

import geektrust.cricket.the.last.four.pojo.Team;

public class SingleInningMatch {

	Team[] teams = new Team[2];
	Innings firstInnings;
	SecondInnings secondInnings;
	Team tossWinner;
	Team tossLooser;
	Team matchWinner;
	int target;

	public SingleInningMatch(Team[] teams) {
		super();
		this.teams = teams;
	}

	public Team[] getTeams() {
		return teams;
	}

	public void setTeams(Team[] teams) {
		this.teams = teams;
	}

	public Innings getFirstInnings() {
		return firstInnings;
	}

	public void setFirstInnings(Innings firstInnings) {
		this.firstInnings = firstInnings;
	}

	public SecondInnings getSecondInnings() {
		return secondInnings;
	}

	public void setSecondInnings(SecondInnings secondInnings) {
		this.secondInnings = secondInnings;
	}

	public Team getMatchWinner() {
		return matchWinner;
	}

	public void setMatchWinner(Team matchWinner) {
		this.matchWinner = matchWinner;
	}

	public Team getTossLooser() {
		return tossLooser;
	}

	public void setTossLooser(Team tossLooser) {
		this.tossLooser = tossLooser;
	}

	public Team getTossWinner() {
		return tossWinner;
	}

	public void setTossWinner(Team tossWinner) {
		this.tossWinner = tossWinner;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public void play() {
		// set the target of 40 runs
		setTarget(40);

		// start second innings
		secondInnings.setTarget(40);
		secondInnings.simualteInnings();
		
		int secondInnigsRuns = secondInnings.getBattingTeam().getTotalRuns();

		// set match winner
		if (target - secondInnigsRuns <= 0) {
			setMatchWinner(secondInnings.getBattingTeam());
		} else {
			setMatchWinner(secondInnings.getBowlingTeam());
		}
	}

}
