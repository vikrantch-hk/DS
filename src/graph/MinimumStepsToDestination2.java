package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumStepsToDestination2 {
	static class Node{
		int x;
		int y;
		int steps;
		public Node(int x,int y,int steps) {
			this.x=x;
			this.y=y;
			this.steps=steps;
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
			int N = 30;
			int knightPos[] = { 1, 1 };
			int targetPos[] = { 30, 30 };
			System.out.println(minStepToReachTarget(knightPos, targetPos, N));
		}

		private static int minStepToReachTarget(int[] knightPos, int[] targetPos, int n) {
			List<Node> visited = new ArrayList<>();
			Queue<Node> q = new LinkedList<Node>();
			Node start = new Node(knightPos[0],knightPos[1],0);
			Node target = new Node(targetPos[0],targetPos[1],0);
			visited.add(start);
			q.add(start);
			int[] neighboursx={ -2, -1,  1,  2, -2, -1, 1, 2 };
			int[] neighboursy={ -1, -2, -2, -1,  1,  2, 2, 1 };
		
			while(!q.isEmpty()) {
				Node curr = q.poll();
				for(int i=0;i<neighboursx.length;i++) {
					Node neighbour = new Node(curr.x+neighboursx[i], curr.y+neighboursy[i], curr.steps+1);
					if(neighbour.equals(target)) {
						return neighbour.steps;
					}
					if(!visited.contains(neighbour) && isSafe(neighbour,n)) {
						visited.add(neighbour);
						q.add(neighbour);
					}
				}
			}
			
			return -1;
		}


		private static boolean isSafe(Node neighbour, int n) {
			return neighbour.x>=0 && neighbour.y >=0 && neighbour.x < n && neighbour.y<n;
		}
}
