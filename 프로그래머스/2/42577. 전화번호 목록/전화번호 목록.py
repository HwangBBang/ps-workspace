from collections import defaultdict


def solution(phone_book):
    answer = True
    d = defaultdict(int)
    for i in phone_book:
        d[i] += 1
    for i in phone_book:
        if i in d:
            return False
    return answer