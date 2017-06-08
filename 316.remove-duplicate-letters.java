import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * [316] Remove Duplicate Letters
 *
 * https://leetcode.com/problems/remove-duplicate-letters
 *
 * Hard (29.13%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"bcabc"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    private int findMIn(HashMap<Character, Integer> lastIndexMap){
        if(lastIndexMap==null || lastIndexMap.isEmpty()) return -1;
        int minlastIndex=Integer.MAX_VALUE;
        for(int lastPos:lastIndexMap.values()){
            minlastIndex=Math.min(minlastIndex,lastPos);
        }
        return minlastIndex;
    }
        public String removeDuplicateLetters(String s) {
        if (s==null || s.length()==0) return s;
        char[] schar=s.toCharArray();
        HashMap<Character,Integer> lastIndexMap=new HashMap<>();
        for (int i=0;i<schar.length;++i){
            lastIndexMap.put(schar[i],i);
        }
        StringBuffer sb=new StringBuffer();
        int n=lastIndexMap.size();
        int begin=0,end=findMIn(lastIndexMap);
        for(int i=0;i<n;++i){
            char minchar='z'+1;
            for(int k=begin;k<=end;++k){
                if (lastIndexMap.containsKey(schar[k]) && schar[k]<minchar){
                    minchar=schar[k];
                    begin=k+1;
                }
            }
            sb.append(minchar);
            if (i==n-1) break;
            lastIndexMap.remove(minchar);
            if (schar[end]==minchar) end=findMIn(lastIndexMap);
        }
        return sb.toString();
        }
}
