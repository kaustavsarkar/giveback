package org.giveback.dscbanasthali.graph;

import org.giveback.dscbanasthali.linkedlist.LinkedList;
import org.giveback.dscbanasthali.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

public final class AdjListGraph {
    private final List<Integer> vertices;
    private final LinkedList<Integer>[] edges;
    private int vertexCount = 0;

    public AdjListGraph(int vertexCount) {
        this.vertexCount = vertexCount;
        vertices = new ArrayList<>();
        edges = new LinkedList[vertexCount];

        for (var index = 0; index < vertexCount; index++) {
            vertices.add(index);
            edges[index] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int target) {
        var sourceIndex = vertices.indexOf(source);
        var targetIndex = vertices.indexOf(target);
        var sourceNode = new ListNode<Integer>();
        var targetNode = new ListNode<Integer>();
        if (sourceIndex != -1 || targetIndex != -1) {
            sourceNode.setValue(source);
            targetNode.setValue(target);
            edges[sourceIndex].insertAtHead(sourceNode);
            edges[targetIndex].insertAtHead(targetNode);
        }
    }
}
