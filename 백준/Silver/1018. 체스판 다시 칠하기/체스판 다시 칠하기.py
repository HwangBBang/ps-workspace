n, m = map(int, input().split())

arr = []
cnt = []
for i in range(n):
    arr.append(input())

for a in range(n-7):
    for b in range(m-7):  # 8*8로 자르기 위해, -7해준다
        w_idx = 0  # 흰색으로 시작
        b_idx = 0  # 검은색으로 시작
        for i in range(a, a+8):  # 시작지점
            for j in range(b, b+8):  # 시작지점
                if (i+j) % 2 == 0:  # 짝수인 경우
                    if arr[i][j] != 'W':  # W가 아니면, 즉 B이면
                        w_idx += 1  # W로 칠하는 갯수
                    else:  # W일 때
                        b_idx += 1  # B로 칠하는 갯수
                else:  # 홀수인 경우
                    if arr[i][j] != 'W':  # W가 아니면, 즉 B이면
                        b_idx += 1  # B로 칠하는 갯수
                    else:
                        w_idx += 1  # W로 칠하는 갯수

        cnt.append(w_idx)  # W로 시작할 때 경우의 수
        cnt.append(b_idx)  # B로 시작할 때 경우의 수
print(min(cnt))
