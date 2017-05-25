/*
 * [231] Power of Two
 *
 * https://leetcode.com/problems/power-of-two
 *
 * Easy (39.82%)
 * Total Accepted:    131769
 * Total Submissions: 330920
 * Testcase Example:  '1'
 *
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n==0) return false;
        if (n==1) return true;
        while (n%2==0){
            n/=2;
        }
        if (n==1) return true;
        else return false;
    }
}
