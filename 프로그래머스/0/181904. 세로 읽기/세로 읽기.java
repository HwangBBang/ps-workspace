import java.util.*;

class Solution {
    public String solution(String my_string, int m, int c) {
        char[] my_char = my_string.toCharArray();
        int n = my_char.length / m;
        char[][] grid = new char[n][m];
        
        
        
        int r = -1;
        for (int i = 0 ;i < n; i++){
            for (int ii = 0 ;ii < m; ii++){
                grid[i][ii] = my_char[i*m + ii];
            }  
        }
        
        String answer = "";
        
        for (int i = 0 ;i < n; i++){
            answer += grid[i][c-1];
        }
        
        
        return answer;
    }
}