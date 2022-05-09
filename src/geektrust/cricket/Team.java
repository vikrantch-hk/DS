package geektrust.cricket;

import java.util.ArrayList;
import java.util.List;

import geektrust.cricket.Main.DECISION;

public class Team {
		String name;
		boolean isTossWinner;
		DECISION decision;
		Player[] players;
		int totalRuns;

		public int getTotalRuns() {
			return totalRuns;
		}
		public void setTotalRuns(int totalRuns) {
			this.totalRuns = totalRuns;
		}
		public Team(String name, Player[] players) {
			this.name=name;
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

		public DECISION getDecision() {
			return decision;
		}

		public void setDecision(DECISION decision) {
			this.decision = decision;
		}

		public Player[] getPlayers() {
			return players;
		}

		public void setPlayers(Player[] players) {
			this.players = players;
		}

	}