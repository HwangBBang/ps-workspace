import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        if (N == number) return 1;
        
        int answer = -1;
        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i ++){
            dp.add(new HashSet<>());
        }
            
        for (int i = 1; i <= 8; i ++){
            Integer repeated = Integer.parseInt((String.valueOf(N)).repeat(i));
            dp.get(i).add(repeated);
        }
        
        /*
        i 단계 = dp[i] = dp[i-1] + dp[1]
        i 단계 = dp[i] = dp[i-2] + dp[2]
        i 단계 = dp[i] = dp[i-3] + dp[3]
        i 단계 = dp[i] = dp[i-i+1] + dp[i+1]
        */ 
        
        for (int i = 1; i <= 8; i ++){
            for (int ii = 1; ii < i; ii ++){
                for (int c : dp.get(ii)){
                    for (int p : dp.get(i-ii)){
                        dp.get(i).add(c + p);
                        dp.get(i).add(c - p);
                        dp.get(i).add(c * p);
                        if (p != 0) dp.get(i).add(c / p);
                        
                        if (dp.get(i).contains(number)) return i;
                    }
                }
            }
        }
        
        
        
//      1. 이어 붙이기 
        // Integer.parseInt((""+N) + N);
//      2. 더하기 
        
//      3. 곱하기 
        
//      4. 빼기 

//      5. 나누기 
        return answer;
    }
}

/* 
이전 결과를 이용한다. 
1단계 : 5
2단계 : 55 , (5 + 5), (5 - 5), (5 / 5), (5 * 5)
3단계 : 555, (555 + 5), (555 - 5), (555 / 5), (555 * 5)


케이스가 지수적으로증가하는데 DP 로 어떻게 풀지..?
*/   
