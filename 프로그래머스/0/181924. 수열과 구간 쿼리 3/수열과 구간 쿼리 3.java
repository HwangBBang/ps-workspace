class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for (int[]q : queries) convert(arr, q);
        
        return arr;
    }
    
    public void convert(int []arr, int [] q){
        int s = q[0];int e = q[1];
        
        int remS = arr[s];
        arr[s] = arr[e];
        arr[e] = remS;
    }
}