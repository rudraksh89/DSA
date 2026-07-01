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
        if(root == null) return l;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(q.size() > 0){
            Pair front = q.remove();
            if(front.level == l.size()){
                l.add(new ArrayList<>());
            }
            l.get(front.level).add(front.node.val);
            if(front.node.left != null){
                q.add(new Pair(front.node.left,front.level+1));
            }
            if(front.node.right != null){
                q.add(new Pair(front.node.right,front.level+1));
            }
        }
        return l;
    }
}