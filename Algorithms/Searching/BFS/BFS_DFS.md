# BFS & DFS — Traversal

## What is Traversal?

Visiting every node in a tree or graph exactly once.

**Why do we need it?**
- Apply an operation to all nodes (e.g., add a property)
- Validate a tree (e.g., check BST rules)
- Convert structure to a list
- Check connectivity in graphs

Since we visit every node: **Time Complexity = O(n)**

---

## Traversal vs Search

- Sometimes used interchangeably
- Traversal = visiting every node
- Time complexity: O(n) — must visit all nodes

---

## Two Types of Traversal

1. **BFS** — Breadth First Search
2. **DFS** — Depth First Search

Both work for Trees and Graphs.

---

## BFS (Breadth First Search)

Visits nodes level by level, left to right, from top to bottom.

### Example

```
        9
      /   \
     4     20
    / \   /  \
   1   6 15  170

BFS order: [9, 4, 20, 1, 6, 15, 170]
```

### How It Works

Uses a **Queue** (FIFO):

1. Visit node
2. Add its children to the queue
3. Repeat

### Advantages

- Finds the shortest path
- Explores closest nodes first

### Disadvantages

- Uses more memory — must store all nodes at each level

### When to Use

- Shortest path problems
- Level-based traversal
- Target is likely in upper levels of the tree

### Implementation

```java
public void bfs() {
    if (root == null) return;
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        Node current = queue.poll();
        System.out.println(current.value);
        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);
    }
}

public boolean contains(int target) {
    if (root == null) return false;
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        Node current = queue.poll();
        if (current.value == target) return true;
        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);
    }
    return false;
}
```

---

## DFS (Depth First Search)

Goes as deep as possible along one branch before backtracking.

### Example

```
DFS order: [9, 4, 1, 6, 20, 15, 170]
```

### How It Works

Uses **Recursion** or a **Stack**:

1. Go as deep as possible
2. If stuck → backtrack
3. Continue with next branch

### Advantages

- Uses less memory
- Good for exploring all paths
- Better for checking if a path exists

### Disadvantages

- Does not guarantee shortest path
- Can be slow for very deep trees

### When to Use

- Path existence problems
- Backtracking (maze, puzzles)
- Exploring all possibilities
- Target is likely in lower levels of the tree
- Memory is constrained

---

## BFS vs DFS

| Feature | BFS | DFS |
|---|---|---|
| Strategy | Level by level | Deep first |
| Data Structure | Queue | Stack / Recursion |
| Shortest Path | Yes | No |
| Memory Usage | High | Low |
| Time Complexity | O(n) | O(n) |
| Best For | Closest nodes, shortest path | Full exploration, path existence |

---

## Key Insight

Both visit every node — O(n). The difference is the **order** of traversal and **memory usage**.

**Rule of thumb:**
- Target in upper levels → BFS
- Target in lower levels → DFS
- Shortest path → BFS
- Memory constrained → DFS
- Does a path exist? → DFS

---

## Why Trees/Graphs Instead of Arrays?

- Arrays → slow insert/delete
- Hash Tables → no order
- Trees → ordered + efficient search O(log n)
- Graphs → model real-world relationships

---

## Interview Answer

> "BFS and DFS are two ways to traverse a tree or graph. BFS visits nodes level by level using a queue — it is good for finding the shortest path but uses more memory. DFS goes as deep as possible using recursion or a stack — it uses less memory and is better for checking if a path exists. Both have O(n) time complexity since every node is visited once."
