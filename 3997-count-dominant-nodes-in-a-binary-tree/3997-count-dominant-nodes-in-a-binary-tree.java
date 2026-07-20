/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    int dfs(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;
       if(root.left == null && root.right == null){
        ans++;
        return root.val;
       }
       int leftmx = dfs(root.left);
       int rightmx = dfs(root.right);
       int mx = Math.max(leftmx,rightmx);
       if(root.val >= mx) ans++;
       return Math.max(root.val,mx); 
    }
    public int countDominantNodes(TreeNode root) {
        dfs(root);
        return ans;
    }
}