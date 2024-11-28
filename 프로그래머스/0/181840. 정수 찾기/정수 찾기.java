class Solution {
    public int solution(int[] num_list, int n) {
        for (int num : num_list){
            if (n == num){
                return 1;
            }
        }
        
        return 0;
    }
}

// 정수 리스트 num_list와 찾으려는 정수 n이 주어질 때,
// num_list안에 n이 있으면 1을 없으면 0을 return