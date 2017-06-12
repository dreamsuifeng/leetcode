import java.util.ArrayList;
import java.util.List;

/*
 * [324] Wiggle Sort II
 *
 * https://leetcode.com/problems/wiggle-sort-ii
 *
 * Medium (25.70%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,5,1,1,6,4]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findKthLargest(int[] nums, int start, int end, int k) {// quick select: kth smallest
	    int lb=start, hb=end;
	    int pVal = nums[lb]; // use random genarater is better in performance
        int i = lb;
        while(i<=hb) {
            if(nums[i]==pVal)
                i++;
            else if(nums[i]<pVal)
                swap(nums,i++,lb++);
            else
                swap(nums,i,hb--);
        }
 
	
    	if(k-1<lb)
            return findKthLargest(nums,start,lb-1,k);
        else if (k-1>hb)
            return findKthLargest(nums,hb+1,end,k);
        else
            return k-1;
        } 
        
        private void swap(int[] nums, int i, int j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        public void wiggleSort(int[] nums) {
            int meindex=(nums.length+1)/2;
            int median=findKthLargest(nums, 0, nums.length-1, meindex);
            // for (Integer i:nums) {
            //     System.out.print(i+",");
            // }
            List<Integer> leftArr=new ArrayList<>();
            for (int i=0;i<meindex;i++){
                leftArr.add(nums[i]);
            }
            List<Integer> rigthArr=new ArrayList<>();
            for (int j=meindex;j<nums.length;++j){
                rigthArr.add(nums[j]);
            }
            for (int li=leftArr.size()-1, ri=rigthArr.size()-1, i=0;ri>=0;li--, ri--, i+=2){
                nums[i]=leftArr.get(li);
                nums[i+1]=rigthArr.get(ri);
            }
            if(nums.length%2!=0){
                nums[nums.length-1]=leftArr.get(0);
            }
        }
}