import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[5];
        int[] array1 = Arrays.stream(num_list).sorted().toArray();
        for (int i = 0; i < answer.length; i++) {
            answer[i] = array1[i];
        }

        return answer;
    }
}