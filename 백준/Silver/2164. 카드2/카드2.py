from collections import deque




n = int(input())
Deque = []
for i in range(1,n+1):
    Deque.append(i)
Deque = deque(Deque)
# 1
# 2
# 3
# ...
# n
while True:
    if len(Deque) == 1:
        print(Deque[0])
        break
    # 가장위 버리고 ~
    Deque.popleft()
    
    # 그 다음위 를 뒤로 넣고 ~
    Deque.append(Deque.popleft())
