h,m,s = map(int,input().split())
addSec = int(input())

# h:시각, m:분, s:초, sec:추가된 초

#고려요소 1번째
s1 = (s+addSec)%60  #최종 초
m1 = (s+addSec)//60

#고려요소 2번째
m2 = (m+m1)%60 # 최종 분
h1 = (m+m1)//60

#고려요소 3번째
h2 = (h+h1)%24 # 최종 시각

print(h2,m2,s1)  #출력