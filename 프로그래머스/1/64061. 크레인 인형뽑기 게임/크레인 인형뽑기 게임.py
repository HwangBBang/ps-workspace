def solution(board, moves):
    stack = []
    answer,cnt = 0,0
    moves = [move - 1 for move in moves]
    for move in moves:
        for i in range(len(board[0])):
            if board[i][move] != 0: 
                stack.append(board[i][move]) 
                
                board[i][move] = 0
                if len(stack) > 1 and stack[-1] == stack[-2]:
                        stack.pop()
                        stack.pop()
                        cnt += 2    
                break
    answer = cnt
    return answer