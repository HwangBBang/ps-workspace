def solution(s):
    # s 는 튜플을 집합으로 표현..
    # 서브 집합의 크기 순으로 차집합 .
    # eval 함수 : 문자열을 파이썬 문법으로 해석
    # set 형 안에 set 는 존재할 수 없다. 
    answer = []
    s = eval(s[1:-1])

# sort함수는 list 클래스의 메서드로 list객체에서만 사용할 수 있다. 
# sorted함수는 iterable 객체(list, string, tuple, dictionary 등등...)을 파라미터로 받을 수 있는 메서드이다.
    
    # len(e) 기준으로 s 를 정렬 
    if len(s) > 1:
        s = sorted(s, key= lambda x : len(x))
    
        for i in range(len(s)):
            if len(answer) == 0:
                answer.append(s[i])    

            else:
                # print(s[i] ,s[i-1])
                answer.append(s[i] - s[i-1])

        answer = [list(e)[0] for e in answer]
    elif len(s) == 1:
        answer = [list(s)[0]]
    return answer
