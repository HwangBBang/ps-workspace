import sys
input = sys.stdin.readline

n = int(input())


# n : 3 * (2 의 거듭제곱)

# k = 0
# (공백 2) 별 (공백 2)
# (공백 4) 별 (공백 4)
star = ["  *  ", " * * ", "*****"]


def makeStar(n):
    # 기본세트
    if n == 3:
        return star

    # 최종완성본을 저장할 리스트
    result = []

    # k 번째 일떄 k-1 의번째 세트를 xStar 초기화
    xStar = makeStar(n//2)

    # 크게 볼 때 0 행
    for sub in xStar:
        # 1번 불러옴
        result.append(" "*3*((n//3)//2) + sub + " "*3*((n//3)//2))

    # 크게 볼 때 1 행
    for sub in xStar:
        result.append(sub + " " + sub)
    
    return result


print("\n".join(makeStar(n)))
