package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "0.1",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    private boolean helpRequested = false;

    @Option(names = { "-V", "--version" }, versionHelp = true, description = "Print version information and exit.")
    private boolean versionRequest = false;

    @Option(names = { "-f", "--format" }, defaultValue = "stylish", description = "output format: plain/stylish/json")
    private String format;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    String firstURI;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    String secondURI;

    @Override
    public Integer call() {
        try {
            System.out.println(Differ.generate(firstURI, secondURI, format));
        } catch (Exception e) {
            System.out.println("Something was wrong. But it's ok.");
        }
        return 0;
    }

    public static void main(String[] args) {
        App ap = new App();
        int exitCode = new CommandLine(ap).execute(args);
    }
}
