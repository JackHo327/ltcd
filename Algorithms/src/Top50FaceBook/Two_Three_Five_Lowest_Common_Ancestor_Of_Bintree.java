package Top50FaceBook;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

public class Two_Three_Five_Lowest_Common_Ancestor_Of_Bintree {
	private class TreeNode {
		int val;
		TreeNode  left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
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
		// }//����Ѿ��ҵ�p,q���أ�����rootΪnull������null
		// TreeNode left = lowestCommonAncestor(root.left, p, q);//������������
		// TreeNode right = lowestCommonAncestor(root.right, p, q);//����������
		// if(left != null && right != null){//������������ֱ���һ�����򷵻ظ��ڵ�
		// return root;
		// }else if(left!=null){//���ֻ��������������left
		// return left;
		// }else{//���ֻ��������������right
		// return right;
		// }
	}

}
