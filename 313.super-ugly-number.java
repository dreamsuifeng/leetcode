import java.util.Iterator;
import java.util.PriorityQueue;

/*
 * [313] Super Ugly Number
 *
 * https://leetcode.com/problems/super-ugly-number
 *
 * Medium (37.36%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1\n[2,3,5]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min)
                factor2 = 2 * ugly[++index2];
            if (factor3 == min)
                factor3 = 3 * ugly[++index3];
            if (factor5 == min)
                factor5 = 5 * ugly[++index5];
        }
        return ugly[n - 1];
    }

    //define a node Structure
    private class node {
        int index;
        int value;

        node(int i, int j) {
            index = i;
            value = j;
        }
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] index = new int[primes.length];
        PriorityQueue<node> quene = new PriorityQueue<>(new Comparator<node>() {
            public int compare(node one, node two) {
                return one.value - two.value;
            }
        });
        ugly[0] = 1;
        for (int i = 0; i < primes.length; ++i) {
            quene.add(new node(i, primes[i]));
        }
        for (int j = 1; j < n; ++j) {
            node min = quene.peek();
            // System.out.println(min.value);
            ugly[j] = min.value;
            Object[] nodeArray = quene.toArray();
            for (int i = 0; i < nodeArray.length; ++i) {
                node tmp = (node) nodeArray[i];
                if (tmp.value == min.value) {
                    quene.remove(tmp);
                    index[tmp.index]++;
                    int factor = primes[tmp.index] * ugly[index[tmp.index]];
                    quene.add(new node(tmp.index, factor));
                }
            }

        }
        return ugly[n - 1];
    }
}
