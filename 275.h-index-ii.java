/*
 * [275] H-Index II
 *
 * https://leetcode.com/problems/h-index-ii
 *
 * Medium (33.98%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * 
 * Follow up for H-Index: What if the citations array is sorted in ascending
 * order? Could you optimize your algorithm?
 * 
 */
public class Solution {
    public int hIndex(int[] citations) {
        int left = 0, len = citations.length, right = len - 1, mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (citations[mid] == (len - mid))
                return citations[mid];
            else if (citations[mid] > (len - mid))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return len - (right + 1);
    }
}
