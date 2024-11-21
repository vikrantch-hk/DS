import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequent {
    public static List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<Map.Entry<String, Integer>>(
                        (a, b) -> {
                            if (!b.getValue().equals(a.getValue()))
                                return b.getValue() - a.getValue();
                            return a.getKey().compareTo(b.getKey());
                        }
                );

        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            m.put(words[i], m.getOrDefault(words[i], 0) + 1);
        }

        pq.addAll(m.entrySet());

        List<String> op = new ArrayList<>();
        while (!pq.isEmpty() && op.size()<k){
            op.add(pq.poll().getKey());
        }
        return op;
    }

    public static void main(String[] args) {
        topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2); // ["i","love"]
        topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);// ["the","is","sunny","day"]
    }
}
