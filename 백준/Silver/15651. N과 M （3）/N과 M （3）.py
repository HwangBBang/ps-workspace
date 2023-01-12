n,m = map(int,input().split())

stack = []

def backTrack(start):
    
    if len(stack) == m:
        for elem in stack: print(elem,end=" ")
        print()
        return

    for elem in range(1,n+1):
        # if not elem in stack:
        stack.append(elem)
        backTrack(elem+1)
        stack.pop()
        
        
backTrack(1)