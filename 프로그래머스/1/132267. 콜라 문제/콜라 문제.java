class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        
        while(n >= a){
            
            int taken = (n / a) * b ;
            int given = (n / a) * a;
            
            n = n - given + taken;
            
            answer += taken;
        }
        return answer;
    }
}

/*
빈 병 20개 중 18개를 마트에 가져가서, 6병의 콜라를 받습니다. 
n =  8(20 – 18 + 6 = 8)개 입니다.
20 -> 10 0 => 10 
10 -> 5 0  => 15
5  -> 2 1  => 17
3  -> 1 2  => 18
*/