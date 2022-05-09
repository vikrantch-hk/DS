package geektrust.cricket.tie.breaker.pojo;

import geektrust.cricket.tie.breaker.factory.RunsFactory;

public class Player {
	private String name;
	boolean isBatting;
	boolean isStriker;
	public int runs;
	public int balls;
    double[] runsProbability = new double[8];
	
	public Player(String name, double[] runsProbability) {
		this.name=name;
		this.runsProbability=runsProbability;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isBatting() {
		return isBatting;
	}

	public void setBatting(boolean isBatting) {
		this.isBatting = isBatting;
	}

	public boolean isStriker() {
		return isStriker;
	}

	public void setStriker(boolean isStriker) {
		this.isStriker = isStriker;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}

	public double[] getRunsProbability() {
		return runsProbability;
	}

	public void setRunsProbability(double[] runsProbability) {
		this.runsProbability = runsProbability;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int hitRuns() {
		return RunsFactory.map.get(name).getDistributedRandomNumber();
	}
}
