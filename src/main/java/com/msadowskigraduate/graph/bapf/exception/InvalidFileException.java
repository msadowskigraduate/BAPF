package com.msadowskigraduate.graph.bapf.exception;

/**
 * Created by sadowsm3 on 03.06.2018
 */
public class InvalidFileException extends BAPFTException {
    public InvalidFileException() {
        super("Invalid file formatting! Please restart and choose different file.");
    }
}
