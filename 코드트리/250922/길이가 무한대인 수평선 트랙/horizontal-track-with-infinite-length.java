import java.util.*;
import java.io.*;

public class Main {
    public static class Group implements Comparable<Group> {
        long position;    // 현재 위치
        int speed;        // 속력
        int originalStart; // 원래 시작 위치 (정렬용)
        
        public Group(int start, int speed) {
            this.position = start;
            this.speed = speed;
            this.originalStart = start;
        }
        
        public void move() {
            this.position += this.speed;
        }
        
        @Override
        public int compareTo(Group other) {
            // 위치가 다르면 위치 기준으로 내림차순 (앞선 그룹부터)
            if (this.position != other.position) {
                return Long.compare(other.position, this.position);
            }
            // 위치가 같으면 속력 기준으로 내림차순 (빠른 그룹부터)
            if (this.speed != other.speed) {
                return Integer.compare(other.speed, this.speed);
            }
            // 둘 다 같으면 원래 시작 위치 기준으로 오름차순
            return Integer.compare(this.originalStart, other.originalStart);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        List<Group> groups = new ArrayList<>();
        
        // 사람들의 정보 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            groups.add(new Group(start, speed));
        }
        
        // T분 동안 시뮬레이션
        for (int time = 0; time < t; time++) {
            // 모든 그룹 이동
            for (Group group : groups) {
                group.move();
            }
            
            // 위치와 속력으로 정렬
            Collections.sort(groups);
            
            // 그룹 합치기
            List<Group> newGroups = new ArrayList<>();
            Group currentGroup = groups.get(0);
            
            for (int i = 1; i < groups.size(); i++) {
                Group nextGroup = groups.get(i);
                
                // 같은 위치에 있으면서 현재 그룹이 더 빠르거나 같으면 합치기
                if (currentGroup.position == nextGroup.position && 
                    currentGroup.speed >= nextGroup.speed) {
                    // 느린 속력으로 맞춤
                    currentGroup.speed = Math.min(currentGroup.speed, nextGroup.speed);
                } else {
                    // 합치지 않고 새 그룹으로 추가
                    newGroups.add(currentGroup);
                    currentGroup = nextGroup;
                }
            }
            newGroups.add(currentGroup);
            groups = newGroups;
        }
        
        System.out.println(groups.size());
    }
}