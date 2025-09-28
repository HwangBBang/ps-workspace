import java.util.*;
import java.io.*;

/*
사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/

class Solution {
	
	static int dx[] = new int[]{1, 0, -1 ,0};
	static int dy[] = new int[]{0, 1, 0 ,-1};
	static final int SIZE = 16;
	static class Pair{
		int x,y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String args[]) throws Exception {
		/*
		 * 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다. 여러분이 작성한 코드를
		 * 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후, 이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때
		 * 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다. 따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		 * 단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int T = 10;
		
		
		int [][] grid = new int[SIZE][SIZE];
		
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String caseNum = br.readLine();
			Pair start = new Pair(0,0); // DUMMEY
			Pair end = new Pair(0,0); // DUMMEY
			
			for (int i = 0; i < SIZE; i++) {
				String line = br.readLine();
				
				for (int j = 0; j < SIZE; j++) {
					grid[i][j] = line.charAt(j) - '0';
					
					if(grid[i][j] == 2) start = new Pair(i,j);
					else if(grid[i][j] == 3) end = new Pair(i,j);
				}
			}
			// 입력 끝
			
			int result = bfs(start,end,grid) ? 1 : 0;
			
			System.out.printf("#%s %d\n",caseNum, result);
		}
	}
	
	static boolean bfs(Pair start, Pair end, int[][] grid) {
		boolean [][] visit = new boolean[SIZE][SIZE]; 

		Queue<Pair> que = new ArrayDeque<>();
		que.add(start);
		visit[start.x][start.y] = true;
		
		while(!que.isEmpty()) {
			Pair cur = que.poll();
			if (end.x == cur.x && end.y == cur.y) return true; 
				
			for (int i = 0; i < dx.length; i++) {
				int nx = cur.x +dx[i];
				int ny = cur.y +dy[i];
				
				if (nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE) continue;
				if (visit[nx][ny]) continue;
				if (grid[nx][ny] == 1) continue;
				
				que.add(new Pair(nx,ny));
				visit[nx][ny] = true;
			}
		}
		
		return false;
	}
}