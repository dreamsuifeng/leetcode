/*
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes
 *
 * Easy (49.23%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * 
 * 
 * For example, given nums  = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].
 * 
 * 
 * 
 * Note:
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length==1 || nums.length==0){
            return;
        }
        int index=-1;
        for (int i=0;i<nums.length;++i){
            if (index==-1 && nums[i]==0){
                index=i;
            }else if (nums[i]!=0 && index!=-1){
                nums[index]=nums[i];
                nums[i]=0;
                index= nums[index+1]==0 ? index+1:i;

            }
        }
    }
}
