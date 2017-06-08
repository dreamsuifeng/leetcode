/*
 * [318] Maximum Product of Word Lengths
 *
 * https://leetcode.com/problems/maximum-product-of-word-lengths
 *
 * Medium (43.59%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["abcw","baz","foo","bar","xtfn","abcdef"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maxProduct(String[] words) {
        int max=0;
        Arrays.sort(words,new Comparator<String>(){
            public int compare(String a, String b){
                return b.length()-a.length();
            }
        });
        int[] marks=new int[words.length];
        for (int i=0;i<words.length;++i){
            char[] array=words[i].toCharArray();
            for (int j=0;j<array.length;++j){
                marks[i] |=1<<(array[j]-'a');
            }
                
        }
        for (int i=0;i<marks.length;i++){
            if(words[i].length()*words[i].length()<=max) break;
            for (int j=i+1;j<marks.length;++j){
                if ((marks[j]&marks[i])==0){
                    max=Math.max(max,words[i].length()*words[j].length());
                    break;
                }
            }
        }
        return max;
    }
    
    }

