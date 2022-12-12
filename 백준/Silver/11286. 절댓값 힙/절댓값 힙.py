import sys ,heapq
input = sys.stdin.readline

heap = []

n = int(input())

for _ in range(n):
    k = int(input())
    
    if k != 0: # k 가 0 이 아닐때 
        if k < 0: # k 가 음수라면
            heapq.heappush(heap,(abs(k),-1))
            
        else: # k 가 양수라면
            heapq.heappush(heap,(k,1))
            
    else: # 0 이라면? 
        if len(heap) == 0: # 비어있다면 
            print(0)
        else: # 비어있지않다면?
            if heap[0][1] == 1:
                print(heapq.heappop(heap)[0])
            else:
                print(-1*(heapq.heappop(heap)[0]))
    