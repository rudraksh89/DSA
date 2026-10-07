/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var findIntersectionValues = function(nums1, nums2) {
    let mp1 = new Map();
    let mp2 = new Map();
    for(let i=0;i<nums1.length;i++){
        mp1.set(nums1[i],(mp1.get(nums1[i])||0)+1);
    }
    for(let i=0;i<nums2.length;i++){
        mp2.set(nums2[i],(mp2.get(nums2[i])||0)+1);
    }
    let c1 = 0;
    let c2 = 0;

    for(let i=0;i<nums1.length;i++){
        if(mp2.has(nums1[i])) c1++;
    }
    for(let i=0;i<nums2.length;i++){
        if(mp1.has(nums2[i])) c2++;
    }
    let ans = [];
    ans.push(c1);
    ans.push(c2);
    return ans;
};