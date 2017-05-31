import java.util.HashMap;
import java.util.Map;
/*
 * [290] Word Pattern
 *
 * https://leetcode.com/problems/word-pattern
 *
 * Easy (32.71%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 * ⁠Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Examples:
 * 
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * 
 * 
 * 
 * 
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains
 * lowercase letters separated by a single space.
 * 
 * 
 * Credits:Special thanks to @minglotus6 for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern==null || str==null) return false;
        String[] charStr=str.split(" ");
        char[] patchar=pattern.toCharArray();
        if (charStr.length!=patchar.length) return false;
        Map<Character,String> map=new HashMap<>();
        Map<String,Character> mapreverse=new HashMap<>();
        for(int i=0;i<patchar.length;++i){
            if (map.containsKey(patchar[i])){
                if  (!charStr[i].equals(map.get(patchar[i]))) return false;
            }else{
                map.put(patchar[i],charStr[i]);
            }
            if (mapreverse.containsKey(charStr[i])){
                if (patchar[i]!=mapreverse.get(charStr[i])) return false;
            }else{
                mapreverse.put(charStr[i], patchar[i]);
            }
        }
        return true; 
    }
}
