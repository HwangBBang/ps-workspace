import java.util.*;
public class Main {
    static class Person implements Comparable<Person>{
        int num;
        int start,during,end;

        public Person(int num, int start, int during){
            this.num = num;
            this.start = start;
            this.during = during;
            this.end = start + during;
        }

        @Override
        public int compareTo(Person other){
            if (this.end != other.end)
                return Integer.compare(this.end, other.end);
            else 
                return Integer.compare(this.num, other.num);   
        }

        @Override
        public String toString(){
            return "시작" + start + "| 종료" + end + "| 번호" + num ;
        }
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // end 순으로,, 
        List<Person> people = new ArrayList<>();

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            t[i] = sc.nextInt();
            people.add(new Person(i+1,a[i],t[i]));
        }
        
        Collections.sort(people);

        PriorityQueue<Person> waitQ = new PriorityQueue<>(
            (p1,p2) -> Integer.compare(p1.num, p2.num)
        );
        
        long time = 0L;
        long maxWait = 0L;
        int idx = 0;        // 아직 대기열에 넣지 않은 사람의 인덱스
        int served = 0;

        while (served < n) {
            // 현재 시각까지 도착한 사람을 모두 대기열에 넣는다
            while (idx < n && people.get(idx).start <= time) {
                waitQ.offer(people.get(idx++));
            }

            // 대기열이 비어 있으면 다음 도착까지 '점프'
            if (waitQ.isEmpty()) {
                // 남은 사람이 있다면 그 사람의 도착 시각으로 이동
                time = people.get(idx).start;
                continue; // 점프 후 다시 채우기 루프부터
            }

            // 번호가 가장 작은 사람 입장
            Person cur = waitQ.poll();
            long wait = time - cur.start;          // 도착 시각 ≤ 현재 시각 보장
            if (wait > maxWait) maxWait = wait;

            time += cur.during;                     // 정원을 비우는 시각으로 진행
            served++;
        }

        System.out.println(maxWait);
    }
}
/*
1~N 명의 사람들 

도착 시간 a1 
잔류 시간 t1
떠나는시간 a1 + t1

정원에는 한사람만 입장가능 , 대기(큐)

25 3
105 30
20 50
10 17
100 10

*/