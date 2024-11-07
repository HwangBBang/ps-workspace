from collections import Counter


def solution(array, n):
    hash = Counter(array)

    answer = hash.get(n)
    
    if answer == None : answer = 0
    return answer