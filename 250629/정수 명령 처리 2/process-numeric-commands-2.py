from collections import deque

N = int(input())
command = []
A = []

for _ in range(N):
    line = input().split()
    command.append(line[0])
    if line[0] == "push":
        A.append(int(line[1]))
    else:
        A.append(0)

queue=deque()

for i in range(N):
    com=command[i]
    if com=="push":
        queue.append(A[i])
    elif com=="pop":
        print(queue.popleft())
    elif com=="size":
        print(queue.__len__())
    elif com=="empty":
        if queue:
            print(0)
            continue
        print(1)
    elif com=="front":
        print(queue[0])