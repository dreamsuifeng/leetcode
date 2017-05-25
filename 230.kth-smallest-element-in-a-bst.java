
/*
 * [230] Kth Smallest Element in a BST
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst
 *
 * Medium (43.17%)
 * Total Accepted:    95324
 * Total Submissions: 220807
 * Testcase Example:  '[1]\n1'
 *
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: 
 * You may assume k is always valid, 1 ? k ? BST's total elements.
 * 
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to
 * find the kth smallest frequently? How would you optimize the kthSmallest
 * routine?
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test
 * cases.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNum(TreeNode root){
        if(root==null) return 0;
        int left=countNum(root.left);
        int right=countNum(root.right);
        return left+right+1;
    }
    public int kthSmallest(TreeNode root, int k) {
        // if (root==null) return
        // System.out.println(k);
        int left=countNum(root.left);
        // System.out.println(left);
        if (left==k-1) return root.val;
        if (left>=0 && left<k-1) return kthSmallest(root.right, k-left-1);
        else return kthSmallest(root.left, k);
    }
}
