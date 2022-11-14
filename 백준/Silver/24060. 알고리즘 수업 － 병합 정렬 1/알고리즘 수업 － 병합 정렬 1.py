
def mergeSort(A, first, last):
    global k
    global cnt
    # 정렬할 엘리먼트가 없거나 엘리먼트가 하나인 경우
    if first >= last:
        return  # 아무것도 하지않음

    mid = first+(last-first)//2

    # 리스트 A 를 반으로 나눠 재귀적으로 접근 : T(n) = 2*T(n/2)
    # 재귀적으로 나누면 엘리먼트 한개씩으로 남음
    mergeSort(A, first, mid)
    mergeSort(A, mid+1, last)

    #리스트의 왼쪽 / first부터 시작하는 leftIdx
    #리스트의 오른쪽 / mid+1부터 시작하는 rightIdx
    leftIdx, rightIdx = first, mid+1
    sortedA = []

    #leftIdx,rightIdx 둘 중 하나가 끝까지 가기전까지 반복
    while leftIdx <= mid and rightIdx <= last:
        #양쪽 배열을 비교하며 병합+정렬
        if A[leftIdx] <= A[rightIdx]:
            sortedA.append(A[leftIdx])
            cnt += 1
            if cnt == k:
                print(A[leftIdx])
            leftIdx += 1
        else:
            sortedA.append(A[rightIdx])
            cnt += 1
            if cnt == k:
                print(A[rightIdx])
            rightIdx += 1

    # leftIdx나 rightIdx 둘 중 끝까지 도달하지 못한 index를 끝까지 가게함
    # 이때 이미 재귀적으로 진행하여서 나머지 idx 의 key 값들은 정렬된 상태임
    for i in range(leftIdx, mid+1):
        sortedA.append(A[i])
        
        cnt += 1
        if cnt == k:
            print(A[i])
            
    for i in range(rightIdx, last+1):
        sortedA.append(A[i])
        
        cnt += 1
        if cnt == k:
            print(A[i])
            
    # 분할된 리스트들 시작Idx를 고려해서
    for j in range(first, last+1):
        A[j] = sortedA[j-first]
        


global k
global cnt
n,k = map(int, input().split())
A = list(map(int, input().split()))
cnt = 0
mergeSort(A, 0, n-1)

if k > cnt :
    print(-1)
