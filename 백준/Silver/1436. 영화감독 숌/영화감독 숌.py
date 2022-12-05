n= int(input())

# 0 1 ... 8 9
# 00 01 02 ... 98 99
# 000 001 002 ... 998 999
# 0000 0001
# 666 = ()

#() 1
nums = [666]
#()-  10
# _() 10
for j in range(0, 10):
    if j > 0:
        nums.append(int(str(j) + str(666)))
    nums.append(int(str(666)+str(j)))
    
#()_ _ 100
#_()_ 100
#_ _() 100

#_ _() 100
for j in range(0, 100):
    if j > 0:
        nums.append(int(str(j) + str(666)))
        
#()_ _ 100
for j in range(0, 100):
    if j < 10:
        nums.append(int(str(666) +"0"+ str(j)))
    else:
        nums.append(int(str(666)+str(j)))

#_()_ 100
for j in range(1, 10):
    for k in range(0, 10):
        nums.append(int(str(j) + str(666)+str(k)))
        
#()_ _ _1000
#_()_ _1000
#_ _()_1000
#_ _ _()1000

#_ _ _()1000
for j in range(100, 1000):
    nums.append(int(str(j) + str(666)))
    

#()_ _ _1000
for j in range(0, 1000):
    if j<10:
        nums.append(int(str(666) + "00" + str(j)))
    elif j > 9 and j < 100:
        nums.append(int(str(666) + "0" + str(j)))
    else:
        nums.append(int(str(666) + str(j)))

#_()_ _1000
for j in range(1,10):
    for k in range(0,100):
        if k < 10:
            nums.append(int(str(j) + str(666) + "0" + str(k)))
        else:
            nums.append(int(str(j) + str(666) + str(k)))

#_ _()_1000
for j in range(10, 100):
    for k in range(0, 10):
        nums.append(int(str(j) + str(666) + str(k)))
        


#()_ _ _ _10000
#_()_ _ _ 10000
#_ _()_ _ 10000
#_ _ _()_ 10000
#_ _ _ _()10000

#_ _ _ _()10000
for j in range(1000, 10000):
    nums.append(int(str(j) + str(666)))

#_ _ _()_ 10000
for j in range(100, 1000):
    for k in range(10):
        nums.append(int(str(j) + str(666)+ str(k)))

#_ _()_ _ 10000
for j in range(10, 100):
    for k in range(0,100):
        if k < 10:
            nums.append(int(str(j) + str(666) +"0"+ str(k)))
        elif k > 9 and k < 100:
            nums.append(int(str(j) + str(666) +str(k)))


#_()_ _ _ 10000
for j in range(1, 10):
    for k in range(0, 1000):
        if k < 10:
            nums.append(int(str(j) + str(666) + "00" + str(k)))
        elif k > 9 and k < 100:
            nums.append(int(str(j) + str(666) + "0"+str(k)))
        elif k > 99 :
            nums.append(int(str(j) + str(666) + str(k)))

#()_ _ _ _10000
for k in range(0, 10000):
    if k < 10:
        nums.append(int(str(666) + "000" + str(k)))
    elif k > 9 and k < 100:
        nums.append(int(str(666) + "00"+str(k)))
    elif k > 99 and k < 1000:
        nums.append(int( str(666) +"0"+ str(k)))
    else:
        nums.append(int(str(666) + str(k)))

nums = list(set(nums))
nums.sort()

print(nums[n-1])


