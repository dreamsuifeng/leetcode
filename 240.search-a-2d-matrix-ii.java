import com.sun.org.apache.bcel.internal.generic.FASTORE;

/*
 * [240] Search a 2D Matrix II
 *
 * https://leetcode.com/problems/search-a-2d-matrix-ii
 *
 * Medium (38.21%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n5'
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * 
 * 
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * 
 * 
 * 
 * 
 * For example,
 * 
 * Consider the following matrix:
 * 
 * 
 * [
 * ⁠ [1,   4,  7, 11, 15],
 * ⁠ [2,   5,  8, 12, 19],
 * ⁠ [3,   6,  9, 16, 22],
 * ⁠ [10, 13, 14, 17, 24],
 * ⁠ [18, 21, 23, 26, 30]
 * ]
 * 
 * 
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class Solution {
    public boolean searchRow(int[] rows, int target,int left, int right){
        if (left>right){
            return false;
        }
        int mid = (left+right)/2;
        if (rows[mid]==target) return true;
        if (target>rows[mid]){
            return searchRow(rows, target, mid+1, right);
        }else{
            return searchRow(rows, target, left, mid-1);
        }
        
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        if (m==0) return false;
        int n=matrix[0].length;
        if (n==0) return false;
        int mindex=-1;
        for (int i=0;i<m;++i){
            if (target>=matrix[i][0] && target<=matrix[i][n-1]){
                if (searchRow(matrix[i], target, 0, n)) return true;
                else continue;
            }
        }
        return false;
    }
}
