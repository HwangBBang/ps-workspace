import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        ArrayList<String> answer = new ArrayList<>();

        int length = my_str.length();

        for (int start = 0; start < length; start+=n) {
            int end = start + n;

            answer.add(my_str.substring(start,Math.min(length,end)));
        }
        return answer.toArray(new String[0]);
    }
}