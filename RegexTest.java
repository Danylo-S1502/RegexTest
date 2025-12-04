import org.testng.annotations.Test;


import java.util.regex.Pattern;
import java.util.regex.Matcher;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexTest {

    @Test
    public void testEmailValidation() {
        String regex = "^[A-Za-z0-9.+_]+@[A-Za-z0-9]+(?:\\.[A-Za-z0-9]+)*\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);

        // Valid emails
        assertTrue(isValid("test@example.com", pattern));
        assertTrue(isValid("test@stu.vistula.edu.pl", pattern));

        // Invalid emails
        assertFalse(isValid("test@examplecom", pattern)); // missing dot
        assertFalse(isValid("test@vistula.pl", pattern)); // domain invalid per requirement
    }

    private boolean isValid(String email, Pattern pattern) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
