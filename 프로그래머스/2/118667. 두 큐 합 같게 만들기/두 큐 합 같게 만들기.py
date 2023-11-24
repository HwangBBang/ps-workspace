
from collections import deque


def solution(queue1, queue2):
    answer = 0
    queue1, queue2 = deque(queue1), deque(queue2)
    sum1, sum2, time = sum(queue1), sum(queue2), len(queue1)*4
    total = sum1 + sum2

    # if total//2 < max(max(queue1), max(queue2)) or total//2 == 1:
    #     return -1

    while not total//2 == sum1:
        if answer > time:
            return -1
        # 둘중하나 수행
        if sum1 > sum2:
            # 1번 빼서 2번 넣기
            d = queue1.popleft()
            sum1 -= d
            queue2.append(d)
            sum2 += d
        elif sum1 < sum2:
            # 2번 빼서 1번 넣기
            d = queue2.popleft()
            sum2 -= d
            queue1.append(d)
            sum1 += d
        answer += 1

    return answer

# 이진 트리
# 방법 1 vs 방법 2
# 길이 n 짜리는 2^n 개 다해봐야함.
# 300,000 n이 까지 이므로 불가함.

# 그리디
# 보장할까..?
# 확인해보자 -> 됌
# 그럼 같을 수 없는 경우는 어떤 경우 일까?
# 큐 두개를 합쳐서 토털/2 랑 같은 경우가 있는지 확인해야해.
# 그럼. 큐 두개 합친 것 중에서 토털/2 보다 큰놈이 있다면, 절대 같을 수 없네?
