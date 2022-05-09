package graph;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/find-number-of-islands/
/*Input : mat[][] ={{1, 1, 0, 0, 0},
        			{0, 1, 0, 0, 1},
			        {1, 0, 0, 1, 1},
			        {0, 0, 0, 0, 0},
			        {1, 0, 1, 0, 1} 
Output : 5*/
public class Islands {

	static void BSF(int[] start, int[][] arr, int[][] visited) {
		int[] neighboursx = new int[] { -1, -1, -1,  0, 0,  1, 1, 1 };
		int[] neighboursy = new int[] { -1,  0,  1, -1, 1, -1, 0, 1 };
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		visited[start[0]][start[1]] = 1;
		while (!q.isEmpty()) {
			int[] Node=q.poll();
			for (int i = 0; i < neighboursx.length; i++) {
				if (isSafe(arr, Node[0] + neighboursx[i], Node[1] + neighboursy[i],visited)) {
					visited[Node[0] + neighboursx[i]][Node[1] + neighboursy[i]] = 1;
					q.add(new int[] {Node[0] + neighboursx[i], Node[1] + neighboursy[i]});
				}
			}
		}
	}

	static boolean isSafe(int[][] arr, int x, int y, int[][] visited) {
		System.out.println("x y"+x+" "+y);
		return x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && arr[x][y] == 1
				&& visited[x][y]!=1;
	}
	
	public static void main(String[] args) {
		int mat[][] ={{1, 1, 0, 0, 0},
    			{0, 1, 0, 0, 1},
		        {1, 0, 0, 1, 1},
		        {0, 0, 0, 0, 0},
		        {1, 0, 1, 0, 1}} ;
		
		int count=0;
		int[][] visited=new int[mat.length][mat.length];
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				if(mat[i][j]==1 && visited[i][j]!=1) {
					System.out.println("i j"+i+" "+j);
					count++;
					BSF(new int[] {i,j},mat,visited);
				}
			}
		}
		
		System.out.println("islandas "+count);
	}
}
