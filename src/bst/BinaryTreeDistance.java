package bst;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BinaryTreeDistance {

    // Find the Lowest Common Ancestor (LCA) iteratively
    public TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) return null;

        // Use a map to track parents of each node
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);

        // Perform BFS to populate the parent map
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!parentMap.containsKey(node1) || !parentMap.containsKey(node2)) {
            TreeNode current = queue.poll();

            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.add(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.add(current.right);
            }
        }

        // Use a set to track the ancestors of node1
        Set<TreeNode> ancestors = new HashSet<>();
        while (node1 != null) {
            ancestors.add(node1);
            node1 = parentMap.get(node1);
        }

        // Find the first common ancestor of node2
        while (!ancestors.contains(node2)) {
            node2 = parentMap.get(node2);
        }

        return node2; // This is the LCA
    }

    // Find the distance from a given node to the target node iteratively
    public int findDistance(TreeNode root, TreeNode target) {
        if (root == null) return -1;

        // Perform BFS to find the target node and track distance
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> distanceMap = new HashMap<>();
        queue.add(root);
        distanceMap.put(root, 0);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int currentDistance = distanceMap.get(current);

            if (current == target) return currentDistance;

            if (current.left != null) {
                queue.add(current.left);
                distanceMap.put(current.left, currentDistance + 1);
            }
            if (current.right != null) {
                queue.add(current.right);
                distanceMap.put(current.right, currentDistance + 1);
            }
        }

        return -1; // Target not found
    }

    // Calculate the total distance between two nodes
    public int findDistanceBetweenNodes(TreeNode root, TreeNode node1, TreeNode node2) {
        TreeNode lca = findLCA(root, node1, node2);

        // Calculate the distances from the LCA to each node
        int d1 = findDistance(lca, node1);
        int d2 = findDistance(lca, node2);

        return d1 + d2; // Total distance
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode node1 = root.left.left; // Node 4
        TreeNode node2 = root.right.right; // Node 7

        BinaryTreeDistance tree = new BinaryTreeDistance();
        int distance = tree.findDistanceBetweenNodes(root, node1, node2);

        System.out.println("Distance between nodes " + node1.val + " and " + node2.val + " is: " + distance);
    }
}
