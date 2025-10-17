m,f = map(int,input().split())
# # 중간 90
# #중간 90 미만 장학금 없
# 중간 90 이상인 얘들만 기말에따라 장학금
# f >=95 ->10
# f >=90 ->5
# f < 90 ->0
if m>=90:
    if f>=95:
        res=100000
    elif f>=90:
        res=50000
    else:
        res=0
else:
    res=0
print(res)