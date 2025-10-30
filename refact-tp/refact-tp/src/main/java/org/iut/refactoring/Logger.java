package org.iut.refactoring;

import java.util.ArrayList;

public class Logger {

    public static ArrayList<String> logs = new ArrayList<>();

    public static void printLogs() {
        System.out.println("=== LOGS ===");
        for (String log : logs) {
            System.out.println(log);
        }
    }

    public static void addLog(String log) {
        logs.add(log);
    }

}
