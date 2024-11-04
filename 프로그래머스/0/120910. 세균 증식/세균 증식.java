import java.util.*;

class Solution {
    public int solution(int n, int t) {
//         int answer = n;
        
//         for(int i = 0; i < t; i ++){
//             answer = makeTwice(answer);
//         }
//         return answer;
        return n * (int)Math.pow(2,t);
    }
    
    // private int makeTwice(int n){
    //     return n * 2;
    // }
}