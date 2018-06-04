package com.msadowskigraduate.graph.bapf.articulationpoint;

import com.msadowskigraduate.graph.bapf.domain.Graph;
import com.msadowskigraduate.graph.bapf.domain.Vertex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sadowsm3 on 04.06.2018
 */
public class ArticulationPointFinder {

    private DFS dfs;

    public ArticulationPointFinder() {
        this.dfs = new DFS(0);
    }

    public Set<Vertex> findarticulationPoints(Graph graph) {
        this.dfs.setTime(0);
        Set<Vertex> visited = new HashSet<>();
        Set<Vertex> foundPoints = new HashSet<>();
        Vertex startVertex = graph.getVerticies().iterator().next();

        Map<Vertex, Integer> visitedTime = new HashMap<>();
        Map<Vertex, Integer> lowTime = new HashMap<>();
        Map<Vertex, Vertex> parent = new HashMap<>();

        dfs.DFS(visited, foundPoints, startVertex, visitedTime, lowTime, parent);
        return foundPoints;
    }

}
