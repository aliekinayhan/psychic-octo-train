# Recursion

## Definition

A function that calls itself to solve smaller instances of the same problem.

**Core Idea:** Break a problem into smaller subproblems until it becomes simple enough to solve directly.

---

## Structure

Every recursive function has two required parts:

**1. Base Case** — stopping condition
```java
if (n == 0) return;
```

**2. Recursive Case** — function calls itself with smaller input
```java
return f(n - 1); // return is critical
```

---

## Example: Factorial

```java
int factorial(int n) {
    if (n == 1) return 1;        // base case
    return n * factorial(n - 1); // recursive case
}
```

**Execution flow:**
```
factorial(3)
→ 3 * factorial(2)
→ 2 * factorial(1)
→ 1 (base case reached)
→ returns back up
```

---

## Two Phases of Recursion

**Phase 1 — Going down (stack fills up):**
```
f(1) → f(2) → f(3) → base case
```

**Phase 2 — Coming back (stack unwinds):**
```
return → return → return → final result
```

This is called **bubbling up** — values travel back up through the call stack.

---

## Rules of Recursion

1. Find the base case — when does it stop?
2. Write the recursive case — how does it call itself?
3. Always return — without return, result is lost and never bubbles up

---

## Call Stack

Each function call is added to the call stack. When the base case is reached, stack unwinds — each call returns its result back up.

---

## Stack Overflow

If there is no base case, the function calls itself forever. Each call is added to the stack but nothing is removed. Stack fills up and the program crashes.

```
Maximum call stack size exceeded
```

**Key insight:** Recursion uses memory because every call is stored in the call stack. Deep recursion = high memory usage.

---

## Recursion vs Iteration

| | Recursion | Iteration |
|---|---|---|
| Uses | Call stack | Loops |
| Best for | Trees, graphs, divide & conquer | Simple repeated tasks |
| Memory | Higher | Lower |
| Readability | Cleaner for complex problems | Better for simple loops |

---

## When to Use

- Problem can be divided into similar subproblems
- Structure is hierarchical (tree, graph)
- Code becomes simpler than iteration

## When NOT to Use

- Memory is constrained
- Simple loops would be cleaner
- Team is not familiar with recursion

---

## Where Recursion is Used

- Tree traversal (DFS)
- Graph traversal (BFS, DFS)
- Divide & Conquer (Merge Sort, Quick Sort)
- Backtracking
- Dynamic Programming

---

## Golden Rule

Every recursive call must get closer to the base case. Without a base case, recursion never stops.

---

## Example: Reverse String

```java
String reverse(String str) {
    if (str.length() <= 1) return str;                 // base case
    return reverse(str.substring(1)) + str.charAt(0); // recursive case
}
```

### How it works

Each call takes the first character and waits. The `+` operator cannot complete until both sides are ready:

- **Right side:** `str.charAt(0)` → known immediately, held in call stack
- **Left side:** `reverse(str.substring(1))` → must be calculated first

Java holds the right side in memory until the recursive call returns, then combines them.

### Step by step — `reverse("hello")`

**Going down:**
```
reverse("hello") → holds 'h', sends "ello"
reverse("ello")  → holds 'e', sends "llo"
reverse("llo")   → holds 'l', sends "lo"
reverse("lo")    → holds 'l', sends "o"
reverse("o")     → base case, returns "o"
```

**Coming back up:**
```
reverse("lo")    → receives "o",    returns "o"    + 'l' = "ol"
reverse("llo")   → receives "ol",   returns "ol"   + 'l' = "oll"
reverse("ello")  → receives "oll",  returns "oll"  + 'e' = "olle"
reverse("hello") → receives "olle", returns "olle" + 'h' = "olleh" ✅
```

**Key insight:** The `+` operator holds the right side (`str.charAt(0)`) in the call stack until the left side (recursive call) returns its result. This is how recursion "remembers" values while going deeper.

---

## Interview Answer

> "Recursion is when a function calls itself to solve smaller subproblems. It requires a base case to stop execution. Without one, the call stack fills up and causes a stack overflow. Results must be returned at each step so they bubble back up through the call stack. Recursion is commonly used in tree traversal, graph search, and divide-and-conquer algorithms."

**Key one-liner:**
> "Recursion works by reaching a base case and then returning values back up the call stack."
