// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. find mid, 2. reverse second half, 3 compare first half with second half
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
    public boolean isPalindrome(ListNode head) {
        if(head == null ||  head.next == null){
            return true;
        }

        ListNode slow = head; 
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverse(slow.next);
        ListNode first = head; 
        ListNode second = newHead; 

        while(second != null){
            if(first.val != second.val){
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;

        }
        reverse(newHead);
        return true;

    }

    private ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode front = null;
        ListNode prev = null;
        
        while(temp != null){
            front = temp.next;
            temp.next = prev;

            prev = temp;
            temp = front;
        }
        return prev;
    }
}