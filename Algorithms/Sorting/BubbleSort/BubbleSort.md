# Bubble Sort

## Definition

Compare two adjacent elements, swap if the left one is greater. Repeat until the array is sorted. Each pass moves the largest unsorted element to the end.

---

## How It Works

```
[8, 6, 9, 2, 4]
Pass 1 → compare pairs, swap if needed → largest goes to end → [6, 8, 2, 4, 9]
Pass 2 → repeat, ignore last → [6, 2, 4, 8, 9]
Pass 3 → [2, 4, 6, 8, 9] ✅
```

---

## Time & Space Complexity

| | Complexity |
|---|---|
| Time | O(n²) — two nested loops |
| Space | O(1) — swapping in place, no extra memory |

---

## Implementation

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
}
```

> `n - 1 - i` → skip already sorted elements at the end.

---

## Stable Sort

Bubble Sort is **stable** — equal elements maintain their original order.

---

## Why Not Use in Production?

O(n²) is too slow for large datasets. Used only for learning purposes.

---

## Interview Answer

> "Bubble Sort repeatedly compares adjacent elements and swaps them if they are out of order. It's O(n²) due to nested loops — simple to understand but inefficient for large data."
