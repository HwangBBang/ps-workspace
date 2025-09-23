import java.util.*;

public class Main {
    static class Person {
        int num;
        int start, during, end;

        public Person(int num, int start, int during){
            this.num = num;
            this.start = start;
            this.during = during;
            this.end = start + during;
        }

        @Override
        public String toString(){
            return "시작" + start + "| 종료" + end + "| 번호" + num ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] t = new int[n];

        List<Person> people = new ArrayList<>(n + 1);
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            t[i] = sc.nextInt();
            // 번호는 1..N
            people.add(new Person(i + 1, a[i], t[i]));
        }

        people.add(new Person(n + 1, Integer.MAX_VALUE, 0));

        // 도착 시각(start) 오름차순, 동시 도착 시 번호(num) 오름차순
        people.sort(Comparator.comparingInt((Person p) -> p.start)
                              .thenComparingInt(p -> p.num));

        // 대기열: 번호가 작은 사람이 먼저
        PriorityQueue<Person> waitQ = new PriorityQueue<>(Comparator.comparingInt(p -> p.num));

        int time = 0;       // 현재 시각(정원 비는 시각)
        int maxDelay = 0;   // 최대 대기시간

        // 도착 순서대로 한 명씩 보면서, 그 사이에 입장/퇴장을 시뮬레이션
        for (int i = 0; i < people.size(); i++) {
            int arrTime = people.get(i).start;
            int arrNum  = people.get(i).num;
            int stay    = people.get(i).during;

            // 다음 도착(arrTime) 전까지, 대기열에서 번호가 가장 작은 사람들을 계속 입장
            while (arrTime > time && !waitQ.isEmpty()) {
                Person next = waitQ.poll();
                int delay = time - next.start;         // next.start ≤ time 보장
                if (delay > maxDelay) maxDelay = delay;
                time += next.during;                   // 연속 처리
            }

            // 지금 도착한 사람을 즉시 입장시킬 수 있으면 바로 입장
            if (arrTime > time) {
                time = arrTime + stay;
            } else {
                // 아니면 대기열에 넣음(번호 기준 우선)
                waitQ.offer(new Person(arrNum, arrTime, stay));
            }
        }

        System.out.println(maxDelay);
    }
}