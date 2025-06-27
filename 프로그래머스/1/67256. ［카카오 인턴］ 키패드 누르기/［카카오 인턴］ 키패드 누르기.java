import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder(); // 정답을 적재
        
        // 0~9 숫자의 (행,열) 좌표
        //   1(0,0) 2(0,1) 3(0,2)
        //   4(1,0) 5(1,1) 6(1,2)
        //   7(2,0) 8(2,1) 9(2,2)
        //   *(3,0) 0(3,1) #(3,2)
        int[][] pos = {
            {3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}
        };

        int[] leftPos = {3,0};
        int[] rightPos = {3,2};
        
        for (int num : numbers){
            if (num == 1 | num == 4 | num == 7) {
                sb.append("L");
                leftPos[0] = pos[num][0];
                leftPos[1] = pos[num][1];
            }
            else if (num == 3 | num == 6 | num == 9)  {
                sb.append("R");
                rightPos[0] = pos[num][0];
                rightPos[1] = pos[num][1];
            }
            else {
                int rightDist = computeDist(pos[num][0],pos[num][1],rightPos[0],rightPos[1]);
                int leftDist = computeDist(pos[num][0],pos[num][1],leftPos[0],leftPos[1]);
                
                if (leftDist == rightDist){
                    if (hand.equals("right")) {
                        sb.append("R");
                        rightPos[0] = pos[num][0];
                        rightPos[1] = pos[num][1];
                    }
                    else{
                        sb.append("L");   
                        leftPos[0] = pos[num][0];
                        leftPos[1] = pos[num][1];
                    }
                }
                else if (leftDist > rightDist){
                    sb.append("R");
                    rightPos[0] = pos[num][0];
                    rightPos[1] = pos[num][1];
                }
                else if (leftDist < rightDist){
                    sb.append("L");      
                    leftPos[0] = pos[num][0];
                    leftPos[1] = pos[num][1];
                }
            }
            
        }
        
        answer = sb.toString();
        return answer;
    }
    
    private static int computeDist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
    
    
        
}

/*
각 포인트 상하좌우 이동 

왼쪽 시작 : *    | 1 4 7 
오른쪽 시작 : #  | 3 6 9 

접전           | 2 5 8 0 
왼손잡이 / 오른손 잡이 
+ 더 가까운곳 

*/