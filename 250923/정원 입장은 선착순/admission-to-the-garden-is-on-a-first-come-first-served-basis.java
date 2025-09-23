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
        
   long time = 0L, maxDelay = 0L;
        int idx = 0, processed = 0;

        while (processed < n) {
            if (waitQ.isEmpty()) {
                time = Math.max(time, people.get(idx).start);   // 다음 도착 시각으로 점프
                while (idx < n && people.get(idx).start <= time) {
                    waitQ.offer(people.get(idx++));             // <-- offer로 넣기
                }
            }

            Person cur = waitQ.poll();                          // 꺼내기
            long delay = time - cur.start;
            if (delay > maxDelay) maxDelay = delay;

            time += cur.during;

            while (idx < n && people.get(idx).start <= time) {
                waitQ.offer(people.get(idx++));                 // <-- offer
            }
            processed++;
        }

        System.out.println(maxDelay);
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