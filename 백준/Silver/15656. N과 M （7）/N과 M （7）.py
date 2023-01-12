n, m = map(int,input().split())

nBox = list(map(int,input().split()))
nBox.sort()

stack = []

def backTrack(start):
    
    if len(stack) == m:
        for elem in stack:
            print(elem,end=" ")
        print()
            
        return

    for elem in nBox:
        
        stack.append(elem)
        
        backTrack(elem)
        
        stack.pop()
    
        
backTrack(1)