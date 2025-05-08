import java.util.*;

class Solution {
    static String[] wordList;
    static boolean[] visited;
    static int[] dist;
    static int answer = 0;
    static Queue<Word> queue = new LinkedList<>();
    
    static class Word{
        String word; int step;
        public Word(String word,int step){
            this.word = word;
            this.step = step;
        }
    }
    
    
    public int solution(String begin, String target, String[] words) {
        wordList = words;
        visited = new boolean[words.length];
        dist = new int[words.length];
        queue.add(new Word(begin, 0));
        
        bfs(begin,target);
        
        return answer;
    }
    
//    최단거리 -> BFS , 
//    words 는 노드, 
//    노드간 모두 연결이 되있다고 가정하고 순회해야함
//    노드간 연결의 주요 조건은 단어간 1개의 단어만 다른지? 

    static void bfs(String begin, String target){
            
        while(!queue.isEmpty()){
            Word startWord = queue.poll();
            String curWord = startWord.word;
            int curIdx = startWord.step;
            
            if (curWord.equals(target)) {
                answer = dist[curIdx];
                return;
            }
            for (int i = 0; i < wordList.length; i++){
                
                if(!isConnected(curWord, wordList[i])) continue;    
                if(visited[i]) continue;
                
                visited[i] = true;
                dist[i] = dist[curIdx] + 1;
                queue.add(new Word(wordList[i],i));
            }
            
        }
    }


//     모든 단어의 길이 같다.
    static boolean isConnected(String cur, String next){
        char[] curArr = cur.toCharArray();
        char[] nextArr = next.toCharArray();
        
        int cnt = 0;
        
        for (int i = 0; i < curArr.length; i++){
            if (curArr[i] != nextArr[i]) cnt ++;
        }
        
        return cnt == 1;
    }
}