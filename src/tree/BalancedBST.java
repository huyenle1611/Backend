package all_about_tree;

public class BalancedBST {
	
	BalancedBSTNode root;

	// O(logn) Search node by value
    public BalancedBSTNode search(int target) {
        BalancedBSTNode current = root;

        while (current != null) {
            if (current.value == target) {
                return current;
            }

            if (target < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }
}
