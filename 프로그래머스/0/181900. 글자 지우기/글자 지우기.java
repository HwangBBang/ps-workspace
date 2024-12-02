import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        int len = my_string.length();

        String[] split = my_string.split("");
        StringBuilder sb = new StringBuilder();

        List<Integer> list = Arrays.stream(indices).boxed().collect(Collectors.toList());
        int newLen = len - list.size();

        for (int i = 0; i < len; i++) {
            if (list.contains(i)) continue;
            sb.append(split[i]);
        }

        return sb.toString();
    }
}