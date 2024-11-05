import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {

        // int[] answer = Arrays.copyOfRange(numbers, num1, num2+1);
        int[] answer = IntStream.rangeClosed(num1,num2).map(num -> numbers[num]).toArray();
        return answer;
    }
}