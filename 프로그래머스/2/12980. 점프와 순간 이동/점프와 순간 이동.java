import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        // System.out.println("Hello Java");
        
        while (n >= 1){
            while(n % 2 == 0) n /= 2;
            // System.out.println(n);
        
            n --;
            ans ++;
        }
        
        
        
        return ans;
    }
}

/*

DP 
    1. k 칸 만큼 이동          | k 만큼 소비 
    2. 온 거리의 2배 위치로 이동  | 소비 X
    
    m 과 m * 2^n 의 결과는 같다.
    
*/

/*

5 
[5] 5만큼 이동
[5] 4만큼 이동 + 1만큼 이동 X
[5] 3만큼 이동 + 2만큼 이동 X
[3] 2만큼 이동 + 2배 + 1만큼 이동 
[2] 1만큼 이동 + 2배 + 2배 + 1만큼 이동 


6 
[6] 6만큼 이동
[6] 5만큼 이동 + 1만큼 이동 
[6] 4만큼 이동 + 2만큼 이동 
[3] 3만큼 이동 + 2배
[4] 2만큼 이동 + 2배 + 2만큼 이동 
[2] 1만큼 이동 + 2배 + 1만큼 이동 + 2배

3
[2] 1만큼 이동 + 2배 + 1만큼 이동

*/


    