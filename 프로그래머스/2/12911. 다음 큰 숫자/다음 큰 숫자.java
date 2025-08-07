class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String nBin = Integer.toBinaryString(n); 
        
        int nCnt = getOneCnt(nBin); 
        
        int k = n + 1;
        while (true){
            String kBin = Integer.toBinaryString(k); 
            if (nCnt == getOneCnt(kBin)) {
                answer = k;
                break;
                // return k;
            }
            k ++;                
        }
        
        return answer;
    }
    
    static int getOneCnt(String bin){
        int cnt = 0;
        
        for (int i = 0; i < bin.length(); i++){
            if (bin.substring(i,i+1).equals("1")) cnt ++;
        }
        
        return cnt;
    }
}

/*
    n의 다음 큰 숫자 ? 를 k 라하자 
    
    1. k > n
    2. k의 2진수 1의 갯수 == n의 2진수 1의 갯수
    3. 여러 k 의 후보중 가장 작은 수 
    
    3번을 통해서 오름 차순으로 순회하다 정답이녀석 내보내기! -> O(n)
    
*/