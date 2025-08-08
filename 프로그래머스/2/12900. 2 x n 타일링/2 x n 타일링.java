class Solution {
    
    static final int MOD = 1_000_000_007;
    
    public int solution(int n) {
        int answer = 0;
        
        int [] dp = new int [n + 1];
        // 초기 값
        dp[1] = 1;
        dp[2] = dp[1] + 1;
        if (n <= 2) return dp[n];
        
        
        for (int i = 3; i <= n; i ++){
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }
        answer = dp[n];
        return answer;
    }
}