from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int,input().split())

# 입력받기
que = deque([i for i in range(1, n+1)])

mList = list(map(int,input().split()))

cnt = 0

for i in range(m):
    # 뽑을 목표와 현재가리키는 큐값이 같다?
    if mList[i] == que[0]: 
        que.popleft()
    
    else: # 왼쪽 < 오른쪽이라면 
        if que.index(mList[i]) <= len(que)//2:
            while mList[i] != que[0]:
                # 왼쪽으로 회전
                que.append(que.popleft())
                cnt+=1
            que.popleft()
        else:
            while mList[i] != que[0]:
                # 오른쪽으로 회전
                que.appendleft(que.pop())
                cnt += 1
            que.popleft()

print(cnt)