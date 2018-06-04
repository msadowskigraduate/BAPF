package com.msadowskigraduate.graph.bapf;

import com.msadowskigraduate.graph.bapf.domain.Graph;
import com.msadowskigraduate.graph.bapf.domain.Vertex;
import com.msadowskigraduate.graph.bapf.exception.InvalidFileException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sadowsm3 on 03.06.2018
 */
public class FileReader {

    public static Graph readFile(File file) throws InvalidFileException {
        try {
            List<String> stringList = Files.readAllLines(file.toPath());
            Integer noOfVertices = Integer.valueOf(stringList.get(0));
            Graph graph = new Graph();
            for(int i = 1; i <= noOfVertices; i++) {
                Vertex v = graph.addVertex(i);
                String edgeList = stringList.get(i);
                if(edgeList != null) {
                    if(!edgeList.isEmpty()) {
                        List<Integer> vertices = Arrays.stream(edgeList.split(" ")).map(Integer::valueOf).collect(Collectors.toList());
                        for(Integer integer : vertices) {
                            graph.addEdge(v.getVertexId(), integer);
                        }
                    }
                }
            }

            return graph;
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new InvalidFileException();
    }
}
