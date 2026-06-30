# Enter your code here. Read input from STDIN. Print output to STDOUTdef swap_min_max(arr):
def swap_min_max(arr):
    if not arr:
        return arr

    min_idx = arr.index(min(arr))
    max_idx = arr.index(max(arr))
    
 
    arr[min_idx], arr[max_idx] = arr[max_idx], arr[min_idx]
    
    return arr


n = int(input())
arr = list(map(int, input().split()))


result = swap_min_max(arr)
print(*(result))

