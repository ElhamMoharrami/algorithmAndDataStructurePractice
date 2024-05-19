package com.practice.algorithmanddatastructure.implementDataStructures.graph;

import java.util.*;

public class Graph {
    private Map<Vertex, List<Vertex>> adjVertices;

    void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    void removeVertex(String label) {
        Vertex vertex = new Vertex(label);
        //Iterates over the values of the Map (i.e., the lists of adjacent vertices) using a stream.
        //For each list, removes all occurrences of the vertex with the given label using the remove method.
        adjVertices.values().stream().forEach(e -> e.remove(vertex));
        adjVertices.remove(new Vertex(label));
    }

    void addEdge(String label1, String label2) {
        Vertex vertex1 = new Vertex(label1);
        Vertex vertex2 = new Vertex(label2);
        adjVertices.get(vertex1).add(vertex2);
        adjVertices.get(vertex2).add(vertex1);
    }

    void removeEdge(String label1, String label2) {
        Vertex vertex1 = new Vertex(label1);
        Vertex vertex2 = new Vertex(label2);
        List<Vertex> vertex1AdjList = adjVertices.get(vertex1);
        List<Vertex> vertex2AdjList = adjVertices.get(vertex2);
        if (vertex1AdjList != null) {
            vertex1AdjList.remove(vertex2);
        }
        if (vertex2AdjList != null) {
            vertex2AdjList.remove(vertex2);
        }
    }

    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }

    Set<String> breadthFirstSearch(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }
}
