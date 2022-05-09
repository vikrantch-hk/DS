package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import trie.TrieNode;

public class NonWeightedGraph {

	private List<Integer> edges[];
	int[] predecessor = null;

	public NonWeightedGraph(int vertices) {
		edges = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			edges[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int source, int target) {
		edges[source].add(target);
	}

	public boolean isConnected(int start, int end) {
		// below algo is BFS
		if (start == end)
			return true;
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> visited = new ArrayList<Integer>();
		visited.add(start);
		queue.add(start);
		while (!queue.isEmpty()) {
			int node = queue.poll();
			List<Integer> neigbhours = edges[node];
			for (Integer neigbhour : neigbhours) {
				if (neigbhour.equals(end)) {
					return true;
				}
				if (!visited.contains(neigbhour)) {
					visited.add(neigbhour);
					queue.add(neigbhour);
				}
			}
		}
		return false;
	}

	public void printGraph() {
		for (int i = 0; i < edges.length; i++) {
			List<Integer> list = edges[i];
			for (int indx = 0; indx < list.size(); indx++) {
				System.out.println(i + "->" + list.get(indx));
			}
		}
		// System.out.println();
	}

	public void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> visited = new ArrayList<Integer>();
		queue.add(start);
		visited.add(start);
		System.out.println("bfs");
		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print("->" + node);
			List<Integer> neighbours = edges[node];
			for (int i = 0; i < neighbours.size(); i++) {
				if (!visited.contains(neighbours.get(i))) {
					visited.add(neighbours.get(i));
					queue.add(neighbours.get(i));
				}

			}
		}

	}

	public void dfs(int start) {
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> visited = new ArrayList<Integer>();
		stack.push(start);
		visited.add(start);
		System.out.println("dfs");
		while (!stack.isEmpty()) {
			int node = stack.pop();
			System.out.print("->" + node);
			List<Integer> neighbours = edges[node];
			for (int i = 0; i < neighbours.size(); i++) {
				if (!visited.contains(neighbours.get(i))) {
					visited.add(neighbours.get(i));
					stack.push(neighbours.get(i));
				}

			}
		}

	}

	public void dfsRecursive(int start) {
		List<Integer> visited = new ArrayList<Integer>();
		dfsRecursiveUtil(start, visited);
	}

	public void dfsRecursiveUtil(int node, List<Integer> visited) {

		visited.add(node);
		System.out.print(node + "->");
		List<Integer> neighbours = edges[node];
		for (int i = 0; i < neighbours.size(); i++) {
			if (!visited.contains(neighbours.get(i))) {
				dfsRecursiveUtil(neighbours.get(i), visited);
			}

		}
	}

	
	// application of topological sorting is in scheduling a sequence of jobs or tasks based on their dependencies
	// algorithm is simply DFS with an extra stack. So time complexity is same as DFS which is O(V+E).
	public void topologicalSort() {
		// A DAG G has at least one vertex with in-degree 0 and one vertex with
		// out-degree 0.
		int[] inDegree = new int[edges.length];
		for (int i = 0; i < edges.length; i++) {
			List<Integer> children = edges[i];
			for (int j = 0; j < children.size(); j++) {
				int child = children.get(j);
				inDegree[child]++;
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < edges.length; i++) {
			if (inDegree[i] == 0)
				queue.add(i);
		}
		Queue<Integer> topoSort = new LinkedList<Integer>();
		int count = 0;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			topoSort.add(node);
			count++;
			for (int child : edges[node]) {
				// If in-degree becomes zero, add it to queue
				if (--inDegree[child] == 0)
					queue.add(child);
			}
		}
		if (count != edges.length) {
			System.out.println("topological cycle in graph");
		}
		System.out.println("topological sort is");
		for (int i : topoSort)
			System.out.print(i + "->");

	}

	public boolean isCyclic() {
		// mark all the vertices not visited
		// boolean visited[] = new boolean[edges.length];
		
		for (int i = 0; i < edges.length; i++) {
			boolean recStack[] = new boolean[edges.length];
			List<Integer> visited = new ArrayList<Integer>();
			if (isCyclicUtil(i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}

	private boolean isCyclicUtil(int node, List<Integer> visited, boolean[] recStack) {
		/*
		 * There is a cycle in a graph only if there is a back edge present in
		 * the graph. A back edge is an edge that is from a node to itself
		 * (selfloop) or one of its ancestor in the tree produced by DFS. To
		 * detect a back edge, we can keep track of vertices currently in
		 * recursion stack of function for DFS traversal. If we reach a vertex
		 * that is already in the recursion stack, then there is a cycle in the
		 * tree.
		 */
		// mark current node as visited and part of recursion stack

		visited.add(node);
		recStack[node] = true;
		List<Integer> neighbours = edges[node];
		for (int i = 0; i < neighbours.size(); i++) {
			int n = neighbours.get(i);
			if (!visited.contains(n) && isCyclicUtil(n, visited, recStack)) {
				return true;
			} else if (recStack[n]) {
				return true;
			}
		}
		recStack[node] = false; // remove the vertex from recursion stack
		return false;
	}

	public int unweightedShortestPath(int source, int target) {
		// do BFS and compute ditance of each other node from given node
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		int[] distances = new int[edges.length];
		// intialize distance of every node from curr as -1
		for (int i = 0; i < distances.length; i++)
			distances[i] = -1;
		distances[source] = 0;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			List<Integer> neighbours = edges[node];
			for (int i = 0; i < neighbours.size(); i++) {
				if (distances[neighbours.get(i)] == -1) // each vertex examined
														// at most once and
														// since its neighbour
														// so min dist
				{
					distances[neighbours.get(i)] = distances[node] + 1;
					queue.add(neighbours.get(i));
				}
			}
		}

		return distances[target];
	}

	public static void main(String[] args) {
		NonWeightedGraph g = new NonWeightedGraph(10);
		g.addEdge(0, 2);

		g.addEdge(0, 5);
		g.addEdge(2, 5);
		// g.addEdge(5, 0);
		g.addEdge(5, 4);

		g.addEdge(3, 9);
		g.addEdge(4, 9);
		g.addEdge(5, 4);
		g.addEdge(9, 5);
		// g.addEdge(5, 3);

		g.printGraph();
		System.out.println("is connected" + g.isConnected(0, 3));
		g.bfs(0);
		g.dfs(0);
		System.out.println("dfsRecursive ");
		g.dfsRecursive(0);
		g.topologicalSort();
		System.out.println("iscyclic" + g.isCyclic());
		System.out.println("shortest dist from node is" + g.unweightedShortestPath(0, 9));
	}

}
