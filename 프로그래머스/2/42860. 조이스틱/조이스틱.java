class Solution {
    public int solution(String name) {
        
        char[] dataSet = name.toCharArray();
        int[] difSet = new int[dataSet.length];
        
        for (int i = 0; i < dataSet.length; i++){   
            int left = dataSet[i] - 'A';
            int right = 26 + ('A' - dataSet[i]);
            difSet[i] = Math.min(left,right);
        }
        
        int answer = 0;
        
        for (int i = 0; i < difSet.length; i++)    answer += difSet[i];
        int n = name.length();
        
        int move = n - 1;  
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            // A가 연속된 구간 건너뛰기
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            // (1) 오른쪽으로 갔다가 복귀 후, 왼쪽에서 건너뛰기
            move = Math.min(move, i  +  i  +  (n - next));
            // (2) 왼쪽(A 구간 뒤쪽) 먼저 건너뛰기
            move = Math.min(move, (n - next) + (n - next) + i );
        }
    
        return answer + move;
    }
}

