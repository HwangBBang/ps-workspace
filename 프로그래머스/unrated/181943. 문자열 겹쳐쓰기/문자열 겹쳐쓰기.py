def solution(my_string, overwrite_string, s):
    answer = ''
    m = len(my_string)
    o = len(overwrite_string)

    answer = my_string[:s] + overwrite_string + my_string[o+s:]
    # print(answer)
    return answer