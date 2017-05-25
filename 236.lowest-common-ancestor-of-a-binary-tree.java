
/*
 * [236] Lowest Common Ancestor of a Binary Tree
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
 *
 * Medium (29.63%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2]\nnode with value 1\nnode with value 2'
 *
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given
 * nodes in the tree.
 * 
 * 
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes v and w as the lowest node in T that has both v
 * and w as descendants (where we allow a node to be a descendant of
 * itself).”
 * 
 * 
 * 
 * ⁠       _______3______
 * ⁠      /              \
 * ⁠   ___5__          ___1__
 * ⁠  /      \        /      \
 * ⁠  6      _2       0       8
 * ⁠        /  \
 * ⁠        7   4
 * 
 * 
 * 
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another
 * example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of
 * itself according to the LCA definition.
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
    private LinkedList<TreeNode> pList = new LinkedList<>();
    private LinkedList<TreeNode> qList = new LinkedList<>();

    public TreeNode getIntersectionNode(LinkedList<TreeNode> headA, LinkedList<TreeNode> headB) {
        int lenA=headA.size();
        int lenB=headB.size();
        int dif=Math.abs(lenA-lenB);
        if (lenA>lenB){
            for (int i=0;i<dif;++i){
                headA.pollLast();
            }
        }
        if (lenB>lenA){
            for (int j=0;j<dif;++j){
                headB.pollLast();
            }
        }
        while (headA.size()>0){
            if (headA.peekLast()==headB.peekLast()){
                return headA.pollLast();
            }
            headA.pollLast();
            headB.pollLast();
        }
        return null;
    }

    public boolean find(TreeNode root, TreeNode p, LinkedList<TreeNode> li) {
        if (root == p) {
            li.add(root);
            return true;
        }
        li.add(root);
        boolean found = false;
        if (root.left != null) {
            found = find(root.left, p, li);
        }
        if (!found && root.right != null) {
            found = find(root.right, p, li);
        }
        if (!found) {
            li.pollLast();
        }
        return found;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean pb = find(root, p, pList);
        boolean qb = find(root, q, qList);
        // System.out.println(pList.toString());
        // System.out.println(qList.toString());
        return getIntersectionNode(pList, qList);
        
        

    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
           return null;
           
         if (root == p || root == q){
            return root;
         }
            
         TreeNode left = lowestCommonAncestor(root.left, p, q);
         TreeNode right = lowestCommonAncestor(root.right, p, q);
         
         if (left != null && right != null){
             return root;
         }
         
         if( left != null)
             return left;
          else 
            return right;
        
    }
}
