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
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
 
 public class BFS
 {
     private Map<String, LinkedList<String>> map = new HashMap();
 
     public void addEdge(String node1, String node2)
     {
    	 LinkedList<String> adjacent = map.get(node1);
         if (adjacent == null)
         {
             adjacent = new LinkedList();
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
    	 LinkedList<String> adjacent = map.get(last);
         if (adjacent == null)
         {
             return new LinkedList();
         }
         return new LinkedList<String>(adjacent);
     }
 
     private static String  START;
     
 
     public static void main(String[] args)
     {
         // this graph is directional
         BFS graph = new BFS();
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
         
         
         graph.addEdge("0","1");
         graph.addEdge("0", "2");
         graph.addEdge("1", "2");
         graph.addEdge("2", "0");
         graph.addEdge("2", "3");
         graph.addEdge("3", "3");
         
         
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
         
         START = "2";
		graph.bfs(graph, START);
		graph.dfs(graph, START);
		
     }
 
     private void bfs(BFS graph,String node)
     {
    	 System.out.println("BFS");
    	 LinkedList<String> visited = new LinkedList();
    	 Queue<String> q = new LinkedList<String>();
 		q.add(node);
 		visited.add(node);
 		while(!q.isEmpty()){
 			String n = q.poll();
 			System.out.print(n + " ");
 			for(String adj : graph.adjacentNodes(n)){
 				if(!visited.contains(adj)){
 					visited.add(adj);
 					q.add(adj);
 				}
 			}
 		}
     }
 
     // please refer to BFS.jpeg for i/p, o/p should be 2 0 3 1
     
     
     
     private void dfs(BFS graph,String node)
     {
    	 System.out.println("DFS");
    	 LinkedList<String> visited = new LinkedList();
    	 Stack<String> q = new Stack<String>();
 		q.push(node);
 		visited.add(node);
 		while(!q.isEmpty()){
 			String n = q.pop();
 			System.out.print(n + " ");
 			for(String adj : graph.adjacentNodes(n)){
 				if(!visited.contains(adj)){
 					visited.add(adj);
 					q.push(adj);
 				}
 			}
 		}
     }
 }
