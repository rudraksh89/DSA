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

    HashMap<Integer, Integer> map = new HashMap<>();

    int[] preorder;
    int[] postorder;

    TreeNode build(int preSt, int preEnd, int postSt, int postEnd) {
        if (preSt > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preSt]);
        if (preSt == preEnd) return root;

        int leftRoot = preorder[preSt + 1];
        int idx = map.get(leftRoot);
        int leftSize = idx - postSt + 1;

        // Build left subtree
        root.left = build(preSt + 1,
                          preSt + leftSize,
                          postSt,
                          idx);

        // Build right subtree
        root.right = build(preSt + leftSize + 1,
                           preEnd,
                           idx + 1,
                           postEnd - 1);

        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        this.preorder = preorder;
        this.postorder = postorder;

        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        return build(0,
                     preorder.length - 1,
                     0,
                     postorder.length - 1);
    }
}