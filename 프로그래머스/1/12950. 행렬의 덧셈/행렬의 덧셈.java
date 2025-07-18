class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int rLen = arr1.length;
        int cLen = arr1[0].length;
        
        int[][] answer = new int[rLen][cLen];
        
        for (int r = 0; r < rLen; r ++){
            for (int c = 0; c < cLen; c ++){
                answer[r][c] = arr1[r][c] + arr2[r][c];
            }
        }
        return answer;
    }
}