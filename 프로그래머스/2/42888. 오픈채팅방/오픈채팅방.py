def solution(record):
    answer = []
    # dic 형을 기록 key : uid ,value : name
    user_dic = dict()
    
    for user in record: 
        user = user.split(" ")
        if user[0] == 'Enter':
            # dic 에  정보 추가하기 
            user_dic[user[1]] = user[2]
    
        elif user[0] == 'Change':
            user_dic[user[1]] = user[2]
    
    # 최종 기록
    for user in record: 
        user = user.split(" ")
        if user[0] == 'Enter':
            answer.append(f'{user_dic[user[1]]}님이 들어왔습니다.')
        elif user[0] == 'Leave':
            answer.append(f'{user_dic[user[1]]}님이 나갔습니다.')
    
    return answer