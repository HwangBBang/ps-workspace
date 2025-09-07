import java.util.*;

class Solution {
    private static Map<Integer, Integer> map;
    
    public long solution(int[] weights) {
        long result = 0;
        
        map = new HashMap<>();
        
        for (int weight : weights){
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }
        
        Set<Integer> keys = map.keySet(); 
        
        for (int key: keys){
            int keyCount = map.get(key);
            if (keyCount >= 2){
                result += ((long)keyCount * (keyCount-1))/2;
            }
        }
        
        for (int k1: keys){
            for (int k2: keys){
                if(k1 >= k2) continue ;
                if (isPairWithOther(k1,k2)){
                    result += (long)map.get(k1) * (long)map.get(k2);
                }
            }
        }

        /*
        1 : 1
        1 : 2
        2 : 3
        3 : 4 
        */
        return result;
    }
    
    static private boolean isPairWithOther(int a, int b){
        if(a*1 ==  b*2 || a*2 ==  b*1) return true;
        if(a*2 ==  b*3 || a*3 ==  b*2) return true;
        if(a*3 ==  b*4 || a*4 ==  b*3) return true;
        return false;
    }
    
    static private boolean isPairWithSame(int a){
        if(map.get(a) >= 2) return true;
        return false;
    }
}

/* 

*/