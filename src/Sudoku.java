import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://codepumpkin.com/sudoku-checker/
// https://www.geeksforgeeks.org/check-if-given-sudoku-board-configuration-is-valid-or-not/
public class Sudoku {
	static Set<Integer> rowSet = new HashSet<>();
	static Set<Integer> colSet = new HashSet<>();
	static Set<Integer> boxSet = new HashSet<>();
	static List<Set<Integer>> list= new ArrayList<Set<Integer>>();
	static boolean isValid(int[][] arr){
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(arr[i][j]!=-1 && !isAllowed(i, j, arr)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static boolean isAllowed(int row, int col, int[][] arr) {
		rowSet = list.get(row);
		colSet = list.get(9+col);
		int box = 3*(row/3)+(col/3);
		boxSet = list.get(18+box);
	
		return rowSet.add(arr[row][col]) && colSet.add(arr[row][col]) && boxSet.add(arr[row][col]);
	}
	
	public static void main(String[] args) {
		int[][] inputSudoku	= { 
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 
				{ 4, 5, 6, 7, 8, 9, 1, 2, 3 },
				{ 7, 8, 9, 1, 2, 3, 4, 5, 6 },
				{ 2, 3, 4, 5, 6, 7, 8, 9, 1 }, 
				{ 5, 6, 7, 8, 9, 1, 2, 3, 4 }, 
				{ 8, 9, 1, 2, 3, 4, 5, 6, 7 },
				{ 3, 4, 5, 6, 7, 8, 9, 1, 2 }, 
				{ 6, 7, 8, 9, 1, 2, 3, 4, 5 }, 
				{ 9, 1, 2, 3, 4, 5, 6, 7, 8 } };
		
		
		for (int i = 0; i < 27; i++) 
		{
			list.add(new HashSet<Integer>());
		}
		System.out.println("isValid "+isValid(inputSudoku));
		
		
		int[][] inputSudoku2	= { 
				{ 5,   3, -1, -1,  7, -1, -1, -1, -1 }, 
				{ 6,  -1, -1,  1,  9,  5, -1, -1, -1 },
				{ -1,  9,  8, -1, -1, -1, -1,  6, -1 },
				{ 8,  -1, -1, -1,  6, -1, -1, -1,  3 }, 
				{ 4,  -1, -1,  8, -1,  3, -1, -1,  1 }, 
				{ 7,  -1, -1, -1,  2, -1, -1, -1,  6 },
				{ -1,  6, -1, -1, -1, -1,  2,  8, -1 }, 
				{ -1, -1, -1,  4,  1,  9, -1, -1,  5 }, 
				{ 5, -1, -1, -1,  8, -1, -1,  7,  9 } };
		
		
		for (int i = 0; i < 27; i++) 
		{
			list.add(new HashSet<Integer>());
		}
		System.out.println("isValid "+isValid(inputSudoku2));
	}
}
