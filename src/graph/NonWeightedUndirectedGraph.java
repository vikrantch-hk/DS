package graph;

import java.util.LinkedList;

public class NonWeightedUndirectedGraph {
	private LinkedList<Integer> edges[];

	public NonWeightedUndirectedGraph(int totalVertices) {
		edges = new LinkedList[totalVertices];
		for(int i=0;i<totalVertices;i++)
		{
			edges[i]=new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int source,int target)
	{
		edges[source].add(target);
		edges[target].add(source);
	}
	
	public void printGraph()
	{
		for(int i=0;i<edges.length;i++)
		{
			System.out.print(i+"->");
			LinkedList<Integer> neighbours = edges[i];
			for(int j=0;j<neighbours.size();j++)
			{
				System.out.print(neighbours.get(j)+"->");
			}
			System.out.println();
		}
	}
	
	
	
	public static void main(String[] args) {
		NonWeightedUndirectedGraph g = new NonWeightedUndirectedGraph(10);
		g.addEdge(0, 2);
		g.addEdge(0, 5);
		g.addEdge(2, 5);
		g.addEdge(9, 3);
		g.addEdge(5, 3);

		
		g.printGraph();
	}
}
