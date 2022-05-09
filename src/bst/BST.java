package bst;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.tree.TreeNode;

import com.sun.javafx.collections.MappingChange.Map;

import junit.FindMinInRotatedArray;

import bst.BSTNode;

public class BST {
	BSTNode root;
	
	static boolean v1 = false, v2 = false;

	public void add(int data) {
		add(root, data);
	}

	public void add(BSTNode node, int data) {
		if (root == null) {
			root = new BSTNode(data);
		} else {
			if (data > node.data) {
				if (node.right == null) {
					node.right = new BSTNode(data);
				} else {
					add(node.right, data);
				}
			} else {
				if (node.left == null) {
					node.left = new BSTNode(data);
				} else {
					add(node.left, data);
				}
			}
		}
	}

	public void preOrder() {
		preOrder(root);
	}

	public void preOrder(BSTNode node) {
		if (node != null) {
			System.out.println(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	/*
	 * the Preorder traversal of the above tree will outputs: 7, 1, 0, 3, 2, 5,
	 * 4, 6, 9, 8, 10
	 */

	public void inOrder() {
		inOrder(root);
	}

	public void inOrder(BSTNode node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}

	/*
	 * Inorder traversal of the above tree will outputs: 0, 1, 2, 3, 4, 5, 6, 7,
	 * 8, 9, 10
	 */

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(BSTNode node) {

		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data + " ");
		}

	}

	/*
	 * the Postorder traversal of the above tree will outputs: 0, 2, 4, 6, 5, 3,
	 * 1, 8, 10, 9, 7
	 */

	public void convertSortedArrayToBalancedBST(int[] arr) {
		this.root = convertSortedArrayToBST(arr, 0, arr.length - 1);
	}
    // make middle element root and convert left and right sub arrays to bst
	public BSTNode convertSortedArrayToBST(int[] arr, int left, int right) {
		BSTNode node = new BSTNode(0);
		if (left > right)
			return null;
		if (left == right) {
			node.data = arr[left];
			node.left = null;
			node.right = null;
		} else {
			int mid = (left + right) / 2;
			node.data = arr[mid];
			node.left = convertSortedArrayToBST(arr, left, mid - 1);
			node.right = convertSortedArrayToBST(arr, mid + 1, right);
		}
		return node;
	}

	/*
	 * Get the height of left sub tree, say leftHeight Get the height of right
	 * sub tree, say rightHeight Take the Max(leftHeight, rightHeight) and add 1
	 * for the root and return
	 */
	public int getTreeHeight() {
		return getTreeHeight(root);
	}

	private int getTreeHeight(BSTNode node) {
		if (node == null)
			return 0;
		return 1 + Math
				.max(getTreeHeight(node.left), getTreeHeight(node.right));
	}

	public boolean isTreeBalanced(BSTNode node) {
		if (node == null) {
			return true;

		}
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);

		if (Math.abs(leftHeight - rightHeight) <= 1
				&& isTreeBalanced(node.left) && isTreeBalanced(node.right))
			return true;
		return false;
	}

	private int getHeight(BSTNode node) {
		// TODO Auto-generated method stub
		if (node == null)
			return 0;
		return getHeight(node.left) > getHeight(node.right) ? 1 + getHeight(node.left)
				: 1 + getHeight(node.right);
	}

