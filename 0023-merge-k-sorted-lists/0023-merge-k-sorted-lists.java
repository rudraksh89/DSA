/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = lists.length;
        for(ListNode row : lists){
            while(row != null){
                pq.add(row.val);
                row = row.next;
            }
        }
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        while(pq.size() > 0){
            ListNode p = new ListNode(pq.remove());
            head.next = p;
            head = head.next;
        }
        return temp.next;
    }
}