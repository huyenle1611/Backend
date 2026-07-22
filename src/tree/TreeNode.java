package all_about_tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	int value;
	List<TreeNode> children = new ArrayList<TreeNode>(); 
	
	public TreeNode(int value) {
		this.value = value;
	}
}
