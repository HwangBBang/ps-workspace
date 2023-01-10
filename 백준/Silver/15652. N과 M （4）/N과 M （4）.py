n,m = map(int,input().split())

stack = []

def backTrack(start):
    
    if len(stack) == m:
        for elem in stack: print(elem,end=" ")
        print()
        return

    for elem in range(start,n+1):
        
        stack.append(elem)
        backTrack(elem)
        stack.pop()
        
        
backTrack(1)