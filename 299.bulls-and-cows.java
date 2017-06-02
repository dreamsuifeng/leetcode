import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.print.DocFlavor.CHAR_ARRAY;

import com.sun.javafx.font.CharToGlyphMapper;

/*
 * [299] Bulls and Cows
 *
 * https://leetcode.com/problems/bulls-and-cows
 *
 * Medium (34.16%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"1807"\n"7810"'
 *
 * You are playing the following Bulls and Cows game with your friend: You
 * write down a number and ask your friend to guess what the number is. Each
 * time your friend makes a guess, you provide a hint that indicates how many
 * digits in said guess match your secret number exactly in both digit and
 * position (called "bulls") and how many digits match the secret number but
 * locate in the wrong position (called "cows"). Your friend will use
 * successive guesses and hints to eventually derive the secret number.
 * 
 * 
 * For example:
 * 
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * 
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * 
 * 
 * Write a function to return a hint according to the secret number and
 * friend's guess, use A to indicate the bulls and B to indicate the cows. In
 * the above example, your function should return "1A3B". 
 * 
 * Please note that both secret number and friend's guess may contain duplicate
 * digits, for example:
 * 
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * 
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a
 * cow, and your function should return "1A1B".
 * 
 * 
 * You may assume that the secret number and your friend's guess only contain
 * digits, and their lengths are always equal.
 * 
 * Credits:Special thanks to @jeantimex for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public String getHint(String secret, String guess) {
        ArrayList<Integer> uniqueA=new ArrayList<>();
        Map<Character,Integer> uniqueB=new HashMap<>();
        char[] sc=secret.toCharArray();
        char[] gc=guess.toCharArray();
        int n=guess.length();
        int countA=0;
        int countB=0;
        for (int i=0;i<n;i++){
            if (sc[i]==gc[i]) countA++;
            else {
                uniqueA.add(i);
                if (uniqueB.containsKey(gc[i])){
                    uniqueB.put(gc[i],uniqueB.get(gc[i])+1);
                }else{
                    uniqueB.put(gc[i],1);
                }
            }

        }
        for (int j=0;j<uniqueA.size();j++){
            char tmp=sc[uniqueA.get(j)];
            if (uniqueB.containsKey(tmp)){
                countB++;
                int t=uniqueB.get(tmp);
                if (t>1){
                    uniqueB.put(tmp,t-1);
                }else{
                    uniqueB.remove(tmp);
                }
            }
        }
        return String.valueOf(countA)+"A"+String.valueOf(countB)+"B";
    }
}
