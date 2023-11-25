def solution(alp, cop, problems):
    max_alp = max(max(p[0] for p in problems), alp)
    max_cop = max(max(p[1] for p in problems), cop)

    dp = [[float('inf')] * (max_cop + 1) for _ in range(max_alp + 1)]
    dp[alp][cop] = 0

    for i in range(alp, max_alp + 1):
        for j in range(cop, max_cop + 1):
            if i < max_alp:
                dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + 1)
            if j < max_cop:
                dp[i][j + 1] = min(dp[i][j + 1], dp[i][j] + 1)

            for alp_req, cop_req, alp_rwd, cop_rwd, cost in problems:
                if i >= alp_req and j >= cop_req:
                    next_alp = min(max_alp, i + alp_rwd)
                    next_cop = min(max_cop, j + cop_rwd)
                    dp[next_alp][next_cop] = min(dp[next_alp][next_cop], dp[i][j] + cost)

    return dp[max_alp][max_cop]


# def solution(alp, cop, problems):
#     answer = 0
#     max_alp = 0
#     max_cop = 0
#     for problem in problems:
#         if max_alp < problem[0]:
#             max_alp = problem[0]
#         if max_cop < problem[1]:
#             max_cop = problem[1]
#     # problems.append([0, 0, 1, 0, 1])
#     # problems.append([0, 0, 0, 1, 1])

#     lack_alp = max_alp - alp
#     lack_cop = max_cop - cop

#     arr = [[0]*(lack_cop+1) for _ in range(lack_alp+1)]
#     for i in range(1, lack_alp):
#         for j in range(1, lack_cop):
#             arr[i+1][j] = min(arr[i][j], arr[i+1][j])
#             arr[i][j+1] = min(arr[i][j], arr[i][j+1])
#             for problem in problems:
#                 if problem[0] <= i and problem[1] <= j:
#                     n_alp = min(max_alp, i+problem[2])
#                     n_cop = min(max_cop, j+problem[3])
#                     arr[n_alp][n_cop] = min(
#                         arr[n_alp][n_cop], arr[i][j]+problem[-1])

#     return arr[-1][-1]


# # 알고력 alp 과 코딩력 cop 를 늘리기위해서는
# # 공부하기 +=1 (1시간), 문제 풀기 += x  (y 시간)
# # 모든 문제를 즉, 요구되는 alp ,cop 의 최대 값 까지 도달하기위해서
# # 최소 몇시간이 걸리는지?
# # problem 은
# # [요구 alp, 요구 cop , 증가 alp, 증가 cop ,시간 ]
# # 정렬 ,
# # 기준은 모든 문제 중 요구 alp 의 최대 , 요구 cop 의 최대를 구한다.
# # 최대값 - 현재 능력치 = 부족한 능력치
# # 부족한 능력치가 >= 0 일때 까지의 시간을 구해야해.
# # [10, 15, 2, 1, 2]
# # [20, 20, 3, 3, 4]
# # [0, 0, 1, 0, 1]
# # [0, 0, 0, 1, 1]