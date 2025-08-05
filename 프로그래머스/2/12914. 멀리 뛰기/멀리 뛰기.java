class Solution {
    public long solution(int n) {
        long answer = 0;
        
        int[] dpTable = new int[n+1];
        
        dpTable[1] = 1;
        if (n == 1) return 1;
        dpTable[2] = dpTable[1] + 1;
        
        for (int i = 3; i <= n; i ++){
            dpTable[i] = (dpTable[i-1] + dpTable[i-2]) % 1234567;
        }
        answer = dpTable[n]; 
        return answer;
    }
}

/*
전형적인 DP 문제 

*/