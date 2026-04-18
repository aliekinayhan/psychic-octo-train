# Graphs

## Definition

A graph is a data structure made of **nodes (vertices)** connected by **edges**. Used to model relationships between things.

---

## Key Terms

- **Node / Vertex** → an item in the graph
- **Edge** → a connection between two nodes

---

## Types of Graphs

**Directed vs Undirected:**

| | Directed | Undirected |
|---|---|---|
| Edge direction | One way | Both ways |
| Example | Twitter (follow) | Facebook (friend) |

**Weighted vs Unweighted:**

| | Weighted | Unweighted |
|---|---|---|
| Edge has value | Yes (distance, cost) | No |
| Example | Google Maps | Friend network |

**Cyclic vs Acyclic:**

| | Cyclic | Acyclic |
|---|---|---|
| Can return to start | Yes | No |
| Example | Road network | Family tree |

**DAG (Directed Acyclic Graph):**
- Directed + no cycles
- Common in blockchain, dependency systems

---

## Relationship to Other Structures

- Linked List → a type of Tree
- Tree → a type of Graph
- Graph is the most general structure

---

## Graph Representations

**Edge List:**
```java
int[][] graph = {{0,2}, {2,3}, {2,1}, {1,3}};
// Just stores which nodes are connected
```

**Adjacent List (preferred):**
```java
// Stores which nodes are connected with which nodes
Map<Integer, List<Integer>> graph = new HashMap<>();
graph.put(0, Arrays.asList(2));
graph.put(2, Arrays.asList(0, 3, 1));
graph.put(3, Arrays.asList(2, 1));
graph.put(1, Arrays.asList(2, 3));
```

**Adjacent Matrix:**
```
    0  1  2  3
0 [ 0, 0, 1, 0 ]
1 [ 0, 0, 1, 1 ]
2 [ 1, 1, 0, 1 ]
3 [ 0, 1, 1, 0 ]
// matrix[i][j] = 1 means i and j are connected
```

---

## Representation Comparison

| | Adjacent List | Adjacent Matrix |
|---|---|---|
| Memory | O(V + E) | O(V²) |
| Check connection | O(E) | O(1) |
| List neighbors | O(neighbors) | O(V) |
| Best for | Sparse graphs | Dense graphs |

**Use Adjacent List in most cases.**

---

## V and E in Graph Complexity

- **V** = number of Vertices (nodes)
- **E** = number of Edges (connections)

**Example:** 4 nodes, 4 edges

- Adjacent List → O(V + E) = O(4 + 4) = O(8) memory
- Adjacent Matrix → O(V²) = O(4²) = O(16) memory

As node count grows, matrix memory explodes. That's why the Adjacent List is preferred in most cases.

---

## When to Use

- Data has relationships between elements
- Need to find paths or connections (shortest path, reachability)
- Need to model networks (social, road, web)
- Hierarchy with multiple parents (unlike trees which have one parent per node)

## When NOT to Use

- Simple sequential or indexed data → use array
- Key-value lookup → use HashMap
- Sorted data → use TreeMap

---

## Real World Use Cases

- Google Maps → shortest path (weighted, directed)
- Facebook → friend suggestions (undirected)
- Twitter → follower network (directed)
- Amazon → recommendation engine
- LinkedIn → degree of connection

**In production:** Neo4j is a popular graph database. You rarely implement your own graph from scratch.

---

## Interview Answer

> "A graph is a set of nodes connected by edges. It can be directed or undirected, weighted or unweighted, cyclic or acyclic. Graphs are used to model relationships — Google Maps uses weighted directed graphs for shortest path, Facebook uses undirected graphs for friend networks. In code, graphs are typically represented as adjacency lists using a HashMap."
