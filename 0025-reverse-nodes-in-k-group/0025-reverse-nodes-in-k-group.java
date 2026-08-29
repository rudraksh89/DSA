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

    ListNode find(ListNode temp , int k){
        k--;
        while(temp != null && k > 0){
            k--;
            temp = temp.next;
        }
        return temp;

    }

    ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode after = head;
        ListNode prev = null;
        while(curr != null){
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode kthnode = find(temp,k);
            if(kthnode == null){
                if(prev != null){
                    prev.next = temp;
                }
                break;
            }
            ListNode after = kthnode.next;
            kthnode.next = null;
            reverse(temp);
            if(temp == head){
                head = kthnode;
            }else prev.next = kthnode;
            prev = temp;
            temp = after;
        }
        return head;
    }
}