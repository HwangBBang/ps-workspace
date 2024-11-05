class Solution {
     public int solution(int n) {
        int lcm = lcm(6, n);   // 6과 n의 최소공배수 계산
        return lcm / 6;        // 최소 피자 판 수 계산
    }

    // 최대공약수(GCD) 계산 함수
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 최소공배수(LCM) 계산 함수
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);  // LCM = (a * b) / GCD
    }
}

// 6 6 
// 10 30 
// 4 12     
    
    