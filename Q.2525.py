num1,num2,num3 = map(int,input().split())

# 총경우수 216, 같은 것있는 경우 96, 모두다를경우 120, 세가지모두 같은경우 6,두가지만 같을경우 90

if num1 == num2 and num2 == num3:
    result = 10000 + num1*1000
    print(result)
elif num1 == num2 and num2 != num3:
    result = 1000 + num1*100
    print(result)
elif num1 != num2 and num2 == num3:
    result = 1000 + num2*100
    print(result)
elif num1 == num3 and num2 != num3:
    result = 1000 + num1*100
    print(result)
elif num1 != num2 and num2 != num3:
    result = max(num1,num2,num3)*100
    print(result)