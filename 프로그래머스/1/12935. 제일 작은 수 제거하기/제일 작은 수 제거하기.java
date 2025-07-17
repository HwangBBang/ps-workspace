import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};

        int min = Integer.MAX_VALUE;

        for (int num : arr) {
            min = Math.min(min, num);
        }

        int[] answer = new int[arr.length - 1];
        int idx = 0;

        for (int num : arr) {
            if (num != min) {
                answer[idx++] = num;
            }
        }

        return answer;
    }
}