def solution(arr):
    result = []
    for elem in arr:
        if elem >= 50 and elem % 2 == 0: result.append(elem // 2)
        elif  elem < 50 and elem % 2 == 1: result.append(elem * 2)
        else: result.append(elem)
    return result