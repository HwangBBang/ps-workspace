// class Solution {
//     public int solution(String name) {
//         int answer1 = 0;
//         int answer2 = 0;
        
// //         char[] charSet = new char[26];
        
// //         for (int i = 0; i < 26; i ++){
// //             charSet[i] = (char)('A' + i);    
// //         }
        
//         char[] dataSet = name.toCharArray();
//         int[] difSet = new int[dataSet.length];
        
//         for (int i = 0; i < dataSet.length; i++){   
//             int left = dataSet[i] - 'A';
//             int right = 26 + ('A' - dataSet[i]);
//             difSet[i] = Math.min(left,right);
//         }
        
//         for (int i = 0; i < difSet; i++){   
//             // 순방향 순회 
//             answer1 = difSet[i] + 1;
            
//             // 역방향 순회 
//             answer2 = difSet[difSet.length-i] + 1;
                
//         }
    
//         return answer;
//     }
// }

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
            // 경우 1: i → 0 → (n-1→next)
            move = Math.min(move, 2 * i + (n - next));
            // 경우 2: (n-1 → next) → 0→i
            move = Math.min(move, i + 2 * (n - next));
        }
    
        return answer + move;
    }
}

