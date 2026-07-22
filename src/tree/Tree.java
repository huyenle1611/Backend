package all_about_tree;

import java.util.LinkedList;

public class Tree {
	TreeNode root;

	// DFS - find and return the node
	public TreeNode dfs(TreeNode node, int target) {
		if (node == null) {
			return null;
		}
		if (node.value == target) {
			return node;
		}
		// recursion
		for (TreeNode child : node.children) {
			TreeNode result = dfs(child, target);

			if (result != null) {
				return result;
			}
		}
		return null;
	}

	// BFS - find and return the node (check by node value)
	public static TreeNode bfs(TreeNode root, int target) {
		if (root == null) {
			return null;
		}
		
		// create linkedlist to store nodes
		LinkedList<TreeNode> list = new LinkedList<>();
		list.addLast(root);

		// get first node in linkedlist and check
		while (!list.isEmpty()) {
			TreeNode current = list.removeFirst();

			if (current.value == target) {
				return current;
			}

			for (TreeNode child : current.children) {
				list.addLast(child);
			}
		}
		return null;
	}

	// Add a node into tree via a target node
	public void addChild(TreeNode node, int target, int newValue) {

	    if (node == null) {
	        return;
	    }

	    if (node.value == target) {
	        node.children.add(new TreeNode(newValue));
	        return;
	    }

	    for (TreeNode child : node.children) {
	        addChild(child, target, newValue);
	    }
	}
	
}
