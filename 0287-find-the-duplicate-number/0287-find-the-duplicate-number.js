/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function(nums) {
    let set = new Set();
    let ans = 0;
    for(let i=0;i<nums.length;i++){
        if(set.has(nums[i])){
            ans = nums[i];
            break;
        }
        set.add(nums[i]);
    }
    return ans;
};