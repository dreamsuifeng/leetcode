/*
 * [239] Sliding Window Maximum
 *
 * https://leetcode.com/problems/sliding-window-maximum
 *
 * Hard (32.41%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]\n0'
 *
 * Given an array nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one
 * position.
 * 
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * 
 * Note: 
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for
 * non-empty array.
 * 
 * Follow up:
 * Could you solve it in linear time?
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k==0 ||nums.length==0) return new int[0];
        int len=nums.length-k+1;
        int[] res=new int[len];
        if (len<=0) return res;
        // System.out.println(res.length);
        for(int i=k-1;i<nums.length;++i){
            int max=Integer.MIN_VALUE;
            for (int j=i;j>i-k;--j){
                max=nums[j]>max ? nums[j]:max;
            }
            res[i-k+1]=max;
        }
        return res;
    }
    // public static void main(String[] args){
    //     int[] test=new int[]{1,3,-1,-3,5,3,6,7};
    //     int[] res=maxSlidingWindow(test, 3);
    //     for (Integer i: res){
    //         System.out.print(i+",");
    //     }
    // }
}
