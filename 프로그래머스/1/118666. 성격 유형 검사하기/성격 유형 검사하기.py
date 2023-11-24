from collections import defaultdict


def solution(survey, choices):
    answer = ''
    mbti = ['R', 'T', 'C', 'F', 'J', 'M', 'A', 'N']
    mbti = defaultdict(int, [(c, 0) for c in mbti])

    for s, choice in zip(survey, choices):
        if choice < 4:  # 왼쪽
            mbti[s[0]] += abs(choice-4)
        elif choice > 4:  # 오른쪽
            mbti[s[1]] += abs(choice-4)

    if mbti['R'] >= mbti['T']:
        answer += 'R'
    else:
        answer += 'T'
    if mbti['C'] >= mbti['F']:
        answer += 'C'
    else:
        answer += 'F'
    if mbti['J'] >= mbti['M']:
        answer += 'J'
    else:
        answer += 'M'
    if mbti['A'] >= mbti['N']:
        answer += 'A'
    else:
        answer += 'N'
    # print(answer)
    return answer