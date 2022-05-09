/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Stockroom1
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		Scanner sc = new Scanner(System.in);
		int cases= Integer.parseInt(sc.nextLine());
		List<String> sources= new ArrayList<String>();
		for(int i=0;i<cases;i++)
		{
		    sources.add(sc.nextLine());
		}
		String target = sc.nextLine();
		int[] top = new int[3];
		List<Result> results = new ArrayList<Result>();
		for(String source:sources)
		{
		    int dist = editDistance(source,target);
		    results.add(new Result(dist,source));
		}
		Collections.sort(results);
		System.out.println(((Result)results.get(0)).getSource());
		System.out.println(((Result)results.get(1)).getSource());
		System.out.println(((Result)results.get(2)).getSource());
	}
	
	public static int editDistance(String s, String t) {
		int arr[][] = new int[s.length() + 1][t.length() + 1];

		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j <= t.length(); j++) {
				if (i == 0) {
					arr[i][j] = j;
				} else if (j == 0) {
					arr[i][j] = i;
				}
				if (i > 0 && j > 0) {
					if (s.charAt(i - 1) == t.charAt(j - 1))
						arr[i][j] = arr[i - 1][j - 1];
					else
						arr[i][j] = 1 + Math.min(arr[i - 1][j - 1],
								Math.min(arr[i][j - 1], arr[i - 1][j]));
				}
			}
		}
		return arr[s.length()][t.length()];
	}
}

class Result implements Comparable<Result>{
	Integer dis;
	public Integer getDis() {
		return dis;
	}
	public void setDis(Integer dis) {
		this.dis = dis;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	String source;
	
	Result(int dis,String source)
	{
		this.dis=dis;
		this.source=source;
	}
	@Override
	public int compareTo(Result o) {
		// TODO Auto-generated method stub
		return this.dis==o.dis?this.source.compareTo(o.source):this.dis.compareTo(o.dis);
	}
	
}
