public class Segregatevisors {

	static int[] arr = new int[] { 37, 22, 2, 5, 76, 99, 21, 102, 100 ,34};
	
	public static void sort(int n){
		
		int low=0, mid=0, high=n-1;
		while(mid <= high){
			
			switch(arr[mid]%3){
				case 0:
					   swap(low, mid);
					   low++;mid++;
					   break;
				case 1:
					   mid++;
					   break;
				case 2:
					   swap(mid, high);
					   high--;
					   break;
			}	
		}
	}

	private static void swap(int aa , int b){
		
		int temp = arr[aa];
		arr[aa] = arr[b];
		arr[b] = temp;
	}
	
	private static void print(){
		
		for(int i: arr)
			System.out.print(i+ " ");
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	sort(arr.length);
	print();

	}

}
