# Linear Search

## Definition

Sequentially checks each element one by one until the target is found or the list ends.

---

## Time Complexity

| Case | Complexity |
|---|---|
| Best case | O(1) — target is first element |
| Worst case | O(n) — target is last or not in list |
| Average | O(n) |

---

## When to Use

- Data is unsorted
- Data is small
- Searching once — not worth sorting first

## When NOT to Use

- Large sorted data → use Binary Search
- Frequent searches → sort first, then Binary Search

---

## Real World

Java's built-in methods use linear search internally:
- `List.contains()`
- `List.indexOf()`
- `Arrays.asList().contains()`

---

## Implementation

```java
public static boolean linearSearch(int[] arr, int target) {
    for (int element : arr) {
        if (element == target) return true;
    }
    return false;
}
```

---

## Interview Answer

> "Linear search checks each element one by one — O(n) worst case. It works on unsorted data but is slow for large datasets. Binary search is preferred when data is sorted."
