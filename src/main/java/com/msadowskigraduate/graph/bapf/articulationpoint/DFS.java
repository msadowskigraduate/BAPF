package com.msadowskigraduate.graph.bapf.articulationpoint;

import com.msadowskigraduate.graph.bapf.domain.Vertex;

import java.util.Map;
import java.util.Set;

/**
 * Created by sadowsm3 on 04.06.2018
 */
class DFS {

    private int time;

    DFS(int time) {
        this.time = time;
    }

    void DFS(Set<Vertex> visitedVertices,
             Set<Vertex> articulationPoints,
             Vertex vertex,
             Map<Vertex, Integer> visitedTime,
             Map<Vertex, Integer> lowTime,
             Map<Vertex, Vertex> parentVertex) {
        visitedVertices.add(vertex);
        visitedTime.put(vertex, time);
        lowTime.put(vertex, time);
        time++;
        int childCount = 0;
        boolean isArticulationPoint = false;
        for (Vertex adjVertex : vertex.getAdjecencyList()) {
            if (adjVertex.equals(parentVertex.get(vertex))) {
                continue;
            }
            if (!visitedVertices.contains(adjVertex)) {
                parentVertex.put(adjVertex, vertex);
                childCount++;
                DFS(visitedVertices, articulationPoints, adjVertex, visitedTime, lowTime, parentVertex);
                if (visitedTime.get(vertex) <= lowTime.get(adjVertex)) {
                    isArticulationPoint = true;
                } else {
                    lowTime.compute(vertex, (currentVertex, time) ->
                            Math.min(time, lowTime.get(adjVertex))
                    );
                }
            } else {
                lowTime.compute(vertex, (currentVertex, time) ->
                        Math.min(time, visitedTime.get(adjVertex))
                );
            }
        }
        if ((parentVertex.get(vertex) == null && childCount >= 2) || parentVertex.get(vertex) != null && isArticulationPoint) {
            articulationPoints.add(vertex);
        }
    }

    void setTime(int time) {
        this.time = time;
    }
}
