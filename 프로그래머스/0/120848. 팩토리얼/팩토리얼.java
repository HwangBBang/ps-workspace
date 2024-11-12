import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 10;
        List<Integer> factorials = new ArrayList<>(List.of(1));

        for (int i = 0; i < 10; i ++){
            factorials.add(factorials.get(i) * (i + 1));
        }

        for (int i = 1; i < 10; i++) {
            if (factorials.get(i) <= n && factorials.get(i + 1) > n) {
                answer = i;
                break;
            }
        }


        return answer;
    }
}