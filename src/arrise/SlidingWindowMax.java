package arrise;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class SlidingWindowMax {
    static class Node{
        int v;
        int i;
        public Node(int v, int i){
            this.v = v;
            this.i = i;
        }
    }

    //At index i, valid window is:
    //[i - k + 1  ...  i]
    // Any element with index < i - k + 1 is OUTSIDE the window, must NOT be used as max
    public static void max(int[] in, int k){
        int n = in.length;
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(
                (a,b)->b.v-a.v
        );
        int[] out = new int[n-k+1];
        for(int i=0;i<k;i++){
            maxHeap.add(new Node(in[i], i));
        }

        out[0]=maxHeap.peek().v;

        for(int i=k;i<n;i++){
            while(!maxHeap.isEmpty() && maxHeap.peek().i<i-k+1){
                maxHeap.poll();
            }
            maxHeap.add(new Node(in[i],i));
            out[i-k+1]=maxHeap.peek().v;
        }

        System.out.println(Arrays.stream(out).mapToObj(i->""+i).collect(Collectors.joining(", ")));
    }

    public static void main(String[] args) {
        int[] in = {1,3,-1,-3,5,3,6,7};
        max(in,3);
    }
}
