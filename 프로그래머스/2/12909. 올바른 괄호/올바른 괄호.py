from collections import deque


def solution(s):

    s = list(s)
    deq = deque()

    deq.append(s.pop())
    for _ in range(len(s)):
        deq.append(s.pop())
        if deq[0] == ')' and deq[-1] == '(':
            deq.pop()
            deq.popleft()

    # 아무것도 남아 있지않다면 즉 빈 큐라면 True
    if len(deq) == 0:
        # print(deq)
        return True
    else:
        # print(deq)
        return False