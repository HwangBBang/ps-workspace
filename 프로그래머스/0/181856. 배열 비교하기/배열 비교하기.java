import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int aSize = arr1.length;
        int bSize = arr2.length;

        if (aSize != bSize) {
            if (aSize > bSize) {
                return 1;
            }
            return -1;
        }

        int aSum = Arrays.stream(arr1).sum();
        int bSum = Arrays.stream(arr2).sum();

        if (aSum == bSum) {
            return 0;
        } else if (aSum > bSum){
            return 1;
        } 
        return -1;
    }
}