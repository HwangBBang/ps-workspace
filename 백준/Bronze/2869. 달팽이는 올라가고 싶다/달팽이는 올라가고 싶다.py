import math
a,b,v = map(int, input().split())

# 시간 초과
# //////////////////////////////////////
# # 바닥으로 부터 거리
# d = 0
# cnt = 0
# while True:
#     cnt += 1
#     # 낮에 a 만큼 올라감
#     d += a
#     # 도달 했다면? 반복문을 멈추고 일 수를 출력
#     if v <= d:
#         print(cnt)
#         break
#     # 밤에 b 만큼 올라감
#     d -= b
# //////////////////////////////////////

# v // a - b =  일 수
# 도달 하기 전까지 일수는 나누기로 계산..

exV = v - a
day =  math.ceil(exV / (a-b))

print(day + 1)