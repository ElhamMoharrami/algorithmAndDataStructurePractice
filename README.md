# Data Structure and algorithms

[Tree](#Everything-about-Trees)

## Everything about Trees
+ [Tree](#tree)

+ [binary search tree](#binary-search-tree)

+ [avl tree](#avl-tree)

+ [red-black tree](#red-black-tree)

+ [trie](#trie)

+ [binary heap](#binary-heap)

## tree
A tree data structure is a collection of nodes, where each node has a value and zero or more child nodes. Think of it like a family tree!

Here's a simple example:

+ A node (or "parent") has a value (e.g., "John")

+ The node has two children (e.g., "Alice" and "Bob")

+ Each child node has its own value and can have its own children (e.g., "Alice" has a child "Charlie")

The tree data structure has some key properties:

+ Root: The top node of the tree.

+ Nodes: The individual elements in the tree, which can have values or other data.

+ Edges: The connections between nodes, which show the parent-child relationships.

+ Child: A node that has a parent node.

+ Parent: A node that has one or more child nodes.

+ Leaf node: The nodes which do not have any children,External node

+ Sibling: Children of the same parent node

+ Descendant: Any successor on the path from the leaf node to the node you want to know it's descendants.

+ Ancestor: Any predecessor node on the path From the root to the node you want to know it's ancestor.

+ Neighbor: Parent or child node of the node that you want to know it's neighbor,a node that is directly connected to another node through an edge

+ Internal node: A node with at least one child

In programming, trees are often used to:

+ Store and retrieve data efficiently

+ Perform operations on large datasets

+ Represent hierarchical relationships between data