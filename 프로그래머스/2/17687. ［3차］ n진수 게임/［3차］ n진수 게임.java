import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= m*t; i++){
            String converted = convertByBase(n, i);
            sb.append(converted);
        }
        StringBuilder answer = new StringBuilder();
        
        int step = 0;
        while(step < t){
            answer.append(sb.substring((p-1)+m*step, (p-1)+m*step +1));
         step ++;   
        }
        
        return answer.toString();
    }
    
    static String convertByBase(int base, int num){
        if (num == 0) return "0";
        Deque<Integer> queue = new ArrayDeque<>();
        while(num != 0){
            queue.addFirst(num%base);
            num /= base;
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i : queue){
            if (i >= 10) {
                i = 'A' + (i - 10);
                answer.append((char) i);
            }else{
                answer.append(i);    
            }
        }
        return answer.toString();
    }
}
//      8421
// 6 -> 0110
// 7 -> 0111

// 6 -> 3 0
// 3 -> 1 1
// 1 -> 0 1

// 7 -> 3 1
// 3 -> 1 1
// 1 -> 0 1



/*
여러 사람이 둥글게 앉아서 숫자를 하나씩 차례대로 말하는 게임

1. 숫자를 0부터 시작해서 차례대로 말한다
2. 10 이상의 숫자부터는 한 자리씩 끊어서 말한다. 
    즉 열한 번째 사람은 10의 첫 자리인 1, 열두 번째 사람은 둘째 자리인 0을 말한다
3. n 진법 으로 변환

n 진법
튜브가 말하는 미리 구할 숫자의 갯수 t
게임에 참가하는 인원 m, 튜브의 순서 p 가 주어진다.
t = 4, m = 2 , p = 1


0123456789
0110111001011101111000

idx 0 2 4 6
0111
*/