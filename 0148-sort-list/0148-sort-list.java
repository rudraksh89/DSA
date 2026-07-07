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

    void linkedlisttolist(ListNode head, List<Integer> l){
        ListNode temp = head;
        while(temp != null){
            l.add(temp.val);
            temp = temp.next;
        }
    }
    void modify(List<Integer> l){
        Collections.sort(l);
    }

    void listtolinkedlist(ListNode head, List<Integer> l){
        ListNode curr = head;
        for(int i=0;i<l.size();i++){
            curr.val = l.get(i);
            curr = curr.next;
        }
    }
    public ListNode sortList(ListNode head) {
        List<Integer> l = new ArrayList<>();
        ListNode temp = head;
        linkedlisttolist(temp,l);
        modify(l);
        listtolinkedlist(temp,l);
        return head;
    }
}