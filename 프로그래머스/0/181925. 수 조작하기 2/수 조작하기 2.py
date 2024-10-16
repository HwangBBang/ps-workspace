def solution(numLog):
    answer = ''
    for idx,cur in enumerate(numLog):
        if idx == 0:continue
#       num  현재 값
#       numLog(idx-1) 이전 값
        pre = numLog[idx-1]
        dif = cur - pre
        if dif == 1: answer += "w"
        elif dif == -1: answer += "s"
        elif dif == 10: answer += "d"
        elif dif == -10: answer += "a"
        
    return answer