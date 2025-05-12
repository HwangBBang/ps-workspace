import java.util.*;

class Solution {
    static int [][] grid;
    static List<Integer> answer;
    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new ArrayList<>();
        
        grid = new int[rows+1][columns+1];
        
        int temp = 1;
        for (int r = 1; r < rows+1; r ++){
            for (int c = 1; c < columns+1; c ++){
                grid[r][c] = temp++;
            }    
        }
        
        for (int[]q : queries){
            shift(q);
        }
        
        int[] a = new int [answer.size()]; 
        for (int i = 0; i < answer.size(); i++){
            a[i] = answer.get(i);
        }
        return a;
    }
    
    // 2,2,5,4
    // 2 ~ 5, 2 ~ 4
    
    static void shift(int[] q) {
    int sR = q[0], sC = q[1], eR = q[2], eC = q[3];

    List<Integer> temp = new ArrayList<>();
    int min = Integer.MAX_VALUE;

    // 1) 위쪽 가로 (왼→오)
    for (int c = sC; c <= eC; c++) {
        temp.add(grid[sR][c]);
        min = Math.min(min, grid[sR][c]);
    }
    // 2) 오른쪽 세로 (위→아래)
    for (int r = sR + 1; r <= eR; r++) {
        temp.add(grid[r][eC]);
        min = Math.min(min, grid[r][eC]);
    }
    // 3) 아래쪽 가로 (오→왼), 모서리 중복 방지: eC-1 부터
    for (int c = eC - 1; c >= sC; c--) {
        temp.add(grid[eR][c]);
        min = Math.min(min, grid[eR][c]);
    }
    // 4) 왼쪽 세로 (아래→위), 모서리 중복 방지: eR-1 부터
    for (int r = eR - 1; r > sR; r--) {
        temp.add(grid[r][sC]);
        min = Math.min(min, grid[r][sC]);
    }

    // 최소값 기록
    answer.add(min);

    // 한 칸 시계 방향으로 회전시키기 위해 리스트 끝을 앞에 붙인다
    temp.add(0, temp.remove(temp.size() - 1));

    // 0번부터 다시 채워넣기 (순서·범위는 수집한 루프와 동일)
    int idx = 0;
    for (int c = sC; c <= eC; c++) grid[sR][c] = temp.get(idx++);
    for (int r = sR + 1; r <= eR; r++) grid[r][eC] = temp.get(idx++);
    for (int c = eC - 1; c >= sC; c--) grid[eR][c] = temp.get(idx++);
    for (int r = eR - 1; r > sR; r--) grid[r][sC] = temp.get(idx++);
    }
}