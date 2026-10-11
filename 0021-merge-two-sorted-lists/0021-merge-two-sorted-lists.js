/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeTwoLists = function(list1, list2) {
    let t1 = list1;
    let t2 = list2;
    let dum = new ListNode(0);
    let temp = dum;
    while(t1 != null && t2 != null){
        if(t1.val > t2.val){
            let t = new ListNode(t2.val);
            temp.next = t;
            temp = t;
            t2 = t2.next;
        }else if(t1.val < t2.val){
            let t = new ListNode(t1.val);
            temp.next = t;
            temp = t;
            t1 = t1.next;
        }else{
            let t = new ListNode(t1.val);
            temp.next = t;
            temp = t;
            t1 = t1.next;
        }
    }
    while(t1 != null){
        temp.next = new ListNode(t1.val);
        t1 = t1.next;
        temp = temp.next;
    }
    while(t2!=null){
        temp.next = new ListNode(t2.val);
        t2 = t2.next;
        temp = temp.next;
    }
    return dum.next;
};