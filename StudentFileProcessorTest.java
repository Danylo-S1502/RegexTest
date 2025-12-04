import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentFileProcessorTest {

    private Path inputFile;
    private Path outputFile;

    @BeforeEach
    void setUp() throws IOException {
        // create temporary input and output files
        inputFile = Files.createTempFile("students_input", ".txt");
        outputFile = Files.createTempFile("students_output", ".txt");

        // data for the temporary input file
        List<String> students = List.of(
                "Alice 5",
                "Bob 3",
                "Charlie 5",
                "Diana 2"
        );

        // save data from the list to the temporary input file
        Files.write(inputFile, students);
    }

    @Test
    void shouldWriteOnlyStudentsWithGradeFive() throws IOException {
        // call our method as part of the test
        StudentFileProcessor.writeStudentsWithGradeFive(inputFile, outputFile);

        // read result from the temporary output file
        List<String> actualLines = Files.readAllLines(outputFile);

        // expected lines – only students with grade 5
        List<String> expectedLines = List.of(
                "Alice 5",
                "Charlie 5"
        );

        // use assertEquals to compare expected vs actual
        assertEquals(expectedLines, actualLines);
    }
}
