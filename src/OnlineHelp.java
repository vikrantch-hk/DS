import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.LinkedList;

class data implements Comparable

{

	Integer num;

	Integer frequency;
	
	static{
	//	num=0;  Cannot make a static reference to the non-static field num
	} // you cant initialize instance variable in static block;

	public data(int n, int f)

	{
		final int i;
		num = n;

		frequency = f;

	}

	@Override
	public int compareTo(Object a1) {

		return this.frequency.compareTo(((data) a1).frequency);

	}

}

class ValueComparator<T1, T2 extends Comparable<T2>> implements Comparator<T1> {
	Map<T1, T2> base;

	public ValueComparator(Map<T1, T2> base) {
		this.base = base;
	}

	@Override
	public int compare(T1 k1, T1 k2) {
		T2 val1 = base.get(k1);
		T2 val2 = base.get(k2);

		return val1.compareTo(val2);
	}
}


public class OnlineHelp {
	public static void createList(String s)
	{
		final List<Character> l = new ArrayList<Character>();// Cannot refer to a non-final variable l inside an inner class defined in a different method
		int len = s.length();
		for(int i=0;i<len;i++)
			l.add(s.charAt(i));
		Collections.sort(l,new Comparator<Character>() {

			@Override
			public int compare(Character arg0, Character arg1) {
				// TODO Auto-generated method stub
				int f1 = Collections.frequency(l, arg0);
				int f2 = Collections.frequency(l, arg1);
				if (f1 == f2)
					return arg1 - arg0;
				else
					return f1 - f2;
			}
		});
		for(Character c:l)
			System.out.print(c+" ");
		
		System.out.println();
		for(char c='z' ;c>='a';c--)
		{
			if(!l.contains(c))
				System.out.print(c+" ");
		}
		int size = l.size();
		int i =0; 
for(int j=1;j<size;j++)
{
	Character val = l.get(j);
	if(l.get(i)!=val)
		l.set(++i, val);
	}
		for(Character c:l)
			System.out.print(c+" ");
			
		
	}
public static void StringCount(String full,String s)
{
	String arr[]=s.split(" ");
	String a = arr[0];
	String b = arr[1];
	int count=0;
	int astart = full.indexOf(a);
	int aend = full.lastIndexOf(a);
	int bstart = full.indexOf(a);
	int bend = full.lastIndexOf(b);
	List<String> substrings = new ArrayList<String>();
	for(int i=astart;i<=aend;i++)
	{
		StringBuffer sb = new StringBuffer();
		sb=sb.append(full.charAt(i));
		
		for(int j=bstart;j<=bend;j++)
		{
			sb=sb.append(full.charAt(j));
			substrings.add(sb.toString());
		}
	}
	for(String str:substrings)
	{System.out.println(str);
	if((str.startsWith(a)&& str.endsWith(b))  || (str.startsWith(b)&& str.endsWith(a)))
	count++;
	}
	System.out.println(count);
	}

public static void StringCount2(String full,String s)
{
	char a = s.charAt(0);
	char b = s.charAt(2);
	int count=0;
	
	int acount=0;
	int bcount=0;
	int i=0;
	while(full.charAt(i)!=b)
	{
		if(full.charAt(i)==a)
		{
			a++;
		}
		i++;
	}
	if(full.charAt(i)==b)
	{
		count++;
		while(i<full.length())
			if(full.charAt(i)==b)
			{
				b++;
			}
	}
		System.out.println(a*b);
	}
	
	
public static void printOp(String s)
{
	String [] ar = s.split(" ");
	int [] arr= new int[3];
	for(int i=0;i<ar.length;i++)
	{
	arr[i] = Integer.parseInt(ar[i]);	
	}
	
	int out = 0;
	int n1,n2,n3,n4=0;
	n1=arr[0]/3;
	n2=arr[1]/3;
	n3=arr[2]/3;
	n4 = Math.max(arr[2]%3, Math.max(arr[0]%3, arr[1]%3));
	System.out.println(n1+n2+n3+n4);
}
	public static void sum(String s, int l)
	{
		int c = new Double(Math.pow(2, l-1)).intValue();
		int r= l-1;
		int a[][]=new int[r][c];

	for(int i=r;i>=0;i--)
	{
		for(int j=0;j<c;j++)
		{
			if(i==r)
			a[i][j]=j+1;
			else
				a[i][j]=a[i-1][j-1]*a[i-2][j-2];
		}
	}

		String [] ar = s.split(" ");
		int [] arr= new int[3];
		for(int i=0;i<ar.length;i++)
		{
		arr[i] = Integer.parseInt(ar[i]);	
		}
		int sum =0;
		for(int i=arr[1]-1;i<arr[2]-1;i++)
			sum+=a[arr[0]-1][i];
System.out.println(sum);		
				
	}

	
	public static int compute(int n)
	{
		
		return (n*(n+1))/2;
	}
	static String computeDegrees(String time) {
		if(time.equals("2400"))
			return "Invalid input: "+time;
		int h = Integer.parseInt(time.substring(0, 2));
		if(h>24)
			return "Invalid input: "+time;
		int m = Integer.parseInt(time.substring(2));
		if(m>60)
			return "Invalid input: "+time;
		int hdeg = (30*h)+(m/2);
		int mdeg = m*6;
		return hdeg+":"+mdeg;

		    }
	
	
	public static void possibleOrNOt(String s,String p)
	{
		
		if(p.length()<s.length())
			System.out.println("Impossible");
		else if(p.length()==s.length() && p.equals(s))
			System.out.println("Possible");
		else if(p.length()==s.length() && !p.equals(s))
			System.out.println("Impossible");
		else
		{
			if(p.length()>(s.length()*2))
					{
				System.out.println("Impossible");
					}
			else
			{
			if(p.indexOf(s)<0)
			{
				System.out.println("Impossible");
			}
			else
			{
				StringBuffer temp = new StringBuffer(p);
			
				
			if(temp.indexOf(s)==0)	
			{
				temp = new StringBuffer(temp.substring(s.length()));
				if(temp.toString().equals(s))
		        { 
		        System.out.println("Possible");
		        }
				else
				{
					System.out.println("Impossible");
				}
			}
			if(temp.indexOf(s)>0)
				{
				int i=temp.indexOf(s);
		        temp = new StringBuffer((temp.substring(0,i))+temp.substring(i+s.length()));
		        if(temp.toString().equals(s))
		        { 
		        System.out.println("Possible");
				}
		        else
		        {

					System.out.println("Impossible");
		        }
				
				}
		        	
			}
		}
		}
		
	}
	
	
	public static void print(long n)
	{
		int count=0;
		//System.out.println(n);
		for(long i=1;i<=n;i++)
		{
			System.out.println(i);
			if(n%i==0)
					{
				count++;
					}
				
		}
		System.out.println(count);
		
	}
	
	
	public static void doSum(int x,int y)
	{
		while(x!=y)
		{
		if(x>y)
			x=x-y;
		if(y>x)
			y=y-x;
		}
		System.out.println(x);
	}
	

