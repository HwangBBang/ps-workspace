import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        answer = (int)Arrays.stream(array)
                .filter(k -> k == n).count();
        return answer;
    }
}