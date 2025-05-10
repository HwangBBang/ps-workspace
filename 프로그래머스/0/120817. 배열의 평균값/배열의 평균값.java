import java.util.*;
class Solution {
    public double solution(int[] numbers) {
        int temp = 0;
        
        int len = numbers.length;
        for(int i = 0; i < len; i++) temp += numbers[i];
        
        return (double)temp / len;
    }
}