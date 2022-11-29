t = int(input())


for k in range(t):
    h,w,n = map(int, input().split())

    roomNum = n//h + 1
    roomFloor = n%h
    
    if roomFloor == 0:
        roomNum -= 1
        roomFloor = h
    print(roomFloor*100+roomNum)
