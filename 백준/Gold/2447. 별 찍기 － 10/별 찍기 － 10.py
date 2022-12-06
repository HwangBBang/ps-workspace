import math
n = int(input())

# n : 3 의 거듭제곱

# on  on  on
# on  off on
# on  on  on

# n =3^k 일 때 다음 처럼 찍힌다.

# 3^(k-1)  3^(k-1)  3^(k-1)
# 3^(k-1)    off    3^(k-1)
# 3^(k-1)  3^(k-1)  3^(k-1)

# 00 01 02
# 10    12
# 20 21 22

# 00 01 02 03 04 05 06
# 10    12 13    15 16
# 20 21 22 23 24 25 26
# 30 31 32          36
# 40    42          36
# 50 51 52          56
# 60 61 62 63 64 65 66

star = ["***", "* *", "***"]

def makeStar(n):
    # 기본세트
    if n == 3:
        return star
    
    # 최종완성본을 저장할 리스트
    result = []
    
    # k 번째 일떄 k-1 의번째 세트를 xStar 초기화
    xStar = makeStar(n//3)
    
    # 크게 볼 때 0 행 
    for sub in xStar:
        # 3번 불러옴
        result.append(sub*3)
    
    # 크게 볼 때 1 행
    for sub in xStar:
        result.append(sub + " "* (n//3)   +sub)
    # on of on
    # ononon offoffoff ononon
    
    # 크게 볼 때 2 행
    for sub in xStar:
        # 3번 불러옴
        result.append(sub*3)
    return result


print("\n".join(makeStar(n)))