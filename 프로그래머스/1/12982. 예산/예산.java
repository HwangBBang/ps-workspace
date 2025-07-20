import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int each : d){
            if (budget < each) break;            
            answer ++;
            budget -= each;
        }
        
        return answer;
    }
}

/*
    예산 : budget
    
*/