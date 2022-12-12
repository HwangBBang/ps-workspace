import sys ,heapq
input = sys.stdin.readline

heap = []
n = int(input())

for _ in range(n):
    k = int(input())
    
    if k > 0: # 자연수 라면 
        heapq.heappush(heap,-1*k)
    else: # 0 이라면? 
        if len(heap) == 0: # 비어있다면 
            print(0)
        else: # 비어있지않다면?
            print(-1*(heapq.heappop(heap)))
    