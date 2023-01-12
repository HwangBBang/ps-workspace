n,m = map(int,input().split())

nBox = list(map(int,input().split()))
nBox.sort()

stack = []

def backTrack(start):
    
    if len(stack) == m:
        print(*stack)
        return

    for idx in  range(start, n):
        
        if not nBox[idx] in stack:
            stack.append(nBox[idx])
            backTrack(idx+1)
            stack.pop()
        
        
backTrack(0)