package arrise;


import java.util.HashMap;
import java.util.Map;

/*Bingo/Tic-Tac-Toe Strike Counter java interview question strikes are rowwise columnwise or diagonal covering end to end edge

1,11,21
3,15,25
5,18,27

1,11,21,25,27,15 = total strikes 3
1,11,21,25,27,15, 3, 5 = total strikes 6
*/
public class StrikeCounter {
    static class Cell {
        int r;
        int c;

        public Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


    public static Map<Integer, Cell> cellMap = new HashMap<>();
    public static boolean[][] coveredArr;

    public static void createCellMap(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cellMap.put(arr[i][j], new Cell(i, j));
            }
        }

        coveredArr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                coveredArr[i][j] = false;
            }
        }
    }

    public static void coveredCells(int[] input, int n) {
        for (int i = 0; i < input.length; i++) {
            Cell coveredCell = cellMap.get(input[i]);
            coveredArr[coveredCell.r][coveredCell.c] = true;
        }
    }

    public static void countStrikes(int[][] arr, int[] input, int n) {
        createCellMap(arr, n);
        coveredCells(input, n);


        int strikes = 0;
        // row strikes
        for (int i = 0; i < n; i++) {
            boolean rowCovered = false;
            for (int j = 0; j < n; j++) {
                rowCovered = coveredArr[i][j];
                if (!rowCovered) {
                    break;
                }
            }
            if (rowCovered) strikes++;
        }

        // column strikes
        for (int i = 0; i < n; i++) {
            boolean colCovered = false;
            for (int j = 0; j < n; j++) {
                colCovered = coveredArr[j][i];
                if (!colCovered) {
                    break;
                }
            }
            if (colCovered) strikes++;
        }

        // diagonal strikes
        boolean diagonalCovered = false;
        for (int i = 0; i < n; i++) {
            diagonalCovered = coveredArr[i][i];
            if (!diagonalCovered) {
                break;
            }

        }
        if (diagonalCovered) strikes++;

        // diagonal strikes
        boolean antiDiagonalCovered = false;
        for (int i = n-1; i >= 0; i--) {
            antiDiagonalCovered = coveredArr[i][n-i];
            if (!antiDiagonalCovered) {
                break;
            }

        }
        if (antiDiagonalCovered) strikes++;

        System.out.println("Total strikes "+ strikes);
    }

    public static void main(String[] args) {
        int arr[][] = {
                {1, 11, 21},
                {3, 15, 25},
                {5, 18, 27}
        };

        int[] input = {1,11,21,25,27,15};
        countStrikes(arr, input, arr[0].length);

        int[] input2 = {1,11,21,25,27,15,5,3};
        countStrikes(arr, input2, arr[0].length);
    }

}
