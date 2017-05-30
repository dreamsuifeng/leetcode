import java.util.LinkedList;

/*
 * [273] Integer to English Words
 *
 * https://leetcode.com/problems/integer-to-english-words
 *
 * Hard (21.73%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '123'
 *
 * 
 * Convert a non-negative integer to its english words representation. Given
 * input is guaranteed to be less than 231 - 1.
 * 
 * 
 * For example,
 * 
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty
 * Seven"
 */
// ten hundred thousand Million billion
public class Solution {
    String[] mapdigit=new String[]{"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] mapTen=new String[]{"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] maplevel=new String[]{"Thousand","Million","Billion"};
    public String numberToWords(int num) {
        if (num==0) return "Zero";
        int i=0;
        String numStr=String.valueOf(num);
        int n=numStr.length();
        int j=n-1;
        LinkedList<String> stb=new LinkedList<>();
        while(num!=0){
            
            int a=0,b=0,c=0;
            a=num%10;
            num/=10;
            b=num%10;
            num/=10;
            c=num%10;
            num/=10;
            if (i>0 && (a>0 ||b>0 ||c>0)) stb.addFirst(maplevel[i-1]);
             if (b<2){
                 int index=b*10+a;
                 if (index>0){
                     stb.addFirst(mapdigit[index-1]);
                 }
                 if (c>0){
                     
                     
                     
                    stb.addFirst("Hundred");
                    stb.addFirst(mapdigit[c-1]);
                     
                 }
             }else{
                 
                if (a>0)  stb.addFirst(mapdigit[a-1]);
                if (b>0){
                    stb.addFirst(mapTen[b-2]);
                   
                }
                if (c>0){
                    
                        stb.addFirst("Hundred");
                        stb.addFirst(mapdigit[c-1]);
                    
                }
             }
             i++;
             
             
        }
        
        StringBuffer res=new StringBuffer();
        while(!stb.isEmpty()){
            res.append(stb.pollFirst());
            if (stb.isEmpty()) return res.toString();
            res.append(" ");

        }
        return res.toString();
        }
}
