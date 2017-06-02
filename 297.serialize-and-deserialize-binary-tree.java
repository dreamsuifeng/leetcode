import java.util.Queue;

/*
 * [297] Serialize and Deserialize Binary Tree
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree
 *
 * Hard (32.80%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment. 
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * 
 * For example, you may serialize the following tree
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠    / \
 * ⁠   4   5
 * 
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a
 * binary tree. You do not necessarily need to follow this format, so please be
 * creative and come up with different approaches yourself.
 * 
 * 
 * 
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be .
 * 
 * 
 * Credits:Special thanks to @Louis1992 for adding this problem and creating
 * all test cases.
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer res=new StringBuffer();
        if(root==null) return "()";
        res.append("("+root.val);
        
        String left=serialize(root.left);
        String right=serialize(root.right);
        res.append(left+right);
        res.append(")");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // System.out.println(data);
        if (data.equals("()")) return null;
        
        int n=data.length();
        int val;
        int valIndex=-1, leftIndex=-1;
        int count=0;
        boolean flag=false;
        for (int i=1;i<n;++i){
            if (data.charAt(i)=='(') {
                count++;
                flag=true;
            }
            if (data.charAt(i)==')') count--;
            if (data.charAt(i)=='(' && valIndex==-1) valIndex=i;
            if (count==0 && flag){
                leftIndex=i;
                break;
            }
        }
        TreeNode root=new TreeNode(Integer.parseInt(data.substring(1,valIndex)));
        TreeNode left=deserialize(data.substring(valIndex,leftIndex+1));
        TreeNode right=deserialize(data.substring(leftIndex+1,n-1));
        root.left=left;
        root.right=right;
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
