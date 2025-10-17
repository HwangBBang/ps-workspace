def findNum(n1):
    for idx, el in enumerate(nums):
        if el == n1:
            return idx
    return 0


n, q = map(int, input().split())  # 원소가 주어지는지 개수를 알려주는n,질의의 개수를 알리는q
nums = list(map(int, input().split()))  # n개의 원소를 받는 배열num

for _ in range(q):
    task = list(map(int, input().split()))
    a = task[1]

    if task[0] == 1:  # a번쨰 원소출력
        ans = nums[a-1]
        print(ans)

    elif task[0] == 2:  # a가 몇번째
        ans = findNum(a)
        print(ans+1)

    elif task[0] == 3:
        b = task[2]

        for i in range(a-1, b):
            print(nums[i], end=" ")