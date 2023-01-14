import sys
input = sys.stdin.readline



t = int(input())

for i in range (1,t+1):
    a = list(map(int,input().split()))
    delta = [0]
    
    k = a.pop(0)
    a.sort(reverse= True)
    

    for o in range(1,k):
        delta.append(a[o-1]-a[o])
        
    q = a[0]
    w = a[-1]
    
    e = max(delta)
    
    print("Class", i)
    print("Max %d, Min %d, Largest gap %d" %(q ,w ,e))
