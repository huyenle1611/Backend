package avl_tree;
/*
 * Flow when adding a node into an AVL Tree:
 *
 * 1. Add the new node normally, like in a Binary Search Tree.
 *
 * 2. While recursion returns from the bottom to the top,
 *    update the height of each ancestor node.
 *
 * 3. Calculate the balance factor of each ancestor node:
 *
 *    balanceFactor = height(left subtree) - height(right subtree)
 *
 * 4. If the balance factor is outside {-1, 0, 1}, the current node is imbalanced.
 *
 * 5. Determine the imbalance case:
 *    - LL: rotate right
 *    - RR: rotate left
 *    - LR: rotate left child, then rotate right
 *    - RL: rotate right child, then rotate left
 *
 * 6. Return the new root of the current subtree.
 */

class Node {
	int value;
	Node left;
	Node right;
	int height;

	public Node(int value) {
		this.value = value;
		this.height = 0; // new node has no child
	}
}

public class AVLTree {
	Node root;

	// Add node
	public Node addNode(Node root, Node node) {
		if (node == null) {
			return root;
		}

		if (root == null) {
			root = node;
		}

		if (node.value < root.value) {
			root.left = addNode(root.left, node);
		} else if (node.value > root.value) {
			root.right = addNode(root.right, node);
		} else {
			return root; // duplicate value >> don't add in the tree
		}

		updateHeight(root);
		int balanceFactor = getBalanceFactor(root);

		// left-heavy (LL or LR imbalance)
		if (balanceFactor > 1) {
			// LR imbalance > left rotation for child node > then right rotation for root
			if (getBalanceFactor(root.left) < 0) {
				root.left = rotateLeft(root.left);
			}
			// LL imbalance > right rotation
			return rotateRight(root);
		}
		// right heavy (RR or RL imbalance)
		if (balanceFactor < -1) {
			// RL imbalance > right rotation for child node > then left rotation for root
			if (getBalanceFactor(root.right) > 0) {
				root.right = rotateRight(root.right);
			}
			// RR imbalance > Left rotation
			return rotateLeft(root);
		}
		return root;

	}

	/* SUPPORTING FUNCTIONS */

	// 1. get height
	public static int getHeight(Node node) {
		if (node == null) {
			return -1;
		} else {
			return node.height;
		}
	}

	// 2. Update height
	private static void updateHeight(Node node) {
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	// 3. Calculate balance factor
	public static int getBalanceFactor(Node node) {
		return (getHeight(node.left) - getHeight(node.right));
	}

	// 4. rotate right (LL imbalance)
	private static Node rotateRight(Node imbalancedNode) {
		Node newRoot = imbalancedNode.left;
		Node temp = newRoot.right;

		newRoot.right = imbalancedNode;
		imbalancedNode.left = temp;

		// update height after rotation
		updateHeight(imbalancedNode);
		updateHeight(newRoot);

		return newRoot;
	}

	// 5. rotate left (RR imbalance)
	private static Node rotateLeft(Node imbalancedNode) {
		Node newRoot = imbalancedNode.right;
		Node temp = newRoot.left;

		newRoot.left = imbalancedNode;
		imbalancedNode.right = temp;

		// update height after rotation
		updateHeight(imbalancedNode);
		updateHeight(newRoot);

		return newRoot;

	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();

		tree.root = tree.addNode(tree.root, new Node(30));
		tree.root = tree.addNode(tree.root, new Node(20));
		tree.root = tree.addNode(tree.root, new Node(10));

		System.out.println("Root: " + tree.root.value);
		System.out.println("Left: " + tree.root.left.value);
		System.out.println("Right: " + tree.root.right.value);

	}

}
