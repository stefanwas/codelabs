package com.stefan.handythings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Executes a command line program and prints out its output
 */
public class ExecuteUnixCommand {

    public static void main(String[] args) {
        String cmd = "pwd";

        try {
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = stdInput.readLine()) != null) {
                System.out.println("Line=" + line);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
