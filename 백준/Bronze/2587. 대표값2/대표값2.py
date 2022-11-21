
n = 5

A = [0 for _ in range(n)]
for i in range(n):
    A[i]= int(input())

def getAverage(A):
    result = sum(A)//n
    return result

def getMidValue(A):
    # selectionSort
    def selectionSort(A):
        for i in range(n-1,-1,-1):
            m = getMax(A,i)
        # 마지막 인덱스의 벨류와 최대값의 인덱스의 벨류를 교환
            A[i], A[m] = A[m], A[i]
    # selectionSort에 필요한 getMaxIdx
    def getMax(A,lastIdx):
        max = A[0]
        idx = 0
        for i in range(1,lastIdx+1):
            if A[i]>max:
                max = A[i]
                idx = i
        return idx
    
    selectionSort(A)
    
    return A[n//2]
    # 리스트중 가장 큰값과 마지막 을 스왑
    # 마지막 값을 제외하고 위과정을 반복


print(getAverage(A))
print(getMidValue(A))
