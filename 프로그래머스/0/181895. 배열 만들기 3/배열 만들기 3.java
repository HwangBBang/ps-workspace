import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] range1 = Arrays.copyOfRange(arr, intervals[0][0], intervals[0][1]+1);
        int[] range2 = Arrays.copyOfRange(arr, intervals[1][0], intervals[1][1]+1);

        int[] answer = new int[range1.length + range2.length];
        
        System.arraycopy(range1, 0 , answer, 0 , range1.length);
        System.arraycopy(range2, 0 , answer, range1.length , range2.length);
        
        return answer;
    }
}