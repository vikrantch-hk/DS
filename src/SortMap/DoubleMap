package SortMap;

import java.util.HashMap;
import java.util.Map;

// Custom double map problem - implement a map with search enabled from value
public class DoubleMap<K,V> {
    Map<K,V> keyToVal = new HashMap<>();

    Map<V,K> valToKey = new HashMap<>();

    public void put(K k, V v){
        if(keyToVal.containsKey(k)){
            valToKey.remove(keyToVal.get(k));
        }

        if(valToKey.containsKey(v)){
            keyToVal.remove(valToKey.get(v));
        }

        keyToVal.put(k,v);
        valToKey.put(v,k);
    }

    public V getByKey(K k){
        return keyToVal.get(k);
    }

    public K getByVal(V v){
        return valToKey.get(v);
    }

    public V removeByKey(K k){
        valToKey.remove(keyToVal.get(k));
        return keyToVal.remove(k);
    }

    public K removeByVal(V v){
        keyToVal.remove(valToKey.get(v));
        return valToKey.remove(v);
    }

    public static void main(String[] args) {
        DoubleMap<Integer, String> doubleMap = new DoubleMap<Integer, String>();
        doubleMap.put(1, "Apple");
        doubleMap.put(2, "Banana");

        System.out.println(doubleMap.getByKey(1));     // Apple
        System.out.println(doubleMap.getByVal("Banana")); // 2
    }
}
