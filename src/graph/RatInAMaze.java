package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class RatInAMaze {
	static class Node{
		int x;
		int y;
		Node parent;
		public Node(int x,int y,Node parent) {
			this.x=x;
			this.y=y;
			this.parent = parent;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
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
			Node other = (Node) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
	
	// Driver code
		public static void main(String[] args) {
			RatInAMaze rat = new RatInAMaze(); 
	        int maze[][] = {    {1, 0, 1, 1, 0},
						        {1, 1, 1, 0, 1},
						        {0, 1, 0, 1, 1},
						        {1, 1, 1, 1, 1} }; 
			int knightPos[] = { 0, 0 };
			int targetPos[] = { 3, 4 };
			System.out.println(minStepToReachTarget(knightPos, targetPos, 3, maze));
		}

		private static int minStepToReachTarget(int[] knightPos, int[] targetPos, int n, int[][] maze) {
			List<Node> visited = new ArrayList<>();
			Queue<Node> q = new LinkedList<Node>();
			Node start = new Node(knightPos[0],knightPos[1],null);
			Node target = new Node(targetPos[0],targetPos[1],null);
			visited.add(start);
			q.add(start);
			int[] neighboursx={ 1,0 };
			int[] neighboursy= { 0,1 };
		
			while(!q.isEmpty()) {
				Node curr = q.poll();
				for(int i=0;i<neighboursx.length;i++) {
					Node neighbour = new Node(curr.x+neighboursx[i], curr.y+neighboursy[i], curr);
					if(neighbour.equals(target)) {
						Node parent = neighbour.parent;
						while(parent!=null) {
							System.out.println("x"+" "+parent.x  +"y"+" "+parent.y);
							parent=parent.parent;
						}
					}
					if(!visited.contains(neighbour) && isSafe(neighbour,n,maze)) {
						visited.add(neighbour);
						q.add(neighbour);
					}
				}
			}
			
			return -1;
		}


		private static boolean isSafe(Node neighbour, int n, int[][] maze) {
			return neighbour.x>=0 && neighbour.y >=0 && neighbour.x<maze.length && neighbour.y<maze[0].length && maze[neighbour.x][neighbour.y]==1;
		}
}
