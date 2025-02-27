package BinaryTrees;
import java.util.*;
public class LCNOfBinaryTree {
    //dfs + optimal
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p)
            return p;
        if (root == q)
            return q;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
    }
    //dfs + brute
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();

        // Find paths from root to p and q
        if (!findPath(root, p, pPath) || !findPath(root, q, qPath)) {
            return null; // One or both nodes not found in the tree
        }

        int i = 0;
        // Compare paths to find the lowest common ancestor
        while (i < pPath.size() && i < qPath.size() && pPath.get(i) == qPath.get(i)) {
            i++;
        }

        return pPath.get(i - 1); // Return the last common node
    }

    static boolean findPath(TreeNode root, TreeNode n, List<TreeNode> list) {
        if (root == null) return false;

        list.add(root);

        if (root == n) return true;

        if (findPath(root.left, n, list) || findPath(root.right, n, list)) {
            return true;
        }

        list.remove(list.size() - 1);

        return false;
    }
}

