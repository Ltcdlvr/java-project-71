package hexlet.code;

import picocli.CommandLine;


public class App {

    public static void main(String[] args) {
//        System.out.println("Hello World");
        Differ ap = new Differ();
        int exitCode = new CommandLine(ap).execute("-h");
        System.exit(exitCode);
    }
}
