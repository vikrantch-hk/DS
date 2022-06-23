// https://leetcode.com/problems/combinations/submissions/

/*
* Given two integers n and k,
* return all possible combinations of k numbers out of the range [1, n].
*
* n = 4, k = 2
*
* [
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
* */

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfK {

    // combinations n,k = include n => (n, (combinations n-1,k-1)) +
    //     dont include n => combine k from remaining n-1(combinations n-1,k)
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> r= new ArrayList<>();
        if(k>n ||k==0){
            return r;
        }
        // include n so get combinations of k-1 from n-1
        r=combine(n-1, k-1);
        if(r.isEmpty()){
            r.add(new ArrayList<Integer>());
        }
        // include n in result
        for(List<Integer> l:r){
            l.add(n);
        }
        // add combinations without n so choose k from n-1
        r.addAll(combine(n-1, k));
        return r;
    }

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
}
