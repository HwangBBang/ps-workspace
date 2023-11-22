from collections import Counter, defaultdict


def solution(phone_book):
    answer = True
    d = defaultdict(int)
    for idx, i in enumerate(phone_book):
        d[i] += idx



    for p in phone_book:
        a = ''
        for i in p:
            a += i
            if a in d and a != p:
                return False
    return answer