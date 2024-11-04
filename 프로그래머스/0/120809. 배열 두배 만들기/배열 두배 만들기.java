import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        answer = Arrays.stream(numbers).map(number -> number * 2).toArray();
        return answer;
    }
}