import java.util.Arrays;

public class SumClosestToN {

	public static void getNumbers(int[] a, int n) {
		Arrays.sort(a);
		int l = 0, r = a.length - 1, minl = 0, minr = 0, minDiff = Integer.MAX_VALUE;
		while (l < r) {
			if (a[l] + a[r] == n) {
				minl=l;minr=r;
				break;
			}
			if (a[l] + a[r] < n) {
				if (Math.abs(n - (a[l] + a[r])) < minDiff) {
					minDiff = n - (a[l] + a[r]);
					minl = l;
					minr = r;
				}
				l++;
			} else {
				if (Math.abs(n - (a[l] + a[r])) < minDiff) {
					minDiff = n - (a[l] + a[r]);
					minl = l;
					minr = r;
				}
				r--;
			}

		}
		System.out.println("min diff numbers are " + a[minl] + " " + a[minr]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 60, -10, 70, -80, 85 };
		getNumbers(arr, 60);
	}

}
