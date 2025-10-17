#A와B의 수학과 영어의 점수를 입력받아 누가더 높은지 비교하는 프로그래믈 작성해주세요
mathScoreA,englishSocoreA=map(int,input().split(" "))
mathScoreB,englishSocoreB=map(int,input().split(" "))
#A가 B보다 수학의 점수도 크고 영어의 점수도 크면 1 그렇지 않으면 0을 출력합니다.
if mathScoreA>mathScoreB:
    if englishSocoreA>englishSocoreB:
        print(1)
    else:
        print(0)
else:
    print(0)
    