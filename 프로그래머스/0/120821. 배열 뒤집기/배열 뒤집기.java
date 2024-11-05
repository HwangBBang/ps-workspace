import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list) {

        return IntStream.range(0,num_list.length).map(idx -> num_list[num_list.length-1-idx]).toArray();
    }
}