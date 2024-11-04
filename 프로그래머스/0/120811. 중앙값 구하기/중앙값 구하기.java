import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int[] sortedArray = Arrays.stream(array).sorted().toArray();
        int len = sortedArray.length;
        answer = sortedArray[len/2];
        
        return answer;
    }
}