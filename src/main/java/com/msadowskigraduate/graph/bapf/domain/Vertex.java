package com.msadowskigraduate.graph.bapf.domain;

import java.util.LinkedList;

/**
 * Created by sadowsm3 on 03.06.2018
 */
public class Vertex {
    private Long vertexId;
    private LinkedList<Edge> edgeList;
    private LinkedList<Vertex> adjecencyList;

    public Vertex(Long vertexId) {
        edgeList = new LinkedList<>();
        adjecencyList = new LinkedList<>();
        this.vertexId = vertexId;
    }

    public void addAdjecencyVertex(Edge edge, Vertex vertex) {
        edgeList.add(edge);
        adjecencyList.add(vertex);
    }

    public Long getVertexId() {
        return vertexId;
    }

    public LinkedList<Edge> getEdgeList() {
        return edgeList;
    }

    public LinkedList<Vertex> getAdjecencyList() {
        return adjecencyList;
    }

}
