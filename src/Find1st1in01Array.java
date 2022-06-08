
// https://www.geeksforgeeks.org/find-index-first-1-infinite-sorted-array-0s-1s/
/*Given an infinite sorted array consisting 0s and 1s.
The problem is to find the index of first ‘1’ in that array.
As the array is infinite, therefore it is guaranteed that number ‘1’ will be present in the array.*/
public class Find1st1in01Array {

    // function to find the index of first '1'
    // binary search technique is applied
    public static int find(int[] a, int l ,int h){
          while(l<=h){
              int mid = (l+h)/2;

              // if true, then 'mid' is the index of
              // first '1'
              if(a[mid] == 1 && (mid==0 || a[mid-1]==0)){
                  return mid;
              }
              // first '1' lies to the left of 'mid'
              if(a[mid]==1){
                  h=mid-1;
              }
              // first '1' lies to the right of 'mid'
              else {
                  l=mid+1;
              }
          }
          return -1;
      }

    public static int posOfFirstOne(int arr[])
    {
        // find the upper and lower bounds
        // between which the first '1' would
        // be present
        int l = 0, h = 1;

        // as the array is being considered
        // infinite therefore 'h' index will
        // always exist in the array
        while (arr[h] == 0) {

            // lower bound
            l = h;

            // upper bound
            h = 2 * h;
        }

        // required index of first '1'
        return find(arr, l, h);
    }

    public static void main(String[] args)
    {

        int arr[] = { 0, 0, 1, 1, 1, 1 };
        System.out.println("Index = " +
                posOfFirstOne(arr));

    }

}
