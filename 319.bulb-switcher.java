/*
 * [319] Bulb Switcher
 *
 * https://leetcode.com/problems/bulb-switcher
 *
 * Medium (42.24%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int bulbSwitch(int n) {
        int sum=0;
        for (int i=1;i<=Math.sqrt(n);++i){
            if (Math.pow(i,2)<=n) sum++;
        }
        return sum;
    }
}