	public void printAllNodesAtALevel( int level) {
		Queue<BSTNode> q = new LinkedList<BSTNode>();
		q.add(root);
		q.add(null);
		int currLevel = 0;
		while (!q.isEmpty()) {
			BSTNode node = q.poll();
			if (node == null) {
				currLevel++;
				if (!q.isEmpty())
					q.add(null);
			} else {
				if (currLevel == level)
					System.out.print(node.data + " ");
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
		}
	}

	// widht is max no of nodes at a level in tree
	public static void getWidthOfTree(BSTNode root) {
		Queue<BSTNode> q = new LinkedList<BSTNode>();
		q.add(root);
		q.add(null);
		int width = 0, maxwidth = 0;
		while (!q.isEmpty()) {
			BSTNode node = q.poll();
			if (node == null) {

				if (width > maxwidth)
					maxwidth = width;
				width = 0;
				if (!q.isEmpty())
					q.add(null);
			} else {
				width++;
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
		}
		System.out.println("width " + maxwidth);
	}

	public BSTNode delete(BSTNode node, int data) {

		if (node == null)
			return null;
		else if (data < node.data)
			node.left = delete(node.left, data);
		else if (data > node.data)
			node.right = delete(node.right, data);
		else {

			System.out.println("found data");
			if (node.left == null && node.right == null) {
				node = null;
			} else if (node.left == null) {
				node = node.right;
			} else if (node.right == null) {
				node = node.left;
			} else if (node.right != null && node.left != null) {
				BSTNode temp = FindMin(node.right);// leftmost node in right
													// subtree
				node.data = temp.data;
				node.right = delete(node.right, temp.data);
			}

		}
		return node;
	}

	private BSTNode find(BSTNode root, int data) {
		// TODO Auto-generated method stub
		if (root == null)
			return null;
		if (data == root.data)
			return root;
		if (data > root.data)
			return find(root.right, data);
		else
			return find(root.left, data);
	}

	private BSTNode FindMin(BSTNode node) {
		// TODO Auto-generated method stub
		if (node == null)
			return null;
		if (node.left != null)
			return FindMin(node.left);
		else
			return node;
	}

	public void isBST() {
		int prev = 0;
		System.out.println("isBST " + isBST(root, prev));
	}

	// in order travesal should return curr val > prev val
	public boolean isBST(BSTNode node, int prev) {
		if (node == null)
			return true;
		if (!isBST(node.left, prev))
			return false;
		if (node.data < prev)
			return false;
		prev = node.data;
		return isBST(node.right, prev);
	}

	public void findLca1(int t1,int t2)
	{
		BSTNode lca = findLca1(root, t1, t2);
		if(lca!=null)
		System.out.println("findLca"+lca.data);
		else
			System.out.println("node not there");
	}
	
	/*Now, adapt this to take two "target" parameters, target1 and target2.

	When the search for target1 takes you left, and the search for target2 takes you right, you've found the LCA.

	This assumes that both targets actually do exist. If you need to assert that they do, you'll need to continue the search after finding the potential LCA.
*/
	public BSTNode findLca1(BSTNode node, int t1, int t2) {
	    if(node == null) {
	        return null;
	    }
	    if(node.data > t2 && node.data > t1) {
	        // both targets are left
	        return findLca1(node.left, t1, t2);
	    } else if (node.data < t2 && node.data < t1) {
	        // both targets are right
	        return findLca1(node.right, t1, t2);
	    } else {
	        // either we are diverging or both targets are equal
	        // in both cases so we've found the LCA
	        // check for actual existence of targets here, if you like
	        return node;
	    }
	}
	
	// Time complexity of the below solution is O(n) 
	// This function returns pointer to LCA of two given
    // values n1 and n2.
    // v1 is set as true by this function if n1 is found
    // v2 is set as true by this function if n2 is found
    BSTNode findLCAUtil(BSTNode node, int n1, int n2)
    {
        // Base case
        if (node == null)
            return null;
 
        // If either n1 or n2 matches with root's key, report the presence
        // by setting v1 or v2 as true and return root (Note that if a key
        // is ancestor of other, then the ancestor key becomes LCA)
        if (node.data == n1)
        {
            v1 = true;
            return node;
        }
        if (node.data == n2)
        {
            v2 = true;
            return node;
        }
 
        // Look for keys in left and right subtrees
        BSTNode left_lca = findLCAUtil(node.left, n1, n2);
        BSTNode right_lca = findLCAUtil(node.right, n1, n2);
 
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return node;
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }
 
    // Finds lca of n1 and n2 under the subtree rooted with 'node'
    void findLCA(int n1, int n2)
    {
    	// this algo works only if both nodes are present in tree
        // Find lca of n1 and n2 using the technique discussed above
        BSTNode lca = findLCAUtil(root, n1, n2);
        
        if(lca!=null)
            System.out.println("LCA is "+ lca.data);
        else
        // Else return NULL
        System.out.println("Node not present for LCA");
    }
	
    
    /*For two trees �a� and �b� to be mirror images, the following three conditions must be true:

    	Their root node�s key must be same
    	Left subtree of root of �a� and right subtree root of �b� are mirror.
    	Right subtree of �a� and left subtree of �b� are mirror.*/
    public boolean isMirror(BSTNode node1,BSTNode node2)
    {
    	if(node1==null && node2==null)
    		return true;
    	if(node1==null || node2==null)
    		return false;
    	return node1.data==node2.data &&
    	       isMirror(node1.left, node2.right) &&
    	       isMirror(node1.right, node2.left);
    }
    
	public void zigzagtraversal(BSTNode node) {
		System.out.println("zigzag start");
		Stack<BSTNode> s1 = new Stack<>();
		Stack<BSTNode> s2 = new Stack<>();
		boolean lftToRght = true;
		s1.push(node);
		while (!s1.isEmpty()) {
		node = s1.pop();
			System.out.print(node.data+" ");
			if (lftToRght) {
				if(node.left!=null)
				s2.push(node.left);
				if(node.right!=null)
				s2.push(node.right);
			} else {
				if(node.right!=null)
				s2.push(node.right);
				if(node.left!=null)
				s2.push(node.left);
			}
			if (s1.isEmpty()) {
				lftToRght = !lftToRght;
				s1 = s2;
				s2 = new Stack<BSTNode>();
			}
		}
		System.out.println("zigzag end");
	}
	public void iterativeInOrder() {
		System.out.println("iterativeInOrder");
		BSTNode curr = root;
		Stack<BSTNode> stack = new Stack<>();
		while(curr!=null || !stack.isEmpty()) {
			while(curr!=null) {
				stack.push(curr);
				curr=curr.left;
			}
			//we have got left most element 
			curr=stack.pop();
			System.out.print(curr.data +"  ");
			// we have printd curr node
			curr=curr.right;
		}
		System.out.println("iterativeInOrder end");
	}
	
	public void printRootToLeaf() {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		printRootToLeaf(root, stack, stack2);
	}
	
	// https://www.youtube.com/watch?v=zIkDfgFAg60
	public void printRootToLeaf(BSTNode node, Stack<Integer> stack, Stack<Integer> stack2) {
		
		if(node !=null) {
			stack.push(node.data);
			
			
			printRootToLeaf(node.left, stack, stack2);
			if(node.left == null && node.right==null)
			{
				System.out.println();
				while(!stack.isEmpty())
				{
					int data = stack.pop();
					stack2.push(data);
					System.out.print(data +"-->");
				}
				while(!stack2.isEmpty())
				{
					stack.push(stack2.pop());
				}
				
			}
			
			printRootToLeaf(node.right, stack, stack2);
			if(!stack.isEmpty())
				stack.pop();
		}
	}
	
	
	// Find two elements in balanced BST which sums to a given a value.
	// https://yuanhsh.iteye.com/blog/2209411
	
	public void findPair(int sum) {
		Stack<BSTNode> ls = new Stack<>();
		Stack<BSTNode> rs = new Stack<>();
		BSTNode lnode = root;
		BSTNode rnode = root;
		boolean searchl = true;
		boolean searchr = true;
		int lval = 0;
		int rval = 0;
		while(true) {
			while(searchl) {
				while(lnode!=null) {
					ls.push(lnode);
					lnode =lnode.left;
				}
				if(!ls.isEmpty()) {
					lnode=ls.pop();
					lval=lnode.data;
					lnode=lnode.right;
					searchl=false;
				}
			}

			while(searchr) {
				while(rnode!=null) {
					rs.push(rnode);
					rnode =rnode.right;
				}
				if(!rs.isEmpty()) {
					rnode=rs.pop();
					rval=rnode.data;
					rnode=rnode.left;
					searchr=false;
				}
			}
			
			if(lval>=rval) {
				System.out.println(" no pair ");
				break;
			}
			if((lval+rval)>sum) {
				// search for smaller value in right subtree
				searchr=true;
			}if((lval+rval) ==sum) {
				// search for smaller value in right subtree
				System.out.println(" pair "+lval+" "+rval);
				break;
			}
		if((lval+rval)>sum) {
			// search for smaller value in right subtree
			searchr=true;
		}else {
			searchl=true;
		}
		
		}
	}
	
	
    private class Pair{
    	BSTNode node;
    	Integer distance;
    	public Pair(BSTNode node,Integer distance) {
    		this.node = node;
    		this.distance=distance;
		}
    }
    
    // https://www.geeksforgeeks.org/iterative-method-to-print-left-view-of-a-binary-tree
    public void leftView() {
    	// do level order traversal if node is first node of level print
    	Queue<BSTNode> q = new LinkedList<>();
    	q.add(root);
    	q.add(null);
    	boolean firstNode = true;
    	System.out.println("left view");
    	while(!q.isEmpty()) {
    		BSTNode node = q.poll();
    		if(node==null) {
    			// level changed set flag
    			firstNode=true;
    			if(!q.isEmpty()) {
    				q.add(null);
    			}
			} else {
				if (firstNode) {
					System.out.print(node.data + " ");
					firstNode = false;
				}
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
    	}
    }
    
    //https://www.geeksforgeeks.org/print-nodes-in-the-top-view-of-binary-tree-set-3/
	public void topView() {
		//  follow vertical distance+level order
		Queue<Pair> q = new LinkedList<>();
		java.util.Map<Integer,BSTNode> verticalDisMap = new HashMap<Integer,BSTNode>();
		q.add(new Pair(root, 0));
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			BSTNode  node = pair.node;
			Integer distance = pair.distance;
			if(!verticalDisMap.containsKey(distance)) {
				verticalDisMap.put(distance, node);
			}
			if(node.left!=null)
			{
				q.add(new Pair(node.left, distance-1));
			}
			if(node.right!=null)
			{
				q.add(new Pair(node.right, distance+1));
			}
		}
		System.out.println("topview");
		verticalDisMap.forEach((k,v)->System.out.print(v.data+" "));
	
	}
	
	public void printDiagonalWise() {
		Queue<Pair> q = new LinkedBlockingQueue<>();
		java.util.Map<Integer, List<BSTNode>> map= new HashMap<>();
		q.add(new Pair(root, 0));
		while(!q.isEmpty()) {
			Pair  pair = q.poll();
			BSTNode node = pair.node;
			Integer distance = pair.distance;
			if(map.containsKey(distance)) {
				map.get(distance);
			}
		}
	}
	
	
	// https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
	
	public void printLeaves() {
		System.out.println(" leaves ");
		printLeafNodes(root);
	}
	
	public static void printLeafNodes(BSTNode node) {
	    // base case
	    if (node == null) {
	      return;
	    }

	    if (node.left == null && node.right == null) {
	      System.out.printf("%d ", node.data);
	    }

	    printLeafNodes(node.left);
	    printLeafNodes(node.right);
	  }
	
	static int diameter = 0;
	
	// https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/
	public int getTreeDiameter(BSTNode node) {
		getDiameterHeight(node);
		return diameter;
	}
	
	public int getDiameterHeight(BSTNode node) {
		if(node==null)
			return 0;
		diameter=Math.max(diameter, 
				1+getDiameterHeight(node.left)+getDiameterHeight(node.right));
		return 1+Math.max(getDiameterHeight(node.left), getDiameterHeight(node.right));
		
	}
	
	//  https://www.geeksforgeeks.org/minimum-time-to-burn-a-tree-starting-from-a-leaf-node/
	public void timeToBurnTree() {
		//consider tree as graph perform BFS find farthest distance
	}

	public static void main(String[] args) {
		BST bst = new BST();

		/*
		 * bst.add(7); bst.add(1); bst.add(0); bst.add(9); bst.add(3);
		 * bst.add(8); bst.add(10); bst.add(2); bst.add(5); // bst.add(4); //
		 * bst.add(6); bst.add(11);
		 */

		// bst.add(93);
		// bst.preOrder();
		// bst.inOrder();

		bst.convertSortedArrayToBalancedBST(new int[] { 1, 2, 3, 4, 5, 6 ,9});
		System.out.println("TreeHeight " + bst.getTreeHeight());
		System.out.println("Tree is balanced " + bst.isTreeBalanced(bst.root));
		System.out.println("printing all nodes of level 2");
		bst.printAllNodesAtALevel( 2);
		bst.getWidthOfTree(bst.root);
		bst.postOrder();
		System.out.println();
		bst.delete(bst.root, 1);
		System.out.println();
		bst.postOrder();
		bst.isBST();
		bst.findLCA(2,6);
		bst.zigzagtraversal(bst.root);
		bst.inOrder();
		bst.iterativeInOrder();
		
		BST bst1 = new BST();
		BSTNode root = new BSTNode(1); 
	    root.left = new BSTNode(2); 
	    root.right = new BSTNode(3); 
	    root.left.right = new BSTNode(4); 
	    root.left.right.right = new BSTNode(5); 
	    root.left.right.right.right = new BSTNode(6);
	    bst1.root=root;
	    bst1.topView();
	    
	    bst.printLeaves();
	    bst.findPair(11);
	    bst.leftView();
	    
	    bst.printRootToLeaf();
	    
	    System.out.println("getTreeDiameter "+bst.getTreeDiameter(bst.root));
	    
	}
}
