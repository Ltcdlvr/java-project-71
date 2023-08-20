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
            System.out.println(Differ.generate(firstURI, secondURI, Formatter.getFormatter(format)));
        } catch (Exception e) {
            System.out.println("Something was wrong. But it's ok.");
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println("Hello World");
        App ap = new App();
//        int exitCode = new CommandLine(ap).execute("-f=dskmwe", "aa", "bb");
//        System.exit(exitCode);
//        int exitCode = new CommandLine(ap).execute("./src/test/resources/1.json",
//                "/Users/mka/hexlet/java/java-project-71/src/test/resources/2.json");
//        int exitCode = new CommandLine(ap).execute("./src/test/resources/1.yaml",
//                "/Users/mka/hexlet/java/java-project-71/src/test/resources/2.yaml");
        int exitCode = new CommandLine(ap).execute("-f=json",
                "./src/test/resources/file1.yml",
                "/Users/mka/hexlet/java/java-project-71/src/test/resources/file2.yml");
    }
}
