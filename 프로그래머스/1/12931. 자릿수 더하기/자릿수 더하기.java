import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String[] ss = String.valueOf(n).split("");
        
        for(String s : ss){
            answer += Integer.parseInt(s);
        }
        
        

        return answer;
    }
}