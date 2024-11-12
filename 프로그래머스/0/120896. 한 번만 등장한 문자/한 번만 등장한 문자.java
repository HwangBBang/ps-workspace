import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] split = s.split("");
        Arrays.sort(split);

        LinkedHashMap<String, Integer> frequency = new LinkedHashMap<>();

        for (String string : split) {
            frequency.put(string, frequency.getOrDefault(string,0) + 1);
        }
        
        for (Map.Entry<String, Integer> stringIntegerEntry : frequency.entrySet()) {
            if (stringIntegerEntry.getValue() == 1) {
                answer.append(stringIntegerEntry.getKey());
            }
        }
        
        return answer.toString();
    }
}