class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int [queries.length];
        int i = 0;
        for (int[] q : queries){
            answer[i] = find(arr, q);
            i++;
        }
        
        return answer;
    }
    
    public int find(int[] arr, int[] q){
        int start = q[0];
        int end = q[1];
        int k = q[2];
        
        int res = 1000001;
        
        for (int i = start; i <= end; i ++ ){
            if (arr[i] <= k) continue;
            res = Math.min(res, arr[i]);
        }
        if (res != 1000001) return res;
        return -1;
    }
}