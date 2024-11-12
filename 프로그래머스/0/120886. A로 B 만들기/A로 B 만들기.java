import java.util.*;

class Solution {
    public int solution(String before, String after) {
        HashMap<String, Integer> beforeMap = new HashMap<>();
        HashMap<String, Integer> afterMap = new HashMap<>();

        String[] befores = before.split("");
        for (String s : befores) {
            beforeMap.put(s, beforeMap.getOrDefault(s, 0) + 1);
        }

        String[] afters = after.split("");
        for (String s : afters) {
            afterMap.put(s, afterMap.getOrDefault(s, 0) + 1);
        }

        if (beforeMap.equals(afterMap)) {
            return 1;
        }
        return 0;
    }
}