/*
 * [257] Binary Tree Paths
 *
 * https://leetcode.com/problems/binary-tree-paths
 *
 * Easy (37.24%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * 
 * For example, given the following binary tree:
 * 
 * 
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * 
 * 
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
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
    private List<String> res=new LinkedList<>();
    private String toSpeString(LinkedList<String> t){
        if (t == null)  
            return "";  
        int iMax = t.size() - 1;  
        if (iMax == -1)  
            return "";  
        StringBuilder b = new StringBuilder();   
        for (int i = 0; ; i++) {  
            b.append(t.get(i));  
            if (i == iMax)  return b.toString();  
            b.append("->");  
        }
    }  
    public void search(TreeNode root, LinkedList<String> buffer){
        if (root==null){
            return;
        }
        buffer.add(String.valueOf(root.val));
        if (root.left==null && root.right==null){
            
            res.add(toSpeString(buffer));
            buffer.pollLast();
            return;
        }
        
        search(root.left, buffer);
        search(root.right, buffer);
        buffer.pollLast();
    }
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> buffer=new LinkedList<>();
        search(root, buffer);
        return res;
    }
}