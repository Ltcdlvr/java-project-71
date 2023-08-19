package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Map;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "0.1",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    private boolean helpRequested = false;

    @Option(names = { "-V", "--version" }, versionHelp = true, description = "Print version information and exit.")
    private boolean versionRequest = false;

    @Option(names = { "-f", "--format" }, defaultValue = "stylish", description = "output format")
    private String format;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    String filePath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    String filePath2;

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        Path path1 = Paths.get(filePath1).toAbsolutePath().normalize();
        if (!Files.exists(path1)) {
            throw new Exception("File '" + path1 + "' does not exist");
        }
        String content1 = Files.readString(path1);

        Path path2 = Paths.get(filePath2).toAbsolutePath().normalize();
        if (!Files.exists(path2)) {
            throw new Exception("File '" + path2 + "' does not exist");
        }
        String content2 = Files.readString(path2);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> firstJson = objectMapper.readValue(content1, new TypeReference<Map<String, Object>>() { });
        Map<String, Object> secondJson = objectMapper.readValue(content2, new TypeReference<Map<String, Object>>() { });

        String res = Differ.generate(firstJson, secondJson);
        System.out.println(res.toString());


        return 0;
    }

    public static void main(String[] args) {
//        System.out.println("Hello World");
        App ap = new App();
//        int exitCode = new CommandLine(ap).execute("-f=dskmwe", "aa", "bb");
//        System.exit(exitCode);
        int exitCode = new CommandLine(ap).execute("./src/test/resources/1.json",
                "/Users/mka/hexlet/java/java-project-71/src/test/resources/2.json");
    }
}
