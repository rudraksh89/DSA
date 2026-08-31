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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head.next;
        List<Integer> l = new ArrayList<>();
        int k = 2;
        while(p2.next != null){
            if((p2.val > p1.val && p2.val > p2.next.val) || (p2.val < p1.val && p2.val < p2.next.val)){
                l.add(k);
            }
            p1 = p1.next;
            p2 = p2.next;
            k++;
        }
        if (l.size() < 2) {
            return new int[]{-1, -1};
        }
        int min = Integer.MAX_VALUE;
        for (int i=1;i<l.size();i++) {
            min = Math.min(min, l.get(i) - l.get(i - 1));
        }
        int max = l.get(l.size() - 1) - l.get(0);
        return new int[]{min, max};
    }
}