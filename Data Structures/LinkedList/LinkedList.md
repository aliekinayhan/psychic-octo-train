# Linked List

## Definition

A linked list is a linear data structure made of nodes, where each node points to the next node in the sequence.

---

## Node

Each node contains:

- **Value** (the data)
- **Pointer** (reference to the next node — address)

---

## Key Terms

- **Head:** the first node in the list
- **Tail:** the last node in the list
- **Null:** indicates the end of the list (no next node)

---

## How It Works

Each node stores the address of the next node, creating a chain. The list is traversed by following these pointers from the head to the tail.

---

## Memory Layout

- Nodes are **not** stored in contiguous memory
- Each node can be located anywhere in memory
- Connectivity is maintained through pointers

**Cache behavior:**
Linked lists are **not cache-friendly** because nodes are scattered in memory. This makes traversal slower than arrays in practice, even though both are O(n).

---

## Operations

### Traversal
- Start from head and move node by node
- Time complexity: O(n)

### Insertion
- Update pointers to include a new node
- Time complexity: **O(1) if the node reference is already known**
- Finding the position first takes O(n)

### Deletion
- Update pointers to remove a node
- Time complexity: **O(1) if the node reference is already known**
- Finding the node first takes O(n)

> **Important:** Insertion and deletion are O(1) only if we already have a reference to the node. Finding that node requires O(n) traversal.

### Index Access
Linked lists do not support true index access. Any index-based access requires traversal from the head — O(n).

---

## Time Complexity

| Operation | Time | Note |
|---|---|---|
| Traversal | O(n) | Must follow pointers |
| Lookup by index | O(n) | No direct access |
| Insert/Delete (with reference) | O(1) | Pointer update only |
| Insert/Delete (without reference) | O(n) | Must find position first |

---

## Advantages

- Dynamic size — no fixed memory requirement
- Efficient insertion and deletion (if reference is known)
- No need for contiguous memory

## Disadvantages

- No direct index access — requires traversal
- Slower lookup compared to arrays — O(n)
- Extra memory required for pointers
- Not cache-friendly — nodes scattered in memory

---

## When to Use

- Frequent insertions/deletions at beginning or end
- Data size is unknown or changes frequently
- When shifting elements (like in arrays) is expensive

## When NOT to Use

- Frequent random/index-based access needed
- Performance-critical iteration (arrays are faster due to cache locality)
- Memory is constrained (extra pointer overhead)

---

## Comparison with Arrays

| Feature | Array | Linked List |
|---|---|---|
| Memory | Contiguous | Scattered |
| Lookup | O(1) | O(n) |
| Insert/Delete | O(n) | O(1) with reference |
| Cache friendly | Yes | No |
| Size | Fixed / Amortized | Dynamic |

---

## In Java

```java
LinkedList<Integer> list = new LinkedList<>();

list.addFirst(10);     // add to front — O(1)
list.addLast(20);      // add to end — O(1)
list.add(1, 99);       // add at index — O(n)

list.removeFirst();    // remove from front — O(1)
list.removeLast();     // remove from end — O(1)
list.remove(1);        // remove at index — O(n)

list.getFirst();       // view first — O(1)
list.getLast();        // view last — O(1)
list.get(1);           // get by index — O(n)

list.size();           // size
list.contains(10);     // search — O(n)
```

> Java's `LinkedList` is a **doubly linked list** internally.

---

## Doubly Linked List

A doubly linked list is a linked list where each node contains references to both the **next** and **previous** node.

### Node Structure

Each node contains:
- `prev` → reference to previous node
- `value` → data
- `next` → reference to next node

```
null ← 5 ⇄ 10 ⇄ 15 → null
```

### Key Difference

- **Singly:** each node points only to the next node
- **Doubly:** each node points to both next and previous nodes

### Traversal

- Can traverse **forward** (head → tail)
- Can traverse **backward** (tail → head)

### Time Complexity

- Lookup: O(n) — in practice slightly faster (O(n/2)) since we can start from either end
- Insert/Delete: O(1) if node reference is known

---

## Singly vs Doubly Linked List

| Feature | Singly | Doubly |
|---|---|---|
| Memory per node | Less (1 pointer) | More (2 pointers) |
| Traversal | One direction only | Both directions |
| Deletion | Harder (need previous node) | Easier (direct prev reference) |
| Implementation | Simpler | More complex |
| Use case | Simple forward traversal | Bidirectional navigation |

---

## Interview Answer

> "A linked list is a chain of nodes where each node holds a value and a pointer to the next node. Lookup is O(n) because there is no index-based access — traversal starts from the head. Insertion and deletion are O(1) only if we already have a reference to the node; finding it first is O(n). Unlike arrays, linked lists are not cache-friendly because nodes are scattered in memory."
