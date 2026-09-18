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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean seen = false;
        while(!q.isEmpty()){
            TreeNode top = q.remove();
            if(top == null) seen = true;
            else{
                if(seen) return false;
                q.offer(top.left);
                q.offer(top.right);
            }
        }
        return true;
    }
}