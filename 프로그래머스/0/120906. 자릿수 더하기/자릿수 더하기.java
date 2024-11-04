import java.util.*;

class Solution {
    public int solution(int n) {
        
        String[] split = String.valueOf(n).split("");
        int answer = Arrays.stream(split).mapToInt(Integer::parseInt).sum();
        return answer;
    
        
    }
}