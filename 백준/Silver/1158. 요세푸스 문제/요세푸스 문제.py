from collections import deque
import sys
input = sys.stdin.readline

n,k = map(int,input().split())

# k 2k 
que = deque([i for i in range(1, n+1)])
result = []

while len(que)>0:
    for _ in range(k-1):
        # 왼쪽 것을 빼서 오른쪽으로 붙임(회전)
        que.append(que.popleft())
    result.append(str(que.popleft()))



print("<",end="")
print(", ".join(result),end="")
print(">",end="")