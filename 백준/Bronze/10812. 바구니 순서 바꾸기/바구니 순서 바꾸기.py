
n,m = map(int,input().split())
# 총 n 개의 바구니를 갖고 있고
arr = [i for i in range(1,n+1)]
# m 번을 회전 시킨다.
# 1번 회전 할 때
# begin mid end -> mid end begin 이된다.
# 슬라이싱한후 갖다 붙이면 된다.

# m번의 시행 
for _ in range(m):
    # 바구니를 1번 시행 시키기위한 피벗값을 입력받음
    begin, end, mid = map(int,input().split())
    # begin to end 만 회전시키고, 기준은 mid 이다. 
    # mid를 기준으로 인덱스 슬라이싱을 하면 된다.
    begin -= 1;end -= 1;mid -= 1
    # 배열에서 인덱스는 0 부터 카운팅하므로,, 1씩 - 해준다.
    arr[begin:end+1] = arr[mid:end+1] + arr[begin:mid]
    # 배열의 슬라이싱을 할때 범위에 유의한다. 
    
print(*arr)