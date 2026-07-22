package all_about_tree;

public class Be10Main {

	public static void main(String[] args) {

		Tree tree = new Tree();

		// Create root
		tree.root = new TreeNode(1);

		// Level 1
		TreeNode child1 = new TreeNode(5);
		TreeNode child2 = new TreeNode(10);

		tree.root.children.add(child1);
		tree.root.children.add(child2);

		// Level 2
		child1.children.add(new TreeNode(15));
		child1.children.add(new TreeNode(20));

		child2.children.add(new TreeNode(25));
		child2.children.add(new TreeNode(30));

		// DFS
		System.out.println(tree.dfs(tree.root, 20).value); 
		System.out.println(tree.dfs(tree.root, 23)); 


		// BFS
		System.out.println(Tree.bfs(tree.root, 25).value); 
		System.out.println(Tree.bfs(tree.root, 27)); 


		// Add child
		tree.addChild(tree.root, 10, 100);
		
		//check node 100 added
		System.out.println(Tree.bfs(tree.root, 100).value); 

	}

}
