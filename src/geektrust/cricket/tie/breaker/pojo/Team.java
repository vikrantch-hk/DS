package geektrust.cricket.tie.breaker.pojo;

import geektrust.cricket.tie.breaker.factory.RunsFactory;

public class Team {
	String name;
	boolean isTossWinner;
	Player[] players;
	int totalRuns;

	public int getTotalRuns() {
		return totalRuns;
	}

	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}

	public Team(String name, Player[] players) {
		this.name = name;
		this.players = players;
		RunsFactory.setRunProbability(players);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isTossWinner() {
		return isTossWinner;
	}

	public void setTossWinner(boolean isTossWinner) {
		this.isTossWinner = isTossWinner;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

}