import java.util.*;

class Solution {
    public String solution(int age) {
        
        HashMap mapped = new HashMap<>();
        mapped.put("0", "a");
        mapped.put("1", "b");
        mapped.put("2", "c");
        mapped.put("3", "d");
        mapped.put("4", "e");
        mapped.put("5", "f");
        mapped.put("6", "g");
        mapped.put("7", "h");
        mapped.put("8", "i");
        mapped.put("9", "j");
        
        StringBuilder sb = new StringBuilder();
        
        String[] parsed = String.valueOf(age).split("");
        for(String s : parsed){
            sb.append(mapped.get(s));
        }
        
        return sb.toString();
    }
}

//  a는 0, b는 1, c는 2, ..., j는 9입니다