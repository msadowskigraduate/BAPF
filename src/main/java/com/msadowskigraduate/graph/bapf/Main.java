package com.msadowskigraduate.graph.bapf;

import com.msadowskigraduate.graph.bapf.articulationpoint.ArticulationPointFinder;
import com.msadowskigraduate.graph.bapf.bridge.BridgeService;
import com.msadowskigraduate.graph.bapf.domain.Edge;
import com.msadowskigraduate.graph.bapf.domain.Graph;
import com.msadowskigraduate.graph.bapf.domain.Vertex;
import com.msadowskigraduate.graph.bapf.exception.InvalidFileException;
import com.msadowskigraduate.graph.bapf.shared.ConsoleUtils;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import static com.msadowskigraduate.graph.bapf.shared.ConsoleUtils.*;

/**
 * Created by sadowsm3 on 03.06.2018
 */
public class Main {
    public static void main(String[] args) {
        BridgeService bridgeService = new BridgeService();
        ArticulationPointFinder articulationPointFinder = new ArticulationPointFinder();
        printHello();
        boolean exit = false;
        while (!exit) {
            printModes();
            try {
                Integer mode = printChooseOperatingMode();
                switch (mode) {
                    case 1:
                        Set<Edge> edges = bridgeService.getBridge(readGraphFromFile());
                        ConsoleUtils.printBridges(edges);
                        break;
                    case 2:
                        Set<Vertex> articulationPoints = articulationPointFinder.findarticulationPoints(readGraphFromFile());
                        printArticulationPoints(articulationPoints);
                        break;
                    case 3:
                        printHelp();
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Exiting...");
                        break;
                    default:
                        printError("Not recognized command!");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFileException e) {
                printError(e.getMessage());
            }
        }
    }

    private static Graph readGraphFromFile() throws IOException, InvalidFileException {
        File file = printChoosePath();
        return FileReader.readFile(file);
    }
}
