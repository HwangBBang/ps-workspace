import java.util.*;

class Solution {
    
    public int solution(int n, int k) {
        
        int answer = -1;
        // String converted = convertByBase(k,n);
        String converted = Long.toString(n,k);
        answer = getResult(converted);
        return answer;
    }
    
    static int getResult(String num){
        String[] nums = num.split("0+");
        int answer = 0;
        for (String n : nums){
            if (n.length() != 0){
                if (isPrime(n)) answer ++;
            }
        }
        return answer;
    }
    
    static boolean isPrime(String num){
        long n = Long.parseLong(num);
        
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        long r = (long) Math.sqrt(n);
        for (long d = 3; d <= r; d += 2) {
            if (n % d == 0) return false; 
        }
        return true;
    }
    
//     static String convertByBase(int base, int num){
//         if (num == 0) return "0";
        
//         Deque<Integer> temp = new ArrayDeque<>();
        
//         while (num > 0){
//             temp.addFirst(num%base);
//             num /= base;
//         }
//         StringBuilder answer = new StringBuilder();
//         for(int a : temp){
//             answer.append(a);
//         }
//         return answer.toString();
//     }
}
/*
아래 조건에 맞는 소수(Prime number)가 몇 개인지 알아보려 합니다.

0P0처럼 소수 양쪽에 0이 있는 경우
P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
P처럼 소수 양쪽에 아무것도 없는 경우
단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.
예를 들어, 101은 P가 될 수 없습니다.
*/
