import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        String[] answer =  myStr.split("[abc]+");

        if (answer.length == 0) return new String[]{"EMPTY"};

        if (answer[0].equals("")) {
            return Arrays.copyOfRange(answer, 1, answer.length);
        }

        return answer;
    }
}