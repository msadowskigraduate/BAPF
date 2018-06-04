package com.msadowskigraduate.graph.bapf.domain;

import com.msadowskigraduate.graph.bapf.shared.GraphUtils;

import java.util.*;

/**
 * Created by sadowsm3 on 02.06.2018
 */
public class Graph {
    private Integer vertices;
    private List<Edge> edgeList;
    private Map<Long, Vertex> vertexList;

    public Graph() {
        this.vertexList = new HashMap<>();
        this.edgeList = new ArrayList<>();
    }

    public Graph(Integer vertices) {
        this.vertices = vertices;
        this.vertexList = new HashMap<>();
        this.edgeList = new ArrayList<>();

    }

    public Vertex addVertex(long id) {
        if (!vertexList.containsKey(id)) {
            vertexList.put(id, new Vertex(id));
        }
        return vertexList.get(id);
    }

    public Vertex getVertexById(long id) {
        return vertexList.get(id);
    }

    public void addEdge(long id1, long id2) {
        GraphUtils.checkIfEdgeExistsAndAddIfDoesnt(this, id1, id2);
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public Map<Long, Vertex> getVertexList() {
        return vertexList;
    }

    public Collection<Vertex> getVerticies() {
        return vertexList.values();
    }
}
