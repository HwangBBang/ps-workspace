from collections import Counter


def solution(clothes):
    answer = 1
    all = Counter()
    for cloth in clothes:
        all.update({cloth[1]})

    all = all.values()

    if len(all) == 1:
        return sum(all)

    all = [e+1 for e in all]

    for i in all:
        answer *= i
    answer -= 1
    
    return answer