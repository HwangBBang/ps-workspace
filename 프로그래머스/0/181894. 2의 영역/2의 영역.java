import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> idxs = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 2) idxs.add(i);
        }
        
        if (idxs.isEmpty()) return new int[]{-1};
        
        int start = idxs.get(0);
        int end = idxs.get(idxs.size()-1)+1;
        
        int[] answer = new int [end-start];
        
        for (int i = start; i < end; i ++){
            answer[i-start] = arr[i];
        }
        
        
        return answer;
    }
}