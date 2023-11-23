
def solution(arr):
    answer = []
    
    answer.append(arr[0])
    for i,e in enumerate(arr):
        if i == 0:continue
        if arr[i-1] == e:continue
        else: answer.append(e)
            
    return answer