class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] fibos = new int[n+1];
        
        // 초기값 세팅
        fibos[1] = 1;
        fibos[2] = 1;
        for (int i = 3; i <= n; i ++){
            fibos[i] = fibos[i-1]% 1234567 + fibos[i-2]% 1234567;
        }
        
        answer = fibos[n]% 1234567;
        return answer;
    }
    
    /*
    static int fibo(int n){
        
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return fibo(n-1) % 1234567 + fibo(n-2) % 1234567;
    }
    */
}

/*
    sol.1 
    일반적인 피보나치 계산은 시간초과 
    왜 사전에 알지 못했을까? 
    사전에 분할정복을 통한 피보나치 연산은 
    시간초과가 발생한다는 것을 알아차렸어야하는 근거 ? -> 확인 요망
    
    ===
    sol.2
    dp -> 이미 연산 한걸 재활용함으로써 
    분할정복으로 자식노드 무한 생성되는 것을 방지 할 수 있음 
    
    리스트 사이즈가 100_000, 메모리 이슈가 없나?? -> 확인 요망
*/