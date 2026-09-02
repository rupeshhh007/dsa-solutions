/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root == p || root ==q){
            return root;
        }

        TreeNode leftSearch = lowestCommonAncestor(root.left,p,q);
        TreeNode rightSearch = lowestCommonAncestor(root.right,p,q);

        if(leftSearch!=null && rightSearch!= null) return root;

        return leftSearch!=null ? leftSearch : rightSearch;


        
    }
}