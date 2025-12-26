package tesco;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/discuss/post/6825916/tesco-sde3-round-1-by-anonymous_user-yy7t/
public class SearchIndex {
    public static class Product {
        public int id;
        public String name;
        public int rank;

        public Product(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    // product id -> name
    public static Map<Integer, Product> productNameIdMap = new HashMap<>();

    // inverted index word->product id
    public static Map<String, List<Integer>> index = new HashMap<>();

    public static void buildProductNameIdMap(List<Product> products) {
        products.stream().forEach(product -> productNameIdMap.put(product.id, product));
    }

    public static void buildIndex(List<Product> products) {
        products.stream().forEach(product -> {
            Arrays.stream(product.name.split(" ")).forEach(s -> {
                List<Integer> ids = new ArrayList<>();
                if (index.containsKey(s)) {
                    ids = index.get(s);
                }
                ids.add(product.id);
                index.put(s, ids);
            });
        });
    }

    public static List<Product> search(String searchString) {
        List<Product> output = new ArrayList<>();
        String[] searchWords = searchString.split(" ");
        // index.forEach((s, integer) -> System.out.println(s+" "+integer));
        // productNameIdMap.forEach((integer, product) -> System.out.println(integer+" "+product));
        for (String word : searchWords) {
            if (!index.containsKey(word)) {
                System.out.println("!index.containsKey(word)" + " " + word);
                return List.of();
            }
            //System.out.println("productNameIdMap.get(index.get(word))"+" "+productNameIdMap.get(index.get(word)));
            index.get(word).forEach(id -> output.add(productNameIdMap.get(id)));
        }
        return output;
    }

    public static List<Product> searchWithRank(String searchString) {
        List<Product> output = new ArrayList<>();
        String[] searchWords = searchString.split(" ");
        for (String word : searchWords) {
            if (!index.containsKey(word)) {
                System.out.println("!index.containsKey(word)" + " " + word);
                return List.of();
            }
            index.get(word).forEach(id -> {
                Product product = productNameIdMap.get(id);
                product.rank=word.length()* 100 / productNameIdMap.get(id).name.length();
                output.add(product);
            });
        }
        return output;
    }

    public static void main(String[] args) {
        Product p1 = new Product(1, "Amul Milk");
        Product p2 = new Product(2, "Nandini Chocolate Milk");
        Product p3 = new Product(3, "Milk Chocolate");
        Product p4 = new Product(4, "Chocolate Milk");
        Product p5 = new Product(5, "Milky Way Chocolate Bar");

        buildIndex(List.of(p1, p2, p3, p4, p5));
        buildProductNameIdMap(List.of(p1, p2, p3, p4, p5));

        System.out.println(search("Amul").stream().map(p -> p.name).collect(Collectors.joining(",")));

        System.out.println(search("Milk").stream().map(p -> p.name).collect(Collectors.joining(",")));

        System.out.println(search("Chocolate").stream().map(p -> p.name).collect(Collectors.joining(",")));

        System.out.println(searchWithRank("Milk")
                .stream().sorted((a,b)->b.rank-a.rank).map(e -> e.rank + " " + e.name).collect(Collectors.joining(",")));

    }
}
