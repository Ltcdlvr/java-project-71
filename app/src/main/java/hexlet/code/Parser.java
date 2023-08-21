package hexlet.code;

//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
//import org.apache.commons.io.FilenameUtils;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Map;
//import java.util.Set;

public class Parser {
//    public static Map<String, Object> parseFile(String fileURI) throws Exception {
//
//        Set<String> extensions = Set.of("yaml", "yml", "json");
//        String fileExtension = FilenameUtils.getExtension(fileURI);
//        if (!extensions.contains(fileExtension)) {
//            throw new Exception("Wrong extension of file '" + fileURI + "', available - " + extensions);
//        }
//
//        Path absoluteFilePath = Paths.get(fileURI).toAbsolutePath().normalize();
//        if (!Files.exists(absoluteFilePath)) {
//            throw new Exception("File '" + absoluteFilePath + "' does not exist");
//        }
//
//        String fileContent = Files.readString(absoluteFilePath);
//        ObjectMapper objectMapper = fileExtension.equals("json") ? new ObjectMapper() : new YAMLMapper();
//        return objectMapper.readValue(fileContent, new TypeReference<Map<String, Object>>() { });
//    }
}
