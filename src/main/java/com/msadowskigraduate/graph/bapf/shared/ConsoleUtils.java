package com.msadowskigraduate.graph.bapf.shared;

import com.msadowskigraduate.graph.bapf.domain.Edge;
import com.msadowskigraduate.graph.bapf.domain.Vertex;
import com.msadowskigraduate.graph.bapf.exception.InvalidFileException;

import java.io.*;
import java.util.Set;

/**
 * Created by sadowsm3 on 03.06.2018
 */
public class ConsoleUtils {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String HOME;

    static {
        HOME = System.getenv("HOME");
    }

    public static void printArticulationPoints(Set<Vertex> points) {
        StringBuilder builder = new StringBuilder("");
        points.forEach(ap -> builder.append(ap.getVertexId()).append(" "));
        System.out.println(builder.toString());
        printEmptyLine();
    }

    public static void printHelp() {
        printEmptyLine();
        printLineSeparator();
        System.out.println(ANSI_WHITE + "HELP" + ANSI_RESET);
        printLineSeparator();
    }

    public static void printBridges(Set<Edge> edgeSet) {
        StringBuilder result = new StringBuilder();
        edgeSet.forEach(x -> result.append(x.toString()).append("\n"));
        System.out.println("Identified following bridges: ");
        System.out.println(result.toString());
    }

    public static void printSysCheck() {
        System.out.println("Home directory: " + HOME);
    }

    public static void printError(String msg) {
        System.out.println(ANSI_RED + msg  + ANSI_RESET);
    }

    public static void printHello() {
        printBanner();
        printLineSeparator();
        printEmptyLineInBrackets();
        printTitle();
        printEmptyLineInBrackets();
        printEmptyLineInBrackets();
        printLineSeparator();
        printSysCheck();
        printReadMe();
    }

    public static Integer printChooseOperatingMode() throws IOException {
        printLineSeparator();
        printEmptyLine();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Which mode would you like to use? \n");
        Integer i = 0;
        try{
             i = Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
        return i;
    }

    public static File printChoosePath() throws IOException, InvalidFileException {
        printLineSeparator();
        printEmptyLine();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input file path: \n");
        File file = new File(br.readLine());
        if(file.getCanonicalPath().endsWith(".txt")) {
            return file;
        }
        throw new InvalidFileException();
    }

    private static void printReadMe() {
        printEmptyLine();
        System.out.println("System allows two operating modes:");
        System.out.println("For valid file formatting look inside README.md at: ");
        printGit();
        printEmptyLine();
    }

    public static void printModes() {
        System.out.println("[1]: Finding bridges from graph described in .txt file");
        System.out.println("[2]: Finding articulation points from graph described in .txt file");
        System.out.println("[3]: Help");
        System.out.println("[4]: Exit Application");
    }

    private static void printGit() {
        System.out.println("\033[3mhttps://github.com/msadowskigraduate/BAPF\033[0m");
    }

    private static void printLineSeparator() {
        System.out.println("==============================================");
    }

    private static void printTitle() {
        System.out.println("|| "+ ANSI_YELLOW+"  Bridge and Articulation Point finder " + ANSI_RESET + "  ||");
        printEmptyLineInBrackets();
        System.out.println("||          @ Michal Sadowski S17983        ||");
    }

    private static void printEmptyLineInBrackets() {
        System.out.println("||                                          ||");
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private static void printBanner() {
        System.out.println(ANSI_CYAN +"\n" +
                " ________  ________  ________ _________   \n" +
                "|\\   __  \\|\\   __  \\|\\  _____\\\\___   ___\\ \n" +
                "\\ \\  \\|\\ /\\ \\  \\|\\  \\ \\  \\__/\\|___ \\  \\_| \n" +
                " \\ \\   __  \\ \\   __  \\ \\   __\\    \\ \\  \\  \n" +
                "  \\ \\  \\|\\  \\ \\  \\ \\  \\ \\  \\_|     \\ \\  \\ \n" +
                "   \\ \\_______\\ \\__\\ \\__\\ \\__\\       \\ \\__\\\n" +
                "    \\|_______|\\|__|\\|__|\\|__|        \\|__|\n" + ANSI_RESET);
    }

}
