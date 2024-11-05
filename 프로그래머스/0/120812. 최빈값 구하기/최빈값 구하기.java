import java.util.stream.*; 
import java.util.*; 


class Solution {
    public int solution(int[] array) {
    
                Map<Integer, Integer> frequencyMap = new HashMap<>();
        int answer = -1;
        for (int num : array){
            frequencyMap.put(num, frequencyMap.getOrDefault(num,0)+1);
        }
        int max = Collections.max(frequencyMap.values());
        
        
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == max) {
                cnt += 1;
                answer = entry.getKey();
            }
        }
        
        boolean isValid = (cnt == 1);

        if (isValid) {
            return answer;
        }
        return -1;
            


        
    }
}