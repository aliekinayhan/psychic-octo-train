# Binary Search

## Definition

Requires a sorted array. Finds the middle, compares with the target, eliminates half, repeats.

---

## Time Complexity

| Case | Complexity |
|---|---|
| Best case | O(1) — target is middle element |
| Worst case | O(log n) |
| Average | O(log n) |

---

## When to Use

- Data is sorted
- Large datasets
- Frequent searches

## When NOT to Use

- Data is unsorted → use Linear Search or sort first
- Data is very small → Linear Search is simpler

---

## How It Works

Each step eliminates half the array.
- 10 elements = max 4 steps
- 1 million elements = max 20 steps

---

## Implementation

```java
public static boolean binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return true;
        if (arr[mid] > target) right = mid - 1;
        else left = mid + 1;
    }
    return false;
}
```

---

## Interview Answer

> "Binary search requires a sorted array. It finds the middle element, compares with the target, and eliminates half the array each step. Time complexity is O(log n) — much faster than linear search for large datasets."
