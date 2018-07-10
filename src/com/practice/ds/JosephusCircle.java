package com.practice.ds;




// https://www.geeksforgeeks.org/josephus-problem-using-bit-magic/
public class JosephusCircle {

	public static int getMSBPos(int n) {
		int pos =0;
		while(n>0)
		{
			n=n>>1;
			pos++;
		}
		return pos;
	}
	
	public static int josephy(int n) {
        int pos = getMSBPos(n);
        int temp=1;
        for(int i=0;i<pos-1;i++)
        {
        	temp=temp<<1;
        }
        n=n^temp;
        n=n<<1;
        n=n|1;
        return n;
	}
	
	public static void main(String[] args) {
		System.out.println(josephy(41));
	}
}
