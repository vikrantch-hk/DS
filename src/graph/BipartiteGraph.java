package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// https://www.glassdoor.co.in/Interview/Round-1-Q-2-n-x-2-matrix-of-integers-given-The-matrix-says-enmity-between-2-prisoners-Divide-the-prisoners-into-2-grou-QTN_3766562.htm

// https://www.geeksforgeeks.org/bipartite-graph/
public class BipartiteGraph {
	
	static Map<Integer,List<Integer>> edges = new HashMap<>();
	static Map<Integer,Integer> color=new HashMap<>();
	
	static void add(int x, int y) {
		if(edges.containsKey(x)) {
			List<Integer> neighbours = edges.get(x);
			neighbours.add(y);
		}
		
		List<Integer> neighbours = new ArrayList<>();
		neighbours.add(y);
		edges.put(x, neighbours);
	}
	
static boolean isBipartite(int start) {
	
	Queue<Integer> q = new LinkedList<>();
	q.add(start);
	color.put(start, 1);
	while (!q.isEmpty()) {
		
		Integer node = q.poll();
		int nodeColor = color.get(node);
		List<Integer> neighbours = edges.get(node);
		if(neighbours!=null) {
		for(int i=0;i<neighbours.size();i++) {
			if(!color.containsKey(neighbours.get(i))) {
				color.put(neighbours.get(i),(nodeColor==1?0:1));
				q.add(neighbours.get(i));
			}else if(color.get(neighbours.get(i))==nodeColor) {
				return false;
			}
		}
		}
	}
	return true;
	
	
}

public static void main(String[] args) {
	// {1,2,3 5,4}
	add(1, 2);
	add(2, 3);
	add(3, 5);
	add(5, 4);
	System.out.println(isBipartite(1));
	System.out.println("first group");
	color.entrySet().stream().filter(e->e.getValue()==1).forEach(e->System.out.println(e.getKey()));
	System.out.println("second group");
	color.entrySet().stream().filter(e->e.getValue()==0).forEach(e->System.out.println(e.getKey()));
}
}
