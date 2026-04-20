# Merge Sort

## Definition

A divide and conquer sorting algorithm that recursively splits an array in half, sorts each half, and merges them back together.

---

## How It Works

1. **Divide** — split array in half until each piece has one element
2. **Conquer** — single elements are already sorted (base case)
3. **Combine** — merge two sorted arrays into one sorted array

### Example: `[3, 1, 5, 2]`

**Split:**
```
[3, 1, 5, 2]
→ [3, 1] and [5, 2]
→ [3], [1], [5], [2]
```

**Merge:**
```
[3] + [1] → [1, 3]
[5] + [2] → [2, 5]
[1, 3] + [2, 5] → [1, 2, 3, 5] ✅
```

---

## Time & Space Complexity

| | Complexity |
|---|---|
| Time (all cases) | O(n log n) |
| Space | O(n) |

- **O(log n)** — number of times we split in half
- **O(n)** — comparing all elements during merge
- **O(n) space** — extra arrays needed during merge

---

## Why O(n log n) and not O(n²)?

Unlike Bubble Sort, we don't compare every element to every other element. We only compare elements within their local sorted lists during merge.

---

## Stable Sort

Merge Sort is stable — equal elements maintain their original order.

---

## Implementation

```java
public static int[] mergeSort(int[] arr) {
    if (arr.length <= 1) return arr;            // base case

    int mid = arr.length / 2;
    int[] left = Arrays.copyOfRange(arr, 0, mid);
    int[] right = Arrays.copyOfRange(arr, mid, arr.length);

    return merge(mergeSort(left), mergeSort(right)); // divide + conquer + combine
}

public static int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    int i = 0, j = 0, k = 0;

    while (i < left.length && j < right.length) {
        if (left[i] < right[j]) result[k++] = left[i++];
        else result[k++] = right[j++];
    }
    while (i < left.length) result[k++] = left[i++];
    while (j < right.length) result[k++] = right[j++];

    return result;
}
```

---

## Merge Sort vs Quick Sort

| | Merge Sort | Quick Sort |
|---|---|---|
| Time (average) | O(n log n) | O(n log n) |
| Time (worst) | O(n log n) | O(n²) |
| Space | O(n) | O(log n) |
| Stable | Yes | No |
| Best for | Guaranteed performance | In-place, faster in practice |

---

## Java's Built-in Sort

```
Arrays.sort() for primitives → Dual-Pivot Quicksort — O(n log n) average
Arrays.sort() for objects   → TimSort (Merge Sort + Insertion Sort hybrid) — O(n log n)
Collections.sort()          → TimSort — O(n log n)
```

---

## Interview Answer

> "Merge Sort uses divide and conquer — it splits the array in half recursively until single elements remain, then merges them back in sorted order. Time complexity is O(n log n) in all cases because we split log n times and compare n elements at each level. Space complexity is O(n) because extra arrays are needed during merge. It is stable, making it preferred for sorting objects."
