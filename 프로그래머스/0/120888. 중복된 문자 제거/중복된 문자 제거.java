import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        //      문자열을 문자열 리스트로 만든다.
        List<String> strings = List.of(my_string.split(""));

        //      문자열을 순서 집합으로 만든다.
        LinkedHashSet<String> answer = new LinkedHashSet<>(strings);
        for (String str : answer) {
            sb.append(str);
        }
        return sb.toString();
    }
}