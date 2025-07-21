import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int [s.length()];
        String[] splited = s.split("");
        Map<String, Integer> map = new HashMap<>();
        
        for (int currentIdx = 0; currentIdx < splited.length; currentIdx ++){
            
            String current = splited[currentIdx];
            
            if(!map.containsKey(current)){
                map.put(current, currentIdx);
                answer[currentIdx] = -1;
                continue;
            }
            
            answer[currentIdx] = currentIdx - map.get(current);
            map.put(current, currentIdx);
        }
        return answer;
    }
}