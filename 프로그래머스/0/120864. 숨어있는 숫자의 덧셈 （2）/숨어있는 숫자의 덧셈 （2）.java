import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;

        String[] datas = my_string.split("[^0-9]+");
        answer = Arrays.stream(datas).filter(d -> !d.isBlank()).mapToInt(Integer::parseInt).sum();

        return answer;
    }
}