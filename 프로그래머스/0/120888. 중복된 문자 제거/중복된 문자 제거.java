import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        //      문자열을 문자열 리스트로 만든다.
        List<String> strings = List.of(my_string.split(""));

        //      문자열을 순서 집합으로 만든다.
        LinkedHashSet<String> stringSet = new LinkedHashSet<>(strings);
        
        String answer = String.join("",stringSet);
        return answer;
    }
}