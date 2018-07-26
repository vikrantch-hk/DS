package com.practice.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph {

	Map<String, List<String>> edges = new HashMap<String, List<String>>();

	public void add(String source, String destination) {
		List<String> destinations = new ArrayList<>();
		if (edges.containsKey(source)) {
			destinations = edges.get(source);
		}
		destinations.add(destination);
		edges.put(source, destinations);

	}

	public void bfs(String start) {
		Queue<String> q = new LinkedList<>();
		List<String> visited = new ArrayList<>();
		visited.add(start);
		q.offer(start);
		while (!q.isEmpty()) {
			String node = q.poll();
			System.out.print(node + "-->");
			if (node != null) {
				List<String> destinations = edges.get(node);
				if (destinations != null) {
					destinations.forEach(destination -> {
						if (!visited.contains(destination)) {
							visited.add(destination);
							q.offer(destination);
						}
					});
				}
			}

		}
	}

	public Map<String, Integer> inDegree() {

		Map<String, Integer> inDegree = new HashMap<>();
		edges.forEach((source, destinations) -> {
			inDegree.put(source, 0);
			destinations.forEach(destination -> {
				inDegree.put(destination, 0);
			});
		});

		edges.keySet().forEach(source -> {
			List<String> destinations = edges.get(source);
			destinations.forEach(destination -> {
				inDegree.put(destination, inDegree.get(destination) + 1);
			});
		});
		return inDegree;
	}

	/*You visited a list of places recently, but you do not remember the
	order in which you visited them. You have with you the airplane
	tickets that you used for traveling. Each ticket contains just the
	start location and the end location. Can you reconstruct your journey?*/
	public void topoSort() {
		Map<String, Integer> inDegree = inDegree();
		Queue<String> zeroIndegree = new LinkedList<>();
		inDegree.forEach((node, value) -> {
			if (value == 0) {
				zeroIndegree.offer(node);

			}

		});

		while (!zeroIndegree.isEmpty()) {
			String node = zeroIndegree.poll();
			System.out.print(node + "-->");
			List<String> destinations = edges.get(node);
			if (destinations != null) {
				destinations.forEach(destination -> {
					//System.out.println(destination + " " + inDegree.get(destination));
					inDegree.put(destination, inDegree.get(destination) - 1);
					if (inDegree.get(destination).equals(0)) {
						//System.out.println(destination);
						zeroIndegree.offer(destination);
					}
				});
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		// g.add("Del", "Mum");
		g.add("Mum", "Agr");
		g.add("Agr", "Lko");
		g.add("Lko", "Blr");
		g.add("Blr", "Del");
		g.bfs("Del");
		Map<String, Integer> inDegree = g.inDegree();
		inDegree.forEach((k, v) -> {
			System.out.println(k + "-->" + v);
		});
		g.add("Lko", "Del");
		g.add("Mum", "Blr");
		g.add("Agr", "Del");
		inDegree = g.inDegree();
		inDegree.forEach((k, v) -> {
			System.out.println(k + "-->" + v);
		});
		g.add("Kol", "Jpr");
		g.add("Jpr", "Agr");
		g.add("Del", "Ggn");
		System.out.println();
		g.topoSort();
	}
}
