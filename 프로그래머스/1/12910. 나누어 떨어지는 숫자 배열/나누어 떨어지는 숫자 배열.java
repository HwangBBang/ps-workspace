import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(arr);
        
        for (int elem : arr){
            if (elem % divisor == 0){
                list.add(elem);
            }
        }
        
        int n = list.size();
        int[] answer = new int[n]; 
        
        if (n == 0) return new int[]{-1};
        for (int i = 0; i < n; i ++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}