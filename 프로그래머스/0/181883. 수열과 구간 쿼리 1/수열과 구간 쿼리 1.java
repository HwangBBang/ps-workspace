import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
                
        for (int[] query : queries){
            process(arr, query);
        
        }
        return arr;
    }
    
    public int[] process(int[] arr , int[] query){
        int start = query[0];
        int end = query[1];
        
        for (int i = start; i <= end; i++ ){
            arr[i] ++;
        }
        return arr;
    }
}