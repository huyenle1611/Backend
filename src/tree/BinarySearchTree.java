package all_about_tree;

class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}
}

public class BinarySearchTree {
	Node root;

	public void addNode(Node node) {
		
		//case 0: node null
		if (node == null) {
			return;
		}

		// case 1: tree is empty
		if (root == null) {
			root = node;
			return;
		}

		// create a pointer and points at root
		Node current = root;

		while (true) {
			// case 2: node has duplicate value with existing nodes in tree >> don't add
			if (current.value == node.value) {
				return;
			}

			// case 3: go to the left subtree
			if (node.value < current.value) {
				// left child of current node is empty
				if (current.left == null) {
					current.left = node;
					return;
				}
				current = current.left;
			}

			// case 4: go to the right subtree
			else {
				// right child of current node is empty
				if (current.right == null) {
					current.right = node;
					return;
				}
				current = current.right;
			}
		}

	}

	public static void main(String[] args) {
		Node root = new Node(50);
		Node node1 = new Node(30);
		Node node2 = new Node(40);
		Node node3 = new Node(60);
		Node node4 = new Node(80);

		BinarySearchTree tree = new BinarySearchTree();

		tree.addNode(root);
		tree.addNode(node1);
		tree.addNode(node2);
		tree.addNode(node3);
		tree.addNode(node4);
	}

}