	public static int longestSubsequence(String s) {

		Set<Character> set= new LinkedHashSet<Character>();
		int i=0;
		char max ='a';
		for(i=0;i<s.length();i++)
		{
		
			if(set.size()<5 &&( s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'))
			{
				
				if(s.charAt(i)<max)
					i--;
				if(s.charAt(i)>max)
				{
					max=s.charAt(i);
				}
				set.add(s.charAt(i));
			}
			else if(set.size()==5)
				break;
		}
		if(set.size()==5)
			return i+1;
		else
			return 0;
    }

	
	static int check()
	{
				try{
					System.out.println("try");
					return 0;
				}
				catch(Exception e)
				{
					System.out.println("catch");
					return 2;
				}
				finally{
					//System.exit(0);
					System.out.println("exit");
					return 3;
				}
	}
	public static void main(int[] args)
	{
	}
	public static void main(String args[])

	{
		System.out.println(args.length);
		ArrayList<A> x = new ArrayList<A>();
		ArrayList a = new ArrayList();
		x.add(new A());
		a=x;
		a.add(new B());
		ArrayList b = a;
		ArrayList<C> c= (ArrayList<C>)b;
		c.add(new C());
		a.add(new A());
		for(Object o:c)
		{
			System.out.println(o);
		}
		
		
		
		int l = check();
		System.out.println(l);
		String ar[] = "abc,def,ghi".split(",",2);
		System.out.println(ar[0]+" "+ar[1]);
		//System.out.println(mergeStrings("abc", "def"));
		//doSum(2437, 87,""5);
		/*Set<Integer> s = new TreeSet<Integer>();
		s.add(null);*///java.lang.NullPointerException
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		String arr[] =sc.nextLine().split(" ");
		long n = 1;
		for(int i=0;i<t;i++)
		{
			n=n*(Long.parseLong(arr[i]));
		}
		System.out.println("strt");
		print(n);
		/*System.out.println(reverseWordByWord("This is good"));
		int[] arr = { 2, 3, 4, 2, 8, 1, 1, 2 };
		// int[] arr = { 1, 1, 1, 4, 5, 5, 18, 18, 1, 2, 5, 9, 3, 3, 6, 6, 7, 10
		// };
		int[] ouput = sort(arr);
		for (int i : ouput)
			System.out.println(i);
*/	}

	public static int[] sort(int[] inputArray) {

		final List<Integer> inputList = new ArrayList<Integer>();
		for (int i : inputArray)
			inputList.add(i);
		Collections.sort(inputList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if (((Integer) Collections.frequency(inputList, o1))
						.compareTo(Collections.frequency(inputList, o2))==0)
					return o1.compareTo(o2);
				else
					return ((Integer) Collections.frequency(inputList, o2))
							.compareTo(Collections.frequency(inputList, o1));
			}
		}

		);
		
		int[] outputArray = new int[inputArray.length];
		for(int i=0;i<inputArray.length;i++)
			outputArray[i]=inputList.get(i);
		return outputArray;
	}

	public static String reverseWordByWord(String inputString) {
		int strLeng = inputString.length() - 1;
		String reverse = "", temp = "";

		for (int i = 0; i <= strLeng; i++) {
			temp += inputString.charAt(i);
			if ((inputString.charAt(i) == ' ') || (i == strLeng)) {
				for (int j = temp.length() - 1; j >= 0; j--) {
					reverse += temp.charAt(j);
					if ((j == 0) && (i != strLeng))
						reverse += " ";
				}
				temp = "";
			}
		}
		return reverse.trim();
	}
}
