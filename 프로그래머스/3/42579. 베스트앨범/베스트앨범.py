from collections import Counter, defaultdict


def solution(genres, plays):
    answer = []
#    장르별로 종합.
    union = Counter()
    playlist = list()

    for ip, (g, p) in enumerate(zip(genres, plays)):
        union.update({g: p})
        playlist.append([g, p, ip])
    union = union.most_common()

    order = {i[0]: idx for idx, i in enumerate(union)}

    playlist.sort(key=lambda x: (order[x[0]], -x[1], x[2]))
    # answer = [play[2] for play in playlist] /  2번까지 조건이없다면. 이거

    group = defaultdict(list)
    for play in playlist:
        group[play[0]].append(play)

    for genre in group:
        answer.extend([s[2] for s in group[genre][:2]])
    # print(answer)
    return answer