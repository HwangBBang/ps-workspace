import java.util.*;

class Solution {
    static int[] pattern1 = {1, 2, 3, 4, 5};
    static int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] result = {0,0,0};
        int n = answers.length;
        int p1 = pattern1.length;
        int p2 = pattern2.length;
        int p3 = pattern3.length;
        
        for (int i = 0; i < n; i++){
            if(answers[i] == pattern1[i % p1]) result[0]++;
            if(answers[i] == pattern2[i % p2]) result[1]++;
            if(answers[i] == pattern3[i % p3]) result[2]++;
        }
        
        return setAnswer(result);
    }
    
    static int[] setAnswer(int[]result){
        int maxValue = Integer.MIN_VALUE;
        List<Integer> temp = new ArrayList<>();
        
        for (int i = 0; i < result.length; i ++){
            maxValue = Math.max(maxValue,result[i]);
        }
        
        for (int i = 0; i < result.length; i ++){
            if (maxValue == result[i])   temp.add(i+1);        
        }

        int[] answerList = new int[temp.size()];
        
        for (int i = 0; i<temp.size(); i++){
            answerList[i] = temp.get(i);
        }
        
        return answerList;
    }
}

// 1번 1, 2, 3, 4, 5
// 2번 2, 1, 2, 3, 2, 4, 2, 5
// 3번 3, 3, 1, 1, 2, 2, 4, 4, 5, 5

// 루프를 계속 돌 수 있도록.. 해야함 
// legnth 와 % 를 이용하면 될 듯
// 패턴 길이가 7 이라고 하면 0~6 까지 인덱스 
//  i % p.length

// 배열에서 가장 큰놈이 누군지 뽑아내야해 중복 O

