import java.util.*;

class Solution {
    
    static String[][] ticketList;
    static int n; 
    static boolean[] visited;
    static List<String> answer = new ArrayList<>();
    static final String START = "ICN";
    
    public String[] solution(String[][] tickets) {
        ticketList = tickets;
        n = ticketList.length;
        
        // 이전 호출 대비 초기화
        visited = new boolean[n];
        answer.clear();
        answer.add(START);
        
        dfs(START);
        return answer.toArray(new String[0]);
    }
    
    static void dfs(String start){
        // 경로에 담긴 공항 수가 티켓 개수+1 이면 모두 사용 완료
        if (answer.size() == n + 1) {
            return;
        }
        
        // 출발지가 start인, 아직 안 쓴 티켓 인덱스 수집
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (!visited[i] && ticketList[i][0].equals(start)) {
                temp.add(i);
            }
        }
        
        // 도착지 공항 코드 기준 사전순 정렬
        Collections.sort(temp, (a, b) -> ticketList[a][1].compareTo(ticketList[b][1]));
        
        // 후보 티켓 하나씩 시도
        for (int idx : temp) {
            visited[idx] = true;
            answer.add(ticketList[idx][1]);
            
            dfs(ticketList[idx][1]);
            // 성공적으로 마지막까지 다 채웠다면 바로 리턴
            if (answer.size() == n + 1) return;
            
            // 아니라면 백트래킹
            visited[idx] = false;
            answer.remove(answer.size() - 1);
        }
    }
}
// [["ICN", "JFK"], 
// ["HND", "IAD"], 
// ["JFK", "HND"]]
// 정답 ["ICN", "JFK", "HND", "IAD"]
//     ["ICN", "JFK", "HND"]

// 정답 ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
//     ["ICN", "ATL", "ICN", "ATL", "ICN"]
