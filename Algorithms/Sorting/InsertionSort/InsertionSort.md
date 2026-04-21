# Insertion Sort

## Core Idea

Divide the array into sorted (left) and unsorted (right). Take one element from unsorted, shift larger elements right, insert it in the correct position.

**Key difference from Bubble/Selection Sort:** Not swapping — shifting. Element is copied to key, larger elements shift right, key is placed in the gap.

---

## How It Works

```
[5, 3, 8, 1]

i=1, key=3 → 5>3, shift 5 right → insert 3 → [3, 5, 8, 1]
i=2, key=8 → 5<8, stop          →             [3, 5, 8, 1]
i=3, key=1 → shift 8, 5, 3 right → insert 1 → [1, 3, 5, 8] ✅
```

---

## Time & Space Complexity

| | Complexity |
|---|---|
| Time | O(n²) |
| Space | O(1) |

---

## Advantage

Very fast on **nearly sorted arrays** — fewer shifts needed.

---

## Implementation

```java
for (int i = 1; i < arr.length; i++) {
    int key = arr[i];
    int j = i - 1;
    while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j]; // shift right
        j--;
    }
    arr[j + 1] = key; // insert
}
```

> `j+1` — while decrements j one too far, so correct position is j+1.

---

## Interview Answer

> "Insertion Sort takes one element at a time, shifts larger elements right, and inserts it in the correct position. It's O(n²) but efficient for nearly sorted arrays."
