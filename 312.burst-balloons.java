/*
* [312] Burst Balloons
*
* https://leetcode.com/problems/burst-balloons
*
* Hard (42.25%)
* Total Accepted:    
* Total Submissions: 
* Testcase Example:  '[3,1,5,8]'
*
* Can you solve this problem? 🤔
*/
public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        int[] numsEx = new int[n + 2];
        numsEx[0] = 1;
        numsEx[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            numsEx[i] = nums[i - 1];
        }
        n=n+2;
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k) {
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i) {
                    dp[left][right] = Math.max(dp[left][right],
                            numsEx[left] * numsEx[i] * numsEx[right] + dp[left][i] + dp[i][right]);
                }
                // System.out.println(dp[left][right]);
            }
        }
        return dp[0][n - 1];
    }
}
