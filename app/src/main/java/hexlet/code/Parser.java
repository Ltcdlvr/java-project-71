package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;
import java.util.Set;

public class Parser {
    public static Map<String, Object> parseFile(String fileURI) throws Exception {

        Set<String> extensions = Set.of("yaml", "yml", "json");
        String fileExtension = FileReader.getFormat(fileURI);
        if (!extensions.contains(fileExtension)) {
            throw new Exception("Wrong extension of file '" + fileURI + "', available - " + extensions);
        }

        String fileContent = FileReader.getContent(fileURI);
        ObjectMapper objectMapper = fileExtension.equals("json") ? new ObjectMapper() : new YAMLMapper();
        return objectMapper.readValue(fileContent, new TypeReference<Map<String, Object>>() { });
    }
}
