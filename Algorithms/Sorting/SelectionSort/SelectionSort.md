# Selection Sort

## Core Idea

Instead of swapping at every comparison like Bubble Sort, find the largest element in each pass, then swap once at the end.

---

## How It Works

```
[6, 5, 2, 8, 3, 7]

Pass 1 → scan all, find largest (8) → swap with last → [6, 5, 2, 7, 3, 8]
Pass 2 → scan first 5, find largest (7) → swap with last unsorted → [6, 5, 2, 3, 7, 8]
Pass 3 → scan first 4, find largest (6) → swap → [3, 5, 2, 6, 7, 8]
...continues until sorted
```

Two sections at all times: **sorted (end)** and **unsorted (start)**.

---

## Time & Space Complexity

| | Complexity |
|---|---|
| Time | O(n²) |
| Space | O(1) |

---

## Advantage over Bubble Sort

Fewer swaps — only **one swap per pass** instead of many.

---

## Implementation

```java
for (int i = 0; i < numbers.length; i++) {
    int largestIndex = 0;
    for (int j = 0; j < numbers.length - i; j++) {
        if (numbers[j] > numbers[largestIndex]) {
            largestIndex = j;
        }
    }
    int temp = numbers[numbers.length - 1 - i];
    numbers[numbers.length - 1 - i] = numbers[largestIndex];
    numbers[largestIndex] = temp;
}
```

---

## Interview Answer

> "Selection Sort finds the largest element in each pass and swaps it once to its correct position. It's O(n²) like Bubble Sort but performs fewer swaps, making it slightly more efficient in practice."
