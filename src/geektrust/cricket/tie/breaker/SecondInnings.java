package geektrust.cricket.tie.breaker;

import geektrust.cricket.tie.breaker.pojo.Team;

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
		System.out.println();
		System.out.println(battingTeam.getName() + " innings:");
		for (int i = bowlsRemaining; i >= 1; i--) {
			if (isTargetAchieved()) {
				System.out.print(battingTeam.getName() + " wins");
				System.out.println();
				break;
			} else if (wicketsRemaining == 0) {
				break;
			} else {
				playBall();
			}
		}
	}

	private boolean isTargetAchieved() {
		return battingTeam.getTotalRuns() - target >= 0;
	}
}
