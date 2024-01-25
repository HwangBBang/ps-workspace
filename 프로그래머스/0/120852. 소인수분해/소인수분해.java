import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList <Integer> answer = new ArrayList<>();
        
        for (int i = 2; i <= n; i++){
            if (n<i) break;

            if(n%i == 0){
                answer.add(i);
                while(n%i==0){
                    n /= i;
                }
            }
        
        }
        
       int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}