import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < numbers.length; i++){
            for (int j = i + 1; j < numbers.length; j++){
                
                int sum = numbers[i] + numbers[j];
                if(!result.contains(sum)) result.add(sum);
            }    
        }
        
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i ++){
            answer[i] = result.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
}