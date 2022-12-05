import sys
input = sys.stdin.readline


n = int(input())
time = [0 for _ in range(n)]
startTime = [0]*n
endTime = [0]*n

for i in range(n):
    time[i] = list(map(int,input().split()))
    

time.sort(key =lambda x :(x[1],x[0]))
for i in range(0,n):
    startTime[i] = time[i][0]
    endTime[i] = time[i][1]
    
L = [0]
k = 0

for j in range(1,n):
    if startTime[j] >= endTime[k]:
        L.append(j)
        k = j

print(len(L))