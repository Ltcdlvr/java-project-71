package hexlet.code;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
    public static String getFormat(String fileURI) {
        return FilenameUtils.getExtension(fileURI);
    }

    public static String getContent(String fileURI) throws Exception {
        Path absoluteFilePath = Paths.get(fileURI).toAbsolutePath().normalize();
        if (!Files.exists(absoluteFilePath)) {
            throw new Exception("File '" + absoluteFilePath + "' does not exist");
        }
        return Files.readString(absoluteFilePath);
    }
}
