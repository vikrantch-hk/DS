
/**
 * gcd(a,b)=b==0?a:gcd(a,b%a)
 * @author vikrant
 *
 */
public class GCD {
	public static int generalizedGCD(int num, int[] arr)
    {
        // WRITE YOUR CODE HERE
        if(num==1)return arr[0];
        int gcd=gcd(arr[0],arr[1]);
        if(num>2){
        for(int i=1;i<num-1;i++){
           gcd=gcd(gcd,arr[i]);
        }}
        return gcd;
    }
    
    public static int gcd(int a,int b){
        int s=-1;int l=-1;
        s=a>b?b:a;
        l=a>b?a:b;
        if(s==0)return l;
        return gcd(s,l%s);
    }
    
    public static void main(String[] args) {
		System.out.println(generalizedGCD(5, new int[]{9,6,12,21}));
	}
}
