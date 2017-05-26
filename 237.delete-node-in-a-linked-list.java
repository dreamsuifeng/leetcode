/*
 * [237] Delete Node in a Linked List
 *
 * https://leetcode.com/problems/delete-node-in-a-linked-list
 *
 * Easy (46.04%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0,1]\nnode at index 0 (node.val = 0)'
 *
 * 
 * Write a function to delete a node (except the tail) in a singly linked list,
 * given only access to that node.
 * 
 * 
 * 
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third
 * node with value 3, the linked list should become 1 -> 2 -> 4 after calling
 * your function.
 * 
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
    public void deleteNode(ListNode node) {
        ListNode p=node;
        p=p.next;
        while(p!=null){
            node.val=p.val;
            p=p.next;
            if (p!=null) node=node.next;
            
        }
        node.next=null;
        
        

    }
}
