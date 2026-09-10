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
    static int ans;
    class Pair{
        int sum;
        int count;
        Pair(int sum, int count){
            this.sum = sum;
            this.count = count;
        }
    }

    Pair fn(TreeNode root){
        if(root == null) return new Pair(0,0);
        Pair left = fn(root.left);
        Pair right = fn(root.right);
        int s = left.sum + right.sum + root.val;
        int c = 1 + left.count + right.count;
        if(s/c == root.val) ans++;
        return new Pair(s,c);
    }
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        fn(root);
        return ans;
    }
}