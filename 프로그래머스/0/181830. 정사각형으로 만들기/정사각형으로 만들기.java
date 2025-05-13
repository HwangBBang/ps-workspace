class Solution {
    public int[][] solution(int[][] arr) {
        
        int rLen = arr.length;
        int cLen = arr[0].length;
        
        int nLen = Math.max(rLen,cLen);
        int[][] answer = new int[nLen][nLen];
        for (int i = 0; i < rLen; i++){
            for (int ii = 0; ii < cLen; ii++){
                answer[i][ii] = arr[i][ii];
            }
        }
        return answer;
    }
}
/*
[
    [572, 22, 37], 
    [287, 726, 384], 
    [85, 137, 292], 
    [487, 13, 876]
]

[
    [572, 22, 37, 0], 
    [287, 726, 384, 0], 
    [85, 137, 292, 0], 
    [487, 13, 876, 0]
]

[
    [57, 192, 534, 2], 
    [9, 345, 192, 999]
]

*/