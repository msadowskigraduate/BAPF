package com.msadowskigraduate.graph.bapf.domain;

/**
 * Created by sadowsm3 on 03.06.2018
 */
public class Edge {
    private Vertex v1;
    private Vertex v2;

    public Edge(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    @Override
    public String toString() {
        if(v1.getVertexId() < v2.getVertexId()) {
            return v1.getVertexId() + " " + v2.getVertexId();
        }
        return v2.getVertexId() + " " + v1.getVertexId();
    }
}
