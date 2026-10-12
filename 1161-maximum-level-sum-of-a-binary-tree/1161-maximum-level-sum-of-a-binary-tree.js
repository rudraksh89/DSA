/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxLevelSum = function(root) {
    let q = [];
    q.push(root);
    let lv = 0;
    let max = -Infinity;
    let ans = 1;
    while(q.length > 0){
        let size = q.length;
        let sum = 0;
        for(let i=0;i<size;i++){
            let node = q.shift();
            sum += node.val;
            if(node.left != null) q.push(node.left);
            if(node.right != null) q.push(node.right);
        }
        lv++;
        if(max < sum){
            max = sum;
            ans = lv;
        }
    }
    return ans;
};