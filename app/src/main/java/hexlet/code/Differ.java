package hexlet.code;


import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "checksum 0.1",
        description = "Compares two configuration files and shows a difference.")
public class Differ {

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    private boolean helpRequested = false;

    @Option(names = { "-V", "--version" }, description = "Print version information and exit.")
    private boolean versionRequest = false;

    @Option(names = { "-f", "--format" }, defaultValue = "stylish", description = "output format")
    private String format;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    String filePath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    String filePath2;

    public static void generate(String filePath1, String filePath2) {
        return;
    }


}
