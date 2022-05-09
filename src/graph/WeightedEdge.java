package graph;

public class WeightedEdge {

	String target;
	int weight;

	public WeightedEdge(String target, int weight) {
		super();
		this.target = target;
		this.weight = weight;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
