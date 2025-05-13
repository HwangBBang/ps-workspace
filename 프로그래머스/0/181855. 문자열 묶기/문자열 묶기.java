import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (String str : strArr){
            int len = str.length();
            map.put(len, map.getOrDefault(len,0)+1);
        }
        
        int answer = 0;
        
        for (Integer elem : map.values()){
            answer = Math.max(answer, elem);
        }
        
        return answer;
    }
}