/*
 * [238] Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self
 *
 * Medium (48.40%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0,0]'
 *
 * 
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array
 * does not count as extra space for the purpose of space complexity analysis.)
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int pro=1;
        int zerocount=0;
        int zeroindex=-1;
        for (int j=0;j<n;++j){
            if (nums[j]!=0) pro*=nums[j];
            else {
                zerocount++;
                zeroindex=j;
            }
        }
        if (zerocount>1) return res;
        
        if (zeroindex!=-1) {
        res[zeroindex]=pro;
        return res;
        }else{
            for (int i=0;i<n;++i){
                if(i!=zeroindex){
                res[i]=pro/nums[i];
                }
            }
            return res;
        }
    }
}
