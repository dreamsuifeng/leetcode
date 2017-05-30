/*
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares
 *
 * Medium (36.13%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1'
 *
 * 
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * 
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
public class Solution {
    private int len=0;
    public boolean isSquare(int n){
        int sq=(int) Math.sqrt(n);
        return (sq*sq==n);
    }

    public int numSquares(int n) {
        if (isSquare(n)) return 1;
        while ( (n & 3) ==0){
            n>>=2;
        }
        if ((n&7)==7) return 4;
        int sq=(int) Math.sqrt(n);
        for (int i=1;i<=sq;++i){
            if(isSquare(n-i*i)){
                return 2;
            }
        }
        return 3;
    }
}
