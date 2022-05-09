/*Palin Pairs

Max. Marks 100
Panda has a thing for palindromes. Hence he was a given a problem by his master. The master will give Panda an array of strings S having N strings. Now Panda has to select the Palin Pairs from the given strings .

A Palin Pair is defined as :

(i,j) is a Palin Pair if Si = reverse(Sj) and i < j

Panda wants to know how many such Palin Pairs are there in S. 
Please help him in calculating this.

Input:

The first line contains N, the number of strings present in S.
Then N strings follow.

Output:

Output the query of Panda in single line.

Constraints:

1 ≤ N ≤ 100000
1 ≤ |Si| ≤ 10 (length of string)

The string consists of Upper and Lower case alphabets only.*/

/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/

import java.util.*;
public class SuperProfs2 {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */

Scanner sc= new Scanner(System.in);
int count =0;
int testCase = Integer.parseInt(sc.nextLine());
for(int i=1;i<=testCase;i++)
{
	String[] str= sc.nextLine().split(" ");
	int frnds = Integer.parseInt(str[0]);
	int dish = Integer.parseInt(str[1]);
	int [] arr = new int[dish];
	for(int j=1;j<=frnds;j++)
	{
		String str11 = sc.nextLine();
		char [] str1=new char[dish];
		if(str11.length()<=dish)
		{
		str1=str11.toCharArray();
		}
		else
		{
			str1=str11.substring(0, dish-1).toCharArray();
		}
		List<String> list= new ArrayList<String>();
		
		for(Character c:str1)
		{//System.out.println("c"+c.toString());
		 list.add(c.toString());
		}
		int idx = list.indexOf("1");
		//System.out.println("idx"+idx);
		if(arr[idx]!=1)
		{
			count++;
			arr[idx]=1;
		}
	}
}


        System.out.println(count);
    }
}
