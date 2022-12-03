from collections import deque
import sys
input = sys.stdin.readline
n = int(input())
Deq = deque()


for _ in range (n):
    command = input().split()
    if command[0] == "push_front":
        Deq.appendleft(command[1])
    if command[0] == "push_back":
        Deq.append(command[1])
        
    if command[0] == "pop_front":
        if len(Deq) == 0: print(-1)
        else: print(Deq.popleft())
    if command[0] == "pop_back":
        if len(Deq) == 0: print(-1)
        else: print(Deq.pop())
            
    if command[0] == "size": print(len(Deq))
    
    if command[0] == "empty":
        if len(Deq) == 0: print(1)
        else: print(0)
    
    if command[0] == "front":
        if len(Deq) == 0: print(-1)
        else: print(Deq[0])
        
    if command[0] == "back":
        if len(Deq) == 0: print(-1)
        else: print(Deq[-1])

# 15
# push_back 1
# push_front 2
# front
# back
# size
# empty
# pop_front
# pop_back
# pop_front
# size
# empty
# pop_back
# push_front 3
# empty
# front

# 22
# front
# back
# pop_front
# pop_back
# push_front 1
# front
# pop_back
# push_back 2
# back
# pop_front
# push_front 10
# push_front 333
# front
# back
# pop_back
# pop_back
# push_back 20
# push_back 1234
# front
# back
# pop_back
# pop_back
