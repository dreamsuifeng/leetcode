/*
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list
 * Easy (32.27%)
 * Total Accepted:    100669
 * Total Submissions: 311940
 * Testcase Example:  '[]'
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverse(ListNode head){
		if (head==null || head.next==null) return head;
		ListNode p=head,q=head.next,tmp=null;
		p.next=null;
		while (q!=null){
		    tmp=q.next;
			q.next=p;
			p=q;
			q=tmp;
			
		}
		return p;
	}
    public boolean isPalindrome(ListNode head) {
        if (head==null) return true;
        if (head.next==null) return true;
        ListNode p=head,q=head;
        while (q!=null && q.next!=null && q.next.next!=null){
            p=p.next;
            q=q.next.next;
        }
        
        ListNode rehead=reverse(p.next);
        ListNode r=head;
        while (rehead!=null){
            // System.out.print(p.val+","+rehead.val);
            if (r.val!=rehead.val){
                return false;
            }
            r=r.next;
            rehead=rehead.next;
        }
        return true;
    }
}
