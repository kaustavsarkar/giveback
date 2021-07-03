package org.giveback.dscbanasthali.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjMatrixGraph {
    private final boolean[][] adjMatrix;
    private final int vertexCount;

    public AdjMatrixGraph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjMatrix = new boolean[vertexCount][vertexCount];
    }

    private static void print(String v) {
        System.out.println(v);
    }

    private boolean isOutOfBounds(int row, int col) {
        return row < 0 && row > vertexCount && col < 0 && col > vertexCount;
    }

    public void addEdge(int vertex1, int vertex2) {
        if (isOutOfBounds(vertex1, vertex2)) {
            return;
        }
        adjMatrix[vertex1][vertex2] = true;
        adjMatrix[vertex2][vertex1] = true;
    }

    public void removeEdge(int vertex1, int vertex2) {
        if (isOutOfBounds(vertex1, vertex2)) {
            return;
        }
        adjMatrix[vertex1][vertex2] = false;
        adjMatrix[vertex2][vertex1] = false;
    }

    public boolean isEdge(int vertex1, int vertex2) {
        if (isOutOfBounds(vertex1, vertex2)) {
            return false;
        }
        return adjMatrix[vertex1][vertex2];
    }

    public void bfs() {
        AdjVertex[] vertices = new AdjVertex[vertexCount];
        Queue<Integer> q = new LinkedList<>();
        // First element.
        vertices[0].isVisited = true;
        print(vertices[0].label);
        q.offer(0);
        while(!q.isEmpty()) {
            int vertex = q.poll();
            int nextVertex;
            while((nextVertex = getUnvisitedVertex(vertex, vertices) )!= -1){
                vertices[nextVertex].isVisited = true;
                print(vertices[nextVertex].label);
                q.offer(nextVertex);
            }
        }
    }
    private int getUnvisitedVertex(int v, AdjVertex[] vertices) {
        for(var index = 0; index < vertexCount; index++) {
            if(adjMatrix[v][index] && !vertices[index].isVisited) {
                return index;
            }
        }
        return -1;
    }

    public void dfs() {
        AdjVertex[] vertices = new AdjVertex[vertexCount];
        Stack<Integer> stack = new Stack<>();

        print(vertices[0].label);
        stack.push(0);

        while(!stack.isEmpty()) {
            int vertex = stack.peek();
            int nextVertex = getUnvisitedVertex(vertex, vertices);
            if(nextVertex == -1) {
                stack.pop();
                continue;
            }

            vertices[nextVertex].isVisited = true;
            print(vertices[nextVertex].label);
            stack.push(nextVertex);
        }
    }
}

class AdjVertex {
    public String label;
    public boolean isVisited;

    public AdjVertex(String label, boolean isVisited) {
        this.label = label;
        this.isVisited = isVisited;
    }
}
