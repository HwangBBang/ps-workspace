import re

def solution(user_id, banned_id):
    answer = 0
    matching = []
    
    for b_id in banned_id:
        
        # b_id 의 벨류의 * 을 . 변경
        b_id = '^'+re.sub(r'\*','.',b_id)+'$'
        # b_id 와 user_id 리스트를 매칭. 
        ex = re.compile(b_id)
        # all_tmp = [b_id]
        tmp = []
        # 매칭 되는 갯수 저장(append)
        for u_id in user_id: 
            if ex.match(u_id):
                # 매칭된 문자열을 제거 
                tmp.append(u_id)
        matching.append(tmp)
        
    # dfs
    result = set()
    dfs(0,[],matching,result)
    
    # product(matching)
    # print(matching)
    
    answer = len(result)
    # print(answer)
    return answer

def dfs(idx, path, matching, result):
    if idx == len(matching): 
        result.add(tuple(sorted(path)))
        return
    for u_id in matching[idx]:
        if u_id not in path :
            dfs(idx+1, path+[u_id],matching,result)