package geektrust.cricket;

import java.util.HashMap;

public class DistributedRandomNumberGenerator {
	private HashMap<Integer, Double> distribution;
	private double distSum;

	public DistributedRandomNumberGenerator() {
		distribution = new HashMap<>();
	}

	public void addNumber(int value, double distribution) {
		if (this.distribution.get(value) != null) {
			distSum -= this.distribution.get(value);
		}
		this.distribution.put(value, distribution);
		distSum += distribution;
	}

	public int getDistributedRandomNumber() {
		double rand = Math.random();
		double ratio = 1.0f / distSum;
		double tempDist = 0;
		for (Integer i : distribution.keySet()) {
			tempDist += distribution.get(i);
			if (rand / ratio <= tempDist) {
				return i;
			}
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
        DistributedRandomNumberGenerator drng = new DistributedRandomNumberGenerator();
        drng.addNumber(0, 0.05d);
        drng.addNumber(1, 0.3d);
        drng.addNumber(2, 0.25d);
        drng.addNumber(3, 0.10d);
        drng.addNumber(4, 0.15d);
        drng.addNumber(5, 0.01d);
        drng.addNumber(6, 0.09d);
        drng.addNumber(7, 0.05d);

        int testCount = 1000000;

        for (int i = 0; i < testCount; i++) {
            int  random= drng.getDistributedRandomNumber();
            System.out.println(random);
        }

        
    }
}
