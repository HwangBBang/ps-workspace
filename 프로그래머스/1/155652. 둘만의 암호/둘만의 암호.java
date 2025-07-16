import java.util.*;

class Solution {
    public static List<String> charSet;
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        String[] chars = s.split("");
        
        charSet = new ArrayList<>();
        
        for (int i = 'a'; i <= 'z'; i ++){
            char c = (char) i;
            if (skip.contains(String.valueOf(c))) continue;
            charSet.add(String.valueOf(c));
        }
            
        for (String elem : chars){
            answer.append(changed(elem, index));
        }
    
        return answer.toString();
    }
    
    protected static String changed(String pivot, int idx){
        int pivotIdx = charSet.indexOf(pivot);
        int newIdx = (pivotIdx + idx) % charSet.size();
        return charSet.get(newIdx);
    }
    
}


/*
s의 알파벳을 idx 만큼 뒤의 알파벳으로 
*/