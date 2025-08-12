class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int c2 = arr2[0].length;
        
        int[][] answer = new int[r1][c2];
        
        for (int i = 0; i < r1; i ++){
            for (int ii = 0; ii < c2; ii ++){
                answer[i][ii] = mul(i,ii, arr1, arr2, c1);
            }    
        }
        
        return answer;
    }
    
    static int mul(int sr, int sc, int[][] arr1, int[][] arr2, int len){
        int res = 0;
        for (int i = 0; i < len; i++){
            res += arr1[sr][i] * arr2[i][sc];
        }
        return res;
    }
}

/*
(3 x 2) (2 x 2)
[
    [1, 4], 
    [3, 2], 
    [4, 1]
]

[
    [3, 3], 
    [3, 3]
]

*/