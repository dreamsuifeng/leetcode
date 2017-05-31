/*
 * [289] Game of Life
 *
 * https://leetcode.com/problems/game-of-life
 *
 * Medium (36.60%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[]]'
 *
 * 
 * According to the Wikipedia's article: "The Game of Life, also known simply
 * as Life, is a cellular automaton devised by the British mathematician John
 * Horton Conway in 1970."
 * 
 * 
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or
 * dead (0). Each cell interacts with its eight neighbors (horizontal,
 * vertical, diagonal) using the following four rules (taken from the above
 * Wikipedia article):
 * 
 * 
 * 
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by
 * under-population.
 * Any live cell with two or three live neighbors lives on to the next
 * generation.
 * Any live cell with more than three live neighbors dies, as if by
 * over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if
 * by reproduction.
 * 
 * 
 * 
 * 
 * Write a function to compute the next state (after one update) of the board
 * given its current state.
 * 
 * 
 * Follow up: 
 * 
 * Could you solve it in-place? Remember that the board needs to be updated at
 * the same time: You cannot update some cells first and then use their updated
 * values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the
 * board is infinite, which would cause problems when the active area
 * encroaches the border of the array. How would you address these problems?
 * 
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        int m= board.length;
        if (m==0) return;
        int n=board[0].length;
        if (n==0) return;
        // int[][] newboard=new int[m][n];
        for (int i=0;i<m;++i){
            for (int j=0;j<n;++j){
                int up = i-1>=0 ? i-1:0;
                int down = i+1<m ? i+1:m-1;
                int left = j-1>=0 ? j-1:0;
                int right = j+1<n ? j+1:n-1;
                int liveCount=0;
                int deadCount=0;
                for (int k=up;k<=down;++k){
                    for (int it=left;it<=right;++it){
                        if (k==i && it ==j) continue;
                        if (board[k][it]==0) deadCount++;
                        else if (board[k][it]==1) liveCount++;
                        else if (board[k][it]==11) deadCount++;
                        else liveCount++;
                    }
                }
                // System.out.println("liveCount is"+liveCount);
                if (board[i][j]==1 && (liveCount<2 || liveCount>3)) board[i][j]=10;
                else if (board[i][j]==0 && liveCount==3) board[i][j]=11;
            }
        }
        for (int i=0;i<m;++i){
            for (int j=0;j<n;++j){
                if (board[i][j]==10) board[i][j]=0;
                if (board[i][j]==11) board[i][j]=1;
            }
        }
    }
}
