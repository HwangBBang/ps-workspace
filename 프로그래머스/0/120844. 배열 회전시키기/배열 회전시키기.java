class Solution {
    public int[] solution(int[] numbers, String direction) {
        int len = numbers.length;
        int[] result = new int[len];

        if (direction.equals("right")){
            result[0] = numbers[len - 1];
            for (int i = 1; i < len; i++) {
                result[i] = numbers[i - 1];
            }   
        }
        else if(direction.equals("left")){
            result[len - 1] = numbers[0];
            for (int i = 1; i < len; i++) {
                result[i-1] = numbers[i];
            }
            
        }
        return result;
    }
}

//          1 ~ len -1 
// numbers [4, / 455, 6, 4, -1, 45, 6]	
//          0~ len - 2
// result [455, 6, 4, -1, 45, 6, 4]