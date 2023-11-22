def solution(arr, delete_list):
    answer = []
    
    for d in delete_list:
        if d in arr:
            arr.remove(d)
    return arr