# Quick Sort

## Definition

A divide and conquer sorting algorithm that selects a pivot element and partitions the array so that elements smaller than the pivot go left and larger go right. Then recursively applies the same process to each side.

---

## How It Works

1. Pick a pivot (usually last element)
2. Move elements smaller than pivot to the left
3. Move elements larger than pivot to the right
4. Pivot is now in its correct position
5. Recursively apply to left and right sides

### Example: `[3, 7, 2, 5]` → pivot = 5

```
j=0: 3 < 5 → swap → [3, 7, 2, 5]
j=1: 7 > 5 → skip
j=2: 2 < 5 → swap → [3, 2, 7, 5]
Place pivot  →        [3, 2, 5, 7] ✅
```

Now recursively sort `[3, 2]` and `[7]`.

---

## Time & Space Complexity

| | Complexity |
|---|---|
| Time (average) | O(n log n) |
| Time (worst) | O(n²) |
| Space | O(log n) |

**Worst case** occurs when pivot is always the smallest or largest element — list never splits in half. Common with already sorted arrays.

---

## Stable Sort

Quick Sort is **not stable** — equal elements may change their original order.

---

## Implementation

```java
public static void quickSort(int[] arr, int low, int high) {
    if (low >= high) return;
    int pivotIndex = partition(arr, low, high);
    quickSort(arr, low, pivotIndex - 1);
    quickSort(arr, pivotIndex + 1, high);
}

public static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return i + 1;
}

public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

// Usage
quickSort(arr, 0, arr.length - 1);
```

---

## Why low and high?

Quick Sort works **in-place** — no new arrays created. `low` and `high` define which portion of the same array we are currently sorting. Each recursive call works on a smaller range.

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

## Interview Answer

> "Quick Sort uses divide and conquer — it picks a pivot, moves smaller elements to the left and larger to the right, then recursively sorts each side. Average time complexity is O(n log n) with O(log n) space since it sorts in-place. Worst case is O(n²) when the pivot is always the smallest or largest element. It is not stable and is generally the fastest sorting algorithm in practice."
