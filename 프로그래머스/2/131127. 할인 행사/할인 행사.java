import java.util.*;

class Solution {
    static Map<String, Integer> wishMap;
    static Map<String, Integer> discMap;
    static Set<String> keys;
     
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        wishMap = new HashMap<>();
        discMap = new HashMap<>();
        
        for (int i = 0; i < want.length; i ++){
            wishMap.put(want[i], number[i]);
            discMap.put(want[i], 0);
               
        }
        
        keys = wishMap.keySet();
        
        
        // 10개 먼저 초기화
        for (int i = 0; i < 10; i ++){
            String each = discount[i]; 

            if (!keys.contains(each)) continue;
            discMap.put(each, discMap.get(each) + 1);     
        }
        if (check()) answer ++;
        
        for (int k = 1; k < discount.length - 9; k ++){
            
            String remove = discount[k-1]; // 제거 할 
            if (keys.contains(remove)) {
                discMap.put(remove, discMap.get(remove) - 1);
            }
            String add = discount[k+9]; // 추가 할 
            if (keys.contains(add)) {
                discMap.put(add, discMap.get(add) + 1);
            }
            if (check()) answer ++;

        }
        
    
        return answer;
    }
    
    static boolean check (){
        
        for (String key :keys){
            if (discMap.get(key) < wishMap.get(key))
                return false;
        }
        return true;
    }
    
}

/*
    100_000 개를 선형 순회 O(n) 10 개씩 .. 괜찮을까..? 확신이 없음 
    일단하자. 
    
   
   
   
   
   
   -"chicken", 
    "apple", 
    "apple", 
    "banana", 
    "rice", 
    "apple", 
    "pork", 
    "banana", 
    "pork", 
    -"rice", 
    "pot", 
    "banana", 
    "apple", 
    "banana"
    
    ]
*/