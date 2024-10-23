
def solution(a, d, included):
    resultArr = []
    for cnt, isAppend in enumerate(included):
        if isAppend:
            resultArr.append(a + d*cnt)
    
    answer = sum(resultArr)
    return answer