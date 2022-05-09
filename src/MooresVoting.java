// https://www.geeksforgeeks.org/majority-element/
// A majority element in an array A[] of size n is an element that appears more than n/2 times
public class MooresVoting {

	public static int findCandidate(int a[]) {
		int index = 0;
		int count =1;
		for(int i=1;i<a.length;i++) {
			if(a[i]==a[index])
			{
				count++;
			}
			else {
				count--;
			}
			if(count==0) {
				index=i;
				count=1;
			}
		}
		return index;
	}
	
	public static int isMajority(int a[],int index) {
		
		int count =0;
		for(int i=0;i<a.length;i++) {
			if(a[i]==a[index]) {
				count++;
			}
		}
		if(count>a.length/2) {
			return a[index];
		}
		return -1;
	}
	
	public static void main(String[] args) {
        int a[] = new int[]{1, 3, 3, 1, 2,1,1,2,1}; 
        int candidate = findCandidate(a); 
        System.out.println(isMajority(a, candidate));
        
        int b[] = {1, 3, 3, 3, 2}; 
        candidate = findCandidate(b); 
        System.out.println(isMajority(b, candidate));
        
	}

}
