package geektrust.cricket.the.last.four.factory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import geektrust.cricket.the.last.four.pojo.Player;
import geektrust.cricket.the.last.four.util.DistributedRandomNumberGenerator;

public class RunsFactory {

	public static Map<String, DistributedRandomNumberGenerator> map = new HashMap<String, DistributedRandomNumberGenerator>();

	public static void setRunProbability(Player player) {
		DistributedRandomNumberGenerator drng = new DistributedRandomNumberGenerator();
		double[] runsProbability = player.getRunsProbability();
		for (int i = 0; i < runsProbability.length; i++) {
			drng.addNumber(i, runsProbability[i]);
		}
		map.put(player.getName(), drng);
	}

	public static void setRunProbability(Player[] players) {
		Arrays.stream(players).forEach(player -> {
			setRunProbability(player);
		});
	}
}
