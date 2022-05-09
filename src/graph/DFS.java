 //This is a sample program to check that there exists a path between source node and destination node
package graph; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
 
 public class DFS
 {
     private Map<String, LinkedHashSet<String>> map = new HashMap();
 
     public void addEdge(String node1, String node2)
     {
         LinkedHashSet<String> adjacent = map.get(node1);
         if (adjacent == null)
         {
             adjacent = new LinkedHashSet();
             map.put(node1, adjacent);
         }
         adjacent.add(node2);
     }
 
     public void addTwoWayVertex(String node1, String node2)
     {
         addEdge(node1, node2);
         addEdge(node2, node1);
     }
 
 
     public LinkedList<String> adjacentNodes(String last)
     {
         LinkedHashSet<String> adjacent = map.get(last);
         if (adjacent == null)
         {
             return new LinkedList();
         }
         return new LinkedList<String>(adjacent);
     }
 
     private static String  START;
     private static String  END;
     private static boolean flag;
     
     public static Set<String> printed = new HashSet<String>();
 
     public static void main(String[] args)
     {
         // this graph is directional
         DFS graph = new DFS();
         // graph.addEdge("A", "B");
         /*graph.addEdge("A", "C");
         graph.addEdge("B", "A");
         graph.addEdge("B", "D");
         graph.addEdge("B", "E"); 
         graph.addEdge("B", "F");
         graph.addEdge("C", "A");
         graph.addEdge("C", "E");
         graph.addEdge("C", "F");
         graph.addEdge("D", "B");
         graph.addEdge("E", "C");
         graph.addEdge("E", "F");
         // graph.addEdge("F", "B");
         graph.addEdge("F", "C");
         graph.addEdge("F", "E");*/
         
         
         
       /*  graph.addTwoWayVertex("0", "3");
         graph.addTwoWayVertex("3", "1");
         graph.addTwoWayVertex("1", "3");
         graph.addTwoWayVertex("4", "2");
         graph.addTwoWayVertex("2", "3");
         graph.addTwoWayVertex("5", "6");
         graph.addTwoWayVertex("3", "4");
         */
         
        /*0-----3     4
              --    -
             - -   -
            -  -  -
           -   - -
          -    --
         1     2*/
         
         
         
        /* graph.addEdge("1","4");
         graph.addEdge("1", "3");
         graph.addEdge("1", "2");
         graph.addEdge("2", "5");
         graph.addEdge("3", "7");
         graph.addEdge("3", "6");
         graph.addEdge("9", "13");
         graph.addEdge("9", "12");
         graph.addEdge("9", "11");
         graph.addEdge("9", "10");
         graph.addEdge("10", "11");
         graph.addEdge("11", "14");
         graph.addEdge("12", "14");*/
         
         graph.addEdge("0","1");
         graph.addEdge("0", "2");
         graph.addEdge("1", "2");
         graph.addEdge("2", "0");
         graph.addEdge("2", "3");
         graph.addEdge("3", "3");
         
         
         START = "2";
         LinkedList<String> visited = new LinkedList();
         
		
		Iterator<Entry<String, LinkedHashSet<String>>> itr = graph.map.entrySet().iterator();
		LinkedList<String> list = new LinkedList<String>();
		list.add(START);
		printed.add(START);
	
		System.out.print(START+" ");
		graph.breadthFirst(graph, list);
		
     }
 
     
     private void breadthFirst(DFS graph,
             LinkedList<String> visited)
     {
         LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
 
         for (String node : nodes)
         {
             if (visited.contains(node))
             {
                 continue;
             }
             visited.addLast(node);
            
             breadthFirst(graph, visited);
             if(!printed.contains(visited.getLast()))
             {
            	 printed.add(visited.getLast());
             System.out.print(visited.getLast()+" ");
             }
             visited.removeLast();
         }
     
 
     }
 
     
 }
