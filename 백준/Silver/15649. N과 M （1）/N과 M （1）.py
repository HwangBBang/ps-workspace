import sys
input = sys.stdin.readline

n,m = map(int,input().split())


# 모든 경우의수를 탐색
# 깊이 우선 탐생 dfs를 활용 
# 각 노드들을 맹목적으로 탐색 할 때 사용한다.
# 깊이가 달라질때 백트리킹을 사용한다. 

#     1   <for>  2   <for>   3
# 2 <for> 3  1 <for> 3   1 <for> 2


# 1 ~ n 까지 1개 선택 
# 이미 선택한 값이 아닌 경우 선택
# recursive(n+1)

# 결과 값
result = []
# 탐색했는지? 
check = [False]*(n+1)

def recursive(num):
    # 최종결과 값이라면?
    if  num == m:
        print(" ".join(map(str,result)))
        return
    
    for i in range(1,n+1):
        
        # 방문하지 않았다면?
        if check[i] == False:
            check[i] = True
            
            result.append(i)
            recursive(num+1)
            check[i] = False
            result.pop()

recursive(0)