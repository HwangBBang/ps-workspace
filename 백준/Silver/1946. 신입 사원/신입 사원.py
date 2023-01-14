import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    score = []
    
    cnt = 1 # 첫 번째 기준 1등은 무조건 뽑힌다.
    # 성적 
    for _ in range(n):
        score.append(tuple(map(int,input().split())))
    
    score.sort()
    
    com = score[0][1]
    for i in range(1,n):
        
        if score[i][1] < com:
            cnt += 1
            
            com = score[i][1]
        
        

    print(cnt)

