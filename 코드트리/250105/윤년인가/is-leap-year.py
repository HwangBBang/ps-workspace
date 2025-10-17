# 4로 나누어 떨어지는 해는 윤년 그 밖의 해는 평년
# 100으로 나누어 떨어지고 400으로 나누어 떨어지지 않는해는 평년

# 4의배수 
#      100의 배수
#           400의 배수
#               윤년
#           400의 배수 아님
#               평년
#      100의 배수 아님
#           윤년
# 4의배수 아닐 때 
#    평년



y=int(input())
if y%4==0:
    res='true'
    if y%100==0:
        if y%400==0:
            res='true'
        else:
            res="false"
    else:
        res='true'
else:
    res='false'
print(res)