def solution(numbers):
    answer = ''
    forSort = list(map(str, numbers))
    forSort.sort(key= lambda x:x*3 ,reverse=True)
    for each in forSort:
        answer += each
        
    return str(int(answer))
