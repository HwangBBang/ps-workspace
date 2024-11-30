class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        for (int num : num_list){
            answer += count(num);
        }
        return answer;
    }
    
    public int count(int num){
        int cnt = 0;
        while (num != 1){
            if(num%2==1)num -=1;    
            num /=2;
            cnt ++;
        }
        return cnt;
    }
    
}