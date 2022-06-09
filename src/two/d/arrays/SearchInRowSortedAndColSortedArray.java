package two.d.arrays;

// https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
// Search in a row wise and column wise sorted matrix
// Complexity would be O(m + n).
public class SearchInRowSortedAndColSortedArray {

    public static void find(int[][]a, int n){
        int i=0;
        int j=a[0].length-1;
        while(i<a.length && j>=0){
            if(a[i][j]==n){
                System.out.println("found at "+i+ " "+j);
                break ;
            }
            if(a[i][j]>n){
                j--;
            }else {
                i++;
            }
        }
    }

    public static void main(String[] args)
    {
        int mat[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };

        find(mat, 29);
    }
}
