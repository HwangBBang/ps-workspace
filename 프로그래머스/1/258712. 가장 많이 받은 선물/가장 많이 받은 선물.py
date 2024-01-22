from collections import defaultdict

# 선물 기록 O
#   횟수 작 -> 큰
# 선물 기록 X
#   지수 낮 -> 높


def solution(friends, gifts):
    # 횟수
    given, received = defaultdict(int), defaultdict(int)

    exchanged = defaultdict(lambda: defaultdict(int))

    for gift in gifts:
        giver, taker = gift.split()
        given[giver] += 1
        received[taker] += 1
        exchanged[giver][taker] += 1

    # 지수
    index = {friend: (given[friend] - received[friend])
             for friend in friends}

    next = defaultdict(int)
    for f1 in friends:
        for f2 in friends:
            if f1 != f2:  # 다른 사람
                # 횟수
                if exchanged[f1][f2] > exchanged[f2][f1]:
                    next[f1] += 1

                elif exchanged[f1][f2] == exchanged[f2][f1]:
                    # 지수
                    if index[f1] == index[f2]:
                        continue
                    elif index[f1] < index[f2]:
                        next[f2] += 1

    answer = max(next.values(), default=0)
    print(answer)
    return answer


solution(
    ["muzi", "ryan", "frodo", "neo"], ["muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"])
solution(['a', "b", "c"], ["a b", "b a", "c a", "a c", "a c", "c a"])


# muzi <- frodo  선물
# ryan <- muzi  선물
# ryan <- muzi  지수
# frodo <- ryan  선물
# neo <- muzi  선물
# neo <- frodo  지수

# 다음달에 가장 선물을 많이 받는 사람은
# ryan과 neo 이고 2개의 선물을 받습니다.
# 따라서 2를 return 해야 합니다.
