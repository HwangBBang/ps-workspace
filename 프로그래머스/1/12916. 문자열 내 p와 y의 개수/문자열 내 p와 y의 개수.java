import java.util.*;

class Solution {
    boolean solution(String s) {
        

        String[] splited = s.split("");
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String each : splited){
            each = each.toUpperCase();
            map.put(each, map.getOrDefault(each,0) + 1);
        }
        
        int pCount = map.getOrDefault("P", 0);
        int yCount = map.getOrDefault("Y", 0);
        
        
        return pCount == yCount;
    }
}