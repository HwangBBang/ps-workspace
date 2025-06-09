import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String s = String.valueOf(n);
        char[] cs = s.toCharArray();
        for(char c : cs){
            answer += c-'0';
        }
        
        

        return answer;
    }
}