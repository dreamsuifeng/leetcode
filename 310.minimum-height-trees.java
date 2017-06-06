import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * [310] Minimum Height Trees
 *
 * https://leetcode.com/problems/minimum-height-trees
 *
 * Medium (28.68%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '4\n[[1,0],[1,2],[1,3]]'
 *
 * 
 * ⁠   For a undirected graph with tree characteristics, we can choose any node
 * as the root. The result graph is then a rooted tree. Among all possible
 * rooted trees, those with minimum height are called minimum height trees
 * (MHTs).
 * ⁠   Given such a graph, write a function to find all the MHTs and return a
 * list of their root labels.
 * 
 * 
 * 
 * ⁠   Format
 * ⁠   The graph contains n nodes which are labeled from 0 to n - 1.
 * ⁠   You will be given the number n and a list of undirected edges (each edge
 * is a pair of labels).
 * 
 * ⁠
 * You can assume that no duplicate edges will appear in edges. Since all edges
 * are
 * ⁠   undirected, [0, 1] is the same as [1, 0] and thus will not appear
 * together in
 * ⁠   edges.
 * 
 * 
 * ⁠   Example 1:
 * 
 * 
 * ⁠   Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * 
 * 
 * 
 * ⁠       0
 * ⁠       |
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * 
 * 
 * ⁠   return  [1]
 * 
 * 
 * 
 * ⁠   Example 2:
 * 
 * 
 * ⁠   Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * 
 * 
 * ⁠    0  1  2
 * ⁠     \ | /
 * ⁠       3
 * ⁠       |
 * ⁠       4
 * ⁠       |
 * ⁠       5
 * 
 * 
 * ⁠   return  [3, 4]
 * 
 * 
 * 
 * ⁠   Note:
 * 
 * 
 * ⁠   (1) According to the definition
 * ⁠   of tree on Wikipedia: “a tree is an undirected graph in which any two
 * vertices are connected by
 * ⁠   exactly one path. In other words, any connected graph without simple
 * cycles is a tree.”
 * 
 * 
 * ⁠   (2) The height of a rooted tree is the number of edges on the longest
 * downward path between the root and a
 * ⁠   leaf.
 * 
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
public class Solution {
     List<Integer>[] e;
     int n;
    public void bfs(int start, int[] dist, int[] pre){
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        dist[start] = 0;
        visited[start] = true;
        pre[start] = -1;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : e[u])
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    queue.add(v);
                    pre[v] = u;
                }
        
        }
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        this.n=n;
        List<Integer> res=new ArrayList<>();
        if (n==0){
            return res;
        }
        if (edges==null || edges.length==0){
            for (int i=0;i<n;++i){
                res.add(i);
            }
            return res;
        }
        e = new List[n];
        for (int i = 0; i < n; i++)
            e[i] = new ArrayList<>();
        for (int[] pair : edges) {
            int u = pair[0];
            int v = pair[1];
            e[u].add(v);
            e[v].add(u);
        }
        int[] d1 = new int[n];
        int[] d2 = new int[n];
        int[] pre = new int[n];
        bfs(0, d1, pre);
        int u = 0;
        for (int i = 0; i < n; i++)
            if (d1[i] > d1[u]) u = i;

        bfs(u, d2, pre);
        int v = 0;
        for (int i = 0; i < n; i++)
            if (d2[i] > d2[v]) v = i;
        List<Integer> list = new ArrayList<>();
        while (v != -1) {
            list.add(v);
            v = pre[v];
        }

        if (list.size() % 2 == 1) return Arrays.asList(list.get(list.size() / 2));
        else return Arrays.asList(list.get(list.size() / 2 - 1), list.get(list.size() / 2));
    }
}