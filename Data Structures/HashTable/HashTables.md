# Hash Tables

## Definition

A hash table is a data structure that stores data in **key–value pairs**.

- Key → used to identify the data
- Value → the actual data

---

## Difference from Arrays

**Array:**
- Uses numeric index
- Example:
  - 0 → 10
  - 1 → 20
  - 2 → 30

**Hash Table:**
- Uses keys instead of indexes
- Example: `"grapes" → 10000`

---

## How It Works

### Hashing

Hashing is a technique used to map data (keys) to specific locations in memory using a hash function. It allows fast data access.

### Hash Function

A hash function takes an input (key) and returns a fixed-size output (hash value).

**Properties of a Hash Function:**

- **Deterministic:** The same input always produces the same output
- **One-way:** It is not possible to retrieve the original input from the output
- **Fast:** The computation must be efficient
- **Avalanche effect:** A small change in input produces a completely different output

### How Hashing Works in Hash Tables

1. A key is given
2. The key is passed to a hash function
3. The hash value is converted into an index
4. The value is stored at that index in memory

### Example

```
"grapes" → hash function → 711
memory[711] = ("grapes", 10000)
```

**Key Idea:** The key is transformed into a memory address using a hash function.

---

## Time Complexity

| Operation | Average | Worst Case |
|---|---|---|
| Insert | O(1) | O(n) |
| Lookup | O(1) | O(n) |
| Delete | O(1) | O(n) |

Worst case O(n) occurs when many keys collide at the same index.

---

## Load Factor & Resizing

Load factor represents how full the hash table is.

```
load factor = number of entries / number of buckets
```

- When load factor exceeds a threshold (e.g., **0.75 in Java**) → table resizes
- Resizing = rehashing all existing keys into a larger table
- Resizing is O(n) but happens rarely → amortized O(1) overall

**Key insight:** Java's HashMap automatically resizes to maintain performance.

---

## Collision

A collision occurs when two different keys are mapped to the same index.

**Example:**
- `"apple"` → index 5
- `"grapes"` → index 5

**Problem:** A single index cannot store multiple values directly.

### Why Collisions Happen

- Limited memory space (finite number of buckets)
- Hash function is not perfect
- Multiple inputs can produce the same hash/index

### Collision Handling

**1. Separate Chaining (used in Java HashMap)**
Each index stores multiple elements using a linked list.

```
index 5 → ("apple", 10) → ("grapes", 20)
```

**2. Open Addressing**
If a collision occurs, find the next available slot.
- Linear probing
- Quadratic probing

### Impact on Performance

- Average case remains O(1)
- Worst case becomes O(n) if many elements collide in the same index

**Key Insight:** Collisions are unavoidable, but good hash functions and resizing help minimize their impact.

---

## When to Use

- Fast lookup required
- Checking for duplicates
- Counting frequency of elements
- Mapping relationships (key → value)
- Caching and database indexing

**Do NOT use when:**
- Ordering or sorting is required (hash tables are unordered)
- Range queries are needed

---

## Limitations

- **Not ordered** — no sorting or range queries
- Iteration over keys requires scanning entire table → O(n)
- Extra memory used for buckets

---

## HashMap vs HashSet

| | HashMap | HashSet |
|---|---|---|
| Stores | Key-value pairs | Keys only |
| Duplicates | No duplicate keys | No duplicates |
| Use case | Map data to values | Check existence |
| Internal | - | Backed by HashMap (dummy values) |

**Note:** HashSet is internally backed by a HashMap — values are dummy objects.

---

## In Java — HashMap

```java
HashMap<String, Integer> map = new HashMap<>();

map.put("grapes", 10000);          // insert — O(1)
map.get("grapes");                 // lookup — O(1)
map.getOrDefault("orange", 0);     // lookup with default
map.containsKey("grapes");         // check key — O(1)
map.containsValue(10000);          // check value — O(n)
map.remove("grapes");              // delete — O(1)
map.size();                        // size
map.isEmpty();                     // check if empty

// Iterate keys
for (String key : map.keySet()) { }

// Iterate values
for (int value : map.values()) { }

// Iterate key-value pairs
for (var entry : map.entrySet()) {
    entry.getKey();
    entry.getValue();
}

// Sum all values
int total = 0;
for (int value : map.values()) {
    total += value;
}
```

## In Java — HashSet

```java
HashSet<String> set = new HashSet<>();

set.add("apple");           // insert — O(1)
set.contains("apple");      // check existence — O(1)
set.remove("apple");        // delete — O(1)
set.size();                 // size
set.isEmpty();              // check if empty

// Iterate
for (String s : set) { }
```

---

## Important Concept

- In arrays, **you** control the index
- In hash tables, the **hash function** controls the index

---

## Interview Answer

> "A hash table stores key-value pairs and uses a hash function to map keys to memory indexes, enabling O(1) average insert, lookup, and delete. Collisions occur when two keys map to the same index and are handled using separate chaining with a linked list. Java's HashMap resizes when the load factor exceeds 0.75, which triggers rehashing. Worst case degrades to O(n) when many collisions occur."
