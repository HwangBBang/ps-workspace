def solution(array, commands):
    answer = []
    for cmd in commands:
        start = cmd[0]-1
        end = cmd[1]
        select = cmd[2]-1
        cur = array[start: end]
        cur.sort()
        answer.append(cur[select])
        

    return answer

# 0, 1, 2, 3, 4, 5, 6
# 1, 5, 2, 6, 3, 7, 4