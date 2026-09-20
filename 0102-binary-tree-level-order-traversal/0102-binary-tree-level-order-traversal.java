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

    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        if(root == null) return l;
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair top = q.remove();
            if(l.size() == top.level){
                l.add(new ArrayList<>());
            }
            l.get(top.level).add(top.node.val);
            if(top.node.left != null) q.offer(new Pair(top.node.left,top.level+1));
            if(top.node.right != null) q.offer(new Pair(top.node.right,top.level+1));
        }
        return l;

    }
}