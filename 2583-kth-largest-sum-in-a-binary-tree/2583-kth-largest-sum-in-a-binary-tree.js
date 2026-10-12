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
 * @param {number} k
 * @return {number}
 */
var kthLargestLevelSum = function(root, k) {
    let q = [];
    let list = [];
    q.push(root);
    while(q.length > 0){
        let size = q.length;
        let sum = 0;
        for(let i=0;i<size;i++){
            let node = q.shift();
            sum += node.val;
            if(node.left) q.push(node.left);
            if(node.right) q.push(node.right); 
        }
        list.push(sum);
    }
    list.sort((a,b) => b-a);
    if(list.length < k) return -1;
    return list[k-1];
};