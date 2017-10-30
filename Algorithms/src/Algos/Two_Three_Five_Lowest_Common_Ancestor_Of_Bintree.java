package Algos;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

public class Two_Three_Five_Lowest_Common_Ancestor_Of_Bintree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// two situations:
		// 1. kids at the same direction
		// 1.1 when they are at the same direction, then just need to judge
		// whether they are samller or larger than root
		// 2. kids at different directions
		// 2.1 the root will be the LCA

		while ((root.val - p.val) * (root.val - q.val) > 0) {
			// they are at the same direction
			if (p.val < root.val) {
				root = root.left;
			} else {
				root = root.right;
			}
		}

		// if the root is the current, then directly return it
		return root;

		// if (root == p || root == q || root == null) { return root;
		// }//如果已经找到p,q返回，或者root为null，返回null
		// TreeNode left = lowestCommonAncestor(root.left, p, q);//先在左子树找
		// TreeNode right = lowestCommonAncestor(root.right, p, q);//再找右子树
		// if(left != null && right != null){//如果左右子树分别有一个，则返回根节点
		// return root;
		// }else if(left!=null){//如果只在左子树，返回left
		// return left;
		// }else{//如果只在右子树，返回right
		// return right;
		// }
	}

}
