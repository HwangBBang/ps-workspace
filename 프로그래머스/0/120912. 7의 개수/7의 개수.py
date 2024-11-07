from collections import Counter


def solution(array):
    answer = ""
    strArray = list(map(str, array))
    for elem in strArray:
        answer += elem

    return Counter(answer).setdefault('7', 0)
