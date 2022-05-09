package graph;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class WeightedGraphMap {

	Map<String, List<WeightedEdge>> edges = new HashMap<String, List<WeightedEdge>>();

	public void addEdge(String s, String t, int weight) {
		List<WeightedEdge> neighbours = null;
		if (edges.containsKey(s)) {
			neighbours = edges.get(s);
		} else {
			neighbours = new LinkedList<WeightedEdge>();

		}
		neighbours.add(new WeightedEdge(t, weight));
		edges.put(s, neighbours);
	}

	public void printGraph() {
		System.out.println("graph ");
		Iterator<Entry<String, List<WeightedEdge>>> itr = edges.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, List<WeightedEdge>> entry = itr.next();
			List<WeightedEdge> neighbours = entry.getValue();
			for (WeightedEdge neighbour : neighbours) {
				System.out.print(entry.getKey() + "->" + neighbour.target);
			}
		}
	}
	
    // Bell-Man ford
	// it is same as non wieghted graph min dist
	// only diff here is we use a priority q instead of q
	// implemented using treemap
	public void getMinimumDistanceOfEachNode(String start) {
		Map<String, Integer> distances = new HashMap<String, Integer>();
		Iterator<Entry<String, List<WeightedEdge>>> itr = edges.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, List<WeightedEdge>> entry = itr.next();
			// put source in map
			distances.put(entry.getKey(), Integer.MAX_VALUE);
			// put each neighbour in map
			entry.getValue().forEach(neighbour -> distances.put(neighbour.target, Integer.MAX_VALUE));
		}
		// put distace from evry other node as MAX_VALUE except same node set 0 from
		// same node
		distances.put(start, 0);
		
		// sort q according to distance
		Queue<String> q = new PriorityQueue<String>(Integer.MAX_VALUE, 
				(a, b) -> distances.get(a).compareTo(distances.get(b)));
		q.add(start);
		// will use bfs to traverse each neighbour is having +1 distance from
		// node
		while (!distances.isEmpty()) {
			String node = q.poll();
			List<WeightedEdge> neighbours = edges.get(node);
			if (neighbours != null) {
				for (WeightedEdge neighbour : neighbours) {
					if (distances.get(neighbour.target).equals(Integer.MAX_VALUE)
							|| (distances.get(node) + neighbour.weight) < distances.get(neighbour.target)) {
						distances.put(neighbour.target, distances.get(node) + neighbour.weight);
						q.add(neighbour.target);
					}
				}
			}
		}

		System.out.println("distances");
		for (Entry entry : distances.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	public static void main(String[] args) {
		WeightedGraphMap g = new WeightedGraphMap();
		g.addEdge("DEL", "MUM", 5);
		// g.addEdge("MUM", "DEL", 2);
		g.addEdge("MUM", "BLR", 1);
		// g.addEdge("BLR", "DEL");
		g.addEdge("DEL", "LKO", 8);
		g.addEdge("DEL", "JPR", 4);
		g.addEdge("MUM", "LKO", 2);
		g.addEdge("DEL", "BLR", 9);
		g.printGraph();
		g.getMinimumDistanceOfEachNode("DEL");
	}

}
