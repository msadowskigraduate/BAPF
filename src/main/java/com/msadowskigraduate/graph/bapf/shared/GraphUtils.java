package com.msadowskigraduate.graph.bapf.shared;

import com.msadowskigraduate.graph.bapf.domain.Edge;
import com.msadowskigraduate.graph.bapf.domain.Graph;
import com.msadowskigraduate.graph.bapf.domain.Vertex;

/**
 * Created by sadowsm3 on 03.06.2018
 */
public class GraphUtils {
    public static void checkIfEdgeExistsAndAddIfDoesnt(Graph graph, long id1, long id2) {
        Vertex vertex1 = checkIfVertexExistsAndAddIfDoesnt(graph, id1);
        Vertex vertex2 = checkIfVertexExistsAndAddIfDoesnt(graph, id2);
        Edge edge = new Edge(vertex1, vertex2);
        graph.getEdgeList().add(edge);
        vertex1.addAdjecencyVertex(edge, vertex2);
        vertex2.addAdjecencyVertex(edge, vertex1);
    }

    public static Vertex checkIfVertexExistsAndAddIfDoesnt(Graph graph, long vertexId) {
        Vertex vertex;
        if (graph.getVertexList().containsKey(vertexId)) {
            vertex = graph.getVertexList().get(vertexId);
        } else {
            vertex = new Vertex(vertexId);
            graph.getVertexList().put(vertexId, vertex);
        }
        return vertex;
    }
}
