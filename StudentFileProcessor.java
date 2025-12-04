import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StudentFileProcessor {

    // callable method – not a program (no main method)
    public static void writeStudentsWithGradeFive(Path inputFile, Path outputFile) throws IOException {
        // regex: ".*5.*" → checks if there is a number 5 somewhere in the line
        // if you want ONLY a standalone 5 (not 15, 50, etc.), use "\\b5\\b" instead
        Pattern pattern = Pattern.compile(".*5.*");

        List<String> result = Files.lines(inputFile)
                .filter(line -> pattern.matcher(line).matches())
                .collect(Collectors.toList());

        Files.write(outputFile, result);
    }
}
