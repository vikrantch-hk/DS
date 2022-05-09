import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * keep frequency and element in map
 * use max heap based on frequency
 * @author vikrant
 *
 */
public class TopKElementsInStream {
	
	public static void main(String[] args) {
		int[] stream = new int[] {1,1,1,2,2,3};
		int k=2;
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i:stream) {
		map.put(i, map.getOrDefault(i,0)+1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>
		((e1,e2)->e2.getValue()-e1.getValue());
		
		map.entrySet().forEach(entry->maxHeap.add(entry));
		
		for(int i=1;i<=k;i++)
			System.out.print(maxHeap.poll()+" ");
		
	}

}
