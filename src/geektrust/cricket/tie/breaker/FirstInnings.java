package geektrust.cricket.tie.breaker;

import geektrust.cricket.tie.breaker.pojo.Team;

public class FirstInnings extends Innings {

	public FirstInnings(Team battingTeam, Team bowlingTeam, int overs) {
		super(battingTeam, bowlingTeam, overs, battingTeam.getPlayers().length - 1);
	}

	// simulate innings return total runs scored by batting team
	@Override
	public void simualteInnings() {
		System.out.println(battingTeam.getName()+" innings:");
		for (int i = bowlsRemaining; i >= 1; i--) {
			if (wicketsRemaining == 0) {
				break;
			} else {
				playBall();
			}
		}
	}

}
