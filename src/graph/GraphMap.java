package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class GraphMap {

	Map<String, List<String>> edges = new HashMap<String, List<String>>();

	public void addEdge(String s, String t) {
		List<String> neighbours = null;
		if (edges.containsKey(s)) {
			neighbours = edges.get(s);
		} else {
			neighbours = new LinkedList<String>();
		}
		neighbours.add(t);
		edges.put(s, neighbours);
	}

	public void printGraph() {
		System.out.println("graph ");
		Iterator<Entry<String, List<String>>> itr = edges.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, List<String>> entry = itr.next();
			List<String> neighbours = entry.getValue();
			for (String neighbour : neighbours) {
				System.out.print(entry.getKey() + "->" + neighbour);
			}
		}
	}

	// O(V+E)
	public void bfs(String start) {
		Queue<String> q = new LinkedList<String>();
		List<String> visited = new LinkedList<String>();
		q.add(start);
		visited.add(start);
		System.out.println("BFS");
		while (!q.isEmpty()) {
			String node = q.poll();
			System.out.println(node);
			List<String> neighbours = edges.get(node);
			if (neighbours != null) {
				for (String neighbour : neighbours) {
					if (!visited.contains(neighbour)) {
						q.add(neighbour);
						visited.add(neighbour);
					}
				}
			}
		}

	}

	public void dfs(String start) {
		Stack<String> stack = new Stack<String>();
		stack.push(start);
		List<String> visited = new LinkedList<String>();
		visited.add(start);
		System.out.println("DFS iterative");
		while (!stack.isEmpty()) {
			String node = stack.pop();
			System.out.println(node);
			List<String> neighbours = edges.get(node);
			if (neighbours != null) {
				for (String neighbour : neighbours) {
					if (!visited.contains(neighbour)) {
						visited.add(neighbour);
						stack.push(neighbour);
					}
				}
			}
		}
	}

	// Depth first search is more memory efficient than breadth first search as
	// you can backtrack sooner.
	public boolean isConnected(String s, String t) {
		Stack<String> stack = new Stack<String>();
		List<String> visited = new ArrayList<String>();
		stack.add(s);
		visited.add(s);
		while (!stack.isEmpty()) {
			String node = stack.pop();
			List<String> neighbours = edges.get(node);
			if (neighbours != null) {
				for (int i = 0; i < neighbours.size(); i++) {
					if (neighbours.get(i).equals(t)) {
						return true;
					}
					if (!visited.contains(neighbours.get(i))) {
						stack.add(neighbours.get(i));
						visited.add(neighbours.get(i));
					}
				}
			}
		}
		return false;
	}

	public boolean isConnectedRecursiveDFS(String s, String t) {
		List<String> visited = new ArrayList<String>();
		return isConnectedRecursiveDFSUtil(s, t, visited);

	}

	private boolean isConnectedRecursiveDFSUtil(String s, String t, List<String> visited) {
		// TODO Auto-generated method stub
		visited.add(s);
		List<String> neighbours = edges.get(s);
		if (neighbours != null) {
			for (String neighbour : neighbours) {
				if (neighbour.equals(t))
					return true;
				if (!visited.contains(neighbour) && isConnectedRecursiveDFSUtil(neighbour, t, visited))
					return true;
			}
		}
		return false;
	}

	// Once DFS finds a cycle, the stack will contain the nodes forming the
	// cycle. The same is not true for BFS
	public boolean isCyclic() {
		Iterator<Entry<String, List<String>>> itr = edges.entrySet().iterator();
		List<String> visited = new LinkedList<String>();
		Queue<String> recursionQ = new LinkedList<String>();
		while (itr.hasNext()) {
			Entry<String, List<String>> entry = itr.next();
			if (hasCycle(entry.getKey(), visited, recursionQ)) {
				System.out.println("cycle path ");
				recursionQ.forEach(s -> System.out.print(s + "->"));
				return true;
			}

			visited.clear();
			recursionQ.clear();
		}
		return false;
	}

	private boolean hasCycle(String start, List<String> visited, Queue<String> recursionStack) {
		if(!visited.contains(start))
		{
		visited.add(start);
		recursionStack.add(start);
		List<String> neighbours = edges.get(start);
		if (neighbours != null) {
			for (String neighbour : neighbours) {
				if (!visited.contains(neighbour) && hasCycle(neighbour, visited, recursionStack)) {
					return true;
				}
				if (visited.contains(neighbour) && recursionStack.contains(neighbour))
					return true;
			}
		}}
		recursionStack.remove(start);
		return false;
	}

	public void dfsRecursive(String start) {
		System.out.println("dfsRecursive");
		List<String> visited = new LinkedList<String>();
		dfsRecursiveUtil(start, visited);
	}

	private void dfsRecursiveUtil(String start, List<String> visited) {
		visited.add(start);
		System.out.print(start + "->");
		List<String> neighbours = edges.get(start);
		if (neighbours != null) {
			for (String neighbour : neighbours) {
				if (!visited.contains(neighbour)) {
					dfsRecursiveUtil(neighbour, visited);
				}
			}
		}
	}

	public void getDistanceOfEachNode(String start) {
		Map<String, Integer> distances = new HashMap<String, Integer>();
		Iterator<Entry<String, List<String>>> itr = edges.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, List<String>> entry = itr.next();
			// put source in map
			distances.put(entry.getKey(), -1);
			// put each neighbour in map
			entry.getValue().forEach(neighbour -> distances.put(neighbour, -1));
		}
		// put distace from evry other node as -1 except same node set 0 from
		// same node
		distances.put(start, 0);

		// will use bfs to traverse each neighbour is having +1 distance from
		// node
		Queue<String> q = new LinkedList<String>();
		List<String> visited = new ArrayList<String>();
		q.add(start);
		visited.add(start);
		while (!q.isEmpty()) {
			String node = q.poll();
			List<String> neighbours = edges.get(node);
			if (neighbours != null) {
				for (String neighbour : neighbours) {
					if (!visited.contains(neighbour)) {
						visited.add(neighbour);
						distances.put(neighbour, distances.get(node) + 1);
						//q.add(neighbour);
						q.offer(neighbour);
					}

				}
			}
		}

		System.out.println("distances");
		for (Entry entry : distances.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	public void topoSort() {
		List<Integer> inDegrees = new ArrayList<Integer>();
		System.out.println("toposort");
		Map<String, Integer> indegrees = calculateIndegree();

		inDegrees.forEach(i -> System.out.print(i));
	}

	private Map<String, Integer> calculateIndegree() {
		// TODO Auto-generated method stub

		return null;
	}

	public Map<String, Integer> inDegree() {
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (Entry<String, List<String>> entry : edges.entrySet()) {
			result.put(entry.getKey(), 0);
			List<String> neighbours = entry.getValue();
			neighbours.forEach(s -> result.put(s, 0));
		} // All in-degrees are 0
		for (String from : edges.keySet()) {
			for (String to : edges.get(from)) {
				result.put(to, result.get(to) + 1); // Increment in-degree
			}
		}
		result.forEach((s, v) -> System.out.print("indegree " + s + " " + v));
		return result;

	}

	/**
	 * Report (as a List) the topological sort of the vertices; null for no such
	 * sort.
	 */
	public List<String> topSort() {
		Map<String, Integer> degree = inDegree();
		int vertexCnt = degree.size();// no of nodes or vertices
		// Determine all vertices with zero in-degree
		Stack<String> zeroVerts = new Stack<String>(); // Stack as good as any
														// here
		for (String v : degree.keySet()) {
			if (degree.get(v) == 0)
				zeroVerts.push(v);
		}
		// Determine the topological order
		List<String> result = new ArrayList<String>();
		while (!zeroVerts.isEmpty()) {
			String v = zeroVerts.pop(); // Choose a vertex with zero in-degree
			result.add(v); // Vertex v is next in topol order
			// "Remove" vertex v by updating its neighbors
			List<String> neighbors = edges.get(v);
			if (neighbors != null) {
				for (String neighbor : neighbors) {
					degree.put(neighbor, degree.get(neighbor) - 1);
					// Remember any vertices that now have zero in-degree
					if (degree.get(neighbor) == 0)
						zeroVerts.push(neighbor);
				}
			}
		}
		// Check that we have used the entire graph (if not, there was a cycle)
		if (result.size() != vertexCnt) {
			System.out.println("  there is a cycle");
			return null;
		}
		return result;
	}

	public int shortestDistance(String s, String t) {
		Map<String, Integer> distances = new HashMap<String, Integer>();
		edges.forEach((k, v) -> {
			distances.put(k, -1);
			v.forEach(i -> {
				distances.put(i, -1);
			});
		});

		// set distance of each node -1
		distances.put(s, 0);
		// set distance of source node 0

		// bfs
		Queue<String> q = new LinkedList<String>();
		q.add(s);
		while (!q.isEmpty()) {
			String node = q.poll();
			List<String> neighbours = edges.get(node);
			if (neighbours != null) {
				neighbours.forEach(neighbour -> {
					if (distances.get(neighbour).equals(-1)) {
						distances.put(neighbour, distances.get(node) + 1);
						q.add(neighbour);
					}
				});
			}
		}

		return distances.get(t);
	}

	public static void main(String[] args) {
		GraphMap g = new GraphMap();
		g.addEdge("DEL", "MUM");
		// g.addEdge("MUM", "DEL");
		g.addEdge("MUM", "BLR");
		//g.addEdge("BLR", "DEL");<r<
		//g.addEdge("DEL", "LKO");
		g.addEdge("DEL", "JPR");
		g.addEdge("MUM", "LKO");
		g.addEdge("BLR", "LKO");
		g.printGraph();
		System.out.println("connected " + g.isConnected("DEL", "BLR"));
		System.out.println("connected recursive" + g.isConnectedRecursiveDFS("JPR", "BLR"));
		System.out.println("cycle " + g.isCyclic());
		g.dfsRecursive("DEL");
		g.getDistanceOfEachNode("DEL");
		g.bfs("DEL");
		g.dfs("DEL");
		if (g.topSort() != null)
			g.topSort().forEach(i -> System.out.print(i + "->"));
		System.out.println("shortestDistance" + g.shortestDistance("DEL", "BLR"));
	}

}
