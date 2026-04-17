# Arrays

## Static Arrays

Arrays store elements in **contiguous memory locations** (side by side in RAM). They are one of the simplest data structures and have **no extra overhead** (no pointers or metadata).

### Memory Model

- The computer knows the **starting address** of the array
- Each element is accessed using its **index**

### Why Lookup is O(1)

- Direct address calculation
- No iteration required
- Independent of array size

### Cache Locality

Arrays are cache-friendly because elements are stored contiguously in memory. When the CPU loads one element, nearby elements are also loaded into cache — making iteration significantly faster compared to linked structures.

### Operations & Complexity

| Operation | Time Complexity | Explanation |
|---|---|---|
| Lookup (by index) | O(1) | Direct memory access |
| Push (add to end) | O(1)* | Only if space is available |
| Pop (remove from end) | O(1) | No shifting needed |
| Insert at beginning | O(n) | All elements shift right |
| Insert/Delete middle | O(n) | Elements must shift |

### Important Notes

- Static arrays have a **fixed size**
- Size must be defined at creation
- If full:
  - Cannot add new elements
  - Must create a new larger array and copy elements

### In Java

```java
int[] arr = {1, 2, 3, 4, 5};

arr[0];        // lookup — O(1)
arr.length;    // size
```

### When to Use

- Fast index-based access is required
- Data size is known in advance
- Iteration-heavy operations
- Index-based lookup tables

### When NOT to Use

- Frequent insertions/deletions at the beginning or middle
- Data size is unknown or changes frequently

### Interview Answer

> "Arrays store elements in contiguous memory, allowing O(1) access via direct address calculation. However, insertion and deletion require shifting elements, making them O(n). Arrays are cache-friendly because contiguous memory allows the CPU to load nearby elements into cache, speeding up iteration."

---

## Dynamic Arrays (ArrayList)

A dynamic array is an array that **automatically resizes** when it runs out of space.

### How Resizing Works

1. Array becomes full
2. A new memory block is allocated (usually **2x capacity**)
3. Existing elements are copied
4. New element is added

### Operations & Complexity

| Operation | Time Complexity | Explanation |
|---|---|---|
| Lookup (by index) | O(1) | Same as static array |
| Push (add to end) | O(1)* | Most of the time |
| Push (resize case) | O(n) | Copying elements |
| Pop (remove from end) | O(1) | No shifting |
| Insert/Delete middle | O(n) | Elements shift |

### Amortized O(1)

- Most pushes → O(1)
- Occasionally → O(n) (during resize)
- Average over time → behaves like O(1)

**Reason:**

- Capacity grows exponentially: `4 → 8 → 16 → 32`
- Resizing is infrequent

### Hidden Cost

After resizing, a dynamic array may have unused capacity. For example, after growing from 4 to 8 slots and only adding 1 element, 3 slots are wasted. This is a space trade-off for avoiding frequent resizing.

### Key Advantages

- No need to define size in advance
- Flexible and easy to use
- Cache-friendly (contiguous memory improves iteration speed)

### In Java

```java
ArrayList<Integer> list = new ArrayList<>();

list.add(10);        // push — O(1) amortized
list.add(0, 99);     // insert at index — O(n)
list.get(0);         // lookup — O(1)
list.set(0, 99);     // update — O(1)
list.remove(0);      // remove by index — O(n)
list.size();         // size
list.contains(10);   // search — O(n)
```

### When to Use

- Data size is unknown
- Frequent additions at the end
- General-purpose usage

### When NOT to Use

- Frequent insertions/deletions at the beginning
- Memory is very constrained (unused capacity after resize)

### Interview Answer

> "Dynamic arrays resize by allocating a larger contiguous block (usually doubling capacity) and copying elements. Therefore, push is amortized O(1), since resizing happens infrequently. After resizing, unused capacity exists as a space trade-off."

---

## Static vs Dynamic Arrays

| Feature | Static Array | Dynamic Array |
|---|---|---|
| Size | Fixed | Resizable |
| Memory Allocation | Manual | Automatic |
| Resize | Not supported | Supported |
| Push | Only if space exists | Amortized O(1) |
| Performance | Very fast | Slight overhead on resize |
| Memory Efficiency | High | Slight extra unused capacity |
| Usage | Low-level (C/C++) | High-level (Java, Python, JS) |
