public class Solution {
    public int hIndex(int[] citations) {
        int maxH=0;
        Arrays.sort(citations);
        int n=citations.length;
        for (int i=0;i<n;i++){
            int currH=Math.min(citations[i],n-i);
            if (currH>maxH) maxH=currH;
        }
        return maxH;
    }
}