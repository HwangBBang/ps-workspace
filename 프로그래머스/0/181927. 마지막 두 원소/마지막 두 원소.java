class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int[] answer = new int[len+1];
        
        for (int i = 0; i < len ; i ++){
            answer[i] = num_list[i];
        }
        
        if (num_list[len-1] > num_list[len-2]){
            answer[len] = num_list[len-1] - num_list[len-2];
        } else{
            answer[len] = num_list[len-1] * 2;
        }
        
        
        return answer;
    }
}

// 마지막 원소가 그전 원소보다 크면
//      마지막 원소에서 그전 원소를 뺀 값을 

// 마지막 원소가 그전 원소보다 크지 않다면
//      마지막 원소를 두 배한 값을 추가하여 return하도록 