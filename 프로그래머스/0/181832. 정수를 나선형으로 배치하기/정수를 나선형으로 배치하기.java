import java.util.*;
import java.io.*;


class Solution {
    static boolean isContinue(int n, int nextX, int nextY, int[][] answer) {
                if (nextX < 0 || n <= nextX) return false;
                if (nextY < 0 || n <= nextY) return false;
                if (answer[nextY][nextX] != 0) return false;
                return true;
            }
    
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        // 우측 , 아래 , 좌측 , 위
        int [] dx = {1,0,-1,0};
        int [] dy = {0,1,0,-1};
        
        int cnt = 1;
        
        int x = 0,y = 0;
        int directIndex = 0;
        
        while (cnt <= n * n){
            answer[y][x] = cnt;
            cnt ++;
            int nextX = x + dx[directIndex % 4];
            int nextY = y + dy[directIndex % 4];
            
            if (!isContinue(n, nextX, nextY, answer)) directIndex++;
                    
            y = y + dy[directIndex % 4];
            x = x + dx[directIndex % 4];
            
        }
        return answer;
    }
}