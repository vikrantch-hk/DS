/* package workspace; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public  class Stockroom3 {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
			Scanner sc = new Scanner(System.in);
			String ip = sc.nextLine();
			int r = Integer.parseInt(sc.nextLine());
			int d = Integer.parseInt(sc.nextLine());
			StringBuilder sb = new StringBuilder();
			if(r>ip.length())
				System.out.println(ip);
			else
			{
				sb = sb.append(ip.substring(0, r+2));
				int n = 2*(r+d);
				while(n<=ip.length()-1)
				{
				if(n<=ip.length()-1)
				{
				if(n+r+2<=ip.length()-1)
					sb = sb.append(" "+ip.substring(n, n+r+2));
				else
					sb = sb.append(ip.substring(n));
				}
				else
					sb = sb.append(ip.substring(r));
				n*=2;
				}
			}
			System.out.println(sb);
	}
}
