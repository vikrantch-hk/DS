/**
 ** Java Program to implement Longest Common Subsequence Algorithm
 **/
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
 
/** Class  LongestCommonSubsequence **/
public class  LongestCommonSubsequence
{    
	/*private boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}*///Cannot reduce the visibility of the inherited method from Object
    /** function lcs **/
    @SuppressWarnings("unchecked")
	public String lcs(String str1, String str2)
    {
    	Set set = new TreeSet();
    	//set.add(null);// will give runtime nullpointerexception
    	List lst = new ArrayList();
    	Map m = new HashMap();
    	m.containsKey("1");
    	Map m1= Collections.synchronizedMap(m);
    	m.entrySet().iterator();
        int l1 = str1.length();
        int l2 = str2.length();
 
        int[][] arr = new int[l1 + 1][l2 + 1];
 
        for (int i = l1 - 1; i >= 0; i--)
        {
            for (int j = l2 - 1; j >= 0; j--)
            {
                if (str1.charAt(i) == str2.charAt(j))
                    arr[i][j] = arr[i + 1][j + 1] + 1;
                else 
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
            }
        }
 
        int i = 0, j = 0;
        StringBuffer sb = new StringBuffer();
        while (i < l1 && j < l2) 
        {
            if (str1.charAt(i) == str2.charAt(j)) 
            {
                sb.append(str1.charAt(i));
                i++;
                j++;
            }
            else if (arr[i + 1][j] >= arr[i][j + 1]) 
                i++;
            else
                j++;
        }
        return sb.toString();
    }
 
    /** Main Function **/
    public static void main(String[] args) throws IOException
    {    
        try {
			Class clss = Class.forName("LongestCommonSubsequence");
			try {
				clss.newInstance();
			} 
			catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Longest Common Subsequence Algorithm Test\n");
 
        System.out.println("\nEnter string 1");
        String str1 = br.readLine();
 
        System.out.println("\nEnter string 2");
        String str2 = br.readLine();
 
        LongestCommonSubsequence obj = new LongestCommonSubsequence(); 
        String result = obj.lcs(str1, str2);
 
        System.out.println("\nLongest Common Subsequence : "+ result);
    }
}