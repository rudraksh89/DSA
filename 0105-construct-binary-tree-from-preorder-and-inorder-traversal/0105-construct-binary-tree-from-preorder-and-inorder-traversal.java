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

    TreeNode build(int prelow, int prehigh, int inlow, int inhigh, int[]preorder, int[]inorder, HashMap<Integer,Integer>mp){
        if(prelow > prehigh) return null;
        int val = preorder[prelow];
        TreeNode root = new TreeNode(val);
        int idx = mp.get(val);
        int cnt = idx - inlow;
        root.left = build(prelow+1,prelow+cnt,inlow,idx-1,preorder,inorder,mp);
        root.right = build(prelow+cnt+1,prehigh,idx+1,inhigh,preorder,inorder,mp);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(inorder[i],i);
        }
        return build(0,n-1,0,n-1,preorder,inorder,mp);
    }
}