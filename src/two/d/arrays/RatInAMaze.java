package two.d.arrays;

// https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/
public class RatInAMaze {

	public boolean isSafe(int[][] maze, int i, int j) {
		if (i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] == 1) {
			return true;
		}
		return false;
	}
	
	public void findPath(int[][] maze) {
		int[][] solution= new int[maze.length][maze[0].length];
		if(mazeUtil(maze,0,0,solution)) {
			printPath(solution);
		}
	}

	private void printPath(int[][] solution) {
		for(int i=0;i<solution.length;i++) {
			for(int  j=0;j<solution[0].length;j++) {
				System.out.print(solution[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private boolean mazeUtil(int[][] maze, int i, int j, int[][] solution) {
		if(i==maze.length-1 && j==maze[0].length-1) {
			solution[i][j]=1;
			return true;
		}
		if(isSafe(maze, i, j)) {
			solution[i][j]=1;
			
			if(mazeUtil(maze, i, j+1, solution))
				return true;
			
			if(mazeUtil(maze, i+1, j, solution))
				return true;
			
			solution[i][j]=0;
			return false; 
		}
		return false;
	}
	
	public static void main(String args[]) 
    { 
        RatInAMaze rat = new RatInAMaze(); 
        int maze[][] = {    {1, 0, 1, 1, 0},
					        {1, 1, 1, 0, 1},
					        {0, 1, 0, 1, 1},
					        {1, 1, 1, 1, 1} }; 
  
        rat.findPath(maze); 
    } 
}
	 	