# Arrays

## Static Arrays

Arrays store elements in contiguous memory locations (side by side in RAM). They are one of the simplest data structures and have no extra overhead (no pointers or metadata).

### Memory Model
- The computer knows the starting address of the array
- Each element is accessed using its index

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
| Update (by index) | O(1) | Direct memory write |
| Push (add to end) | O(1)* | Only if space is available |
| Pop (remove from end) | O(1) | No shifting needed |
| Insert at beginning | O(n) | All elements shift right |
| Insert/Delete middle | O(n) | Elements must shift |

*\* If the array is full, a new larger array must be created and all elements copied.*

### Important Notes
- Static arrays have a fixed size
- Size must be defined at creation
- If full: cannot add new elements; must create a new larger array and copy elements

### In Java
```java
int[] arr = {1, 2, 3, 4, 5};

arr[0];        // lookup  — O(1)
arr[0] = 99;   // update  — O(1)
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
*"Arrays store elements in contiguous memory, allowing O(1) access via direct address calculation. However, insertion and deletion require shifting elements, making them O(n). Arrays are cache-friendly because contiguous memory allows the CPU to load nearby elements into cache, speeding up iteration."*

---

## Dynamic Arrays (ArrayList)

A dynamic array is an array that automatically resizes when it runs out of space.

### How Resizing Works
1. Array becomes full
2. A new memory block is allocated (typically 1.5x–2x capacity depending on the language)
3. Existing elements are copied
4. New element is added

> **Note:** Java's `ArrayList` grows by approximately **1.5x**, not 2x. The 2x factor is a common theoretical model but varies by implementation (Python uses ~1.125x).

### Operations & Complexity

| Operation | Time Complexity | Explanation |
|---|---|---|
| Lookup (by index) | O(1) | Same as static array |
| Update (by index) | O(1) | Direct memory write |
| Push (add to end) | O(1)* | Amortized — most of the time |
| Push (resize case) | O(n) | All elements must be copied |
| Pop (remove from end) | O(1) | No shifting needed |
| Insert/Delete middle | O(n) | Elements must shift |
| Search (contains) | O(n) | Linear scan — no index to jump to |

### Amortized O(1)
- Most pushes → O(1)
- Occasionally → O(n) (during resize)
- Average over time → behaves like O(1)

**Reason:** Capacity grows exponentially (e.g. 4 → 6 → 9 → 13 in Java), so resizing is infrequent. The total copy cost spread across all pushes averages out to O(1) per push.

### Hidden Cost
After resizing, a dynamic array may have unused capacity. For example, after growing from 4 to 8 slots and only adding 1 element, 3 slots are wasted. This is a space trade-off for avoiding frequent resizing.

### In Java
```java
ArrayList<Integer> list = new ArrayList<>();

list.add(10);        // push (end)         — O(1) amortized
list.add(0, 99);     // insert at index     — O(n)
list.get(0);         // lookup              — O(1)
list.set(0, 99);     // update              — O(1)
list.remove(0);      // remove by index     — O(n)
list.size();         // size
list.contains(10);   // search (linear)     — O(n)
```

### When to Use
- Data size is unknown
- Frequent additions at the end
- General-purpose usage

### When NOT to Use
- Frequent insertions/deletions at the beginning or middle
- Memory is very constrained (unused capacity after resize)

### Interview Answer
*"Dynamic arrays resize by allocating a larger contiguous block and copying elements. In Java, ArrayList grows by ~1.5x. Push is amortized O(1) since resizing happens infrequently. After resizing, unused capacity exists as a space trade-off."*

---

## Static vs Dynamic Arrays

| Feature | Static Array | Dynamic Array |
|---|---|---|
| Size | Fixed | Resizable |
| Memory Allocation | Manual | Automatic |
| Resize | Not supported | Supported (copies all elements) |
| Push | O(1) only if space exists | O(1) amortized |
| Update | O(1) | O(1) |
| Performance | Very fast | Slight overhead on resize |
| Memory Efficiency | High | Slight extra unused capacity |
| Usage | Low-level (C/C++) | High-level (Java, Python, JS) |
