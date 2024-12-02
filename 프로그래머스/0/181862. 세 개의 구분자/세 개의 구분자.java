import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        String[] answer = myStr.split("[a|b|c]");
        if (answer.length == 0) return new String[]{"EMPTY"};

        String[] array = Arrays.stream(answer).filter(each -> !each.equals("")).toArray(String[]::new);
        return array;
    }
}