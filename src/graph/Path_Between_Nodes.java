 //This is a sample program to check that there exists a path between source node and destination node
package graph; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
 
 public class Path_Between_Nodes
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
 
     /*public boolean isConnected(String node1, String node2)
     {
         Set adjacent = map.get(node1);
         if (adjacent == null)
         {
             return false;
         }
         return adjacent.contains(node2);
     }*/
 
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
 
     public static void main(String[] args)
     {
         // this graph is directional
         Path_Between_Nodes graph = new Path_Between_Nodes();
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
         
         
         
         graph.addTwoWayVertex("0", "3");
         graph.addTwoWayVertex("3", "1");
         graph.addTwoWayVertex("1", "3");
         graph.addTwoWayVertex("4", "2");
         graph.addTwoWayVertex("2", "3");
         graph.addTwoWayVertex("5", "6");
         
         
        /*0-----3     4
              --    -
             - -   -
            -  -  -
           -   - -
          -    --
         1     2*/
         
         
         LinkedList<String> visited = new LinkedList();
         
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter test cases:");
		int t = Integer.parseInt(sc.nextLine());
		String [][] arr= new String[t][2];
		for (int i = 0; i < t; i++) {
			System.out.println("Enter the source node:");
			arr[i][0]= sc.next();
			System.out.println("Enter the destination node:");
			arr[i][1]= sc.next();
		}
		
		for (int i = 0; i < t; i++) {
			START = arr[i][0];
			END = arr[i][1];
			visited.add(START);
			flag = false;
			new Path_Between_Nodes().breadthFirst(graph, visited);
			if (!flag)
				System.out.println("No Path between "+START+" and "+END);
			new Path_Between_Nodes().bfs(graph, START);
		}
		sc.close();
     }
 
     private void breadthFirst(Path_Between_Nodes graph,
             LinkedList<String> visited)
     {
         LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
 
         for (String node : nodes)
         {
             if (visited.contains(node))
             {
                 continue;
             }
             if (node.equals(END))
             {
                 visited.add(node);
                 printPath(visited);
                 visited.removeLast();
                 break;
             }
         }
 
         for (String node : nodes)
         {
             if (visited.contains(node) || node.equals(END))
             {
                 continue;
             }
             visited.addLast(node);
             breadthFirst(graph, visited);
             visited.removeLast();
         }
       /*  if (!visited.getLast().equals(END))
         {
             System.out.println("No path Exists between " + START + " and "
                     + END);
             flag = false;
         }*/
 
     }
 
     private void printPath(LinkedList<String> visited)
     {
    	 flag=true;
             System.out.println("Yes there exists a path between " + START
                     + " and " + END);
 
         for (String node : visited)
         {
             System.out.print(node);
             System.out.print(" ");
         }
         System.out.println();
     }
     
     private void bfs(Path_Between_Nodes graph,String node)
     {
    	 System.out.println("BFS");
    	 LinkedList<String> visited = new LinkedList();
    	 Queue<String> q = new LinkedList<String>();
 		q.add(node);
 		visited.add(node);
 		while(!q.isEmpty()){
 			String n = q.poll();
 			System.out.print(n + " ");
 			if(n.equals(END))
 			{
 				System.out.println("path exists");
 				return;
 			}
 			for(String adj : graph.adjacentNodes(n)){
 				if(!visited.contains(adj)){
 					visited.add(adj);
 					q.add(adj);
 				}
 			}
 		}
 		System.out.println("path dosent exiists");
     }
 
     
     
 }
