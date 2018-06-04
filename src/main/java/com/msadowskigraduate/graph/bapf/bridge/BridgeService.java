package com.msadowskigraduate.graph.bapf.bridge;

import com.msadowskigraduate.graph.bapf.domain.Edge;
import com.msadowskigraduate.graph.bapf.domain.Graph;
import com.msadowskigraduate.graph.bapf.domain.Vertex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sadowsm3 on 03.06.2018
 */
public class BridgeService {

    private Integer time = 0;

    public Set<Edge> getBridge(Graph graph) {
        Set<Edge> result = new HashSet<>();
        Map<Vertex, Integer> discovery = new HashMap<>();
        Map<Vertex, Integer> low = new HashMap<>();
        Map<Vertex, Vertex> parent = new HashMap<>();
        Map<Vertex, Boolean> visited = new HashMap<>();

        for (Vertex vertex : graph.getVerticies()) {
            if (!visited.containsKey(vertex)) {
                BridgeUtil(vertex, result, discovery, low, parent, visited);
            }
        }
        return result;
    }

    private void BridgeUtil(Vertex vertex, Set<Edge> result, Map<Vertex, Integer> discovery,
                            Map<Vertex, Integer> low, Map<Vertex, Vertex> parent, Map<Vertex, Boolean> visited) {
        visited.put(vertex, true);
        discovery.put(vertex, time);
        low.put(vertex, time);
        time++;
        for (Vertex child : vertex.getAdjecencyList()) {
            if (!visited.containsKey(child)) {
                parent.put(child, vertex);
                BridgeUtil(child, result, discovery, low, parent, visited);

                if (discovery.get(vertex) < low.get(child)) {
                    result.add(new Edge(vertex, child));
                }
                low.put(vertex, Math.min(discovery.get(vertex), low.get(child)));
            } else {
                if (!child.equals(parent.get(vertex))) {
                    low.put(vertex, Math.min(discovery.get(vertex), low.get(child)));
                }
            }
        }
    }
}
