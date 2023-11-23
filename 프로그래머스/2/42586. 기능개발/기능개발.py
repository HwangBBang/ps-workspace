import math


def solution(progresses, speeds):
    answer = []
    progresses = [100-p for p in progresses]
    compelete = [math.ceil(p/s) for p, s in zip(progresses, speeds)]

    for ci, c in enumerate(compelete):
        if len(progresses) == sum(answer):
            break
        cnt = 0
        for i in range(sum(answer), len(compelete)):
            if c >= compelete[i]:
                cnt += 1
            else:
                break
        if cnt:
            answer.append(cnt)
    # print(answer)
    return answer