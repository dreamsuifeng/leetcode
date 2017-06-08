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
    public String removeDuplicateLetters(String s) {
        if (s==null || s.length()==0) return "";
        PriorityQueue<Character> priQue=new PriorityQueue<>();
        Set<Character> set=new HashSet<>();
        char[] scha=s.toCharArray();
        for (Character c:scha){
            if (set.contains(c)){
                continue;
            }else{
                set.add(c);
                priQue.add(c);
            }
        }
        StringBuffer sb=new StringBuffer();
        int n=priQue.size();
        for (int i=0;i<n;++i){
            sb.append(priQue.poll());
        }
        return sb.toString();
    }
}
