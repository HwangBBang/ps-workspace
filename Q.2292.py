# 중앙 방 인덳스 1부터 시작해서 탐색을함 

N = int(input())
way = 0
while True:
    if (N>=1+6*(way-1))and (N<1+6*way):
        print(way)
        break
    else:
        way+=1
