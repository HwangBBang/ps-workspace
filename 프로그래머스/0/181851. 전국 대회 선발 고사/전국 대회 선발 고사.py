def solution(rank, attendance):
    rankList = [i for i in range(len(rank))]
    rankAtten = list(zip(rank, attendance, rankList))

    rankAtten.sort(key=lambda x: x[0])
    rankAtten = list(filter(lambda x: x[1], rankAtten))

    answer = getValue(rankAtten[0][2], rankAtten[1][2], rankAtten[2][2])
    return answer


def getValue(a, b, c):
    return a * 10000 + b*100 + c
