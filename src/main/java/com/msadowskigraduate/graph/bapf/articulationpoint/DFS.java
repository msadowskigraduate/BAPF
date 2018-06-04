package com.msadowskigraduate.graph.bapf.articulationpoint;

import com.msadowskigraduate.graph.bapf.domain.Vertex;

import java.util.Map;
import java.util.Set;

/**
 * Created by sadowsm3 on 04.06.2018
 */
public class DFS {

    private int time;

    public DFS(int time) {
        this.time = time;
    }

    public void DFS(Set<Vertex> visited,
                    Set<Vertex> articulationPoints,
                    Vertex vertex,
                    Map<Vertex, Integer> visitedTime,
                    Map<Vertex, Integer> lowTime,
                    Map<Vertex, Vertex> parent) {
        visited.add(vertex);
        visitedTime.put(vertex, time);
        lowTime.put(vertex, time);
        time++;
        int childCount = 0;
        boolean isArticulationPoint = false;
        for (Vertex adj : vertex.getAdjecencyList()) {
            //if adj is same as parent then just ignore this vertex.
            if (adj.equals(parent.get(vertex))) {
                continue;
            }
            //if adj has not been visited then visit it.
            if (!visited.contains(adj)) {
                parent.put(adj, vertex);
                childCount++;
                DFS(visited, articulationPoints, adj, visitedTime, lowTime, parent);

                if (visitedTime.get(vertex) <= lowTime.get(adj)) {
                    isArticulationPoint = true;
                } else {
                    //below operation basically does lowTime[vertex] = min(lowTime[vertex], lowTime[adj]);
                    lowTime.compute(vertex, (currentVertex, time) ->
                            Math.min(time, lowTime.get(adj))
                    );
                }

            } else { //if adj is already visited see if you can get better low time.
                //below operation basically does lowTime[vertex] = min(lowTime[vertex], visitedTime[adj]);
                lowTime.compute(vertex, (currentVertex, time) ->
                        Math.min(time, visitedTime.get(adj))
                );
            }
        }

        //checks if either condition 1 or condition 2 meets). If yes then it is articulation point.
        if ((parent.get(vertex) == null && childCount >= 2) || parent.get(vertex) != null && isArticulationPoint) {
            articulationPoints.add(vertex);
        }
    }

    public void setTime(int time) {
        this.time = time;
    }
}
