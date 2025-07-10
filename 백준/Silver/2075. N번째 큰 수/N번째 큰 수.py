
import heapq


n = int(input())

heap = []
for _ in range(n):
    line = list(map(int, input().split()))
    for num in line:
        if len(heap) < n:
            heapq.heappush(heap, num)
        elif heap[0] < num:
            heapq.heapreplace(heap, num)
        else:
            continue

print(heap[0])
