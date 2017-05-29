/*
 * [268] Missing Number
 *
 * https://leetcode.com/problems/missing-number
 *
 * Easy (44.05%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0]'
 *
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * 
 * 
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * 
 * 
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant extra space complexity?
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
public class Solution {
    public int missingNumber(int[] nums) {
        for (int i=0;i<nums.length;++i){
            if (nums[i]==i) continue;
            while (nums[i]!=i){
                if (nums[i] >= nums.length) break;
                int temp=nums[nums[i]];
                nums[nums[i]]=nums[i];
                nums[i]=temp;
            }
            
        }
        for (int j=0;j<nums.length;++j){
            if (nums[j]!=j){
                return j;
            }
        }
        return nums.length;
    }
}
