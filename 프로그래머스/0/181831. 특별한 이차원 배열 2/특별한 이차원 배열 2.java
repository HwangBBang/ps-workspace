class Solution {
    public int solution(int[][] arr) {
        for(int i = 0; i < arr.length; i ++ ){
            for(int j = 0; j < i; j ++ ){
                if (arr[i][j] != arr[j][i]) return 0;
            }
        }
        return 1;
    }
}


// [5, 192, 33]
// [192, 72, 95]
// [33, 95, 999]

//  1
//  12
//  123
//  1234 
//  12345