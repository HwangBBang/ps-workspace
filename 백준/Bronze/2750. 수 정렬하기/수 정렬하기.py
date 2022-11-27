n = int(input())

A = [0 for _ in range(n)]
for i in range(n):
	A[i] = int(input())


def quick_after_insertion(A, low, high):
    
    def quick_sort(A, low, high):
        if high - low < 5:
            return
        # 요소 찾는 화살표 세팅,pivot 설정
        pivot = low
        findLeft, findRight = low+1, high

        while findLeft <= findRight:
            # 좌측 화살표 한칸씩 이동
            # 잘못 된 자리에 있는 elem 의 index 에서 멈춘다.
            while (findLeft <= high and A[findLeft] <= A[pivot]):
                # while 안의 2개의 조건문의 순서를 변경하면 인덱스 오류가 발생한다.
                findLeft += 1

            # 우측 화살표 한칸씩 이동
            # 잘못 된 자리에 있는 elem 의 index 에서 멈춘다.
            while (findRight > low) and A[pivot] <= A[findRight]:
                # while 안의 2개의 조건문의 순서를 변경하면 인덱스 오류가 발생한다.
                findRight -= 1

    # 잘못된 자리에 있는 elem 들을 바꿔준다.
            if findLeft <= findRight:
                A[findLeft], A[findRight] = A[findRight], A[findLeft]

    # 엇갈렸다면(findLeft > findRight) 작은 데이터와 피벗을 교체
        A[pivot], A[findRight] = A[findRight], A[pivot]
        

    # 위 처럼 quickSort를 1회 수행시 S,M,L 형태로 변경됨
        # 좌측(S) 정렬
        quick_sort(A, low, findRight-1)
        # 우측(L) 정렬
        quick_sort(A, findRight+1, high)

    # 대부분이 정렬된 A
    quick_sort(A, low, high)

    # A 전체에 대한 insertionSort
    #1 to n-1 까지
    for currentIdx in range(1, len(A)):

        currentValue = A[currentIdx]
        # 이전 인덱스 = 현재인덱스 왼쪽 (바로 왼쪽부터 시작함)
        prevIdx = currentIdx-1

        # 이전인덱스 0보다 크면서 현재값이 이전값 보다 작다면 즉, 정렬 되지않았다면
        while prevIdx >= 0 and currentValue < A[prevIdx]:
            #현재값을 이전 값으로 바꿔줌
            A[prevIdx + 1] = A[prevIdx]
            
            #왼쪽으로 이동
            prevIdx -= 1
            
        #이전값을 현재값으로 바꿔줌
        A[prevIdx + 1] = currentValue
    #insertion 종료
#quick_after_insertion()종료

quick_after_insertion(A,0,n-1)

for i in range(n):
	print(A[i],end="\n")
