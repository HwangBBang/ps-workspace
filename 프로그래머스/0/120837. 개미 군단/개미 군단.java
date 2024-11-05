class Solution {
    
    // 장군개미는 5의 공격력
    // 병정개미는 3의 공격력 
    // 일개미는 1의 공격력
    
    public int solution(int hp) {
        int[] attacks = {5,3,1};
        int answer = 0;
        int idx = 0;
        
        while (hp > 0){
            int cnt = hp / attacks[idx];
            hp -= cnt * attacks[idx];
            answer += cnt;
            idx ++;
        }
        return answer;
    }
    
}