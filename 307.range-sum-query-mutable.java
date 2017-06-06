/*
 * [307] Range Sum Query - Mutable
 *
 * https://leetcode.com/problems/range-sum-query-mutable
 *
 * Medium (19.85%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["NumArray","sumRange","update","sumRange"]\n[[[1,3,5]],[0,2],[1,2],[0,2]]'
 *
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * The update(i, val) function modifies nums by updating the element at index i
 * to val.
 * 
 * Example:
 * 
 * Given nums = [1, 3, 5]
 * 
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 
 * 
 * 
 * Note:
 * 
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is
 * distributed evenly.
 * 
 * 
 */
public class NumArray {
    private class segmentTree{
        int start;
        int end;
        int sum;
        segmentTree left,right;
        public segmentTree(int start,int end){
            this.start=start;
            this.end=end;
            this.left=null;
            this.right=null;
            this.sum=0;
        }
    
    }
    private segmentTree root;
    private segmentTree buildTree(int[] nums, int start, int end){
        if (start>end) return null;
        else{
            segmentTree root=new segmentTree(start, end);
            if (start==end){
                root.sum=nums[start];
            }else{
                int mid=start+(end-start)/2;
                root.left=buildTree(nums, start, mid);
                root.right=buildTree(nums, mid+1, end);
                root.sum=root.left.sum+root.right.sum;

            }
            return root;
        }
    }
    public NumArray(int[] nums) {
        root=buildTree(nums, 0, nums.length-1);
    }
    
    public void update(int i, int val) {
        update(root, i, val);
    }
    private void update(segmentTree root, int i, int val){
        if (root.start==root.end){
            root.sum=val;
        }else{
            int mid=root.start+(root.end-root.start)/2;
            if (i<=mid){
                update(root.left, i, val);
            }else{
                update(root.right, i, val);
            }
            root.sum=root.left.sum+root.right.sum;
        }
    }
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    private int sumRange(segmentTree root, int i, int j){
        if (root.start==i && root.end==j){
            return root.sum;
        }else{
            int mid= root.start+(root.end-root.start)/2;
            if (j<=mid){
                return sumRange(root.left,i, j);
            }else if (i>=mid+1){
                return sumRange(root.right, i, j);
            }else{
                return sumRange(root.right, mid+1, j) + sumRange(root.left, i, mid);
            }
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
