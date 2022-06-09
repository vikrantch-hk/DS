// https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/
/*Given a sorted array with possibly duplicate elements,
 the task is to find indexes of first and last occurrences of an element x in the given array.*/
public class Find1stAndLastPositionInSortedDuplicatesArray {

    public static int first(int[] a,int n){
        int l=0;
        int r = a.length-1;
        int pos=-1;
        while(l<=r){
            int mid=(l+r)/2;
            // If arr[mid] is same as
            // x, we update res and
            // move to the left half.
            if(a[mid]==n){
                pos=mid;
                r=mid-1;
            }else if(a[mid]>n){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return pos;
    }

    public static int last(int[] a,int n){
        int l=0;
        int r = a.length-1;
        int pos=-1;
        while(l<=r){
            int mid=(l+r)/2;
            // If arr[mid] is same as x,
            // we update res and move to
            // the right half.
            if(a[mid]==n){
                pos=mid;
                l=mid+1;
            }else if(a[mid]>n){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return pos;
    }

    public static void main(String[] args)
    {
        int arr[] = {5,7,7,8,8,10};
        int n = arr.length;
        int x = 8;
        System.out.println("First Occurrence = " +
                first(arr, x));
        System.out.println("Last Occurrence = " +
                last(arr, x));
    }
}
